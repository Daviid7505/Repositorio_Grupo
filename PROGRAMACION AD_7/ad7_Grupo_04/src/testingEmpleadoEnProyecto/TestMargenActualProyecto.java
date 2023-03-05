package testingEmpleadoEnProyecto;

import modelo.daojdbc.EmpleadosEnProyectoDao;
import modelo.daojdbc.EmpleadosEnProyectoDaoImplMy8;

public class TestMargenActualProyecto {

	public static void main(String[] args) {

		EmpleadosEnProyectoDao eepd = new EmpleadosEnProyectoDaoImplMy8();

		System.out.println(
				"METODO PARA CALCULAR EL MARGEN DE BENEFICIO DEL PROYECTO. CALCULAMOS EL BENEFICIO DEL PROYECTO \"FOR2021001\":");
		System.out.println(eepd.margenActualProyecto("FOR2021001") + " €");

	}

}
