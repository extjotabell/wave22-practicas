SELECT title, g.name FROM series 
INNER JOIN genres g ON genre_id = g.id;

SELECT title, a.first_name, a.last_name FROM episodes e
INNER JOIN actor_episode ae ON e.id = ae.episode_id
INNER JOIN actors a ON a.id = ae.actor_id;

SELECT series.title, count(s.id) AS "# of seasons" FROM series
INNER JOIN seasons s ON s.serie_id = series.id
GROUP BY series.title;

SELECT g.name, COUNT(g.id) AS "# of movies/genre" FROM movies m
INNER JOIN genres g ON m.genre_id = g.id
GROUP BY g.id;

SET @cantidadPeli = (SELECT COUNT(movies.id) FROM movies WHERE title like 'La Guerra de las galaxias%');

SELECT first_name, last_name FROM actors a 
INNER JOIN actor_movie am on a.id = am.actor_id
INNER JOIN movies m on m.id = am.movie_id
WHERE m.title LIKE "La Guerra de las galaxias%"
GROUP BY first_name, last_name
HAVING count(first_name) = @cantidadPeli;
