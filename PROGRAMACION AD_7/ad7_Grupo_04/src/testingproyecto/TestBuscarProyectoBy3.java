package testingproyecto;

import modelo.daojdbc.ProyectoDao;
import modelo.daojdbc.ProyectoDaoImplMy8;
import modelo.javabeans.Proyecto;

public class TestBuscarProyectoBy3 {

	public static void main(String[] args) {
		 ProyectoDao prodao = new ProyectoDaoImplMy8();
			
		 System.out.println("Buscar por Estado");
		 for (Proyecto ele: prodao.proyectosByEstado("ACTIVO")) {
		 System.out.println(ele);
		 
		 
		 System.out.println("Buscar por Cliente");
		 for (Proyecto ele1: prodao.proyectosByCliente("A22222222")) {
		 System.out.println(ele1);
					  
		 System.out.println("Buscar por Jefede Proyecto y Estado");
		 for (Proyecto ele2: prodao.proyectosByJefeProyectoAndByEstado(114, "Activo")) {
		 System.out.println(ele2);
					  
	}		  
	}

	}
	}
}
