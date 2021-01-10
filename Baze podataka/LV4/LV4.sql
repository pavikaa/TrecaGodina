--LV4
--Zadatak 1.

--funkcija
CREATE FUNCTION funkcija (
  @word VARCHAR(31)
) RETURNS VARCHAR(100) BEGIN DECLARE @output VARCHAR(100);
IF LEN(@word)> 30 
SET 
  @output = 'Ulazna riječ je predugačka, maksimalan broj znakova je 30' ELSE BEGIN 
SET 
  @output = REVERSE(@word);
IF @output = @word 
SET 
  @output = 'palindrom' END RETURN @output END 

SELECT 
  dbo.funkcija('rijec') 
  
--procedura
  CREATE PROCEDURE procedura (
    @word VARCHAR(31)
  ) AS DECLARE @output VARCHAR(100);
IF LEN(@word)> 30 
SET 
  @output = 'Ulazna riječ je predugačka, maksimalan broj znakova je 30' ELSE BEGIN 
SET 
  @output = REVERSE(@word);
IF @output = @word 
SET 
  @output = 'palindrom' PRINT @output;
END 

exec procedura 'rijec';

--trigger
CREATE TRIGGER okidac ON računi FOR INSERT AS DECLARE @output VARCHAR(100);
SELECT 
  @output = REVERSE(ime) 
FROM 
  inserted;
UPDATE 
  računi 
SET 
  ime = @output 
  
  CREATE TABLE računi (
    ime VARCHAR(100)
  );
  
INSERT INTO računi 
VALUES 
  ('ime') 
  
SELECT 
  * 
FROM 
  računi