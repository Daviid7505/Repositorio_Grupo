package javabeans;
/**
 * 
 * @author David
 *
 *Esta clase consiste tiene 2 metodos
 *
 *En nuestro primer metodo nos devolvera un resultado true o false en funcion de si tenemos mas de 0 balas o no
 *
 *En el segundo metodo pasamos por parametro un soldado nos va a descontar 1 bala y el soldado que hemos pasado
 *por parametro va a morir y el soldado que llama al metodo termina con 1 bala menos
 *
 */
public class Soldado {

    private boolean estaMuerto;

    private int numeroBalas;


   /**
    * Este método nos dice si el soldado puede disparar o no dependiendo de las balas que tenga
    * 
    * @return Devuelve verdadero en caso de que el soldado tenga más de 1 bala y falso en cualquier otro caso
    */

    public boolean puedeDisparar() {

                  if(this.numeroBalas > 0) {

                                return true;

                  }                          

                  return false;

    }

   /**
    * Este método recibe 1 soldado y descuenta 1 bala del soldado que dispara, finalmente el soldado que pasamos por parámetro 
    * nos va a devolver que está muerto
    * 
    * @param sol es el soldado que recie el disparo, después de recibir el soldado nos asigna true a la variable estaMuerto
    */

    public void disparar(Soldado sol) {

    				if (this.numeroBalas > 0) {
		                  this.numeroBalas--;
		
		                  sol.estaMuerto = true;
    				}
		            else 
		            	sol.estaMuerto = false;
           
    }


    //Getter and Setters
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

    
    
    
}