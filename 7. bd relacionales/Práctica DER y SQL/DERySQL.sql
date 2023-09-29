CREATE TABLE Cliente (
id_cliente int AUTO_INCREMENT PRIMARY KEY,
dni int,
nombre varchar(50),
apellido varchar(50),
fecha_de_nacimiento date,
provincia varchar(30),
ciudad varchar(50)
);

CREATE TABLE Plan(
id_plan int AUTO_INCREMENT PRIMARY KEY,
velocidad int,
precio float,
descuento float
);

ALTER TABLE Cliente
ADD COLUMN id_plan INT;

ALTER TABLE Cliente
ADD FOREIGN KEY (id_plan)
REFERENCES Plan(id_plan);

INSERT INTO Plan (velocidad, precio, descuento)
VALUES
    (30, 29.99, 0.10),
    (50, 39.99, 0.15),
    (100, 49.99, 0.20),
    (200, 59.99, 0.25),
    (500, 69.99, 0.30);
    
SELECT * FROM Plan;

INSERT INTO Cliente (dni, nombre, apellido, fecha_de_nacimiento, provincia, ciudad, id_plan)
VALUES
    (123456789, 'Juan', 'Pérez', '1990-05-15', 'Buenos Aires', 'Ciudad A', 1),
    (987654321, 'María', 'González', '1985-02-22', 'Córdoba', 'Ciudad B', 2),
    (456789123, 'Carlos', 'López', '1995-11-10', 'Santa Fe', 'Ciudad C', 3),
    (789123456, 'Ana', 'Rodríguez', '1980-08-03', 'Mendoza', 'Ciudad D', 4),
    (321654987, 'Pedro', 'Fernández', '1993-04-28', 'Tucumán', 'Ciudad E', 5),
    (654987321, 'Laura', 'Díaz', '1988-01-12', 'Salta', 'Ciudad F', 1),
    (159753468, 'Diego', 'Martínez', '1998-07-19', 'San Juan', 'Ciudad G', 2),
    (753468159, 'Carolina', 'Sánchez', '1983-12-25', 'Entre Ríos', 'Ciudad H', 3),
    (852963741, 'Miguel', 'Hernández', '1992-09-05', 'Jujuy', 'Ciudad I', 4),
    (369258147, 'Lucía', 'Torres', '1987-03-08', 'Neuquén', 'Ciudad J', 5);

SELECT * FROM Cliente;

-- Seleccionar todos los clientes
SELECT * FROM Cliente;

-- Seleccionar clientes de una ciudad específica
SELECT *
FROM Cliente
WHERE ciudad = "Ciudad A";

-- Seleccionar clientes con un plan específico
SELECT * 
FROM Cliente
WHERE id_plan = 1;

-- Calcular el promedio de velocidad de todos los planes
SELECT AVG(velocidad) as velocidad_promedio
FROM Plan;

-- Mostrar el plan más caro
SELECT MAX(precio) as plan_mas_caro
FROM Plan;

-- Contar cuantos clientes hay en cada provincia
SELECT provincia, COUNT(ciudad) AS cantidad_de_clientes
FROM Cliente 
GROUP BY provincia;

-- Clientes mayores de 30 años
SELECT *
FROM Cliente
WHERE TIMESTAMPDIFF(YEAR, fecha_de_nacimiento, CURDATE()) > 30;

-- Actualizar velocidad de un plan
UPDATE Plan
SET velocidad = 40
WHERE id_plan = 1;

-- Eliminar clientes sin un plan asignado
DELETE FROM Cliente
WHERE id_plan = null;

-- Obtener el nombre, apellido y precio del plan de todos los clientes
SELECT c.nombre, c.apellido, p.precio
FROM Cliente c INNER JOIN Plan p
ON c.id_plan = p.id_plan;
