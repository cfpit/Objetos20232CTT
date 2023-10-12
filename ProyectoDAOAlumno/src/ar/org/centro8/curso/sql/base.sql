create database colegio;

use colegio;

create table alumnos(
    nombre char(20),
    edad int
);

insert into alumnos values
('Juan',25),('Maria',30),('Carlos',40),('Ana',20);

select * from alumnos;