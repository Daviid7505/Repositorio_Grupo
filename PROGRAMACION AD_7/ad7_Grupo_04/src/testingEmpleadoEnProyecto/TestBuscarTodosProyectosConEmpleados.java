package testingEmpleadoEnProyecto;

import modelo.daojdbc.EmpleadosEnProyectoDao;
import modelo.daojdbc.EmpleadosEnProyectoDaoImplMy8;
import modelo.javabeans.EmpleadosEnProyecto;

public class TestBuscarTodosProyectosConEmpleados {

	public static void main(String[] args) {

		EmpleadosEnProyectoDao eepd = new EmpleadosEnProyectoDaoImplMy8();

		System.out.println("BUSCAR TODOS LOS PROYECTOS CON EMPLEADOS:");
		for (EmpleadosEnProyecto ele : eepd.buscarTodasLasOrdenes())
			System.out.println(ele);
	}
}
