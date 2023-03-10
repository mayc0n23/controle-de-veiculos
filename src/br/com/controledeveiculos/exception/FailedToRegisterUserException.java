package br.com.controledeveiculos.exception;

public class FailedToRegisterUserException extends Exception {

	private static final long serialVersionUID = 6578848912803795659L;
	
	public FailedToRegisterUserException(String message) {
		super(message);
	}

}