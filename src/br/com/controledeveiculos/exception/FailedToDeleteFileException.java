package br.com.controledeveiculos.exception;

public class FailedToDeleteFileException extends Exception {

	private static final long serialVersionUID = 9202001108401659556L;
	
	public FailedToDeleteFileException(String message) {
		super(message);
	}

}