SELECT * FROM movies_db.series;


-- Mostrar el título y el nombre del género de todas las series.

select title, name from series 
join genres on series.genre_id = genres.id; 

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.

select title, first_name, last_name  from actor_episode
join actors on actor_episode.actor_id = actors.id
join episodes on actor_episode.episode_id = episodes.id;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.

select series.title, count(*) as temporadas from seasons 
join series on seasons.serie_id = series.id
group by series.title;


-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.

set @cantidad_movies := (select count(*) from movies where title like "La guerra de las galaxias%");

select actors.first_name, actors.last_name, count(*) as cantidad from actors
join actor_movie on actors.id = actor_movie.actor_id
join movies on actor_movie.movie_id = movies.id
where movies.title like "La guerra de las galaxias%"
group by actors.first_name, actors.last_name
having cantidad >= @cantidad_movies;
