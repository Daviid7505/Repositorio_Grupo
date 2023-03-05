package testingEmpleadoEnProyecto;

import modelo.daojdbc.EmpleadosEnProyectoDao;
import modelo.daojdbc.EmpleadosEnProyectoDaoImplMy8;
import modelo.javabeans.EmpleadosEnProyecto;

public class TestEmpleadosByProyecto {

	public static void main(String[] args) {

		EmpleadosEnProyectoDao eepd = new EmpleadosEnProyectoDaoImplMy8();

		System.out.println("METODO PARA BUSCAR EMPLEADOS POR PROYECTO, BUSCAMOS EL PROYECTO \"FOR2021001\":");
		for (EmpleadosEnProyecto ele : eepd.empleadosByProyecto("FOR2021001"))
			System.out.println(ele);
	}

}
