package testingproyecto;

import modelo.daojdbc.ProyectoDao;
import modelo.daojdbc.ProyectoDaoImplMy8;
import modelo.javabeans.Proyecto;

public class TestBuscarByJefeProyectoYEstado {

	public static void main(String[] args) {
		 ProyectoDao prodao = new ProyectoDaoImplMy8();
			
			
			System.out.println("Buscar por Jefede Proyecto y Estado");
			 for (Proyecto ele2: prodao.proyectosByJefeProyectoAndByEstado(114, "Activo")) {
			 System.out.println(ele2);
				
		}

		}
	


	}


