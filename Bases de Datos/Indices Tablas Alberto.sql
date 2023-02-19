--
-- AÑADO LOS INDICES A LAS TABLAS
--

--
-- Indices para la tabla Especie
--

ALTER TABLE Especie
ADD PRIMARY KEY (CodEspecie);

--
-- Indices para la tabla E-A
--

ALTER TABLE `E-A`
ADD KEY FK_CodEspecie (CodEspecie),
ADD KEY FK_CodArea (CodArea);

--
-- Indices para la tabla Area
--

ALTER TABLE Area
ADD PRIMARY KEY (NombreA);

--
-- Indices para la tabla vehiculo
--

ALTER TABLE Vehiculo
ADD PRIMARY KEY (Matricula);

--
-- Indices para la tabla I-P
--

ALTER TABLE `I-P`
ADD KEY FK_CodProy (CodProy),
ADD KEY FK_DNI (DNI);

--
-- Indices para la tabla Proyecto
--

ALTER TABLE Proyecto
ADD PRIMARY KEY (CodProy),
ADD KEY FK_CodEspecie (CodEspecie);

--
-- Indices para la tabla Conservador
--

ALTER TABLE Conservador
ADD PRIMARY KEY (DNI);

--
-- Indices para la tabla Vigilante
--

ALTER TABLE Vigilante
ADD PRIMARY KEY (DNI);
