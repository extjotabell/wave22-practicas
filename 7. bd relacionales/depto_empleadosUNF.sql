INSERT INTO departamentos(depto_nro, nombre_depto, localidad) VALUES("D-000-1", "Software", "Los Tigres");
INSERT INTO departamentos(depto_nro, nombre_depto, localidad) VALUES("D-000-2", "Sistemas", "Guadalupe");
INSERT INTO departamentos(depto_nro, nombre_depto, localidad) VALUES("D-000-3", "Contabilidad", "La Roca");
INSERT INTO departamentos(depto_nro, nombre_depto, localidad) VALUES("D-000-4", "Ventas", "Plata");

SELECT * FROM departamentos;

INSERT INTO empleados(cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) VALUES("E-0001", "César", "Piñero", "Vendedor", "2015-05-12", 80000, 15000, "D-000-4");
INSERT INTO empleados(cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) VALUES("E-0002", "Yosep", "Kowaleski", "Analista", "2015-05-12", 140000, 0, "D-000-2");
INSERT INTO empleados(cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) VALUES("E-0003", "Mariela", "Barrios", "Directo", "2014-05-12", 80000, 0, "D-000-3");
INSERT INTO empleados(cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) VALUES("E-0004", "Jonathan", "Aguilera", "Vendedor", "2015-05-12", 80000, 10000, "D-000-4");
INSERT INTO empleados(cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) VALUES("E-0005", "Daniel", "Brezezick", "Vendedor", "2018-05-12", 80000, 10000, "D-000-4");
INSERT INTO empleados(cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) VALUES("E-0006", "Mito", "Barchuk", "Presidente", "2015-05-12", 80000, 0, "D-000-3");
INSERT INTO empleados(cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) VALUES("E-0007", "Emilio", "Galarza", "Desarrollador", "2014-05-12", 80000, 0, "D-000-1");

SELECT * FROM empleados;

#Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT emp.nombre, emp.puesto, dep.localidad FROM empleados emp INNER JOIN departamentos dep ON emp.depto_nro = dep.depto_nro WHERE puesto="Vendedor";

#Visualizar los departamentos con más de cinco empleados.
SELECT * FROM departamentos dep INNER JOIN empleados emp ON emp.depto_nro = dep.depto_nro GROUP BY dep.depto_nro, dep.nombre_depto, dep.localidad HAVING count(emp.cod_emp) > 5;

#Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.

#Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.

#Mostrar el nombre del empleado que tiene el salario más bajo.

#Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
