/*1. Ver todos los datos del clientes*/
select dni, c.nombre , apellido , fecha_nacimiento
from cliente;


/*2. Descuento por cliente */
select c.nombre , apellido , precio, descuento ,
round(precio - (precio*(descuento/100)),2) as precio_total
from cliente c
inner join pack p on p.id_pack = c.id_pack;

/*3. Localidad y provincia por cliente*/
select   c.nombre , apellido , l.nombre as localidad , p.nombre as provincia
from cliente c 
inner join localidad l on l.id_localidad = c.id_localidad
inner join provincia p on p.id_provincia = l.id_provincia;

/*4. Los megas por cliente */
select c.nombre , apellido , mega
from cliente c
inner join pack p on p.id_pack = c.id_pack;


/*5. Todos los pack internet */
select * from pack;

/*6. Todas las localidades con su provincia */
select l.nombre as localidad , p.nombre as provincia
from localidad l
inner join provincia p on p.id_provincia = l.id_provincia;

/*7. Asociar toda lo que contenga la tabla cliente */
select   c.nombre , apellido ,mega , precio , descuento,  l.nombre as localidad , pv.nombre as provincia
from cliente c 
inner join pack p on p.id_pack = c.id_pack
inner join localidad l on l.id_localidad = c.id_localidad
inner join provincia pv on pv.id_provincia = l.id_provincia;
 
 /*8. Cliente que comiencen con la palabra MA*/
select dni, nombre , apellido
from cliente
where nombre like 'MA%';

 /*9. Cliente tengan el pack 200*/
select c.nombre , apellido , mega
from cliente c
inner join pack p on p.id_pack = c.id_pack
where mega = 200;


/*10 cantidad de cliente por pack */
select  mega , count(id_cliente) as cantidad_cliente
from cliente c
inner join pack p on p.id_pack = c.id_pack
group by mega



