package modelo.daojdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import conexion.ConexionDaoMy8;

public class AbstractDaoMy8 {
	
	//Definimos los atributos necesarios para trabajar con la BBDD
	protected Connection conn;
	protected PreparedStatement ps;
	protected ResultSet rs;
	protected String sql;
	protected int filas;
	
	//Definimos el m�todo que utilizaremos para trabajar con java en conexi�n
	//con la BBDD
	public AbstractDaoMy8() {
		conn = ConexionDaoMy8.getConexion();
	}

}
