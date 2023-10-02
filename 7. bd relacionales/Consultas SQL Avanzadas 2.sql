# Agregar una película a la tabla movies.movies

INSERT INTO `movies_db`.`movies`
(`id`,
`title`,
`rating`,
`awards`,
`release_date`,
`length`)
VALUES
(22,
"El señor de los anillos",
10,
6,
2001-12-05,
150);


# Agregar un género a la tabla genres.

INSERT INTO `movies_db`.`genres`
(`id`,
`name`,
`ranking`)
VALUES
(13,
'Ciencia Ficción Nueva',
10);


# Asociar a la película del punto 1. genre el género creado en el punto 2.

UPDATE movies SET genre_id = 13 WHERE id = 22;

# Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.

UPDATE actors SET favorite_movie_id = 22 WHERE id = 3;

# Crear una tabla temporal copia de la tabla movies.

CREATE TEMPORARY TABLE movies_copy AS SELECT * FROM movies;

# Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.

DELETE FROM movies_copy WHERE awards < 5;

# Obtener la lista de todos los géneros que tengan al menos una película.

SELECT g.* FROM genres g
JOIN movies m ON g.id = m.genre_id;

# Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.

SELECT a.* FROM actors a
JOIN movies m ON a.favorite_movie_id = m.id
WHERE m.awards > 3;

# Crear un índice sobre el nombre en la tabla movies.

CREATE INDEX index_movie_title
ON movies (title);

# Chequee que el índice fue creado correctamente.

SHOW INDEX FROM movies;

# En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.

# Si habría mejoras notables al crear indices sobre campos que se utilicen con frecuencia en las claúsulas WHERE y JOIN ya que no sería necesario analizar todos los registros para filtrar algún valor.

# ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta

# La creación de indices se justifican según el uso y las consultas que se quieran hacer sobre un determinada tabla.
# Por ejemplo para actores, se podría crear un índice en el apellido para realizar filtros más rápidos. Lo mismo ocurriría en el título de películas o series o para su rating.
