package br.com.controledeveiculos.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.controledeveiculos.entity.Vehicle;

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
			}
		} catch (Exception exception) {
			Logger.getLogger(VehicleRepository.class.getName()).log(Level.SEVERE, null, exception);
		} finally {
			connection.disconnect();
		}
		return vehicles;
	}
	
}