package testingPerfiljdbc;

import modelo.daojdbc.PerfilDao;
import modelo.daojdbc.PerfilDaoImplMy8;
import modelo.javabeans.Perfil;

public class TestEliminarPerfil {

	public static void main(String[] args) {

		PerfilDao pdao = new PerfilDaoImplMy8();
		
	//Eliminamos el perfil 5
		System.out.println("ELIMINAR PERFIL");
		System.out.println();
		System.out.println(pdao.eliminarUno(5));
		System.out.println();
		
	//Mostramos la lista sin el perfil 5
		System.out.println("NUEVA TABLA");
		System.out.println();
		for (Perfil ele : pdao.buscarTodos())
		System.out.println(ele);

	}

}
