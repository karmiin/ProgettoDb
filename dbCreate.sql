create database negozi;
use negozi;

CREATE TABLE PuntoVendita (
    id INT PRIMARY KEY NOT NULL auto_increment,
    provincia VARCHAR(100) NOT NULL,
    citta VARCHAR(100) NOT NULL,
    via VARCHAR(100) NOT NULL,
    civico VARCHAR(10) NOT NULL,
    numeroDipendenti INT NOT NULL
);

CREATE TABLE Dipendente (
    id char(6) PRIMARY KEY NOT NULL,
    nome VARCHAR(50) NOT NULL,
    cognome VARCHAR(50) NOT NULL,
    dataDiNascita DATE NOT NULL,
    oreSettimanali INT NOT NULL,
    puntoVendita INT NOT NULL,
    FOREIGN KEY (puntoVendita) REFERENCES PuntoVendita(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Titolare (
    codiceFiscale VARCHAR(16) PRIMARY KEY NOT NULL,
    nome VARCHAR(50) NOT NULL,
    cognome VARCHAR(50) NOT NULL,
    dataDiNascita DATE NOT NULL,
    puntoVendita INT NOT NULL,
    FOREIGN KEY (puntoVendita) REFERENCES PuntoVendita(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Magazzino (
    id INT PRIMARY KEY NOT NULL auto_increment,
    provincia VARCHAR(100) NOT NULL,
    citta VARCHAR(100) NOT NULL,
    via VARCHAR(100) NOT NULL,
    civico VARCHAR(10) NOT NULL
);

CREATE TABLE Prodotto (
    codiceABarre VARCHAR(13) PRIMARY KEY NOT NULL,
    nome VARCHAR(100) NOT NULL,
    prezzo FLOAT NOT NULL
);

CREATE TABLE Rifornimento (
    puntoVendita INT NOT NULL,
    magazzino INT NOT NULL,
    PRIMARY KEY (puntoVendita, magazzino),
    FOREIGN KEY (puntoVendita) REFERENCES PuntoVendita(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (magazzino) REFERENCES Magazzino(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Vende (
    puntoVendita INT NOT NULL,
    prodotto VARCHAR(13) NOT NULL,
    quantita INT NOT NULL,
    PRIMARY KEY (puntoVendita, prodotto),
    FOREIGN KEY (puntoVendita) REFERENCES PuntoVendita(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (prodotto) REFERENCES Prodotto(codiceABarre) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Deposito (
    prodotto VARCHAR(13) NOT NULL,
    magazzino INT NOT NULL,
    quantita INT NOT NULL,
    PRIMARY KEY (prodotto, magazzino),
    FOREIGN KEY (prodotto) REFERENCES Prodotto(codiceABarre) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (magazzino) REFERENCES Magazzino(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Videogame (
    prodotto VARCHAR(13) NOT NULL PRIMARY KEY,
    piattaforma VARCHAR(50) NOT NULL,
    dataDiUscita DATE NOT NULL,
    condizione VARCHAR(50) NOT NULL,
    FOREIGN KEY (prodotto) REFERENCES Prodotto(codiceABarre) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Categoria (
    nome VARCHAR(100) NOT NULL,
    prodotto VARCHAR(13) NOT NULL,
    PRIMARY KEY (nome, prodotto),
    FOREIGN KEY (prodotto) REFERENCES Videogame(prodotto) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Console (
    prodotto VARCHAR(13) PRIMARY KEY NOT NULL,
    nome VARCHAR(100) NOT NULL,
    annoDiRilascio INT NOT NULL,
    FOREIGN KEY (prodotto) REFERENCES Prodotto(codiceABarre) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Accessorio (
    nome VARCHAR(100),
    console VARCHAR(13),
    PRIMARY KEY (nome, console),
    FOREIGN KEY (console) REFERENCES Console(prodotto) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Acquisto (
    numeroOrdine char(6) PRIMARY KEY NOT NULL,
    dataAcquisto DATE NOT NULL,
    totale float NOT NULL,
    indirizzoSpedizione VARCHAR(100),
    stato VARCHAR(50)
);

CREATE TABLE Cliente (
    codiceFiscale VARCHAR(16) PRIMARY KEY NOT NULL,
    dataDiNascita DATE NOT NULL,
    nome VARCHAR(50) NOT NULL,
    cognome VARCHAR(50) NOT NULL
);

CREATE TABLE Effettua (
    acquisto char(6) NOT NULL,
    cliente VARCHAR(16) NOT NULL,
    PRIMARY KEY (acquisto, cliente),
    FOREIGN KEY (acquisto) REFERENCES Acquisto(numeroOrdine) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (cliente) REFERENCES Cliente(codiceFiscale) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Contenuto_in (
    prodotto VARCHAR(13) NOT NULL,
    acquisto VARCHAR(6) NOT NULL,
    PRIMARY KEY (prodotto, acquisto),
    FOREIGN KEY (prodotto) REFERENCES Prodotto(codiceABarre) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (acquisto) REFERENCES Acquisto(numeroOrdine) ON DELETE CASCADE ON UPDATE CASCADE
);
