/*Mostrar el título y el nombre del género de todas las series.*/
select title, genres.name 
from movies 
inner join genres on genres.id = movies.genre_id;

/*Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.*/
select title, actors.first_name, actors.last_name
from episodes
inner join actor_episode on actor_episode.episode_id = episodes.id
inner join actors on actors.id = actor_episode.actor_id
group by title,actors.first_name,actors.last_name;

/*Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.*/
select se.title, count(sea.id)
from series se
inner join seasons sea on sea.serie_id = se.id
group by se.title;

/*Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.*/
select g.name, count(mo.title)
from genres g
inner join movies mo on mo.genre_id = g.id
group by g.name having count(mo.title) >= 3;

/*Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.*/
select distinct a.first_name, a.last_name
from actors a
inner join actor_movie am on am.actor_id = a.id
inner join movies mo on am.movie_id = mo.id
where mo.title like "%La guerra de las galaxias%";

