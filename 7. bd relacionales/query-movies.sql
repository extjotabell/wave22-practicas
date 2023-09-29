/* 1 */
SELECT * FROM movies;

/* 2 */

SELECT first_name, last_name, rating FROM actors;

/* 3 */
SELECT title AS 'Título de la Serie'
FROM series;

/* 4 */
SELECT first_name AS 'Nombre del Actor', last_name AS 'Apellido del Actor'
FROM actors
WHERE rating > 7.5;

/* 5 */
SELECT title AS 'Título de la Película', rating AS 'Rating', awards AS 'Premios'
FROM movies
WHERE rating > 7.5 AND awards > 2;

/* 6 */
SELECT titulo AS 'Título de la Película', rating AS 'Rating'
FROM peliculas
ORDER BY rating ASC;

/* 7 */
SELECT title AS 'Título de la Película', rating AS 'Rating'
FROM movies
ORDER BY rating DESC
LIMIT 5;

/* 8 */
SELECT first_name AS 'Nombre del Actor', last_name AS 'Apellido del Actor'
FROM actors
LIMIT 10;

/* 9 */
SELECT title AS 'Título de la Película', rating AS 'Rating'
FROM movies
WHERE title LIKE '%Toy Story%';

/* 10 */
SELECT first_name AS 'Nombre del Actor', last_name AS 'Apellido del Actor'
FROM actors
WHERE first_name LIKE 'Sam%';

/* 11 */
SELECT title AS 'Título de la Película'
FROM movies
WHERE release_date BETWEEN '2004-01-01 00:00:00' AND '2008-12-31 23:59:59';

select title as 'pelicula', release_date as 'fecha'
from movies;

/* 12 */
SELECT title AS 'Título de la Película'
FROM movies
WHERE rating > 3 AND awards > 1 AND release_date BETWEEN '1988-01-01 00:00:00' AND '2009-12-31 23:59:59'
ORDER BY rating;



