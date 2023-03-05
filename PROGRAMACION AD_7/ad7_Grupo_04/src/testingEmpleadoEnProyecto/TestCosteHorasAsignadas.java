package testingEmpleadoEnProyecto;

import modelo.daojdbc.EmpleadoDao;
import modelo.daojdbc.EmpleadoDaoImplMy8;
import modelo.daojdbc.EmpleadosEnProyectoDao;
import modelo.daojdbc.EmpleadosEnProyectoDaoImplMy8;
import modelo.daojdbc.ProyectoDao;
import modelo.daojdbc.ProyectoDaoImplMy8;
import modelo.javabeans.EmpleadosEnProyecto;

public class TestCosteHorasAsignadas {

	public static void main(String[] args) {

		EmpleadosEnProyectoDao eepd = new EmpleadosEnProyectoDaoImplMy8();
		ProyectoDao pdao = new ProyectoDaoImplMy8();
		EmpleadoDao edao = new EmpleadoDaoImplMy8();

		System.out.println("METODO PARA CALCULAR EL COSTE DE LAS HORAS ASIGNADAS A UN PROYECTO. "
				+ "CALCULAMOS EL COSTE DE LAS HORAS ASIGNADAS AL PROYECTO \"FOR2021001\":");

		EmpleadosEnProyecto eep = new EmpleadosEnProyecto(5, pdao.buscarUno("FOR2021001"), edao.buscarUno(119), 60,
				null);
		System.out.println(eep.costeHorasAsignadas() + " €");

	}

}
