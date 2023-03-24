package br.com.controledeveiculos.service;

import java.util.List;

import br.com.controledeveiculos.entity.Vehicle;
import br.com.controledeveiculos.repository.VehicleRepository;

public class VehicleService {

	private VehicleRepository repository;
	
	public VehicleService() {
		this.repository = new VehicleRepository();
	}
	
	public List<Vehicle> listOfAvailableVehicles() {
		return this.repository.findAllAvailableForSale();
	}
	
	public List<Vehicle> listOfVehiclesSold() {
		return this.repository.findAllSold();
	}
	
}