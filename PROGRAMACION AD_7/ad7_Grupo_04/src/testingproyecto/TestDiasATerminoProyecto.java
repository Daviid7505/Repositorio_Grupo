package testingproyecto;

import modelo.daojdbc.ProyectoDao;
import modelo.daojdbc.ProyectoDaoImplMy8;

public class TestDiasATerminoProyecto {

	public static void main(String[] args) {

		 ProyectoDao prodao = new ProyectoDaoImplMy8();
        System.out.println(prodao.diasATerminoProyectoActivo("FOR2020001"));

       
	}




	}


