package br.com.controledeveiculos.exception;

public class FailedToFetchUserException extends Exception {

	private static final long serialVersionUID = -107460222800928674L;
	
	public FailedToFetchUserException(String message) {
		super(message);
	}

}