package testingproyecto;

import modelo.daojdbc.ProyectoDao;
import modelo.daojdbc.ProyectoDaoImplMy8;

public class TestBuscarPorEstado {

	public static void main(String[] args) {
		ProyectoDao prodao = new ProyectoDaoImplMy8();
		
		System.out.println("Buscar un Proyecto por estado");
		System.out.println(prodao.proyectosByEstado("ACTIVO"));
		  

	}

}
