package testingEmpleadojdbc;

import java.util.Date;

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
		
		Empleado emp = new Empleado();
				
		emp.setIdEmpl(121);
		emp.setNombre("Marta");
		emp.setApellidos("Robles");
		emp.setGenero('M');
		emp.setEmail(emp.obtenerEmail());
		emp.setPassword("marta");
		emp.setSalario(43000);
		emp.setFechaIngreso(null);
		emp.setFechaNacimiento(null);
		emp.setPerfil(pdao.buscarUno(2));
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
