use biblio;

CREATE TABLE LIBRO (
  idLibro INT PRIMARY KEY,
  Titulo VARCHAR(255),
  Editorial VARCHAR(255),
  Area VARCHAR(255)
);
CREATE TABLE PRESTAMO (
  idPrestamo INT PRIMARY KEY,
  idLector INT,
  idLibro INT,
  FechaPrestamo DATE,
  FechaDevolucion DATE,
  Devuelto BOOLEAN,
  FOREIGN KEY (idLector) REFERENCES ESTUDIANTE(idLector),
  FOREIGN KEY (idLibro) REFERENCES LIBRO(idLibro)
);
CREATE TABLE ESTUDIANTE (
  idLector INT PRIMARY KEY,
  Nombre VARCHAR(255),
  Apellido VARCHAR(255),
  Direccion VARCHAR(255),
  Carrera VARCHAR(255),
  Edad INT
);
CREATE TABLE LIBROAUTOR (
  idAutor INT,
  idLibro INT,
  FOREIGN KEY (idAutor) REFERENCES AUTOR(idAutor),
  FOREIGN KEY (idLibro) REFERENCES LIBRO(idLibro),
  PRIMARY KEY (idAutor, idLibro)
);
CREATE TABLE AUTOR (
  idAutor INT PRIMARY KEY,
  Nombre VARCHAR(255),
  Nacionalidad VARCHAR(255)
);

-- Registros de prueba para la tabla LIBRO
INSERT INTO LIBRO (idLibro, Titulo, Editorial, Area) VALUES
(1, 'Harry Potter y la piedra filosofal', 'Salamandra', 'Fantasía'),
(2, '1984', 'Debolsillo', 'Ciencia ficción'),
(3, 'Cien años de soledad', 'Diana', 'Realismo mágico');
-- Registros de prueba para la tabla PRESTAMO
INSERT INTO PRESTAMO (idPrestamo, idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto) VALUES
(4, 4, 1, "2021-03-04", "2022-03-03" , true),
(1, 1, 1, '2021-01-01', '2021-01-15', true),
(2, 2, 2, '2021-02-01', '2021-02-15', true),
(3, 3, 3, '2021-03-01', '2021-03-15', true),
(5, 1, 2, '2021-07-01', '2021-07-16', false),
(6, 2, 3, '2021-07-02', '2021-07-16', false),
(7, 3, 1, '2021-07-03', '2021-07-16', false);

-- Registros de prueba para la tabla ESTUDIANTE
INSERT INTO ESTUDIANTE (idLector, Nombre, Apellido, Direccion, Carrera, Edad) VALUES
(4 , "Flippo" , "Galli" , "Calle 123" , "Informatica" , 21 ),
(1, 'Juan', 'Pérez', 'Calle Principal 123', 'Ingeniería', 20),
(2, 'María', 'Gómez', 'Avenida Central 456', 'Medicina', 22),
(3, 'Carlos', 'López', 'Calle Secundaria 789', 'Derecho', 21);
-- Registros de prueba para la tabla LIBROAUTOR
INSERT INTO LIBROAUTOR (idAutor, idLibro) VALUES
(3, 2),
(1, 1),
(2, 2),
(3, 3);
-- Registros de prueba para la tabla AUTOR
INSERT INTO AUTOR (idAutor, Nombre, Nacionalidad) VALUES
(1, 'J.K. Rowling', 'Británica'),
(2, 'George Orwell', 'Británico'),
(3, 'Gabriel García Márquez', 'Colombiano');

-- 1
select * from AUTOR;

-- 2
SELECT nombre , edad from ESTUDIANTE;

-- 3

SELECT * from ESTUDIANTE WHERE carrera = "Medicina";

-- 4

SELECT * FROM AUTOR WHERE nacionalidad = "Colombiano" or nacionalidad = "Británico";

-- 5

SELECT * FROM LIBRO WHERE Area != "Fantasía";

-- 6

SELECT * FROM LIBRO WHERE Editorial = "Salamandra";

-- 7

SELECT * FROM ESTUDIANTE WHERE edad > (SELECT avg(edad) from ESTUDIANTE);

-- 8

SELECT Nombre, Apellido FROM ESTUDIANTE WHERE Apellido LIKE "G%";

-- 9 

SELECT AUTOR.Nombre
FROM AUTOR
INNER JOIN LIBROAUTOR ON AUTOR.idAutor = LIBROAUTOR.idAutor
INNER JOIN LIBRO ON LIBRO.idLibro = LIBROAUTOR.idLibro
WHERE LIBRO.Titulo = '1984';

-- 10

SELECT LIBRO.Titulo
FROM LIBRO
INNER JOIN PRESTAMO ON LIBRO.idLibro = PRESTAMO.idLibro
INNER JOIN ESTUDIANTE ON PRESTAMO.idLector = ESTUDIANTE.idLector
WHERE ESTUDIANTE.Nombre = 'Filippo' AND ESTUDIANTE.Apellido = 'Galli';

-- 11

SELECT Nombre
FROM ESTUDIANTE
WHERE Edad = (SELECT MIN(Edad) FROM ESTUDIANTE);

-- 12

SELECT ESTUDIANTE.Nombre
FROM ESTUDIANTE
INNER JOIN PRESTAMO ON ESTUDIANTE.idLector = PRESTAMO.idLector
INNER JOIN LIBRO ON PRESTAMO.idLibro = LIBRO.idLibro
WHERE LIBRO.Area = 'Realismo mágico';

-- 13

SELECT LIBRO.Titulo
FROM LIBRO
INNER JOIN LIBROAUTOR ON LIBRO.idLibro = LIBROAUTOR.idLibro
INNER JOIN AUTOR ON LIBROAUTOR.idAutor = AUTOR.idAutor
WHERE AUTOR.Nombre = 'J.K. Rowling';

-- 14

SELECT LIBRO.Titulo
FROM LIBRO
INNER JOIN PRESTAMO ON LIBRO.idLibro = PRESTAMO.idLibro
WHERE PRESTAMO.FechaDevolucion = '2021-07-16';

