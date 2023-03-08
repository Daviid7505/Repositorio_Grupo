package testingModeloJavabeans;

import java.sql.Date;
import java.time.LocalDate;

import modelo.daojdbc.ClienteDao;
import modelo.daojdbc.ClienteDaoImplMy8;
import modelo.daojdbc.EmpleadoDao;
import modelo.daojdbc.EmpleadoDaoImplMy8;
import modelo.javabeans.Proyecto;

public class TestProyectoModeloJavabeans {

	public static void main(String[] args) {
		EmpleadoDao empdao = new EmpleadoDaoImplMy8();
		ClienteDao clidao = new ClienteDaoImplMy8();
		LocalDate ffin =LocalDate.of(2023, 3, 8);
		Date ffinconvertida = Date.valueOf(ffin);
		LocalDate ffinreal =LocalDate.of(2023, 5, 10);
		Date ffinrealconvertida = Date.valueOf( ffinreal);
		
		
		Proyecto pro = new Proyecto();
		pro.setIdProyecto("FOR2020004");
		pro.setDescripcion("Formacion de empleados");
		pro.setFechaInicio(null);
		pro.setFechaFinPrevisto(ffinconvertida);
		pro.setFechaFinReal(ffinrealconvertida);
		pro.setVentaPrevisto(50000.00);
		pro.setCostesPrevisto(30000.00);
		pro.setCosteReal(41000.00);
		pro.setEstado("TERMINADO");
		pro.setEmpleado(empdao.buscarUno(114));
		pro.setCliente(clidao.buscarCliente("A22222222"));
		
		
		System.out.println(pro.diferenciFinPrevisto());
		System.out.println(pro.margenPrevisto());
		System.out.println(pro.diferenciGastos());
	    System.out.println(pro.margenReal());
	}



	}


