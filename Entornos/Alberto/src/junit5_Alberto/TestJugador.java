package junit5_Alberto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javabean_Alberto.Jugador;

class TestJugador {

	private Jugador jugad;

	@BeforeEach
	void setUp() throws Exception {
		// Me interesa antes de cada test tener un objeto jugador vacio
		jugad = new Jugador();
		// configuramos todo lo que queramos antes de cada @Test
	}

	@AfterEach
	void tearDown() throws Exception {
		// Después de cada test elimino el objeto de tipo jugador
		jugad = null;
	}

	/**
	 * En esta prueba unitaria, vamos a probar el metodo "ponerDorsal" probando los
	 * tres posibles casos que se pueden dar : dorsal entre uno y treinta, dorsal
	 * mayor de treinta y dorsal menor de uno
	 */

	@Test
	public void testPonerDorsalEntreUnoYTreinta() {
		jugad.ponerDorsal(7);

		int resultadoEsperado = 7;
		int resultadoObtenido = jugad.getDorsal();

		assertEquals(resultadoEsperado, resultadoObtenido);
	}
	// Cuando al dorsal se le asigna un valor entre uno y treinta, al ejecutar el
	// metodo ponerDorsal se aplica a dorsal el valor que se le ha pasado por
	// parametro.

	@Test
	public void testPonerDorsalMasdeTreinta() {
		jugad.ponerDorsal(45);

		int resultadoEsperado = -1;
		int resultadoObtenido = jugad.getDorsal();

		assertEquals(resultadoEsperado, resultadoObtenido);
	}
	// Cuando al dorsal se le asigna un valor mayor de treinta, al ejecutar el
	// metodo ponerDorsal se aplica a dorsal el valor -1.

	@Test
	public void testPonerDorsalMenosdeUno() {
		jugad.ponerDorsal(0);

		int resultadoEsperado = -1;
		int resultadoObtenido = jugad.getDorsal();

		assertEquals(resultadoEsperado, resultadoObtenido);
	}
	// Cuando al dorsal se le asigna un valor menor de uno, al ejecutar el
	// metodo ponerDorsal se aplica a dorsal el valor -1.

	/**
	 * En esta prueba unitaria, vamos a probar el metodo "numeroTarjetasAmarillas"
	 * probando los dos posibles casos que se pueden dar : menos de dos tarjetas
	 * amarillas y dos o mas tarjetas amarillas.
	 */

	@Test
	public void testEstaExpulsadoMenosdeDosConAmarillas() {
		jugad.setNumeroTarjetasAmarillas(1);

		assertFalse(jugad.estaExpulsado());
	}
	// cuando al objeto Jugador se le aplica el metodo numeroTarjetasAmarillas con
	// valores menores a dos, no cambia el resultado del metodo estaExpulsado, por
	// lo que permanece false, es decir, no expulsado.

	@Test
	public void testEstaExpulsadoConDosAmarillas() {

		jugad.setNumeroTarjetasAmarillas(2);

		assertTrue(jugad.estaExpulsado());
	}
	// cuando al objeto Jugador se le aplica el metodo numeroTarjetasAmarillas con
	// valores mayores de dos, cambia el resultado del metodo estaExpulsado a true,
	// es decir, expulsado.

	/**
	 * En esta prueba unitaria, vamos a probar el metodo "numeroTarjetasRojas"
	 * probando los dos posibles casos que se pueden dar : menos de una tarjeta roja
	 * y una tarjeta roja o más.
	 */

	@Test
	public void testEstaExpulsadoConMenosDeUnaRoja() {
		jugad.setNumeroTarjetasRojas(0);

		assertFalse(jugad.estaExpulsado());
	}
	// cuando al objeto Jugador se le aplica el metodo numeroTarjetasRojas con
	// valores menores a uno, no cambia el resultado del metodo estaExpulsado, por
	// lo que permanece false, es decir, no expulsado.

	@Test
	public void testEstaExpulsadoConUnaRoja() {
		jugad.setNumeroTarjetasRojas(1);

		assertTrue(jugad.estaExpulsado());
	}
	// cuando al objeto Jugador se le aplica el metodo numeroTarjetasAmarillas con
	// valores mayores de uno, cambia el resultado del metodo estaExpulsado a true,
	// es decir, expulsado.

}
