USE movies_db;

/* INDICES*/
# ver el índice de una tabla específica
SHOW INDEX FROM autor;
# crear indice 
CREATE INDEX movies_idx
ON movies(id);

# Explain
EXPLAIN SELECT * FROM movies;

/* TABLAS TEMPORALES*/

CREATE TEMPORARY TABLE Harringui (nombreActor varchar(40), apellidoActor varchar(40));

INSERT INTO Harringui SELECT DISTINCT act.first_name, act.last_name
FROM movies mo
JOIN actor_movie am ON mo.id = am.movie_id
JOIN actors act ON act.id = am.actor_id
WHERE mo.title LIKE "%Harry%";

SELECT apellidoActor FROM Harringui;



/* Ejercicio de Normalización */

/* Tabla cliente:
id_cliente
nombre_cliente
apellido_cliente
direccion_cliente

Tabla Facturacion
id_factura
fecha_factura
Forma_pago
Iva
cantidad
importe
id_cliente
