package testingDepartamento;

import modelo.daojdbc.DepartamentoDao;
import modelo.daojdbc.DepartamentoDaoImplMy8;

public class TestEliminarDepartamento {

	public static void main(String[] args) {

		DepartamentoDao ddao = new DepartamentoDaoImplMy8();

		System.out.println("ELIMINAR DEPARTAMENTO");

		System.out.println(ddao.eliminarDepartamento(50));
	}

}
