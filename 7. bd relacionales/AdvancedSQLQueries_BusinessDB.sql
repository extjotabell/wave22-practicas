-- Seleccionar el nombre, el puesto y la localidad 
-- de los departamentos donde trabajan los vendedores.
SELECT em.nombre, em.puesto, dep.localidad
FROM Empleado em
INNER JOIN Departamento dep
ON em.depto_nro = dep.depto_nro;

-- Visualizar los departamentos con más de cinco empleados.
SELECT dep.nombre_depto, COUNT(em.depto_nro) AS amount
FROM Departamento dep
INNER JOIN Empleado em
ON dep.depto_nro = em.depto_nro
GROUP BY dep.depto_nro
HAVING amount > 5;

-- Mostrar el nombre, salario y nombre del departamento 
-- de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT em.nombre, em.salario, dep.nombre_depto
FROM Empleado em
INNER JOIN Departamento dep
ON em.depto_nro = dep.depto_nro
WHERE em.puesto IN (SELECT puesto
					FROM empleado
					WHERE nombre = "Mito"
                    AND apellido = "Barchuk");
			
-- Mostrar los datos de los empleados que trabajan en el 
-- departamento de contabilidad, ordenados por nombre.
SELECT em.*, dep.nombre_depto
FROM Empleado em
INNER JOIN Departamento dep
ON em.depto_nro = dep.depto_nro
WHERE dep.nombre_depto = "Contabilidad";

-- Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT nombre
FROM Empleado
WHERE salario IN (SELECT MIN(salario)
				FROM EMPLEADO);
                
-- Mostrar los datos del empleado que tiene el salario 
-- más alto en el departamento de ‘Ventas’.
SELECT em.*
FROM Empleado em
INNER JOIN Departamento dep
ON em.depto_nro = dep.depto_nro
WHERE em.salario IN (SELECT MAX(salario)
				FROM Empleado em
                INNER JOIN Departamento dep
                ON em.depto_nro = dep.depto_nro
                WHERE dep.nombre_depto = "Ventas")


