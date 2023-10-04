select * from client;
/* 1 Todos los clientes de ny*/
Select first_name, last_name from Client 
where province = "New York";

/* 2 nombre de los clientes y el plan que tienen */
Select first_name, last_name, p.name from Client c
inner join plan p on p.id = c.plan_id;

/* 3 el precio, el descuento y el precio con el descuento aplicado de los planes */
select name, price, discount, (price*(1-discount)) as discounted_price from plan;

/* 4 similar al 3 con el precio con descuento menor a 5000*/
select price, discount, (price*(1-discount)) as discounted_price from plan
having discounted_price < 5000;

/* 5 cuando arme los wifi plans solo puse 3 y despues vi que la consigna era 5 asi que agregué dos mas*/
insert into plan (name, speed, price, discount) values
("exclusive", "1000MB", 10000.0, 0.25),
("new customer", "250MB", 5200.0, 0.1);

/* 6 Los planes con velocidad mayor a 250 megas*/
select name, price*(1-discount) as discounted_price from plan
where cast(trim('MB' from speed) as signed)  > 250 ;

/* 7 Los clientes mayores a 25 años */
select first_name, last_name, plan_id from client
where YEAR(curdate()) - YEAR(DATE(birth_date))  >= 25;

/* 8 la cantidad de clientes que tienen contratado cada plan */
select p.name, count(c.id) as cantidad_de_Clientes from client c
inner join plan p on p.id = c.plan_id
group by p.name;

/* 9 trae el nombre de los planes que tengan un descuento mayor o igual al 10% */
select name from plan where discount >=0.10;

/* 10 trae nombre y apellido de los clientes que tienen el plan PRO*/
Select first_name, last_name from Client c
inner join plan p on p.id = c.plan_id
where p.name = "PRO";

