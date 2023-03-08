package testingproyecto;

import modelo.daojdbc.ProyectoDao;
import modelo.daojdbc.ProyectoDaoImplMy8;

public class TestImporteProyectoTerminado {

	public static void main(String[] args) {
		ProyectoDao prodao = new ProyectoDaoImplMy8();
		System.out.println(prodao.importesVentaProyectosTerminados());
		}
		
	}


