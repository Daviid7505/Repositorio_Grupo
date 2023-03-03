package testingEmpleadojdbc;

import modelo.daojdbc.DepartamentoDao;
import modelo.daojdbc.DepartamentoDaoImplMy8;
import modelo.daojdbc.EmpleadoDao;
import modelo.daojdbc.EmpleadoDaoImplMy8;
import modelo.daojdbc.PerfilDao;
import modelo.daojdbc.PerfilDaoImplMy8;
import modelo.javabeans.Empleado;

public class TestBuscarTodos {

	public static void main(String[] args) {

		EmpleadoDao edao = new EmpleadoDaoImplMy8();
		
		Empleado empleado = new Empleado();
		
	
		System.out.println("BUSCAR TODOS LOS EMPLEADOS");
		for (Empleado ele : edao.buscarTodos())
		System.out.println(ele);
		
		}			
		
	
		
			
	
}	


