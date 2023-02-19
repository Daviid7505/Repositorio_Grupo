CREATE DATABASE AD_6;
USE AD_6;

CREATE TABLE `VISITANTE`(
`DNI` varchar (15) NOT NULL,
`Nombre` varchar (20) NOT NULL,
`Domicilio` varchar (30) NOT NULL,
`Profesion` varchar (30) NOT NULL);


CREATE TABLE `EV` (
`CodExcursion` int(5) NOT NULL,
`DNI` varchar (15) NOT NULL);

CREATE TABLE `AV` (
`CodAlojamiento` int (5) NOT NULL,
`DNI` varchar (15) NOT NULL,
`Fechainicio` DATE ,
`FechaFin` DATE);

CREATE TABLE `EXCURSION` (
`CodExcursion` int (5) NOT NULL,
`Fecha` DATE,
`Hora` TIME,
`aPIE` int(5) DEFAULT NULL,
`CodAlojamiento` int (5) NOT NULL);

CREATE TABLE `ALOJAMIENTO` (
`CodAlojamiento` int (5) NOT NULL,
`Categoria` varchar (15) NOT NULL,
`Capacidad` int(5) NOT NULL,
`CodPN` int (5) NOT NULL);

CREATE TABLE  `PARQUENATURAL` (
`CodPN` int(5) NOT NULL,
`Nombre` varchar(30) NOT NULL,
`FechaDeclaracion` DATE);


-- Indices de la tabla 'VISITANTE'

ALTER TABLE `VISITANTE`
ADD PRIMARY KEY (DNI),
ADD KEY `DNI`(`DNI`);

-- Indices de la tabla 'EXCURSION'
ALTER TABLE `EXCURSION`
ADD PRIMARY KEY (CodExcursion),
ADD KEY `CodExcursion` (CodExcursion),
ADD KEY `CodAlojamiento` (CodAlojamiento);



-- Indices de la tabla 'EV'
ALTER TABLE `EV`
ADD KEY `CodExcursion`(CodExcursion),
ADD KEY `DNI`(DNI);

-- Indices de la tabla 'AV'
ALTER TABLE `AV`
ADD PRIMARY KEY (FechaInicio),
ADD KEY `FechaInicio` (FechaInicio),
ADD KEY `CodAlojamiento`(CodAlojamiento),
ADD KEY `DNI` (DNI);

-- Indices de la tabla 'PARQUENATURAL'
ALTER TABLE `PARQUENATURAL`
ADD PRIMARY KEY (CodPN),
ADD KEY `CodPN` (CodPN);


-- Filtros para la tabla `EXCURSION`

ALTER TABLE `EXCURSION`
  ADD CONSTRAINT `EXCURSION` FOREIGN KEY (`CodAlojamiento`) REFERENCES `ALOJAMIENTO` (CodAlojamiento)  ON DELETE CASCADE ON UPDATE CASCADE;

-- Filtros para la tabla `ALOJAMIENTO`
ALTER TABLE `ALOJAMIENTO`
ADD CONSTRAINT `ALOJAMIENTO` FOREIGN KEY (`CodPN`) REFERENCES `PARQUENATURAL`(CodPN) ON DELETE CASCADE ON UPDATE CASCADE;

-- Filtros para la tabla `EV`
ALTER TABLE `EV`
ADD CONSTRAINT `EV1` FOREIGN KEY (`CodExcursion`) REFERENCES `EXCURSION` (CodExcursion)  ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `EV2` FOREIGN KEY (`DNI`) REFERENCES `VISITANTE` (DNI)  ON DELETE CASCADE ON UPDATE CASCADE;

-- Filtros para la tabla `AV`
ALTER TABLE `AV`
ADD CONSTRAINT `AV1` FOREIGN KEY (`CodAlojamiento`) REFERENCES `ALOJAMIENTO` (CodAlojamiento)  ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `AV2` FOREIGN KEY (`DNI`) REFERENCES `VISITANTE` (DNI)  ON DELETE CASCADE ON UPDATE CASCADE;

-- Carga de datos

INSERT INTO `VISITANTE` (`DNI`,  `Nombre`, `Domicilio`,`Profesion`) values
('A1254783', 'Alejandro','Calle Navara 13, Madrid', 'Carpintero'),
('A2154876', 'Ana Maria','Calle Somosierra 23, Alcorcon', 'Enfermera '),
('B2541787', 'Cesar','Calle Goya10, Logroño', 'Supervisor '),
('B4787487', 'Carla','Calle Constitucion 8, Rioja', 'Peluquera '),
('A5691276', 'Vicente','Calle Rios 123, Madrid', 'Conductor ');


INSERT INTO `EXCURSION` (`CodExcursion`, `Fecha`, `Hora`, `aPIE`, `CodAlojamiento`) values
(04, '2022-01-15', '09:50', 42 , 015),
(05, '2022-05-21', '11:45', 40 , 017),
(06, '2022-06-13', '13:02', 42 , 010),
(07, '2022-05-21', '11:45', 41 , 014),
(08, '2022-05-21', '11:45', 43 , 019);


INSERT INTO `ALOJAMIENTO` (`CodAlojamiento`, `Categoria`, `Capacidad`, `CodPN`) values
(010, 'Hotel', 50, 500),
(014, 'Pension', 15, 501),
(015, 'Casa Rural', 8, 502),
(017, 'Casa Rural', 12, 503),
(019, 'Apartamento', 4, 504);


INSERT INTO `EV` (`CodExcursion`, `DNI`) values
(04,'A1254783' ),
(05, 'A2154876'),
(06, 'B2541787'),
(07, 'B4787487'),
(08, 'A5691276');
 
 
 INSERT INTO `AV` (`CodAlojamiento`, `DNI`, `FechaInicio`, `FechaFin`) values
(010, 'A1254783', '2022-01-15', '2022-01-22'),
(014, 'A2154876', '2022-05-21', '2022-05-31'),
(015, 'B2541787', '2022-06-13', '2022-06-27'),
(017, 'B4787487', '2022-05-21', '2022-05-28' ),
(019, 'A5691276', '2022-05-21', '2022-05-31');


INSERT INTO`PARQUENATURAL`(`CodPN`, `Nombre`, `FechaDeclaracion`) values
 (500, 'Monfragûe', '2003-03-05'),
 (501, 'Picos de Europa', '1995-05-31'),
 (502, 'Teide', '1954-01-22'),
 (503, 'Timanfaya', '1974-09-17'),
 (504, 'Doñana', '1969-10-27');
