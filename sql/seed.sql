
INSERT INTO bendrijos (pavadinimas)
VALUES ('Bendrija_A'), ('Bendrija_B');

INSERT INTO paslaugos (pavadinimas, aprasymas)
VALUES
('Vanduo', 'Saltas vanduo'),
('Sildymas', 'Centrinis sildymas'),
('Siuksles', 'Atliekų isvezimas');

-- prisijungimas: vardas / pavarde
INSERT INTO vartotojai (vardas, pavarde, prisijungimo_vardas, slaptazodis, role, bendrija_id)
VALUES
('Admin', 'Admin', 'Admin', 'Admin', 'ADMINISTRATORIUS', NULL),
('Petras', 'Vadyba', 'Petras', 'Vadyba', 'VADYBININKAS', NULL),
('Ieva', 'Gyventoja', 'Ieva', 'Gyventoja', 'GYVENTOJAS', 1);

INSERT INTO kainos (bendrija_id, paslauga_id, kaina)
VALUES
(1, 1, 5.50),
(1, 2, 30.00),
(2, 3, 8.00);
