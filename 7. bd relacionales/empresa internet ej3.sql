

INSERT INTO `empresa_internet`.`internet_plan`
(
`velocity`,
`price`,
`discount`)
VALUES
(100,5800, 0),
(300, 7000, 0),
(1000, 8900, 15),
(3000, 12000, 10),
(5000, 15000, 5)
;

INSERT INTO `empresa_internet`.`customer`
(`dni`,
`first_name`,
`last_name`,
`date_of_birth`,
`province`,
`city`,
`id_internet_plan`)
VALUES 
(12345678, "Nicolas", "Salvo", "1988-12-14", "Buenos Aires", "CABA", 2),
(23456789, "Cosme", "Fulanito", "1967-5-5", "Buenos Aires", "Trenque Lauquen", 5),
(34567890, "Jenny", "Aniston", "1978-2-23", "Buenos Aires", "Bahia Blanca", 3),
(45678901, "Jimena", "Cobra", "1990-11-15", "Buenos Aires", "CABA", 1),
(56789012, "Francisco", "Sarlanga", "1955-5-5", "Chubut", "Trelew", 2),
(67890123, "Bob", "Esponja", "2020-3-23", "Mar profundo", "Alga", 4),
(78901234, "Lucia", "Bueno", "1997-9-9", "Cordoba", "Tres Arroyos", 2),
(89012345, "Linda", "Muela", "2000-1-16", "Buenos Aires", "Ostende", 1),
(90123456, "Esteban", "Quito", "2014-2-1", "Buenos Aires", "CABA", 2),
(01234567, "Mona", "Jimenez", "1958-8-7", "Fernelandia", "Fernando", 3)
;

CREATE TABLE `empresa_internet`.`customer` (
  `dni` INT NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `date_of_birth` DATE NULL,
  `province` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  `id_internet_plan` INT NULL,
  PRIMARY KEY (`dni`),
  INDEX `fk_internet_plan_customer_id_internet_plan_idx` (`id_internet_plan` ASC) VISIBLE,
  CONSTRAINT `fk_internet_plan_customer_id_internet_plan`
    FOREIGN KEY (`id_internet_plan`)
    REFERENCES `empresa_internet`.`internet_plan` (`id_internet_plan`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
CREATE TABLE `internet_plan` (
  `id_internet_plan` int NOT NULL AUTO_INCREMENT,
  `velocity` int NOT NULL,
  `price` float NOT NULL,
  `discount` int DEFAULT '0',
  PRIMARY KEY (`id_internet_plan`)
);
