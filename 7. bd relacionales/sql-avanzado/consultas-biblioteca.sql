-- 1 
SELECT * FROM autor;

-- 2
SELECT e.nombre, e.edad from estudiante e ;

-- 3
SELECT e.nombre, e.apellido, e.carrera from estudiante e where carrera = "Informática";

-- 4
SELECT a.nombre, a.nacionalidad from autor a where a.nacionalidad="Francesa" or a.nacionalidad="Italiana"

-- 5
SELECT l.titulo from libros l where l.area != "Internet";

-- 6
SELECT l.titulo, l.editorial from libros l where l.editorial = "Salamandra"

-- 7
-- SELECT AVG(x.edad) from estudiante x;
SELECT e.nombre, e.edad from estudiante e where edad > (SELECT AVG(x.edad) from estudiante x);

-- 8
SELECT e.apellido from estudiante e where e.apellido  LIKE "G%"

-- 9
select l.titulo, a.nombre as autor from libros l join libro_autor la on la.id_libro = l.id_libro JOIN autor a on a.id_autor = la.id_autor where l.titulo = "El Universo: Guía de viaje";

-- 10
SELECT l.titulo FROM estudiante e JOIN prestamo p ON p.id_lector = e.id_lector  JOIN libros l ON l.id_libro = p.id_libro WHERE e.nombre = "Filippo" AND e.apellido = "Galli";

-- 11
SELECT * from estudiante e where e.edad = (SELECT MIN(e2.edad) from estudiante e2) 

-- 12
SELECT l.titulo, l.editorial, l.AREA , e.nombre, e.apellido  from libros l join prestamo p ON p.id_libro = l.id_libro JOIN estudiante e ON e.id_lector = p.id_lector  where l.AREA = "Base de Datos";

-- 13 
SELECT l.titulo, a.nombre  from libros l JOIN libro_autor la on la.id_libro  = l.id_libro JOIN autor a ON la.id_autor = a.id_autor WHERE a.nombre ='J.K. Rowling';

-- 14
SELECT * from libros l JOIN prestamo p ON l.id_libro = p.id_libro WHERE p.fecha_devolucion = "2021-07-16"