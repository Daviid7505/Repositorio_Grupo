package testingproyecto;

import modelo.daojdbc.ProyectoDao;
import modelo.daojdbc.ProyectoDaoImplMy8;
import modelo.javabeans.Proyecto;

public class TestBuscarTodosProyectos {

	public static void main(String[] args) {
		
			
     ProyectoDao prodao = new ProyectoDaoImplMy8();
				
	 System.out.println("Buscar un Proyecto");
	 for (Proyecto ele: prodao.buscarTodos()) {
			
	 System.out.println(ele);
				  
			}
	}

}
