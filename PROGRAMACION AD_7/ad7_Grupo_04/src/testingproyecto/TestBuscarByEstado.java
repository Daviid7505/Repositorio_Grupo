package testingproyecto;

import modelo.daojdbc.ProyectoDao;
import modelo.daojdbc.ProyectoDaoImplMy8;
import modelo.javabeans.Proyecto;

public class TestBuscarByEstado {

	public static void main(String[] args) {
		 ProyectoDao prodao = new ProyectoDaoImplMy8();
			
		 System.out.println("Buscar por Estado");
		 for (Proyecto ele: prodao.proyectosByEstado("ACTIVO")) {
		 System.out.println(ele);
		 
		 
	}

	}


	}


