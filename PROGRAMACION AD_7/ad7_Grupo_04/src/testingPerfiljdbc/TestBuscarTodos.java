package testingPerfiljdbc;

import modelo.daojdbc.PerfilDao;
import modelo.daojdbc.PerfilDaoImplMy8;
import modelo.javabeans.Perfil;

public class TestBuscarTodos {

	public static void main(String[] args) {
		PerfilDao pdao = new PerfilDaoImplMy8();
		
		System.out.println("BUSCAR TODOS LOS PERFILES");
		System.out.println();
		
		for (Perfil ele: pdao.buscarTodos())
			System.out.println(ele);

	}

}
