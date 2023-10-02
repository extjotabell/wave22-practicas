SELECT * FROM sakila.payment
WHERE payment_date BETWEEN  "2005-05-25 00:00:00" AND "2005-05-25 23:59:59";

/****** COUNT ******/
SELECT COUNT(payment_id) AS cantidad_de_pedidos
FROM payment 
WHERE payment_date BETWEEN  "2005-05-25 00:00:00" AND "2005-05-25 23:59:59";

/****** MIN ******/
SELECT MIN(DISTINCT amount) AS facturacion_mas_baja
FROM payment 
WHERE payment_date BETWEEN  "2005-05-25 00:00:00" AND "2005-05-25 23:59:59";

/****** MAX ******/
SELECT MAX(DISTINCT amount) AS facturacion_mas_alta
FROM payment 
WHERE payment_date BETWEEN  "2005-05-25 00:00:00" AND "2005-05-25 23:59:59";

/****** SUM ******/
SELECT SUM(amount) AS dia_facturado 
FROM payment 
WHERE payment_date BETWEEN  "2005-05-25 00:00:00" AND "2005-05-25 23:59:59";

/****** AVG ******/
SELECT AVG(amount) AS dia_facturado 
FROM payment 
WHERE payment_date BETWEEN  "2005-05-25 00:00:00" AND "2005-05-25 23:59:59";







