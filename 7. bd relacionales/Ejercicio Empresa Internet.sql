/*SELECT * FROM MOVIES;
SELECT A.first_name, A.last_name, A.rating FROM ACTORS A;
SELECT S.title as Titulo from SERIES S;
SELECT A.first_name, A.last_name FROM ACTORS A WHERE A.RATING>7.5;
SELECT M.title, M.rating, M.awards FROM MOVIES M WHERE M.RATING>7.5 and M.AWARDS>2;
SELECT M.title, M.rating FROM MOVIES M ORDER BY M.rating;
SELECT M.title FROM MOVIES M LIMIT 3;
SELECT * FROM MOVIES M ORDER BY M.rating desc LIMIT 5;
SELECT * FROM ACTORS LIMIT 10;
SELECT M.title, M.rating FROM MOVIES M WHERE M.title like "Toy Story%";
SELECT * FROM ACTORS A WHERE A.first_name like "Sam%";
SELECT M.title FROM MOVIES M where M.release_date BETWEEN '2004-01-01' AND '2008-12-31';
SELECT M.title FROM MOVIES M where M.rating>3 and M.awards>1 and M.release_date BETWEEN '1988-01-01' AND '2009-12-31' order by M.rating;

CREATE TABLE Planes_internet (
id_plan INT NOT NULL,
velocidad float NOT NULL,
precio float NOT NULL,
descuento float NOT NULL,
constraint pk_planes_internet primary key(id_plan)
);

CREATE TABLE Clientes(
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
)
INSERT INTO Planes_internet values (1,50,500,15);
INSERT INTO Planes_internet values (2,25,250,10);
INSERT INTO Planes_internet values (3,10,100,25);
INSERT INTO Planes_internet values (4,100,1000,35);
INSERT INTO Planes_internet values (5,200,2000,45);
INSERT INTO Planes_internet values (6,300,3000,55);
INSERT INTO Planes_internet values (7,400,4000,65);
INSERT INTO Planes_internet values (8,500,5000,75);
INSERT INTO Planes_internet values (9,600,6000,85);
INSERT INTO Planes_internet values (10,700,7000,95);
INSERT INTO Clientes Values(1,12345678,"Juan","Gonzalez",'1990-10-10',"Cordoba","Cordoba",1);
INSERT INTO Clientes Values(2,41551567,"Pedro","Macri",'1980-10-10',"Cordoba","Cordoba",2);
INSERT INTO Clientes Values(3,42342425,"Martin","Massa",'1970-10-10',"Cordoba","Cordoba",3);
INSERT INTO Clientes Values(4,14356356,"Romina","Messi",'1960-10-10',"Cordoba","Cordoba",4);
INSERT INTO Clientes Values(5,63524246,"Rocio","Fernandez",'1991-10-10',"Cordoba","Cordoba",5);
INSERT INTO Clientes Values(6,42612626,"Jorge","Rios",'1978-10-10',"Cordoba","Cordoba",6);
INSERT INTO Clientes Values(7,52362726,"Gaspar","Gonzalez",'1948-10-10',"Cordoba","Cordoba",7);
INSERT INTO Clientes Values(8,62564262,"Maria","Diaz",'1984-10-10',"Cordoba","Cordoba",8);
INSERT INTO Clientes Values(9,34255625,"Ramon","Perez",'1927-10-10',"Cordoba","Cordoba",9);
INSERT INTO Clientes Values(10,6265626,"Carlos","Dominguez",'1984-10-10',"Cordoba","Cordoba",10);*/

SELECT * FROM CLIENTES;
SELECT * FROM Planes_internet;
SELECT C.* FROM CLIENTES C LEFT JOIN Planes_Internet P on C.id_plan=p.id_plan WHERE P.velocidad>=100;
SELECT C.* FROM CLIENTES C WHERE C.nombre like "R%";
SELECT C.*, P.* FROM CLIENTES C INNER JOIN Planes_Internet P on C.id_plan=p.id_plan;
SELECT C.* FROM CLIENTES C WHERE C.fecha_nacimiento >= '1980-01-01';
SELECT C.dni, C.nombre, C.apellido FROM CLIENTES C LEFT JOIN Planes_Internet P on C.id_plan=p.id_plan WHERE c.ciudad like "Cordoba" and P.velocidad<=100; 
