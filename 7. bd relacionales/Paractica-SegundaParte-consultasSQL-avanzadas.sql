/* Ejercicios Prácticos: SQL Avanzado */
SELECT * FROM series;
SELECT * FROM genres;
# 1- Mostrar el título y el nombre del género de todas las series.
SELECT s.title, g.name FROM series s 
JOIN genres g ON g.id = s.genre_id;


# 2- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT e.title, a.first_name, a.last_name FROM actor_episode ae
JOIN actors a ON a.id =  ae.actor_id
JOIN episodes e ON e.id = ae.episode_id;


# 3- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT se.title, count(ss.serie_id) AS cantidad_episodios FROM series se
JOIN seasons ss ON ss.serie_id = se.id
GROUP BY se.title;


# 4- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT g.name, count(m.id) AS total from genres g
JOIN movies m on m.genre_id = g.id
GROUP BY m.genre_id
HAVING total >= 3;

# 5- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT DISTINCT a.first_name, a.last_name, count(a.id) as cuenta
FROM actors a
JOIN actors_movie am ON a.id = am.actor_id
JOIN movies m ON am.movie_id = m.id
WHERE m.title like "La Guerra de las galaxias%"
GROUP BY a.id 
HAVING cuenta = (SELECT  count(movies.id) FROM movies WHERE title like "La Guerra de las galaxias%");


insert into actor_movie values(44, null, null, 1, 3);
