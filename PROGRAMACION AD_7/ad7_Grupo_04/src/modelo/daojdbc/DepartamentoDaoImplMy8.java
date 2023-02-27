package modelo.daojdbc;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.javabeans.Departamento;

public class DepartamentoDaoImplMy8 extends AbstractDaoMy8 implements DepartamentoDao {

	@Override
	public int altaDepartamento(Departamento departamento) {
		sql = "insert into departamentos values(?,?,?)";
		filas = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, departamento.getIdDepartamento());
			ps.setString(2, departamento.getNombre());
			ps.setString(3, departamento.getDireccion());
			filas = ps.executeUpdate();
			filas = 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
=======
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

	public int eliminarDepartamento(int idDepartamento) {
		sql = "delete from departamentos where id_depar = ?";
		filas = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idDepartamento);

			filas = ps.executeUpdate();
			filas = 1;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int modificarUnDepartamento(Departamento departamento) {
		sql = "update departamentos set nombre = ? ," + " direccion = ? " + " where id_depar = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(3, departamento.getIdDepartamento());
			ps.setString(1, departamento.getNombre());
			ps.setString(2, departamento.getDireccion());

			filas = ps.executeUpdate();
			filas = 1;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public Departamento buscarUnDepartamento(int idDepartamento) {
		sql = "select * from departamentos where id_depar = ?";
		Departamento dep = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idDepartamento);
			// alimento el interrogante
			rs = ps.executeQuery();
			if (rs.next()) {
				// si existen monta el objeto
				dep = new Departamento();
				dep.setIdDepartamento(rs.getInt("id_depar"));
				dep.setNombre(rs.getString("nombre"));
				dep.setDireccion(rs.getString("direccion"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dep;
	}

	@Override
	public List<Departamento> buscarTodosDepartamentos() {
		sql = "select * from departamentos";
		List<Departamento> lista = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();
			while (rs.next()) {
				Departamento dep = new Departamento();
				// si existen monta el objeto
				dep = new Departamento();
				dep.setIdDepartamento(rs.getInt("id_depar"));
				dep.setNombre(rs.getString("nombre"));
				dep.setDireccion(rs.getString("direccion"));
				lista.add(dep);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return lista;
	}


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
