package javabeans;


/**
 * 
 * @author David
 * 
 * Esta clase consiste en un jugador el cual tiene 2 métodos
 * 
 * El primer método (ponerDorsal) nos permite modificar el dorsal de nuestro jugador
 * 
 * El segundo método (estaExpulsado) Nos permite saber si nuestro jugador está expulsado
 * en función del número de tarjetas que le han sacado
 *
 */
public class Jugador {

    private int dorsal;

    private int numeroTarjetasAmarillas;

    private int numeroTarjetasRojas;

                 


/**
 * El método nos permite modificar el dorsal de nuestro jugador
 * 
 * @param dorsal | Es el número de dorsal que nosotros queremos poner a nuestro jugador
 * En caso de ser inferior a 1 o superior a 30 nos asignará el dorsal -1
 */

    public void ponerDorsal(int dorsal) {

                  if(dorsal >= 1 && dorsal <= 30) {

                                this.dorsal = dorsal;

                  }else {

                                this.dorsal = -1;

                  }

    }

   /**
    * Este método nos permite saber si nuestro jugador está expulsado
    * en función del número de tarjetas que le han sacado
    * 
    * @return Nos devuelve verdadero en caso de que el jugador sea expulsado por tener 2 tarjetas amarillas o 1 tarjeta roja, 
    * en otro caso cualquiera nos devuelve falso
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


//Getter and Setters
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
    
    
    

}