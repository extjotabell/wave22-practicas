USE movies_db;


/* Ejercicio 1 */
SELECT * FROM movies;

/* Ejercicio 2 */
SELECT first_name, last_name, rating FROM actors;

/* Ejercicio 3 */
SELECT title AS 'Titulo' FROM series;

/* Ejercicio 4 */
SELECT first_name, last_name FROM actors WHERE rating > 7.5;

/* Ejercicio 5 */
SELECT title, rating, awards FROM movies WHERE rating > 7.5 AND awards > 2;

/* Ejercicio 6 */
SELECT title, rating FROM movies ORDER BY rating ASC;

/* Ejercicio 7 */
SELECT title FROM movies LIMIT 3;

/* Ejercicio 8 */
SELECT title FROM movies ORDER BY rating DESC LIMIT 5;

/* Ejercicio 9 */
SELECT * FROM actors LIMIT 10;

/* Ejercicio 10 */
SELECT title, rating FROM movies WHERE title LIKE 'Toy Story%';

/* Ejercicio 11 */
SELECT * FROM actors WHERE first_name LIKE 'Sam%';

/* Ejercicio 12 */
SELECT title FROM movies WHERE year(release_date) BETWEEN 2004 AND 2008;  

/* Ejercicio 13 */
SELECT title FROM movies WHERE rating > 3 AND awards > 1 AND year(release_date) BETWEEN 1988 AND 2009 ORDER BY rating;













