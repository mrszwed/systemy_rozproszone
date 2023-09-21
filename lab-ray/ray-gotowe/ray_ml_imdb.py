import numpy as np
from keras.datasets import imdb
from keras.models import Sequential
from keras.layers import Embedding, Conv1D, MaxPooling1D, Flatten, Dense, LSTM, Bidirectional
from sklearn.model_selection import StratifiedKFold
import keras
import ray

ray_cluster=True

if ray_cluster:
    ray.init(address='ray://localhost:10001')

    print('''This cluster consists of
        {} nodes in total
        {} CPU resources in total
    '''.format(len(ray.nodes()), ray.cluster_resources()['CPU']))
else:
    ray.init()
def load_and_preprocess_data():
    (X_train, y_train), (X_test, y_test) = imdb.load_data(num_words=5000)
    max_words = 500
    X_train = keras.utils.pad_sequences(X_train, maxlen=max_words)
    X_test = keras.utils.pad_sequences(X_test, maxlen=max_words)
    return X_train, y_train, X_test, y_test

def create_conv_model(input_dim=5000, input_length=500):
    model = Sequential()
    model.add(Embedding(input_dim=input_dim, output_dim=32, input_length=input_length))
    model.add(Conv1D(filters=32, kernel_size=3, padding='same', activation='relu'))
    model.add(MaxPooling1D(pool_size=2))
    model.add(Flatten())
    model.add(Dense(250, activation='relu'))
    model.add(Dense(1, activation='sigmoid'))
    model.compile(loss='binary_crossentropy', optimizer='adam', metrics=['accuracy'])
    return model

def create_lstm_model(input_dim=5000, input_length=500):
    model = Sequential()
    model.add(Embedding(input_dim=input_dim, output_dim=32, input_length=input_length))
    model.add(LSTM(units=32, return_sequences=True))
    model.add(LSTM(units=32))
    model.add(Dense(units=1, activation='sigmoid'))
    model.compile(loss='binary_crossentropy', optimizer='adam', metrics=['accuracy'])
    return model

@ray.remote
def process_fold(model_fn, X_train, y_train, X_val, y_val):
    model = model_fn()
    model.fit(X_train, y_train, epochs=3, batch_size=64)
    score = model.evaluate(X_val, y_val, verbose=0)
    return score[1]


@ray.remote
class TrainerEvaluator:
    def __init__(self, model_fn):
        self.model_fn=model_fn
    def execute(self, X_train, y_train, X_val, y_val):
        model = self.model_fn()
        model.fit(X_train, y_train, epochs=1, batch_size=64) #uczy model na zbiorze treningowym
        score = model.evaluate(X_val, y_val, verbose=0) #testuje model na zbiorze testowym
        return score[1] #accuracy



@ray.remote
def cross_validate(model_fn,X, y,num_folds=3):
    kfold = StratifiedKFold(n_splits=num_folds, shuffle=True, random_state=42) #klasa odpowiedzialna za podział zbioru na wskazaną liczbę podzbiorów
    #stratified powoduje zachowanie proporcji klas w podzbiorach
    scores = []
    for train, val in kfold.split(X, y):
        te = TrainerEvaluator.remote(model_fn)
        score_fold=te.execute.remote(X[train], y[train], X[val], y[val])
        scores.append(score_fold)
    return scores

@ray.remote
def evaluate_model(model_fn, X_train, y_train, X_test, y_test):
    model = model_fn()
    model.fit(X_train, y_train, epochs=3, batch_size=64)
    score = model.evaluate(X_test, y_test, verbose=0)
    return score

####

X_train, y_train, X_test, y_test=load_and_preprocess_data()

X_train=ray.put(X_train)
y_train=ray.put(y_train)
X_test=ray.put(X_test)
y_test=ray.put(y_test)

scores=cross_validate.remote(create_conv_model,X_train, y_train)
scores = [ray.get(s) for s in ray.get(scores)]
print('Cross-validation accuracy: {:.4f} +/- {:.4f}'.format(np.mean(scores), np.std(scores)))

score=evaluate_model.remote(create_conv_model, X_train, y_train, X_test, y_test)

score = ray.get(score)
print(f'Evaluation on test set  loss:{score[0]} accuracy:{score[1]}')

del X_train
del y_train
del X_test
del y_test

ray.shutdown()