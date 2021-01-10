--LV1 
--Zadatak 2. 
CREATE TABLE smartphone (
  imei CHAR(13), 
  nazivproizvodaca VARCHAR(20), 
  nazivmodela VARCHAR(20), 
  kolicinamemorije INT, 
  brzinaprocesora DECIMAL(3, 2), 
  velicinaekrana DECIMAL(2, 1), 
  nazivosa VARCHAR(10), 
  datumzadnjenadogradnje DATETIME, 
  imekorisnika VARCHAR(20), 
  prezimekorisnika VARCHAR(20), 
  CONSTRAINT pksmartphone PRIMARY KEY(imei)
);

--Zadatak 3. 
CREATE TABLE djelatnik (
  matbr CHAR(13) PRIMARY KEY, 
  ime VARCHAR(20), 
  prezime VARCHAR(20)
);
CREATE TABLE projekt (
  oznaka VARCHAR(20) PRIMARY KEY, 
  naziv VARCHAR(20)
);
CREATE TABLE radina (
  matbr CHAR(13), 
  oznaka VARCHAR(20), 
  CONSTRAINT pkradina PRIMARY KEY (matbr, oznaka), 
  CONSTRAINT fkradinamatbr FOREIGN KEY (matbr) REFERENCES djelatnik(matbr), 
  CONSTRAINT fkradinaoznaka FOREIGN KEY (oznaka) REFERENCES projekt(oznaka)
);

--Zadatak 4. 
CREATE TABLE grupa (
  id_grupe INT, 
  oznaka_grupe VARCHAR(5), 
  smjer VARCHAR(15), 
  broj_studenata INT, 
  CONSTRAINT pkgrupe PRIMARY KEY (id_grupe), 
  CONSTRAINT ukgrupe UNIQUE (oznaka_grupe)
);

--Zadatak 5.
CREATE TABLE student (
  br_indeksa INT, 
  ime VARCHAR(20), 
  prezime VARCHAR(20), 
  grupaid INT, 
  godina_upisa INT, 
  godina_studija INT, 
  CONSTRAINT pkstudent PRIMARY KEY (br_indeksa), 
  CONSTRAINT fkgrupa FOREIGN KEY (grupaid) REFERENCES grupa(id_grupe)
) 

--Zadatak 6. 
ALTER TABLE 
  student 
ADD 
  prosjek DECIMAL (3, 2);
ALTER TABLE 
  student 
ADD 
  CONSTRAINT chk_prosjek CHECK(prosjek >= 0);
ALTER TABLE 
  student 
DROP 
  COLUMN godina_studija;