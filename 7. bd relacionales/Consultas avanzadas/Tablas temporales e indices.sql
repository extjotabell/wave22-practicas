

CREATE TEMPORARY TABLE TWD (id int, temporada int, episodio varchar(50), fecha_lanzamiento datetime, rating decimal (3,1));

INSERT INTO TWD
SELECT e.id, s.number, e.title, e.release_date, e.rating FROM episodes e
JOIN seasons s ON s.id = e.season_id
JOIN series ser ON ser.id = s.serie_id
WHERE ser.title = 'The Walking Dead';

SELECT * FROM TWD
WHERE temporada = 1;

CREATE INDEX idx_names_actors ON actors(first_name, last_name);