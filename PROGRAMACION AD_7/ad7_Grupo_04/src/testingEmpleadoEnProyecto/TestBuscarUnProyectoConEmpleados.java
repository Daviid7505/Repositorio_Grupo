package testingEmpleadoEnProyecto;

import modelo.daojdbc.EmpleadosEnProyectoDao;
import modelo.daojdbc.EmpleadosEnProyectoDaoImplMy8;

public class TestBuscarUnProyectoConEmpleados {

	public static void main(String[] args) {

		EmpleadosEnProyectoDao eepd = new EmpleadosEnProyectoDaoImplMy8();

		System.out.println("BUSCAR UN PROYECTO CON EMPLEADOS POR NUMERO DE ORDEN -> 2:");
		System.out.println(eepd.buscarUno(2));
	}
}
