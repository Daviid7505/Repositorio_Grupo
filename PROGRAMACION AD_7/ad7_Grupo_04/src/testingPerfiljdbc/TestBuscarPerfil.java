package testingPerfiljdbc;

import modelo.daojdbc.PerfilDao;
import modelo.daojdbc.PerfilDaoImplMy8;
import modelo.javabeans.Perfil;

public class TestBuscarPerfil {

	public static void main(String[] args) {
		
		PerfilDao pdao = new PerfilDaoImplMy8();
	//Eliminamos el perfil 5
		System.out.println("BUSCAR POR ID_PERFIL");
		System.out.println();
		System.out.println(pdao.buscarUno(3));
		
	}

}
