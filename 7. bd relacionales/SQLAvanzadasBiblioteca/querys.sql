/*Listar los datos de los autores.*/
select nombre , nacionalidad from autor;

/*Listar nombre y edad de los estudiantes*/
select nombre, edad from estudiante;

/*¿Qué estudiantes pertenecen a la carrera informática?*/
select * from estudiante
where carrera like 'IT';
/*¿Qué autores son de nacionalidad francesa o italiana?*/
select * from autor 
where nacionalidad in ('francesa', 'italiana');
/*¿Qué libros no son del área de internet?*/
select * from libro where area not like 'internet';
/*Listar los libros de la editorial Salamandra.*/
select * from libro where editorial like 'Salamandra';
/*Listar los datos de los estudiantes cuya edad es mayor al promedio.*/
set @edadPromedio = (select round(avg(edad),0) from estudiante);
select * from estudiante where edad > @edadPromedio;

/*Listar los nombres de los estudiantes cuyo apellido comience con la letra G.*/
select nombre, apellido from estudiante where apellido like 'G%';

/*Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).*/
select a.nombre from autor a
inner join libroAutor la on la.idAutor = a.idAutor
inner join libro l on la.idLibro = l.idLibro         
where titulo like 'El Universo: Guía de viaje';

/*¿Qué libros se prestaron al lector “Filippo Galli”?*/
select titulo from estudiante e
inner join prestamos p on e.idLector = p.idLector
inner join libro l on l.idLibro = p.idLibro
where nombre like 'Filippo' and apellido like 'Galli';

/*Listar el nombre del estudiante de menor edad.*/
set @menorEdad = (select min(edad) from estudiante);
select nombre, apellido, edad from estudiante where edad = @menorEdad;

/*Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.*/
select  distinct nombre , apellido from estudiante e
inner join prestamos p on e.idLector = p.idLector;

/*Listar los libros que pertenecen a la autora J.K. Rowling.*/
select l.titulo from autor a
inner join libroAutor la on la.idAutor = a.idAutor
inner join libro l on la.idLibro = l.idLibro       
where nombre like 'J.K. Rowling';

/*Listar títulos de los libros que debían devolverse el 16/07/2023.*/
select titulo from prestamos p
inner join libro l on l.idLibro = p.idLibro
where Convert(fechaDevolucion,DATE) = '2023-07-16'