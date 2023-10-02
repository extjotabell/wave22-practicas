#1
select title, name from series join genres on series.genre_id = genres.id;
#2
select title, first_name, last_name from episodes ep join actor_episode aep on ep.id = aep.episode_id join actors a on aep.actor_id = a.id;
#3
select series.title, count(seasons.id) from series join seasons on series.id = seasons.serie_id group by series.id; 
#4
select genres.name, count(movies.id) as movie_amount from genres join movies on genres.id = movies.genre_id
group by genres.id having movie_amount >= 3;
#5
select a.first_name, a.last_name, count(a.id) as number_movies from actors a 
	join actor_movie am on a.id = am.actor_id 
	join movies m on am.movie_id = m.id
    where m.title like "La Guerra de las galaxias%"
    group by a.id having number_movies = 
    (select count(movies.id) from movies where title like "La Guerra de las galaxias%");
    