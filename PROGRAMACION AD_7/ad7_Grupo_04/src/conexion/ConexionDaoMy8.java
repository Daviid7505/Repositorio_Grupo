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

	// Creamos el método para la conexión con la BBDD
	private ConexionDaoMy8() {
		url = "jdbc:mysql://localhost:3306/clientes_proyectos_empleados_2023?serverTimezone=UTC";
		user = "root";
		password = "root";

		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Conexión establecida");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Conexión no establecida");
		}
	}

	public static Connection getConexion() {
		if (conn == null) {
			new ConexionDaoMy8();
		}
		return conn;

	}

}
