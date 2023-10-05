####### ESTUDIANTES
INSERT INTO `biblioteca_db`.`estudiante`
(`nombre`,`apellido`,`direccion`,`carrera`,`edad`) 
VALUES( "camila", "lemos", "algun lugar en el mundo 245", "MATEMATICAS", 27);

INSERT INTO `biblioteca_db`.`estudiante`
(`nombre`,`apellido`,`direccion`,`carrera`,`edad`) 
VALUES( "Julio", "alvarez", "algun lugar en el mundo 245", "INFORMATICA", 24);

INSERT INTO `biblioteca_db`.`estudiante`
(`nombre`,`apellido`,`direccion`,`carrera`,`edad`) 
VALUES( "Luciana", "Pio", "algun lugar en el mundo 245", "INFORMATICA", 23);

INSERT INTO `biblioteca_db`.`estudiante`
(`nombre`,`apellido`,`direccion`,`carrera`,`edad`) 
VALUES( "Rodrigo", "Baliani", "algun lugar en el mundo 245", "LENGUA", 28);

INSERT INTO `biblioteca_db`.`estudiante`
(`nombre`,`apellido`,`direccion`,`carrera`,`edad`) 
VALUES( "Mateo", "Giovanni", "algun lugar en el mundo 245", "LENGUA", 43);

INSERT INTO `biblioteca_db`.`estudiante`
(`nombre`,`apellido`,`direccion`,`carrera`,`edad`) 
VALUES( "Gino", "Gonzalez", "algun lugar en el mundo 245", "INFORMATICA", 20);

######## AUTORES
INSERT INTO `biblioteca_db`.`autor`
(`nombre`, `nacionalidad`) VALUES ("Camus Albert","FRANCES");

INSERT INTO `biblioteca_db`.`autor`
(`nombre`, `nacionalidad`) VALUES ("Jorge Luis Borges","ARGENTINO");

INSERT INTO `biblioteca_db`.`autor`
(`nombre`, `nacionalidad`) VALUES ("Dante Alighieri","ITALIANO");

INSERT INTO `biblioteca_db`.`autor`
(`nombre`, `nacionalidad`) VALUES ("Italo Calvino","ITALIANO");

INSERT INTO `biblioteca_db`.`autor`
(`nombre`, `nacionalidad`) VALUES ("Jorge Amado","BRASILEÑO");

INSERT INTO `biblioteca_db`.`autor`
(`nombre`, `nacionalidad`) VALUES ("Suzanne Collins","ESTADOUNIDENSE");

INSERT INTO `biblioteca_db`.`autor`
(`nombre`, `nacionalidad`) VALUES ("Mark Mackenzie","ESTADOUNIDENSE");

INSERT INTO `biblioteca_db`.`autor`
(`nombre`, `nacionalidad`) VALUES ("Valerie Stimac","ESTADOUNIDENSE");

INSERT INTO `biblioteca_db`.`autor`
(`nombre`, `nacionalidad`) VALUES ("Mark A Garlick","BRITÁNICO");

INSERT INTO `biblioteca_db`.`autor`
(`nombre`, `nacionalidad`) VALUES ("Oliver Berry","BRITÁNICO");

INSERT INTO `biblioteca_db`.`autor`
(`nombre`, `nacionalidad`) VALUES ("Filippo Galli","ITALIANO");

INSERT INTO `biblioteca_db`.`autor`
(`nombre`, `nacionalidad`) VALUES ("J.K. Rowling","BRITÁNICA");

INSERT INTO `biblioteca_db`.`autor`
(`nombre`, `nacionalidad`) VALUES ("Ramez Elmasri","ESTADOUNIDENSE");


######## LIBROS

INSERT INTO `biblioteca_db`.`libro` (`titulo`,`editorial`,`area`)
VALUES ("La peste","Alianza", "INTERNET");

INSERT INTO `biblioteca_db`.`libro` (`titulo`,`editorial`,`area`)
VALUES ("Ficciones completas","Otra", "FISICO");

INSERT INTO `biblioteca_db`.`libro` (`titulo`,`editorial`,`area`)
VALUES ("Divina Comedia","Alianza", "INTERNET");

INSERT INTO `biblioteca_db`.`libro` (`titulo`,`editorial`,`area`)
VALUES ("Las ciudades invisibles","Ciruela", "FISICO");

INSERT INTO `biblioteca_db`.`libro` (`titulo`,`editorial`,`area`)
VALUES ("Gabriela, clavo y canela","Planeta", "FISICO");

INSERT INTO `biblioteca_db`.`libro` (`titulo`,`editorial`,`area`)
VALUES ("Sinsajo","Salamandra", "FISICO");

INSERT INTO `biblioteca_db`.`libro` (`titulo`,`editorial`,`area`)
VALUES ("En llamas","Salamandra", "FISICO");

INSERT INTO `biblioteca_db`.`libro` (`titulo`,`editorial`,`area`)
VALUES ("Los juegos del hambre","Salamandra", "FISICO");

INSERT INTO `biblioteca_db`.`libro` (`titulo`,`editorial`,`area`)
VALUES ("El Universo: Guía de viaje","GeoPlaneta", "INTERNET");

INSERT INTO `biblioteca_db`.`libro` (`titulo`,`editorial`,`area`)
VALUES ("Idade Média Explorações, Comércio e Utopias","Leya", "FISICO");

INSERT INTO `biblioteca_db`.`libro` (`titulo`,`editorial`,`area`)
VALUES ("Harry Potter y la piedra filosofal" ,"Salamandra", "FISICO");

INSERT INTO `biblioteca_db`.`libro` (`titulo`,`editorial`,`area`)
VALUES ("Fundamentos de Bases de Datos" ,"Pearson", "INTERNET");


######## LIBRO_AUTOR

INSERT INTO `biblioteca_db`.`libro_autor` (`id_autor`,`id_libro`) VALUES(1,1);
INSERT INTO `biblioteca_db`.`libro_autor` (`id_autor`,`id_libro`) VALUES(2,2);
INSERT INTO `biblioteca_db`.`libro_autor` (`id_autor`,`id_libro`) VALUES(3,3);
INSERT INTO `biblioteca_db`.`libro_autor` (`id_autor`,`id_libro`) VALUES(4,4);
INSERT INTO `biblioteca_db`.`libro_autor` (`id_autor`,`id_libro`) VALUES(5,5);
INSERT INTO `biblioteca_db`.`libro_autor` (`id_autor`,`id_libro`) VALUES(6,6);
INSERT INTO `biblioteca_db`.`libro_autor` (`id_autor`,`id_libro`) VALUES(6,7);
INSERT INTO `biblioteca_db`.`libro_autor` (`id_autor`,`id_libro`) VALUES(6,8);
INSERT INTO `biblioteca_db`.`libro_autor` (`id_autor`,`id_libro`) VALUES(7,9);
INSERT INTO `biblioteca_db`.`libro_autor` (`id_autor`,`id_libro`) VALUES(8,9);
INSERT INTO `biblioteca_db`.`libro_autor` (`id_autor`,`id_libro`) VALUES(9,9);
INSERT INTO `biblioteca_db`.`libro_autor` (`id_autor`,`id_libro`) VALUES(10,9);
INSERT INTO `biblioteca_db`.`libro_autor` (`id_autor`,`id_libro`) VALUES(11,11);
INSERT INTO `biblioteca_db`.`libro_autor` (`id_autor`,`id_libro`) VALUES(12,12);
INSERT INTO `biblioteca_db`.`libro_autor` (`id_autor`,`id_libro`) VALUES(13,13);

######## PRESTAMO

INSERT INTO `biblioteca_db`.`prestamo`
(`id_lector`, `id_libro`, `fecha_prestamo`, `fecha_devolucion`, `devuelto`)
VALUES (2, 13, "2021-05-16","2021-07-16",1);

INSERT INTO `biblioteca_db`.`prestamo`
(`id_lector`, `id_libro`, `fecha_prestamo`, `fecha_devolucion`, `devuelto`)
VALUES (3, 13, "2022-02-06","2022-04-06",0);

INSERT INTO `biblioteca_db`.`prestamo`
(`id_lector`, `id_libro`, `fecha_prestamo`, `fecha_devolucion`, `devuelto`)
VALUES (8, 13, "2021-05-10","2021-07-16",1);

INSERT INTO `biblioteca_db`.`prestamo`
(`id_lector`, `id_libro`, `fecha_prestamo`, `fecha_devolucion`, `devuelto`)
VALUES (4, 1, "2023-09-07","2023-10-09",1);

INSERT INTO `biblioteca_db`.`prestamo`
(`id_lector`, `id_libro`, `fecha_prestamo`, `fecha_devolucion`, `devuelto`)
VALUES (5, 3, "2021-07-20","2021-08-21",1);



# 1.Listar los datos de los autores.
SELECT *
FROM biblioteca_db.autor;

# 2.Listar nombre y edad de los estudiantes
SELECT e.nombre, e.edad 
FROM biblioteca_db.estudiante e;

# 3.¿Qué estudiantes pertenecen a la carrera informática?
SELECT *
FROM biblioteca_db.estudiante e
WHERE e.carrera LIKE "%INFORMATICA%";

# 4.¿Qué autores son de nacionalidad francesa o italiana?
SELECT *
FROM biblioteca_db.autor a
WHERE a.nacionalidad in ("FRANCES", "ITALIANO");  

# 5.¿Qué libros no son del área de internet?
SELECT *
FROM biblioteca_db.libro l
WHERE l.area NOT LIKE "INTERNET";

# 6.Listar los libros de la editorial Salamandra.
SELECT *
FROM biblioteca_db.libro l
WHERE l.editorial like "%Salamandra%";

# 7.Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT *
FROM biblioteca_db.estudiante
WHERE edad > (SELECT AVG(edad) FROM biblioteca_db.estudiante);

# 8.Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT e.*
FROM biblioteca_db.estudiante e
WHERE e.apellido LIKE "G%";

# 9.Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres). 
SELECT a.nombre
FROM biblioteca_db.libro_autor la
INNER JOIN biblioteca_db.libro l ON l.id_libro = la.id_libro AND l.titulo = "El Universo: Guía de viaje"
INNER JOIN biblioteca_db.autor a ON a.id_autor = la.id_autor ;

# 10.¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT l.*
FROM biblioteca_db.libro l 
INNER JOIN biblioteca_db.libro_autor la ON la.id_libro = l.id_libro
INNER JOIN biblioteca_db.autor a ON (a.id_autor = la.id_autor) AND (a.nombre LIKE "Filippo Galli");

# 11.Listar el nombre del estudiante de menor edad.
SELECT e.nombre 
FROM biblioteca_db.estudiante e
ORDER BY edad
LIMIT 1;

# 12.Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT e.nombre
FROM biblioteca_db.libro l 
INNER JOIN biblioteca_db.estudiante e 
INNER JOIN biblioteca_db.prestamo p ON p.id_libro = l.id_libro and p.id_lector = e.id_lector
WHERE l.titulo LIKE "%Bases de Datos%";


# 13.Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.*
FROM biblioteca_db.autor a 
INNER JOIN biblioteca_db.libro_autor la ON la.id_autor= a.id_autor
INNER JOIN biblioteca_db.libro l ON l.id_libro =la.id_libro
WHERE a.nombre LIKE "%J.K. Rowling%";

# 14.Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT distinct l.titulo
FROM biblioteca_db.prestamo p
INNER JOIN biblioteca_db.libro l ON l.id_libro = p.id_libro
WHERE p.fecha_devolucion = "2021-07-16"














