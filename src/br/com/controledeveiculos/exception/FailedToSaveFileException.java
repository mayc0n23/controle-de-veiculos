package br.com.controledeveiculos.exception;

public class FailedToSaveFileException extends Exception {

	private static final long serialVersionUID = 3377451827506621543L;
	
	public FailedToSaveFileException(String message) {
		super(message);
	}

}