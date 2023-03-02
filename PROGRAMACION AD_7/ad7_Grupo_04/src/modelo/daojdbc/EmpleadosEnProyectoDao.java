package modelo.daojdbc;

import java.util.List;

import modelo.javabean.Cuenta;
import modelo.javabeans.Departamento;
import modelo.javabeans.EmpleadosEnProyecto;

public interface EmpleadosEnProyectoDao {
	
	int altaProyectoConEmpleados(EmpleadosEnProyecto proyectoConEmpleados);
	
	int eliminarProyectoConEmpleados(int numeroOrden);
	
	EmpleadosEnProyecto buscarUno(int numeroOrden);
	
	List<EmpleadosEnProyecto> buscarTodosProyectosConEmpleados();
	
	int modificarUnProyectoConEmpleados(EmpleadosEnProyecto proyectoConEmpleados);

}
