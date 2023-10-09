INSERT INTO `vehiculo` (`vehiculo_id`, `patente`, `marca`, `modelo`, `fecha_fabricacion`, `cantidad_ruedas`)
VALUES
    (1, 'ABC123', 'Toyota', 'Corolla', '2020-04-15', 4),
    (2, 'DEF456', 'Ford', 'Mustang', '2018-04-15', 4),
    (3, 'GHI789', 'Chevrolet', 'Cruze', '2019-04-15', 4),
    (4, 'JKL012', 'Honda', 'Civic', '2017-04-15', 4),
    (5, 'MNO345', 'Volkswagen', 'Golf', '2021-04-15', 4),
    (6, 'PQR678', 'BMW', 'X5', '2016-04-15', 4),
    (7, 'STU901', 'Mercedes-Benz', 'C-Class', '2015-04-15', 4),
    (8, 'VWX234', 'Audi', 'A4', '2014-04-15', 4),
    (9, 'YZA567', 'Hyundai', 'Elantra', '2022-04-15', 4),
    (10, 'BCD890', 'Kia', 'Sportage', '2013-04-15', 4),
    (11, 'EFG123', 'Nissan', 'Sentra', '2023-04-15', 4),
    (12, 'HIJ456', 'Mazda', 'CX-5', '2012-04-15', 4),
    (13, 'KLM789', 'Subaru', 'Impreza', '2011-04-15', 4),
    (14, 'NOP012', 'Volvo', 'S60', '2024-04-15', 4),
    (15, 'QRS345', 'Lexus', 'RX', '2010-04-15', 4);

INSERT INTO `siniestro` (`id`, `fecha`, `perdida_economica`, `vehiculo_id`)
VALUES
    (1, '2022-01-01', 5000, 1),
    (2, '2022-02-15', 10000, 1),
    (3, '2022-03-10', 7500, 2),
    (4, '2022-04-20', 3000, 4),
    (5, '2022-05-05', 8000, 5),
    (6, '2022-06-30', 2000, 6),
    (7, '2022-07-15', 6000, 8),
    (8, '2022-08-10', 4000, 10),
    (9, '2022-09-25', 9000, 11),
    (10, '2022-10-05', 1500, 12),
    (11, '2022-11-20', 7000, 14),
    (12, '2022-12-12', 2500, 15),
    (13, '2022-01-10', 5500, 1),
    (14, '2022-02-25', 12000, 1),
    (15, '2022-03-20', 8500, 3),
    (16, '2022-04-30', 3500, 4),
    (17, '2022-05-15', 7500, 5),
    (18, '2022-06-25', 1800, 6),
    (19, '2022-07-20', 6500, 8),
    (20, '2022-08-15', 4500, 9),
    (21, '2022-09-30', 9500, 11),
    (22, '2022-10-10', 1700, 12),
    (23, '2022-11-25', 8500, 13),
    (24, '2022-12-20', 2200, 15),
    (25, '2022-01-20', 6000, 2),
    (26, '2022-02-05', 11000, 2),
    (27, '2022-03-30', 8000, 3),
    (28, '2022-04-10', 2500, 4),
    (29, '2022-05-25', 7000, 6),
    (30, '2022-06-20', 1600, 7);