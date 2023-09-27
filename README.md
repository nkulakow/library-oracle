# Projekt **Biblioteka**

Jest to aplikacja robiona przez mój zespół w ramach przedmiotu Bazy Danych na Politechnice Warszawskiej. Jako bazę danych używaliśmy Oracle.

## Krótki opis rozwiązania

Tematem projektu jest biblioteka i czynności związane z zarządzaniem nią.

### Modele:

Schematy modelu ER i modelu relacyjnego (w formacie png) znajdują się w folderze **_/ER_**.

### DDL i DML:

Skrypt poleceń ddl znajduje się w pliku _sql/create.sql_. Skrypt ładujący dane znajduje się w pliku _sql/insert.sql_.

### PLSQL:

Obsługą funkcjonalności systemu wypożyczeń zajmują się procedury, funkcje i wyzwalacze dostępne w folderze **_/plsql_**:

- procedura **order_book** - użytkownik wyraża chęć wypożyczenia danej książki.
- procedura **borrow_book** - użytkownik może wypożyczyć książkę, jeżeli została przez niego wcześniej zamówiona.
- procedura **return_book** - użytkownik zwraca książkę do biblioteki.
- wyzwalacz **delete_order_on_borrow** - zamówienie zostaje usunięte w momencie wypożyczenia książki.
- pakiet **validate_data** - służący do sprawdzania poprawności danych dotyczących wypożyczeń i reagowania za pomocą specjalnych wyjątków.
- funkcja **calculate_penalty** - oblicza karę pieniężną w zależności od ilości dni, które wykraczają poza termin oddania wypożyczonej książki.
- trigger **check_phone_number** - sprawdza format dodanego numeru telefonu, jeśli brakuje w nim numeru kierunkowego - dodaje go do podanego numeru, jeśli numer w jakiś sposób nie zgadza się z założeniami (jest za długi/za krótki) występuje error.
- view **borrowed_ordered_together** - do aplikacji java. Wyświetla wszystkie wypożyczenia i zamówienia + posiada dodatkową kolumnę o wartości kolejno "B" dla ksiązek wypożyczonych i "O" dla książek zamówionych. 

### Testy:

Zgodnie z wymaganiami projektowymi, testy stanowią zestaw nietrywialnych zapytań do bazy danych, a także przykład wykorzystania metod zaimplementowanych w pl/sql.

### Aplikacja w Javie:

Wybrane technologie: JDBC, Maven

<ins>Wymagania systemowe</ins>

- Wersja Javy: 19

- Wersja Mavena: 3.8.1+ (najlepiej 3.8.6)

<ins>Uruchamianie z linii komend w systemie Linux/WSL</ins>

- utworzenie pliku jar: _mvn install_ lub _mvn package_

- uruchomienie pliku jar: _java -jar target/BD1_22Z_Z90-1.0-SNAPSHOT.jar_

<ins>Instrukcja obsługi</ins>

- Należy wybrać jako kto chcemy się zalogować: jako zwykły użytkownik, pracownik, czy manager. Logowanie zachodzi zgodnie z danymi znajdującymi się w tabelach (odpowiednio) USERS_LOGIN,

EMPLOYEE_LOGIN, MANAGER_LOGIN

- Przykładowe dane to zalogowania:

  - zwykły użytkownik -> login:akali password:password (uwaga - może zostać on przypadkiem usunięty przez managera i te dane nie będą działać)

  - pracownik -> login:lbudka password:password

  - manager -> login:nkulakow password:nkulakow

- Manager ma możliwość wyświetlania użytkowników, książek, dodawanie i usuwanie nowych książek/użytkowników

- Pracownik ma możliwość wyświetlania użytkowników, książek, wypożyczenia zamówionej książki i zwrócenie przyniesionej książki

- Użytkownik ma możliwość wyświetlenia książek, zamówienia książek, wyświetlenia zamówionych/wypożyczonych książek przez siebie, wyświetlenia kar za przedłużenia.

## Analiza rozwiązania

Znaczącym ułatwieniem logistycznym pod kątem obsługi bazy danych przez poszczególne metody było z pewnością wprowadzenie automatycznego generowania identyfikatorów do kolejnych wpisów w tabelach.
Dzięki temu podejściu nie nastąpiła sytuacja z niepotrzebnym wymieszaniem logiki, które z pewnością byłoby efektem złożenia odpowiedzialności za zapewnienie unikalności id po stronie pl/sql, mającego już z takowej korzystać.

Za jedno ze specyficznych projektowi ograniczeń można uznać system zamówienia-wypożyczenia książki, stawiający użytkownika przed koniecznością wykonania dwóch czynności, mogących się sprowadzić do jednej.
Jest to jednak punkt potencjalnie rozwojowy, ponieważ po niewielkich zmianach w systemie i najpewniej poszerzeniu samej bazy o dodatkowe tabele, możnaby uzyskać funkcjonalność kolejkowania użytkowników biblioteki pod kątem daty złożenia przez nich zamówienia na daną książkę. Zastąpiłoby to istniejący obecnie system wypożyczeń "kto pierwszy ten lepszy".

Analogicznym pomysłem, zapewniającym podobną funkcjonalność uporządkowanego dostępu do zamówień, mogłoby być dodanie także kolejki oczekujących na książkę, która jest obecnie wypożyczona. Pociągałoby to za soba dalszy rozwój związany z możliwymi przedłużeniami wypożyczenia i potencjalnymi ograniczeniami co do terminu zwrotu w związku ze stanem zapełnienia kolejki oczekujących.
Innym punktem, który po pewnych modyfikacjach i, ponownie, poszerzeniu bazy o nowe tabele, znacząco rozszerzyłby funkcjonalność byłoby dodanie historii wypożyczeń użytkownika, historii przedłużeń oraz potencjalnie naliczonych kar za opóźnienie w terminie zwrotu. Wymagałoby to zmiany aktualnie stosowanego podejścia do tabeli zamówień, z której obecnie istniejące wpisy są usuwane w momencie wypożyczenia przez użytkownika książki, tak aby dane z rekordu były zachowywane w odpowiednich miejscach.
