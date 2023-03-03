package testingproyecto;

import modelo.daojdbc.ProyectoDao;
import modelo.daojdbc.ProyectoDaoImplMy8;

public class TestBuscarUnProyecto {

	public static void main(String[] args) {
	ProyectoDao prodao = new ProyectoDaoImplMy8();
	
	System.out.println("Buscar un Proyecto");
	 System.out.println(prodao.buscarUno("FOR2021001"));
	  

	}

}
