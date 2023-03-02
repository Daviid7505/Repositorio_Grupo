package modelo.daojdbc;

import java.util.List;

import modelo.javabeans.Departamento;

public interface DepartamentoDao {

	int altaDepartamento(Departamento departamento);

	int eliminarDepartamento(int idDepartamento);

	int modificarUnDepartamento(Departamento departamento);

	Departamento buscarUnDepartamento(int idDepartamento);

	List<Departamento> buscarTodosDepartamentos();

}
