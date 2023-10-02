USE biblioteca;

/*
INSERT INTO autores(nombre, nacionalidad) 
VALUES ('Stephen King', 'EEUU'),
		('Dan Brown', 'EEUU'),
        ('J.R.R, Tolkien', 'Reino Unido'),
        ('J.K. Rowling', 'Reino Unido'),
        ('Olvier Berry', 'EEUU'),
        ('Mark Garlick', 'EEUU'),
        ('Mark Mackenzie', 'EEUU'),
        ('Valerie Stimac', 'EEUU');

INSERT INTO estudiantes(nombre, apellido, direccion, carrera, edad) 
VALUES ('Facundo', 'Hermida', 'Calle 123', 'Ingeniería en informática', 23),
		('Filippo', 'Galli', 'Calle 342', 'Derecho', 21),
        ('Graciela', 'Pérez', 'Calle 53444', 'Medicina', 25),
        ('Marcos', 'Alonso', 'Calle 7854', 'Ingeniería en informática', 19),
        ('Mateo', 'Retegui', 'Calle 2456', 'Administración de empresas', 27);
        
INSERT INTO libros(titulo, editorial, area) 
VALUES ('The Two Towers', 'Harper Collins', 'medicina'),
		('Harry Potter and the chamber of secrets', 'Bloomsbury', 'Historia'),
        ('El Universo: Guía de viaje', 'Salamandra', 'Biografía'),
        ('22/11/63', 'Debolsillo', 'Turismo'),
        ('Inferno', 'Planeta', 'Historia');
        
INSERT INTO libro_autor(id_libro, id_autor) 
VALUES (4, 6),
		(5, 7),
        (1, 8),
        (2, 9),
        (3, 11),
        (3, 12),
        (3, 13),
        (3, 14);
        
INSERT INTO prestamos(id_lector, id_libro, fecha_prestamo, fecha_devolucion, devuelto) 
VALUES (1, 3, '2023-09-09', '2023-09-19', false),
		(2, 1, '2023-07-10', '2023-07-20', true),
        (4, 4, '2023-08-20', '2023-08-30', false),
		(1, 5, '2021-06-27', '2021-07-16', false),
		(2, 3, '2021-06-27', '2021-07-16', true);
*/


#Listar los datos de los autores.
SELECT * FROM autores;

#Listar nombre y edad de los estudiantes
SELECT nombre, edad FROM Estudiante;

#¿Qué estudiantes pertenecen a la carrera informática?
SELECT * FROM estudiantes WHERE carrera = 'Informática';

#¿Qué autores son de nacionalidad francesa o italiana?
SELECT * FROM autores WHERE nacionalidad = 'Francesa' OR nacionalidad = 'Italiana';

#¿Qué libros no son del área de internet?
SELECT * FROM libros WHERE area <> 'Internet';

#Listar los libros de la editorial Salamandra.
SELECT * FROM libros WHERE editorial = 'Salamandra';

#Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT * FROM estudiantes
WHERE edad > (SELECT AVG(edad) FROM Estudiante);

#Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT * FROM estudiantes
WHERE apellido LIKE 'G%';

#Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT a.nombre FROM libro_autor la
JOIN libros l ON l.id_libro = la.id_libro
JOIN autores a ON a.id_autor = la.id_autor
WHERE titulo = 'El Universo: Guía de viaje';

#¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT l.titulo FROM prestamos p
JOIN estudiantes e ON e.id_lector = p.id_lector
JOIN libros l ON l.id_libro = p.id_libro
WHERE e.nombre = 'Filippo' AND e.apellido = 'Galli';

#Listar el nombre del estudiante de menor edad.
SELECT nombre, apellido FROM estudiantes
WHERE edad = (SELECT MIN(edad) FROM estudiantes);

#Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT e.nombre FROM prestamos p
JOIN estudiantes e ON e.id_lector = p.id_lector
JOIN libros l ON l.id_libro = p.id_libro
WHERE l.area = 'Base de Datos';

#Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.titulo FROM libro_autor la
JOIN libros l ON l.id_libro = la.id_libro
JOIN autores a ON a.id_autor = la.id_autor
WHERE a.nombre = 'J.K. Rowling';

#Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT l.titulo FROM prestamos p
JOIN libros l ON l.id_libro = p.id_libro
WHERE p.fecha_devolucion = '2021-07-16' AND devuelto = false;
