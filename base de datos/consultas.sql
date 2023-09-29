-- selecciono la base x defecto
use pubs;

-- estructura de la tabla titles
describe titles;

-- tablas de la base seleccionada
show tables;

-- queries
select * from authors;

select 	21 as IVA,
		title as libro,
        type categoria,
		price precio,
        price * 1.21 as 'Precio con IVA'
        
from	titles;

-- filtros (clausula WHERE)
-- listar los libros cuyo precio este entre 10 y 20 U$s
select	*
from	titles
-- where	price not between 10 and 20;
where	price between 10 and 20;


-- listar los puestos de trabajo de diseñador, editor y editorial
select	*
from 	jobs
-- where 	job_desc not in ('designer','editor','publisher');
where 	job_desc in ('designer','editor','publisher');

-- listar los autores cuyo nombre empiece con m y termine con l
select	*
from	authors
where	au_fname like 'm%l';

-- listar los empleados cuyo nombre empiece con m,
-- el 2do caracter sea cualquiera, el 3er caracter 
-- sea r y termine de cualquier manera.
select	*
from	employee
where	fname like 'm_r%';

-- listar los libros publicados durante el 2do semestre de 1990
select 	* 
from 	titles
where	year(pubdate) = 1990
and		month(pubdate) between 7 and 12;

-- ordenar los libros que no sean de cocina por precio descendente. 
-- Si empatan en precio, desempatar por titulo en forma alfabetica
select 		* 
from 		titles
where		type not like '%cook%'
order by	price desc, title;

-- de la ultima query, traer los 3 primeros registros
select 		* 
from 		titles
where		type not like '%cook%'
order by	price desc, title
limit		3;

-- funciones agrupadas
select	min(price) 'libro mas barato',
		max(price) 'libro mas caro',
		round(avg(price),3) promedio,
		count(title_id) cantidad,
		sum(price) total
        
from	titles;

-- agrupaciones
-- listar por categoria la cantidad de titulos
select		type categoria,
			count(title_id) cantidad
from		titles
group by	type;


-- listar por categoria la cantidad de titulos que 
-- no sean de cocina
select		type categoria,
			count(title_id) cantidad
from		titles
where		type not like '%cook%'
group by	type;

-- listar por categoria la cantidad de titulos que 
-- no sean de cocina y cuya cantidad sea mayor que 2.
-- Ordenar por cantidad de titulos descendente.
select		type categoria,
			count(title_id) cantidad
from		titles
where		type not like '%cook%'
group by	type
having		cantidad > 2
order by	2 desc;














select * from jobs



