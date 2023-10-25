INSERT INTO `VEHICULOS` (`AÑO_FABRICACION` ,`CANTIDAD_RUEDAS` , `MARCA` ,`MODELO` ,`PATENTE` )
VALUES
    ('2017-01-01', 4, 'Toyota', 'Etios', 'AA111AA'),
    ('2017-02-01', 4, 'Toyota', 'Etios', 'AB123XZ'),
    ('2018-04-01', 4, 'Chevrolet', 'Cruze', 'AC323VF'),
    ('2019-01-01', 2, 'Toyota', 'Corolla', 'AD543VX'),
    ('2018-02-01', 2, 'Ford', 'Fiesta', 'AC564YZ'),
    ('2020-01-01', 4, 'Toyota', 'Etios', 'AD987ZX'),
    ('2022-02-01', 4, 'Peugeot', '3008', 'AE111AA'),
    ('2023-06-01', 2, 'Ford', 'Ranger', 'AF111AA'),
    ('2023-11-01', 4, 'Batimovil', 'Robin', 'AF176GE'),
    ('2023-06-01', 4, 'Toyota', 'SW4', 'AG843IP');

INSERT INTO `SINIESTROS` (`fecha` ,`perdida_economica` , `id_vehiculo`)
VALUES
    ('2017-01-01', 125000, 1),
    ('2017-02-01', 84000, 1),
    ('2018-04-01', 25000, 1),
    ('2019-01-01', 35000, 2),
    ('2018-02-01', 59500, 2),
    ('2020-01-01', 72300, 3),
    ('2022-02-01', 103000, 4),
    ('2023-06-01', 63000, 5),
    ('2023-11-01', 20000, 5),
    ('2023-06-01', 45700, 8);
