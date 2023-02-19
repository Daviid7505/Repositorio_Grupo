use ad_6 ;

-- Indice de la tabla excursion 

ALTER TABLE  `excursion`
ADD PRIMARY KEY (CodExcursion),
ADD KEY  `CodExcursion` (CodExcursion),
ADD KEY `CodAlojamiento` (CodAlojamiento);

-- Indice de la tabla alojamiento
ALTER TABLE `alojamiento`
ADD PRIMARY KEY (CodAlojamiento),
ADD KEY `CodAlojamiento` (CodAlojamiento),
ADD KEY `CodPN` (CodPN);

-- Indice de la tabla entrada
ALTER TABLE `entrada`
ADD PRIMARY KEY (CodEntrada),
ADD KEY `CodEntrada` (CodEntrada),
ADD KEY `CodPN` (CodPN);

-- ALTER TABLE `personal`
ALTER TABLE `personal`
ADD PRIMARY KEY (DNI),
ADD KEY `DNI` (DNI),
ADD KEY `CodPN` (CodPN);


-- Indice de la tabla conservador
ALTER TABLE `conservador`
ADD PRIMARY KEY (DNI),
ADD KEY `DNI` (DNI),
ADD KEY `NombreA` (NombreA);

-- Indice de la tabla vigilante
ALTER TABLE `vigilante`
ADD PRIMARY KEY (DNI),
ADD KEY `DNI` (DNI),
ADD KEY `NombreA` (NombreA);

-- Indice de la tabla investigador
ALTER TABLE `Investigador`
ADD PRIMARY KEY (DNI),
ADD KEY `DNI`(DNI);

-- Indice de la tabla investigador
ALTER TABLE `Gestor`
ADD PRIMARY KEY (DNI),
ADD KEY `DNI`(DNI),
ADD KEY `CodEntrada`(CodEntrada);

-- Indice de la tabla parque natural
ALTER TABLE `ParqueNatural`
ADD PRIMARY KEY (CodPN),
ADD KEY `CodPN`(CodPN);


-- Indice de la tabla parque natural
ALTER TABLE `Area`
ADD PRIMARY KEY (NombreA),
ADD KEY `NombreA`(NombreA),
ADD KEY `CodPN`(CodPN);

-- Filtros para la tabla excursion
ALTER TABLE `excursion`
ADD CONSTRAINT  `excursion` FOREIGN KEY (`CodAlojamiento`) REFERENCES `alojamiento`(CodAlojamiento) ON DELETE CASCADE ON UPDATE CASCADE;

-- Filtros para la tabla alojamiento
ALTER TABLE `Alojamiento`
ADD CONSTRAINT  `Alojamiento` FOREIGN KEY (`CodPN` ) REFERENCes `ParqueNatural`  (`CodPN` ) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `entrada`
ADD CONSTRAINT  `entrada` FOREIGN KEY (`CodPN` ) REFERENCes `ParqueNatural`  (CodPN ) ON DELETE CASCADE ON UPDATE CASCADE;


ALTER TABLE `personal`
ADD CONSTRAINT  `personal` FOREIGN KEY (`CodPN` ) REFERENCes `ParqueNatural`  (CodPN ) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `conservador`
ADD CONSTRAINT  `conservador` FOREIGN KEY (`NombreA` ) REFERENCes `Area`  (NombreA ) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `vigilante`
ADD CONSTRAINT  `vigilante` FOREIGN KEY (`NombreA` ) REFERENCes `Area`  (NombreA ) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `gestor`
ADD CONSTRAINT  `gestor` FOREIGN KEY (`CodEntrada` ) REFERENCes `entrada`  (CodEntrada ) ON DELETE CASCADE ON UPDATE CASCADE;
