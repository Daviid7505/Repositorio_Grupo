package principal;

import modelo.daojdbc.EmpleadoDao;
import modelo.daojdbc.EmpleadoDaoImplMy8;
import modelo.javabeans.Empleado;

public class TestEmpleadosJavabean {

	public static void main(String[] args) {

		EmpleadoDao edao = new EmpleadoDaoImplMy8();

		Empleado empleado = edao.buscarUno(120);

		System.out.println("El nombre completo es: " + empleado.nombreCompleto());
		System.out.println();
		System.out.println("El email es: " + empleado.obtenerEmail());
		System.out.println();
		System.out.println("El salario mensual es: " + empleado.salarioMensual(12));
		System.out.println();
		System.out.println("El salario bruto es: " + empleado.salarioBruto());
		System.out.println();
		System.out.println("El género es: " + empleado.literalSexo(empleado.getGenero()));

	}

}
