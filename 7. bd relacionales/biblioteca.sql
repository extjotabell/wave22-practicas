DROP DATABASE IF EXISTS biblioteca;
CREATE DATABASE biblioteca;

USE biblioteca;

-- Crear la tabla AUTOR
CREATE TABLE autor (
    id_autor INT PRIMARY KEY,
    nombre VARCHAR(50),
    nacionalidad VARCHAR(50)
);

-- Insertar algunos datos falsos en la tabla AUTOR
INSERT INTO autor (id_autor, nombre, nacionalidad)
VALUES
    (1, 'Jean-Pierre Dupont', 'Francés'),
    (2, 'Antonio Rossi', 'Italiano'),
    (3, 'J.K. Rowling', 'Francés'),
    (4, 'Giuseppe Conte', 'Italiano'),
    (5, 'Ramón', 'Italiana'),
    (6, 'Cristian', 'Argentino');

-- Crear la tabla LIBRO
CREATE TABLE libro (
    id_libro INT PRIMARY KEY,
    titulo VARCHAR(100),
    editorial VARCHAR(50),
    area VARCHAR(50)
);

-- Insertar algunos datos falsos en la tabla LIBRO
INSERT INTO libro (id_libro, titulo, editorial, area)
VALUES
    (101, 'El Arte de la Cocina Francesa', 'Culinaria Books', 'Internet'),
    (102, 'La Divina Comedia', 'Salamandra', 'Literatura'),
    (103, 'Cocina Italiana Auténtica', 'Culinaria Books', 'Cocina'),
    (104, 'El Universo: Guía de viaje', 'Historia Publishers', 'Base de Datos');

-- Crear la tabla LIBROAUTOR
CREATE TABLE libro_autor (
    id_autor INT,
    id_libro INT,
    FOREIGN KEY (id_autor) REFERENCES autor(id_autor),
    FOREIGN KEY (id_libro) REFERENCES libro(id_libro)
);

-- Asociar autores a libros
INSERT INTO libro_autor (id_autor, id_libro)
VALUES
    (1, 101),
    (2, 102),
    (2, 103),
    (3, 104),
    (1, 104);

-- Crear la tabla ESTUDIANTE
CREATE TABLE estudiante (
    id_lector INT PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    direccion VARCHAR(100),
    carrera VARCHAR(50),
    edad INT
);

-- Insertar algunos datos falsos en la tabla ESTUDIANTE
INSERT INTO ESTUDIANTE (id_lector, nombre, apellido, direccion, carrera, edad)
VALUES
    (201, 'Luis', 'González', '123 Calle Principal', 'Ingeniería Civil', 22),
    (202, 'Filippo', 'Galli', '456 Avenida Central', 'Informática', 20),
    (203, 'Carlos', 'López', '789 Calle Secundaria', 'Medicina', 28),
    (204, 'Pepe', 'Perez', '789 Calle Secundaria', 'Medicina', 15);

-- Crear la tabla PRESTAMO
CREATE TABLE prestamo (
    id_lector INT,
    id_libro INT,
    fecha_prestamo DATE,
    fecha_devolucion DATE,
    devuelto BOOLEAN,
    FOREIGN KEY (id_lector) REFERENCES estudiante(id_lector),
    FOREIGN KEY (id_libro) REFERENCES libro(id_libro)
);

-- Insertar algunos datos falsos en la tabla PRESTAMO
INSERT INTO prestamo (id_lector, id_libro, fecha_prestamo, fecha_devolucion, devuelto)
VALUES
    (201, 101, '2023-09-01', '2023-09-15', TRUE),
    (202, 103, '2023-08-15', '2023-09-05', TRUE),
    (203, 104, '2023-09-10', '2021-07-16', FALSE);

# Listar los datos de los autores.

SELECT * FROM autor;

# Listar nombre y edad de los estudiantes

SELECT nombre, edad FROM estudiante;

# ¿Qué estudiantes pertenecen a la carrera informática?

SELECT * FROM estudiante WHERE carrera = 'Informática';

# ¿Qué autores son de nacionalidad francesa o italiana?

SELECT * FROM autor WHERE nacionalidad LIKE 'Franc%' OR nacionalidad LIKE 'Italian%';

# ¿Qué libros no son del área de internet?

SELECT * FROM libro WHERE area <> 'Internet';

# Listar los libros de la editorial Salamandra.

SELECT * FROM libro WHERE editorial = 'Salamandra';

# Listar los datos de los estudiantes cuya edad es mayor al promedio.

SELECT * FROM estudiante e WHERE edad > (SELECT AVG(edad) FROM estudiante);

# Listar los nombres de los estudiantes cuyo apellido comience con la letra G.

SELECT nombre FROM estudiante WHERE apellido LIKE 'G%';

# Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).

SELECT a.nombre FROM autor a
INNER JOIN libro_autor la ON a.id_autor = la.id_autor
INNER JOIN libro l ON la.id_libro = l.id_libro
WHERE l.titulo = 'El Universo: Guía de viaje';

# ¿Qué libros se prestaron al lector “Filippo Galli”?

SELECT * FROM libro l
JOIN prestamo p ON l.id_libro = p.id_libro
JOIN estudiante e ON p.id_lector = e.id_lector
WHERE e.nombre = 'Filippo' AND e.apellido = 'Galli';

# Listar el nombre del estudiante de menor edad.

SELECT nombre FROM estudiante ORDER BY edad LIMIT 1;

# Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.

SELECT nombre FROM estudiante e
JOIN prestamo p ON e.id_lector = p.id_lector
JOIN libro l ON p.id_libro = l.id_libro
WHERE l.area = 'Base de Datos';

# Listar los libros que pertenecen a la autora J.K. Rowling.

SELECT * FROM libro l
INNER JOIN libro_autor la ON l.id_libro = la.id_libro
INNER JOIN autor a ON la.id_autor = a.id_autor
WHERE a.nombre = 'J.K. Rowling';

# Listar títulos de los libros que debían devolverse el 16/07/2021.

SELECT l.titulo FROM libro l
JOIN prestamo p ON l.id_libro = p.id_libro
WHERE p.fecha_devolucion = '2021-07-16';
