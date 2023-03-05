package testingEmpleadojdbc;

import modelo.daojdbc.EmpleadoDao;
import modelo.daojdbc.EmpleadoDaoImplMy8;
import modelo.javabeans.Empleado;

public class TestBuscarEmpleadoPorGenero {

	public static void main(String[] args) {

		EmpleadoDao edao = new EmpleadoDaoImplMy8();
		
				
		//Buscamos un empleado por su genero
			System.out.println("BUSCAR EMPLEADOS POR GENERO");
			System.out.println();
					
			for (Empleado ele : edao.buscarEmpleadoPorGenero('M')) {
			System.out.println(ele);
			
	}

}
}
