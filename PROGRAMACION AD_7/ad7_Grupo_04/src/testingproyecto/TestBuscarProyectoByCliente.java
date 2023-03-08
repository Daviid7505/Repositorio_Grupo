package testingproyecto;

import modelo.daojdbc.ProyectoDao;
import modelo.daojdbc.ProyectoDaoImplMy8;
import modelo.javabeans.Proyecto;

public class TestBuscarProyectoByCliente {

	public static void main(String[] args) {
		ProyectoDao prodao = new ProyectoDaoImplMy8();
		
		 System.out.println("Buscar por Cliente");
		 for (Proyecto ele1: prodao.proyectosByCliente("A22222222")) {
		 System.out.println(ele1);
	}


}
}