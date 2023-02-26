package modelo.javabeans;

import java.util.Objects;

public class ProyectoConEmpleado {
	
	// Definimos los atributos para la clase ProyectosConEmpleado que se corresponden con los
	//que aparecen en la BBDD
	
	int numeroOrden;
	Proyecto proyecto;
	Empleado empleado;
	int horasAsignadas;
	String fechaIncorporacion;
	
	// Definimos el método constructor con todos los parámetros
	public ProyectoConEmpleado(int numeroOrden, Proyecto proyecto, Empleado empleado, int horasAsignadas,
			String fechaIncorporacion) {
		super();
		this.numeroOrden = numeroOrden;
		this.proyecto = proyecto;
		this.empleado = empleado;
		this.horasAsignadas = horasAsignadas;
		this.fechaIncorporacion = fechaIncorporacion;
	}
	
	// Definimos el método constructor sin parámetros
	public ProyectoConEmpleado() {
		super();
	}
	
	//Generamos los getters and setters
	public int getNumeroOrden() {
		return numeroOrden;
	}

	public void setNumeroOrden(int numeroOrden) {
		this.numeroOrden = numeroOrden;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public int getHorasAsignadas() {
		return horasAsignadas;
	}

	public void setHorasAsignadas(int horasAsignadas) {
		this.horasAsignadas = horasAsignadas;
	}

	public String getFechaIncorporacion() {
		return fechaIncorporacion;
	}

	public void setFechaIncorporacion(String fechaIncorporacion) {
		this.fechaIncorporacion = fechaIncorporacion;
	}

	//Generamos equals y hashcode, en los cuales definimos que dos ProyectoConEmpleado son iguales 
	//si tienen el mismo numeroOrden
	@Override
	public int hashCode() {
		return Objects.hash(numeroOrden);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProyectoConEmpleado other = (ProyectoConEmpleado) obj;
		return numeroOrden == other.numeroOrden;
	}
	
	

}