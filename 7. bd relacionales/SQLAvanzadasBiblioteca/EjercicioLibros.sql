DROP TABLE IF EXISTS `libro`;
CREATE TABLE `libro` (
  `idLibro` int(10) unsigned NOT NULL AUTO_INCREMENT, 
  `titulo` varchar(50) NOT NULL,
  `editorial` varchar(50) NOT NULL,
  `area` varchar(25),
  PRIMARY KEY (`idLibro`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

DROP TABLE IF EXISTS `autor`;
CREATE TABLE `autor` (
  `idAutor` int(10) unsigned NOT NULL AUTO_INCREMENT, 
  `nombre` varchar(50) NOT NULL,
  `nacionalidad` varchar(50) NOT NULL,
  PRIMARY KEY (`idAutor`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

DROP TABLE IF EXISTS `libroAutor`;
CREATE TABLE `libroAutor` (
  `idLibroAutor` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `idAutor` int(10) unsigned NOT NULL, 
  `idLibro` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idLibroAutor`),
  KEY`idAutor_foreignkey`(`idAutor`),
  KEY`idLibro_foreignkey`(`idLibro`),
  CONSTRAINT `idAutor_foreignkey` FOREIGN KEY (`idAutor`) REFERENCES `autor` (`idAutor`),
  CONSTRAINT `idLibro_foreignkey` FOREIGN KEY (`idLibro`) REFERENCES `libro` (`idLibro`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

DROP TABLE IF EXISTS `estudiante`;
CREATE TABLE `estudiante` (
  `idLector` int(10) unsigned NOT NULL AUTO_INCREMENT, 
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `direccion` varchar(100),
  `carrera` varchar(50),
  `edad` int(3),
  PRIMARY KEY (`idLector`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

DROP TABLE IF EXISTS `prestamos`;
CREATE TABLE `prestamos` (
  `idPrestamo` int(10) unsigned NOT NULL AUTO_INCREMENT, 
  `idLector` int(10) unsigned NOT NULL, 
  `idLibro` int(10) unsigned NOT NULL,
  `fechaPrestamos` timestamp,
  `fechaDevolucion` timestamp,
  `devuelto` boolean,
  PRIMARY KEY (`idPrestamo`),
  KEY`idLector_foreignkey`(`idLector`),
  KEY`idLibroPrestamo_foreignkey`(`idLibro`),
  CONSTRAINT `idLector_foreignkey` FOREIGN KEY (`idLector`) REFERENCES `estudiante` (`idLector`),
  CONSTRAINT `idLibroPrestamo_foreignkey` FOREIGN KEY (`idLibro`) REFERENCES `libro` (`idLibro`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

