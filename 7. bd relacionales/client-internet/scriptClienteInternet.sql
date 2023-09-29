DROP DATABASE IF EXISTS empresa_internet;
CREATE DATABASE empresa_internet;
USE empresa_internet;

DROP TABLE IF EXISTS internet_plan;
CREATE TABLE internet_plan (
    plan_ID int(10) unsigned NOT NULL AUTO_INCREMENT,
    speed_megas INT,
    price DECIMAL(8, 2),
    discount DECIMAL(4, 2),
    PRIMARY KEY (plan_ID)
);

INSERT INTO internet_plan (speed_megas, price, discount)
VALUES 
(100, 50.00, 0.10),
(200, 60.00, 0.15),
(300, 70.00, 0.20),
(400, 80.00, 0.25),
(500, 90.00, 0.30);

DROP TABLE IF EXISTS customer;
CREATE TABLE customer (
    DNI VARCHAR(10) PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    birthdate DATE,
    state VARCHAR(50),
    city VARCHAR(50),
    plan_ID INT(10) unsigned,
    FOREIGN KEY (plan_ID) REFERENCES internet_plan(plan_ID)
);

INSERT INTO customer (DNI, first_name, last_name, birthdate, state, city, plan_ID)
VALUES 
('123456789', 'Lautaro', 'Martinez', '1990-05-15', 'Buenos Aires', 'CABA', 1),
('234567890', 'Sofia', 'Gomez', '1985-09-20', 'Cordoba', 'Cordoba', 2),
('345678901', 'Mateo', 'Rodriguez', '1988-11-30', 'Santa Fe', 'Rosario', 1),
('456789012', 'Valentina', 'Lopez', '1992-03-10', 'Mendoza', 'Mendoza', 1),
('567890123', 'Thiago', 'Fernandez', '1983-07-25', 'Tucuman', 'San Miguel de Tucuman', 2),
('678901234', 'Isabella', 'Perez', '1995-01-18', 'Salta', 'Salta', 1),
('789012345', 'Benjamin', 'Diaz', '1998-06-05', 'San Juan', 'San Juan', 2),
('890123456', 'Valeria', 'Sanchez', '1994-09-12', 'Entre Rios', 'Parana', 1),
('901234567', 'Alexander', 'Molina', '1987-12-08', 'Neuquen', 'Neuquen', 2),
('012345678', 'Valeria', 'Ramirez', '1989-04-22', 'San Juan', 'San Juan', 1);


-- Obtener los detalles de un cliente específico por su DNI
SELECT * FROM customer WHERE DNI = '234567890';

-- Obtener los clientes que tienen un plan de Internet específico
SELECT * FROM customer WHERE plan_ID = 1;

-- Obtener los clientes que viven en una ciudad en particular
SELECT * FROM customer WHERE city = 'Cordoba';

-- Obtener los planes de Internet ordenados por precio de forma descendente
SELECT * FROM internet_plan ORDER BY price DESC;

-- Obtener la provinca con la mayor cantidad de clientes
SELECT state, COUNT(*) as total_clientes
FROM customer
GROUP BY state
ORDER BY total_clientes DESC
LIMIT 1;

-- Calcular el promedio de la velocidad de Internet ofrecida en los planes
SELECT AVG(speed_megas) FROM internet_plan;

-- Obtener la velocidad mínima y máxima de los planes de Internet
SELECT MIN(speed_megas) AS velocidad_minima, MAX(speed_megas) AS velocidad_maxima FROM internet_plan;

-- Obtener la cantidad total de clientes en la base de datos
SELECT COUNT(*) FROM customer;

-- Obtener el plan de Internet más caro
SELECT * FROM internet_plan ORDER BY price DESC LIMIT 1;














