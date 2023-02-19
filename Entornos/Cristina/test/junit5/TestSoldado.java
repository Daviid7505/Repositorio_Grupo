package junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Clases.Soldado;




	/** Esta es la clase donde se van a ejecutar los metodo de la clase soldado
	 *Los metodos que se van ha verificar son el puedeDisparar() y el disparar()
	 */

	class TestSoldado {
		Soldado soldado  = new Soldado();
	 
	 @BeforeEach
	 void setUp() throws Exception{
	  Soldado soldado = new Soldado();
		}
		@AfterEach
		void taerDown() throws Exception{
			soldado = null; 
		}  
		
		/**
		 * Hacemos el test para el metodo puedeDisparar
		 * En la primera prueba se le asigna un numero positivo mayor que zero 
		 *
		 * En la segunda prueba se le asigna 0
		 * 
		 *En la tercera prueba se le asigna un valor negativo 
		 */
		 @Test
		public void testPuedeDisparar(){
		  Soldado soldado = new  Soldado();
		     soldado.setNumeroBalas(3);
		      int resultadoEsperado = 3;
				int resultado = soldado.getNumeroBalas();
				
				assertTrue(soldado.puedeDisparar());
			}
		
	    @Test
		public void testPuedeDispararNoTieneBalas(){
		 Soldado soldado = new  Soldado();
	    soldado.setNumeroBalas(0);
	     int resultadoEsperado = 0;
	     int resultado = soldado.getNumeroBalas();
			
		assertFalse(soldado.puedeDisparar());
		}
	 
	    @Test
	   	public void testPuedeDispararNoTieneBalas2(){
	   	 Soldado soldado = new  Soldado();
	     soldado.setNumeroBalas(-3);
	     int resultadoEsperado = -3;
	     int resultado = soldado.getNumeroBalas();
	   		
	   	assertFalse(soldado.puedeDisparar());
	   	}
	    
	    
	    /**
	     * El test para el metodo disparar
	     * primera prueba el sodado tiene un numero positivo mayor que 0
	     * En la segunda prueba le asignamos 0 para el numero de balas
	     */
	    
	    @Test
	    void disparar()  {
	     Soldado sol1 = new Soldado();
	     Soldado sol2 = new Soldado();
	    	 
	    	 sol1.setNumeroBalas(5);
	    	 sol2.setEstaMuerto(false);
	         sol1.setEstaMuerto(false);
	         sol1.disparar(sol2);
	     assertTrue(sol2.isEstaMuerto());
	    	  
	    }
	    
	    @Test
	    void disparar1()  {
	     Soldado sol1 = new Soldado();
	     Soldado sol2 = new Soldado();
	    	 
	    	 sol1.setNumeroBalas(0);
	    	 sol2.setEstaMuerto(true);
	         sol1.setEstaMuerto(true);
	         sol1.disparar(sol2);
	     assertTrue(sol2.isEstaMuerto());
	    	  
	    }
} 
