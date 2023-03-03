package modelo.daojdbc;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.PopupFactory;

import modelo.javabeans.Perfil;

public class PerfilDaoImplMy8 extends AbstractDaoMy8 implements PerfilDao {
	
	/*Sobreescribimos el metodo altaPerfil. A traves de este metodo insertamos en la
	* en la BBDD un nuevo perfil. Una vez dado de lata, retornara la fila con los datos
	* del perfil agregado.
	*/
	 
	@Override
	public int altaPerfil(Perfil perfil) {
		sql = "insert into perfiles values (?,?,?)";
		filas = 0;
		Perfil pf = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, perfil.getIdPerfil());
			ps.setString(2, perfil.getNombre());
			ps.setDouble(3, perfil.getPrecio_hora());
			filas = ps.executeUpdate();
			filas = 1;
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return filas;
	}
	
	/*Sobreescribimos el metodo eliminarUno. En este meetodo se elimina un perfil
	 * pasando por parametro el id del perfil que se desea eliminar.
	 */
	@Override
	public int eliminarUno(int idPerfil) {
	sql = "delete from perfiles where id_perfil = ?";
	filas = 0;
	
	try {
	ps = conn.prepareStatement(sql);
	ps.setInt(1, idPerfil);
	filas = ps.executeUpdate();
	filas = 1;
			
	} catch (Exception e) {
		e.printStackTrace();
	}
		return filas;
	}
	
	/*Sobreescribimos el metodo modificarUno, el cual modifica los datos del perfil en 
	 * la BBDD, pasandole los parametros. El metodo retorna la fila la modificacion. 
	 */
	@Override
	public int modificarUno(Perfil perfil) {
	sql = "update from perfiles set id_perfil= ?" + "nombre = ?"+ "precio_hora=?";
	
	try {
		ps = conn.prepareStatement(sql);
		ps.setInt(1, perfil.getIdPerfil());
		ps.setString(2, perfil.getNombre());
		ps.setDouble(3, perfil.getPrecio_hora());
		
		filas = ps.executeUpdate();
		filas = 1;
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return filas;
	}
	

	/*Sobreescribimos el metodo buscarTodos. En este metodo devuelva una lista con todos los 
	 * perfiles existentes en la BBDD.
	 */
	@Override
	public List<Perfil> buscarTodos() {
	sql = "select * from perfiles";
	List<Perfil> lista = new ArrayList<>();
				
	try {
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
	
		while(rs.next()) {
		Perfil pf = new Perfil();
		
		pf.setIdPerfil(rs.getInt("id_perfil"));
		pf.setNombre(rs.getString("nombre"));
		pf.setPrecio_hora(rs.getDouble("precio_hora"));
		lista.add(pf);
		
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return lista;
	}

	
	/*Sobreescribimos el metodo buscarUno. Este metodo devuelve la fila que contiene el 
	 * id_perfil que le pasamos por parametro.  
	 */
	@Override
	public Perfil buscarUno(int idPerfil) {
	sql = "select * from perfiles where id_perfil = ?";
	Perfil perfil = null;
		
	try {
	ps = conn.prepareStatement(sql);
	ps.setInt(1, idPerfil);
	rs = ps.executeQuery();
	
	if (rs.next()) {
	perfil = new Perfil();
	perfil.setIdPerfil(rs.getInt("id_perfil"));
	perfil.setNombre(rs.getNString("nombre"));
	perfil.setPrecio_hora(rs.getDouble("precio_hora"));
	}
			
	} catch (Exception e) {
		e.printStackTrace();
	}
		return perfil;
	}

}
