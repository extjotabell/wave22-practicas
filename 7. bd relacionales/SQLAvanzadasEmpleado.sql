create temporary table empleado (
cod_emp varchar(10) ,
nombre varchar(50),
apellido varchar(50),
puesto varchar(50),
fecha_alta datetime,
salario decimal (8,2),
comision decimal(8,2),
depto_nro varchar(50));
 

create temporary table departamento (
depto_nro varchar(10) ,
nombre_depto varchar(50),
localidad varchar(50));


insert into empleado
select 'E-0001','César','Piñero','Vendedor','20180512',80000,15000,'D-000-4' union 
select 'E-0002','Yosep','Kowaleski','Analista','20150714','140000','0','D-000-2'        union
select 'E-0003','Mariela','Barrios','Director','20140605','185000','0','D-000-3' union
select 'E-0004','Jonathan','Aguilera','Vendedor','20150603','85000','10000','D-000-4' union
select 'E-0005','Daniel','Brezezicki','Vendedor','20180303','83000','10000','D-000-4' union
select 'E-0006','Mito','Barchuk','Presidente','20140605','190000','0','D-000-3' union
select 'E-0007','Emilio','Galarza','Desarrollador','20140802','60000','0','D-000-1'  ;

insert into departamento 
select 'D-000-1','Software','Los Tigres'   union
select 'D-000-2','Sistemas','Guadalupe' union
select 'D-000-3','Contabilidad','La Roca' union
select 'D-000-4','Ventas','Plata';

/* Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.*/
 
 select nombre, apellido , puesto , localidad
from departamento d
inner join empleado e on d.depto_nro = e.depto_nro;


/* Visualizar los departamentos con más de cinco empleados.*/

select d.depto_nro, count(cod_emp) as cant_empleado from departamento d
inner join empleado e on d.depto_nro = e.depto_nro
group by d.depto_nro
having cant_empleado  >5;

/* Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.*/

SET @pestoMitoBarchuk = (select puesto from empleado 
						  where  nombre like 'Mito' 
						  and apellido like 'Barchuk');

select e.nombre , e.apellido ,salario , d.nombre_depto
from departamento d
inner join empleado e on d.depto_nro = e.depto_nro
where e.puesto = @pestoMitoBarchuk;

/* Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.*/

select e.*
from departamento d
inner join empleado e on d.depto_nro = e.depto_nro
where d.nombre_depto like 'Contabilidad'
order by nombre;

/* Mostrar el nombre del empleado que tiene el salario más bajo.*/
SET @salarioBajo =(select  min(salario) from empleado);

select nombre, apellido from empleado e
where salario = @salarioBajo;
 
/* Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.*/
SET @salarioAlto =(select Max(salario)
					from departamento d
					inner join empleado e on d.depto_nro = e.depto_nro
					where d.nombre_depto like 'Ventas');

select nombre, apellido from empleado e
where salario = @salarioAlto;

