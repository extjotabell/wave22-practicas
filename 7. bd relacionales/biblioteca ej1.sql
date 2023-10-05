# Listar los datos de los autores.
SELECT * FROM autor;

# Listar nombre y edad de los estudiantes
SELECT nombre, edad FROM estudiante;

# ¿Qué estudiantes pertenecen a la carrera informática?
SELECT * FROM estudiante WHERE carrera = "Informática";

# ¿Qué autores son de nacionalidad francesa o italiana?
SELECT * FROM autor WHERE nacionalidad LIKE "Franc%" OR nacionalidad LIKE "Italian%";

# ¿Qué libros no son del área de internet?
SELECT * FROM libro WHERE area <> "Internet";

# Listar los libros de la editorial Salamandra.
SELECT * FROM libro WHERE editorial = "Salamandra";

# Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT * FROM estudiante e WHERE edad > (SELECT AVG(edad) FROM estudiante);

# Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT nombre FROM estudiante WHERE apellido LIKE "G%";

# Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT a.nombre FROM autor a
INNER JOIN libro_autor la ON a.id_autor = la.id_autor
INNER JOIN libro l ON la.id_libro = l.id_libro
WHERE l.titulo = "El Universo: Guía de viaje";

# ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT * FROM libro l
JOIN prestamo p ON l.id_libro = p.id_libro
JOIN estudiante e ON p.id_lector = e.id_lector
WHERE e.nombre = "Filippo" AND e.apellido = "Galli";

# Listar el nombre del estudiante de menor edad.
SELECT nombre FROM estudiante ORDER BY edad LIMIT 1;

# Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT nombre FROM estudiante e
JOIN prestamo p ON e.id_lector = p.id_lector
JOIN libro l ON p.id_libro = l.id_libro
WHERE l.area = "Base de Datos";

# Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT * FROM libro l
INNER JOIN libro_autor la ON l.id_libro = la.id_libro
INNER JOIN autor a ON la.id_autor = a.id_autor
WHERE a.nombre = "J.K. Rowling";

# Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT l.titulo FROM libro l
JOIN prestamo p ON l.id_libro = p.id_libro
WHERE p.fecha_devolucion = "2021-07-16";