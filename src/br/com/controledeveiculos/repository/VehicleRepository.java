package br.com.controledeveiculos.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.controledeveiculos.entity.Vehicle;
import br.com.controledeveiculos.exception.FailedToDeleteVehicleException;
import br.com.controledeveiculos.exception.FailedToRegisterVehicleException;
import br.com.controledeveiculos.exception.FailedToUpdateVehicleException;

public class VehicleRepository {
	
	private MySQLConnection connection;
	
	private ResultSet resultSet;
	
	private PreparedStatement statement;
	
	public List<Vehicle> findAllAvailableForSale() {
		List<Vehicle> vehicles = new ArrayList<>();
		connection = MySQLConnection.getInstance();
		String query = "SELECT * FROM vehicle WHERE out_name IS NULL ORDER BY id DESC";
		try {
			connection.connect();
			statement = connection.getConnection().prepareStatement(query);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Vehicle vehicle = new Vehicle();
				vehicle.setId(resultSet.getInt(1));
				vehicle.setDescription(resultSet.getString(2));
				vehicle.setPlate(resultSet.getString(3));
				vehicle.setChassis(resultSet.getString(4));
				vehicle.setRenavam(resultSet.getString(5));
				vehicle.setSalePrice(resultSet.getString(6));
				vehicle.setObservation(resultSet.getString(7));
				vehicle.setType(resultSet.getString(8));
				vehicle.setInName(resultSet.getString(9));
				vehicle.setInAddress(resultSet.getString(10));
				vehicle.setInPhone(resultSet.getString(11));
				vehicle.setInPaymentDescription(resultSet.getString(12));
				vehicle.setInRg(resultSet.getString(13));
				vehicle.setInCpf(resultSet.getString(14));
				vehicles.add(vehicle);
			}
		} catch (Exception exception) {
			Logger.getLogger(VehicleRepository.class.getName()).log(Level.SEVERE, null, exception);
		} finally {
			connection.disconnect();
		}
		return vehicles;
	}
	
	public List<Vehicle> findAllSold() {
		List<Vehicle> vehicles = new ArrayList<>();
		connection = MySQLConnection.getInstance();
		String query = "SELECT * FROM vehicle WHERE out_name IS NOT NULL ORDER BY id DESC";
		try {
			connection.connect();
			statement = connection.getConnection().prepareStatement(query);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Vehicle vehicle = new Vehicle();
				vehicle.setId(resultSet.getInt(1));
				vehicle.setDescription(resultSet.getString(2));
				vehicle.setPlate(resultSet.getString(3));
				vehicle.setChassis(resultSet.getString(4));
				vehicle.setRenavam(resultSet.getString(5));
				vehicle.setSalePrice(resultSet.getString(6));
				vehicle.setObservation(resultSet.getString(7));
				vehicle.setType(resultSet.getString(8));
				vehicle.setInName(resultSet.getString(9));
				vehicle.setInAddress(resultSet.getString(10));
				vehicle.setInPhone(resultSet.getString(11));
				vehicle.setInPaymentDescription(resultSet.getString(12));
				vehicle.setInRg(resultSet.getString(13));
				vehicle.setInCpf(resultSet.getString(14));
				vehicle.setOutName(resultSet.getString(15));
				vehicle.setOutAddress(resultSet.getString(16));
				vehicle.setOutPhone(resultSet.getString(17));
				vehicle.setOutPaymentDescription(resultSet.getString(18));
				vehicle.setOutRg(resultSet.getString(19));
				vehicle.setOutCpf(resultSet.getString(20));
				vehicles.add(vehicle);
			}
		} catch (Exception exception) {
			Logger.getLogger(VehicleRepository.class.getName()).log(Level.SEVERE, null, exception);
		} finally {
			connection.disconnect();
		}
		return vehicles;
	}
	
	public boolean register(Vehicle vehicle) throws FailedToRegisterVehicleException {
		connection = MySQLConnection.getInstance();
		String query = "INSERT INTO vehicle (description, plate, chassis, renavam, sale_price, observation, type, in_name, in_address, in_phone, in_payment_description, in_rg, in_cpf) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			connection.connect();
			statement = connection.getConnection().prepareStatement(query);
			statement.setString(1, vehicle.getDescription());
			statement.setString(2, vehicle.getPlate());
			statement.setString(3, vehicle.getChassis());
			statement.setString(4, vehicle.getRenavam());
			statement.setString(5, vehicle.getSalePrice());
			statement.setString(6, vehicle.getObservation());
			statement.setString(7, vehicle.getType());
			statement.setString(8, vehicle.getInName());
			statement.setString(9, vehicle.getInAddress());
			statement.setString(10, vehicle.getInPhone());
			statement.setString(11, vehicle.getInPaymentDescription());
			statement.setString(12, vehicle.getInRg());
			statement.setString(13, vehicle.getInCpf());
			statement.execute();
			return true;
		} catch (Exception exception) {
			Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, exception);
			throw new FailedToRegisterVehicleException("Falha ao cadastrar o veículo! Tente novamente.");
		} finally {
			connection.disconnect();
		}
	}
	
	public boolean delete(int id) throws FailedToDeleteVehicleException {
		connection = MySQLConnection.getInstance();
		String query = "DELETE FROM vehicle WHERE id = ?";
		try {
			connection.connect();
			statement = connection.getConnection().prepareStatement(query);
			statement.setInt(1, id);
			statement.execute();
			return true;
		} catch (Exception exception) {
			Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, exception);
			throw new FailedToDeleteVehicleException("Falha ao excluir o veículo! Tente novamente.");
		} finally {
			connection.disconnect();
		}
	}
	
	public Optional<Vehicle> findById(int id) {
		connection = MySQLConnection.getInstance();
		String query = "SELECT * FROM vehicle WHERE id = ?";
		try {
			connection.connect();
			statement = connection.getConnection().prepareStatement(query);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Vehicle vehicle = new Vehicle();
				vehicle.setId(resultSet.getInt(1));
				vehicle.setDescription(resultSet.getString(2));
				vehicle.setPlate(resultSet.getString(3));
				vehicle.setChassis(resultSet.getString(4));
				vehicle.setRenavam(resultSet.getString(5));
				vehicle.setSalePrice(resultSet.getString(6));
				vehicle.setObservation(resultSet.getString(7));
				vehicle.setType(resultSet.getString(8));
				vehicle.setInName(resultSet.getString(9));
				vehicle.setInAddress(resultSet.getString(10));
				vehicle.setInPhone(resultSet.getString(11));
				vehicle.setInPaymentDescription(resultSet.getString(12));
				vehicle.setInRg(resultSet.getString(13));
				vehicle.setInCpf(resultSet.getString(14));
				vehicle.setOutName(resultSet.getString(15));
				vehicle.setOutAddress(resultSet.getString(16));
				vehicle.setOutPhone(resultSet.getString(17));
				vehicle.setOutPaymentDescription(resultSet.getString(18));
				vehicle.setOutRg(resultSet.getString(19));
				vehicle.setOutCpf(resultSet.getString(20));
				return Optional.of(vehicle);
			}
		} catch (Exception exception) {
			Logger.getLogger(VehicleRepository.class.getName()).log(Level.SEVERE, null, exception);
		} finally {
			connection.disconnect();
		}
		return Optional.empty();
	}
	
	public void updateAvailableVehicle(Vehicle vehicle) throws FailedToUpdateVehicleException {
		connection = MySQLConnection.getInstance();
		String query = "UPDATE vehicle SET description = ?, plate = ?, chassis = ?, renavam = ?, sale_price = ?, observation = ?, type = ?, in_name = ?, in_address = ?, in_phone = ?, in_payment_description = ?, in_rg = ?, in_cpf = ? WHERE id = ?";
		try {
			connection.connect();
			statement = connection.getConnection().prepareStatement(query);
			statement.setString(1, vehicle.getDescription());
			statement.setString(2, vehicle.getPlate());
			statement.setString(3, vehicle.getChassis());
			statement.setString(4, vehicle.getRenavam());
			statement.setString(5, vehicle.getSalePrice());
			statement.setString(6, vehicle.getObservation());
			statement.setString(7, vehicle.getType());
			statement.setString(8, vehicle.getInName());
			statement.setString(9, vehicle.getInAddress());
			statement.setString(10, vehicle.getInPhone());
			statement.setString(11, vehicle.getInPaymentDescription());
			statement.setString(12, vehicle.getInRg());
			statement.setString(13, vehicle.getInCpf());
			statement.setInt(14, vehicle.getId());
			statement.execute();
		} catch (Exception exception) {
			Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, exception);
			throw new FailedToUpdateVehicleException("Falha ao atualizar os dados do veículo! Tente novamente.");
		} finally {
			connection.disconnect();
		}
	}
	
}