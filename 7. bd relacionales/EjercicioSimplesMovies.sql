USE movies_db

/*1*/
Select * from movies
/*2*/
Select first_name, last_name, rating from actors
/*3*/
Select title as titulo from movies as peliculas
/*4*/
Select first_name, last_name, rating from actors where rating > 7.5
/*5*/
Select title, rating, awards from movies where rating > 7.5 and awards > 2 
/*6*/
Select title, rating from movies 
order by title asc
/*7*/
Select title from movies limit 3
/*8*/
Select title,rating from movies 
group by title
order by rating desc 
limit 5
/*9*/
Select * from actors limit 10
/*10*/
Select title, rating from movies where title = 'Toy Story'
/*11*/
Select * from actors where first_name like 'Sam%'
/*12*/ 
Select * from movies where YEAR(release_date) between 2004 and 2008
/*12*/
Select * from movies where rating > 3 and awards > 1 and YEAR(release_date) between 1988 and 2009
order by rating desc


