package modelo.daojdbc;

import java.util.List;

import modelo.javabeans.Departamento;
<<<<<<< HEAD

public interface DepartamentoDao {

	int altaDepartamento(Departamento departamento);

	int eliminarDepartamento(int idDepartamento);

	int modificarUnDepartamento(Departamento departamento);

	Departamento buscarUnDepartamento(int idDepartamento);

	List<Departamento> buscarTodosDepartamentos();
=======
import modelo.javabeans.Perfil;

public interface DepartamentoDao {
	
	int altaDepartamento(Departamento departamento);
	int eliminarUno (int idDepartamento);
	int modificarUno(Departamento departamento); 
	List<Perfil> buscarTodos();
	Departamento buscarUno (int idDepartamento);


}
