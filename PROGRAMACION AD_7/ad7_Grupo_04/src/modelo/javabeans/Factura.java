package modelo.javabeans;

import java.util.Objects;

public class Factura {
	
	//Definimos los atributos para la clase Factura que se corresponden con los
	//definidos en la BBDD
	
	private String idFactura;
	private String descripcion;
	private Proyecto proyecto;
	
	//Generamos el método constructor con todos los parámetros
	
	public Factura(String idFactura, String descripcion,Proyecto proyecto) {
		super();
		this.idFactura = idFactura;
		this.descripcion = descripcion;
		this.proyecto = proyecto;
	}

	
	//Generamos el método constructor sin parámetros
	public Factura() {
		super();
	}
	
	//Generamos los getters and setters
	public String getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(String idFactura) {
		this.idFactura = idFactura;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
		}
	
	//Generamos equals y hashcode, en los cuales definimos que dos facturas son iguales si
	//tienen el mismo idFactura
	@Override
	public int hashCode() {
		return Objects.hash(idFactura);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Factura other = (Factura) obj;
		return Objects.equals(idFactura, other.idFactura);
	}
	
	
	
	
	

}
