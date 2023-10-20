INSERT INTO `test_cases` (`description`, `tested`, `passed`, `number_of_tries`, `last_update`)
VALUES
    ('Caso de prueba 1', TRUE, TRUE, 100, '2022-05-06'),
    ('Caso de prueba 2', TRUE, TRUE, 90, '2022-05-07'),
    ('Caso de prueba 3', TRUE, TRUE, 80, '2023-10-11'),
    ('Caso de prueba 4', TRUE, FALSE, 70, '2023-04-12'),
    ('Caso de prueba 5', TRUE, FALSE, 60, '2022-07-06'),
    ('Caso de prueba 6', FALSE, FALSE, 50, '2023-09-29'),
    ('Caso de prueba 7', FALSE, FALSE, 40, CURRENT_DATE());