USE movies_db;

/* 1 */

SELECT series.title AS titulo, genres.name AS genero FROM series
INNER JOIN genres ON series.genre_id = genres.id;

/* 2 */

SELECT title, first_name, last_name from episodes ep join actor_episode aep on ep.id = aep.episode_id join actors a on aep.actor_id = a.id;

/* 3 */

select series.title, count(seasons.id) from series join seasons on series.id = seasons.serie_id group by series.id;

/* 4 */
select genres.name, count(movies.id) as movie_amount from genres join movies on genres.id = movies.genre_id
group by genres.name having movie_amount >= 3;

/* 5 */

