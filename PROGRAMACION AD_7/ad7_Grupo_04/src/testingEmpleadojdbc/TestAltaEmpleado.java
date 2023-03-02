package testingEmpleadojdbc;

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
		
		Empleado empleado = new Empleado();
		
		Empleado emp = new Empleado (122, "Marta", "Perez Torres", "marta", empleado.obtenerEmail(),
				'M', 46000, "2023-04-12", "1980-12-25", pdao.buscarUno(3) , ddao.buscarUnDepartamento(10));
		
		System.out.println("ALTA EMPLEADO");
		System.out.println();
		System.out.println(edao.altaEmpleado(emp));
		
		//Mostramos que el empleado fue agregado		
		System.out.println("NUEVA LISTA DE EMPLEADOS");
		for (Empleado ele: edao.buscarTodos()) {
			System.out.println(ele);
		
	}

}
