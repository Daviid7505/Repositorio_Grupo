package testingEmpleadoEnProytectojdbc;

import modelo.daojdbc.ProyectoDao;
import modelo.daojdbc.ProyectoDaoImplMy8;
public class TestAltaProyectoConEmpleados {


public static void main(String[] args) {
		ProyectoDao prodao = new ProyectoDaoImplMy8();
		
		System.out.println("Buscar un Proyecto por estado");
		System.out.println(prodao.proyectosByEstado("ACTIVO"));
		  
	}
	}


