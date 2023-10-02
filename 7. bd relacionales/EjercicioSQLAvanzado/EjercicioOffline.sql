#1
select s.title as titulo,  g.name as genero
from series s inner join genres g 
on s.genre_id = g.id;


#2
select e.title as titulo, a.first_name as nombre, a.last_name as apellido
from episodes e
inner join actor_episode ae on e.id = ae.episode_id
inner join actors a on ae.actor_id = a.id;


#3
select s.title as titulo, count(s.title) as cantidad
from series s 
inner join seasons se on s.id = se.serie_id
group by s.title;

#4
select g.name, count(g.name) as cantidad 
from genres g
inner join movies m on g.id = m.genre_id
group by g.name
having cantidad >= 3

#5

