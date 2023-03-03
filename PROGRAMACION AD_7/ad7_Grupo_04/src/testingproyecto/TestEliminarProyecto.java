package testingproyecto;

import modelo.daojdbc.ProyectoDao;
import modelo.daojdbc.ProyectoDaoImplMy8;

public class TestEliminarProyecto {

	public static void main(String[] args) {
		ProyectoDao prodao = new ProyectoDaoImplMy8();
		
		System.out.println("Eliminar un Proyecto");
		 System.out.println(prodao.eliminarProyecto("FOR2020004"));
		  

		}

	}


