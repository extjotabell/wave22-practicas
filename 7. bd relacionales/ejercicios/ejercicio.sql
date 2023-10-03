create temporary table TWD(
select e.title from episodes e
inner join seasons sea on e.season_id = sea.id
inner join series se on sea.serie_id = se.id
where se.title like "The Walking Dead"
);
​
select * from TWD;
​
create index series_index on series (release_date);
​
explain select * from series where release_date = '2011-01-01 00:00:00';