package br.com.controledeveiculos.exception;

public class FailedToUpdateUserException extends Exception {

	private static final long serialVersionUID = 7181742666419365257L;
	
	public FailedToUpdateUserException(String message) {
		super(message);
	}

}