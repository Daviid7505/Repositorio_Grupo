package modelo.daojdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.javabeans.Proyecto;

public class ProyectoDaoImplMy8 extends AbstractDaoMy8 implements ProyectoDao{
	@Override
	public int altaProyecto(Proyecto proyecto) {
		sql = "insert into proyectos values(?,?,?,?,?,?,?,?,?,?,?)";
		Proyecto pro = null;
		EmpleadoDao empdao = new EmpleadoDaoImplMy8();
		ClienteDao clidao = new ClienteDaoImplMy8();
		filas=0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, proyecto.getIdProyecto());
			ps.setString(2, proyecto.getDescripcion());
			ps.setDate(3, proyecto.getFechaInicio());
			ps.setDate(4, proyecto.getFechaFinPrevisto());
			ps.setDate(5, proyecto.getFechaFinReal());
			ps.setDouble(6, proyecto.getVentasPrevisto());
			ps.setDouble(7, proyecto.getCostesPrevisto());
			ps.setDouble (8, proyecto.getCosteReal());
			ps.setString(9, proyecto.getEstado());
			ps.setInt(10 ,proyecto.getJefeProyecto().getIdEmpl());
			ps.setString(11, proyecto.getCliente().getCif());
			filas = ps.executeUpdate();
			filas = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int eliminarProyecto(String idProyecto) {
		sql= "delete from proyectos where id_proyecto = ?";
		filas =0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, idProyecto);
			filas = ps.executeUpdate();
			filas = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filas;
	}
	

	@Override
	public int modificarProyecto(Proyecto proyecto) {
		 sql = "update proyecto set id_proyecto = ?,"
					+ "descripcion = ? ,"
					+ " fecha_inicio = ? ,"
					+ " fecha_fin _previsto = ? "
					+ " fecha_fin _real = ? "
					+ " venta _previsto = ? "
					+ " costes _previsto = ? "
					+ " coste_real = ? "
					+ " estado = ? "
					+ " jefe_proyecto = ? "
					+ " cif = ? "
					+ " where id_proyecto = ?";
			
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, proyecto.getIdProyecto());
				ps.setString(2, proyecto.getDescripcion());
				ps.setDate(3, proyecto.getFechaInicio());
				ps.setDate(4, proyecto.getFechaFinPrevisto());
				ps.setDate(5, proyecto.getFechaFinReal());
				ps.setDouble(6, proyecto.getVentasPrevisto());
				ps.setDouble(7, proyecto.getCostesPrevisto());
				ps.setDouble (8, proyecto.getCosteReal());
				ps.setString(9, proyecto.getEstado());
				ps.setInt(10, proyecto.getJefeProyecto().getIdEmpl());
				ps.setString(11, proyecto.getCliente().getCif());
				filas = ps.executeUpdate();
				filas = 1;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
		
			}
			return filas;	
		}
	@Override
	public Proyecto buscarUno(String idProyecto) {
		sql = "select * from proyectos where id_proyecto = ?";
		Proyecto pro = null;
		EmpleadoDao empdao= new EmpleadoDaoImplMy8();
		ClienteDao cldao = new ClienteDaoImplMy8();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, idProyecto);
			rs = ps.executeQuery();
			if (rs.next()) {
				pro = new Proyecto();
				pro.setIdProyecto(rs.getString("id_proyecto"));
				pro.setDescripcion(rs.getString("descripcion"));
				pro.setFechaInicio(rs.getDate("fecha_inicio"));
				pro.setFechaFinPrevisto(rs.getDate("fecha_fin_previsto"));
				pro.setFechaFinReal(rs.getDate("fecha_fin_real"));
				pro.setVentasPrevisto(rs.getDouble("venta_previsto"));
				pro.setCostesPrevisto(rs.getDouble("costes_previsto"));
				pro.setCosteReal (rs.getDouble("coste_real"));
				pro.setEstado(rs.getString("estado"));
				
				pro.setJefeProyecto(empdao.buscarUno(rs.getInt("jefe_proyecto")));
			    pro.setCliente(cldao.buscarCliente(rs.getString("cif")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pro;
		
	}

	@Override
	public List<Proyecto> buscarTodos() {
		 sql = "select * from proyectos ";
			List<Proyecto> lista = new ArrayList<>();
			EmpleadoDao empdao= new EmpleadoDaoImplMy8();
			ClienteDao cldao = new ClienteDaoImplMy8();
			try {
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					Proyecto pro = new Proyecto();
				
					pro.setIdProyecto(rs.getString("id_proyecto"));
					pro.setDescripcion(rs.getString("descripcion"));
					pro.setFechaInicio(rs.getDate("fecha_inicio"));
					pro.setFechaFinPrevisto(rs.getDate("fecha_fin_previsto"));
					pro.setFechaFinReal(rs.getDate("fecha_fin_real"));
					pro.setVentasPrevisto(rs.getDouble("venta_provisto"));
					pro.setCostesPrevisto(rs.getDouble("costes_previsto"));
					pro.setCosteReal (rs.getDouble("coste_real"));
					pro.setEstado(rs.getString("estado"));
					
					pro.setJefeProyecto(empdao.buscarUno(rs.getInt("jefe_proyecto")));
					pro.setCliente(cldao.buscarCliente(rs.getString("cif")));
					lista.add(pro);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return lista;
		}

	@Override
	public List<Proyecto> proyectosByEstado(String estado) {
		sql = "select * from proyectos where estado = ? ";
		List<Proyecto> lista = new ArrayList<>();
		EmpleadoDao empdao= new EmpleadoDaoImplMy8();
		ClienteDao cldao = new ClienteDaoImplMy8();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, estado);
			rs = ps.executeQuery();
			while (rs.next()) {
				Proyecto pro = new Proyecto();
		
				pro.setIdProyecto(rs.getString("id_proyecto"));
			    pro.setDescripcion(rs.getString("descripcion"));
				pro.setFechaInicio(rs.getDate("fecha_inicio"));
				pro.setFechaFinPrevisto(rs.getDate("fecha_fin_previsto"));
				pro.setFechaFinReal(rs.getDate("fecha_fin_real"));
				pro.setVentasPrevisto(rs.getDouble("venta_provisto"));
				pro.setCostesPrevisto(rs.getDouble("costes_previsto"));
				pro.setCosteReal (rs.getDouble("coste_real"));
				pro.setEstado(rs.getString("estado"));
				
				pro.setJefeProyecto(empdao.buscarUno(rs.getInt("jefe_proyecto")));
				pro.setCliente(cldao.buscarCliente(rs.getString("cif")));
				lista.add(pro);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	@Override
	public List<Proyecto> proyectosByCliente(String cif) {
		sql = "select * from proyectos where cif = ? ";
		List<Proyecto> lista = new ArrayList<>();
		EmpleadoDao empdao= new EmpleadoDaoImplMy8();
		ClienteDao cldao = new ClienteDaoImplMy8();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cif);
			rs = ps.executeQuery();
			while (rs.next()) {
				Proyecto pro = new Proyecto();
	
				pro.setIdProyecto(rs.getString("id_proyecto"));
				pro.setDescripcion(rs.getString("descripcion"));
				pro.setFechaInicio(rs.getDate("fecha_inicio"));
				pro.setFechaFinPrevisto(rs.getDate("fecha_fin_previsto"));
				pro.setFechaFinReal(rs.getDate("fecha_fin_real"));
				pro.setVentasPrevisto(rs.getDouble("ventas_previsto"));
				pro.setCostesPrevisto(rs.getDouble("costes_previsto"));
				pro.setCosteReal (rs.getDouble("coste_real"));
				pro.setEstado(rs.getString("estado"));
				
				pro.setJefeProyecto(empdao.buscarUno(rs.getInt("jefe_proyecto")));
				pro.setCliente(cldao.buscarCliente(rs.getString("cif")));
				lista.add(pro);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
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

	
	
