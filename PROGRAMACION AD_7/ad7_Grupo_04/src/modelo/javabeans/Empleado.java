package modelo.javabeans;

import java.util.Objects;

public class Empleado {
	
	// Definimos los atributos para la clase Empleado que se corresponden con los
	//que aparecen en la BBDD
	
	int idEmpl;
	String nombre;
	String apellidos;
	char genero;
	String email;
	String password;
	double salario;
	String fechaIngreso;
	String fechaNacimiento; 
	Perfil perfil;
	Departamento departamento;
	
	
	//Generamos el constructor sin parámetros
	public Empleado() {
		super();
	}
	
	
//Generamosel constructor con todos los parámetros
	
	public Empleado(int idEmpl, String nombre, String apellidos, char genero, String email, String password,
			double salario, String fechaIngreso, String fechaNacimiento, Perfil perfil, Departamento departamento) {
		super();
		this.idEmpl = idEmpl;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.genero = genero;
		this.email = email;
		this.password = password;
		this.salario = salario;
		this.fechaIngreso = fechaIngreso;
		this.fechaNacimiento = fechaNacimiento;
		this.perfil = perfil;
		this.departamento = departamento;
	}

	//Generamos los getters and setters
	public int getIdEmpl() {
		return idEmpl;
	}

	public void setIdEmpl(int idEmpl) {
		this.idEmpl = idEmpl;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public char getGenero() {
		return genero;
	}


	public void setGenero(char genero) {
		this.genero = genero;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	//Generamos equals y hashcode, en los cuales definimos que dos empleados son iguales si
	//tienen el mismo idEmpl
	@Override
	public int hashCode() {
		return Objects.hash(idEmpl);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return idEmpl == other.idEmpl;
	}
	
	//Método toString
	@Override
	public String toString() {
		return "Empleado [idEmpl=" + idEmpl + ", nombre=" + nombre + ", apellidos=" + apellidos + ", genero=" + genero
				+ ", email=" + email + ", password=" + password + ", salario=" + salario + ", fechaIngreso="
				+ fechaIngreso + ", fechaNacimiento=" + fechaNacimiento + ", perfil=" + perfil + ", departamento="
				+ departamento + "]";
	}

	//Métodos propios de la clase
	
	//Método que calcula el salario bruto del empleado
	public double salarioBruto() {
		double salarioBruto = salario;
		return salarioBruto;
	}
	
	//Metodo que calcula el salario mensual del empleado
	public double salarioMensual(int meses) {
	double salarioMensual=0;
	salarioMensual = salario/meses;
	return salarioMensual;
	}
	
	//Método que devuelve el género de una persona
	public String literalSexo(char genero) {
		if (genero == 'H' || genero == 'h')
			return "Sexo : Hombre";
		else if (genero == 'M'|| genero == 'm')
			return "Sexo : Mujer";
		else
			return "Sexo erróneo";
	}
	
	//Método que devuelve el email del empleado
	public String obtenerEmail() {
		int espacio = apellidos.indexOf(" "); // para averiguar en qu� posici�n est� el espacio entre los apellidos
		String obtenerEmail = (nombre.charAt(0) + apellidos.substring(0, espacio)).toLowerCase() + "@nombreEmpresa.com";
		return obtenerEmail;
	}
	
	//Método que devuelve el nombre completo del empleado
	public String nombreCompleto() {
		String nombreCompleto = nombre + " " + apellidos;
		return nombreCompleto;
	}
}
	

