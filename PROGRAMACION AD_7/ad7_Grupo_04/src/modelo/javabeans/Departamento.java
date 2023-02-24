package modelo.javabeans;

import java.util.Objects;

public class Departamento {
	
	// Definimos los atributos para la clase Departamento que se corresponden con los
	//que aparecen en la BBDD
	
	int idDepartamento;
	String nombre;
	String direccion;
	
	//Definimos los constructores de la clase con todos los parámetros
	public Departamento(int idDepartamento, String nombre, String direccion) {
		super();
		this.idDepartamento = idDepartamento;
		this.nombre = nombre;
		this.direccion = direccion;
	}
	//Definimos el constructor sin parámetros
	public Departamento() {
		super();
	}
	
	//Insertamos los getters and setters
	public int getIdDepartamento() {
		return idDepartamento;
	}
	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	//Generamos equals y hashcode, en los cuales definimos que dos departamentos son iguales si
	//tienen el mismo idDepartamento
	@Override
	public int hashCode() {
		return Objects.hash(idDepartamento);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		return idDepartamento == other.idDepartamento;
	}
	
	
	
	

}
