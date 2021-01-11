--14.1.2019 A
CREATE TABLE Kupac
(
OIBKupca CHAR(11),
Ime VARCHAR(50),
Prezime VARCHAR(50),
DatumRođenja DATETIME,
CONSTRAINT pkKupacOIB PRIMARY KEY (OIBKupca)
);

CREATE TABLE Kupuje
(
IDKupovine CHAR(10),
OIBKupca CHAR(11),
IDProizvoda CHAR(10),
DatumKupnje DATETIME,
CONSTRAINT pkKupujeID PRIMARY KEY (IDKupovine)
);

CREATE TABLE Proizvod
(
IDProizvoda CHAR(10),
Naziv VARCHAR(50),
Proizvođač CHAR(4),
Kategorija INT,
Cijena DECIMAL(8,2),
Dostupnost CHAR(2)
CONSTRAINT pkProizvodID PRIMARY KEY (IDProizvoda)
);

CREATE TABLE Proizvođač
(
IDProizvođača CHAR(4),
Naziv VARCHAR(50),
ZemljaPorijekla VARCHAR(50),
GodinaOsnutka INT,
CONSTRAINT pkProizvođačID PRIMARY KEY (IDProizvođača)
);

--Zadatak 1.
ALTER TABLE Proizvod ADD CONSTRAINT fkIDProizvođača FOREIGN KEY(Proizvođač) REFERENCES Proizvođač(IDProizvođača)
ALTER TABLE Kupac ADD VIPKupac CHAR(2)
ALTER TABLE Kupac ADD CONSTRAINT chkVip CHECK (VIPKupac IN ('DA','NE'))
ALTER TABLE Kupac DROP CONSTRAINT chkVip
--Zadatak 2.
INSERT INTO Proizvod VALUES ('1234567891','ImeProizvoda','ABCD','123','614.25','DA')

UPDATE Proizvođač
SET Naziv=SUBSTRING (Naziv,1,3)
WHERE GodinaOsnutka>1901 AND ZemljaPorijekla='Japan'

UPDATE Proizvod
SET Kategorija=99
WHERE Kategorija = (SELECT MIN(KATEGORIJA) FROM Proizvod)
INSERT INTO Kupac VALUES('12345678912','Ime1','Prezime1','02/01/1999','DA')
INSERT INTO Kupac VALUES('12345678913','Ime2','Prezime2','02/01/1996','DA')
INSERT INTO Kupac VALUES('12345678914','Ime3','Prezime3','02/01/1997','DA')

DELETE FROM Kupac WHERE MONTH(DatumRođenja)=4

--Zadatak 3.
SELECT COUNT(DISTINCT OIBKupca)
FROM Kupac GROUP BY YEAR(DatumRođenja)

SELECT YEAR(k.DatumKupnje),MAX(p.Cijena)
FROM Kupuje AS k, Proizvod as p
WHERE k.IDProizvoda=p.IDProizvoda AND p.Naziv LIKE '%a'
GROUP BY YEAR(k.DatumKupnje)

SELECT k.IDKupovine,p.Naziv
FROM Kupuje AS k, Proizvođač AS p, Proizvod AS pr
WHERE k.IDProizvoda=pr.IDProizvoda AND pr.Cijena>(SELECT AVG(Cijena) FROM Proizvod) AND pr.Proizvođač=p.IDProizvođača


CREATE VIEW pogled AS
SELECT k.Ime,k.Prezime,pr.Naziv,pr.Cijena,ku.DatumKupnje
FROM Kupac AS k, Kupuje AS ku, Proizvod AS pr
WHERE k.OIBKupca=ku.OIBKupca AND pr.IDProizvoda=ku.IDProizvoda

SELECT * FROM pogled

--Zadatak 4.
CREATE TRIGGER okidac ON Proizvod FOR INSERT
AS
DECLARE @cijena DECIMAL(8,2);
DECLARE @dostupnost CHAR(2);
DECLARE @id CHAR(10);
SET @id=(SELECT IDProizvoda FROM inserted);
SET @cijena=(SELECT Cijena FROM inserted);
SET @dostupnost=(SELECT Dostupnost FROM inserted);
IF (@cijena<0 OR @cijena>999999)
SET @cijena=0;
UPDATE Proizvod 
SET Cijena = @cijena
WHERE IDProizvoda=@id;
UPDATE Proizvod 
SET Dostupnost = LOWER(@dostupnost)
WHERE IDProizvoda=@id;

--14.1.2019 B
CREATE TABLE Avion
(
IDAviona CHAR(10),
Proizvođač VARCHAR(50),
Model VARCHAR(50),
DatumProizvodnje DATETIME,
CONSTRAINT pkAvionID PRIMARY KEY (IDAviona)
);
CREATE TABLE Let
(
IDLeta CHAR(8),
AerodromIz CHAR(12),
AerodromU CHAR(12),
DatumPolaska DATETIME,
BrojPutnika INT,
IDAviona CHAR(10),
CONSTRAINT pkLetID PRIMARY KEY (IDLeta)
);
CREATE TABLE Aerodrom
(
IDAerodroma CHAR(12),
Naziv VARCHAR(50),
sifraDrzave CHAR(6),
Kapacitet INT,
CONSTRAINT pkAerodromID PRIMARY KEY (IDAerodroma)
);
CREATE TABLE Država
(
IDDržave CHAR(6),
Naziv VARCHAR(50),
CONSTRAINT pkDržavaID PRIMARY KEY (IDDržave)
);
--Zadatak 1.
ALTER TABLE Let ADD VrstaLeta CHAR(3)
ALTER TABLE Let ADD CONSTRAINT checkVrstaLeta CHECK (VrstaLeta IN('INT','NAT'))
ALTER TABLE Let DROP CONSTRAINT checkVrstaLeta
ALTER TABLE Aerodrom ADD CONSTRAINT fkAerodromIDDrzave FOREIGN KEY (sifraDrzave) REFERENCES Država(IDDržave)

--Zadatak 2.
DELETE FROM Let WHERE YEAR(DatumPolaska)=2013 AND MONTH(DatumPolaska)=6
UPDATE Avion
SET Model='747'
WHERE 









--Zadatak 4. 2018 B
CREATE PROCEDURE procedura (@datum DATETIME)
AS
DECLARE @output NVARCHAR(50);
IF YEAR(@datum)<2012
SET @output=FORMAT(@datum,'dd. MMMM yyyy.');
ELSE
SET @output=FORMAT(@datum,'dd.MM.yyyy.');
PRINT @output

exec procedura '01/03/2013'