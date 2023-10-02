#Consultas avanzadas 1
/*CREATE TEMPORARY TABLE TWD (
SELECT E.* FROM EPISODES E 
JOIN SEASONS S ON E.season_id = S.id 
JOIN SERIES SE ON S.serie_id = SE.id WHERE se.title like "The Walking Dead");
SELECT * FROM TWD;
SELECT T.* FROM TWD T JOIN SEASONS S ON T.season_id = S.id where s.number = 1;*/

#Consultas avanzadas 2
#1
INSERT INTO movies values (22,null, null, "Forrest Gump", 9,5,'2010-10-04 00:00:00',120,5);
#2
INSERT INTO `movies_db`.`GENRES` (`id`, `created_at`, `name`, `ranking`, `active`) VALUES ('14', '2013-07-04 00:00:00', 'Romance', '13', '1');
#3
UPDATE `movies_db`.`MOVIES` SET `genre_id` = '13' WHERE (`id` = '22');

#4
UPDATE `movies_db`.`actors` SET `favorite_movie_id` = '22' WHERE (`id` = '27');
#5
CREATE TEMPORARY TABLE temp_movies (SELECT * FROM MOVIES);
SELECT * from temp_movies;
#6
DELETE FROM temp_movies TM where TM.awards<5;
#7
SELECT g.name from genres g 
JOIN movies m on g.id=m.genre_id
GROUP by g.id
having count(g.id)>=1;
#Otra alternativa
SELECT distinct g.name from genres g 
JOIN movies m on g.id=m.genre_id
GROUP by g.id;
#8
SELECT a.* FROM actors a
JOIN movies m on a.favorite_movie_id = m.id
WHERE m.awards >3;
#9
ALTER TABLE `movies_db`.`movies` 
ADD INDEX `release_date` (`release_date` ASC) VISIBLE;
;
#10
SHOW INDEX FROM movies;
#11 NO, es demasiado pequeña
#12 En ninguna otra, es demasiado pequeña la base como para obtener una mejora notable en el rendimiento.