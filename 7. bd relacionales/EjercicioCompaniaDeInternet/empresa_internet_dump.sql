-- MySQL dump 10.13  Distrib 8.0.34, for macos13 (arm64)
--
-- Host: localhost    Database: empresa_internet
-- ------------------------------------------------------
-- Server version	8.1.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `dni` int NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `fecha_nacimiento` datetime DEFAULT NULL,
  `provincia` varchar(45) DEFAULT NULL,
  `ciudad` varchar(45) DEFAULT NULL,
  `id_plan` int DEFAULT NULL,
  PRIMARY KEY (`dni`),
  KEY `id_plan_idx` (`id_plan`),
  CONSTRAINT `id_plan` FOREIGN KEY (`id_plan`) REFERENCES `plan_de_internet` (`id_plan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (11111111,'Juan','Pérez','1990-01-01 00:00:00','Madrid','Madrid',1),(22222222,'María','Gómez','1985-05-10 00:00:00','Barcelona','Barcelona',2),(33333333,'Luis','García','1992-08-15 00:00:00','Valencia','Valencia',1),(44444444,'Ana','Rodríguez','1994-03-25 00:00:00','Sevilla','Sevilla',3),(55555555,'Pedro','López','1988-11-30 00:00:00','Granada','Granada',2),(66666666,'Laura','Martínez','1991-06-20 00:00:00','Alicante','Alicante',1),(77777777,'Carlos','Fernández','1987-12-05 00:00:00','Zaragoza','Zaragoza',NULL),(88888888,'Marta','Sánchez','1993-09-12 00:00:00','Málaga','Málaga',2),(99999999,'David','Hernández','1996-02-18 00:00:00','Bilbao','Bilbao',1),(430123123,'Hernan','Martinez','2020-11-11 00:00:00','Buenos Aires','CABA',1);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plan_de_internet`
--

DROP TABLE IF EXISTS `plan_de_internet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plan_de_internet` (
  `id_plan` int NOT NULL,
  `velocidad` int DEFAULT NULL,
  `precio` float DEFAULT NULL,
  `descuento` int DEFAULT NULL,
  PRIMARY KEY (`id_plan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plan_de_internet`
--

LOCK TABLES `plan_de_internet` WRITE;
/*!40000 ALTER TABLE `plan_de_internet` DISABLE KEYS */;
INSERT INTO `plan_de_internet` VALUES (1,10,100,0),(2,100,200,10),(3,400,1000,0),(4,2000,1200,0),(5,100000,123000,70);
/*!40000 ALTER TABLE `plan_de_internet` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-29 17:50:49
