/*Mostrar el título y el nombre del género de todas las series.*/
SELECT movies.title, genres.name from movies 
JOIN genres ON genres.id = movies.genre_id;

/*Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.*/
SELECT DISTINCT episodes.title, actors.first_name, actors.last_name FROM episodes
JOIN actor_episode ON actor_episode.episode_id = episodes.id
JOIN actors ON actors.id = actor_episode.actor_id;

/*Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.*/
SELECT series.title, COUNT(seasons.number) AS temporadas 
FROM series 
JOIN seasons ON seasons.serie_id = series.id GROUP BY series.title;

/*Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.*/
SELECT genres.name AS genre, COUNT(movies.id) AS cantidad_peliculas 
FROM genres
JOIN movies ON movies.genre_id = genres.id
GROUP BY genres.id
HAVING COUNT(movies.title) >= 3;

/*Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.*/
SELECT DISTINCT actors.first_name, actors.last_name from actors
JOIN actor_movie ON actor_movie.actor_id = actors.id
JOIN movies ON movies.id = actor_movie.movie_id WHERE title like 'La Guerra de las galaxias%';
