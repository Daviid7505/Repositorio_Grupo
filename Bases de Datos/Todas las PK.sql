-- Creación de todas las PK

-- Creamos la PK de Visitante
alter table `Visitante` add primary key (`DNI`);

-- Creamos la PK de ComunidadAutónoma
alter table `ComunidadAutonoma` add primary key (`CodCA`);

-- Creamos la PK de Especie
alter table `Especie` add primary key (`CodEspecie`);

-- Creamos la PK de Animal
alter table `Animal` add primary key (`CodEspecie`);

-- Creamos la PK de Vegetal
alter table `Vegetal` add primary key (`CodEspecie`);

-- Creamos la PK de Mineral
alter table `Mineral` add primary key (`CodEspecie`);

-- Creamos la PK de ParqueNatural
alter table `ParqueNatural` add primary key (`CodPN`);

-- Creamos la PK para Area 
alter table `Area` add primary key (`NombreA`);

-- Creamos la PK de Vehículo
alter table `Vehiculo` add primary key (`Matricula`);

-- Creamos la PK de Proyecto
alter table `Proyecto` add primary key (`CodProy`);

-- Creamos la PK de Excursión
alter table `Excursion` add primary key (`CodExcursion`);

-- Creo la PK de Alojamiento 
alter table `Alojamiento` add primary key (`CodAlojamiento`);

-- Creamos la PK de Entrada 
alter table `Entrada` add primary key (`CodEntrada`);

-- Creamos la PK de Personal
alter table `Personal` add primary key (`DNI`);

-- Creamos la PK de Conservador
alter table `Conservador` add primary key (`DNI`);

-- Creamos la PK de Vigitante
alter table `Vigilante` add primary key (`DNI`);

-- Creamos la PK de Investigador
alter table `Investigador` add primary key (`DNI`);

-- Creamos la PK de Gestor
alter table `Gestor` add primary key (`DNI`);






