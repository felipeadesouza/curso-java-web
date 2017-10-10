package br.com.tt.util.convert;

import org.springframework.stereotype.Service;

@Service(value = "cv")
public class Convert {

	public String cpf(String cpf) {

		String bloco1 = cpf.substring(0, 3);
		String bloco2 = cpf.substring(3, 6);
		String bloco3 = cpf.substring(6, 9);
		String bloco4 = cpf.substring(9, 11);

		cpf = bloco1 + "." + bloco2 + "." + bloco3 + "-" + bloco4;
		
		//usar isto no index do cliente para formatar
		//<td th:text="${beans.cv.cpf(c.cpf)}">

		return cpf;
	}

}
