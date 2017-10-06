package br.com.tt.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	List<Cliente> consulta() {

		List<Cliente> resultado = repository.findAll();
		//List<Cliente> resultado = repository.clientesOrdenadoNome();
		//List<Cliente> resultado = repository.findByNomeLike("%Fel%");

		return resultado;
	}

	public void salvar(Cliente cliente) {
		repository.save(cliente);
		
	}

}
