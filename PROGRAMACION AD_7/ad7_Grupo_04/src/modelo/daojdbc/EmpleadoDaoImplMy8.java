package modelo.daojdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.javabeans.Departamento;
import modelo.javabeans.Empleado;
import modelo.javabeans.Perfil;

public class EmpleadoDaoImplMy8 extends AbstractDaoMy8 implements EmpleadoDao{
	
	/*Sobreescribimos el m�todo altaEmpleado. A trav�s de este m�todo, se inserta un 
	*empleado utilizando Eclipse y se refleja en la BBDD. Como el m�todo arroja una
	*excepci�n, dentro de try definimos las sentencias SQL que pueden causar la excepci�n
	*En catch, definimos la respuesta que daremos a dicha excepci�n.
	*/
	@Override
	public int altaEmpleado(Empleado empleado) {
	
	//Definimos la sentencia sql que nos permitirá dar de alta al empleado
		sql = "insert into empleados values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		filas = 0; 
	
	//Capturamos las excepciones y definimos las sentencias en el bloque try
		try {
		ps = conn.prepareStatement(sql);
		ps.setInt(1, empleado.getIdEmpl());
		ps.setString(2, empleado.getNombre());
		ps.setString(3, empleado.getApellidos());
		ps.setString(4, empleado.getEmail());
		ps.setString(5, empleado.getPassword());
		ps.setDouble(6, empleado.getSalario());
		ps.setString(7, empleado.getFechaIngreso());
		ps.setString(8, empleado.getFechaNacimiento());
		ps.setInt(9, empleado.getPerfil().getIdPerfil());
		ps.setInt(10, empleado.getDepartamento().getIdDepartamento());
		
		filas = ps.executeUpdate();
		filas = 1;
	
	//Imprimimos las excepciones en caso de que los hubiera	
	}catch (SQLException e ) {
		e.printStackTrace();
	}return filas;
	}
	
	/*Sobreescribimos el m�todo elimnarUno. Para eliminar un empleado de la tabla, el
	*procedimiento se realizar� utilizando el id del empleado. Definimos la sentencia sql y 
	*capturamos la excepciones. 
	*/
	 
	@Override
	public int eliminarUno(int idEmpl) {
	
	//Definimos la qwery que nos permite eliminar un empleado, de la tabla empleados
	sql = "delete * from empleados where id_empl = ?";
	filas = 0;
	
	//Establecemos el bloque try, capturando las sentencias que dan excepción dentro de este
	try {
		ps = conn.prepareStatement(sql); 
		ps.setInt(1, idEmpl);
		filas = ps.executeUpdate();
		filas = 1;
	
	//Imprimimos las excepciones en caso de que los hubiera	
	}catch (SQLException e) {
		e.printStackTrace();
	}
	//Retornamos la tabla que muestra todas las filas, prescindicndo del empleado que fue
	//eliminado
	return filas;
	}
//------------------------------------------------------------------------------------------
	
	/*Sobreescribimos el m�todo modificarUno. En este m�todo, a partir del cif de un
	*empleado, se modifican sus datos con la sentencia sql correspondiente. El m�todo 
	*retornará 1 si la modificaci�n fue exitosa.
	*/
	@Override
	public int modificarUno(Empleado empleado) {
	
	//Definimos la qwery que nos permite modificar un empleado de la tabla empleados
	sql = "update from empleados set id_empl=?"
			+ "nombre = ?"
			+ "apellidos = ?"
			+ "email = ?"
			+ "password = ?"
			+ "salario = ?"
			+ "fecha_inicio = ?"
			+ "fecha_nacimiento = ?"
			+ "id_perfil = ?"
			+ "id_departamento = ?";
	
	/*Establecemos el bloque try y capturamos dentro de este aquellas sentencias que pueden 
	*causar excepciones
	*/
	try {
		ps = conn.prepareStatement(sql);
		ps.setInt(1, empleado.getIdEmpl());
		ps.setString(2, empleado.getNombre());
		ps.setString(3, empleado.getApellidos());
		ps.setString(4, empleado.getEmail());
		ps.setString(5, empleado.getPassword());
		ps.setDouble(6, empleado.getSalario());
		ps.setString(7, empleado.getFechaIngreso());
		ps.setString(8, empleado.getFechaNacimiento());
		ps.setInt(9, empleado.getPerfil().getIdPerfil());
		ps.setInt(10, empleado.getDepartamento().getIdDepartamento());
		
		filas = ps.executeUpdate();
		filas = 1;
		
	//Imprimimos las excepciones en caso de que los hubiera	
	} catch (Exception e) {
		e.printStackTrace();
	}
	//Se devuelve 1 si la modificación fue exitosa. Caso contrario, devolverá 0.
		return filas;
	}
//-------------------------------------------------------------------------------------------
	
	/*Sobreescribimos el m�todo buscarUno. En este m�todo, obtenemos los datos de un 
	 * empleado introducinedo su cif. Si dicho empleado existe, el m�todo retornar�
	 * la fila que contiene los datos correspondientes al empleado cuyo cif hemos
	 * pasado como par�metro. 
	 */
	@Override
	public Empleado buscarUno(int idEmpl) {
	sql = "select * from empleados where id_empl = ?"; 
	Empleado empleado = null; 
	PerfilDao pdao = new PerfilDaoImplMy8();
	
	try {
		ps = conn.prepareStatement(sql);
		ps.setInt(1, idEmpl);
		rs = ps.executeQuery();
		
		if (rs.next()) {
			empleado = new Empleado();
			empleado.setIdEmpl(rs.getInt("id_empl"));
			empleado.setNombre(rs.getString("nombre"));
			empleado.setApellidos(rs.getString("apellidos"));
			empleado.setEmail(rs.getString("email"));
			empleado.setPassword(rs.getString("password"));
			empleado.setSalario(rs.getDouble("salario"));
			empleado.setFechaIngreso(rs.getString("fecha_ingreso"));
			empleado.setFechaNacimiento(rs.getString("fecha_nacimiento"));
			empleado.setPerfil(pdao.buscarUno(rs.getInt("id_perfil")));
				
		}
	
	//Imprimimos las excepciones en caso de que los hubiera			
	} catch (Exception e) {
		e.printStackTrace();
	}
		return empleado;
	}
//-------------------------------------------------------------------------------------------
	
	/*Sobreescribimos el m�todo buscarTodos. Este m�todo devolver� una lista con todos los 
	*empleados que existen en la BBDD.
	*/
	@Override
	public List<Empleado> buscarTodos() {
		
	/*Definimos la sentencia sql que nos permite obtener la tabla que contiene a todos 
	*los empleados
	*/
	sql = "select * from empleados";
	
	/*Creamos el objeto "lista" que devolverá la tabla con todos los empelados existentes. Además,
	 *creamos los objetos pdao y dep que nos permitirán implementar el método "buscarUno"
	 *para invocar el id de cada uno de estos objetos.
	 */
	List<Empleado> lista = new ArrayList<>();
	PerfilDao pdao = new PerfilDaoImplMy8();
	DepartamentoDao dep = new DepartamentoDaoImplMy8();
	
	//Establecemos el boque try, definiendo dentro de este las sentencias que causarán excepciones.
	try {
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
	
	/*En el bucle while, situamos el cursor antes de la primera fila y luego recorremos loas filas
 	*través de las columnas y se recorren hasta que no haya más apellidos que inicien con la 
	*subcadena indicada
	*/
	 	while (rs.next()) {
			Empleado emp = new Empleado();
			emp.setIdEmpl(rs.getInt("id_empleado"));
			emp.setNombre(rs.getNString("nombre"));
			emp.setApellidos(rs.getNString("apellidos"));
			emp.setEmail(rs.getNString("email"));
			emp.setPassword(rs.getNString("password"));
			emp.setSalario(rs.getByte("salario"));
			emp.setFechaIngreso(rs.getString("fecha_ingreso"));
			emp.setFechaNacimiento(rs.getString("fecha_nacimiento"));
			emp.setPerfil(pdao.buscarUno(rs.getInt("id_perfil")));
			emp.setDepartamento(dep.buscarUno(rs.getInt("id_departamento")));
			
			lista.add(emp);			
		}
	
	//Imprimimos las excepciones en caso de que los hubiera	
	} catch (Exception e) {
		e.printStackTrace();
	}
	//Retornamos la tabla que muestra todos los empelados existentes
		return lista;
	}
//------------------------------------------------------------------------------------------
	
	
	/*Sobreescribimos el método buscar un empleado por departamento. En este caso, pasando
	 * el id del departamento, obtendremos los empleados que pertenecen a este. 
	 */
	@Override
	public List<Empleado> buscarEmpleadoPorDepartamento(int idDepartamento) {
		sql = "select * from empleados where id_departamento = ?";
	
	/*Cramos un nuevo objeto dep y definimos la lista que mostrará los empleados que
	 * pertenecen al departamento pasado por id. 
	 */
	DepartamentoDao dep = new DepartamentoDaoImplMy8();
	List<Empleado> lista = new ArrayList<>();
	
	//Captruramos las excepciones
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idDepartamento);
			rs = ps.executeQuery();
		
		Departamento departamento = dep.buscarUno(idDepartamento);
		
	//Establecemos que, aunque el id de departamento no exsita, se muestre la tabla vacía	
			if (departamento == null) {
				return lista;
			}
	/*Se sitúa el cursor antes de la primera fila y luego recorremos loas filas a través
	*de las columnas y se recorren hasta que no haya más apellidos que inicien con la 
	*subcadena indicada*/
			while (rs.next()) {
				Empleado emp = new Empleado();
				PerfilDao pdao = new PerfilDaoImplMy8();
				
				emp.setIdEmpl(rs.getInt("id_empleado"));
				emp.setNombre(rs.getNString("nombre"));
				emp.setApellidos(rs.getNString("apellidos"));
				emp.setEmail(rs.getNString("email"));
				emp.setPassword(rs.getNString("password"));
				emp.setSalario(rs.getDouble("salario"));
				emp.setFechaIngreso(rs.getNString("fecha_ingreso"));
				emp.setFechaNacimiento(rs.getNString("fecha_nacimiento"));
				emp.setPerfil(pdao.buscarUno(rs.getInt("id_perfil")));
				emp.setDepartamento(departamento);
		
	/*Establecemos que se agreguen a la lista los empelados que cumplan con la condición de 
	*búsqueda.
	*/
				lista.add(emp);
		}
	
	//Imprimimos los errores y excepciones, en caso de producirse
		} catch (Exception e) {
			e.printStackTrace();
	}
	
	/*Devolvemos la tabla que contiene a todos los empleados que pertenecen al departamento 
	 * cuyo id fue establecido en la condición de búsqueda.
	 */
	return lista;
	}
//-------------------------------------------------------------------------------------------
	
	//VEEEEEERRRRRR!!!!!!!!!!!!!
	@Override
	public List<Empleado> buscarEmpleadoPorGenero(char genero){
	
		return null;
	}
	
	
	/*Sobreescribimos el método buscar por apellido. En este método, se ingresa la subcadena con
	 * las letras por las cuales comienza el apellido del empleado y se obtiene una lista con 
	 * todos los empleados que contienen dicha subcadena.  
	 */
	@Override
	public List<Empleado> buscarEmpleadoPorApellido(String subcadena) {
		
	//Escribimos la sentencia sql para la búsqueda en MySQL
		sql = "select * from empleados where apellidos like ?";
		
	//Definimos la lista que mostrará los resultados obtenidos
		List<Empleado> lista = new ArrayList<>();
		
	//Capturamos las excepciones		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, subcadena + "%");
			rs = ps.executeQuery();
	
	/*Se sitúa el cursor antes de la primera fila y luego recorremos loas filas a través
	 *de las columnas y se recorren hasta que no haya más apellidos que inicien con la 
	 *subcadena indicada*/
			while (rs.next()) {
				Empleado e = new Empleado();
				PerfilDao pdao = new PerfilDaoImplMy8();
				DepartamentoDao ddao = new DepartamentoDaoImplMy8();
				
				e.setIdEmpl(rs.getInt("id_empleado"));
				e.setNombre(rs.getString("nombre"));
				e.setApellidos(rs.getString("apellidos"));
				e.setEmail(rs.getString("email"));
				e.setPassword(rs.getNString("password"));
				e.setSalario(rs.getDouble("salario"));
				e.setFechaIngreso(rs.getString("fecha_ingreso"));
				e.setFechaNacimiento(rs.getString("fecha_nacimiento"));
				e.setPerfil(pdao.buscarUno(rs.getInt("id_perfil")));
				e.setDepartamento(ddao.buscarUno(rs.getInt("id_departamento")));
				
				lista.add(e);
			}
	//En caso de producirse un error, lo imprimimos con la sentencia comprendida en "catch"		
		} catch (Exception e) {
			e.printStackTrace();
		}
	//Devolvemos la lista con las condiciones de búsqueda pautadas en el inicio	
		return lista;
	}
//--------------------------------------------------------------------------------------------
	/*Sobreescribimos el método salario total. Para este método, solo se muetra una fila que 
	*contiene la suma de los salarios de todos los empleados. 
	*/
	@Override
	public double salarioTotal() {
	
	//Definimos la sentencia sql que ejecutará la suma de los salarios
		sql = "select sum(salario as suma from empleados";
		
	//Defnimos e iniciamos la variable suma
		double suma = 0;
	
	//Capturamos las excepciones en try, definiendo las sentencias sql dentro de este bloque.
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
	/*Se sitúa el cursor antes de la primera fila y luego recorremos loas filas a través
	 *de las columnas*/
			if (rs.next()) {
				suma = rs.getDouble("suma");
			}
	//En caso de producirse un error, lo imprimimos con la sentencia comprendida en "catch"			
		} catch (Exception e) {
			e.printStackTrace();
		}
	//Devolvemos la suma de los salarios de todos los empleados		
		return suma;
	}

	/*Sobreescribimos el método salario total por departamentos. Para este método, se muestran 
	 * las filas con la suma de los salarios de todos los empleados especificados por departamento. 
	 */
	@Override
	public double salarioTotal(int idDepartamento) {
		sql = "select sum(salario) as suma from empleados where id_departamento = ?";
		
	//Defnimos e iniciamos la variable suma
		double suma = 0;
		
	//Capturamos las excepciones en try, definiendo las sentencias sql dentro de este bloque.
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idDepartamento);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				suma = rs.getDouble("salario");
			}
				
	//En caso de producirse un error, lo imprimimos con la sentencia comprendida en "catch"			
		} catch (Exception e) {
			e.printStackTrace();
		
	//Retornamos la suma de los salarios del departamento especifcado		
		return suma;
		}
	}
}

