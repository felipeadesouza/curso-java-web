package br.com.tt.exception;

public class SistemaException extends Exception {

	private static final long serialVersionUID = 1L;

	public SistemaException(String message, Throwable cause) {
		super(message, cause);
		System.err.println(message+" - Erro:"+cause.getMessage());
	}

	public SistemaException(String message) {
		super(message);
		System.err.println("Erro:"+message);
	}

}
