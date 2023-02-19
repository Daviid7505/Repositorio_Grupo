package javabean_Alberto;

/**
 * 
 * Clase que define el estado de un objeto Jugador en base a su dorsal y al
 * numero de tarjetas amarillas y rojas que puede tener.
 * 
 * @author Alberto Saboya
 * @version 1.0
 *
 */

public class Jugador {

	/**
	 * 
	 * El atributo dorsal nos informa del dorsal que tiene el objeto Jugador.
	 * 
	 * El atributo numeroTarjetasAmarillas nos informa del numero de tarjetas
	 * amarillas que tiene el objeto Jugador.
	 * 
	 * El atributo numeroTarjetasRojas nos informa del numero de tarjetas rojas que
	 * tiene el objeto Jugador.
	 * 
	 * @author Alberto Saboya
	 *
	 */

	private int dorsal;

	private int numeroTarjetasAmarillas;

	private int numeroTarjetasRojas;

	/**
	 * Metodo constructor para crear objetos Jugador sin parametros de entrada
	 * 
	 * @author Alberto Saboya
	 */

	public Jugador() {
		super();
	}

	/**
	 * Metodo constructor para crear objetos Jugador con sus parametros de entrada
	 * dorsal, numeroTarjetasAmarillas y numeroTarjetasRojass que se corresponden
	 * con los atributos de instancia.
	 * 
	 * @author Alberto Saboya
	 * @param dorsal                  indica el dorsal del objeto Jugador
	 * @param numeroTarjetasAmarillas se corresponde con el numero de tarjetas
	 *                                amarillas que tiene el objeto Jugador.
	 * @param numeroTarjetasRojas     se corresponde con el numero de tarjetas rojas
	 *                                que tiene el objeto Jugador.
	 */

	public Jugador(int dorsal, int numeroTarjetasAmarillas, int numeroTarjetasRojas) {
		super();
		this.dorsal = dorsal;
		this.numeroTarjetasAmarillas = numeroTarjetasAmarillas;
		this.numeroTarjetasRojas = numeroTarjetasRojas;
	}

	// Metodos getter and setter no se documentan a no ser que se modifique su
	// su funcionalidad. En este caso no se modifica y por ese motivo no se
	// documentan

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
	 * Metodo ponerDorsal que sirve para asignar un dorsal al objeto Jugador. Si el
	 * dorsal asignado por parametro de entrada esta comprendido entre 1 y 30, se le
	 * asignara el dorsal correspondiente al del parametro de entrada. Si el dorsal
	 * asignado toma cualquier otro valor no comprendido entre 1 y 30 se le asignara
	 * el valor -1, por ejemplo, si recibe el valor 57, el dorsal sera -1.
	 * 
	 * @author Alberto Saboya
	 * @param dorsal indica el valor del dorsal para asignar al atributo dorsal del
	 *               objeto Jugador.
	 * 
	 */

	public void ponerDorsal(int dorsal) {
		if (dorsal >= 1 && dorsal <= 30) {
			this.dorsal = dorsal;
		} else {
			this.dorsal = -1;
		}
	}

	/**
	 * Metodo estaExpulsado sirve para saber si el objeto Jugasor esta expulsado o
	 * no. Estara expulsado si numeroTarjetasAmarillas es igual a 2 o si el
	 * numeroTarjetasRojas es igual a 1. Si el valor de numeroTarjetasAmarillas es
	 * diferente de 2 o si el numeroTarjetasRojas es diferente de 1, el objeto
	 * Jugador no esta expulsado.
	 * 
	 * @author Alberto Saboya
	 * @return true si el objeto Jugador esta expulsado o false si el objeto Jugador
	 *         no esta expulsado.
	 * 
	 */

	public boolean estaExpulsado() {
		boolean expulsado = false;
		if (numeroTarjetasAmarillas == 2) {
			expulsado = true;
		}
		if (numeroTarjetasRojas == 1) {
			expulsado = true;
		}
		return expulsado;
	}
}
