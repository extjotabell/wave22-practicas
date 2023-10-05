/*Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.*/

CREATE TEMPORARY TABLE TWD
(nombre NVARCHAR(50),
temporada int);

INSERT INTO TWD (nombre, temporada)
SELECT episodes.title, seasons.number FROM episodes
JOIN seasons ON seasons.id = episodes.season_id
JOIN series ON series.id = seasons.serie_id WHERE series.title like '%The Walking Dead%';

SELECT * FROM TWD;

/*Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.*/
SELECT * FROM TWD where temporada = 1;

/*En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo. 
Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.*/
SELECT * FROM movies WHERE rating >= 8.0;
EXPLAIN SELECT * FROM movies WHERE rating >= 8.0;

ALTER TABLE `movies_db`.`movies` 
ADD INDEX `indice_rating` (`rating` ASC) VISIBLE;
;

