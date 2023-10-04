#Consultas SQL Avanzadas Parte 1 PG

#Mostrar el título y el nombre del género de todas las series.
SELECT series.title, genres.name 
FROM (series 
INNER JOIN genres ON series.genre_id = genres.id);

#Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT episodes.title, actors.first_name, actors.last_name 
FROM (episodes 
INNER JOIN actor_episode ON episodes.id = actor_episode.episode_id
INNER JOIN actors ON actor_episode.actor_id = actors.id);

#Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT series.title, count(series.id) 
FROM series 
INNER JOIN seasons ON series.id = seasons.serie_id 
GROUP BY series.title;

#Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT genres.name, count(movies.genre_id) 
FROM genres 
INNER JOIN movies ON movies.genre_id = genres.id 
GROUP BY genre_id 
HAVING count(movies.genre_id) >= 3;

#Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT DISTINCT actors.first_name, actors.last_name 
FROM actors 
INNER JOIN actor_movie ON actors.id = actor_movie.actor_id 
INNER JOIN movies ON actor_movie.movie_id = movies.id 
WHERE movies.title LIKE "La Guerra de las galaxias%";
