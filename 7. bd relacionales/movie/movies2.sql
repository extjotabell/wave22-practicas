USE movies_db;
SELECT series.title, genres.name
FROM series
JOIN genres ON series.genre_id = genres.id;

SELECT e.title, a.first_name, a.last_name
FROM episodes e 
JOIN actor_episode ae ON e.id = ae.episode_id
JOIN actors a ON ae.actor_id = a.id;

SELECT series.title, COUNT(seasons.id) as number_season
FROM series
JOIN seasons ON series.id = seasons.serie_id
GROUP BY title;

SELECT genres.name, COUNT(movies.id) as total
FROM genres
JOIN movies ON genres.id = movies.genre_id
GROUP BY genres.name
HAVING total >= 3;

SELECT DISTINCT actors.first_name, actors.last_name
FROM actors
JOIN actor_movie ON actors.id = actor_movie.actor_id
JOIN movies ON actor_movie.movie_id = movies.id
WHERE movies.title LIKE "La Guerra de las galaxias%"
GROUP BY actors.first_name, actors.last_name
HAVING COUNT(DISTINCT movies.id) = (SELECT COUNT(id) FROM movies WHERE movies.title LIKE 'La Guerra de las Galaxias%');


