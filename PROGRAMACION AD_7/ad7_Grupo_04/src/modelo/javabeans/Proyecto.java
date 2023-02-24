package modelo.javabeans;

import java.util.Objects;

public class Proyecto {
	
	//Definimos los atributos para la clase Proyecto que se corresponden con los
	//que aparecen en la BBDD
	
	String idProyecto;
	String descripcion;
	String fechaInicio;
	String fechaFinPrevisto;
	String fechaFinReal;
	double ventasPrevisto;
	double costesPrevisto;
	String estado;
	int jefeProyecto;
	Empleado empleado;
	
	//Generamos el método constructor con todos los parámetros
	public Proyecto(String idProyecto, String descripcion, String fechaInicio, String fechaFinPrevisto,
			String fechaFinReal, double ventasPrevisto, double costesPrevisto, String estado, int jefeProyecto,
			Empleado empleado) {
		super();
		this.idProyecto = idProyecto;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFinPrevisto = fechaFinPrevisto;
		this.fechaFinReal = fechaFinReal;
		this.ventasPrevisto = ventasPrevisto;
		this.costesPrevisto = costesPrevisto;
		this.estado = estado;
		this.jefeProyecto = jefeProyecto;
		this.empleado = empleado;
	}
	
	//Generamos el método constructor sin parámetros
	public Proyecto() {
		super();
	}
	
	//Generamos los getters and setters
	public String getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(String idProyecto) {
		this.idProyecto = idProyecto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFinPrevisto() {
		return fechaFinPrevisto;
	}

	public void setFechaFinPrevisto(String fechaFinPrevisto) {
		this.fechaFinPrevisto = fechaFinPrevisto;
	}

	public String getFechaFinReal() {
		return fechaFinReal;
	}

	public void setFechaFinReal(String fechaFinReal) {
		this.fechaFinReal = fechaFinReal;
	}

	public double getVentasPrevisto() {
		return ventasPrevisto;
	}

	public void setVentasPrevisto(double ventasPrevisto) {
		this.ventasPrevisto = ventasPrevisto;
	}

	public double getCostesPrevisto() {
		return costesPrevisto;
	}

	public void setCostesPrevisto(double costesPrevisto) {
		this.costesPrevisto = costesPrevisto;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getJefeProyecto() {
		return jefeProyecto;
	}

	public void setJefeProyecto(int jefeProyecto) {
		this.jefeProyecto = jefeProyecto;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	//Generamos equals y hashcode, en los cuales definimos que dos proyectos son iguales si
	//tienen el mismo idProyecto
	@Override
	public int hashCode() {
		return Objects.hash(idProyecto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proyecto other = (Proyecto) obj;
		return Objects.equals(idProyecto, other.idProyecto);
	}
	
	
	

}
