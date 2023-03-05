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
			filas = 0;
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

}