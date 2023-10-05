select * from empleado;
INSERT INTO empleado VALUES(1, "E-0001" ,"Cesar", "Piñero", "Vendedor", "2018-05-12 00:00:00", 8000, 150000, "D-000-4");
INSERT INTO empleado VALUES(2,"E-0003" , "Yosep", "Kowaleski", "Analista", "2015-07-14 00:00:00", 140000, 0, "D-000-2");
INSERT INTO empleado VALUES(3, "E-0003" ,"Mariela", "Barrios", "Director", "2014-06-05 00:00:00", 185000, 0, "D-000-3");
INSERT INTO empleado VALUES(5, "E-0004" ,"Jonathan", "Aguilera", "Vendedor", "2025-06-03 00:00:00", 85000, 10000, "D-000-4");
INSERT INTO empleado VALUES(6, "E-0005" ,"Daniel", "Brezezicki", "Vendedor", "2018-03-03 00:00:00", 35000, 10000, "D-000-4");
INSERT INTO empleado VALUES(7, "E-006" ,"Mito", "Barchuck", "Presidente", "2014-06-05 00:00:00", 190000, 0, "D-000-3");
INSERT INTO empleado VALUES(8, "E-0007" ,"Emilio", "Galarza", "Desarrollador", "2014-02-08 00:00:00", 60000, 0, "D-000-1");
INSERT INTO empleado VALUES(9, "E-0009" ,"Daniel", "Brezezicki", "Vendedor", "2018-03-03 00:00:00", 35000, 10000, "D-000-4");
INSERT INTO empleado VALUES(10, "E-0010" ,"Daniel", "Brezezicki", "Vendedor", "2018-03-03 00:00:00", 35000, 10000, "D-000-4");
INSERT INTO empleado VALUES(11, "E-0011" ,"Daniel", "Brezezicki", "Vendedor", "2018-03-03 00:00:00", 35000, 10000, "D-000-4");


INSERT INTO departamento VALUES(1, "D-000-1", "Software", "Los Tigres");
INSERT INTO departamento VALUES(2, "D-000-2", "Sistemas", "Guadalupe");
INSERT INTO departamento VALUES(3, "D-000-3", "Contabilidad", "La Roca");
INSERT INTO departamento VALUES(4, "D-000-4", "Ventas", "Plata");

/*Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.*/
SELECT empleado.nombre, departamento.nombre_depto, departamento.localidad FROM empleado
JOIN departamento ON empleado.depto_nro = departamento.depto_nro;

/*Visualizar los departamentos con más de cinco empleados.*/
SELECT departamento.nombre_depto, subconsulta.cantidad FROM departamento
JOIN (SELECT depto_nro, COUNT(*) AS cantidad 
FROM empleado
GROUP BY depto_nro
HAVING COUNT(*) > 5 ) subconsulta ON departamento.depto_nro = subconsulta.depto_nro;

/*Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.*/
SELECT emp.nombre, emp.salario, depto.nombre_depto FROM empleado emp
JOIN departamento depto ON depto.depto_nro = emp.depto_nro
WHERE emp.puesto = (SELECT puesto FROM empleado WHERE nombre LIKE 'Mito') AND apellido like 'Barchuck';

/*Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.*/
SELECT empleado.nombre, empleado.apellido, empleado.puesto, empleado.fecha_alta, empleado.salario from empleado
JOIN departamento ON departamento.depto_nro = empleado.depto_nro WHERE departamento.nombre_depto LIKE '%Contabilidad%' ORDER BY empleado.nombre;

/*Mostrar el nombre del empleado que tiene el salario más bajo.*/
SELECT nombre, apellido, salario FROM empleado ORDER BY salario ASC LIMIT 1;

/*Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.*/
SELECT * FROM empleado
JOIN departamento ON departamento.depto_nro = empleado.depto_nro WHERE departamento.nombre_depto LIKE '%Ventas%' ORDER BY empleado.salario DESC LIMIT 1;
