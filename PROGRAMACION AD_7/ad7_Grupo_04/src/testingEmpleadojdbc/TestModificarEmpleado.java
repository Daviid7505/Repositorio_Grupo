package testingEmpleadojdbc;

import modelo.daojdbc.EmpleadoDao;
import modelo.daojdbc.EmpleadoDaoImplMy8;
import modelo.javabeans.Empleado;

public class TestModificarEmpleado {

	public static void main(String[] args) {

		EmpleadoDao edao = new EmpleadoDaoImplMy8();

<<<<<<< HEAD
		Empleado emp =edao.buscarUno(120);
		
		emp.setPassword("raquelita"); 
		
		emp.getDepartamento().setIdDepartamento(40);
		emp.getPerfil().setIdPerfil(4);		

		// Modificamos el password del empleado
=======
		Empleado emp = edao.buscarUno(120);

		emp.setPassword("raquelita"); // cambiamos password "raquel" por "raquelita"

		// Modificamos el password del empleado 120
>>>>>>> 45aa953ed0441ae4bd765a166c1aa2a3eb4f9655

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
