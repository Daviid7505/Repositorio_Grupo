package modelo.daojdbc;

import java.util.List;

import modelo.javabeans.Departamento;
import modelo.javabeans.Perfil;

public interface DepartamentoDao {
	
	int altaDepartamento(Departamento departamento);
	int eliminarUno (int idDepartamento);
	int modificarUno(Departamento departamento); 
	List<Perfil> buscarTodos();
	Departamento buscarUno (int idDepartamento);

}
