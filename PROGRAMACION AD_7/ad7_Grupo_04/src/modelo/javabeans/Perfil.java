package modelo.javabeans;

import java.util.Objects;

public class Perfil {
	
	// Definimos los atributos para la clase departamento que se corresponden con los
	//que aparecen en la BBDD
	
	int idPerfil;
	String nombre;
	double precio_hora;
	
	//Definimos los constructores de la clase con todos los parámetros
	
	public Perfil(int idPerfil, String nombre, double precio_hora) {
		super();
		this.idPerfil = idPerfil;
		this.nombre = nombre;
		this.precio_hora = precio_hora;
	}

	//Definimos el constructor sin parámetros
	public Perfil() {
		super();
	}
	
	//Generamos los getters and setters
	public int getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public double getPrecio_hora() {
		return precio_hora;
	}

	public void setPrecio_hora(double precio_hora) {
		this.precio_hora = precio_hora;
	}
	
	//Método toString
	@Override
	public String toString() {
		return "Perfil [idPerfil=" + idPerfil + ", nombre=" + nombre + ", precio_hora=" + precio_hora + "]";
	}

	//Generamos equals y hashcode, en el cual definimos que dos departamentos son iguales si
	//tienen el mismo idPerfil
	@Override
	public int hashCode() {
		return Objects.hash(idPerfil);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Perfil other = (Perfil) obj;
		return idPerfil == other.idPerfil;
	}
	
	

}
