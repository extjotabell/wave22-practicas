create temporary table TWD(
select e.title from episodes e
inner join seasons sea on e.season_id = sea.id
inner join series se on sea.serie_id = se.id
where se.title like "The Walking Dead"
);

select * from TWD;

create index series_index on series (release_date);

explain select * from series where release_date = '2011-01-01 00:00:00';

/*Agregar una película a la tabla movies.*/
insert into movies (title,rating,awards, release_date,length,genre_id) values ("La sirenita",2.0,2,"2023-01-02",120,2);

/*Agregar un género a la tabla genres.*/
insert into genres (name,ranking,active) values ("Fantasia", 120,1);

/*Asociar a la película del punto 1. genre el género creado en el punto 2.*/
update movies set genre_id = 14 where id = 22;

/*Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.*/
update actors set favorite_movie_id = 22 where id = 1;

/*Crear una tabla temporal copia de la tabla movies.*/
create temporary table movies_temp (select * from movies);

/*Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.*/
delete from movies_temp where awards < 5;

/*Obtener la lista de todos los géneros que tengan al menos una película.*/
select distinct g.name 
from genres g
inner join movies m on g.id = m.genre_id;

/*Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.*/
select a.first_name, a.last_name
from actors a
inner join movies m on a.favorite_movie_id = m.id
where m.awards > 3;

/*Crear un índice sobre el nombre en la tabla movies.*/
create index movieName_index on movies (title);

