package br.com.tt.cliente;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.tt.exception.SistemaException;
import br.com.tt.model.CadastroReceita;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService service;

	@GetMapping
	ModelAndView cliente() {

		ModelAndView mv = new ModelAndView("cliente/index");

		mv.addObject("clientes", service.consulta());

		return mv;
	}

	@GetMapping("/cadastro")
	ModelAndView cadastro(Cliente cliente) {

		ModelAndView mv = new ModelAndView("cliente/cadastro");
		mv.addObject("cliente", cliente);
		return mv;
	}

	@PostMapping("/salvar")
	ModelAndView salvar(@Valid Cliente cliente, BindingResult result) {
		if (result.hasErrors()) {
			return this.cadastro(cliente);
		}

		service.salvar(cliente);
		return this.cliente();

	}
	
	@GetMapping("/editar/{id}")
	ModelAndView editar(@PathVariable("id") Long id) {
		return cadastro(service.buscar(id));
	}
	
	@GetMapping("/excluir/{id}")
	ModelAndView excluir(@PathVariable("id") Long id) {
		service.excluir(id);
		return cliente();
	}
	
	@GetMapping("/consulta/receita")
	ModelAndView telaconsultaReceita() {
		ModelAndView mv = new ModelAndView("/cliente/consulta-receita");
		mv.addObject("cadastroReceita", new CadastroReceita());
		return mv;
	}
	
	@PostMapping("/consulta/receita")
	ModelAndView consultaReceita(CadastroReceita cadastroReceita) throws SistemaException {
		
		
		Cliente cliente = new Cliente();

		
		List<Cliente> clientes = service.consulta(cadastroReceita.getCnpj());
		if (clientes != null && !clientes.isEmpty()) {
			cliente = clientes.get(0);
		}else {
			cadastroReceita = service.consultaReceita(cadastroReceita.getCnpj());
			cliente.setNome(cadastroReceita.getFantasia());
			cliente.setCnpj(cadastroReceita.getCnpj().replace(".", "").replace("/", "").replace("-", ""));
			cliente.setData(cadastroReceita.getAbertura());
		}
		 
		return cadastro(cliente);
		
	}

}
