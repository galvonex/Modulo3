create database viagens;
use viagens;

CREATE TABLE Pacote (
Id_pacote integer PRIMARY KEY auto_increment,
Destino VARCHAR(20),
dataIda date,
dataVolta date,
valorTransporte double,
valorHospedagem double,
valoresExtra double
);

CREATE TABLE Cliente (
Nome VARCHAR(50),
Email VARCHAR(50),
Telefone VARCHAR(20),
senha VARCHAR(15),
Id_cliente integer PRIMARY KEY auto_increment
);

CREATE TABLE Compra (
Id_cliente integer,
Id_pacote integer,
FOREIGN KEY(Id_cliente) REFERENCES Cliente (Id_cliente),
FOREIGN KEY(Id_pacote) REFERENCES Pacote (Id_pacote)
)

