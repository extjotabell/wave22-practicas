SELECT * FROM sakila.actor;

/****** DISTINCT ******/

SELECT COUNT(DISTINCT last_name)
FROM actor
WHERE last_name != null; /* IS NOT; // <> null */

/****** ORDER BY ******/
SELECT first_name, last_name , actor_id
FROM actor
WHERE first_name = "ADAM"
ORDER BY last_name;

/****** LIMIT ******/
SELECT first_name, last_name , actor_id
FROM actor 
LIMIT 50;

/****** AND ******/
SELECT actor_id, first_name, last_name 
FROM actor
WHERE first_name = "ADAM" AND last_name="HOPPER";

/****** OR ******/
SELECT actor_id, first_name, last_name 
FROM actor
WHERE first_name = "ADAM" OR last_name="HOPPER";

/****** AND NOT ******/
SELECT actor_id, first_name, last_name 
FROM actor
WHERE first_name = "ADAM" AND NOT last_name="HOPPER"; 

/****** LIKE ******/
SELECT actor_id, first_name, last_name 
FROM actor
WHERE first_name LIKE '%A'; /* %A // %A%*/ 

/****** BETWEEN ******/
SELECT actor_id, first_name, last_name 
FROM actor
WHERE actor_id BETWEEN 10 AND 100; 
