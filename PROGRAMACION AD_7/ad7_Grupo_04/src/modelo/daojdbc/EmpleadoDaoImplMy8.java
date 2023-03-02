package modelo.daojdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.javabeans.Empleado;

public class EmpleadoDaoImplMy8 extends AbstractDaoMy8 implements EmpleadoDao {

	/*
	 * Sobreescribimos el método altaEmpleado. A través de este método, se inserta
	 * un empleado utilizando Eclipse y se refleja en la BBDD. Como el método arroja
	 * una excepción, dentro de try definimos las sentencias SQL que pueden causar
	 * la excepción En catch, definimos la respuesta que daremos a dicha excepción.
	 */
	@Override
	public int altaEmpleado(Empleado empleado) {
		sql = "insert into empleados values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		filas = 0;

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, empleado.getIdEmpl());
			ps.setString(2, empleado.getNombre());
			ps.setString(3, empleado.getApellidos());
			ps.setString(4, empleado.getEmail());
			ps.setString(5, empleado.getPassword());
			ps.setDouble(6, empleado.getSalario());
			ps.setString(7, empleado.getFechaIngreso());
			ps.setString(8, empleado.getFechaNacimiento());
			ps.setInt(9, empleado.getPerfil().getIdPerfil());
			ps.setInt(10, empleado.getDepartamento().getIdDepartamento());

			filas = ps.executeUpdate();
			filas = 1;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return filas;
	}

	/*
	 * Sobreescribimos el método elimnarUno. Para eliminar un empleado de la tabla,
	 * el procedimiento se realizará utilizando el id del empleado. Definimos la
	 * sentencia sql y capturamos la excepciones.
	 */

	@Override
	public int eliminarUno(int idEmpl) {
		sql = "delete from empleado where id_empl = ?";
		filas = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idEmpl);
			filas = ps.executeUpdate();
			filas = 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return filas;
	}

	/*
	 * Sobreescribimos el método modificarUno. En este método, a partir del cif de
	 * un empleado, se modifican sus datos con la sentencia sql correspondiente. El
	 * método retornará true si la modificación fue exitosa.
	 */
	@Override
	public int modificarUno(Empleado empleado) {
		sql = "update from empleados set id_empl=?" + "nombre = ?" + "apellidos = ?" + "email = ?" + "password = ?"
				+ "salario = ?" + "fecha_inicio = ?" + "fecha_nacimiento = ?" + "id_perfil = ?" + "id_departamento = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, empleado.getIdEmpl());
			ps.setString(2, empleado.getNombre());
			ps.setString(3, empleado.getApellidos());
			ps.setString(4, empleado.getEmail());
			ps.setString(5, empleado.getPassword());
			ps.setDouble(6, empleado.getSalario());
			ps.setString(7, empleado.getFechaIngreso());
			ps.setString(8, empleado.getFechaNacimiento());
			ps.setInt(9, empleado.getPerfil().getIdPerfil());
			ps.setInt(10, empleado.getDepartamento().getIdDepartamento());

			filas = ps.executeUpdate();
			filas = 1;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	/*
	 * Sobreescribimos el método buscarUno. En este método, obtenemos los datos de
	 * un empleado introducinedo su cif. Si dicho empleado existe, el método
	 * retornará la fila que contiene los datos correspondientes al empleado cuyo
	 * cif hemos pasado como parámetro.
	 */
	@Override
	public Empleado buscarUno(int idEmpl) {
		sql = "select form empleados where id_empl = ?";
		Empleado empleado = null;
		PerfilDao pdao = new PerfilDaoImplMy8();

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idEmpl);
			rs = ps.executeQuery();

			if (rs.next()) {
				empleado = new Empleado();
				empleado.setIdEmpl(rs.getInt("id_empl"));
				empleado.setNombre(rs.getString("nombre"));
				empleado.setApellidos(rs.getString("apellidos"));
				empleado.setEmail(rs.getString("email"));
				empleado.setPassword(rs.getString("password"));
				empleado.setSalario(rs.getDouble("salario"));
				empleado.setFechaIngreso(rs.getString("fecha_ingreso"));
				empleado.setFechaNacimiento(rs.getString("fecha_nacimiento"));
				empleado.setPerfil(pdao.buscarUno(rs.getInt("id_perfil")));

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	/*
	 * Sobreescribimos el método buscarTodos. Este método devolverá una lista con
	 * todos los empleados que existen en la BBDD.
	 */
	@Override
	public List<Empleado> buscarTodos() {
		sql = "select form empleados";
		List<Empleado> lista = new ArrayList<>();

		try {
			ps = conn.prepareStatement(sql);

		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}

	@Override
	public List<Empleado> buscarEmpleadoPorDepartamento(int idDepartamento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Empleado> buscarEmpleadoPorGenero(char genero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Empleado> buscarEmpleadoPorApellido(String subcadena) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double salarioTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double salarioTotal(int idDepartamento) {
		// TODO Auto-generated method stub
		return 0;
	}

}
