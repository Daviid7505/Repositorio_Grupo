package modelo.javabeans;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Proyecto {


	// Definimos los atributos para la clase Proyecto que se corresponden con los
	// que aparecen en la BBDD

	private String idProyecto;
	private String descripcion;
	private Date fechaInicio;
	private Date fechaFinPrevisto;
	private Date fechaFinReal;
	private double ventaPrevisto;
	private double costesPrevisto;
	private double costeReal;
	private String estado;
	private Empleado empleado;
	private Cliente cliente;
	
	//Con la ayuda de surce generamos:
	
	
	//El constructor vacio
	public Proyecto() {
		super();
	}
	
	//El constructor con todo
	public Proyecto(String idProyecto, String descripcion, Date fechaInicio, Date fechaFinPrevisto, Date fechaFinReal,
			double ventaPrevisto, double costesPrevisto, double costeReal, String estado, Empleado empleado,
			Cliente cliente) {
		super();
		this.idProyecto = idProyecto;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFinPrevisto = fechaFinPrevisto;
		this.fechaFinReal = fechaFinReal;
		this.ventaPrevisto = ventaPrevisto;
		this.costesPrevisto = costesPrevisto;
		this.costeReal = costeReal;
		this.estado = estado;
		this.empleado = empleado;
		this.cliente = cliente;
	}
	
	
	//Los gett and sett
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
	public double getVentaPrevisto() {
		return ventaPrevisto;
	}
	public void setVentaPrevisto(double ventaPrevisto) {
		this.ventaPrevisto = ventaPrevisto;
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
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	//Sobreescribimos con toSring
	@Override
	public String toString() {
		return "Proyecto [idProyecto=" + idProyecto + ", descripcion=" + descripcion + ", fechaInicio=" + fechaInicio
				+ ", fechaFinPrevisto=" + fechaFinPrevisto + ", fechaFinReal=" + fechaFinReal + ", ventaPrevisto="
				+ ventaPrevisto + ", costesPrevisto=" + costesPrevisto + ", costeReal=" + costeReal + ", estado="
				+ estado + ", empleado=" + empleado + ", cliente=" + cliente + "]";
	}
	
	//El hashcode y equals solo para el idProyecto
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


	// Metodos propios de la clase proyectos

	// Definimos el metodo que calcula y retorna el margen de las ganancias.

	public double margenPrevisto() {
		double mprev ;
		
               mprev =ventaPrevisto-costesPrevisto;
		return mprev;
	}

	public double margenReal() {
		Factura factura = new Factura();
		double mreal ;
		
	     mreal = ventaPrevisto - costeReal;

		return mreal;

	}

	@Override
	public String toString() {
		return "Proyecto [idProyecto=" + idProyecto + ", descripcion=" + descripcion + ", fechaInicio=" + fechaInicio
				+ ", fechaFinPrevisto=" + fechaFinPrevisto + ", fechaFinReal=" + fechaFinReal + ", ventasPrevisto="
				+ ventasPrevisto + ", costesPrevisto=" + costesPrevisto + ", costeReal=" + costeReal + ", estado="
				+ estado + ", jefeProyecto=" + jefeProyecto + ", cliente=" + cliente + "]";
	}
    public double diferenciGastos()   {
    	double gasto;
    	
        gasto = costeReal- costesPrevisto;
    	
    	return gasto;
    }
    
    
       //el metodo que da el numero de dia entre la fecha actual y el fin previsto del proyecto
        public int diferenciFinPrevisto()   {
    	
        	LocalDate fecha1 = fechaFinPrevisto.toLocalDate();
        	LocalDate fecha2 = fechaFinReal.toLocalDate();
    	    long DiferenciaDias = ChronoUnit.DAYS.between(fecha1 ,fecha2);
    	    int difdias = Long.valueOf(DiferenciaDias).intValue();
    	    return difdias;
       
	

    }

}	