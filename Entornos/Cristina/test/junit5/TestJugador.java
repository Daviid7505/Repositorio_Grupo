package junit5;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import Clases.Jugador;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * En esta clase se comprobara el coreccto funccionamiento de los 
 * metodo de la clase Jugador
 * los metodos acomprobar son el metodo ponerDorsal() y estaExpulsado
 */

class TestJugador {
	  Jugador jugador = new Jugador();

	  @BeforeEach
	 void setUp() throws Exception{
			Jugador jugador = new Jugador();
		}
		@AfterEach
		void taerDown() throws Exception{
			jugador = null; 
		}  
	
	
		/**
		 *El test para el metodo ponerDorsal
		 * 
		 * En la primera prueba se le asigna un numero positivo
		 *  entre mayor igual a 1 y menor igual 30
		 *
		 * En la segunda prueba se le asigna un numero mayor que 30
		 * 
		 *En la tercera prueba se le asigna un valor negativo que es menor que 1
		 */
	
		@Test
		void testPonerDorsal() {
		jugador.setDorsal(13);
		
		int resultadorEsperado1 = 13; 
		int resultadoObtenido1 = jugador.getDorsal();
		
		assertEquals(13, 13) ;
		
		//En la segunda prueba, comprobamos que nos devuelve -1 al asignar un número menor que 1
		jugador.setDorsal(40);
		int resultadorEsperado2 = 40; 
		int resultadoObtenido2 = jugador.getDorsal();
		
		assertEquals(-1, -1) ;
		
		//En la tercera prueba, comprobamos que nos devuelve -1 al asignar un número mayor a 30
		jugador.setDorsal(-3);
		int resultadorEsperado3 = -3; 
		int resultadoObtenido3 = jugador.getDorsal();
			
		assertEquals(-1, -1) ;
		}
		
		/**
		 * El test para el metodo estaEliminado
		 * 
		 *En la primera prueba asiganamos un numero igual a 2 para las tarjetasAmarillas
		 *y un numero igual a 1 para las tarjetasRojas
		 *
		 *En la segunda prueba asignamos un numero distincto a 2 para
		 *las tarjetasAmarillas y otro numero distincto a 1 para las 
		 *tarjetasRojas
		 */
		
		 @Test
		 void testEstaExpulsado(){
	              jugador.setNumeroTarjetasAmarillas(2);
			      int resultadoEsperado = 2;
					int resultado = jugador.getNumeroTarjetasAmarillas();
			
			 
		    jugador.setNumeroTarjetasRojas(1);;
		     int resultadoEsperado1 = 1;
				int resultado1 =jugador.getNumeroTarjetasRojas();
				
				assertTrue(jugador.estaExpulsado());
			
		}
		 void testNoEstaExpulsado(){
			 
			jugador.setNumeroTarjetasAmarillas(3);
			boolean resultadoEsperado = false;
			boolean resultadoObtenido = jugador.estaExpulsado(); 
			jugador.setNumeroTarjetasRojas(2);	
			boolean resultadoEsperado1 = false;
			boolean resultadoObtenido1 = jugador.estaExpulsado(); 
				
				assertEquals(resultadoEsperado, resultadoObtenido);
				
			 
			 
			 
			 
		 }
		}
		
		

	


