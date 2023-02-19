package Clases;
/**
 * Clase que representa un jugador de futbol.
 *  Tiene tres atributos, dorsal,numeroTaretasAmarillas y numeroTargetasRojas.
 * 
 * @author Grupo 4
 * @version 1.0
 *
 */
public class Jugador {

	/**
	
	 * El atributo int dorsal es el número que se usa para identificar al jugador 
	 * y indicar su posicion 
	 */
	private int dorsal;
	
	/**El atributo int numeroTarjetasAmarillas indica el numero de  tarjetas amarillas
	 * que puede tener el jugador
	 */
	private int numeroTarjetasAmarillas;
	
	/**El atributo int numeroTarjetasRojas indica el numero
	 *  de tarjetas amarillas que puede tener el jugador
	 */
	private int numeroTarjetasRojas;
	
	
	
	//Gett y Sett
	
	public int getDorsal() {
		return dorsal;
	}


	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}


	public int getNumeroTarjetasAmarillas() {
		return numeroTarjetasAmarillas;
	}


	public void setNumeroTarjetasAmarillas(int numeroTarjetasAmarillas) {
		this.numeroTarjetasAmarillas = numeroTarjetasAmarillas;
	}


	public int getNumeroTarjetasRojas() {
		return numeroTarjetasRojas;
	}


	public void setNumeroTarjetasRojas(int numeroTarjetasRojas) {
		this.numeroTarjetasRojas = numeroTarjetasRojas;
	}
	
	
	/**
	 * Metodo que establece el numero que se le asignara al jugado
	 * Deben ser numeros comprendidos entre 1 y 30
	 * En el caso que el numero asignado sea un numero diferente 
	 * se le asignara el numero -1
	 * 
	 * @param int dorsal representa el numero que se le va establecer al jugador
	 */

	public void ponerDorsal (int dorsal)  {
		if(dorsal>=1 && dorsal<=30)  {
			this.dorsal= dorsal;
		}
		else   {
			this.dorsal= -1;
		}
	}


	
	 /**Metodo que devuelve si el judador esta expulsado en  base
	 * al numero de tarjetas amarillas o rojas que se le asignara
	 * 
	 * @return El metodo returna expulsado en el caso de que
	 *  el numero de tarjetas amarillas del jugador es igual a 2
	 *  Tambien returna expulsado en el caso de que el numero de taretas rojas es igual a 1
	 *  En el caso de que el numero de las tarjetas amarillas sean diferente a 2
	 *  y el numero de targetas rojas sea diferente a 1 el rezultado va ser false 
	 */
	
	public boolean estaExpulsado() {

        boolean expulsado = false;                                                  

        if(numeroTarjetasAmarillas == 2) {

            expulsado = true;
        }                          
        if(numeroTarjetasRojas == 1) {
        	expulsado = true;
        }                          
        return expulsado;
}
}
