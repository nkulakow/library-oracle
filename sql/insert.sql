--managers_login
insert into managers_login values('nkulakow', 'nkulakow');
insert into managers_login values('mwawrzy1', 'mwawrzy1');
insert into managers_login values('mborek', 'bmborek');
insert into managers_login values('jhapunik', 'amhhcHVuaWs=');

--managers
insert into managers values(1, 'Nel', 'Kulakowska');
insert into managers values(2, 'Marcin', 'Wawrzyniak');
insert into managers values(3, 'Marta', 'Borek');
insert into managers values(4, 'Janek', 'Hapunik');

--manager_id_to_login
insert into manager_id_to_login values(1, 'nkulakow');
insert into manager_id_to_login values(2, 'mwawrzy1');
insert into manager_id_to_login values(3, 'mborek');
insert into manager_id_to_login values(4, 'jhapunik');

--users_login
insert into users_login values('hwalczak', 'password');
insert into users_login values('awitkowski', 'password');
insert into users_login values('akali', 'password');
insert into users_login values('mkraj', 'password');
insert into users_login values('pmaciej', 'password');
insert into users_login values('pjanow', 'password');
insert into users_login values('afilo', 'password');
insert into users_login values('aking', 'password');
insert into users_login values('jkowal', 'password');
insert into users_login values('nloren', 'password');
insert into users_login values('kpomid', 'password');
insert into users_login values('dgruby', 'password');


--users
insert into users values(1, 'Hubert', 'Walczak', 'hubertwalczak@mydomain.pl', null);
insert into users values(2, 'Aleksander', 'Witkowski', 'awitkowski1@mydomain.pl', '012324777');
insert into users values(3, 'Arleta', 'Kalinowska', 'kalinowskia.arleta@mydomain.pl', null);
insert into users values(4, 'Maria', 'Krajewska', 'marysiakrajewska@mydomain.pl', null);
insert into users values(5, 'Piotr', 'Maciejewski', 'piotrmaciejewski@mydomain.pl', '+48762134562');
insert into users values(6, 'Piotr', 'Janowski', 'piotrjanowski@mydomain.pl', '+48758963214');
insert into users values(7, 'Anna', 'Filochowska', 'ana.filu@mydomain.pl', '+48789456321');
insert into users values(8, 'Andrzej', 'King', 'krolandrzej@mydomain.pl', null);
insert into users values(9, 'Juila', 'Kowalska', 'kowalska.julia@mydomain.pl', null);
insert into users values(10, 'Nancy', 'Lorentz', 'nancyloe@mydomain.pl', null);
insert into users values(11, 'Katarzyna', 'Pomidor', 'pomidorek.kasia@mydomain.pl', null);
insert into users values(12, 'Daniel', 'Gruby', 'gruby.daniel@mydomain.pl', '+48420123666');
insert into users values(13, 'Mateusz', 'Opornik', 'opornymati@mydomain.pl', null);             --without set account
insert into users values(14, 'Adam', 'Bosy', 'adam.bosya@mydomain.pl', null);                   --without set account
insert into users values(15, 'Grzegorz', 'Bednarek', 'bednarekgrzesiu.priv@mydomain.pl', null); --without set account
insert into users (name, surname, email, phone_number) values('Anna', 'Pomalska', 'anapom@mydomain.pl', null); --without set account
insert into users (name, surname, email, phone_number) values('Barbara', 'Pomalska', 'basiapom@mydomain.pl', null); --without set account


--user_id_to_login
insert into user_id_to_login values(1, 'hwalczak');
insert into user_id_to_login values(2, 'awitkowski');
insert into user_id_to_login values(3, 'akali');
insert into user_id_to_login values(4, 'mkraj');
insert into user_id_to_login values(5, 'pmaciej');
insert into user_id_to_login values(6, 'pjanow');
insert into user_id_to_login values(7, 'afilo');
insert into user_id_to_login values(8, 'aking');
insert into user_id_to_login values(9, 'jkowal');
insert into user_id_to_login values(10, 'nloren');
insert into user_id_to_login values(11, 'kpomid');
insert into user_id_to_login values(12, 'dgruby');


--departments
insert into departments values(101, 'Biblioteka Kubusia Puchatka', 'Warszawa', 1);
insert into departments values(102, 'Biblioteka Tolkiena', 'Zakopane', 2);

--emplooyees
insert into employees values (11, 'Ludwik', 'Budka', 'ludwik.budka@library.com', '+48902456132', 101);
insert into employees values (12, 'Jadwiga', 'Nowacka', 'jadwiga.nowacka@library.com', '+48765345213', 101);
insert into employees values (13, 'Beata', 'Mucha', 'beata.mucha@library.com', '+48675342122', 102);
insert into employees values (14, 'Bartosz', 'Pawlak', 'bartosz.pawlak@library.com', '+48765452987', 102);
insert into employees values (15, 'Malgorzata', 'Pawloska', 'malgorzata.pawloska@library.com', '+48789456698', 102);
insert into employees values (16, 'Kamil', 'Krzemieniowski', 'kamil.krzemieniowski@library.com', '+48741258714', 101);

--employee_login
insert into employee_login values('lbudka', 'password');
insert into employee_login values('jnowac', 'password');
insert into employee_login values('bmucha', 'password');
insert into employee_login values('bpawl', 'password');
insert into employee_login values('mpawlo', 'password');
insert into employee_login values('krzemie', 'password');

--employee_id_to_login
insert into employee_id_to_login values('lbudka', 11);
insert into employee_id_to_login values('jnowac', 12);
insert into employee_id_to_login values('bmucha', 13);
insert into employee_id_to_login values('bpawl', 14);
insert into employee_id_to_login values('mpawlo', 15);
insert into employee_id_to_login values('krzemie', 16);

--books
insert into books values(1, 'W pustyni i w puszczy', 'Henryk Sienkiewicz', null, 101);
insert into books values(2, 'Hobbit, czyli tam i z powrotem', 'J.R.R. Tolkien', 'fantasy', 101);
insert into books values(3, 'Smierc na Nilu', 'Agatha Christie', 'kryminal', 102);
insert into books values(4, 'Silmarilion', 'J.R.R. Tolkien', 'fantasy', 102);
insert into books values(5, 'Kubus Puchatek', 'A. A. Milne', null, 101);
insert into books values(6, 'It', 'Stephen King', 'horror', 101);
insert into books values(7, 'Lew, czarownica i stara szafa', 'C. S. Lewis', 'fantasy', 101);
insert into books values(8, 'Bastion', 'Stephen King', 'thriller', 101);
insert into books values(9, 'Podroz Wedrowca do Switu', 'C. S. Lewis', 'fantasy', 101);
insert into books values(10, 'Perswazje', 'Jane Austen', 'powiesc romantyczna', 101);
insert into books values(11, 'Duma i uprzedzenie', 'Jane Austen', 'powiesc romantyczna', 101);
insert into books values(12, 'Przygody Sherlocka Holmesa', 'Arthur Conan Doyle', 'powiesc kryminalna', 101);
insert into books values(13, 'All About Radiation', 'L. Ron Hubbard', 'popularnonaukowa', 101);
insert into books values(14, 'A.B.C.', 'Agatha Christie', 'powiesc kryminalna', 101);
insert into books values(15, 'Niekonczaca sie opowiesc', 'Michael Ende', 'fantasy', 101);
insert into books values(16, 'Czarnoksiê¿nik z Krainy Oz', 'L. Frank Baum', 'literatura dziecieca', 101);
insert into books values(17, 'Ostatni jednorozec', 'Peter S. Beagle', null, 101);
insert into books values(18, 'Morderstwo w Orient Expressie', 'Agatha Christie', 'powiesc kryminalna', 102);
insert into books values(19, 'Smierc na Nilu', 'Agatha Christie', 'powiesc kryminalna', 102);
insert into books values(20, 'Krótka historia czasu', 'Stephen Hawking', 'popularnonaukowa', 102);
insert into books values(21, 'Ksiaze Kaspian', 'C. S. Lewis', 'fantasy', 102);
insert into books values(22, 'Gwiezdny pyl', 'Neil Gaiman', 'fantasy', 102);
insert into books values(23, 'Piec Malych Swinek', 'Agatha Christie', 'powiesc kryminalna', 102);
insert into books values(24, 'Trzecia lokatorka', 'Agatha Christie', 'powiesc kryminalna', 102);
insert into books values(25, 'Zerwane zareczyny', 'Agatha Christie', 'powiesc kryminalna', 102);
insert into books values(26, 'PrzyjdŸ i zgin', 'Agatha Christie', 'powiesc kryminalna', 102);
insert into books values(27, 'Karaibska tajemnica', 'Agatha Christie', 'powiesc kryminalna', 102);
insert into books values(28, 'Zima w Madrycie', 'C. J. Sansom', null, 102);
insert into books values(29, 'Piêædziesi¹t twarzy Greya', 'E. L. James', null, 102);
insert into books values(30, 'The Loveday Honour', 'Kate Tremayne', 'powiesc romantyczna', 102);
insert into books values(31, 'The Unknown Ajax', 'Georgette Heyer', 'powiesc romantyczna', 102);

commit;