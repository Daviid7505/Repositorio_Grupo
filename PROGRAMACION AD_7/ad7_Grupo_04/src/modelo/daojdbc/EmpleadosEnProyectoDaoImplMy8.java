package modelo.daojdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.javabeans.EmpleadosEnProyecto;

public class EmpleadosEnProyectoDaoImplMy8 extends AbstractDaoMy8 implements EmpleadosEnProyectoDao {

	/*
	 * Sobreescribimos el metodo altaOrden() es para dar de alta un orden en la bbdd
	 * a través de java recibiendo como parametro un objeto de la clase
	 * EmpleadosEnProycecto llamado orden. Para resolver la excepcion, recurrimos al
	 * try catch.
	 */

	@Override
	public int altaOrden(EmpleadosEnProyecto orden) {
		sql = "insert into proyecto_con_empleados values(?,?,?,?,?)";
		filas = 0;
		// Se capturan las excepciones
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, orden.getNumeroOrden());
			ps.setString(2, orden.getProyecto().getIdProyecto());
			ps.setInt(3, orden.getEmpleado().getIdEmpl());
			ps.setInt(4, orden.getHorasAsignadas());
			ps.setDate(5, orden.getFechaIncorporacion());
			filas = ps.executeUpdate();
			filas = 1;
		} catch (SQLException e) {
			// Si hubiera errores, se imprimen por consola
			e.printStackTrace();
		}
		// Se devuelve un uno si se añade la fila o 0 si no se añade
		return filas;
	}

	/*
	 * Sobreescribimos el metodo eliminarOden() que consiste en eliminar un registro
	 * de la tabla proyecto_con_empleados recibiendo como parametro el numero_orden.
	 * Para resolver la excepcion, recurrimos al try catch.
	 */

	@Override
	public int eliminarOrden(int numeroOrden) {
		sql = "delete from proyecto_con_empleados where numero_orden = ?";
		filas = 0;
		// Se capturan las excepciones
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, numeroOrden);
			filas = ps.executeUpdate();
			filas = 1;
		} catch (SQLException e) {
			// Si hubiera errores, se imprimen por consola
			e.printStackTrace();
		}
		// Se devuelve un 1 si se elimina la fila o un 0 si no se elimina
		return filas;
	}

	/*
	 * Sobreescribimos el metodo buscarUno() que consiste en buscar un registro de
	 * la tabla proyecto_con_empleados recibiendo como parametro el numero de orden.
	 * Para resolver la excepcion, recurrimos al try catch con un condicional if ya
	 * que va a mostrar una fila o ninguna.
	 */

	@Override
	public EmpleadosEnProyecto buscarUno(int numeroOrden) {
		sql = "select * from proyecto_con_empleados where numero_orden = ?";
		EmpleadosEnProyecto eep = null;
		ProyectoDao pdao = new ProyectoDaoImplMy8();
		EmpleadoDao edao = new EmpleadoDaoImplMy8();
		// Se capturan las excepciones
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, numeroOrden);
			// alimento el interrogante
			rs = ps.executeQuery();
			if (rs.next()) {
				// si existen monta el objeto
				eep = new EmpleadosEnProyecto();
				eep.setNumeroOrden(rs.getInt("numero_orden"));
				eep.setProyecto(pdao.buscarUno(rs.getString("id_proyecto")));
				eep.setEmpleado(edao.buscarUno(rs.getInt("id_empl")));
				eep.setHorasAsignadas(rs.getInt("horas_asignadas"));
				eep.setFechaIncorporacion(rs.getDate("fecha_incorporacion"));
			}
		} catch (SQLException e) {
			// Si hubiera errores, se imprimen por consola
			e.printStackTrace();
		}
		// Se devuelve el objeto empleado que se busca
		return eep;
	}

	/*
	 * Sobreescribimos el metodo buscarTodasLasOrdenes() que consiste en buscar
	 * todos los registros de la tabla proyecto_con_empleados. Para resolver la
	 * excepcion, recurrimos al try catch con un condicional while ya que va a
	 * mostrar un numero de filas n.
	 */

	@Override
	public List<EmpleadosEnProyecto> buscarTodasLasOrdenes() {
		sql = "select * from proyecto_con_empleados";

		List<EmpleadosEnProyecto> lista = new ArrayList<>();
		ProyectoDao pdao = new ProyectoDaoImplMy8();
		EmpleadoDao edao = new EmpleadoDaoImplMy8();
		// Se capturan las excepciones
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				EmpleadosEnProyecto eep = new EmpleadosEnProyecto();
				// si existen monta el objeto
				eep.setNumeroOrden(rs.getInt("numero_orden"));
				eep.setProyecto(pdao.buscarUno(rs.getString("id_proyecto")));
				eep.setEmpleado(edao.buscarUno(rs.getInt("id_empl")));
				eep.setHorasAsignadas(rs.getInt("horas_asignadas"));
				eep.setFechaIncorporacion(rs.getDate("fecha_incorporacion"));
				lista.add(eep);
			}
		} catch (SQLException e) {
			// Si hubiera errores, se imprimen por consola
			e.printStackTrace();
		}
		// Se devuelven todos los registros de le tabla proyectos_con_empleados
		return lista;
	}

	/*
	 * Sobreescribimos el metodo modificarOrden() que sirve para modificar uno de
	 * los registros de la tabla proyecto_con_empleados recibiendo por parametro un
	 * objeto de la clase EmpleadosEnProyecto. Mediante el try catch se resuelven
	 * las excepciones.
	 */

	@Override
	public int modificarUnaOrden(EmpleadosEnProyecto orden) {
		sql = "update proyecto_con_empleados set id_proyecto = ? ," + " id_empl = ? ," + " horas_asignadas = ? ,"
				+ " fecha_incorporacion = ? " + " where numero_orden = ?";
		// Se capturan las excepciones
		try {
			filas = 0;
			ps = conn.prepareStatement(sql);
			ps.setInt(5, orden.getNumeroOrden());
			ps.setString(1, orden.getProyecto().getIdProyecto());
			ps.setInt(2, orden.getEmpleado().getIdEmpl());
			ps.setInt(3, orden.getHorasAsignadas());
			ps.setDate(4, orden.getFechaIncorporacion());

			filas = ps.executeUpdate();
			filas = 1;

		} catch (Exception e) {
			// Si hubiera errores, se imprimen por consola
			e.printStackTrace();
		}
		// Se devuelve 1 si se realiza el cambio o 0 si no se realiza
		return filas;
	}

	/*
	 * Sobreescribimos el metoso empleadosByProyecto() que recibe como parametro el
	 * codigo de proyecto y devuelve una lista con los empleados asociados a ese
	 * codigo de proyecto. Para resolver la excepcion, recurrimos al try catch con
	 * un condicional while ya que va a mostrar un numero de filas n.
	 */

	@Override
	public List<EmpleadosEnProyecto> empleadosByProyecto(String codigoProyecto) {
		sql = "select * from proyecto_con_empleados where id_proyecto = ?";

		List<EmpleadosEnProyecto> lista = new ArrayList<>();
		ProyectoDao pdao = new ProyectoDaoImplMy8();
		EmpleadoDao edao = new EmpleadoDaoImplMy8();
		// Se capturan las excepciones
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, codigoProyecto);
			rs = ps.executeQuery();

			while (rs.next()) {
				// si existen monta el objeto
				EmpleadosEnProyecto eep = new EmpleadosEnProyecto();
				eep.setNumeroOrden(rs.getInt("numero_orden"));
				eep.setProyecto(pdao.buscarUno(rs.getString("id_proyecto")));
				eep.setEmpleado(edao.buscarUno(rs.getInt("id_empl")));
				eep.setHorasAsignadas(rs.getInt("horas_asignadas"));
				eep.setFechaIncorporacion(rs.getDate("fecha_incorporacion"));
				lista.add(eep);
			}
		} catch (SQLException e) {
			// Si hubiera errores, se imprimen por consola
			e.printStackTrace();
		}
		// Devuelve la lista de registros que tienen asociado el codigo de proyecto
		// buscado
		return lista;
	}

	/*
	 * Sobreescribimos el metodo asignarEmpleadosAProyecto() que recibe una lista de
	 * empleados asociados a proyectos y devuelve el numero ordenes introducidas en
	 * la lista. Para resolver la excepcion, recurrimos al try catch.
	 */

	@Override
	public int asignarEmpleadosAProyecto(List<EmpleadosEnProyecto> empleados) {
<<<<<<< HEAD
	
=======

>>>>>>> Alberto
		sql = "insert into proyecto_con_empleados " + "(id_proyecto, id_empl, horas_asignadas, fecha_incorporacion) "
				+ "values(?,?,?,?)";
		EmpleadosEnProyecto eep = new EmpleadosEnProyecto();
		int contador = 0;
		for (EmpleadosEnProyecto ele : empleados) {
			// Se capturan las excepciones
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, ele.getProyecto().getIdProyecto());
				ps.setInt(2, ele.getEmpleado().getIdEmpl());
				ps.setInt(3, ele.getHorasAsignadas());
				ps.setDate(4, ele.getFechaIncorporacion());
				filas = ps.executeUpdate();
				contador++;
<<<<<<< HEAD

=======
>>>>>>> Alberto

			} catch (Exception e) {
				// Si hubiera errores, se imprimen por consola
				e.printStackTrace();
			}
<<<<<<< HEAD
		
		}
		return contador;

=======
		}
		// Devuelve el numero de registros que tiene la lista introducida por parametro
		return contador;
>>>>>>> Alberto
	}

	/*
	 * Sobreescribimos el metodo horasAsignadasAProyecto() que recibe un codigo de
	 * proyecto y devuelve la sumatoria del numero de horas asignadas a ese
	 * proyecto. Para resolver la excepcion, recurrimos al try catch.
	 */

	@Override
	public int horasAsignadasAProyecto(String codigoProyecto) {
		sql = "select sum(horas_asignadas) as sumaHorasProyecto from proyecto_con_empleados where id_proyecto = ?";
		int suma = 0;
		// Se capturan las excepciones
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, codigoProyecto);
			rs = ps.executeQuery();

			if (rs.next()) {
				suma = rs.getInt("sumaHorasProyecto"); // lo que vale es el alias
			}
		} catch (SQLException e) {
			// Si hubiera errores, se imprimen por consola
			e.printStackTrace();
		}
		// Devuelve el valor de la suma de las horas asignadas al proyecto buscado
		return suma;
	}

	/*
	 * Sobreescribimos el metodo costeActualDeProyecto() que recibe por parametro el
	 * codigo de proyecto y devuelve el total del producto numero de horas asignadas
	 * a ese proyecto por el precio hora del empleado. Para resolver la excepcion,
	 * recurrimos al try catch con condicional if ya que devuelve 0 o 1 fila.
	 */

	@Override
	public double costeActualDeProyecto(String codigoProyecto) {
		sql = "select sum(p.precio_hora *pce.horas_asignadas) as total from empleados e join perfiles p on e.id_perfil "
				+ "= p.id_perfil join proyecto_con_empleados pce on e.id_empl = pce.id_empl where id_proyecto = ?";

		double coste = 0;
		// Se capturan las excepciones
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, codigoProyecto);
			rs = ps.executeQuery();

			if (rs.next()) {
				coste = rs.getDouble("total"); // lo que vale es el alias
			}

		} catch (Exception e) {
			// Si hubiera errores, se imprimen por consola
			e.printStackTrace();
		}
		// Devuelve el coste del proyecto en base a las horas asignadas y al precio por
		// hora del proyecto buscado
		return coste;
	}

	/*
	 * Sobreescribimos el metodo margenActualProyecto() que recibe un codigo de
	 * proyecto y devuelve el beneficio resultante de la diferencia de la venta
	 * previsto menos el coste prevista. Para resolver la excepcion, recurrimos al
	 * try catch con condicional if ya que devuelve 0 o 1 fila.
	 */

	@Override
	public double margenActualProyecto(String codigoProyecto) {
		sql = "select (venta_previsto - costes_previsto) as margen from proyectos";
		double margen = 0;
		// Se capturan las excepciones
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				margen = rs.getDouble("margen");
			}
		} catch (SQLException e) {
			// Si hubiera errores, se imprimen por consola
			e.printStackTrace();
		}
		// Devuelve el beneficio
		return margen;
	}
}
