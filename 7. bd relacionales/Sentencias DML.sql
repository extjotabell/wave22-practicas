SELECT * FROM sakila.film;

/******* SELECT *******/
SELECT * FROM film;

SELECT title, film_id, rating FROM film
WHERE film_id =1;

/******* INSERT *******/
SELECT * FROM film;
INSERT INTO film 
VALUES (1001, "The Avengers", "Pelicula de superheroes", 2010, 1, null , 3, 5, 210, 30.99, "PG-13", "Trailers,Commentaries", "2010-01-01 00:00:00");

SELECT * FROM film
WHERE film_id = 1002;

/******* UPDATE*******/
UPDATE film
SET rating = "PG-13"
WHERE film_id = 1000;

SELECT * FROM film;

/******* DELETE *******/
DELETE FROM film
WHERE film_id = 1001;