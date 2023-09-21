Komendy do uruchomienia na dockerze:
1. zbudowanie obrazu: docker build -t raytest .
2. uruchomienie klastra: docker-compose up
3. uruchomienie programu: python ray-ml-imdb.py

Wymaganie biblioteki lokalne:
-tensorflow
-ray[default]
-scikit-learn

Dzia³anie programu:
1. £adowany jest plik z recenzjami imdb (s³ownik to 5000 najczêœciej wystêpuj¹cych s³ów)
2. Po za³adowaniu dane s¹ wyrównywane do 500 wyrazów (wyrazy s¹ reprezentowane przez liczby typu int)
3. Zbiory danych s¹ zapisywane w rozporoszonym magazynie za pomoc¹ ray.put()
4. Uruchamiana jest walidacja krzy¿owa dla podzia³u na 3 podzbiory (cross_validate()), przy przetwarzaniu ka¿dego podzbioru tworzony jest obiekt aktora
   TrainerEvaluator i uruchamiany zdalnie
5. Nastêpnie zbierane s¹ i wyœwietlane metryki
6. Na koñcu uruchamiana jest sekwencja uczenia na pe³nym zbiorze treningowym i walidacji na zbiorze testowym (ok. 3 minuty)


walidacja krzy¿owa polega na tym, ¿e robimy ró¿ne konfiguracje ucz¹ce z xtraina i ytraina i ka¿d¹ konfiguracjê zlecamy
jednemu aktorowi i ka¿dy aktor buduje model robi fita na 2 foldach i evaluuje na 3 foldzie
u nas TrainerEvaluator jest aktorem workerem przetwarzaj¹cym jeden fold
walidacjê krzy¿ow¹ powinniœmy powtózyæ dla ró¿nych modeli i wybraæ ten, który ma najlepsze wartoœci, a potem taki model uczy siê
na ca³ym zbiorze treningowym i testuje na zbiorze testowym, ale u nas tego nie ma bo by d³ugo trwa³o
evaluate model powinno braæ model z cross validation, mog³oby byæ lokalnie, ale na rayu np. mog³oby siê ³¹czyæ z rayem, który
ma GPU
inny scenarisuz testujemy crossvalidate 10 modeli, wybieramy 3 i ich ewaluacja mo¿e byæ robiona równolegle