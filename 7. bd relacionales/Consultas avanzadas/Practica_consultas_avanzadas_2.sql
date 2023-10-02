SELECT * FROM actors;
#Agregar una película a la tabla movies.
INSERT INTO movies (title, rating, awards, release_date, length, genre_id)
VALUES ('La noche del demonio: La puerta roja', 5, 0, '2023-06-27', 107, 2);

#Agregar un género a la tabla genres.
INSERT INTO genres (created_at, name, ranking, active)
VALUES (CURDATE(), 'Thriller', 13, true);

#Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies SET genre_id = 13 WHERE id = 23;

#Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors SET favorite_movie_id = 23 WHERE id = 3;

#Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE movies_copy AS (SELECT * FROM movies);
ALTER TABLE movies_copy ADD PRIMARY KEY(id);

#Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE mc FROM movies_copy mc
JOIN movies m ON m.id = mc.id
WHERE m.awards < 5;

#Obtener la lista de todos los géneros que tengan al menos una película.
SELECT g.name, COUNT(*) cantidad FROM genres g
JOIN movies m ON m.genre_id = g.id
GROUP BY g.name
HAVING COUNT(*) >= 1;

#Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT a.* FROM actors a
JOIN movies m ON a.favorite_movie_id = m.id
WHERE m.awards >= 3;

#Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX idx_movie_title ON movies(title);

#Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;

#En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
#Sí, dado que es una tabla que tiene muchos registros y puede tener aún más

#¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
#En la tabla actors. Es una tabla a la que se le realiza muchas consultas, tiene muchos registros pero, en mi opinión, no se actualizaría con tanta periodicidad


