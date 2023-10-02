#Consultas SQL Avanzadas - Parte 1 - PG - Ejercicios Prácticos: SQL Avanzado
SELECT s.title, g.name FROM series s left join genres g on s.genre_id =g.id;
SELECT e.title, a.first_name, a.last_name from ACTORS A INNER JOIN actor_episode AE on a.id = AE.actor_id join episodes E on AE.episode_id = E.id;
SELECT s.title, COUNT(se.id) as 'Cantidad temporadas' from SERIES S inner join SEASONS SE on S.id = SE.serie_id GROUP BY s.id;
SELECT G.name, count(g.name) from GENRES G INNER JOIN MOVIES M on g.id = m.genre_id group by g.name having count(g.name)>=3;
SELECT distinct a.first_name, A.last_name from actors a join actor_movie AM on a.id = AM.actor_id join movies M on AM.movie_id = M.id where M.title like "%Guerra de las galaxias%";

SELECT A.* from autor a; #1
SELECT e.nombre, e.edad from estudiante e; #2
SELECT e.* FROM estudiante e where e.carrera like "Informatica"; #3
SELECT a.* FROM autor a where a.nacionalidad like "Francesa" or a.nacionalidad like "Italiana"; #4
SELECT l.* FROM libro l where l.area not like "internet"; #5
SELECT l.* FROM libro l where .editorial like "Salamandra"; #6
SELECT e.* FROM estudiante e where e.edad > (SELECT AVG(e.edad) from estudiante e); #7
SELECT e.nombre FROM estudiante e where e.apellido like "G%"; #8
SELECT a.nombre FROM autor a #9
JOIN libroautor la on a.idAutor = la.idAutor 
JOIN libro l on la.idLibro = l.idLibro where l.titulo like "El Universo: Guía de viaje";
SELECT l.* FROM libro l #10
JOIN prestamo p on l.idLibro = p.idLibro 
JOIN estudiante e on p.idLector = e.idLector WHERE e.nombre like "Filippo" and e.apellido like "Galli";
SELECT e.nombre FROM estudiante e where e.edad=(SELECT MIN(e.edad) FROM estudiante e); #11
SELECT e.nombre FROM estudiante e ORDER BY e.edad ASC LIMIT 1; #11
SELECT e.nombre FROM estudiante e join prestamo p on e.idLector = p.idLector join libro l on p.idLibro = l.idLibro WHERE l.area like "Base de Datos"; #12
SELECT l.* FROM libro l join libroautor la on l.idLibro = la.idLibro join autor a on la.idAutor = a.idAutor WHERE a.nombre like "J.K. Rowling"; #13
SELECT l.titulo FROM libro l join prestamo p on l.idLibro = p.idLibro where p.fechaDevolucion = '16/07/2021'; #14