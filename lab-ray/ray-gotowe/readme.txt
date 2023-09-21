Komendy do uruchomienia na dockerze:
1. zbudowanie obrazu: docker build -t raytest .
2. uruchomienie klastra: docker-compose up
3. uruchomienie programu: python ray-ml-imdb.py

Wymaganie biblioteki lokalne:
-tensorflow
-ray[default]
-scikit-learn

Dzia�anie programu:
1. �adowany jest plik z recenzjami imdb (s�ownik to 5000 najcz�ciej wyst�puj�cych s��w)
2. Po za�adowaniu dane s� wyr�wnywane do 500 wyraz�w (wyrazy s� reprezentowane przez liczby typu int)
3. Zbiory danych s� zapisywane w rozporoszonym magazynie za pomoc� ray.put()
4. Uruchamiana jest walidacja krzy�owa dla podzia�u na 3 podzbiory (cross_validate()), przy przetwarzaniu ka�dego podzbioru tworzony jest obiekt aktora
   TrainerEvaluator i uruchamiany zdalnie
5. Nast�pnie zbierane s� i wy�wietlane metryki
6. Na ko�cu uruchamiana jest sekwencja uczenia na pe�nym zbiorze treningowym i walidacji na zbiorze testowym (ok. 3 minuty)


walidacja krzy�owa polega na tym, �e robimy r�ne konfiguracje ucz�ce z xtraina i ytraina i ka�d� konfiguracj� zlecamy
jednemu aktorowi i ka�dy aktor buduje model robi fita na 2 foldach i evaluuje na 3 foldzie
u nas TrainerEvaluator jest aktorem workerem przetwarzaj�cym jeden fold
walidacj� krzy�ow� powinni�my powt�zy� dla r�nych modeli i wybra� ten, kt�ry ma najlepsze warto�ci, a potem taki model uczy si�
na ca�ym zbiorze treningowym i testuje na zbiorze testowym, ale u nas tego nie ma bo by d�ugo trwa�o
evaluate model powinno bra� model z cross validation, mog�oby by� lokalnie, ale na rayu np. mog�oby si� ��czy� z rayem, kt�ry
ma GPU
inny scenarisuz testujemy crossvalidate 10 modeli, wybieramy 3 i ich ewaluacja mo�e by� robiona r�wnolegle