package br.com.tt.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cliente")
public class ClienteApi {

	@Autowired
	private ClienteService service;

	@GetMapping
	List<Cliente> clientes() {
		return service.consulta();
	}
	
	@GetMapping("{id}")
	Cliente cliente(@PathVariable(name = "id") Integer id) {
		List<Cliente> clientes = service.consulta();
		
		if (id > clientes.size()) {
			return new Cliente();
		}
			
		return clientes.get(id -1);
	}

}
