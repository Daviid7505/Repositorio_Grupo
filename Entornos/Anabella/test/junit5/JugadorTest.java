package junit5;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JugadorTest {
	
	Jugador jugador = new Jugador(); 
	
	@BeforeEach
	void setUp() throws Exception{
		Jugador jugador = new Jugador();
	}
	
	@AfterEach
	void taerDown() throws Exception{
		jugador = null; 
	}
	
	//En la primera prueba comprobamos que los números que admiten las dorsales están comprendidos
	//entre 1 y 30.
	@Test
	void testPonerDorsal() {
	jugador.setDorsal(7);
	
	int resultadorEsperado1 = 7; 
	int resultadoObtenido1 = jugador.getDorsal();
	
	assertEquals(7, 7) ;
	
	//En la segunda prueba, comprobamos que nos devuelve -1 al asignar un número menor que 1
	jugador.setDorsal(-11);
	int resultadorEsperado2 = -1; 
	int resultadoObtenido2 = jugador.getDorsal();
	
	assertEquals(-1, -1) ;
	
	//En la tercera prueba, comprobamos que nos devuelve -1 al asignar un número mayor a 30
	jugador.setDorsal(87);
	int resultadorEsperado3 = -1; 
	int resultadoObtenido3 = jugador.getDorsal();
		
	assertEquals(-1, -1) ;
	}
	
	//En esta prueba unitaria, testeamos el método estaExpulsado()
	//En la primera prueba unitaria ingresamos como parámetro 1 para tarjetas amarillas 
	@Test
	void testEstaExpulsado() {
	jugador.setNumeroTarjetasAmarillas(1);
		
	boolean resultadoEsperado = false;
	boolean resultadoObtenido = jugador.estaExpulsado(); 
	
	assertEquals(resultadoEsperado, resultadoObtenido);
	
	
	//En la segunda prueba unitaria ingresamos como parámetro 2 para tarjetas amarillas
	
	Jugador jugador1 = new Jugador();
	jugador1.setNumeroTarjetasAmarillas(2);
			
	assertFalse(jugador.estaExpulsado());
	
	
	//En la tercera prueba unitaria ingresamos como parámetro 1 para tarjetas rojas.
	
	Jugador jugador2 = new Jugador();
	jugador2.setNumeroTarjetasRojas(1);
		
	assertFalse(jugador2.estaExpulsado());
		
	}

}
