package testingEmpleadoEnProyecto;

import modelo.daojdbc.EmpleadosEnProyectoDao;
import modelo.daojdbc.EmpleadosEnProyectoDaoImplMy8;
import modelo.javabeans.EmpleadosEnProyecto;

public class TestModificarProyectoConEmpleados {

	public static void main(String[] args) {

		EmpleadosEnProyectoDao eepd = new EmpleadosEnProyectoDaoImplMy8();

		EmpleadosEnProyecto eep = eepd.buscarUno(1);
		System.out.println("MODIFICAR UN PROYECTO CON EMPLEADOS -> NUMERO_ORDEN 1:");
		eep.setHorasAsignadas(200);
		System.out.println(eepd.modificarUnaOrden(eep));
	}

}
