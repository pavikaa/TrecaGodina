SET DATEFORMAT dmy
--Zadatak 1
CREATE TABLE Osobe_Pavicic
(
ime CHAR(30),
prezime VARCHAR(30) NOT NULL,
jmbg CHAR(13) NOT NULL,
dat_rod DATETIME,
spol CHAR(1) DEFAULT 'M',
visina INT,
broj_cipela INT,
CONSTRAINT Osobe_Pavicic_pk PRIMARY KEY(jmbg),
CONSTRAINT chk_spol_Pavicic CHECK (spol IN ('M', 'Ž')),
);
SELECT * FROM Osobe_Pavicic
INSERT INTO Osobe_Pavicic
VALUES
(
'Ivan',
'Ivić',
'1234567891234',
'01/01/1999',
'M',
'180',
'44'
);
INSERT INTO Osobe_Pavicic
VALUES
(
'Luka',
'Lukić',
'1234567891235',
'01/02/1999',
'M',
'182',
'44'
);
INSERT INTO Osobe_Pavicic
VALUES
(
'Matej',
'Matić',
'1234567891236',
'01/03/1999',
'M',
'181',
'43'
);
INSERT INTO Osobe_Pavicic
VALUES
(
'Iva',
'Ivić',
'1234567891237',
'01/05/1999',
'Ž',
'170',
'40'
);
INSERT INTO Osobe_Pavicic
VALUES
(
'Ana',
'Anić',
'1234567891238',
'01/01/1999',
'Ž',
'172',
'39'
);
--Zadatak 2
UPDATE Osobe_Pavicic
SET broj_cipela=broj_cipela+1;
UPDATE Osobe_Pavicic
SET prezime='Luka',
ime='Lukić'
WHERE jmbg=1234567891235;
--Zadatak 3
SELECT * FROM student ORDER BY (datUpis) DESC;
SELECT ime AS "Ime",
prezime AS "Prezime",
datRod AS "Datum rođenja"
FROM student
WHERE datRod<'01/01/1995'
ORDER BY(prezime)
--Zadatak 4
SELECT s.ime AS "Ime",
s.prezime AS "Prezime",
p.naziv AS "Naziv predmeta",
i.Ocjena AS "Ocjena"
FROM student AS s,
predmet AS p,
ispit AS i
WHERE s.mbr=i.mbrStud AND p.sifra=i.sifPredmeta AND i.ocjena>=4
ORDER BY(prezime)