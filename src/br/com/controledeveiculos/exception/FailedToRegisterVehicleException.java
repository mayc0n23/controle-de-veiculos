package br.com.controledeveiculos.exception;

public class FailedToRegisterVehicleException extends Exception {

	private static final long serialVersionUID = 6863960995080029383L;
	
	public FailedToRegisterVehicleException(String message) {
		super(message);
	}

}