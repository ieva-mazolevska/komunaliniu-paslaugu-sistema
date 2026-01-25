CREATE DATABASE komunalines_paslaugos;
USE komunalines_paslaugos;

CREATE TABLE bendrijos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    pavadinimas VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE paslaugos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    pavadinimas VARCHAR(100) NOT NULL UNIQUE,
    aprasymas VARCHAR(255)
);

CREATE TABLE vartotojai (
    id INT AUTO_INCREMENT PRIMARY KEY,
    vardas VARCHAR(50) NOT NULL,
    pavarde VARCHAR(50) NOT NULL,
    prisijungimo_vardas VARCHAR(50) NOT NULL UNIQUE,
    slaptazodis VARCHAR(255) NOT NULL,
    role ENUM('ADMINISTRATORIUS','VADYBININKAS','GYVENTOJAS') NOT NULL,
    bendrija_id INT,
    FOREIGN KEY (bendrija_id) REFERENCES bendrijos(id)
);

CREATE TABLE kainos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    bendrija_id INT NOT NULL,
    paslauga_id INT NOT NULL,
    kaina DECIMAL(10,2) NOT NULL,
    UNIQUE (bendrija_id, paslauga_id),
    FOREIGN KEY (bendrija_id) REFERENCES bendrijos(id),
    FOREIGN KEY (paslauga_id) REFERENCES paslaugos(id)
);


