package modelo.daojdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.javabeans.Empleado;
import modelo.javabeans.EmpleadosEnProyecto;
import modelo.javabeans.Proyecto;

public class EmpleadosEnProyectoDaoImplMy8 extends AbstractDaoMy8 implements EmpleadosEnProyectoDao {

	@Override
	public int altaOrden(EmpleadosEnProyecto orden) {
		sql = "insert into proyecto_con_empleados values(?,?,?,?,?)";
		filas = 0;
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
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int eliminarOrden(int numeroOrden) {
		sql = "delete from proyecto_con_empleados where numero_orden = ?";
		filas = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, numeroOrden);

			filas = ps.executeUpdate();
			filas = 1;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public EmpleadosEnProyecto buscarUno(int numeroOrden) {
		sql = "select * from proyecto_con_empleados where numero_orden = ?";
		EmpleadosEnProyecto eep = null;
		ProyectoDao pdao = new ProyectoDaoImplMy8();
		EmpleadoDao edao = new EmpleadoDaoImplMy8();
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
			e.printStackTrace();
		}
		return eep;
	}

	@Override
	public List<EmpleadosEnProyecto> buscarTodasLasOrdenes() {
		sql = "select * from proyecto_con_empleados";
		List<EmpleadosEnProyecto> lista = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();
			while (rs.next()) {
				ProyectoDao pdao = new ProyectoDaoImplMy8();
				EmpleadoDao edao = new EmpleadoDaoImplMy8();
				EmpleadosEnProyecto eep = new EmpleadosEnProyecto();
				// si existen monta el objeto
				eep = new EmpleadosEnProyecto();
				eep.setNumeroOrden(rs.getInt("numero_orden"));
				eep.setProyecto(pdao.buscarUno(rs.getString("id_proyecto")));
				eep.setEmpleado(edao.buscarUno(rs.getInt("id_empl")));
				eep.setHorasAsignadas(rs.getInt("horas_asignadas"));
				eep.setFechaIncorporacion(rs.getDate("fecha_incorporacion"));
				lista.add(eep);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public int modificarUnaOrden(EmpleadosEnProyecto orden) {
		sql = "update proyecto_con_empleados set id_proyecto = ? ," + " id_empl = ? ," + " horas_asignadas = ? ,"
				+ " fecha_incorporacion = ? " + " where numero_orden = ?";
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
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public List<EmpleadosEnProyecto> empleadosByProyecto(String codigoProyecto) {
		sql = "select * from proyecto_con_empleados where id_proyecto = ?";

		List<EmpleadosEnProyecto> lista = new ArrayList<>();
		ProyectoDao pdao = new ProyectoDaoImplMy8();
		EmpleadoDao edao = new EmpleadoDaoImplMy8();
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
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public int asignarEmpleadosAProyecto(List<EmpleadosEnProyecto> empleados) {
<<<<<<< HEAD
		sql = "insert into proyecto_con_empleados values(?,?,?,?,?)";
		filas = 0;
		try {
			ps = conn.prepareStatement(sql);
			filas = ps.executeUpdate();
			filas = 1;

			while (rs.next()) {
				ProyectoDao pdao = new ProyectoDaoImplMy8();
				EmpleadoDao edao = new EmpleadoDaoImplMy8();
				EmpleadosEnProyecto eep = new EmpleadosEnProyecto();
				eep = new EmpleadosEnProyecto();
				eep.setNumeroOrden(rs.getInt("numero_orden"));
				eep.setProyecto(pdao.buscarUno(rs.getString("id_proyecto")));
				eep.setEmpleado(edao.buscarUno(rs.getInt("id_empl")));
				eep.setHorasAsignadas(rs.getInt("horas_asignadas"));
				eep.setFechaIncorporacion(rs.getDate("fecha_incorporacion"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
=======
		sql = "update proyecto_con_empleados set id_proyecto = ? , id_empl = ? , horas_asignadas = ?, numero_orden = ?"
				+ "where id_proyecto = ?";
		
		filas = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setObject(1, empleados);
			filas = ps.executeUpdate();
			
			while (rs.next()) {
				EmpleadosEnProyecto eep = new EmpleadosEnProyecto();
				List <EmpleadosEnProyecto> lista = new ArrayList<>();
				lista.add(eep);
			}
			filas = 1;
						
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
>>>>>>> 0a609fe5649d35636430c218f71a2637da8df2fc
		return filas;
	}

	@Override
	public int horasAsignadasAProyecto(String codigoProyecto) {
		sql = "select sum(horas_asignadas) as sumaHorasProyecto from proyecto_con_empleados where id_proyecto = ?";
		int suma = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, codigoProyecto);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				suma = rs.getInt("sumaHorasProyecto"); // lo que vale es el alias
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return suma;
	}

	@Override
	public double costeActualDeProyecto(String codigoProyecto) {
		return 0;
	
	}

	@Override
	public double margenActualProyecto(String codigoProyecto) {
		sql = "select (venta_previsto - costes_previsto) as margen from proyectos";
		double margen = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setDouble(1, margen);
			rs = ps.executeQuery();
<<<<<<< HEAD
			if (rs.next()) {
				margen = rs.getDouble("margen"); // lo que vale es el alias
=======
			
			while (rs.next()) {
				margen = rs.getDouble("m"); // lo que vale es el alias
>>>>>>> 0a609fe5649d35636430c218f71a2637da8df2fc
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return margen;
	}

}
