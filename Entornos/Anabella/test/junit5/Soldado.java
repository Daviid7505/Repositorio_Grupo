	/**
	* Entidad Soldado con atributos estaMuerto y numeroBalas.
	* @author Grupo 4
	*/

package junit5;

public class Soldado {

	/**
	 * Condición de vida del soldado. La condición de boolean se completa con 
	 * true si el soldado está muerto y con false, si el soldado está con vida.
	 */
	private boolean estaMuerto;
	
	/**
	 * Número de balas que el soldado tiene en su poder. Este es un dato num�rico de 
	 * tipo entero aunque solo cobra sentido si se completa con un número entero positivo 
	 * o con cero.
	 */
	private int numeroBalas;
	
	//Método constructor por defecto.
	public Soldado() {
		super();
	}

	/**
	 * Método constructor con parámetros.
	 * @param estaMuerto: representa la condiciòn de vida del soldado
	 * @param numeroBalas: representa la cantidad de balas que el soldado tiene 
	 * en su poder y son factibles de ser disparadas. 
	 */
	public Soldado(boolean estaMuerto, int numeroBalas) {
		super();
		this.estaMuerto = estaMuerto;
		this.numeroBalas = numeroBalas;
	}
	
	//Métodos Getter and setter
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

	
	//Métodos propios de la clase
	
	/**
	 * El método puedeDisparar establece si el soldado puede disparar o no puede hacerlo, 
	 * conforme a la cantidad de balas pasadas por parámetro. Es decir, si la cantidad de 
	 * balas es un número entero positivo, el método devolverá "true" mientras que, si el número 
	 * de balas es cero, el método arrojará como resultado "false". 
	 * @return retorna "true" si la cantidad de balas pasadas por parámeto es mayor a cero
	 * y retorna "false" si el número de balas es cero o menor a cero.
	 */
	public boolean puedeDisparar() {
		if (this.numeroBalas >0) {
		return true;
		}
		else return false;
	}
		
	/**
	 * Método que reduce la cantidad de balas introducidas por parámetro, de una en una. 
	 * Cuando el conteo de balas sea igual a cero, la condición de vida del soldado cambiará.
	 * Por lo tanto, el parámetro estaMuerto que en un principio se le asignara false
	 * variará a true. Por ejemplo, si se tiene como parámetros Soldado(false, 1), esto 
	 * significa que el soldado está con vida y tiene una bala para disparar. Al ejecutar el 
	 * método disparar, se reducirá la catidad de balas en una, por lo cual el soldado ahora
	 * tendrá cero balas. En consecuencia, la condición de vida cambiará, arrojando un 
	 * resultado booleano del parámetro estMuerto igual a true.
	 * @param sol
	 */
	public void disparar (Soldado sol) {
		
		this.numeroBalas--;
		sol.estaMuerto = true;
	}


	@Override
	//Sobreescritura del método toString.
	/**
	 * La sobreescritura de este m�todo permite obtener información más significativa sobre
	 * el objeto. 
	 */
	public String toString() {
		return "Soldado [estaMuerto=" + estaMuerto + ", numeroBalas=" + numeroBalas + "]";
	}
	

}
