--Zadatak 1
SELECT 
  DISTINCT SUBSTRING(ime, 1, 1) AS 'Ime', 
  SUBSTRING(prezime, 1, 1) AS 'Prezime', 
  YEAR(datRod) AS 'Godina' 
FROM 
  student;
--Ispisujemo inicijale studenata korištenjem SUBSTRING naredbe, te godinu rođenja korištenjem YEAR naredbe

SELECT 
  * 
FROM 
  student 
ORDER BY 
  datRod;
--Ispisujemo sve studente i njihove podatke te ih slažemo po starosti, od najstarijeg prema najmlađem

SELECT 
  ime AS 'Ime', 
  prezime AS 'Prezime' 
FROM 
  student 
WHERE 
  datRod =(
    SELECT 
      MIN(datRod) 
    FROM 
      student 
    WHERE 
      spol = 'F'
  ) 
  --Ispisujemo ime i prezime najstarije ženskog studenta, provjeru 
  --radimo u WHERE gdje smo pomoću SELECT MIN(datRod) i dodatnog uvjeta spol='F' 
  --pronašli najraniji datum rođenja ženskog studenta
  
  --Zadatak 2
SELECT 
  COUNT(DISTINCT mbr) AS 'BrojStudenata' 
FROM 
  student 
  --Ispisujemo broj matičnih brojeva iz tablice student što predstavlja broj studenata
  
SELECT 
  COUNT(DISTINCT pbrPreb) AS 'BrojMjesta' 
FROM 
  student 
  --Ispisujemo broj različitih poštanskih brojeva koji predstavljaju broj različitih mjesta u kojima studenti žive
  
  --Zadatak 3
SELECT 
  AVG(ocjena) AS 'Prosjek' 
FROM 
  ispit 
WHERE 
  ocjena > 1 
  --Ispisujemo prosječnu ocjenu svih predmeta iz tablice ispit uz uvjet da je ispit položen
  
  --Zadatak 4
SELECT 
  s.ime, 
  s.prezime, 
  AVG(i.ocjena) AS 'Prosjek' 
FROM 
  student AS s, 
  ispit AS i 
WHERE 
  i.ocjena > 1 
  AND s.mbr = i.mbrStud 
GROUP BY 
  s.ime, 
  s.prezime 
ORDER BY 
  AVG(i.ocjena) DESC 
  --Povezujemo tablice student i ispit provjerom matičnih brojeva te ispisujemo prosječne ocjene padajućim nizom
SELECT 
  mbrStud 
FROM 
  ispit 
WHERE 
  ocjena > 1 
GROUP BY 
  mbrStud 
HAVING 
  AVG(ocjena)> 2.5 
  --Ispisujemo matični broj studenata koji imaju prosječnu ocjenu položenih ispita veću od 2.5
  --sa WHERE provjeravamo je li ispit položen te sa HAVING ispisujemo samo one koji imaju prosječnu ocjenu veću od 2.5

  --Zadatak 5
  CREATE VIEW student_view AS 
SELECT 
  s.ime, 
  s.prezime, 
  i.ocjena, 
  i.datIspita, 
  p.naziv 
FROM 
  student AS s, 
  ispit AS i, 
  predmet AS p 
WHERE 
  s.mbr = i.mbrStud 
  AND i.sifPredmeta = p.sifra 
  --Kreiramo pogled student_view i povezujemo tablice student 
  --i ispit preko matičnih brojeva te tablice ispit i predmet preko šifre predmeta
SELECT 
  * 
FROM 
  student_view 
  --Ispisujemo prethodno napravljeni pogled
