package testingproyecto;

import modelo.daojdbc.ClienteDao;
import modelo.daojdbc.ClienteDaoImplMy8;
import modelo.daojdbc.DepartamentoDao;
import modelo.daojdbc.DepartamentoDaoImplMy8;
import modelo.daojdbc.EmpleadoDao;
import modelo.daojdbc.EmpleadoDaoImplMy8;
import modelo.daojdbc.ProyectoDao;
import modelo.daojdbc.ProyectoDaoImplMy8;
import modelo.javabeans.Proyecto;

public class TestAltaProyecto {

	public static void main(String[] args) {
		
       ProyectoDao prodao = new ProyectoDaoImplMy8();
	   EmpleadoDao empdao = new EmpleadoDaoImplMy8();
	   DepartamentoDao depdao = new DepartamentoDaoImplMy8();
	   ClienteDao clidao = new ClienteDaoImplMy8();

		
				
	Proyecto pro = new Proyecto();
	pro.setIdProyecto("FOR2020004");
	pro.setDescripcion( "Formacion de empleados");
	pro.setFechaInicio(null);
	pro.setFechaFinPrevisto(null);
	pro.setFechaFinReal(null);
	pro.setVentasPrevisto(50000.00);
	pro.setCostesPrevisto(30000.00);
	pro.setCosteReal(41000.00);
	pro.setEstado("TERMINADO");
	pro.setJefeProyecto(empdao.buscarUno(114));
	pro.setCliente(clidao.buscarCliente("A22222222"));
	
	
	System.out.println("Alta Proyecto");
	System.out.println(prodao.altaProyecto(pro));

	}

}
