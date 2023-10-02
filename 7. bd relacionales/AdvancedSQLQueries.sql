-- Mostrar el título y el nombre del género de todas las series.
SELECT se.title, ge.name AS genre
FROM series se
INNER JOIN genres ge
ON se.genre_id = ge.id;

-- Mostrar el título de los episodios, el nombre y 
-- apellido de los actores que trabajan en cada uno de ellos.
SELECT ep.title, ac.first_name as actor_first_name , ac.last_name as actor_last_name
FROM episodes ep
INNER JOIN actor_episode ae
ON ep.id = ae.episode_id
INNER JOIN actors ac
ON ae.actor_id = ac.id;

-- Mostrar el título de todas las series y 
-- el total de temporadas que tiene cada una de ellas.
SELECT se.title, COUNT(sea.id) as seasons_amount
FROM series se
INNER JOIN seasons sea
ON se.id = sea.serie_id
GROUP BY se.id;


-- Mostrar el nombre de todos los géneros y 
-- la cantidad total de películas por cada uno, 
-- siempre que sea mayor o igual a 3.
SELECT ge.name, COUNT(mo.genre_id) AS amount
FROM genres ge
INNER JOIN movies mo
ON ge.id = mo.genre_id
GROUP BY ge.id
HAVING cuenta >= 3;

-- Mostrar sólo el nombre y apellido de los actores 
-- que trabajan en todas las películas de la guerra de 
-- las galaxias y que estos no se repitan.
SELECT DISTINCT ac.first_name, ac.last_name
FROM actors ac
INNER JOIN actor_movie ac_mo
ON ac.id = ac_mo.actor_id
INNER JOIN movies mo
ON ac_mo.movie_id = mo.id
WHERE mo.title LIKE "La guerra de las galaxias%";





