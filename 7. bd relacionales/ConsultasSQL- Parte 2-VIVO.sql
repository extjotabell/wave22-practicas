# Mostrar todos los registros de la tabla de movies. 
SELECT * FROM movies;

# Mostrar el nombre, apellido y rating de todos los actores.
SELECT first_name, last_name, rating FROM actors;

# Mostrar el título de todas las series y usar alias para que tanto el nombre de la tabla como el campo estén en español.
SELECT title AS Título FROM series;

# Mostrar el nombre y apellido de los actores cuyo rating sea mayor a 7.5.
SELECT A.first_name, A.last_name FROM ACTORS A WHERE A.RATING>7.5;

# Mostrar el título de las películas, el rating y los premios de las películas con un rating mayor a 7.5 y con más de dos premios.
SELECT M.title, M.rating, M.awards FROM MOVIES M WHERE M.RATING>7.5 and M.AWARDS>2;

# Mostrar el título de las películas y el rating ordenadas por rating en forma ascendente.
SELECT M.title, M.rating FROM MOVIES M ORDER BY M.rating;

# Mostrar los títulos de las primeras tres películas en la base de datos.
SELECT M.title FROM MOVIES M LIMIT 3;

# Mostrar el top 5 de las películas con mayor rating.
SELECT * FROM MOVIES M ORDER BY M.rating desc LIMIT 5;

# Listar los primeros 10 actores.
SELECT * FROM ACTORS LIMIT 10;

# Mostrar el título y rating de todas las películas cuyo título sea de Toy Story.
SELECT M.title, M.rating FROM MOVIES M WHERE M.title like "Toy Story%";

# Mostrar a todos los actores cuyos nombres empiezan con Sam.
SELECT * FROM ACTORS A WHERE A.first_name like "Sam%";

# Mostrar el título de las películas que salieron entre el 2004 y 2008.
SELECT M.title FROM MOVIES M where M.release_date BETWEEN '2004-01-01' AND '2008-12-31';

# Traer el título de las películas con el rating mayor a 3, con más de 1 premio y con fecha de lanzamiento entre el año 1988 al 2009. Ordenar los resultados por rating.
SELECT M.title FROM MOVIES M where M.rating>3 and M.awards>1 and M.release_date BETWEEN '1988-01-01' AND '2009-12-31' order by M.rating;

CREATE TABLE Planes_internet (
id_plan int NOT NULL,
velocidad float NOT NULL,
precio float NOT NULL,
descuento float NOT NULL,
constraint pk_planes_internet primary key(id_plan)
);

CREATE TABLE Clientes (
id_cliente int NOT NULL,
dni varchar(50) NOT NULL,
nombre varchar(50) NOT NULL,
apellido varchar(50) NOT NULL,
fecha_nacimiento date NOT NULL,
provincia varchar(50) NOT NULL,
ciudad varchar(50) NOT NULL,
id_plan int NOT NULL,
constraint pk_clientes primary key(id_cliente),
constraint fk_id_plan foreign key(id_plan) references Planes_internet (id_plan)
);

