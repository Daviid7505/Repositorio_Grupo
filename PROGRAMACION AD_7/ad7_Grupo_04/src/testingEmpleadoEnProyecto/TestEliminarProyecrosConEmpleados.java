package testingEmpleadoEnProyecto;

import modelo.daojdbc.EmpleadosEnProyectoDao;
import modelo.daojdbc.EmpleadosEnProyectoDaoImplMy8;
import modelo.javabeans.EmpleadosEnProyecto;

public class TestEliminarProyecrosConEmpleados {

	public static void main(String[] args) {

		EmpleadosEnProyectoDao eepd = new EmpleadosEnProyectoDaoImplMy8();

		System.out.println("Antes de ejecutar la consulta de alta de proyecto con empleados vamos a listarlos:");
		for (EmpleadosEnProyecto ele : eepd.buscarTodasLasOrdenes())
			System.out.println(ele);
		System.out.println();

		System.out.println("ELIMNAR PROYECTO CON EMPLEADOS:");
		System.out.println(eepd.eliminarOrden(5));
		System.out.println();
		System.out.println("Después de eliminar el proyecto con empleados, lo listo nuevamente:");
		for (EmpleadosEnProyecto ele : eepd.buscarTodasLasOrdenes())
			System.out.println(ele);
	}

}
