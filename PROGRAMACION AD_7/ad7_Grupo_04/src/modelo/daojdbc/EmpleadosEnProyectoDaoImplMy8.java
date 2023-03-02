package modelo.daojdbc;

import java.sql.SQLException;
import java.util.List;

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
		Proyecto pdao = new ProyectoDaoImplMy8();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, numeroOrden);
			// alimento el interrogante
			rs = ps.executeQuery();
			if (rs.next()) {
				// si existen monta el objeto
				eep = new EmpleadosEnProyecto();
				eep.setNumeroOrden(rs.getInt("numero_orden"));
				eep.set(rs.getString("nombre"));
				eep.setDireccion(rs.getString("direccion"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dep;
	}

	@Override
	public List<EmpleadosEnProyecto> buscarTodasLasOrdenes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int modificarUnaOrden(EmpleadosEnProyecto orden) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<EmpleadosEnProyecto> empleadosByProyecto(String codigoProyecto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int asiganarEmpleadosAProyecto(List<EmpleadosEnProyecto> empleados) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int horasAsignadasAProyecto(String codigoProyecto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double costeActualDeProyecto(String codigoProyecto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double margenActualProyecto(String codigoProyecto) {
		// TODO Auto-generated method stub
		return 0;
	}

}