package br.com.tt.cliente;

import static br.com.tt.util.HttpClient.get;
import static br.com.tt.util.Util.jsonToObject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tt.exception.SistemaException;
import br.com.tt.model.CadastroReceita;

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
	
	List<Cliente> consulta(String cnpj) {

		List<Cliente> resultado = repository.findByCnpjLike(cnpj);

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

	public CadastroReceita consultaReceita(String cnpj) throws SistemaException {
		return jsonToObject(get("https://www.receitaws.com.br/v1/cnpj/" + cnpj), CadastroReceita.class);

	}

	public static void main(String[] args) throws SistemaException {
		CadastroReceita cad = new ClienteService().consultaReceita("27865757000102");
		System.out.println(cad.getAbertura());
	}

}
