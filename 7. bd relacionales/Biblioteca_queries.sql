use biblioteca;

# Listar los datos de los autores.
select * from autor;

# Listar nombre y edad de los estudiantes
select nombre, edad from estudiante;

# ¿Qué estudiantes pertenecen a la carrera informática?
select nombre, apellido from estudiante where carrera = "Informatica";

# ¿Qué autores son de nacionalidad francesa o italiana?
select nombre, apellido from autor where nacionalidad like "Italian%" or nacionalidad like "France%";

# ¿Qué libros no son del área de internet?
select titulo from libro where area not like "Internet";

# Listar los libros de la editorial Salamandra
select titulo from libro where editorial = "Salamandra";

# Listar los datos de los estudiantes cuya edad es mayor al promedio.
select * from estudiante where edad >= (select avg(edad) from estudiante);

# Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
select nombre from estudiantes where apellido like "G%";

# Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
select autor.nombre from autor 
inner join libro_autor on autor.id = libro_autor.idAutor
inner join libro on libro_autor.idLibro = libro.id
where libro.titulo = "El Universo: Guía de viaje";

# ¿Qué libros se prestaron al lector “Filippo Galli”?
select titulo from libro
inner join prestamo on libro.idLibro = prestamo.idLibro
inner join estudiante on prestamo.idLector = estudiante.idLector
where estudiante.nombre = "Filippo" and estudiante.apellido = "Galli";

# Listar el nombre del estudiante de menor edad.
select nombre from estudiante order by edad limit 1;

# Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
select distinct estudiante.nombre from estudiante
inner join prestamo on prestamo.idLector = estudiante.id;

# Listar los libros que pertenecen a la autora J.K. Rowling.
select titulo from libro
inner join libro_autor on libro.id = libro_autor.idLibro
inner join autor on libro_autor.idAutor = autor.id
where autor.nombre = "J.K. Rowling";

# Listar títulos de los libros que debían devolverse el 16/07/2021.
select titulo from libro
inner join prestamo on prestamo.idLibro = libro.id
where prestamo.fecha_devolucion = "16-07-2021";
