-- Creamos la PK de Animal
alter table `Animal` add primary key (`CodEspecie`),
add constraint `Animal FK1` foreign key  (`CodEspecie`) references `Especie` (`CodEspecie`) ON DELETE CASCADE;


-- Creamos la PK de Vegetal
alter table `Vegetal` add primary key (`CodEspecie`),
add constraint `Vegetal Fk1` foreign key (`CodEspecie`) references `Especie` (`CodEspecie`) ON DELETE CASCADE;

-- Creamos la PK de Mineral
alter table `Mineral` add primary key (`CodEspecie`),
add constraint `Mineral FK1` foreign key (`CodEspecie`) references `Especie` ( `CodEspecie`) ON DELETE CASCADE;

-- Restricciones CA-PN
alter table `ca-pn`
add key (`CodCA`),
add key (`CodPN`),
add constraint `CA-PN FK1` foreign key (`CodCA`) references ComunidadAutonoma (`CodCA`) ON DELETE CASCADE,
add constraint `CA-PN FK2` foreign key (`CodPN`) references ParqueNatural (`CodPN`) ON DELETE CASCADE;

-- Restricciones E-V 
alter table `e-v`
add key (`CodExcursion`),
add key (`DNI`),
add constraint `E-V FK1` foreign key (`CodExcursion`) references Excursion (`CodExcursion`) ON DELETE CASCADE,
add constraint `E-V FK2` foreign key (`DNI`) references Visitante (`DNI`) ON DELETE CASCADE;

-- Restricciones A-V 
alter table `a-v`
add primary key (`FechaInicio`),
add key (`CodAlojamiento`),
add key (`DNI`),
add constraint `A-V FK1` foreign key (`CodAlojamiento`) references Alojamiento (`CodAlojamiento`) ON DELETE CASCADE,
add constraint `A-V FK2` foreign key (`DNI`) references Visitante (`DNI`) ON DELETE CASCADE;
