use ad_6;
create view FECHA_DNI as
select  excursion.Fecha, `e-v`.DNI
-- Uniremos las talbas e-v + excursión
FROM `e-v` -- Indico la tabla inicial
	JOIN Excursion -- Le digo con que tabla la quiero unir
		ON `e-v`.CodExcursion=Excursion.CodExcursion -- Pongo la condición que se debe de cumplir para unir las tablas
        
-- Condición
where excursion.aPie like 'si';

select * from FECHA_DNI;