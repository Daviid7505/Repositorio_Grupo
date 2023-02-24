package modelo.daojdbc;

import java.util.List;

import modelo.javabeans.Empleado;

public interface EmpleadoDao {
	
	int altaEmpleado(Empleado empleado);
	int eliminarUno (int idEmpl);
	int modificarUno (Empleado empleado);
	Empleado buscarUno(int idEmpl);
	List<Empleado> buscarTodos();
	List<Empleado> buscarEmpleadoPorDepartamento(int idDepartamento);
	List<Empleado> buscarEmpleadoPorGenero(char genero);
	List<Empleado> buscarEmpleadoPorApellido(String subcadena);
	double salarioTotal();
	double salarioTotal(int idDepartamento);
}
