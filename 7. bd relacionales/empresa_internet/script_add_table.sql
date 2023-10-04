
DROP TABLE IF EXISTS `pack`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pack` (
  `id_pack` int(10) unsigned NOT NULL AUTO_INCREMENT, 
  `mega` int(4) unsigned DEFAULT NULL,
  `precio` decimal(7,2) unsigned NOT NULL,
  `descuento` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id_pack`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `provincia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `provincia` (
  `id_provincia` int(10) unsigned NOT NULL AUTO_INCREMENT, 
  `nombre` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id_provincia`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `localidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `localidad` (
  `id_localidad` int(10) unsigned NOT NULL AUTO_INCREMENT, 
  `nombre` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `id_provincia` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id_localidad`),
  CONSTRAINT `id_provincia_foreign` FOREIGN KEY (`id_provincia`) REFERENCES `provincia` (`id_provincia`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `id_cliente` int(10) unsigned NOT NULL AUTO_INCREMENT, 
  `dni` int(15) unsigned DEFAULT NULL,
  `nombre` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `apellido` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `fecha_nacimiento` timestamp,
  `id_pack` int(10) unsigned NOT NULL,
  `id_localidad` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id_cliente`),
  CONSTRAINT `id_pack_foreign` FOREIGN KEY (`id_pack`) REFERENCES `pack` (`id_pack`),
  CONSTRAINT `id_localidad_foreign` FOREIGN KEY (`id_localidad`) REFERENCES `localidad` (`id_localidad`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;



