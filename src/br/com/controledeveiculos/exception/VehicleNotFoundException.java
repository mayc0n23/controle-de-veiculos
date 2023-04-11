package br.com.controledeveiculos.exception;

public class VehicleNotFoundException extends Exception {

	private static final long serialVersionUID = 1844509252581035190L;
	
	public VehicleNotFoundException(String message) {
		super(message);
	}

}