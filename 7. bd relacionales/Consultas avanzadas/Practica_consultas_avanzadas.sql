USE movies_db;

#Mostrar el título y el nombre del género de todas las series.
SELECT s.title, g.name FROM series s
JOIN genres g ON s.genre_id = g.id;

#Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT e.title, a.first_name, a.last_name FROM actor_episode ae
JOIN actors a ON ae.actor_id = a.id
JOIN episodes e ON ae.episode_id = e.id;

#Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT s.title, COUNT(0) FROM series s
JOIN seasons se ON s.id = se.serie_id
GROUP BY s.id;

#Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT name, COUNT(0) FROM genres g
JOIN movies m ON g.id = m.genre_id
GROUP BY g.id
HAVING COUNT(0) >= 3;

#Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
EXPLAIN SELECT a.first_name, a.last_name FROM actor_movie am
JOIN movies m ON m.id = am.movie_id 
JOIN actors a ON a.id = am.actor_id
WHERE m.title LIKE 'La Guerra de las galaxias%'
GROUP BY a.first_name, a.last_name
HAVING COUNT(*) = (SELECT COUNT(*) FROM movies WHERE title LIKE 'La Guerra de las galaxias%');