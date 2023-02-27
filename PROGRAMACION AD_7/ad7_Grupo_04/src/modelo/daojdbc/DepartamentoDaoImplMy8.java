package modelo.daojdbc;

import java.util.List;

import modelo.javabeans.Departamento;
import modelo.javabeans.Perfil;

public class DepartamentoDaoImplMy8 extends AbstractDaoMy8 implements DepartamentoDao {

	/*Sobreescribimos el m�todo altaDepartamento. A trav�s de este m�todo, se inserta un 
	*departamento utilizando Eclipse y se refleja en la BBDD. Como el m�todo arroja una
	*excepci�n, dentro de try definimos las sentencias SQL que pueden causar la excepci�n
	*En catch, definimos la respuesta que daremos a dicha excepci�n.
	*/
	@Override
	public int altaDepartamento(Departamento departamento) {
	sql = "insert into departamentos values (?, ?, ?)";
	filas = 0;
	
	try {
		ps = conn.prepareStatement(sql);
		ps.setInt(1, departamento.getIdDepartamento());
		ps.setString(2, departamento.getNombre());
		ps.setString(3, departamento.getDireccion());
		
		filas= ps.executeUpdate();
		filas = 1;
		
	} catch (Exception e) {
		e.printStackTrace();
	}
		
		return filas;
	}

	@Override
	public int eliminarUno(int idDepartamento) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modificarUno(Departamento departamento) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Perfil> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Departamento buscarUno(int idDepartamento) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	
}
