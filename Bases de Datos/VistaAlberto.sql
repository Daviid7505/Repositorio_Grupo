USE AD_6;
-- Creamos la vista 
-- Sentencia para crear la vista CREATE VIEW NombreVista AS
CREATE VIEW ExcursionAPie AS
-- Consulta SELECT para que muestre los campos dni, fecha y aPie
SELECT Vis.DNI, Exc.Fecha, Exc.aPie as A_pie
-- FROM indica las tablas que se participan en la relacion de la tabla Visitante y Excursión
FROM Visitante as Vis, e_v as ev, Excursion as Exc
-- WHERE define las relaciones que hay entre las tablas del FROM a traves de su PK y FK y asigna la condición que debe cumplir el campo aPie de la tabla Excursion
WHERE Vis.DNI = ev.DNI AND ev.CodExcursion = Exc.CodExcursion AND Exc.aPie like 'Si';