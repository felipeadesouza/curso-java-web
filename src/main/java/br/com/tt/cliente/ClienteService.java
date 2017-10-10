package br.com.tt.cliente;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.tt.exception.SistemaException;
import br.com.tt.model.CadastroReceita;
import br.com.tt.util.convert.HttpClient;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	List<Cliente> consulta() {

		List<Cliente> resultado = repository.findAll();
		// List<Cliente> resultado = repository.clientesOrdenadoNome();
		// List<Cliente> resultado = repository.findByNomeLike("%Fel%");

		return resultado;
	}

	public Cliente salvar(Cliente cliente) {
		cliente = repository.save(cliente);
		return cliente;
	}

	public Cliente buscar(Long id) {
		return repository.findOne(id);
	}

	public void excluir(Long id) {
		repository.delete(id);

	}

	public CadastroReceita consultaReceita(String cnpj) throws Exception {

		ObjectMapper mapper = new ObjectMapper();
		String receitaJson = HttpClient.get("");
		CadastroReceita cadReceita = mapper.readValue(receitaJson, CadastroReceita.class);
		return null;
	}

}
