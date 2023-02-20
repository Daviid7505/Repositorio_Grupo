package junit5;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javabeans.Soldado;

class TestSoldado {
	


	
		Soldado s1 = new Soldado();
		
		Soldado s2 = new Soldado();
		

	
   /**
    * Este método nos dice si el soldado puede disparar o no dependiendo de las balas que tenga
    * 
    * @return Devuelve verdadero en caso de que el soldado tenga más de 1 bala y falso en cualquier otro caso
    */
    @Test
    public void testdisparar() {
    	
    	//Hacemos una prueba con un número de balas positivo
	    	s1.setNumeroBalas(5);
	    	
	    	boolean Resultado=s1.puedeDisparar();
	    	boolean Esperado = true;
	    	
	    	assertEquals(Esperado, Resultado);
    }
    	
	@Test
	public void testdisparar2() {
    	//Hacemos una prueba con un número de balas igual a 0
	    	s1.setNumeroBalas(0);
	    	
	    	boolean Resultado2 = s1.puedeDisparar();
	    	boolean Esperado2 = false;
	    	
	    	assertEquals(Esperado2, Resultado2);
	 }
	 @Test
	 public void testdisparar3() {
    	//Hacemos una prueba con un número de balas negativo (esto no tiene mucho sentido
    	//pero si suponemos que el usuario mete un número negativo también hay que testearlo)
    	
	    	s1.setNumeroBalas(-1);
	    	
	    	boolean Resultado3 = s1.puedeDisparar();
	    	boolean Esperado3 = false;
	    	
	    	assertEquals(Esperado3, Resultado3);
    	
    }


	/**
    * Este método recibe 1 soldado y descuenta 1 bala del soldado que dispara, finalmente el soldado que pasamos por parámetro 
    * nos va a devolver que está muerto
    * 
    * @param sol es el soldado que recie el disparo, después de recibir el soldado nos asigna true a la variable estaMuerto
    */

   
   @Test
    public void testpuededisparar1() {
	   		
	   		//Prueba1
	   		//Probamos a que nuestros soldado2 dispare a nuestro soldado1, ambos con una cantidad de balas superior a 0
		   		s1.setNumeroBalas(5);
		   		s2.setNumeroBalas(3);
		   		//invocamos el método disparar
		   		s2.disparar(s1);
		   		
		   		//Pasamos la variable estamuerto del soldado 1 que es el que recibe el disparo a una variable Resultado
		   		boolean Resultado = s1.isEstaMuerto();
		   		//Creamos nuestro resultado esperado
		   		boolean Esperado = true;
		   		
		   		//Vamos a crear las variables para comparar el número de balas del soldado que hace el disparo
		   		//En este caso dispara nuestro s2
		   		int Resultadobalas = s2.getNumeroBalas();
		   		int Esperadobalas = 2;
		   		
		   		
		   		assertEquals(Esperado, Resultado);
   	            assertTrue(Resultadobalas == (Esperadobalas));
   	            
   }
   @Test
   public void testpuededisparar2() {
	   		//Prueba2
	   		//Ahora vamos a probar si nuestro soldado s2 tiene un valor inicial de 0 balas, si puede disparar y matar al otro soldado
	   		
		   		s1.setNumeroBalas(5);
		   		s2.setNumeroBalas(1);
		   		
		   		s2.disparar(s1);
		   		
		   		boolean Resultado2 = s1.isEstaMuerto();
		   		boolean Esperado2 = true;
		   		
		   		int Resultadobalas2 = s2.getNumeroBalas();
		   		int Esperadobalas2 = 0;
   
		   	  assertTrue(Resultadobalas2 == (Esperadobalas2));
 	          assertEquals(Esperado2, Resultado2);
   }
   @Test
   public void testpuededisparar3() {
	   		//Prueba3
	   		//Vamos a ver que ocurre si nuestro soldado 2 no tiene balas y hace un disparo al soldado1
	   		
		   		s1.setNumeroBalas(2);
		   		s2.setNumeroBalas(0);
		   		
		   		
		   		s2.disparar(s1);
		   		
		   		boolean Resultado3 = s1.isEstaMuerto();
		   		boolean Esperado3 = false;
		   		
		   		int Resultadobalas3 = s2.getNumeroBalas();
		   		int Esperadobalas3 = 0;
		   		assertTrue(Resultadobalas3 == (Esperadobalas3));
   	    		assertEquals(Esperado3, Resultado3); 
   }
	   	
	   		
	   		
    }

	


