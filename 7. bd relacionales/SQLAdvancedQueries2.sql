-- Agregar una película a la tabla movies.
INSERT INTO Movies VALUES(
	22 ,null, null, "Barbie", 8.5, 3, "2023-07-22 00:00:00", 137, 1
);

-- Agregar un género a la tabla genres.
INSERT INTO Genres VALUES(
	13, "2010-07-04 00:00:00", null, "Comedia Romántica", 13, 1
);

-- Asociar a la película del punto 1
-- el género creado en el punto 2.
UPDATE Movies
SET genre_id = 13
WHERE id = 22;

-- Modificar la tabla actors para que al menos un 
-- actor tenga como favorita la película agregada en el punto 1.
UPDATE Actors
SET favorite_movie_id = 22
WHERE id = 4;

-- Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE movies_copy AS
SELECT * FROM Movies;

-- Eliminar de esa tabla temporal todas las películas que 
-- hayan ganado menos de 5 awards.
DELETE FROM movies_copy
WHERE awards < 5;

-- Obtener la lista de todos los géneros que tengan al 
-- menos una película.
SELECT gen.id, gen.name, gen.ranking
FROM Genres gen
INNER JOIN Movies mov
ON gen.id = mov.genre_id
GROUP BY gen.id;

-- Obtener la lista de actores cuya película favorita haya 
-- ganado más de 3 awards.
SELECT ac.id, ac.first_name, ac.last_name
FROM Actors ac
INNER JOIN Movies mov
ON ac.favorite_movie_id = mov.id
WHERE mov.awards > 3;

-- Crear un índice sobre el nombre en la tabla movies.
-- Chequee que el índice fue creado correctamente.
-- Índice creado sobre el atributo title

-- En la base de datos movies ¿Existiría una mejora notable
-- al crear índices? Analizar y justificar la respuesta.
-- ¿En qué otra tabla crearía un índice y por qué? 
-- Justificar la respuesta
-- Decidi hacer un indice sobre el titulo dado a que puede ser
-- una condición frecuente para una query.
-- Dentro de la base de datos hay varías tablas a las que
-- se les podría crear índices para mejorar su rendimiento
-- Por ejemplo, actores, por su apellido. Series por su nombre, etc



