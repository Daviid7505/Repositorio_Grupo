package testingPerfiljdbc;

import modelo.daojdbc.PerfilDao;
import modelo.daojdbc.PerfilDaoImplMy8;
import modelo.javabeans.Perfil;

public class TestAltaPerfil {

	public static void main(String[] args) {
		
		PerfilDao pdao = new PerfilDaoImplMy8();
		Perfil p = new Perfil(5, "IT", 25);
		
		System.out.println("ALTA PERFIL");
		System.out.println();
		System.out.println(pdao.altaPerfil(p));
		System.out.println();

	//Mostramos la lista con el perfil añadido
		System.out.println("NUEVA TABLA");
		System.out.println();
		for (Perfil ele : pdao.buscarTodos())
			System.out.println(ele);

	}

}
