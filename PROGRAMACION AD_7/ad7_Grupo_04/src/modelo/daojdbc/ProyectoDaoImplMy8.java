package modelo.daojdbc;

import java.sql.SQLException;
import java.util.List;

import modelo.javabeans.Proyecto;

public class ProyectoDaoImplMy8 extends AbstractDaoMy8 implements ProyectoDao {

	@Override
	public int altaProyecto(Proyecto proyecto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminarProyecto(String idProyecto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modificarProyecto(Proyecto proyecto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Proyecto buscarUno(String idProyecto) {
		sql = "select * from proyectos where id_proyecto = ?";
		Proyecto pro = null;
		ClienteDao clidao = new ClienteDaoImplMy8();
		EmpleadoDao empdao = new EmpleadoDaoImplMy8();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, idProyecto);
			// alimento el interrogante
			rs = ps.executeQuery();
			if (rs.next()) {
				// si existen monta el objeto
				pro = new Proyecto();
				pro.setIdProyecto(rs.getString("id_proyecto"));
				pro.setDescripcion(rs.getString("descripcion"));
				pro.setFechaInicio(rs.getDate("fecha_inicio"));
				pro.setFechaFinPrevisto(rs.getDate("fecha_fin_previsto"));
				pro.setFechaFinReal(rs.getDate("fecha_fin_real"));
				pro.setVentasPrevisto(rs.getDouble("venta_previsto"));
				pro.setCostesPrevisto(rs.getDouble("coste_previsto"));
				pro.setCosteReal(rs.getDouble("coste_real"));
				pro.setEstado(rs.getString("estado"));

				/*
				 * Falta hacer el del jefe de proyecto y el cliente
				 */

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pro;
	}

	@Override
	public List<Proyecto> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Proyecto> proyectosByEstado(String estado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Proyecto> proyectosByCliente(String cif) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Proyecto> proyectosByJefeProyectoAndByEstado(int jefeProyecto, String estado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double importesVentaProyectosTerminados() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double margenBrutoProyectosTerminados() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int diasATerminoProyectoActivo(String codigoProyecto) {
		// TODO Auto-generated method stub
		return 0;
	}

}
