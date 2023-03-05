package testingDepartamento;

import modelo.daojdbc.DepartamentoDao;
import modelo.daojdbc.DepartamentoDaoImplMy8;
import modelo.javabeans.Departamento;

public class TestAltaDepartamentoDao {

	public static void main(String[] args) {

		DepartamentoDao ddao = new DepartamentoDaoImplMy8();

		System.out.println("ALTA DEPARTAMENTO");

		Departamento dep = new Departamento(50, "Comercial", "Barcelona");
		System.out.println(ddao.altaDepartamento(dep));
	}

}
