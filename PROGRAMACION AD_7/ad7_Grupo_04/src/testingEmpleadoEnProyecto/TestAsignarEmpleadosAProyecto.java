package testingEmpleadoEnProyecto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import modelo.daojdbc.EmpleadoDao;
import modelo.daojdbc.EmpleadoDaoImplMy8;
import modelo.daojdbc.EmpleadosEnProyectoDao;
import modelo.daojdbc.EmpleadosEnProyectoDaoImplMy8;
import modelo.daojdbc.ProyectoDao;
import modelo.daojdbc.ProyectoDaoImplMy8;
import modelo.javabeans.EmpleadosEnProyecto;

public class TestAsignarEmpleadosAProyecto {

	public static void main(String[] args) {

		EmpleadosEnProyectoDao eepd = new EmpleadosEnProyectoDaoImplMy8();
		ProyectoDao pdao = new ProyectoDaoImplMy8();
		EmpleadoDao edao = new EmpleadoDaoImplMy8();

		Date f1 = Date.valueOf("2022-06-12");
		Date f2 = Date.valueOf("2023-01-12");
		Date f3 = Date.valueOf("2022-02-28");

		List<EmpleadosEnProyecto> lista = new ArrayList<>();
		lista.add(new EmpleadosEnProyecto(6, pdao.buscarUno("FOR2021001"), edao.buscarUno(117), 55, f1));
		lista.add(new EmpleadosEnProyecto(7, pdao.buscarUno("FOR2020001"), edao.buscarUno(114), 80, f2));
		lista.add(new EmpleadosEnProyecto(8, pdao.buscarUno("FOR2020001"), edao.buscarUno(100), 70, f3));

		System.out.println(eepd.asignarEmpleadosAProyecto(lista));
	}

}
