package testingEmpleadojdbc;

import modelo.daojdbc.EmpleadoDao;
import modelo.daojdbc.EmpleadoDaoImplMy8;
import modelo.javabeans.Empleado;

public class TesteBuscarEmpleadoPorApellido {

	public static void main(String[] args) {
		
		EmpleadoDao edao = new EmpleadoDaoImplMy8();
		
		//Buscamos un empleado por su apellido
		System.out.println("BUSCAR EMPLEADOS POR DEPARTAMENTO");
		System.out.println();
						
		for (Empleado ele : edao.buscarEmpleadoPorApellido("Di")) {
		System.out.println(ele);
		System.out.println();
						}					

	}

}
