package Clases;

public class Soldado {
	

		/**
		 * Clase que representa un soldado.
		 *  Tiene dos atributos privado, estaMuerto,numeroBalas.
		 * 
		 * @author  Grupo 04
		 * @version 1.0
		 *
		 */

		/**
		 * Atrubuto que nos idica el estado de vida del soldado
		 */
		private boolean estaMuerto;
		/**
		 * Atributo que nos indican el numero de balas que pueda tener el soldado
		 */
		private int numeroBalas;
		
		
		
		//Gett y Sett
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
		 * Metodo que nos indica si el soldado puede disparar 
		 * en base al numero de bala que se le asigna 
		 * @returnEl metodo returna true  en el caso de que
		 *  el numero de balas del soldado es mayor que 0
		 *  y  returna false en el caso de que el numero de balas es negativo 
		 */
		
		public boolean puedeDisparar() {
			if(this.numeroBalas >0)  {
				return true;
			}
			return false;
			}
		
		
		/**
		 * metodo que indica que en cuanto la cantidad de balas decrementa
		 *  es decir el soldado efectua disparos ,otro soldado muere
		 * @param sol soldadodo que crearemos para que reciba disparos
		 */
		public void disparar(Soldado sol)  {
			this.numeroBalas --;
			sol.estaMuerto= true;
		}
	}	
		







