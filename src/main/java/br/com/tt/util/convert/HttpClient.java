package br.com.tt.util.convert;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import br.com.tt.exception.SistemaException;

public class HttpClient {

	public static String get(String url) throws SistemaException {

		try {
			HttpResponse<String> consulta = Unirest.get(url).asString();

			return consulta.getBody();

		} catch (UnirestException e) {

			throw new SistemaException("Acesso a URL " + url, e);
		}
	}

	public static void main(String[] args) throws SistemaException {
		String url = "https://www.receitaws.com.br/v1/cnpj/27865757000102";
		System.out.println(get(url));
		;
	}

}
