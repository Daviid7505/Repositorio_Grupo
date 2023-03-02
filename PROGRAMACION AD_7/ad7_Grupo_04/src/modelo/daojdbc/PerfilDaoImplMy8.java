package modelo.daojdbc;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.PopupFactory;

import modelo.javabeans.Perfil;

public class PerfilDaoImplMy8 extends AbstractDaoMy8 implements PerfilDao {
	
	/*Sobreescribimos el m�todo altaPerfil. A trav�s de este m�todo insertamos en la
	* en la BBDD un nuevo perfil. Una vez dado de lata, retornar� la fila con los datos
	* del perfil agregado.
	*/
	 
	@Override
	public int altaPerfil(Perfil perfil) {
		sql = "insert into perfiles values (?,?)";
		filas = 0;
		Perfil pf = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, perfil.getIdPerfil());
			ps.setString(2, perfil.getNombre());
			
			filas = ps.executeUpdate();
			filas = 1;
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return filas;
	}
	
	/*Sobreescribimos el m�todo eliminarUno. En este me�todo se elimina un perfil
	 * pasando por par�metro el id del perfil que se desea eliminar.
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
	
	/*Sobreescribimos el m�todo modificarUno, el cual modifica los datos del perfil en 
	 * la BBDD, pas�ndole los par�metros. El m�todo retorna la fila la modificaci�n. 
	 */
	@Override
	public int modificarUno(Perfil perfil) {
	sql = "update from perfiles set id_perfil= ?" + "nombre = ? ";
	
	try {
		ps = conn.prepareStatement(sql);
		ps.setInt(1, perfil.getIdPerfil());
		ps.setString(2, perfil.getNombre());
		
		filas = ps.executeUpdate();
		filas = 1;
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return filas;
	}
	

	/*Sobreescribimos el método buscarTodos. En este método devuelva una lista con tosos los 
	 * perfiles existentes en la BBDD.
	 */
	@Override
	public List<Perfil> buscarTodos() {
	sql = " select from perfiles ";
	List<Perfil> lista = new ArrayList<>();
	
			
	try {
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
	
		while(rs.next()) {
		Perfil pf = new Perfil();
		
		pf.setIdPerfil(rs.getInt("id_perfil"));
		pf.setNombre(rs.getString("nombre"));
		lista.add(pf);
		
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return lista;
	}

	
	/*Sobreescribimos el método buscarUno. Este método devuelve la fila que contiene el 
	 * id_perfil que le pasamos por parámetro.  
	 */
	@Override
	public Perfil buscarUno(int idPerfil) {
	sql = "select from perfiles where id_perfil = ?";
	Perfil perfil = null;
		
	try {
	ps = conn.prepareStatement(sql);
	ps.setInt(1, idPerfil);
	rs = ps.executeQuery();
	
	if (rs.next()) {
	perfil = new Perfil();
	perfil.setIdPerfil(rs.getInt("id_perfil"));
	perfil.setNombre(rs.getNString("nombre"));
	}
			
	} catch (Exception e) {
		e.printStackTrace();
	}
		return perfil;
	}

}
