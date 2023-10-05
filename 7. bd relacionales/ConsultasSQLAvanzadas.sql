INSERT INTO autor VALUES (1, "J.K. Rowling", "Britanica")
INSERT INTO autor VALUES (2, "Ray Bradbury", "Estadounidense")
INSERT INTO autor VALUES (3, "Mark A Garlick", "Britanica")
INSERT INTO autor VALUES (4, "Oliver Berry", "Britanica")

INSERT INTO estudiante VALUES(1, "Juan", "Jose", "Calle falsa 123", "Literatura", 18)
INSERT INTO estudiante VALUES(2, "Filipo", "Gali", "Calle falsa 123", "Informática", 20)
INSERT INTO estudiante VALUES(3, "Juana", "Diaz", "Calle falsa 123", "Informática", 19)
INSERT INTO estudiante VALUES(4, "Micaela", "Gali", "Calle falsa 123", "Informática", 22)
INSERT INTO estudiante VALUES(5, "Daniel", "Perez", "Calle falsa 123", "Biologia", 20)

INSERT INTO libro VALUES(1, "Harry Potter", "Salamandra", "Fantasia")
INSERT INTO libro VALUES(2, "El Universo: Guía de viaje", "GeoPlaneta", "Ciencia")
INSERT INTO libro VALUES(3, "Fahrenheit 451", "Norma" , "Ciencia Ficción")
INSERT INTO libro VALUES(4, "Introduccion a las bases de datos", "ORELLY" , "Base de datos")

INSERT INTO libro_autor VALUES(1, 1)
INSERT INTO libro_autor VALUES(3, 2)
INSERT INTO libro_autor VALUES(4, 2)
INSERT INTO libro_autor VALUES(2, 3)

INSERT INTO prestamo VALUES(2, 2, '2023-09-02 00:00:00', CURDATE() ,1)
INSERT INTO prestamo VALUES(3, 2, '2023-08-02 00:00:00', '2023-09-02 00:00:00' ,1)
INSERT INTO prestamo VALUES(4, 4, '2021-06-02 00:00:00', '2021-07-16 00:00:00' ,1)
INSERT INTO prestamo VALUES(5, 1, '2023-08-03 00:00:00', CURDATE() ,1)

/* 1 */
SELECT * FROM autor;
/* 2 */
SELECT nombre, edad FROM estudiante;
/* 3 */
SELECT nombre FROM estudiante where carrera like 'Informática';
/* 4 */
SELECT nombre from autor where nacionalidad like "Italiana" or nacionalidad like "Francesa";
/* 5 */
SELECT titulo from libro where area NOT LIKE 'Internet';
/* 6 */
SELECT titulo from libro where editorial like 'Salamandra';
/* 7 */
SELECT nombre from estudiante where edad > (SELECT AVG(edad) FROM estudiante);
/* 8 */
SELECT nombre, apellido from estudiante where apellido like 'G%';
/* 9 */
SELECT nombre from autor
JOIN libro_autor ON autor.id_autor = libro_autor.id_autor
JOIN libro ON libro.id_libro = libro_autor.id_libro where libro.titulo like 'El Universo: Guía de viaje';
/* 10 */
SELECT titulo 
FROM libro
JOIN prestamo ON prestamo.id_libro = libro.id_libro
JOIN estudiante ON prestamo.id_lector = estudiante.id_lector
WHERE estudiante.apellido like 'Gali'
/* 11 */
SELECT nombre, edad FROM estudiante WHERE edad =(SELECT MIN(edad) from estudiante);
/* 12 */
SELECT estudiante.nombre
from estudiante
JOIN prestamo on prestamo.id_lector = estudiante.id_lector
JOIN libro ON libro.id_libro = prestamo.id_libro
WHERE area like 'Base de datos';
/* 13 */
SELECT titulo from libro
JOIN libro_autor ON libro_autor.id_libro = libro.id_libro
JOIN autor ON libro_autor.id_autor = autor.id_autor WHERE autor.nombre like 'J.K. Rowling';
/* 14 */
SELECT titulo 
from libro
JOIN prestamo ON prestamo.id_libro = libro.id_libro WHERE fecha_devolucion like '2021-07-16%';

