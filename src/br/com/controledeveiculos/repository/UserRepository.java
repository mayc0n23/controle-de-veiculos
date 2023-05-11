package br.com.controledeveiculos.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.controledeveiculos.entity.User;
import br.com.controledeveiculos.exception.FailedToFetchUserException;
import br.com.controledeveiculos.exception.FailedToRegisterUserException;
import br.com.controledeveiculos.exception.FailedToUpdateUserException;

public class UserRepository {
	
	private MySQLConnection connection;
	
	private ResultSet resultSet;
	
	private PreparedStatement statement;
	
	public List<User> findAll() {
		List<User> users = new ArrayList<>();
		connection = MySQLConnection.getInstance();
		String query = "SELECT * FROM user";
		try {
			connection.connect();
			statement = connection.getConnection().prepareStatement(query);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt(1));
				user.setName(resultSet.getString(2));
				user.setUsername(resultSet.getString(3));
				user.setPassword(resultSet.getString(4));
				users.add(user);
			}
		} catch (Exception exception) {
			Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, exception);
		} finally {
			connection.disconnect();
		}
		return users;
	}
	
	public void save(User user) throws FailedToRegisterUserException {
		connection = MySQLConnection.getInstance();
		String query = "INSERT INTO user (name, username, password) values (?, ?, ?)";
		try {
			connection.connect();
			statement = connection.getConnection().prepareStatement(query);
			statement.setString(1, user.getName());
			statement.setString(2, user.getUsername());
			statement.setString(3, user.getPassword());
			statement.execute();
		} catch (Exception exception) {
			Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, exception);
			throw new FailedToRegisterUserException("Falha ao cadastrar o usuário! Tente novamente.");
		} finally {
			connection.disconnect();
		}
	}
	
	public Optional<User> findByUsernameAndPassword(String username, String password) throws FailedToFetchUserException {
		Optional<User> response = Optional.empty();
		connection = MySQLConnection.getInstance();
		String query = "SELECT id, name, username, password FROM user WHERE username = ? and password = ?";
		try {
			connection.connect();
			statement = connection.getConnection().prepareStatement(query);
			statement.setString(1, username);
			statement.setString(2, password);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt(1));
				user.setName(resultSet.getString(2));
				user.setUsername(resultSet.getString(3));
				user.setPassword(resultSet.getString(4));
				response = Optional.of(user);
			}
		} catch (Exception exception) {
			Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, exception);
			throw new FailedToFetchUserException("Falha ao fazer login! Tente novamente..");
		} finally {
			connection.disconnect();
		}
		return response;
	}
	
	public void update(User user) throws FailedToUpdateUserException {
		connection = MySQLConnection.getInstance();
		String query = "UPDATE user SET name = ?, username = ?, password = ? WHERE id = ?";
		try {
			connection.connect();
			statement = connection.getConnection().prepareStatement(query);
			statement.setString(1, user.getName());
			statement.setString(2, user.getUsername());
			statement.setString(3, user.getPassword());
			statement.setInt(4, user.getId());
			statement.execute();
		} catch (Exception exception) {
			Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, exception);
			throw new FailedToUpdateUserException("Falha ao atualizar os dados do usuário! Tente novamente.");
		} finally {
			connection.disconnect();
		}
	}
	
}