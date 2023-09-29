#Obtener todos los clientes
SELECT * FROM clientes;

#Obtener todos los planes
SELECT * FROM planes;

#Obtener el nombre completo del cliente con el descuento que le corresponda
SELECT c.nombre, c.apellido, p.descuento FROM clientes c
INNER JOIN planes p ON c.id_plan = p.id_plan;

#Obtener el nombre completo del cliente, su DNI y la provincia donde vive con la cantidad de megas que contrató
SELECT c.nombre, c.apellido, c.provincia, p.velocidad_megas FROM clientes c
INNER JOIN planes p ON c.id_plan = p.id_plan;

#Obtener a todos los clientes cuyo apellido comience con H
SELECT * FROM clientes
WHERE apellido LIKE 'H%';

#Obtener el nombre completo, DNI de los clientes que hayan nacido después del 1999 y contraten más de mil megas
SELECT c.nombre, c.apellido FROM clientes c
INNER JOIN planes p ON c.id_plan = p.id_plan
WHERE c.fecha_nacimiento > '1999-01-01' AND p.velocidad_megas > 1000;

#Obtener el nombre completo y fecha de nacimiento de los clientes que hayan nacido entre 1990 y 2002
SELECT nombre, apellido, fecha_nacimiento FROM clientes
WHERE fecha_nacimiento BETWEEN '1990-01-01' AND '2002-01-01';

#Obtener todos los planes que tengan un descuento mayor al 15% ordenados de menor a mayor
SELECT * FROM planes
WHERE descuento > 0.15
ORDER BY descuento ASC;

#Obtener todos los clientes que vivan en La Pampa, junto con los megas que contrataron ordenados por DNI de mayor a menor
SELECT c.*, p.velocidad_megas FROM clientes c
INNER JOIN planes p ON c.id_plan = p.id_plan
WHERE provincia = 'La Pampa'
ORDER BY c.dni DESC;

#Obtener el dni, nombre y ciudad de los clientes que contraten el plan de 30000 megas y no vivan en La Plata
SELECT c.nombre, c.apellido, c.ciudad FROM clientes c
INNER JOIN planes p ON c.id_plan = p.id_plan
WHERE p.velocidad_megas = 30000 AND ciudad <> 'La Plata';
