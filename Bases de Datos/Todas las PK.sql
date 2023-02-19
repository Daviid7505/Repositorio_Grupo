-- Creación de todas las PK

-- -- Creamos la PK para Area 
alter table `Area` add primary key (`NombreA`);

-- Creo la PK de Alojamiento 
alter table `Alojamiento` add primary key (`CodAlojamiento`);

-- Creamos la PK de Entrada 
alter table `Entrada` add primary key (`CodEntrada`);

-- Creamos la PK de Personal
alter table `Personal` add primary key (`DNI`);

-- Creamos la PK de Excursión
alter table `Excursión` add primary key (`CodExcursión`);

-- Creamos la PK de Visitante
alter table `Visitante` add primary key (`DNI`);

-- Creamos la PK de ComunidadAutónoma
alter table `ComunidadAutónoma` add primary key (`CodCA`);

-- Creamos la PK de ParqueNatural
alter table `ParqueNatural` add primary key (`CodPN`);

-- Creamos la PK de Especie
alter table `Especie` add primary key (`CodEspecie`);

-- Creamos la PK de Vehículo
alter table `Vehículo` add primary key (`Matrícula`);

