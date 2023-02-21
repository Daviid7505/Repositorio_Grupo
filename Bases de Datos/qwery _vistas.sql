use ad_6;

create view Excursiones_a_pie as
select DNI, fecha, aPie
from excursion, e_v
where excursion.CodExcursion = e_v.CodExcursion; 
