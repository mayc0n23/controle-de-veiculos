package br.com.controledeveiculos.service;

import java.util.List;

import br.com.controledeveiculos.entity.Vehicle;
import br.com.controledeveiculos.exception.FailedToDeleteVehicleException;
import br.com.controledeveiculos.exception.FailedToRegisterVehicleException;
import br.com.controledeveiculos.exception.FailedToUpdateVehicleException;
import br.com.controledeveiculos.exception.VehicleNotFoundException;
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
	
	public boolean register(Vehicle vehicle) throws FailedToRegisterVehicleException {
		return this.repository.register(vehicle);
	}
	
	public void delete(int id) throws FailedToDeleteVehicleException {
		this.repository.delete(id);
	}
	
	public Vehicle searchById(int vehicleId) throws VehicleNotFoundException {
		return this.repository.findById(vehicleId)
				.orElseThrow(() -> new VehicleNotFoundException("Veículo não encontrado."));
	}
	
	public void updateAvailableVehicle(Vehicle vehicle) throws FailedToUpdateVehicleException {
		this.repository.updateAvailableVehicle(vehicle);
	}
	
}