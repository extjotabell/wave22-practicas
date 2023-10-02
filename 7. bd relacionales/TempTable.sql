CREATE TEMPORARY TABLE TWD (
	episode_id int AUTO_INCREMENT PRIMARY KEY,
    title varchar(500),
    rating decimal(3,1),
    season varchar(500)
);

INSERT INTO TWD (title, rating, season)
SELECT ep.title, ep.rating, se.title
FROM Episodes ep
INNER JOIN Seasons se
ON ep.season_id = se.id
INNER JOIN Series serie
ON se.serie_id = serie.id
WHERE serie.title = "The Walking Dead";

SELECT *
FROM TWD
WHERE season = "Primer Temporada";