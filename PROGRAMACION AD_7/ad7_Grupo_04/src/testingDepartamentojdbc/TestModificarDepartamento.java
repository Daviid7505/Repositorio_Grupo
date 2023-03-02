package testingDepartamentojdbc;

import modelo.daojdbc.DepartamentoDao;
import modelo.daojdbc.DepartamentoDaoImplMy8;
import modelo.javabeans.Departamento;

public class TestModificarDepartamento {

	public static void main(String[] args) {

		DepartamentoDao ddao = new DepartamentoDaoImplMy8();
		Departamento dep = ddao.buscarUnDepartamento(10);
		System.out.println("MODIFICAR DEPARTAMENTO -> id_depar = 10");
		dep.setNombre("RR.HH");
		System.out.println(ddao.modificarUnDepartamento(dep));

	}

}
