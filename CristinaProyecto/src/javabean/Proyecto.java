package javabean;

import java.sql.Date;

public class Proyecto {
	//Loa atributos de la clase
	private String idProyecto;
	private String descripcion;
	private Date fechaInicio;
	private Date fechaFinPrevisto;
	private Date fechaFinReal;
	private double ventaPrevista;
	private double costePrevisto;
	private double costeReal;
	private String estado;
	private int jefeProyecto;
	private String cif; 
	private Cliente cliente;
	private Empleado empleado;
	
    //El constructor vacio
	
	//El constructor con todo 
	
	
	//Los gett y sett
	
	
	//el toString 
	
	
	//el hashcode y equals 
	
	//metos propios de la clase
	
	 public void margenPrevisto (double importe) {
	 //Importe de venta – coste previsto
		 ventaPrevista -= costePrevisto;
	 }
	 
	public void margenReal(double cantidad) {
		//Importe de venta – gastos reales
		ventaPrevista -=costeReal;
	}
			
	public void diferenciaGastos( double gasto) {
	//Gasto real – gasto previsto
		costeReal-=costePrevisto;
	}
	
	public void diferenciaFinPrevistoReal( int dias)  {
	//Días entre fin previsto y fin real
		//fechaFinPrevisto  fechaFinReal; DUDAS
		
	}
	 
}
