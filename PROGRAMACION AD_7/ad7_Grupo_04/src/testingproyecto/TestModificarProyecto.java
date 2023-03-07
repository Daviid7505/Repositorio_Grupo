package testingproyecto;

import modelo.daojdbc.ProyectoDao;
import modelo.daojdbc.ProyectoDaoImplMy8;
import modelo.javabeans.Proyecto;

public class TestModificarProyecto {

	public static void main(String[] args) {
<<<<<<< HEAD

		ProyectoDao prodao = new ProyectoDaoImplMy8();

		System.out.println("Buscar un Proyecto");
		Proyecto pro = new Proyecto();
		System.out.println(prodao.buscarUno("FOR2021001"));
		pro.setIdProyecto("FOR2020002");
		System.out.println(prodao.modificarProyecto(pro));

	}

}
=======
		 ProyectoDao prodao = new ProyectoDaoImplMy8();
			Proyecto pro = prodao.buscarUno("FOR2020001");
			System.out.println("Buscar un Proyecto");
			//Proyecto pro = new Proyecto();
			System.out.println(prodao.buscarUno("FOR2020001"));
			pro.setDescripcion("ProyectoDesarollo");

			System.out.println(prodao.modificarProyecto(pro));
			  


	}

}
>>>>>>> kyty
