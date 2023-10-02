/*Select * from episodes;
#Select * from seasons;
Select * from series;*/

#Ejercicio 1
CREATE TEMPORARY TABLE TWD (
id int, title varchar(40), rating float, season_id int, season_number int 
);

INSERT INTO TWD SELECT e.id, e.title, e.rating, e.season_id, s.number FROM episodes as e
JOIN seasons s ON s.id = e.season_id
JOIN series ser ON ser.id = s.serie_id
WHERE ser.title = 'The Walking Dead';

SELECT * FROM TWD WHERE season_number = 1;

#Ejercicio 2
#SELECT * FROM actors;
ALTER TABLE `movies_db`.`movies` 
ADD INDEX `indice_rating` (`rating` ASC) VISIBLE;
#EXPLAIN SELECT * FROM movies WHERE rating > 8;
EXPLAIN SELECT * FROM movies WHERE rating > 8;