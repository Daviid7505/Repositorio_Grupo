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
		PerfilDao pdao = new PerfilDaoImplMy8();
		DepartamentoDao ddao = new DepartamentoDaoImplMy8();
		Empleado empleado = new Empleado();
		
		Empleado emp = new Empleado(122, "Marta", "Perez Torres", 'M', empleado.obtenerEmail(), "martita",
				46000, "2023-04-12", "1982-12-25", pdao.buscarUno(3) , ddao.buscarUnDepartamento(10));
		
		Perfil p = new Perfil();
		
		//Modificamos el password y el año de nacimiento del empleado 122
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

