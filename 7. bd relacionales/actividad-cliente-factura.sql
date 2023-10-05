-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema clinteFactura
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema clinteFactura
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `clinteFactura` DEFAULT CHARACTER SET utf8 ;
USE `clinteFactura` ;

-- -----------------------------------------------------
-- Table `clinteFactura`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clinteFactura`.`Cliente` (
  `id_cliente` INT NOT NULL AUTO_INCREMENT,
  `nombre_cliente` VARCHAR(45) NOT NULL,
  `apellido_cliente` VARCHAR(45) NOT NULL,
  `direccion_cliente` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_cliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinteFactura`.`Factura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clinteFactura`.`Factura` (
  `id_Factura` INT NOT NULL AUTO_INCREMENT,
  `fecha_factura` DATE NOT NULL,
  `forma_pago` DECIMAL(10,0) NULL,
  `IVA` DECIMAL(10,0) NULL,
  `cantidad` INT NULL,
  `importe` DECIMAL(10,0) NULL,
  `descripcion_articulo` VARCHAR(40) NULL,
  `Cliente_id_cliente` INT NOT NULL,
  PRIMARY KEY (`id_Factura`, `Cliente_id_cliente`),
  INDEX `fk_Factura_Cliente_idx` (`Cliente_id_cliente` ASC) VISIBLE,
  CONSTRAINT `fk_Factura_Cliente`
    FOREIGN KEY (`Cliente_id_cliente`)
    REFERENCES `clinteFactura`.`Cliente` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
