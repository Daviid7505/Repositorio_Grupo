package testingproyecto;

import modelo.daojdbc.ClienteDao;
import modelo.daojdbc.ClienteDaoImplMy8;
import modelo.daojdbc.EmpleadoDao;
import modelo.daojdbc.EmpleadoDaoImplMy8;
import modelo.daojdbc.ProyectoDao;
import modelo.daojdbc.ProyectoDaoImplMy8;
import modelo.javabeans.Proyecto;

public class TestModificarProyecto {

	public static void main(String[] args) {


		 ProyectoDao prodao = new ProyectoDaoImplMy8();
	        EmpleadoDao empdao = new EmpleadoDaoImplMy8();
	        ClienteDao cldao =new ClienteDaoImplMy8();
		    Proyecto proyecto = prodao.buscarUno("FOR202007");
		    proyecto.setDescripcion("Financicion");
	        proyecto.getEmpleado().setIdEmpl(114);
	        proyecto.getCliente().setCif("A22222222");
	        System.out.println(prodao.modificarProyecto(proyecto));
	        System.out.println( prodao.buscarUno("FOR202007"));
			
			 

			}
	}





