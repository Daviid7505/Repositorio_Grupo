package testingEmpleadoEnProyecto;

import modelo.daojdbc.EmpleadosEnProyectoDaoImplMy8;

public class TestCosteActualDeProyecto {

	public static void main(String[] args) {

		EmpleadosEnProyectoDaoImplMy8 eep = new EmpleadosEnProyectoDaoImplMy8();

		System.out.println(eep.costeActualDeProyecto("FOR2020001"));

	}

}
