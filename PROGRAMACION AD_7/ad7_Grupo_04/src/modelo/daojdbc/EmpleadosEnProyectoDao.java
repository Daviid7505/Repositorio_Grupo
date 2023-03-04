package modelo.daojdbc;

import java.util.List;

import modelo.javabeans.EmpleadosEnProyecto;

public interface EmpleadosEnProyectoDao {

	int altaOrden(EmpleadosEnProyecto orden);

	int eliminarOrden(int numeroOrden);

	EmpleadosEnProyecto buscarUno(int numeroOrden);

	List<EmpleadosEnProyecto> buscarTodasLasOrdenes();

	int modificarUnaOrden(EmpleadosEnProyecto orden);

	List<EmpleadosEnProyecto> empleadosByProyecto(String codigoProyecto);

	int asignarEmpleadosAProyecto(List<EmpleadosEnProyecto> empleados);

	int horasAsignadasAProyecto(String codigoProyecto);

	double costeActualDeProyecto(String codigoProyecto);

	double margenActualProyecto(String codigoProyecto);
}
