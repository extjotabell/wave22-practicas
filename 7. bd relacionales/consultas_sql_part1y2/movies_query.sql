
SELECT * FROM movies;

SELECT first_name, last_name, rating FROM actors;

SELECT title AS titulos FROM SERIES;

SELECT first_name, last_name, rating FROM actors WHERE rating > 7.5;

SELECT title, rating, awards from MOVIES where rating > 7.5 ORDER BY RATING ASC;

SELECT title FROM MOVIES LIMIT 3;

SELECT title, rating FROM MOVIES ORDER BY rating DESC LIMIT 5;

SELECT first_name FROM actors LIMIT 10;

SELECT title, rating FROM MOVIES where title = "Toy Story";

SELECT title, rating FROM MOVIES WHERE title LIKE "Toy Story%";

SELECT * FROM actors WHERE first_name LIKE "SAM%";

SELECT title from MOVIES where release_date BETWEEN "2004-01-01" AND "2008-01-01";

SELECT title from MOVIES where rating > 3 AND awards > 1 AND release_date BETWEEN "1998-01-01" AND "2009-01-01" ORDER BY rating ASC;





























