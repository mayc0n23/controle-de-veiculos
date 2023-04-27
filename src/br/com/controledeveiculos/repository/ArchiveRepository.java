package br.com.controledeveiculos.repository;

import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.controledeveiculos.entity.Archive;
import br.com.controledeveiculos.exception.FailedToDeleteFileException;
import br.com.controledeveiculos.exception.FailedToSaveFileException;

public class ArchiveRepository {
	
	private MySQLConnection connection;
	
	private ResultSet resultSet;
	
	private PreparedStatement statement;
	
	public void save(Archive archive) throws FailedToSaveFileException {
		connection = MySQLConnection.getInstance();
		String query = "INSERT INTO file_storage (vehicle_id, filename, archive) values (?, ?, ?)";
		try {
			connection.connect();
			statement = connection.getConnection().prepareStatement(query);
			statement.setInt(1, archive.getVehicleId());
			statement.setString(2, archive.getFilename());
			Blob blob = connection.getConnection().createBlob();
			blob.setBytes(1, archive.getArchive());
			statement.setBlob(3, blob);
			statement.execute();
		} catch (Exception exception) {
			Logger.getLogger(ArchiveRepository.class.getName()).log(Level.SEVERE, null, exception);
			throw new FailedToSaveFileException("Falha ao salvar arquivo! Tente novamente.");
		} finally {
			connection.disconnect();
		}
	}
	
	public boolean delete(int vehicleId) throws FailedToDeleteFileException {
		connection = MySQLConnection.getInstance();
		String query = "DELETE FROM file_storage WHERE vehicle_id = ?";
		try {
			connection.connect();
			statement = connection.getConnection().prepareStatement(query);
			statement.setInt(1, vehicleId);
			statement.execute();
			return true;
		} catch (Exception exception) {
			Logger.getLogger(ArchiveRepository.class.getName()).log(Level.SEVERE, null, exception);
			throw new FailedToDeleteFileException("Falha ao excluir o arquivo! Tente novamente.");
		} finally {
			connection.disconnect();
		}
	}
	
	public List<Archive> findByVehicleId(int vehicleId) {
		List<Archive> archives = new ArrayList<>();
		connection = MySQLConnection.getInstance();
		String sql = "SELECT * FROM file_storage WHERE vehicle_id = ?";
		try {
			connection.connect();
			statement = connection.getConnection().prepareStatement(sql);
			statement.setInt(1, vehicleId);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Archive archive = new Archive();
				archive.setId(resultSet.getInt(1));
				archive.setVehicleId(resultSet.getInt(2));
				archive.setFilename(resultSet.getString(3));
				Blob blob = resultSet.getBlob(4);
				int blobLength = (int) blob.length();
				archive.setArchive(blob.getBytes(1, blobLength));
				archives.add(archive);
				blob.free();
			}
		} catch (Exception exception) {
			Logger.getLogger(ArchiveRepository.class.getName()).log(Level.SEVERE, null, exception);
		} finally {
			connection.disconnect();
		}
		return archives;
	}

}