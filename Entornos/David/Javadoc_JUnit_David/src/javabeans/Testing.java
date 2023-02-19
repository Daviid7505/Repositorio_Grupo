package javabeans;

public class Testing {

	public static void main(String[] args) {
	
		//Creamos un jugador y con set asignamos valores
		Jugador j1 = new Jugador();
		
		j1.setDorsal(58);
		j1.setNumeroTarjetasAmarillas(2);
		j1.setNumeroTarjetasRojas(4);
		
		
		//Creamos un soldado y con set asignamos valores
		Soldado s1 = new Soldado();
		
		Soldado s2 = new Soldado();
		
		s1.setEstaMuerto(false);
		s1.setNumeroBalas(10);
		
		s2.setEstaMuerto(false);
		s2.setNumeroBalas(15);
		
		//Invocamos métodos para testear
//		j1.ponerDorsal(18);
//		System.out.println(j1.getDorsal());
		s1.disparar(s2);
		
		System.out.println(s1.isEstaMuerto());
		System.out.println(s2.isEstaMuerto());

	}

}
