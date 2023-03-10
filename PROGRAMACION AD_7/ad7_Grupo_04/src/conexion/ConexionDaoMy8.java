package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDaoMy8 {

	// Definimos los atributos de la clase
	private static String url;
	private static String user;
	private static String password;
	private static Connection conn;

	// Creamos el m�todo para la conexi�n con la BBDD
	private ConexionDaoMy8() {
		url = "jdbc:mysql://localhost:3306/banco_fp_23?serverTimezone=UTC";
		user = "root";
		password = "";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Conexion establecida");

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Conexion no establecida");
		}
	}

	public static Connection getConexion() {
		if (conn == null) {
			new ConexionDaoMy8();
		}
		return conn;

	}

}
