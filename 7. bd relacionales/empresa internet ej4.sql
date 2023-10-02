# Obtener los primeros 5 usuarios
SELECT * FROM customer
LIMIT 5;

#Obtener nombre y apellido de los usuarios nacidos entre 1980 y 2000. Ordernarlos por fecha de forma ascendente
SELECT first_name, last_name, date_of_birth from customer
WHERE date_of_birth between "1980-01-01" and "2000-12-31"
ORDER BY date_of_birth;

# Obtener el nombre y apellido de los usuarios que viven en CABA
SELECT first_name, last_name, city from customer
WHERE city = "CABA";

# Obtener todas las ciudades sin repeticion
SELECT Distinct(city) FROM customer;

# Obtener la cantidad de ciudades y ponerle un nombre descriptivo
SELECT COUNT(DISTINCT(city)) `Cantidad de ciudades` FROM customer;

# Obtener los planes de internet que tengan descuento y ordenarlos descendente
SELECT * FROM internet_plan
WHERE discount > 0
ORDER BY discount desc;

# Obtener el nombre y apellido de los clientes que utilizan un plan de internet con una velocidad mayor a 500
SELECT c.first_name, c.last_name, ip.velocity FROM customer c
INNER JOIN internet_plan ip ON c.id_internet_plan = ip.id_internet_plan
WHERE ip.velocity > 500;

# Obtener la cantidad de clientes que tienen el plan mayor a 500 con nombre "Cantidad de clientes"
SELECT COUNT(*) as "Cantidad de clientes" from customer c
JOIN internet_plan ip ON c.id_internet_plan = ip.id_internet_plan
WHERE ip.velocity > 500;

# Agrupar la cantidad de clientes que utiliza cada servicio de internet y ordenar descendente por cantidad de clientes y velocidad
SELECT COUNT(*) as "Cantidad de clientes", ip.velocity FROM customer c
JOIN internet_plan ip ON c.id_internet_plan = ip.id_internet_plan
GROUP BY c.id_internet_plan
ORDER BY COUNT(*) DESC, velocity DESC;

# Agrupar la cantidad de clientes que utiliza cada servicio de internet y mostrar solo los que tienen mas de 3
SELECT COUNT(*) as "Cantidad de clientes", ip.velocity from customer c
JOIN internet_plan ip ON c.id_internet_plan = ip.id_internet_plan
GROUP BY c.id_internet_plan
HAVING COUNT(*) > 3;