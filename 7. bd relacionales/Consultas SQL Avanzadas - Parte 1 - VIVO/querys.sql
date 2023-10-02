-- Listar los datos de los autores.

select * from autores;

-- Listar nombre y edad de los estudiantes

select nombre, edad from estudiantes;

-- ¿Qué estudiantes pertenecen a la carrera informática?

select * from estudiantes 
where carrera = "informatica";

-- ¿Qué autores son de nacionalidad francesa o italiana?

select * from autores 
where nacionalidad in ("francesa", "italiana");

-- ¿Qué libros no son del área de internet?

select * from libros 
where area != "Internet";

-- Listar los libros de la editorial Salamandra

select * from libros
where editorial = "Salamandra";

-- Listar los datos de los estudiantes cuya edad es mayor al promedio.

set @edad_promedio := (select avg(edad) from estudiantes);

select * from estudiantes 
where edad > @edad_promedio;

-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G

select * from estudiantes 
where apellido like "G%";

-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).

select autores.nombre from autores
join libro_autor on libro_autor.id_autor = autores.id
join libros on libro_autor.id_libro = libros.id
where libros.titulo = "El Universo: Guía de viaje";

-- ¿Qué libros se prestaron al lector “Filippo Galli”?

select libros.titulo from prestamos 
join libros on prestamos.id_libro = libros.id
join estudiantes on prestamos.id_lector = estudiantes.id_lector
where estudiantes.nombre = "Filippo" and estudiantes.apellido = "Galli";

-- Listar el nombre del estudiante de menor edad.

select * from estudiantes
where edad < 18;

-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.

select estudiantes.nombre from estudiantes
join prestamos on estudiantes.id_lector = prestamos.id_lector;

-- Listar los libros que pertenecen a la autora J.K. Rowling.

select libros.titulo from libros
join libro_autor on libros.id_libro = libro_autor.id_libro
join autores on autores.id_autor = libro_auto.id_autor
where autores.nombre = "J.K. Rowling";

-- Listar títulos de los libros que debían devolverse el 16/07/2021.

select libros.titulo from libros
join prestamos on prestamos.id_libro = libros.id_libro
where prestamos.fecha_devolucion <= '2021-07-16';




