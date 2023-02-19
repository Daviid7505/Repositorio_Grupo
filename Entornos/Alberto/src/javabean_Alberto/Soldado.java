package javabean_Alberto;

/**
 * 
 * Clase que define el estado de un objeto Soldado en base a si esta muerto y al
 * numero de balas que le quedan
 * 
 * @author Alberto Saboya
 * @version 1.0
 *
 */

public class Soldado {

	/**
	 * 
	 * El atributo estaMuerto nos informa si el soldado esta muerto (true) o si esta
	 * vivo (false)
	 * 
	 * El atributo numeroBalas nos indica el numero de balas que le quedan al
	 * soldado. Los valores que puede tomar son numeros enteros positivos o
	 * negativos.
	 * 
	 * @author Alberto Saboya
	 *
	 */

	private boolean estaMuerto;

	private int numeroBalas;

	/**
	 * Metodo constructor para crear objetos Soldado con sus parametros de entrada
	 * estaMuerto y numeroBalas que se corresponden con los atributos de instancia.
	 * 
	 * @author Alberto Saboya
	 * @param estaMuerto  indica si el soldado esta muerto (true) o vivo (false)
	 * @param numeroBalas representa el numero de balas que le quedan al soldado
	 */

	public Soldado(boolean estaMuerto, int numeroBalas) {
		super();
		this.estaMuerto = estaMuerto;
		this.numeroBalas = numeroBalas;
	}

	/**
	 * Metodo constructor para crear objetos Soldado sin parametros de entrada
	 * 
	 * @author Alberto Saboya
	 */

	public Soldado() {
	}

	// Metodos getter and setter no se documentan a no ser que se modifique su
	// su funcionalidad. En este caso no se modifica y por ese motivo no se
	// documentan

	public boolean isEstaMuerto() {
		return estaMuerto;
	}

	public void setEstaMuerto(boolean estaMuerto) {
		this.estaMuerto = estaMuerto;
	}

	public int getNumeroBalas() {
		return numeroBalas;
	}

	public void setNumeroBalas(int numeroBalas) {
		this.numeroBalas = numeroBalas;
	}

	/**
	 * Metodo puedeDisparar que sirve para saber si el objeto Soldado al que le
	 * aplicamos el metodo puede disparar. El que pueda disparar o no dependera del
	 * numero de balas que tenga en el momento que se ejecuta el metodo. Si el
	 * numero de balas es mayor de cero, el objeto Soldado al que se le aplica el
	 * metodo puede disparar y si el numero de balas es cero o menor de cero, el
	 * objeto Solado al que se le aplica el metodo no puede disparar.
	 * 
	 * @author Alberto Saboya
	 * @return true si el atributo numeroBalas es mayor de cero y false si el
	 *         atributo numeroBalas es menor o igual a cero.
	 * 
	 */

	public boolean puedeDisparar() {
		if (this.numeroBalas > 0) {
			return true;
		}
		return false;
	}

	/**
	 * Metodo disparar sirve para disparar a al objeto Soldado que se le pase por
	 * parametro. Cada vez que se ejecuta este metodo, el numero de balas disminuye
	 * una unidad. Por otro lado el objeto Soldado que recibe el disparo cambia el
	 * estado del atributo estaMuerto a true.
	 * 
	 * @author Alberto Saboya
	 * @param sol indica indica el objeto Soldado al que se le va a disparar
	 */

	public void disparar(Soldado sol) {
		this.numeroBalas--;
		sol.estaMuerto = true;
	}

}
