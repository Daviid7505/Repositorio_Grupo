package testingEmpleadojdbc;

import modelo.daojdbc.EmpleadoDao;
import modelo.daojdbc.EmpleadoDaoImplMy8;
import modelo.javabeans.Empleado;

public class TestBuscarPorDepartamento {

	public static void main(String[] args) {
		
		EmpleadoDao edao = new EmpleadoDaoImplMy8();
		
		//Buscamos un empleado por su id
		System.out.println("BUSCAR EMPLEADOS POR DEPARTAMENTO");
		System.out.println();
		
		for (Empleado ele : edao.buscarEmpleadoPorDepartamento(20)) {
		System.out.println(ele);
		System.out.println();
		}			
		

	}

}
