package modelo.javabeans;

import java.sql.Date;
import java.util.Objects;

public class EmpleadosEnProyecto {

	// Definimos los atributos para la clase ProyectosConEmpleado que se
	// corresponden con los
	// que aparecen en la BBDD

	private int numeroOrden;
	private Proyecto proyecto;
	private Empleado empleado;
	private int horasAsignadas;
	private Date fechaIncorporacion;

	// Definimos el metodo constructor con todos los parametros
	public EmpleadosEnProyecto(int numeroOrden, Proyecto proyecto, Empleado empleado, int horasAsignadas,
			Date fechaIncorporacion) {
		super();
		this.numeroOrden = numeroOrden;
		this.proyecto = proyecto;
		this.empleado = empleado;
		this.horasAsignadas = horasAsignadas;
		this.fechaIncorporacion = fechaIncorporacion;
	}

	// Definimos el metodo constructor sin parámetros
	public EmpleadosEnProyecto() {
		super();
	}

	// Generamos los getters and setters
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

	public Date getFechaIncorporacion() {
		return fechaIncorporacion;
	}

	public void setFechaIncorporacion(Date fechaIncorporacion) {
		this.fechaIncorporacion = fechaIncorporacion;
	}

	// Generamos equals y hashcode, en los cuales definimos que dos
	// ProyectoConEmpleado son iguales
	// si tienen el mismo numeroOrden
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
		EmpleadosEnProyecto other = (EmpleadosEnProyecto) obj;
		return numeroOrden == other.numeroOrden;

	}

	// Metodos propios:
	public double costeHorasAsignadas() {
		double coste = getEmpleado().getPerfil().getPrecio_hora();
		return horasAsignadas * coste;
	}

}
