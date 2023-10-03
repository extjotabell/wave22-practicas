CREATE TABLE Planes (
    idPlan INT NOT NULL AUTO_INCREMENT,
    velocidad FLOAT NOT NULL,
    precio FLOAT NOT NULL,
    descuento FLOAT NOT NULL,
    PRIMARY KEY (idPlan)
);

CREATE TABLE `empresa_internet`.`Clientes` (
  `idClientes` INT NOT NULL AUTO_INCREMENT,
  `dni` VARCHAR(50) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `fecha_nacimiento` DATE NOT NULL,
  `provincia` VARCHAR(45) NOT NULL,
  `ciudad` VARCHAR(45) NOT NULL,
  `idPlan` INT NULL,
  PRIMARY KEY (`idClientes`),
  CONSTRAINT `fk_Clientes_Planes`
    FOREIGN KEY (`idPlan`)
    REFERENCES `empresa_internet`.`Planes` (`idPlan`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- Insertar registros en la tabla "Planes"
INSERT INTO Planes (velocidad, precio, descuento) VALUES
(50.0, 29.99, 0.0),
(100.0, 49.99, 5.0),
(200.0, 79.99, 10.0),
(500.0, 99.99, 15.0),
(1000.0, 149.99, 20.0);

-- Insertar registros en la tabla "Clientes" y asociarlos con planes
INSERT INTO Clientes (dni, nombre, apellido, fecha_nacimiento, provincia, ciudad, idPlan) VALUES
('123456789A', 'Juan', 'Pérez', '1990-01-15', 'Santiago del Estero', 'Santiago del Estero', 1),
('987654321B', 'María', 'Gómez', '1985-05-20', 'Santiago del Estero', 'Termas de Río Hondo', 2),
('555555555C', 'Pedro', 'Sánchez', '2000-11-10', 'Santiago del Estero', 'La Banda', 3),
('777777777D', 'Ana', 'Martínez', '1998-09-25', 'Santiago del Estero', 'Fernández', 4),
('999999999E', 'Luis', 'López', '1993-03-05', 'Santiago del Estero', 'Añatuya', 5),
('111111111F', 'Laura', 'Fernández', '1980-12-30', 'Santiago del Estero', 'Santiago del Estero', 1),
('222222222G', 'Carlos', 'García', '1982-08-17', 'Santiago del Estero', 'Termas de Río Hondo', 2),
('333333333H', 'Elena', 'Hernández', '1995-04-08', 'Santiago del Estero', 'La Banda', 3),
('444444444I', 'Sergio', 'Rodríguez', '1999-06-12', 'Santiago del Estero', 'Fernández', 4),
('666666666J', 'Isabel', 'Díaz', '1987-07-22', 'Santiago del Estero', 'Añatuya', 5);

-- 10 consultas SQL que podrías realizar a la base de datos:

-- 1 - Obtener todos los clientes en Santiago del Estero:

SELECT * FROM Clientes WHERE provincia = 'Santiago del Estero';

-- 2 - Recuperar la información del plan asociado al cliente con ID 1:

SELECT * FROM Planes WHERE idPlan = (SELECT idPlan FROM Clientes WHERE idClientes = 1);

-- 3 - Mostrar los clientes que tienen un plan con un descuento mayor a 5%:

SELECT nombre, apellido FROM Clientes WHERE idPlan IS NOT NULL AND (SELECT descuento FROM Planes WHERE idPlan = Clientes.idPlan) > 5.0;

-- 4 - Encontrar los planes con una velocidad mayor o igual a 100 Mbps:

SELECT * FROM Planes WHERE velocidad >= 100.0;


-- 5 - Contar la cantidad de clientes en cada ciudad de Santiago del Estero:

SELECT ciudad, COUNT(*) AS cantidad_clientes
FROM Clientes
WHERE provincia = 'Santiago del Estero'
GROUP BY ciudad;

-- 6 - Calcular el promedio de velocidad de todos los planes:

SELECT AVG(velocidad) AS promedio_velocidad FROM Planes;


-- 7 - Listar los clientes en orden alfabético por apellido:

SELECT * FROM Clientes ORDER BY apellido;


-- 8 - Encontrar el plan más caro:

SELECT velocidad, precio FROM Planes WHERE precio = (SELECT MAX(precio) FROM Planes);


-- 9 - Mostrar los nombres y apellido con la fecha de nacimiento de los clientes que hayan nacido entre 1980 y 1995

SELECT nombre, apellido , fecha_nacimiento FROM Clientes WHERE YEAR(fecha_nacimiento) BETWEEN 1980 AND 1995;

-- 10 - Calcular el total de clientes en la base de datos:

SELECT COUNT(*) AS total_clientes FROM Clientes;







