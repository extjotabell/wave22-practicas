/*Agregar una película a la tabla movies.*/
set @id = (select max(id) from movies) +1;
insert into movies (id, created_at, updated_at, title, rating, awards, release_date, length, genre_id)
select @id , now() , null , 'Titanic 2', 9.6, 2, 19980205 , 194, 3;
select * from movies;

/*Agregar un género a la tabla genres.*/
set @id = (select max(id) from genres) +1;
insert into genres 
select @id,now(), null, 'romantico',@id,1;

/*Asociar a la película del punto 1. genre el género creado en el punto 2.*/
set @id = (select id from genres where name like 'romantico') ;
update movies 
set genre_id = @id
where title like 'Titanic 2';

/*Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.*/
set @id = (select id from movies where title like 'Titanic 2');
update actors
set favorite_movie_id= @id 
where first_name like 'Leonardo' and last_name like 'Di Caprio';

/*Crear una tabla temporal copia de la tabla movies.*/
create temporary table movies_tmp 
select * from movies;
/*Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.*/
delete from movies_tmp where awards < 5;

/*Obtener la lista de todos los géneros que tengan al menos una película.*/
select distinct g.name from genres g
inner join movies m on g.id = m.genre_id;

/*Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.*/
select distinct first_name , last_name from actors a
inner join actor_movie am on a.id = am.actor_id 
inner join movies m on m.id = am.movie_id 
where awards > 3;

/*Crear un índice sobre el nombre en la tabla movies.*/
create index index_title on movies (title);

/*Chequee que el índice fue creado correctamente.*/
show index from movies;
