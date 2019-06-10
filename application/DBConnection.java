package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String URL = "jdbc:mysql://localhost/Online_Shop?useSSL=false";
	private static final String USERNAME = "XAVIER";
	private static final String PASSWORD = "@LMNTrix254";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}
	
	
}
