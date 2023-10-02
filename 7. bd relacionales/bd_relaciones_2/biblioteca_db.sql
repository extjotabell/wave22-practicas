CREATE TABLE `autor` (
  `id_autor` int NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `nacionalidad` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_autor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `estudiante` (
  `id_lector` int NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `carrera` varchar(45) DEFAULT NULL,
  `edad` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `libro` (
  `id_libro` int NOT NULL,
  `titulo` varchar(45) DEFAULT NULL,
  `editorial` varchar(45) DEFAULT NULL,
  `area` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_libro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `libro_autor` (
  `id_autor` int NOT NULL,
  `id_libro` int DEFAULT NULL,
  PRIMARY KEY (`id_autor`),
  KEY `id_libro_idx` (`id_libro`),
  CONSTRAINT `id_autor` FOREIGN KEY (`id_autor`) REFERENCES `autor` (`id_autor`),
  CONSTRAINT `id_libro` FOREIGN KEY (`id_libro`) REFERENCES `libro` (`id_libro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `prestamo` (
  `id_lector` int NOT NULL,
  `id_libro` int DEFAULT NULL,
  `fecha_prestamo` datetime DEFAULT NULL,
  `fecha_devolucion` datetime DEFAULT NULL,
  `devulto` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id_lector`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
