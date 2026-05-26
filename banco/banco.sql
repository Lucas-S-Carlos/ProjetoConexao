CREATE DATABASE IF NOT EXISTS cadastro_java;
USE cadastro_java;

CREATE TABLE IF NOT EXISTS cliente (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    nomeSocial VARCHAR(100),
    cpf VARCHAR(100) NOT NULL,
    dataNascimento VARCHAR(100) NOT NULL,
    afrodescendente VARCHAR(100) NOT NULL,
    escolaridadePublica VARCHAR(100) NOT NULL,
    localNascimento VARCHAR(100) NOT NULL,
    nacionalidade VARCHAR(100) NOT NULL,
    paisOrigem VARCHAR(100) NOT NULL,
    Filiacao1 VARCHAR(100) NOT NULL,
    filiacao2 VARCHAR(100) NOT NULL,
    responsavelLegal VARCHAR(100) NOT NULL,
    grauParentesco VARCHAR(100) NOT NULL,
    habilitacao VARCHAR(100) NOT NULL,
    serieModulo VARCHAR(100) NOT NULL,
    periodo VARCHAR(100) NOT NULL,
    ruaAvenida VARCHAR(100) NOT NULL,
    complemento VARCHAR(100) NOT NULL,
    apto VARCHAR(100) NOT NULL,
    bloco VARCHAR(100) NOT NULL,
    bairro VARCHAR(100) NOT NULL,
    cidade VARCHAR(100) NOT NULL,
    cep VARCHAR(100) NOT NULL,
    telefone VARCHAR(100) NOT NULL,
    celular VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL
);
