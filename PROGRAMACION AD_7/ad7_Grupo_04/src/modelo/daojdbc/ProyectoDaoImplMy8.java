package modelo.daojdbc;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.javabeans.Proyecto;

public class ProyectoDaoImplMy8 extends AbstractDaoMy8 implements ProyectoDao{
	
	
	//En esta clase se implementa todos los metodos del interface ProyectoDao
		//En todos estos metodos usaremos la coneccion conn. 
		//el prepareStatement sql ,ps. para preparar la sentencia y ejecutarla
		//el ResultSet r.s  para leer los datos 
		// Como ps. levanta exepciones metemos al try donde definimos la sentencia y en el catch donde definimos la respuesta a la exepcion
		
		//Los metodos CRUD
		
		
		//Con este metodo se puede dar de alta un nuevo proyecto
		
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
				ps.setDate(3,  proyecto.getFechaInicio());
				ps.setDate(4, proyecto.getFechaFinPrevisto());
				ps.setDate(5, proyecto.getFechaFinReal());
				ps.setDouble(6, proyecto.getVentaPrevisto());
				ps.setDouble(7, proyecto.getCostesPrevisto());
				ps.setDouble (8, proyecto.getCosteReal());
				ps.setString(9, proyecto.getEstado());
				ps.setInt(10 ,proyecto.getEmpleado().getIdEmpl());
				ps.setString(11, proyecto.getCliente().getCif());
				filas = ps.executeUpdate();
				filas = 1;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return filas;
		}

		
		//Este metodo elimina un proyecto
		
		
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
<<<<<<< HEAD
		return filas;
	}
	

	 //Este metodo modifica un proyecto
=======

		 //Este metodo modifica un proyecto
		
>>>>>>> kyty
		@Override
		public int modificarProyecto(Proyecto proyecto) {
			 sql = " update proyectos set descripcion = ?, fecha_inicio = ?, fecha_fin_previsto = ?, fecha_fin_real = ?, venta_previsto = ?, costes_previsto = ?, coste_real = ?, estado = ?, jefe_proyecto = ?, cif = ?"
					+ " where id_proyecto = ?";
			 filas = 0;
				try {
					ps = conn.prepareStatement(sql);
					ps.setString(1, proyecto.getDescripcion());
					ps.setDate(2, proyecto.getFechaInicio());
					ps.setDate(3, proyecto.getFechaFinPrevisto());
					ps.setDate (4, proyecto.getFechaFinReal());
					ps.setDouble(5, proyecto.getVentaPrevisto());
					ps.setDouble(6, proyecto.getCostesPrevisto());
					ps.setDouble (7, proyecto.getCosteReal());
					ps.setString(8, proyecto.getEstado());
					ps.setInt(9, proyecto.getEmpleado().getIdEmpl());
					ps.setString(10, proyecto.getCliente().getCif());
					ps.setString(11, proyecto.getIdProyecto());
					filas = ps.executeUpdate();
			
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
			
				}
				return filas;
		}
	     //Metodo que busca un proyecto pasandole el id de proyecto
		
		
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
					pro.setVentaPrevisto(rs.getDouble("venta_previsto"));
					pro.setCostesPrevisto(rs.getDouble("costes_previsto"));
					pro.setCosteReal (rs.getDouble("coste_real"));
					pro.setEstado(rs.getString("estado"));
					
					pro.setEmpleado(empdao.buscarUno(rs.getInt("jefe_proyecto")));
				    pro.setCliente(cldao.buscarCliente(rs.getString("cif")));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return pro;
			
		}
	    //Metodo que busca todos los proyectos
		
		
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
						pro.setVentaPrevisto(rs.getDouble("venta_previsto"));
						pro.setCostesPrevisto(rs.getDouble("costes_previsto"));
						pro.setCosteReal (rs.getDouble("coste_real"));
						pro.setEstado(rs.getString("estado"));
						
						pro.setEmpleado(empdao.buscarUno(rs.getInt("jefe_proyecto")));
						pro.setCliente(cldao.buscarCliente(rs.getString("cif")));
						lista.add(pro);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return lista;
			}
		
		
	    //Otros metodos de la clase
		
		//Metodo que busca un proyecto por el estado del proyecto que puede ser TERMINADO o ACTIVO
		
		
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
					pro.setVentaPrevisto(rs.getDouble("venta_previsto"));
					pro.setCostesPrevisto(rs.getDouble("costes_previsto"));
					pro.setCosteReal (rs.getDouble("coste_real"));
					pro.setEstado(rs.getString("estado"));
					
					pro.setEmpleado(empdao.buscarUno(rs.getInt("jefe_proyecto")));
					pro.setCliente(cldao.buscarCliente(rs.getString("cif")));
					lista.add(pro);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return lista;
		}
		
		//Metodo que busca un proyecto por el cif del cliente
		
		
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
					pro.setVentaPrevisto(rs.getDouble("venta_previsto"));
					pro.setCostesPrevisto(rs.getDouble("costes_previsto"));
					pro.setCosteReal (rs.getDouble("coste_real"));
					pro.setEstado(rs.getString("estado"));
					
					pro.setEmpleado(empdao.buscarUno(rs.getInt("jefe_proyecto")));
					pro.setCliente(cldao.buscarCliente(rs.getString("cif")));
					lista.add(pro);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return lista;
		}

			
	    //Metodo que busca los proyectos que tiene el mismo idJefeProyecto y el mismo estado
		
		
		@Override
		public List<Proyecto> proyectosByJefeProyectoAndByEstado(int jefeProyecto, String estado) {
			sql = "select * from proyectos where jefe_proyecto = ? and estado=? ";
			List<Proyecto> lista = new ArrayList<>();
			EmpleadoDao empdao= new EmpleadoDaoImplMy8();
			ClienteDao cldao = new ClienteDaoImplMy8();
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, jefeProyecto);
				ps.setString(2,estado);
				rs = ps.executeQuery();
				while (rs.next()) {
					Proyecto pro = new Proyecto();
			
					pro.setIdProyecto(rs.getString("id_proyecto"));
				    pro.setDescripcion(rs.getString("descripcion"));
					pro.setFechaInicio(rs.getDate("fecha_inicio"));
					pro.setFechaFinPrevisto(rs.getDate("fecha_fin_previsto"));
					pro.setFechaFinReal(rs.getDate("fecha_fin_real"));
					pro.setVentaPrevisto(rs.getDouble("venta_previsto"));
					pro.setCostesPrevisto(rs.getDouble("costes_previsto"));
					pro.setCosteReal (rs.getDouble("coste_real"));
					pro.setEstado(rs.getString("estado"));
					
					pro.setEmpleado(empdao.buscarUno(rs.getInt("jefe_proyecto")));
					pro.setCliente(cldao.buscarCliente(rs.getString("cif")));
					lista.add(pro);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return lista;
		}
		
		//Metodo que muestra el importe de venta de los proyectos terminados
		
		
		@Override
		public double importesVentaProyectosTerminados() {
			sql = "select sum(venta_previsto) as impventas from proyectos where estado = 'TERMINADO'";
			double suma = 0;
			
			try {
				ps = conn.prepareStatement(sql);
				
				rs = ps.executeQuery();
				if (rs.next()) {
					suma = rs.getDouble("impventas");
					
					
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return suma;
		}

		
		 //Metodo que calcula la diferencia de la suma importes venta y gastos reales.
		
		
		@Override  
		public double margenBrutoProyectosTerminados() {
			
			sql = "select ((sum(venta_previsto )) - (sum(coste_real))) as margen from proyectos where estado ='TERMINADO';";
			double margen = 0;
		
			try {
				ps = conn.prepareStatement(sql);
				
				
				rs = ps.executeQuery();
				if (rs.next()) {
					margen = rs.getDouble(1);
			
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return margen;
		}

		//Metodo que muestra cuantos días quedan para terminar el proyecto (diferencia entre fecha_fin_previsto y la fecha de hoy)
		
		
		@Override
		public int diasATerminoProyectoActivo(String codigoProyecto) {
			sql = "select  datediff(current_date() , fecha_fin_previsto) from proyectos where id_proyecto = ?";
			int dias = 0;
		
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, codigoProyecto);
				
				rs = ps.executeQuery();
				if (rs.next()) {
					dias = rs.getInt(1);
				
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dias;
		}

		}

		

	
	
