package br.com.controledeveiculos.exception;

public class FailedToDeleteVehicleException extends Exception {

	private static final long serialVersionUID = -8892132714962369944L;
	
	public FailedToDeleteVehicleException(String message) {
		super(message);
	}

}