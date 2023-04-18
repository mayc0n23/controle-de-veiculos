package br.com.controledeveiculos.repository;

import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		String query = "INSERT INTO file_storage (vehicle_id, archive) values (?, ?)";
		try {
			connection.connect();
			statement = connection.getConnection().prepareStatement(query);
			statement.setInt(1, archive.getVehicleId());
			Blob blob = connection.getConnection().createBlob();
			blob.setBytes(1, archive.getArchive());
			statement.setBlob(2, blob);
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

}