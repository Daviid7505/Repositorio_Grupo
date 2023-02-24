package modelo.daojdbc;

import java.sql.ResultSet;
import java.util.List;

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

	@Override
	public List<Perfil> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Perfil buscarUno(int idPerfil) {
		// TODO Auto-generated method stub
		return null;
	}

}
