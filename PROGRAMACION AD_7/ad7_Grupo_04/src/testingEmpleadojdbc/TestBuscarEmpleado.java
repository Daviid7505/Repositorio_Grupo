package testingEmpleadojdbc;

import modelo.daojdbc.DepartamentoDao;
import modelo.daojdbc.DepartamentoDaoImplMy8;
import modelo.daojdbc.EmpleadoDao;
import modelo.daojdbc.EmpleadoDaoImplMy8;
import modelo.daojdbc.PerfilDao;
import modelo.daojdbc.PerfilDaoImplMy8;
import modelo.javabeans.Empleado;

public class TestBuscarEmpleado {

	public static void main(String[] args) {

		EmpleadoDao edao = new EmpleadoDaoImplMy8();
		PerfilDao pdao = new PerfilDaoImplMy8();
		DepartamentoDao ddao = new DepartamentoDaoImplMy8();
		Empleado empleado = new Empleado();
		
	//Buscamos un empleado por su id
		System.out.println("BUSCAR EMPLEADO POR ID_EMPLEADO");
		System.out.println();
		System.out.println(edao.buscarUno(120));
		System.out.println();
		
		
	//Buscamos un empleado por su id
		System.out.println("BUSCAR EMPLEADOS POR DEPARTAMENTO");
		System.out.println();
		
		for (Empleado ele : edao.buscarEmpleadoPorDepartamento(20)) {
		System.out.println(ele);
		System.out.println();
		}			
		
	//Buscamos un empleado por su perfil
		System.out.println("BUSCAR EMPLEADOS POR PERFIL");
		System.out.println();
				
		for (Empleado ele : edao.buscarEmpleadoPorPerfil(2)) {
		System.out.println(ele);
		System.out.println();
		}	
		
	//Buscamos un empleado por su genero
		System.out.println("BUSCAR EMPLEADOS POR GENERO");
		System.out.println();
			
		for (Empleado ele : edao.buscarEmpleadoPorGenero('M')) {
		System.out.println(ele);
		System.out.println();
				}	
		
	//Buscamos un empleado por su apellido
		System.out.println("BUSCAR EMPLEADOS POR DEPARTAMENTO");
		System.out.println();
						
		for (Empleado ele : edao.buscarEmpleadoPorApellido(null)) {
		System.out.println(ele);
		System.out.println();
				}					
		
		
	}

}
