package br.com.tt.cliente;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ClienteService {

	List<Cliente> consulta() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		clientes.add(new Cliente(1L, "Carlos", "03258", new Date()));
		clientes.add(new Cliente(2L, "Maria", "25478", new Date()));
		clientes.add(new Cliente(3L, "Marcia", "21749", new Date()));
		clientes.add(new Cliente(4L, "Juca", "01147", new Date()));
		clientes.add(new Cliente(5L, "Bruno", "99853", new Date()));
		clientes.add(new Cliente(6L, "Daniel", "23743", new Date()));

		return clientes;
	}

}
