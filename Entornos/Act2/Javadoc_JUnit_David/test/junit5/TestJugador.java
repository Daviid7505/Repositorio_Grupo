package junit5;

import static org.junit.jupiter.api.Assertions.*;
import javabeans.Jugador;
import org.junit.jupiter.api.Test;

class TestJugador {
	
	Jugador jugador = new Jugador();
	
	@Test
	public void testDorsal() {
		
		//Prueba1
		//Vamos a asignarle a nuestro jugador el dorsal 5, al ser mayor a 1 y menor de 30 debería de asignarle el dorsal
		//que le hemos pasado
		
			//Llamamos al método y le pasamos el dorsal
			jugador.ponerDorsal(5);
		
			int Resultadodorsal = jugador.getDorsal();
			int Esperadodorsal = 5;
		
		//Prueba2
		//Vamos a asignarle a nuestro jugador un número de dorsal inferior a 1
		//Debería de ponernos -1 en el dorsal
		
			jugador.ponerDorsal(0);
		
			int Resultadodorsal2 = jugador.getDorsal();
			int Esperadodorsal2 = -1;
		
		//Prueba3
		//En esta prueba le vamos a pasar un dorsal superior a 30 
		//Debería de poner -1 en el dorsal
		
			jugador.ponerDorsal(35);
		
			int Resultadodorsal3 = jugador.getDorsal();
			int Esperadodorsal3 = -1;
		
		
		//Agrupamos todos los assert de nuestras pruebas para tener el código más ordenado
		assertAll("Comparaciones TestDorsal",
			() -> assertTrue(Resultadodorsal == Esperadodorsal),	
			() -> assertTrue (Resultadodorsal2 == Esperadodorsal2),
			() -> assertTrue (Resultadodorsal3 == Esperadodorsal3));		
}
	@Test
	public void testExpulsado() {
		
		//Prueba1
		//En esta prueba vamos a introducir 2 tarjetas amarillas al jugador y 0 rojas 
		//Debería de expulsar a nuestro jugador
		
			//Asignamos las tarjetas
			jugador.setNumeroTarjetasAmarillas(2);
			jugador.setNumeroTarjetasRojas(0);
		
			//Llamamos al método estaExpulsado
			boolean Resultadoexpulsado = jugador.estaExpulsado();
			boolean Esperadoexpulsado = true;
		
		
		//Prueba2
		//Vamos a pasarle 1 tarjeta amarilla y 1 tarjeta Roja
		//Debería de expulsarnos al jugador
		
			//Asignamos las tarjetas
			jugador.setNumeroTarjetasAmarillas(1);
			jugador.setNumeroTarjetasRojas(1);
		
			//Llamamos al método estaExpulsado
			boolean Resultadoexpulsado2 = jugador.estaExpulsado();
			boolean Esperadoexpulsado2 = true;
		
		
		//Prueba3
		//Asignamos 1 tarjeta amarilla y 0 rojas
		//Debería de no expulsarnos al jugador
		
			//Asignamos las tarjetas
			jugador.setNumeroTarjetasAmarillas(1);
			jugador.setNumeroTarjetasRojas(0);
		
			//Llamamos al método estaExpulsado
			boolean Resultadoexpulsado3 = jugador.estaExpulsado();
			boolean Esperadoexpulsado3 = false;
			
		//Prueba4
		//Asignamos 0 tarjetas amarillas y 0 rojas
		//Debería de no expulsarnos al jugador
			
				//Asignamos las tarjetas
				jugador.setNumeroTarjetasAmarillas(0);
				jugador.setNumeroTarjetasRojas(0);
			
				//Llamamos al método estaExpulsado
				boolean Resultadoexpulsado4 = jugador.estaExpulsado();
				boolean Esperadoexpulsado4 = false;		
		
		assertAll("Comparaciones testExpulsado",
				() -> assertEquals(Esperadoexpulsado, Resultadoexpulsado),
				() -> assertEquals(Esperadoexpulsado2, Resultadoexpulsado2),
				() -> assertEquals(Esperadoexpulsado3, Resultadoexpulsado3),
				() -> assertEquals(Esperadoexpulsado4, Resultadoexpulsado4));
	}
			

}
