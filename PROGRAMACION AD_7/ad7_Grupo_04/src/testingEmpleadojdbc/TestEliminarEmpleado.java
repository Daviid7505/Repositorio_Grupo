package testingEmpleadojdbc;

import modelo.daojdbc.EmpleadoDao;
import modelo.daojdbc.EmpleadoDaoImplMy8;
import modelo.javabeans.Empleado;

public class TestEliminarEmpleado {

	public static void main(String[] args) {
	
	EmpleadoDao edao = new EmpleadoDaoImplMy8();
	
	System.out.println("ELIMINAMOS EL EMPLEADO 122");
	System.out.println();
	System.out.println(edao.eliminarUno(122));
	
	//Mostramos la tabla con las nuevas modificaciones
	System.out.println("NUEVA LISTA DE EMPLEADOS");
	for (Empleado ele : edao.buscarTodos()) {
		System.out.println(ele);
		}
}	
}
