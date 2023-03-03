package testingEmpleadojdbc;

import modelo.daojdbc.EmpleadoDao;
import modelo.daojdbc.EmpleadoDaoImplMy8;

public class BuscarEmpleadoPorId {

	public static void main(String[] args) {
		
		EmpleadoDao edao = new EmpleadoDaoImplMy8();
		
		//Buscamos un empleado por su id
		System.out.println("BUSCAR EMPLEADO POR ID_EMPLEADO");
		System.out.println();
		System.out.println(edao.buscarUno(100));
		System.out.println();
		

	}

}
