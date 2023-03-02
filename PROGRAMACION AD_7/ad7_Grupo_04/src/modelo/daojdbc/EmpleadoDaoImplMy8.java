package modelo.daojdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.javabeans.Departamento;
import modelo.javabeans.Empleado;

public class EmpleadoDaoImplMy8 extends AbstractDaoMy8 implements EmpleadoDao {

	/*
	 * Sobreescribimos el m�todo altaEmpleado. A trav�s de este m�todo, se inserta
	 * un empleado utilizando Eclipse y se refleja en la BBDD. Como el m�todo arroja
	 * una excepci�n, dentro de try definimos las sentencias SQL que pueden causar
	 * la excepci�n En catch, definimos la respuesta que daremos a dicha excepci�n.
	 */
	@Override
	public int altaEmpleado(Empleado empleado) {
		sql = "insert into empleados values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		filas = 0;

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, empleado.getIdEmpl());
			ps.setString(2, empleado.getNombre());
			ps.setString(3, empleado.getApellidos());
			ps.setCharacterStream(4, empleado.getGenero());
			ps.setString(5, empleado.getEmail());
			ps.setString(6, empleado.getPassword());
			ps.setDouble(7, empleado.getSalario());
			ps.setString(8, empleado.getFechaIngreso());
			ps.setString(9, empleado.getFechaNacimiento());
			ps.setInt(10, empleado.getPerfil().getIdPerfil());
			ps.setInt(110, empleado.getDepartamento().getIdDepartamento());

			filas = ps.executeUpdate();
			filas = 1;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return filas;
	}
//-------------------------------------------------------------------------------------------------------------------------
	/*
	 * Sobreescribimos el m�todo elimnarUno. Para eliminar un empleado de la tabla,
	 * el procedimiento se realizar� utilizando el id del empleado. Definimos la
	 * sentencia sql y capturamos la excepciones.
	 */

	@Override
	public int eliminarUno(int idEmpl) {
		sql = "delete from empleado where id_empl = ?";
		filas = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idEmpl);
			filas = ps.executeUpdate();
			filas = 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return filas;
	}
//---------------------------------------------------------------------------------------------------------------------------
	
	/*
	 * Sobreescribimos el m�todo modificarUno. En este m�todo, a partir del cif de
	 * un empleado, se modifican sus datos con la sentencia sql correspondiente. El
	 * m�todo retornar� true si la modificaci�n fue exitosa.
	 */
	@Override
	public int modificarUno(Empleado empleado) {
		sql = "update from empleados set id_empl=?" + "nombre = ?" + "apellidos = ?" + "email = ?" + "password = ?"
				+ "salario = ?" + "fecha_inicio = ?" + "fecha_nacimiento = ?" + "id_perfil = ?" + "id_departamento = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, empleado.getIdEmpl());
			ps.setString(2, empleado.getNombre());
			ps.setString(3, empleado.getApellidos());
			ps.setCharacterStream(4, empleado.getGenero());
			ps.setString(5, empleado.getEmail());
			ps.setString(6, empleado.getPassword());
			ps.setDouble(7, empleado.getSalario());
			ps.setString(8, empleado.getFechaIngreso());
			ps.setString(9, empleado.getFechaNacimiento());
			ps.setInt(10, empleado.getPerfil().getIdPerfil());
			ps.setInt(11, empleado.getDepartamento().getIdDepartamento());

			filas = ps.executeUpdate();
			filas = 1;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas;
	}
//--------------------------------------------------------------------------------------------------------------------------
	
	/*
	 * Sobreescribimos el m�todo buscarUno. En este m�todo, obtenemos los datos de
	 * un empleado introducinedo su cif. Si dicho empleado existe, el m�todo
	 * retornar� la fila que contiene los datos correspondientes al empleado cuyo
	 * cif hemos pasado como par�metro.
	 */
	@Override
	public Empleado buscarUno(int idEmpl) {
		sql = "select form empleados where id_empl = ?";
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
//-----------------------------------------------------------------------------------------------------------------------------------
	/*
	 * Sobreescribimos el m�todo buscarTodos. Este m�todo devolver� una lista con
	 * todos los empleados que existen en la BBDD.
	 */
	@Override
	public List<Empleado> buscarTodos() {
		sql = "select form empleados";
		List<Empleado> lista = new ArrayList<>();

		try {
			ps = conn.prepareStatement(sql);

		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}
//-----------------------------------------------------------------------------------------------------------------------
	@Override
	public List<Empleado> buscarEmpleadoPorDepartamento(int idDepartamento) {
		sql = "select * from empleados where id_departamento = ?";
		
	/*Cramos un nuevo objeto dep y definimos la lista que mostrará los empleados que
	* pertenecen al departamento pasado por id. 
	*/
	DepartamentoDao ddao = new DepartamentoDaoImplMy8();
	List<Empleado> lista = new ArrayList<>();
		
	//Captruramos las excepciones
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idDepartamento);
			rs = ps.executeQuery();
			
			Departamento dep = ddao.buscarUnDepartamento(idDepartamento);
				
	//Establecemos que, aunque el id de departamento no exsita, se muestre la tabla vacía	
				if (dep == null) {
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
					emp.setGenero(rs.getCharacterStream("genero"));
					emp.setEmail(rs.getNString("email"));
					emp.setPassword(rs.getNString("password"));
					emp.setSalario(rs.getDouble("salario"));
					emp.setFechaIngreso(rs.getNString("fecha_ingreso"));
					emp.setFechaNacimiento(rs.getNString("fecha_nacimiento"));
					emp.setPerfil(pdao.buscarUno(rs.getInt("id_perfil")));
					emp.setDepartamento(dep);
			
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
		
	//Sobreescribimos el método buscar empleado por género
	@Override
	public List<Empleado> buscarEmpleadoPorGenero(char genero) {
		sql = "select * from empleados where genero = ?";
		EmpleadoDao edao = new EmpleadoDaoImplMy8();
		List<Empleado> lista = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setCharacterStream(1, genero);
			rs = ps.executeQuery();
						
			Empleado emp = (Empleado) edao.buscarEmpleadoPorGenero(genero);
		/*Se sitúa el cursor antes de la primera fila y luego recorremos loas filas a través
		*de las columnas y se recorren hasta que no haya más apellidos que inicien con la 
		*subcadena indicada*/
				while (rs.next()) {
					DepartamentoDao ddao = new DepartamentoDaoImplMy8();
					PerfilDao pdao = new PerfilDaoImplMy8();
					
					emp.setIdEmpl(rs.getInt("id_empleado"));
					emp.setNombre(rs.getNString("nombre"));
					emp.setApellidos(rs.getNString("apellidos"));
					emp.setGenero(rs.getCharacterStream("genero"));
					emp.setEmail(rs.getNString("email"));
					emp.setPassword(rs.getNString("password"));
					emp.setSalario(rs.getDouble("salario"));
					emp.setFechaIngreso(rs.getNString("fecha_ingreso"));
					emp.setFechaNacimiento(rs.getNString("fecha_nacimiento"));
					emp.setPerfil(pdao.buscarUno(rs.getInt("id_perfil")));
					emp.setDepartamento(ddao.buscarUnDepartamento(rs.getInt("id_departamento")));
					
		/*Establecemos que se agreguen a la lista los empelados que cumplan con la condición de 
		*búsqueda.
		*/
					lista.add(emp);
					}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*Devolvemos la tabla que contiene a todos los empleados que pertenecen al departamento 
		 * cuyo id fue establecido en la condición de búsqueda.
		 */
		return lista;
		
		}		
//-----------------------------------------------------------------------------------------------------------------------
	
	
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
					e.setGenero(rs.getCharacterStream("genero"));
					e.setEmail(rs.getString("email"));
					e.setPassword(rs.getNString("password"));
					e.setSalario(rs.getDouble("salario"));
					e.setFechaIngreso(rs.getString("fecha_ingreso"));
					e.setFechaNacimiento(rs.getString("fecha_nacimiento"));
					e.setPerfil(pdao.buscarUno(rs.getInt("id_perfil")));
					e.setDepartamento(ddao.buscarUnDepartamento(rs.getInt("id_departamento")));
					
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
	
	
	/*Sobreescribimos el método buscar por pefil. En este método, se ingresa el idPerfil con
	 *y se obtiene una lista con  todos los empleados que contienen dicho perfil.  
	 */
	@Override
	public List<Empleado> buscarEmpleadoPorPerfil(int idPerfil) {
		//Escribimos la sentencia sql para la búsqueda en MySQL
		sql = "select * from empleados where id_perfil = ?";
		
//Definimos la lista que mostrará los resultados obtenidos
	List<Empleado> lista = new ArrayList<>();
		
//Capturamos las excepciones		
	try {		
		ps = conn.prepareStatement(sql);
		ps.setInt(1, idPerfil);;
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
			e.setGenero(rs.getCharacterStream("genero"));
			e.setEmail(rs.getString("email"));
			e.setPassword(rs.getNString("password"));
			e.setSalario(rs.getDouble("salario"));
			e.setFechaIngreso(rs.getString("fecha_ingreso"));
			e.setFechaNacimiento(rs.getString("fecha_nacimiento"));
			e.setPerfil(pdao.buscarUno(rs.getInt("id_perfil")));
			e.setDepartamento(ddao.buscarUnDepartamento(rs.getInt("id_departamento")));
			
			lista.add(e);
			}
//En caso de producirse un error, lo imprimimos con la sentencia comprendida en "catch"		
} catch (Exception e) {
		e.printStackTrace();
		}
//Devolvemos la lista con las condiciones de búsqueda pautadas en el inicio	
return lista;
	}
//---------------------------------------------------------------------------------------------	
	
	
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
		}
	//Retornamos la suma de los salarios del departamento especifcado		
		return suma;
		}

	
	
	}



