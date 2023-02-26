package testingDepartamentojdbc;

import modelo.daojdbc.DepartamentoDao;
import modelo.daojdbc.DepartamentoDaoImplMy8;
import modelo.javabeans.Departamento;

public class TestBuscarDepartamento {

	public static void main(String[] args) {

		DepartamentoDao ddao = new DepartamentoDaoImplMy8();

		System.out.println("BUSCAR UN DEPARTAMENTO -> 30:");
		System.out.println(ddao.buscarUnDepartamento(30));

		System.out.println("BUSCAR TODOS LOS DEPARTAMENTOS:");
		for (Departamento ele : ddao.buscarTodosDepartamentos())
			System.out.println(ele);

	}

}
