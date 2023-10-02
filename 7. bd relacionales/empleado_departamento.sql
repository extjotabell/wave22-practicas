# Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.

SELECT e.nombre, e.puesto, d.localidad FROM empleado e
JOIN departamento d ON e.depto_nro = d.depto_nro;

# Visualizar los departamentos con más de cinco empleados.

SELECT d.* 
FROM departamento d 
JOIN empleado e ON d.depto_nro = e.depto_nro 
GROUP BY d.depto_nro, d.nombre, d.localidad
HAVING COUNT(e.cod_emp) > 5;

# Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.

SELECT e.nombre, e.salario, d.nombre_depto
FROM empleado e
JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE puesto = (SELECT puesto FROM empleado WHERE nombre = 'Mito' AND apellido = 'Barchuk');

# Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.

SELECT e.* 
FROM empleado e
JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = 'Contabilidad'
ORDER BY e.nombre;


# Mostrar el nombre del empleado que tiene el salario más bajo.

SELECT nombre FROM empleado ORDER BY salario LIMIT 1;

# Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.

SELECT nombre 
FROM empleado 
JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = 'Ventas'
ORDER BY salario DESC LIMIT 1;

