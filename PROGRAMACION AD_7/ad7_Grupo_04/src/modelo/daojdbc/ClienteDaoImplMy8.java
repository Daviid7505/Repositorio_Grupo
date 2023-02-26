package modelo.daojdbc;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import modelo.javabeans.Cliente;

public class ClienteDaoImplMy8 extends AbstractDaoMy8 implements ClienteDao {

	@Override
	public int altaCliente(Cliente cliente) {
			//Insertamos la sentencia sql que queremos ejecutar
			sql = "insert into clientes values (?, ?, ?, ?, ?, ?)";
			//Damos valor a la variable filas
			filas = 0;
			try {
				//Le indicamos al prepareStatement que sentencia se va a ejecutar, en este caso la de la variable sql
				ps=conn.prepareStatement(sql);
				//Vamos metiendo datos en nuestro cliente
				ps.setString(1, cliente.getCif());
				ps.setString(2, cliente.getNombre());
				ps.setString(3, cliente.getApellidos());
				ps.setString(4, cliente.getDomicilio());
				ps.setDouble(5, cliente.getFacturacionAnual());
				ps.setInt(6, cliente.getNumeroEmpleados());
				
				//la variable filas es actualizada con las filas que tiene la variable ps
				//usamos executeUpdate porque nos devuelve un entero
				filas = ps.executeUpdate();
				filas =1;
			}
			//Le indicamos que si hay una excepción que nos imprima la traza, creando la variable e como
			//SQLException y usando la clase printStackTrace();
				catch (SQLException e) {
				e.printStackTrace();
			}
		//Devolvemos el número de filas actualizadas si todo ha ido bien 	
		return filas;
	}

	@Override
	public Cliente buscarCliente(String cif) {
			//Insertamos la sentencia sql que queremos ejecutar
			sql="select * from clientes where cif = ?";
			//Creamos un cliente sin constructor
			Cliente cl = null;
			try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cif);
			//Usamos executeQuery porque estamos recuperando informacion
			rs = ps.executeQuery();
			
			//Nosotros en el ps.executeQuery hemos pedido que nos devuelva una fila con el cif
			//Puede que encuentre 1 cliente con ese cif o que no encuentre ninguno
			//Usamos next para saber si rs ha devuelto una fila; next nos devuelve un boolean true si hay 1 fila
			//o false si no hay fila, y dependiendo de esto en nuestro if haremos una cosa u otra
			if (rs.next()) {
				//creamos un cliente vacío que será en el que carguemos los datos
				cl = new Cliente();
				
				cl.setCif(rs.getString("cif"));
				cl.setNombre(rs.getString("nombre"));
				cl.setApellidos(rs.getString("apellidos"));
				//Hay dos formas de indicar el campo, la primera es usando getString e indicando el nombre de la columna
				//Y la segunda es con getInt indicando en que posición está ese campo, hemos usado las 2 formas.
				cl.setDomicilio(rs.getString(4));
				cl.setFacturacionAnual(rs.getDouble(5));
				cl.setNumeroEmpleados(rs.getInt(6));
			}
	
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
		return cl;
	}

	@Override
	public int borrarCliente(String cif) {
		//Introduzco la sentencia que quiero ejecutar
		sql = "delete from clientes where cif = ?";
		//Doy valor a la variable fila y la pongo a 0
		filas = 0;
		try {
		ps = conn.prepareStatement(sql);
		//Vamos a indicar el dato que hay que meter en la interrogación que hay en la sentencia
		ps.setString(1, cif);
		
		filas = ps.executeUpdate();
		filas = 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int modificarCliente(Cliente cliente) {
		//Metemos nuestra sentencia
		sql = "update cliente set cif = ?,"
				+ " nombre = ?, "
				+ " apellidos = ?, "
				+ " domicilio = ?, "
				+ " facturacion_anual = ?, "
				+ " numero_empleados = ?, ";
		
		//Le doy valor a la variable filas
		filas = 0;
		
		try {
			//Indicamos al preparaeStatement que ejecute la sentencia de la variable sql
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, cliente.getCif());
			ps.setString(2, cliente.getNombre());
			ps.setString(3, cliente.getApellidos());
			ps.setString(4, cliente.getDomicilio());
			ps.setDouble(5, cliente.getFacturacionAnual());
			ps.setInt(6,  cliente.getNumeroEmpleados());
			
			
			filas = ps.executeUpdate();
			filas=1;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
				
		return filas;
	}

	@Override
	public List<Cliente> buscarTodos() {
		//Metemos la sentencia sql
		sql = "select * from clientes";
		
		//Creamos una lista vacía donde vamos a ir metiendo todos los clientes que aparezcan al hacer la búsqueda
		List<Cliente> lista = new ArrayList<>();
		
		//Creamos un cliente sin constructor
		Cliente cl = null;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			//Creamos un bucle while para que entre siempre que el resultado de rs.next sea True, cuando nos devuelva false (que será cuando
			//no encuentre más clientes), nos devolverá false y dejará de entrar al bucle
			while (rs.next()) {
				//Creamos un cliente vacío para que reciba los datos
				cl = new Cliente();
					
					cl.setCif(rs.getString("cif"));
					cl.setNombre(rs.getString("nombre"));
					cl.setApellidos(rs.getString("apellidos"));
					cl.setDomicilio(rs.getString("domicilio"));
					cl.setFacturacionAnual(rs.getDouble(5));
					cl.setNumeroEmpleados(rs.getInt(6));
					
					//Después de haber creado el empleado vacío y haberle cargado datos, lo añadimos a la lista que habíamos creado anteriormente
					//que estaba vacía
					lista.add(cl);
					
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

}







