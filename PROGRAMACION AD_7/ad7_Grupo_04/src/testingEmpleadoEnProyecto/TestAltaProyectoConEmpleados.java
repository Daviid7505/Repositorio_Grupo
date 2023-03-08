package testingEmpleadoEnProyecto;

import java.sql.Date;

import modelo.daojdbc.EmpleadoDao;
import modelo.daojdbc.EmpleadoDaoImplMy8;
import modelo.daojdbc.EmpleadosEnProyectoDao;
import modelo.daojdbc.EmpleadosEnProyectoDaoImplMy8;
import modelo.daojdbc.ProyectoDao;
import modelo.daojdbc.ProyectoDaoImplMy8;
import modelo.javabeans.EmpleadosEnProyecto;

public class TestAltaProyectoConEmpleados {

	public static void main(String[] args) {

		EmpleadosEnProyectoDao eepd = new EmpleadosEnProyectoDaoImplMy8();
		ProyectoDao pdao = new ProyectoDaoImplMy8();
		EmpleadoDao edao = new EmpleadoDaoImplMy8();
		Date f = Date.valueOf("2021-01-28");

		System.out.println("Antes de ejecutar la consulta vamos a listar los proyectos con empleados:");
		for (EmpleadosEnProyecto ele : eepd.buscarTodasLasOrdenes())
			System.out.println(ele);
		System.out.println();

		System.out.println("ALTA PROYECTO CON EMPLEADOS:");

		EmpleadosEnProyecto eep = new EmpleadosEnProyecto(5, pdao.buscarUno("FOR2021001"), edao.buscarUno(119), 60, f);
		System.out.println(eepd.altaOrden(eep));
		System.out.println();
		System.out.println("Después de dar de alta el proyecto con empleados, lo listo nuevamente:");
		for (EmpleadosEnProyecto ele : eepd.buscarTodasLasOrdenes())
			System.out.println(ele);
	}
}
