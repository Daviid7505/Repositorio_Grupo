package junit5;

/**
 * Entidad Jugador con atributos dorsal, numeroTarjetasAmarillas y numeroTarjetasRojas.
 * @author Grupo 4
 */

public class Jugador {
	
	//Atributos de la clase jugador
	/**
	 * El atributo privado dorsal hace referencia al número estampado en la camiseta
	 * del jugador. El atributo entero numeroTarjetasAmarillas representa la cantidad de este 
	 * tipo de tarjetas que el jugador posee. Este valor oscila entre 0 y 2. El atributo entero 
	   numeroTarjetasRojas, representa la cantidad de tarjetas rojas que el jugador posee. Este 
	 *valor puede ser 0 o 1.
	 */
	private int dorsal;	
	private int numeroTarjetasAmarillas;
    private int numeroTarjetasRojas;
	
    
    //Método costructor por defecto de la clase Jugador
    @Override
	public String toString() {
		return "Jugador []";
	}

    //Métodos getter and setter
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
    
    //Métodos propios de la clase
	
	/**
	 * El método ponerDorsal() establece que los números de las dorsales deben estar
	 * comprendidos entre el 1 y el 30. En este caso, el valor de la dorsal será ogual al valor 
	 * pasado por parámetro. Para los números menores a uno y mayores a 30, el número de dorsal
	 * que asignará el método será -1.
	 * @param dorsal: representa el número pasado por parámetro para la dorsal.
	 */
	public void ponerDorsal(int dorsal) {

        if(dorsal >= 1 && dorsal <= 30) {
        	this.dorsal = dorsal;
        }
        else {
        	this.dorsal = -1;

        }
	}
	/**
	 * El método estaExpulsado devuelve "true" en el caso de que al jugador se le hayan
	 * asignado como parámetro dos tarjetas amarillas o una tarjeta roja, dado que, en este 
	 * caso el jugador ha sido expulsado. Si al jugador se le asiganaran ninguna o solo una 
	 * tarjeta amarilla y ninguna tarjeta roja el método retornará false.
	 * @return: el método retorna false para el caso en que el número de tarjetas amarillas 
	 * pasadas por parámetro sea 0 o 1. Si el el número de tarjetas rojas es igual a 1 o el número 
	 * de tarjetas amarillas es 2, devolverá true.
	 */
	public boolean estaExpulsado() {

        boolean expulsado = false;                                                  

        if(numeroTarjetasAmarillas == 2) {

            expulsado = true;
        }                          
        if(numeroTarjetasRojas == 2) {
        	expulsado = true;
        }                          
        return expulsado;
	}            
    

    
    
}
