use negozi;

INSERT INTO puntovendita(via, civico, citta, provincia, numerodipendenti) VALUES 
("Via Condotti", "15", "Roma", "RO", 2), 
("Via della Spiga", "2", "Milano", "MI", 5),
("Via Garibaldi", "4", "Genova", "GE", 4),
("Via Toledo", "17", "Napoli", "NA", 2),
("Via Veneto", "41", "Roma", "RO", 3);

INSERT INTO dipendente(id, nome, cognome, dataDiNascita, oreSettimanali, puntoVendita) VALUES
(111251, "Mario", "Lavi", "1990-02-15", 2, 1),
(123123, "Alessandro", "Ferri", "2000-07-21", 15, 1),
(123321, "Davide", "Conti", "1977-02-05", 17, 1),
(321111, "Lorenzo", "De Luca", "1983-09-09", 39, 4),
(223332, "Martina", "Galli", "2001-04-16", 51, 4);

INSERT INTO titolare(codiceFiscale, nome, cognome, dataDiNascita, puntoVendita) VALUES 
("RNLFRC84E12H501X", "Fernicola", "Rinaldi", "1987-04-03", 1),
("GLLMTN92S59H501B", "Martina", "Grossi", "1992-01-22", 2),
("LMBCHR91M63H501V", "Chiara", "Lombardi", "1991-06-21", 3),
("GRCVLN93C57H501U", "Valentina", "Greco", "1991-10-02", 4),
("RCCMTT85R29H501P", "Matteo", "Ricci", "1985-11-29", 5);

INSERT INTO magazzino(via, civico, citta, provincia) VALUES 
("Via del Corso", "11", "Roma", "RO"),
("Via Veneto", "13", "Roma", "RO"),
("Via Giovanni Paolo II", "2", "Fisciano", "SA");

INSERT INTO prodotto(codiceABarre, nome, prezzo) VALUES 
("1231231231231", "Black Myth: Wukong", 59.99),
("1231231231232", "PlayStation 4", 499.99),
("1231231231233", "Nintendo Switch", 200.00),
("1231231231234", "PlayStation 2", 70.00),
("1231231231235", "Minecraft", 22.99),
("1231231231236", "Valorant", 6.99),
("1231231231237", "Rainbow six: Siege", 18.60),
("1231231231238", "Xbox One", 450.00);

INSERT INTO console(prodotto, nome, annoDiRilascio) VALUES 
("1231231231232", "PlayStation 4", 2017),
("1231231231231", "Xbox One", 2022),
("1231231231234", "PlayStation 2", 2006),
("1231231231233", "Nintendo Switch", 2021);

INSERT INTO videogame(prodotto, piattaforma, dataDiUscita, condizione) VALUES 
("1231231231231", "PC","2023-08-22", "Nuovo"),
("1231231231235", "PlayStation 4", "2015-11-02", "Usato"),
("1231231231236", "PlayStation 5", "2024-07-24", "Nuovo"),
("1231231231237", "Xbox One", "2016-10-01", "Usato");

INSERT INTO categoria(nome, prodotto) VALUES 
("Azione", "1231231231231"),
("Avventura", "1231231231231"),
("Mitologico", "1231231231231"),
("Sandbox", "1231231231235"),
("Avventura", "1231231231235");

INSERT INTO acquisto(numeroOrdine, dataAcquisto, totale, indirizzoSpedizione, stato) VALUES 
("123123", "2024-08-11", 366.00, "Via Giovanni Paolo II 13", "Consegnato"),
("111111", "2024-03-15", 40.00, null, null),
("222222", "2024-02-02", 10.50, null, null);

INSERT INTO cliente(codiceFiscale, nome, cognome, dataDiNascita) VALUES 
("MRCLCU88A10H501T", "Luca", "Marchetti", "2002-10-10"),
("RMNELS94D65H501X", "Elisa", "Romano", "1995-04-12"),
("FNTNDR82L07H501P", "Andrea", "Fontana", "1980-11-22");


INSERT INTO rifornimento(puntoVendita, magazzino) VALUES 
(1,1), (1,2), (4,1);

INSERT INTO vende(puntoVendita, prodotto, quantita) VALUES 
(1, "1231231231231", 1),
(1, "1231231231236", 3),
(1, "1231231231235", 5);

INSERT INTO deposito(prodotto, magazzino, quantita) VALUES 
("1231231231235", 2, 33),
("1231231231234", 2, 10),
("1231231231232", 1, 3),
("1231231231237", 1, 15);

INSERT INTO contenuto_in(prodotto, acquisto) VALUES 
("1231231231237", "123123"),
("1231231231237", "111111"),
("1231231231231", "222222"),
("1231231231231", "123123");

INSERT INTO effettua(acquisto, cliente) VALUES 
("123123", "MRCLCU88A10H501T"),
("111111", "RMNELS94D65H501X"),
("222222", "FNTNDR82L07H501P");


