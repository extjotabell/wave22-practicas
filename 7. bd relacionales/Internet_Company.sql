DROP DATABASE IF EXISTS empresa_internet;
CREATE DATABASE IF NOT EXISTS empresa_internet;

USE empresa_internet;
CREATE TABLE planes (
	id_plan INT PRIMARY KEY AUTO_INCREMENT,
    velocidad FLOAT NOT NULL,
    precio FLOAT NOT NULL,
    descuento FLOAT
);

CREATE TABLE clientes (
	id_cliente INT PRIMARY KEY AUTO_INCREMENT,
    dni VARCHAR(50) NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    provincia VARCHAR(50) NOT NULL,
    ciudad VARCHAR(50) NOT NULL,
    id_plan INT NOT NULL,
    FOREIGN KEY (id_plan) REFERENCES planes(id_plan)
);

INSERT INTO planes(velocidad, precio, descuento) VALUES(50,3000,0);
INSERT INTO planes(velocidad, precio, descuento) VALUES(100,5000,0);
INSERT INTO planes(velocidad, precio, descuento) VALUES(20,2500,0);
INSERT INTO planes(velocidad, precio, descuento) VALUES(10,1800,0);
INSERT INTO planes(velocidad, precio, descuento) VALUES(5,1500,0);
INSERT INTO clientes(dni, nombre, apellido, fecha_nacimiento, provincia, ciudad, id_plan) VALUES('36964073', 'Renzo', 'Bayarri', '1992-06-19', 'Mendoza', 'Mendoza', 1);
INSERT INTO clientes(dni, nombre, apellido, fecha_nacimiento, provincia, ciudad, id_plan) VALUES('12345678', 'Alice', 'Smith', '1985-04-15', 'New York', 'New York', 2);
INSERT INTO clientes(dni, nombre, apellido, fecha_nacimiento, provincia, ciudad, id_plan) VALUES('98765432', 'John', 'Doe', '1990-09-22', 'California', 'Los Angeles', 3);
INSERT INTO clientes(dni, nombre, apellido, fecha_nacimiento, provincia, ciudad, id_plan) VALUES('55555555', 'Ella', 'Johnson', '1988-11-30', 'Texas', 'Houston', 4);
INSERT INTO clientes(dni, nombre, apellido, fecha_nacimiento, provincia, ciudad, id_plan) VALUES('11112222', 'Robert', 'Brown', '1997-02-10', 'Florida', 'Miami', 5);
INSERT INTO clientes(dni, nombre, apellido, fecha_nacimiento, provincia, ciudad, id_plan) VALUES('44444444', 'Emily', 'Davis', '1993-07-07', 'Illinois', 'Chicago', 1);
INSERT INTO clientes(dni, nombre, apellido, fecha_nacimiento, provincia, ciudad, id_plan) VALUES('99999999', 'Sophia', 'Wilson', '1991-05-25', 'Arizona', 'Phoenix', 2);
INSERT INTO clientes(dni, nombre, apellido, fecha_nacimiento, provincia, ciudad, id_plan) VALUES('77777777', 'James', 'Taylor', '1987-03-18', 'Nevada', 'Las Vegas', 3);
INSERT INTO clientes(dni, nombre, apellido, fecha_nacimiento, provincia, ciudad, id_plan) VALUES('66666666', 'Olivia', 'Anderson', '1996-08-12', 'Colorado', 'Denver', 4);
INSERT INTO clientes(dni, nombre, apellido, fecha_nacimiento, provincia, ciudad, id_plan) VALUES('33333333', 'William', 'Martinez', '1986-01-05', 'Georgia', 'Atlanta', 5);

SELECT c.nombre, p.velocidad
FROM clientes c
JOIN planes p ON c.id_plan = p.id_plan;

SELECT c.nombre, c.apellido
FROM clientes c
JOIN planes p ON c.id_plan = p.id_plan
WHERE p.descuento > 0;

SELECT provincia, COUNT(*) AS total_customers
FROM clientes
GROUP BY provincia;

SELECT nombre, apellido, fecha_nacimiento
FROM clientes
WHERE fecha_nacimiento > '1990-01-01';

SELECT MAX(velocidad) AS Velocidad_Maxima
FROM planes;

SELECT nombre, apellido
FROM clientes
WHERE provincia = 'New York';

SELECT AVG(precio) AS promedio
FROM planes;

SELECT nombre, apellido
FROM clientes c
WHERE c.id_plan NOT IN (
    SELECT id_plan
    FROM planes
    WHERE descuento > 0
);

SELECT c.nombre, c.apellido, p.velocidad
FROM clientes c
JOIN planes p ON c.id_plan = p.id_plan
ORDER BY p.velocidad DESC
LIMIT 1;

SELECT c.nombre, c.apellido, p.velocidad
FROM clientes c
JOIN planes p ON c.id_plan = p.id_plan
ORDER BY c.nombre, c.apellido;


