CREATE TABLE Actors
(
    Name VARCHAR(40),
    Movie VARCHAR(80),
    Year INTEGER,
    Role VARCHAR(40)
);

LOAD DATA LOCAL INFILE '~/ebay-data/actors.csv'
INTO TABLE Actors
FIELDS TERMINATED BY ','
OPTIONALLY ENCLOSED BY '"';

SELECT Name
FROM Actors
WHERE Movie='Die Another Day'
GROUP BY Name;

DROP TABLE Actors;
