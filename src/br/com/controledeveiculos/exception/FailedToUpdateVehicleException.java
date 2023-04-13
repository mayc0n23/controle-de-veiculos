package br.com.controledeveiculos.exception;

public class FailedToUpdateVehicleException extends Exception {

	private static final long serialVersionUID = 2034879106389967142L;
	
	public FailedToUpdateVehicleException(String message) {
		super(message);
	}

}