-- Segunda Parte
-- Se propone realizar las siguientes consultas a la base de datos movies_db.sql trabajada en la primera clase.
-- Importar el archivo movies_db.sql desde PHPMyAdmin o MySQL Workbench y resolver las siguientes consultas:
-- 1 - Mostrar el título y el nombre del género de todas las series.

SELECT series.title, genres.name 
FROM SERIES 
INNER JOIN genres
ON series.genre_id = genres.id;

-- 2 - Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.

SELECT actors.first_name, actors.last_name, episodes.title 
FROM actor_episode
INNER JOIN actors
ON actor_episode.actor_id = actors.id
INNER JOIN episodes
ON actor_episode.episode_id = episodes.id;

-- 3 - Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.

SELECT series.title, COUNT(seasons.id) AS total_temporadas
FROM series
JOIN seasons
ON series.id= seasons.serie_id
GROUP BY series.id;

-- 4 - Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.

SELECT genres.name, COUNT(movies.id) as total FROM genres
JOIN movies ON genres.id = movies.genre_id
GROUP BY genres.name
HAVING total >= 3;

-- 5 - Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.

SElECT a.first_name, a.last_name, count(a.id) as number_movies 
FROM actors a
JOIN actor_movie acm 
ON a.id = acm.actor_id
JOIN movies m
ON acm.movie_id = m.id
WHERE m.title LIKE "La Guerra de las galaxias%"
GROUP BY a.id 
HAVING number_movies = (SELECT COUNT(movies.id) FROM movies WHERE title LIKE "La Guerra de las galaxias%");


show index from movies;
