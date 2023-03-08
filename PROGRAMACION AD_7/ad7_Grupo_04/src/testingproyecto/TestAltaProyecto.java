package testingproyecto;
import java.sql.Date;

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
		   Date inicio = Date.valueOf("2020-06-15");
		   Date finPrev = Date.valueOf("2020-09-21");
		   Date finReal = Date.valueOf("2020-10-23");		
		   Proyecto pro = new Proyecto("FOR202007", "Investigacion", new Date (new java.util.Date().getTime()), finPrev, finReal, 40000.00, 20000.00, 315000.00, "ACTIVO", empdao.buscarUno(114), clidao.buscarCliente("A22222222"));
		   Proyecto pro1 = new Proyecto("FOR202010", "Financiacion", new Date (new java.util.Date().getTime()), finPrev, finReal, 40000.00, 20000.00, 315000.00, "ACTIVO", empdao.buscarUno(114), clidao.buscarCliente("A22222222"));
			  
		   
		
		System.out.println("Alta Proyecto");
		System.out.println(prodao.altaProyecto(pro));
		System.out.println(prodao.altaProyecto(pro1));

		}


	}



     
	