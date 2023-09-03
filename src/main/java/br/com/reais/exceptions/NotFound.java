package br.com.reais.exceptions;

public class NotFound extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public NotFound(String mesage) {
		super(mesage);
	}
}
