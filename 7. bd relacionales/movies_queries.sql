Select * from movies;
Select first_name, last_name, rating from actors;
Select title as "titulo" from series;
Select first_name, last_name from actors where rating > 7.5;
Select title, rating, awards from movies where rating > 7.5 and awards > 2;
Select title, rating from movies order by rating asc;
Select title from movies limit 3;
Select title, rating from movies order by rating desc limit 5;
Select * from actors limit 10;
Select title, rating from movies where title like "%Toy Story%";
Select * from actors where first_name like "Sam%";
Select title, rating from movies where rating > 3 and awards > 1 and release_date between "1988-01-01" and "2009-12-31" order by rating;
