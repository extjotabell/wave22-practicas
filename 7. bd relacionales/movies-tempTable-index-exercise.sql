create temporary table TWD
(
	id INT AUTO_INCREMENT PRIMARY KEY,
    episode_title varchar(50),
    season tinyint
);

insert into TWD (episode_title, season)
select episodes.title, seasons.number as season 
from episodes
inner join seasons on episodes.season_id = seasons.id
inner join series on seasons.serie_id = series.id
where series.title like "%The Walking Dead%";

select * from TWD;

create index title_index on movies(title);
# La razon de este index es que todos los ejercicios de esta database hasta ahora 
# incluyeron de alguna forma el titulo de las peliculas.

explain select movies.title from movies where movies.title like "%H%";

