package testingproyecto;

import modelo.daojdbc.ProyectoDao;
import modelo.daojdbc.ProyectoDaoImplMy8;
import modelo.javabeans.Proyecto;

public class TestModificarProyecto {

	public static void main(String[] args) {
		
		ProyectoDao prodao = new ProyectoDaoImplMy8();
		
		System.out.println("Buscar un Proyecto");
		Proyecto pro = new Proyecto();
		System.out.println(prodao.buscarUno("FOR2021001"));
		pro.setIdProyecto("FOR2020004");
		System.out.println(prodao.modificarProyecto(pro));
		  

		}

	}

