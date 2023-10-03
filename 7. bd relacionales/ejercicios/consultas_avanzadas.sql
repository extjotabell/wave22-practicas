/* 1 Mostrar el título y el nombre del género de todas las series.*/
select title, g.name
from series s
         inner join genres g on s.genre_id = g.id;
/*2 Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.*/
select epi.title, a.first_name, a.last_name
from episodes epi
         inner join actor_episode ae on epi.id = ae.episode_id
         inner join actors a on a.id = ae.actor_id;
/*Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.*/
select s.title, count(se.number)
from series s
         inner join seasons se on s.id = se.serie_id
group by s.id;
/*Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.*/
select name, count(m.id) as count
from genres g
    inner join movies m
on g.id = m.genre_id
group by g.id
having count (m.id) >= 3;
/*Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan*/
select distinct first_name, last_name
from actors a
         inner join actor_movie am on a.id = am.actor_id
         inner join movies m on m.id = am.movie_id
where m.title like 'La Guerra de las galaxias%'