package junit5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SoldadoTest {

	Soldado soldado = new Soldado();
	
	@BeforeEach
	void setUp() throws Exception{
		Soldado soldado = new Soldado();
	}
	
	@AfterEach
	void taerDown() throws Exception{
		soldado = null; 
	}
	
	/**
	 * En esta prueba unitaria probamos el método puedeDisparar(). Realizamos tres pruebas 
	 * con valores: positivo, cero y negativo. 
	 */
	@Test
	void testPuedeDisparar() {
	soldado.setNumeroBalas(5);
	
	boolean resultadoEsperado1 = true;
	boolean resultadoObtenido1 = soldado.puedeDisparar();
	
	assertEquals(resultadoEsperado1, resultadoObtenido1);
	
	soldado.setNumeroBalas(0);
	boolean resultadoEsperado2 = false;
	boolean resultadoObtenido2 = soldado.puedeDisparar();
	
	assertEquals(resultadoEsperado2, resultadoObtenido2);
	
	soldado.setNumeroBalas(-8);
	boolean resultadoEsperado3 = false;
	boolean resultadoObtenido3 = soldado.puedeDisparar();
	
	assertEquals(resultadoEsperado3, resultadoObtenido3);
	}
	
	/**
	 * Probamos el método puedeDisparar(). Realizamos tres pruebas con 
	 * valores: positivo, cero y negativo. 
	 */
	
	//En la primera prueba, el soldado tiene tres balas y puede disparar
	@Test
	void testDisparar() {
	soldado.setNumeroBalas(3);
	soldado.setEstaMuerto(false);
	
	soldado.disparar(soldado);

	assertEquals(2, soldado.getNumeroBalas()); 
	
	//En la segunda prueba, el soldado no tiene balas
	soldado.setNumeroBalas(0);
	soldado.setEstaMuerto(true);
	
	soldado.disparar(soldado);
	
	assertTrue(soldado.isEstaMuerto());
	

	}
}
