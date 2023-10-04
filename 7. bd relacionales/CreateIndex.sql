create temporary table TWD ( season varchar(500), episode varchar(500), number int ) ;

insert into TWD
select s.title , e.title , e.number from seasons s
inner join episodes e on s.id = e.season_id
inner join series se on se.id = s.serie_id
where upper(se.title) like 'THE WALKING DEAD';

select * from TWD;

 
select * from TWD where season like 'Primer Temporada';

create index first_name_index on actors (first_name);

show index from actors;
 
