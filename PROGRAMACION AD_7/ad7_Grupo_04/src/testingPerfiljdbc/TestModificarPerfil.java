package testingPerfiljdbc;

import modelo.daojdbc.PerfilDao;
import modelo.daojdbc.PerfilDaoImplMy8;
import modelo.javabeans.Perfil;

public class TestModificarPerfil {

	public static void main(String[] args) {
	
		PerfilDao pdao = new PerfilDaoImplMy8();
		Perfil p = new Perfil(5, "IT_PROGRAMMER", 25);
	
	//Modificamos el nombre del perfil
		System.out.println("MODIFICAR PERFIL");
		System.out.println();
		System.out.println(pdao.modificarUno(p));
		System.out.println();
		
	//Mostramos la lista con el perfil modificado
		System.out.println("NUEVA TABLA");
		System.out.println();
		for (Perfil ele : pdao.buscarTodos())
		System.out.println(ele);
		
	
	}

}
