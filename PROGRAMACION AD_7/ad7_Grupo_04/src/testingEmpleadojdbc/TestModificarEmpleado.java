package testingEmpleadojdbc;

import modelo.daojdbc.EmpleadoDao;
import modelo.daojdbc.EmpleadoDaoImplMy8;
import modelo.javabeans.Empleado;

public class TestModificarEmpleado {

	public static void main(String[] args) {

		EmpleadoDao edao = new EmpleadoDaoImplMy8();

		Empleado emp = edao.buscarUno(120);

		emp.setPassword("raquelita"); // cambiamos password "raquel" por "raquelita"

		// Modificamos el password del empleado 120

		System.out.println("MODIFICAR EMPLEADO");
		System.out.println();

		System.out.println(edao.modificarUno(emp));
		System.out.println();

		// Mostramos la tabla con las nuevas modificaciones
		System.out.println("NUEVA LISTA DE EMPLEADOS");
		for (Empleado ele : edao.buscarTodos()) {
			System.out.println(ele);
		}
	}
}
