package modelo.javabeans;

import java.sql.Date;
import java.util.Objects;

public class Proyecto {

	// Definimos los atributos para la clase Proyecto que se corresponden con los
	// que aparecen en la BBDD

	private String idProyecto;
	private String descripcion;
	private Date fechaInicio;
	private Date fechaFinPrevisto;
	private Date fechaFinReal;
	private double ventasPrevisto;
	private double costesPrevisto;
	private double costeReal;
	private String estado;
	private Empleado jefeProyecto;
	private Cliente cliente;

	// Generamos el metodo constructor con todos los parametros

	public Proyecto(String idProyecto, String descripcion, Date fechaInicio, Date fechaFinPrevisto, Date fechaFinReal,
			double ventasPrevisto, double costesPrevisto, double costeReal, String estado, Empleado jefeProyecto,
			Cliente cliente) {
		super();
		this.idProyecto = idProyecto;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFinPrevisto = fechaFinPrevisto;
		this.fechaFinReal = fechaFinReal;
		this.ventasPrevisto = ventasPrevisto;
		this.costesPrevisto = costesPrevisto;
		this.costeReal = costeReal;
		this.estado = estado;
		this.jefeProyecto = jefeProyecto;
		this.cliente = cliente;
	}

	// Generamos el metodo constructor sin parametros
	public Proyecto() {
		super();
	}

	// Generamos los getters and setters
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

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFinPrevisto() {
		return fechaFinPrevisto;
	}

	public void setFechaFinPrevisto(Date fechaFinPrevisto) {
		this.fechaFinPrevisto = fechaFinPrevisto;
	}

	public Date getFechaFinReal() {
		return fechaFinReal;
	}

	public void setFechaFinReal(Date fechaFinReal) {
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

	public double getCosteReal() {
		return costeReal;
	}

	public void setCosteReal(double costeReal) {
		this.costeReal = costeReal;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Empleado getJefeProyecto() {
		return jefeProyecto;
	}

	public void setJefeProyecto(Empleado jefeProyecto) {
		this.jefeProyecto = jefeProyecto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	// Generamos equals y hashcode, en los cuales definimos que dos proyectos son
	// iguales si tienen el mismo idProyecto
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

	// Metodos propios de proyectos

	// Definimos el metodo que calcula y retorna el margen de las ganancias.

	public double margenPrevisto() {
		Factura factura = new Factura();
		double importeVenta = 0;
		double margen = importeVenta - costesPrevisto;

		return margen;
	}

	public double margenReal() {
		Factura factura = new Factura();
		double importeVenta = 0;
		double mreal = importeVenta - costeReal;

		return mreal;
	}
  
}
