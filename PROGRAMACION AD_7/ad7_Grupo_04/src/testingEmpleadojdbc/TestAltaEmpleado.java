package testingEmpleadojdbc;

import java.sql.Date;
import java.text.DateFormat;

import modelo.daojdbc.DepartamentoDao;
import modelo.daojdbc.DepartamentoDaoImplMy8;
import modelo.daojdbc.EmpleadoDao;
import modelo.daojdbc.EmpleadoDaoImplMy8;
import modelo.daojdbc.PerfilDao;
import modelo.daojdbc.PerfilDaoImplMy8;
import modelo.javabeans.Empleado;

public class TestAltaEmpleado {

	public static void main(String[] args) {

		EmpleadoDao edao = new EmpleadoDaoImplMy8();
		PerfilDao pdao = new PerfilDaoImplMy8();
		DepartamentoDao ddao = new DepartamentoDaoImplMy8();
		Empleado e = new Empleado();
		Date f = Date.valueOf("1980-04-12");
		
		Empleado emp = new Empleado(121, "Marta", "Robles", 'M', e.obtenerEmail(), 
		"marta", 43000, new Date (new java.util.Date().getTime()), f , 
		pdao.buscarUno(2), ddao.buscarUnDepartamento(10));		
				
		System.out.println("ALTA EMPLEADO");
		System.out.println();
		System.out.println(edao.altaEmpleado(emp));
		
		//Mostramos que el empleado fue agregado		
		System.out.println("NUEVA LISTA DE EMPLEADOS");
		for (Empleado ele: edao.buscarTodos()) {
			System.out.println(ele);
		
	}

}
}
