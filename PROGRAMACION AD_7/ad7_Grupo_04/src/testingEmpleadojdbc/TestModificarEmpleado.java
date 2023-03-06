package testingEmpleadojdbc;


import modelo.daojdbc.DepartamentoDao;
import modelo.daojdbc.DepartamentoDaoImplMy8;
import modelo.daojdbc.EmpleadoDao;
import modelo.daojdbc.EmpleadoDaoImplMy8;
import modelo.daojdbc.PerfilDao;
import modelo.daojdbc.PerfilDaoImplMy8;
import modelo.javabeans.Empleado;
import modelo.javabeans.Perfil;

public class TestModificarEmpleado {

	public static void main(String[] args) {
		
		EmpleadoDao edao = new EmpleadoDaoImplMy8();
		Empleado emp =edao.buscarUno(120);
		
		emp.setPassword("raquelita"); //cambiamos password "marta" por "martita"
				
		//Modificamos el password del empleado 122
		System.out.println("MODIFICAR EMPLEADO");
		System.out.println();
		
		
		System.out.println(edao.modificarUno(emp));
		System.out.println();
		
		//Mostramos la tabla con las nuevas modificaciones
		System.out.println("NUEVA LISTA DE EMPLEADOS");
		for (Empleado ele: edao.buscarTodos()) {
			System.out.println(ele);
	}
	}
	}


