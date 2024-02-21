package br.com.controledeveiculos.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLConnection {
	
	private Connection connection;
	
	private volatile static MySQLConnection instance;
	
	private MySQLConnection() { }
	
	public static MySQLConnection getInstance() {
		if (instance == null) {
			synchronized (MySQLConnection.class) {
				if (instance == null) {
					instance = new MySQLConnection();
				}
			}
		}
		return instance;
	}
	
	public Connection connect() {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			Class.forName(driver);
			String url = "jdbc:mysql://localhost:3306/cvc?useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
			String username = "root";
			String password = "maycon";
			connection = DriverManager.getConnection(url, username, password);
			return connection;
		} catch (SQLException | ClassNotFoundException exception) {
			Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, null, exception);
			return connection;
		}
	}
	
	public void disconnect() {
		try {
			connection.close();
		} catch (SQLException exception) {
			
		}
	}
	
	public Connection getConnection() {
    	return connection;
    }
	
}