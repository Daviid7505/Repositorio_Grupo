package testingEmpleadoEnProyecto;

import modelo.daojdbc.EmpleadosEnProyectoDao;
import modelo.daojdbc.EmpleadosEnProyectoDaoImplMy8;

public class TestHorasAsignadasAProyecto {

	public static void main(String[] args) {

		EmpleadosEnProyectoDao eepd = new EmpleadosEnProyectoDaoImplMy8();

		System.out.println(
				"METODO PARA SUMAR LAS HORAS DE LOS EMPLEADOS ASIGNADOS AL PROYECTO. CALCULAMOS LAS HORAS DEL PROYECTO \"FOR2020001\":");
		System.out.println(eepd.horasAsignadasAProyecto("FOR2020001") + " horas");

	}

}
