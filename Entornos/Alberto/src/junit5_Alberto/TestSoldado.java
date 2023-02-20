package junit5_Alberto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javabean_Alberto.Soldado;

class TestSoldado {

	private Soldado sol1;
	private Soldado sol2;

	@BeforeEach
	void setUp() throws Exception {
		// Me interesa antes de cada test tener dos objeto soldado
		// limpios (nuevos)
		sol1 = new Soldado();
		sol2 = new Soldado();
		// configuramos todo lo que queramos antes de cada @Test
	}

	@AfterEach
	void tearDown() throws Exception {
		// Después de cada test elimino los dos objeto soldado
		sol1 = null;
		sol2 = null;
	}

	/**
	 * En esta prueba unitaria, vamos a probar el metodo "puedeDisparar", en los dos
	 * casos que se nos pueden dar: numeroBalas > 0 o numeroBalas <= 0 por lo que se
	 * van a realizar dos pruebas.
	 */

	@Test
	public void testPuedeDispararMayorCeroBalas() {
		sol1.setNumeroBalas(5);

		assertTrue(sol1.puedeDisparar());
	}
	// Cuando el numero de balas es positivo el objeto Soldado puede disparar.

	@Test
	public void testPuedeDispararMenorOIgualCeroBalas() {
		sol1.setNumeroBalas(0);

		assertFalse(sol1.puedeDisparar());
	}
	// Cuando el numero de balas es cero o negativo el objeto soldado no puede
	// disparar.

	/**
	 * En esta prueba unitaria vamos a probar el metodo "disparar" que como afecta a
	 * los atributos numeroBalas y estaMuerto, los vamos a probar por separado.
	 */

	/**
	 * Primero probamos que numeroBalas disminuye una unidad cada vez que se dispara
	 * independientemente del valor inicial de numeroBalas. Vamos a hacer dos
	 * pruebas con numeroBalas positivo y otra con numeroBalas igual a cero o
	 * negativo.
	 */

	@Test
	public void testDispararNumeroBalasPositivo() {
		sol1.setNumeroBalas(3);
		sol1.disparar(sol2);

		int resultadoEsperadoNumeroBalas = 2;
		int resultadoObtenidoNumeroBalas = sol1.getNumeroBalas();

		assertEquals(resultadoEsperadoNumeroBalas, resultadoObtenidoNumeroBalas);
		assertTrue(sol1.puedeDisparar());
	}
	// NumeroBalas disminuye una unidad al disparar. Cuando numeroBalas es positivo
	// despues de ejecutar el metod disparar el objeto Soldado puede seguir
	// disparando.

	@Test
	public void testDispararNumeroBalasCeroONegativo() {
		sol1.setNumeroBalas(0);
		sol1.disparar(sol2);

		int resultadoEsperadoNumeroBalas = -1;
		int resultadoObtenidoNumeroBalas = sol1.getNumeroBalas();

		assertEquals(resultadoEsperadoNumeroBalas, resultadoObtenidoNumeroBalas);
		assertFalse(sol1.puedeDisparar());
	}
	// NumeroBalas disminuye una unidad al disparar. Cuando numeroBalas es negativo
	// o cero el objeto Soldado no puede ejecutar el metodo disparar.

	/**
	 * Finalmente vamos a probar que cuando se ejecuta el metodo disparar, el objeto
	 * que recibe el disparo, el atributo estaMuerto cambia de estado a true.
	 */

	@Test
	public void testSoldado1DisparaAlSoldado2Vivo() {
		sol1.setEstaMuerto(false);
		sol2.setEstaMuerto(false);
		sol1.disparar(sol2);

		assertFalse(sol1.isEstaMuerto());
		assertTrue(sol2.isEstaMuerto());
	}
	// Se ajusta el valor del atributo estaMuerto del soldado1 y soldado2 a false.
	// El objeto soldado1 ejecuta el metodo disparar sobre soldado2.
	// Tras recibir el metodo disparar, el soldado 2 cambia el estado del atributo
	// estaMuerto a true, es decir, el soldado 2 muere.

	@Test
	public void testSoldado1DisparaAlSoldado2Muerto() {
		sol1.setEstaMuerto(false);
		sol2.setEstaMuerto(true);
		sol1.disparar(sol2);

		assertFalse(sol1.isEstaMuerto());
		assertTrue(sol2.isEstaMuerto());
	}
	// Se ajusta el valor del atributo estaMuerto del soldado1 a false y el del
	// soldado 2 a true.
	// El objeto soldado1 ejecuta el metodo disparar sobre soldado2.
	// Tras recibir el metodo disparar, el soldado 2 continua con el estado del
	// atributo estaMuerto igual a true, es decir, sigue muerto.

	@Test
	public void testSoldado1DisparaAlSoldado1Vivo() {
		sol1.setEstaMuerto(false);
		sol2.setEstaMuerto(false);
		sol1.disparar(sol1);

		assertTrue(sol1.isEstaMuerto());
		assertFalse(sol2.isEstaMuerto());
	}
	// Se ajusta el valor del atributo estaMuerto del soldado1 y soldado2 a false.
	// El objeto soldado1 ejecuta el metodo disparar sobre soldado1, es decir, se
	// pega un tiro.
	// Tras recibir el metodo disparar, el soldado 1 cambia el estado del atributo
	// estaMuerto a true, es decir, el soldado 1 muere porque se ha pegado un tiro.

}
