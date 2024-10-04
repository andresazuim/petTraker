CREATE DATABASE pettracker;

CREATE TABLE usuarios (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE animais (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    especie VARCHAR(255),
    raca VARCHAR(255),
    data_nascimento DATE,
    usuario_id INTEGER REFERENCES usuarios(id) ON DELETE CASCADE
);

CREATE TABLE tratamentos (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    tipo VARCHAR(50),
    data_aplicacao DATE,
    proxima_aplicacao DATE,
    animal_id INTEGER REFERENCES animais(id) ON DELETE CASCADE
);

CREATE TABLE notificacoes (
    id SERIAL PRIMARY KEY,
    descricao VARCHAR(255),
    data_notificacao DATE NOT NULL,
    animal_id INTEGER REFERENCES animais(id) ON DELETE CASCADE
);
