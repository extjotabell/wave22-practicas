#PUNTO 1
SELECT id, created_at, updated_at, title, rating, awards, release_date, length, genre_id
FROM movies

#PUNTO 2
SELECT first_name, last_name, rating
FROM actors

#PUNTO 3
SELECT title as TITULO
FROM series

#PUNTO 4
SELECT first_name, last_name, rating
FROM actors
WHERE rating > 7.5

#PUNTO 5
SELECT title, rating, awards
FROM movies
WHERE rating > 7.5 AND awards > 2

#PUNTO 6
SELECT title, rating
FROM movies
ORDER BY rating

#PUNTO 7
SELECT title
FROM movies
LIMIT 3

#PUNTO 8
SELECT *
FROM movies
ORDER BY rating DESC
LIMIT 5

#PUNTO 9
SELECT * 
FROM actors
LIMIT 10

#PUNTO 10
SELECT title, rating
FROM MOVIES
WHERE title = "Toy Story"

#PUNTO 11
SELECT * 
FROM actors
WHERE first_name LIKE 'Sam%'

#PUNTO 12
SELECT title, release_date
FROM movies
WHERE release_date BETWEEN '2004-01-01' AND '2008-12-31'

#PUNTO 13
SELECT *
FROM movies
WHERE rating > 3 
	AND awards > 1
    AND release_date BETWEEN '1998-01-01' AND '2009-12-31'
ORDER BY rating


#Segundo ejercicio
#Parte 2

#Punto 1
SELECT title, name
FROM series as S
	INNER JOIN genres G ON s.genre_id = G.id
    
    
#Punto 2
SELECT E.title, A.first_name, A.last_name
FROM episodes as E
	INNER JOIN  actor_episode AE ON  E.id = AE.episode_id
	INNER JOIN actors A ON A.id = AE.actor_id

#PUNTO 3
SELECT SE.title, COUNT(SA.id)
FROM series SE
	INNER JOIN seasons SA ON SE.id = SA.serie_id
GROUP BY(SE.id)

#PUNTO 4
SELECT G.title, COUNT(G.genre_id)
FROM genres G
	INNER JOIN movies M ON G.id = M.genre_id
GROUP BY(G.genre_id)

