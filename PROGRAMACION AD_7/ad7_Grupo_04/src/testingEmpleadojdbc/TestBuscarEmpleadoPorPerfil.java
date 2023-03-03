package testingEmpleadojdbc;

import modelo.daojdbc.EmpleadoDao;
import modelo.daojdbc.EmpleadoDaoImplMy8;
import modelo.daojdbc.PerfilDao;
import modelo.daojdbc.PerfilDaoImplMy8;
import modelo.javabeans.Empleado;

public class TestBuscarEmpleadoPorPerfil {

	public static void main(String[] args) {
		
		EmpleadoDao edao = new EmpleadoDaoImplMy8();
		PerfilDao pdao = new PerfilDaoImplMy8();
		
		//Buscamos un empleado por su perfil
			System.out.println("BUSCAR EMPLEADOS POR PERFIL");
			System.out.println();
					
			for (Empleado ele : edao.buscarEmpleadoPorPerfil(2)) {
			System.out.println(ele);
			System.out.println();
				}	
	}

}
