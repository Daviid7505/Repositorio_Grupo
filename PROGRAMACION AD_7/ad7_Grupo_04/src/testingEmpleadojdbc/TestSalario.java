package testingEmpleadojdbc;

import modelo.daojdbc.EmpleadoDao;
import modelo.daojdbc.EmpleadoDaoImplMy8;

public class TestSalario {

	public static void main(String[] args) {
		
	EmpleadoDao edao = new EmpleadoDaoImplMy8();
		
	//Buscamos un empleado por su id
		System.out.println("SALARIO TOTAL");
		System.out.println();
		System.out.println(edao.salarioTotal());
		System.out.println();

		
		System.out.println("SALARIO TOTAL POR DEPARTAMENTO");
		System.out.println();
		System.out.println(edao.salarioTotal(20));
		

	}

}
