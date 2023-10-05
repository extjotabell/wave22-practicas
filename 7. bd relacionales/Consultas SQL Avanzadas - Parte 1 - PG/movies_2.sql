# Mostrar el título y el nombre del género de todas las series.
SELECT s.title as title, (SELECT g.name FROM movies_db.genres g WHERE g.id = s.genre_id) as genre 
FROM movies_db.series s;

# Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT e.title as titulo,
		(SELECT a.first_name FROM movies_db.actors a WHERE (a.id =(SELECT ae.actor_id FROM movies_db.actor_episode ae WHERE ae.episode_id = e.id limit 1))) as Nombre,
        (SELECT a.last_name FROM movies_db.actors a WHERE (a.id =(SELECT ae.actor_id FROM movies_db.actor_episode ae WHERE ae.episode_id = e.id limit 1))) as Apellido
FROM movies_db.episodes e;

# Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT (SELECT se.title FROM movies_db.series se WHERE se.id = sea.serie_id) as Titulo, SUM(sea.serie_id) as Cant_temporadas
FROM movies_db.seasons sea
GROUP BY sea.serie_id;

# Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno,
# siempre que sea mayor o igual a 3.
SELECT (SELECT g.name FROM movies_db.genres g WHERE g.id = m.genre_id) as Genero, SUM(m.genre_id) as cant_peliculas
FROM movies_db.movies m
GROUP BY m.genre_id
HAVING m.genre_id >= 3;

# Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas 
# de la guerra de las galaxias y que estos no se repitan.
SELECT distinct (SELECT a.first_name FROM movies_db.actors a WHERE (a.id = am.actor_id)) as Nombre,
        (SELECT a.last_name FROM movies_db.actors a WHERE (a.id = am.actor_id)) as Apellido
FROM movies_db.actor_movie am
WHERE am.movie_id in (SELECT m.id FROM movies_db.movies m WHERE m.title LIKE "%La Guerra de las galaxias%");

insert into actor_movie values(44, null, null, 1, 3);
