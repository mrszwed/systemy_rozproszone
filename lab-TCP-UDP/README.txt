Program obejmuje dwa projekty: Server i Client.

Server:
Dla połączenia TCP tworzy wątek (ClientHandler) odpowiedzialny za komunikację z klientem. Server przechowuje zbiór wątków.
Do połączeń UDP używa jednego wątku UDPServerThread oraz zbiór klientów UDP (klasa UDPClient).
Server nie uczestniczy w komunikacji Multicast.

Client:
Client otrzymuje informacje z 4 źródeł:
-System.in, są to znaki z klawiatury, obsługiwane przez wątek funkcji Main
-socket TCP, obsługiwane przez wątek TCPClientThread
-socket UDP, obsługiwane przez wątek UDPCLientThread
-multicast, obsługiwane przez wątek MulticastClientThread

Klient i serwer komunikują się za pomocą komunikatów opakowanych w JSON. Mają one postać {"command":"", "content":"", "nick":""}
Możliwe polecenia to:
-nick - ustawienie nicka
-msg - wysłanie wiadomości
-quit - wiadomość do serwera, że użytkownik opuścił czat

Podczas odczytu danych z konsoli wpisy:
-zaczynające się od "U " - wyślij jako UDP
-zaczynające się od "M " - wyślij jako multicast
-"UMON" jako cała linia - przełącza tryb na wysyłanie wielu linii w trybie UDP(umożliwia wielu pakietów zawierających ASCII Art)
-"UMOFF" jako cała linia - wraca do trybu standardowego
-quit - opuszczenie chatu