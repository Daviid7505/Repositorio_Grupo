-- Este ejercicio se ha realizado para el entorno MYSQL
--------------------------------------------------------

--
-- Creación de la base de datos AD_6:
--

CREATE DATABASE IF NOT EXISTS AD_6;
USE AD_6;

--
-- Desactivo restricciones de integridad para poder insertar en claves ajenas
--

SET FOREIGN_KEY_CHECKS = 0;

--
-- CREACION DE TABLAS:
--

--
-- Estructura de tabla para la tabla `Visitante`:
--

CREATE TABLE `visitante`(
`DNI` char (9) COMMENT 'DNI del visitante',
`Nombre` varchar (20) COMMENT 'Nombre del visitante',
`Domicilio` varchar (30) COMMENT 'domicilio del visitante',
`Profesion` varchar (30) COMMENT 'profesión del visitante');

--
-- Estructura de tabla para la tabla `ComunidadAutonoma`:
--

create table `Comunidad_Autonoma` (
`CodCA` int(8) COMMENT 'Código de Comunidad Autónoma',
`Nombre` varchar(25) COMMENT 'Nombre de la CA',
`OrgResponsable` varchar(30) COMMENT 'Organismo responsable');

--
-- Estructura de tabla para la tabla `CA-PN`:
--

create table `CA_PN` (
`CodCA` int(8) COMMENT 'Código de Comunidad Autónoma del Parque Natural',
`CodPN` int(5) COMMENT 'Còdigo del Parque Natural',
`Superficie` float(10) COMMENT 'Superficie en km del Parque Natural');

--
-- Estructura de tabla para la tabla `Especie`:
--

CREATE TABLE `Especie` (
  `CodEspecie` int(4) COMMENT 'código de la especie',
  `NombreCientifico` varchar(25) COMMENT 'nombre científico de la especie',
  `NombreVulgar` varchar(25) COMMENT 'nombre vulgar de la especie'  
);

--
-- Estructura de tabla para la tabla `Animal`:
--

CREATE TABLE `Animal` ( 
	`CodEspecie` int(4) COMMENT 'código de la especie',
    `Alimentacion` varchar (25) COMMENT 'tipo de alimentación',
    `Periodo de celo` varchar (15) COMMENT 'período de celo'
);

--
-- Estructura de tabla para la tabla `Vegetal`:
--

CREATE TABLE `Vegetal` (
  `CodEspecie` int(4) COMMENT 'Código de especie',
  `Floracion` varchar(25) COMMENT 'Floracion',
  `PeriodoFloracion` varchar(25) COMMENT 'Periodo de floracion' 
);

--
-- Estructura de tabla para la tabla `Mineral`:
--

CREATE TABLE `Mineral` (
  `CodEspecie` int(4) COMMENT 'Código de especie',
  `Tipo` varchar(25) COMMENT 'Tipo de mineral'
);

--
-- Estructura de tabla para la tabla `E-V`:
--

CREATE TABLE `E_V` (
`CodExcursion` int(5) NOT NULL COMMENT 'código de la excursión',
`DNI` char (9) NOT NULL) COMMENT 'DNI del visitante FK';

--
-- Estructura de tabla para la tabla `A-V`:
--

CREATE TABLE `A_V` (
`CodAlojamiento` int (5) COMMENT 'código del alojamiento',
`DNI` char (9)  COMMENT 'DNI del visitante FK',
`Fechainicio` DATE COMMENT 'fecha de inicio' ,
`FechaFin` DATE) COMMENT 'fecha de finalización';

--
-- Estructura de tabla para la tabla `ParqueNatural`:
--

create table `Parque_Natural` (
`CodPN` int(5) COMMENT 'Còdigo del Parque Natural',
`Nombre` varchar(20) COMMENT 'Nombre del PN',
`FechaDeclaracion` DATE COMMENT 'Fecha de declaración del PN');

--
-- Estructura de tabla para la tabla `E-A`:
--

create table `E_A` (
`CodEspecie` int(4) COMMENT 'Código de la especie del PN',
`CodArea` varchar(20) COMMENT 'Código de área del PN',
`CantIndividuos` int(10) COMMENT 'Cantidad de individuos de la especie');

--
-- Estructura de tabla para la tabla `Area`:
--

CREATE TABLE `Area`(
	`NombreA` varchar (15) COMMENT 'nombre del área',
    `Extension km` int (10) COMMENT 'extensión en km',
    `CodPN` int (5) COMMENT 'código de parque natural FK'
);

--
-- Estructura de tabla para la tabla `Vehiculo`:
--

CREATE TABLE `Vehiculo`(
	`Matricula` varchar (10) COMMENT 'matrícula del vehículo',
    `Tipo` varchar (25) COMMENT 'tipo de vehículo',
    `DNI` char (9) COMMENT 'DNI del vigilante FK'
);

--
-- Estructura de tabla para la tabla `I-P`:
--

CREATE TABLE `I_P` (
  `CodProy` int(4) COMMENT 'Codigo de proyecto',
  `DNI` char(9) COMMENT 'DNI'
);

--
-- Estructura de tabla para la tabla `Proyecto`:
--

CREATE TABLE `Proyecto` (
  `CodProy` int(4) COMMENT 'Codigo de proyecto',
  `Presupuesto` int(5) COMMENT 'Presupuesto',
  `FechaInicio` date COMMENT 'Fecha de inicio del pro',
  `FechaFin` date COMMENT 'Fecha de fin del proyecto',
  `CodEspecie` int(4) COMMENT 'Código de especie'
);

--
-- Estructura de tabla para la tabla `Excursion`:
--

CREATE TABLE `Excursion` (
`CodExcursion` int(5) COMMENT 'código de la excursión PK',
`Fecha` DATE COMMENT 'fecha de la excursión',
`Hora` TIME COMMENT 'hora de la excursión',
`aPie` int(5) COMMENT 'modalidad de la excursión',
`CodAlojamiento` int (5) COMMENT 'código del alojamiento FK');

--
-- Estructura de tabla para la tabla `Alojamiento`:
--

CREATE TABLE `Alojamiento` (
`CodAlojamiento` int (5) COMMENT 'código del alojamiento PK',
`Categoria` varchar (15) COMMENT 'categoría del alojamiento',
`Capacidad` int(5) COMMENT 'capacidad del alojamiento',
`CodPN` int (5) COMMENT 'código del Parque Natural FK');

--
-- Estructura de tabla para la tabla `Entrada`:
--

create table `Entrada`(
`CodEntrada` int(3) COMMENT 'Código de la entrada al PN PK',
`CodPN` int(5) COMMENT 'Còdigo del Parque Natural FK');

--
-- Estructura de tabla para la tabla `Personal`:
--

create table `Personal`(
`DNI` char(9) COMMENT 'DNI del empleado PK',
`NSS` varchar(20) Unique COMMENT 'Número de seguridad socal',
`Nombre` varchar(20) COMMENT 'Nombre del empleado' ,
`Apellidos` varchar(30) COMMENT 'Apellidos del empelado', 
`TfnoDomicilio` int(10) COMMENT 'Teléfono del domicilio particular',
`TfnoMovil` int(10) COMMENT 'Teléfono móvil particular',
`Sueldo` float(10) COMMENT 'Sueldo del empleado',
`CodPN` int(5) COMMENT 'Còdigo del Parque Natural FK');

--
-- Estructura de tabla para la tabla `Conservador`:
--

CREATE TABLE `Conservador`(
	`DNI` char (9) COMMENT 'DNI del conservador PK',
    `Tarea` varchar (20) COMMENT 'tarea que realiza',
    `NombreA` varchar (15) COMMENT 'Nombre del área FK'
);

--
-- Estructura de tabla para la tabla `Vigilante`:
--

CREATE TABLE `Vigilante`(
	`DNI` char (9) COMMENT 'DNI del vigilante PK',
    `NombreA` varchar (25) COMMENT 'Nombre del área FK'
);

--
-- Estructura de tabla para la tabla `Investigador`:
--

CREATE TABLE `Investigador` (
  `DNI` char(9) COMMENT 'DNI PK',
  `Titulacion` varchar(25) COMMENT 'Titulacion'
);

--
-- Estructura de tabla para la tabla `Gestor`:
--

CREATE TABLE `gestor` (
  `DNI` char(9) COMMENT 'DNI del gestor PK',
  `CodEntrada` int(3) COMMENT 'Codigo de entrada FK'
);

--
-- CARGA DE DATOS:
--

--
-- Insertamos datos en la tabla `Visitante`:
--

INSERT INTO `Visitante` (`DNI`,  `Nombre`, `Domicilio`,`Profesion`) values
('A1254783', 'Alejandro','Calle Navara 13, Madrid', 'Carpintero'),
('A2154876', 'Ana Maria','Calle Somosierra 23, Alcorcon', 'Enfermera '),
('B2541787', 'Cesar','Calle Goya10, Logroño', 'Supervisor '),
('B4787487', 'Carla','Calle Constitucion 8, Rioja', 'Peluquera '),
('A5691276', 'Vicente','Calle Rios 123, Madrid', 'Conductor ');

--
-- Insertamos datos en la tabla `ComunidadAutonoma`:
--

insert into `Comunidad_Autonoma` (`CodCA`, `Nombre`, `OrgResponsable`) values 
(100, 'Extremadura', 'Cáceres'),
(101, 'León', 'Asturias'),
(102,'Tenerife', 'Las Palmas'),
(103, 'Lanzarote', 'Las Palmas'),
(104, 'Huelva', 'Huelva');

--
-- Insertamos datos en la tabla `CA-PN`:
--

insert into `CA_PN` (`CodCA`, `CodPN`, `Superficie`) values 
(100, 500, 86200), 
(101, 501, 15310),
(102, 502, 11704),
(103, 503, 17800),
(104, 504, 65431); 

--
-- Insertamos datos en la tabla `Especie`:
--

INSERT INTO `Especie` (`CodEspecie`, `NombreCientifico`, `NombreVulgar`) VALUES
(20001,'Panthera leo', 'León'),
(20002,'Elephas maximus','Elefante asiático'),
(20003,'Gorilla beringei','Gorila de montaña'),
(20004,'Felis catus','Gato doméstico'),
(20005,'Canis lupus','Lobo gris'),
(20006,'Helianthus annuu','Girasol'),
(20007,'Bellis perennis','Margarita'),
(20008,'Jasminum officinale','Jazmin'),
(20009,'Pinus canariensi','Pino canario'),
(20010,'Pteridium aquilinum', 'Helecho'),
(20011,'Corcidus sarfo','Cuarzo'),
(20012,'Anthirinum lapirus','Antracita'),
(20013,'Aureus trius','Oro'),
(20014,'Chlostrinum virum','Cristobalita'),
(20015,'Lapidopter amaticum','Amatista');

--
-- Insertamos datos en la tabla `Animal`:
--

INSERT INTO `Animal` (`CodEspecie`, `Alimentacion`, `Periodo de celo`) VALUES
(20001, 'Carnívoro', 'Todo el año'),
(20002, 'Herbívoro', 'Variable'),
(20003, 'Herbívoro', 'Variable'),
(20004, 'Carnívoro', 'Todo el año'),
(20005, 'Carnívoro', 'Variable');

--
-- Insertamos datos en la tabla `Vegetal`:
--

INSERT INTO `Vegetal` (`CodEspecie`, `Floracion`, `PeriodoFloracion`) VALUES
(20006, 'marzo', 'marzo a mayo'),
(20007, 'febrero', 'febrero a julio'),
(20008, 'abril', 'abril a junio'),
(20009, 'marzo', 'marzo a julio'),
(20010, 'mayo', 'mayo a junio');

--
-- Insertamos datos en la tabla `Mineral`:
--

INSERT INTO `Mineral` (`CodEspecie`, `Tipo`) VALUES
(20011, 'Nativo'),
(20012, 'Silicato'),
(20013, 'Nitrato'),
(20014, 'Cromato'),
(20015, 'Halogenuro');

--
-- Insertamos datos en la tabla `E-V`:
--

INSERT INTO `E_V` (`CodExcursion`, `DNI`) values
(04,'A1254783' ),
(05, 'A2154876'),
(06, 'B2541787'),
(07, 'B4787487'),
(08, 'A5691276');

--
-- Insertamos datos en la tabla `A-V`:
-- 
 
 INSERT INTO `A_V` (`CodAlojamiento`, `DNI`, `FechaInicio`, `FechaFin`) values
(010, 'A1254783', '2022-01-15', '2022-01-22'),
(014, 'A2154876', '2022-02-21', '2022-02-28'),
(015, 'B2541787', '2022-06-13', '2022-06-27'),
(017, 'B4787487', '2022-04-21', '2022-04-28' ),
(019, 'A5691276', '2022-05-21', '2022-05-31');

--
-- Insertamos datos en la tabla `ParqueNatural`:
--

insert into `Parque_Natural`(`CodPN`, `Nombre`, `FechaDeclaracion`) values 
(500, 'Monfragûe', '2007-05-03'),
(501, 'Picos de Europa', '1995-05-31'),
(502, 'Teide', '1954-01-22'),
(503, 'Timanfaya', '1974-09-17'),
(504, 'Doñana', '1969-10-27');

--
-- Insertamos datos en la tabla `E-A`:
--

insert into `E_A` (`CodEspecie`, `CodArea`, `CantIndividuos`) values
(20001, 'León', 2800), 
(20002, 'Sevilla', 1500),
(20003, 'Huelva', 2350),
(20004, 'Tenerife', 14120),
(20005, 'Extremadura', 3105); 

--
-- Insertamos datos en la tabla `Area`:
--

INSERT INTO `Area` (`NombreA`, `Extension km`, `CodPN`) VALUES
('Huelva',3081,500),
('Extremadura',6641,501),
('León',8983,502),
('Sevilla',19485,503),
('Tenerife',18346,504);

--
-- Insertamos datos en la tabla `Vehiculo`:
--

INSERT INTO `Vehiculo` (`Matricula`, `Tipo`, `DNI`) VALUES
('2456GBC', 'Sedán', '12345678A'),
('8910KLM', 'SUV', '23456789B'),
('5678FGH', 'Coupe', '34567890C'),
('4321ZYX', 'Hatchback','45678901D'),
('9876VUT', 'Pickup', '56789012E');

--
-- Insertamos datos en la tabla `I-P`:
--

INSERT INTO `I_P` (`CodProy`, `DNI`) VALUES
(1459, '45879655W'),
(6541, '35641528G'),
(3598, '74596348R'),
(3247, '45879524B'),
(5812, '24598644E');

--
-- Insertamos datos en la tabla `Proyecto`:
--

INSERT INTO `Proyecto` (`CodProy`, `Presupuesto`, `FechaInicio`, `FechaFin`, `CodEspecie`) VALUES
(1459, 45000, '2020-05-14', '2023-05-14', 20000),
(6541, 25000, '2018-02-03', '2025-02-13', 20005),
(3598, 30000, '2005-08-09', '2024-08-09', 20003),
(3247, 28000, '2016-11-01', '2026-11-01', 20001),
(5812, 34000, '2020-07-25', '2023-07-25', 20009);

--
-- Insertamos datos en la tabla `Excursion`:
--

INSERT INTO `Excursion` (`CodExcursion`, `Fecha`, `Hora`, `aPie`, `CodAlojamiento`) values
(04, '2022-01-15', '09:50', 42 , 015),
(05, '2022-05-21', '11:45', 40 , 017),
(06, '2022-06-13', '13:02', 42 , 010),
(07, '2022-05-21', '11:45', 41 , 014),
(08, '2022-05-21', '11:45', 43 , 019);

--
-- Insertamos datos en la tabla `Alojamiento`:
--

INSERT INTO `Alojamiento` (`CodAlojamiento`, `Categoria`, `Capacidad`, `CodPN`) values
(010, 'Hotel', 50, 500),
(014, 'Pension', 15, 501),
(015, 'Casa Rural', 8, 502),
(017, 'Casa Rural', 12, 503),
(019, 'Apartamento', 4, 504);

--
-- Insertamos datos en la tabla `Entrada`:
--

insert into `Entrada` (`CodEntrada`, `CodPN`) values 
(20, 500),
(21, 501),
(22, 502),
(23, 503), 
(24, 504);

--
-- Insertamos datos en la tabla `Personal`:
--

insert into `Personal` (`DNI`, `NSS`, `Nombre`, `Apellidos`, `TfnoDomicilio`, `TfnoMovil`, `Sueldo`, `CodPN`) values 
('45879655W', '29890765', 'Ana', 'García Navarro', 977865456, 65478901, 1200, 500), 
('14835912H', '17649076', 'Juan', 'Arce Salgado', 954865001, 62378901, 1500, 500),
('74821544P', '19890905', 'Ema', 'Ferro Ulloa', 911007612, 663789477, 1200, 500),
('78514286K', '17890765', 'Pedro', 'Pou Sarda', 983865075, 633789103, 1300, 501), 
('75412388Y', '09890765', 'Sara', 'Vilas Fhur', 911334678, 623009008, 1800, 501),
('41879612S', '15890765', 'Teresa', 'Martínez Morgade', 977012012, 633330887, 1800, 501), 
('25847165V', '12890765', 'Belén', 'Soria Stewart', 977865456, 663876876, 1800, 502), 
('74954722Q', '29111765', 'Fabio', 'Flores Carretel', 911123456, 66918923, 1700, 502),
('74578433C', '55890765', 'Didac', 'Gasol Martín', 945865456, 663122777, 1600, 503), 
('74954177Z', '44044055', 'Ricardo', 'Machado Verne', 977000669, 655320033, 1500, 503), 
('12345678A', '33200882', 'Carmen', 'Parra Ribot', 911322467, 663121212, 1700, 504), 
('23456781B', '45566700', 'Sandra', 'Pla Verez', 977889955, 623500500, 1800, 504),
('34567899C', '90876901', 'Ana', 'Calas Vera', 988675555, 663267788, 1700, 504), 
('45678901D', '20065434', 'Martín', 'Leiva Pérez', 965345561, 633221199, 1600, 502),
('56789012E', '50089764', 'Rosa', 'Méndez Paz', 912321111, 688901234, 1750, 501),
('12345670A', '70145632', 'Horacio', 'Suárez Gala', 934512123, 622100789, 1550, 503),
('23456789B', '609775443', 'José', 'Esteban Prol', 933442277, 611009007, 1850, 500), 
('34567890C', '55449900', 'Laura', 'Juanes Voight', 988706534, 622123456, 1900, 502),
('45678905D', '77732100', 'Felipe', 'Saldívar Lorenzo', 955433211, 611090987, 1950, 500),
('56789017E', '66430012', 'Romina', 'Graff Estévez', 97654340, 664991038, 1800, 500);

--
-- Insertamos datos en la tabla `Conservador`:
--

INSERT INTO `Conservador` (`DNI`, `Tarea`, `NombreA`) VALUES
('12345670A', 'Conducir visitantes', 'Sevilla'),
('23456789B', 'Reparar jaula loros', 'Tenerife'),
('34567899C', 'Limpieza cuadra', 'Extremadura'),
('45678901D', 'Alimentar patos', 'Huelva'),
('56789012E', 'Entrenar delfines', 'León');

--
-- Insertamos datos en la tabla `Vigilante`:
--

INSERT INTO `Vigilante` (`DNI`, `NombreA`) VALUES
('12345678A', 'Sevilla'),
('23456781B', 'Sevilla'),
('34567890C', 'León'),
('45678905D', 'Tenerife'),
('56789017E', 'Extremadura');

--
-- Insertamos datos en la tabla `Investigador`:
--

INSERT INTO Investigador (`DNI`, Titulacion) VALUES
('41879612S', 'Biomedicina'),
('25847165V', 'Botanica'),
('74954722Q', 'Geologia'),
('74578433C', 'Zoologia'),
('74954177Z', 'Fisiologia Animal');

--
-- Insertamos datos en la tabla `Gestor`:
--

INSERT INTO Gestor (`DNI`, CodEntrada) VALUES
('45879655W', 478),
('14835912H', 657),
('74821544P', 412),
('78514286K', 985),
('75412388Y', 753);

--
-- Activo restricciones de integridad para mantener integridad referencial
--

SET FOREIGN_KEY_CHECKS = 1;

--
-- Confirmo los cambios realizados
--

COMMIT;

use ad_6;

alter table `Parque_Natural` add primary key (`CodPN`);

alter table `Animal`add primary key (`CodEspecie`);

alter table `Vegetal`add primary key (`CodEspecie`);

alter table `mineral`add primary key (`CodEspecie`);

alter table `Area` add primary key (`NombreA`);

alter table `Alojamiento` add primary key (`CodAlojamiento`);

alter table `Entrada` add primary key (`CodEntrada`);

alter table `Personal` add primary key (`DNI`);

alter table `Excursion` add primary key (`CodExcursion`);

alter table `Comunidad_Autonoma` add primary key (`CodCA`);

alter table `Especie` add primary key (`CodEspecie`);

alter table`E_V`add primary key (`CodExcursion`, `DNI`);

alter table`Investigador`add primary key (`DNI`);

alter table `a_v` add primary key (`fechainicio`, `CodAlojamiento`, `DNI`);

alter table `vigilante`add primary key (`DNI`); 

alter table `vehiculo`add primary key (`Matricula`);

alter table `Proyecto`add primary key (`CodProy`);

alter table `gestor`add primary key (`DNI`);

alter table `conservador` add primary key (`DNI`);

alter table `ca_pn`add primary key (`CodCa`, `CodPN`);

alter table `e_a` add primary key (`CodEspecie`, `CodArea`);


-- Genero las claves Foráneas
SET FOREIGN_KEY_CHECKS = 0;

-- Creamos la FK de Area referencia ParqueNatural
alter table `Area`add foreign key (`CodPN`) references `Parque_Natural`(`CodPN`) on delete restrict;

-- Creamos la FK de Personal que referencia ParqueNatural
alter table `Personal` add foreign key (`CodPN`) references `Parque_Natural`(`CodPN`) on delete cascade;

-- Creamos la FK de Entrada que referencia Parquenatural
alter table `Entrada` add foreign key (`CodPN`) references `Parque_Natural`(`CodPN`) on delete cascade;

-- Creamos la FK de AV que referencia Alojamiento
alter table `a_v` add foreign key (`CodAlojamiento`) references `Alojamiento`(`CodAlojamiento`) on delete cascade;

-- Creamos la FK de e-v que referencia Excursion
alter table `e_v` add foreign key (`CodExcursion`) references `excursion`(`CodExcursion`) on delete cascade;

-- Creamos la FK de e-v que referencia Visitante
alter table `e_v` add foreign key (`DNI`) references `visitante`(`DNI`) on delete cascade;

-- Creamos la FK de Investigador que referencia personal
alter table `Investigador` add foreign key (`DNI`) references `Personal`(`DNI`) on delete cascade;

-- Creamos la FK de I-P que referencia Investigador-------------------------------
alter table `I_P` add foreign key (`DNI`) references `Investigador`(`DNI`) on delete cascade;

-- Creamos la FK de Excursion que referncia Alojamiento 
alter table `excursion` add foreign key (`CodAlojamiento`) references `Alojamiento`(`CodAlojamiento`) on delete cascade;

-- Creamos la FK de Alojamiento que referencia  PN
alter table `Alojamiento` add foreign key (`CodPN`) references `Parque_Natural`(`CodPN`) on delete cascade;

-- Creamos la FK de A-V que referencia Alojamiento
alter table `A_V` add foreign key (`CodAlojamiento`) references `Alojamiento`(`CodAlojamiento`) on delete cascade;

-- Creamos la FK de A-V que referencia Visitante
alter table `A_V` add foreign key (`DNI`) references `Visitante`(`DNI`) on delete cascade;

-- Creamos la FK de ca-pn que referencia Comunidad Autónoma
alter table `ca_pn` add foreign key (`CodCA`) references `Comunidad_Autonoma`(`CodCA`) on delete cascade;

-- Creamos la FK de ca-pn que referencia PN
alter table `ca_pn` add foreign key (`CodPN`) references `Parque_Natural`(`CodPN`) on delete cascade;

-- Creamos la FK de e-a que referencia Especie
alter table `e_a` add constraint `CodEspecie` foreign key (`CodEspecie`) references `Especie`(`CodEspecie`) on delete cascade on update cascade;

-- Creamos la FK de e-a que referencia Area
alter table `e_a` add foreign key (`CodArea`) references `Area`(`NombreA`) on delete cascade;

-- Creamos la FK de animal que referencia Especie
alter table `animal` add foreign key (`CodEspecie`) references `Especie`(`CodEspecie`) on delete cascade;

-- Creamos la FK de vegetal que referencia Especie
alter table `vegetal` add foreign key (`CodEspecie`) references `Especie`(`CodEspecie`) on delete cascade;

-- Creamos la FK de mineral que referencia Especie
alter table `mineral` add foreign key (`CodEspecie`) references `Especie`(`CodEspecie`) on delete cascade;

-- Creamos la FK de vehículo que referencia vigilante
alter table `vehiculo` add foreign key (`DNI`) references `vigilante`(`DNI`) on delete cascade;

-- Creamos la FK de I-P que referencia Proyecto
alter table `i_p` add foreign key (`CodProy`) references `Proyecto`(`CodProy`) on delete cascade;

-- Creamos la FK de I-P que referencia Investigador
alter table `i_p` add foreign key (`DNI`) references `Investigador`(`DNI`) on delete cascade;

-- Creamos la FK de Proyecto que referencia Especie
alter table `Proyecto` add foreign key (`CodEspecie`) references `Especie`(`CodEspecie`);

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

SET FOREIGN_KEY_CHECKS = 1;

-- Creamos la vista 
-- Sentencia para crear la vista CREATE VIEW NombreVista AS
CREATE VIEW ExcursionAPie AS

-- Consulta SELECT para que muestre los campos dni, fecha y aPie
SELECT Vis.DNI, Exc.Fecha, Exc.aPie as A_pie

-- FROM indica las tablas que se participan en la relacion de la tabla Visitante y Excursión
FROM Visitante as Vis, e_v as ev, Excursion as Exc

-- WHERE define las relaciones que hay entre las tablas del FROM a traves de su PK y FK y asigna la condición que debe cumplir el campo aPie de la tabla Excursion
WHERE Vis.DNI = ev.DNI AND ev.CodExcursion = Exc.CodExcursion AND Exc.aPie like 'Si';
