/*Listar los datos de los autores.*/
select * from autor;

/*Listar nombre y edad de los estudiantes*/
select nombre, edad from estudiantes;

/*¿Qué estudiantes pertenecen a la carrera informática?*/
select * from estudiantes where carrera like "%informatica%";

/*¿Qué autores son de nacionalidad francesa o italiana?*/
select * from autor where nacionalidad = "Francesa" or nacionalidad = "Italiana";

/*¿Qué libros no son del área de internet?*/
select * from libros where area != "internet";

/*Listar los libros de la editorial Salamandra.*/
select * from libros where editorial = "Salamanca";

/*Listar los datos de los estudiantes cuya edad es mayor al promedio.*/
select * from estudiantes where edad > (select avg(edad) from estudiantes);

/*Listar los nombres de los estudiantes cuyo apellido comience con la letra G.*/
select * from estudiantes where apellido like "G%";

/*Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).*/
select name 
from autor
inner join libroautor on autor.id = libroautor.idAutor
inner join libro on libroautor.idLibro = libro.idLibro
where libro.titulo = "El Universo: Guía de viaje";

/*¿Qué libros se prestaron al lector “Filippo Galli”?*/
select l.titulo
from libro l
inner join prestamo p on l.id = p.idLibro
inner join estudiante e on p.idLector = e.idLector
where e.nombre = "Filippo Galli";

/*Listar el nombre del estudiante de menor edad.*/
select name
from estudiantes
where edad = (select min(edad) from estudiantes);

/*Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.*/
select e.name
from estudiantes e
inner join prestamo p on e.idLector = p.idLector
inner join libro l on p.idLibro = l.idLibro
where l.area = "Base de datos";

/*Listar los libros que pertenecen a la autora J.K. Rowling.*/
select * 
from libros l 
inner join libroautor la on l.idLibro = la.idLibro
inner join autor a on la.idAutor = a.idAutor
where a.name = "J.K. Rowling";

/*Listar títulos de los libros que debían devolverse el 16/07/2021.*/
select l.titulo
from libros l
inner join prestamo p on l.idLibro = p.idLibro
where p.fechaDevolucion = "2021-07-16";




