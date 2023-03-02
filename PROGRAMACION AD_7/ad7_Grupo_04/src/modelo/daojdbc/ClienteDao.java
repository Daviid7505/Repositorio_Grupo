package modelo.daojdbc;

import java.util.List;

import modelo.javabeans.Cliente;

public interface ClienteDao {
	
	// CREAR - LEER - ACTUALIZAR - BORRAR - BUSCAR TODOS
	
	int altaCliente (Cliente cliente);
	Cliente buscarCliente (String cif);
	int borrarCliente (String cif);
	int modificarCliente (Cliente cliente);
	List<Cliente> buscarTodos();

}
