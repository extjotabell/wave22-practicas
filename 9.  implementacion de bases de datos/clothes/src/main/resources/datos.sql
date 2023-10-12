INSERT INTO `clothes` (`code`, `name`, `type`, `brand`, `color`, `size`, `quantity`, `price`)
VALUES
    (1, 'Camiseta de algodón', 'Camiseta', 'Nike', 'Negro', 'M', 20, 29.99),
    (2, 'Jeans ajustados', 'Pantalón', 'Levis', 'Azul', '32', 15, 89.99),
    (3, 'Zapatillas deportivas', 'Zapatos', 'Adidas', 'Blanco', '42', 10, 99.99),
    (4, 'Vestido de fiesta', 'Vestido', 'Zara', 'Rojo', 'S', 5, 79.99),
    (5, 'Chaqueta de cuero', 'Chaqueta', 'Gucci', 'Negro', 'L', 8, 249.99),
    (6, 'Blusa estampada', 'Blusa', 'H&M', 'Multicolor', 'M', 12, 39.99),
    (7, 'Shorts deportivos', 'Shorts', 'Nike', 'Gris', 'S', 10, 19.99),
    (8, 'Pantalón de vestir', 'Pantalón', 'Zara', 'Negro', '36', 7, 59.99),
    (9, 'Suéter de lana', 'Suéter', 'Gap', 'Gris', 'L', 6, 49.99),
    (10, 'Falda plisada', 'Falda', 'Forever 21', 'Azul marino', 'M', 10, 29.99),
    (11, 'Camisa a rayas', 'Camisa', 'Tommy Hilfiger', 'Blanco y azul', 'L', 15, 69.99),
    (12, 'Traje de baño', 'Traje de baño', 'Calvin Klein', 'Negro', 'M', 4, 89.99),
    (13, 'Vestido casual', 'Vestido', 'Mango', 'Verde', 'XS', 9, 39.99),
    (14, 'Jersey de punto', 'Jersey', 'Zara', 'Beige', 'S', 10, 59.99),
    (15, 'Pantalón corto', 'Pantalón', 'H&M', 'Negro', '34', 12, 24.99);

INSERT INTO `sales` (`number`, `sale_date`, `total`, `payment_type`)
VALUES
    (1, '2022-06-05', 22900, 1),
    (2, '2022-09-15', 25000, 1),
    (3, '2022-10-30', 32000, 1),
    (4, '2023-03-04', 50000, 1),
    (5, '2023-09-14', 72356, 1),
    (6, '2023-09-14', 38543, 1);

INSERT INTO `sales_clothes` (`sale_number`, `clothes_code`)
VALUES
    (2,1),
    (3,2),
    (4,3),
    (4,1),
    (5,10),
    (5,11),
    (5,5),
    (6,1);