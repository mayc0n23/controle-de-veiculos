package br.com.controledeveiculos.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
	
	public int register(Vehicle vehicle) throws FailedToRegisterVehicleException {
		connection = MySQLConnection.getInstance();
		String query = "INSERT INTO vehicle (description, plate, chassis, renavam, sale_price, observation, type, in_name, in_address, in_phone, in_payment_description, in_rg, in_cpf) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			connection.connect();
			statement = connection.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
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
			int rowsAffected = statement.executeUpdate();
			if (rowsAffected == 1) {
				ResultSet generatedKeys = statement.getGeneratedKeys();
				if (generatedKeys.next()) {
					return generatedKeys.getInt(1);
				} else {
					throw new FailedToRegisterVehicleException("Falha ao obter o ID do veículo inserido");
				}
			} else {
				throw new FailedToRegisterVehicleException("Falha ao cadastrar o veículo! Nenhuma linha afetada.");
			}
		} catch (Exception exception) {
			Logger.getLogger(VehicleRepository.class.getName()).log(Level.SEVERE, null, exception);
			throw new FailedToRegisterVehicleException("Falha ao cadastrar o ve�culo! Tente novamente.");
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
			Logger.getLogger(VehicleRepository.class.getName()).log(Level.SEVERE, null, exception);
			throw new FailedToDeleteVehicleException("Falha ao excluir o ve�culo! Tente novamente.");
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
			Logger.getLogger(VehicleRepository.class.getName()).log(Level.SEVERE, null, exception);
			throw new FailedToUpdateVehicleException("Falha ao atualizar os dados do ve�culo! Tente novamente.");
		} finally {
			connection.disconnect();
		}
	}
	
	public void sellVehicle(Vehicle vehicle) throws FailedToUpdateVehicleException {
		connection = MySQLConnection.getInstance();
		String query = "UPDATE vehicle SET out_name = ?, out_address = ?, out_phone = ?, out_payment_description = ?, out_rg = ?, out_cpf = ? WHERE id = ?";
		try {
			connection.connect();
			statement = connection.getConnection().prepareStatement(query);
			statement.setString(1, vehicle.getOutName());
			statement.setString(2, vehicle.getOutAddress());
			statement.setString(3, vehicle.getOutPhone());
			statement.setString(4, vehicle.getOutPaymentDescription());
			statement.setString(5, vehicle.getOutRg());
			statement.setString(6, vehicle.getOutCpf());
			statement.setInt(7, vehicle.getId());
			statement.execute();
		} catch (Exception exception) {
			Logger.getLogger(VehicleRepository.class.getName()).log(Level.SEVERE, null, exception);
			throw new FailedToUpdateVehicleException("Falha ao atualizar os dados do ve�culo! Tente novamente.");
		} finally {
			connection.disconnect();
		}
	}
	
}