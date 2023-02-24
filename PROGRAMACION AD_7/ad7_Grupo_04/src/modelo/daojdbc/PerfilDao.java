package modelo.daojdbc;

import java.util.List;

import modelo.javabeans.Perfil;

public interface PerfilDao {
	
	int altaPerfil(Perfil perfil);
	int eliminarUno (int idPerfil);
	int modificarUno(Perfil perfil); 
	List<Perfil> buscarTodos();
	Perfil buscarUno (int idPerfil);
	
	

}
