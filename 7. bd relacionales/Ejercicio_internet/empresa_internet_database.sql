
DROP DATABASE IF EXISTS empresa_internet;
CREATE DATABASE `empresa_internet` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE empresa_internet;

DROP TABLE IF EXISTS clientes;
CREATE TABLE `clientes` (
  `id_cliente` int NOT NULL AUTO_INCREMENT,
  `dni` varchar(8) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `fecha_nacimiento` datetime NOT NULL,
  `provincia` varchar(45) NOT NULL,
  `ciudad` varchar(45) NOT NULL,
  `id_plan` int NOT NULL,
  PRIMARY KEY (`id_cliente`),
  UNIQUE KEY `id_cliente_UNIQUE` (`id_cliente`),
  UNIQUE KEY `dni_UNIQUE` (`dni`),
  KEY `fk_id_plan_idx` (`id_plan`),
  CONSTRAINT `fk_id_plan` FOREIGN KEY (`id_plan`) REFERENCES `planes` (`id_plan`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS planes;
CREATE TABLE `planes` (
  `id_plan` int NOT NULL AUTO_INCREMENT,
  `velocidad_megas` double NOT NULL,
  `precio` double NOT NULL,
  `descuento` double DEFAULT NULL,
  PRIMARY KEY (`id_plan`),
  UNIQUE KEY `id_plan_UNIQUE` (`id_plan`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

#Datos tablas
INSERT INTO planes (velocidad_megas, precio, descuento)
VALUES (800, 2000, 0.05),
	(1000, 4000, 0.1),
    (5000, 7500, 0.15),
    (10000, 9000, 0.25),
    (30000, 15000, 0.35);
    
INSERT INTO clientes (dni, nombre, apellido, fecha_nacimiento, provincia, ciudad, id_plan)
VALUES ('12345671', 'Facundo', 'Hermida', '2000-03-02', 'Buenos Aires', 'Pilar', 2),
		('12345672', 'Julián', 'Hernández', '1998-04-12', 'Buenos Aires', 'Pilar', 1),
        ('12345673', 'José', 'Fernández', '1994-05-03', 'Córdoba', 'Córdoba', 5),
        ('12345674', 'Claudia', 'Hernández', '1987-01-25', 'Chubut', 'Rawson', 3),
        ('12345675', 'María', 'Gómez', '2004-03-15', 'La Pampa', 'Santa Rosa', 1),
        ('12345676', 'Marcos', 'Rodríguez', '2005-08-30', 'Buenos Aires', 'La matanza', 1),
        ('12345677', 'Francisca', 'Hernández', '2001-10-31', 'Buenos Aires', 'Pilar', 4),
        ('12345678', 'Celina', 'Fernández', '1999-11-02', 'Buenos Aires', 'La Plata', 5),
        ('12345679', 'Carlos', 'Rodríguez', '1991-06-01', 'La Rioja', 'Ciudad de La Rioja', 4),
        ('12345670', 'Sofía', 'Fernández', '2000-12-12', 'Buenos Aires', 'Tandil', 2);
        