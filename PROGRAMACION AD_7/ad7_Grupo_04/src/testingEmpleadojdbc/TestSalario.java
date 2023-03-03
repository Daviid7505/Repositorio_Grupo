package testingEmpleadojdbc;

import modelo.daojdbc.DepartamentoDao;
import modelo.daojdbc.DepartamentoDaoImplMy8;
import modelo.daojdbc.EmpleadoDao;
import modelo.daojdbc.EmpleadoDaoImplMy8;
import modelo.javabeans.Departamento;

public class TestSalario {

	public static void main(String[] args) {
		
	EmpleadoDao edao = new EmpleadoDaoImplMy8();
	DepartamentoDao ddao = new DepartamentoDaoImplMy8();
	Departamento dep = new Departamento();
		
	//Buscamos un empleado por su id
		System.out.println("SALARIO TOTAL");
		System.out.println();
		System.out.println(edao.salarioTotal());
		System.out.println();

		
	System.out.println("SALARIO TOTAL POR DEPARTAMENTO");
		System.out.println();
		
		System.out.println(edao.salarioTotal(ddao.buscarUnDepartamento(10)));
		

	}

}
