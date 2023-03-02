package principales;


import java.util.Scanner;

import modelo.daojdbc.*;

import modelo.javabeans.*;


public class GestionClientes {


	public static void main(String[] args) {
		
		Scanner leer = new Scanner(System.in);

		int opcion=0;
		String cif;
		String nombre;
		String apellidos;
		String domicilio;
		double facturacion;
		int numeroempleados;

		ClienteDao cldao = new ClienteDaoImplMy8();
		Cliente cl1 = new Cliente();
		
		while (opcion != 5) {
			System.out.println("");
			System.out.println("-------------MENÚ-------------");
			System.out.println("");
			System.out.println("1. Alta del Cliente");
			System.out.println("2. Buscar un Cliente");
			System.out.println("3. Mostrar Todos");
			System.out.println("4. Eliminar un cliente");
			System.out.println("5. Salir");
			System.out.println("");
			System.out.println("Selecciona una opción");
		
			opcion = leer.nextInt();
			switch (opcion) {
			
				case 1:{ //Dar de alta un cliente
					
					System.out.println("Introduce los datos del cliente que vas a dar de alta");
					System.out.println("------------");
					
					System.out.println("Cif");
					cif = leer.next();
					cl1.setCif(cif);
					
					System.out.println("Nombre");
					nombre = leer.next();
					cl1.setNombre(nombre);;
					
					System.out.println("Apellidos");
					apellidos = leer.next();
					cl1.setApellidos(apellidos);
					
					System.out.println("Domicilio");
					domicilio = leer.next();
					cl1.setDomicilio(domicilio);
					
					System.out.println("Facturacion anual");
					facturacion = leer.nextDouble();
					cl1.setFacturacionAnual(facturacion);
					
					System.out.println("Numero de empleados");
					numeroempleados = leer.nextInt();
					cl1.setNumeroEmpleados(numeroempleados);
					
					cldao.altaCliente(cl1);
						
				break;
				}
				
				
				case 2:{ // Buscar un cliente
					
					System.out.println("2. Buscar un Cliente");
					System.out.println("Introduce el cif del cliente que quieres buscar");
					cif = leer.next();
					cldao.buscarCliente(cif);
				break;
				
				}
			
				
				case 3:{ //Mostrar todos
					
		
					for (Cliente ele: cldao.buscarTodos()) {
						System.out.println(ele);
						}
				break;
				}
			
				
				case 4:{ //Eliminar un cliente
				
					System.out.println("Introduce el cif del cliente que quires eliminar");
					cif = leer.next();
					cldao.borrarCliente(cif);
				break;	
				}
				
				default: { if (opcion > 5 || opcion <1)
					System.out.println("Opción incorrecta");
					break;
				}
			
	}

		
		System.out.println("FIN");
	}

}}
