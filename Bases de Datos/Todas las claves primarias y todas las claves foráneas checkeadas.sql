alter table `ParqueNatural` add primary key (`CodPN`);

alter table `Animal`add primary key (`CodEspecie`);

alter table `Vegetal`add primary key (`CodEspecie`);

alter table `mineral`add primary key (`CodEspecie`);

alter table `Area` add primary key (`NombreA`);

alter table `Alojamiento` add primary key (`CodAlojamiento`);

alter table `Entrada` add primary key (`CodEntrada`);

alter table `Personal` add primary key (`DNI`);

alter table `Excursion` add primary key (`CodExcursion`);

alter table `Visitante` add primary key (`DNI`);

alter table `ComunidadAutónoma` add primary key (`CodCA`);

alter table `Especie` add primary key (`CodEspecie`);

alter table`E-V`add primary key (`CodExcursion`);

alter table`Investigador`add primary key (`DNI`);

alter table `a-v` add primary key (`fechainicio`);

alter table `vigilante`add primary key (`DNI`); 

alter table `vehiculo`add primary key (`Matrícula`);

alter table `Proyecto`add primary key (`CodProy`);

alter table `gestor`add primary key (`DNI`);

alter table `conservador` add primary key (`DNI`);


-- Genero las claves Foráneas

-- Creamos la FK de Area referencia ParqueNatural
alter table `Area`add foreign key (`CodPN`) references `ParqueNatural`(`CodPN`) on delete restrict;

-- Creamos la FK de Personal que referencia ParqueNatural
alter table `Personal` add foreign key (`CodPN`) references `ParqueNatural`(`CodPN`) on delete cascade;

-- Creamos la FK de Entrada que referencia Parquenatural
alter table `Entrada` add foreign key (`CodPN`) references `ParqueNatural`(`CodPN`) on delete cascade;

-- Creamos la FK de AV que referencia Alojamiento
alter table `a-v` add foreign key (`CodAlojamiento`) references `Alojamiento`(`CodAlojamiento`) on delete cascade;

-- Creamos la FK de e-v que referencia Excursion
alter table `e-v` add foreign key (`CodExcursion`) references `excursion`(`CodExcursion`) on delete cascade;

-- Creamos la FK de e-v que referencia Visitante
alter table `e-v` add foreign key (`DNI`) references `visitante`(`DNI`) on delete cascade;

-- Creamos la FK de Investigador que referencia personal
alter table `Investigador` add foreign key (`DNI`) references `Personal`(`DNI`) on delete cascade;

-- Creamos la FK de I-P que referencia Investigador
alter table `I-P` add foreign key (`DNI`) references `Investigador`(`DNI`) on delete cascade;

-- Creamos la FK de Excursion que referncia Alojamiento 
alter table `excursion` add foreign key (`CodAlojamiento`) references `Alojamiento`(`CodAlojamiento`) on delete cascade;

-- Creamos la FK de Alojamiento que referencia  PN
alter table `Alojamiento` add foreign key (`CodPN`) references `ParqueNatural`(`CodPN`) on delete cascade;

-- Creamos la FK de A-V que referencia Alojamiento
alter table `A-V` add foreign key (`CodAlojamiento`) references `Alojamiento`(`CodAlojamiento`) on delete cascade;

-- Creamos la FK de A-V que referencia Visitante
alter table `A-V` add foreign key (`DNI`) references `Visitante`(`DNI`) on delete cascade;

-- Creamos la FK de ca-pn que referencia Comunidad Autónoma
alter table `ca-pn` add foreign key (`CodCA`) references `ComunidadAutonoma`(`CodCA`) on delete cascade;

-- Creamos la FK de ca-pn que referencia PN
alter table `ca-pn` add foreign key (`CodPN`) references `ParqueNatural`(`CodPN`) on delete cascade;

-- Creamos la FK de e-a que referencia Especie
alter table `e-a` add foreign key (`CodEspecie`) references `Especie`(`CodEspecie`) on delete cascade;

-- Creamos la FK de e-a que referencia Area
alter table `e-a` add foreign key (`CodArea`) references `Area`(`NombreA`) on delete cascade;

-- Creamos la FK de animal que referencia Especie
alter table `animal` add foreign key (`CodEspecie`) references `Especie`(`CodEspecie`) on delete cascade;

-- Creamos la FK de vegetal que referencia Especie
alter table `vegetal` add foreign key (`CodEspecie`) references `Especie`(`CodEspecie`) on delete cascade;

-- Creamos la FK de mineral que referencia Especie
alter table `mineral` add foreign key (`CodEspecie`) references `Especie`(`CodEspecie`) on delete cascade;

-- Creamos la FK de vehículo que referencia vigilante
alter table `vehiculo` add foreign key (`DNI`) references `vigilante`(`DNI`) on delete cascade;

-- Creamos la FK de I-P que referencia Proyecto
alter table `i-p` add foreign key (`CodProy`) references `Proyecto`(`CodProy`) on delete cascade;

-- Creamos la FK de I-P que referencia Investigador
alter table `i-p` add foreign key (`DNI`) references `Investigador`(`DNI`) on delete cascade;

-- Creamos la FK de Proyecto que referencia Especie
alter table `Proyecto` add foreign key (`CodEspecie`) references `Especie`(`CodEspecie`) on delete cascade;

-- Creamos la FK de Gestor que referencia Personal
alter table `gestor` add foreign key (`DNI`) references `Personal`(`DNI`) on delete cascade;

-- Creamos la FK de Gestor que referencia Entrada
alter table `gestor` add foreign key (`CodEntrada`) references `Entrada`(`CodEntrada`) on delete cascade;

-- Creamos la FK de Investigador que referencia Personal
alter table `Investigador` add foreign key (`DNI`) references `Personal`(`DNI`) on delete cascade;

-- Creamos la FK de vigilante que referencia Area
alter table `vigilante` add foreign key (`NombreA`) references `Area`(`NombreA`) on delete cascade;

-- Creamos la FK de vigilante que referencia Personal
alter table `vigilante` add foreign key (`DNI`) references `Personal`(`DNI`) on delete cascade;

-- Creamos la FK de conservador que referencia Personal
alter table `conservador` add foreign key (`DNI`) references `Personal`(`DNI`) on delete cascade;

-- Creamos la FK de conservador que referencia Area
alter table `conservador` add foreign key (`NombreA`) references `Area`(`NombreA`) on delete cascade;
