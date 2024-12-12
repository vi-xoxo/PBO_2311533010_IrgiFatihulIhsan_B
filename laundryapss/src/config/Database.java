package config;

import java.sql.*;
import javax.swing.JOptionPane;

public class Database {
	
	private static Connection connection;
	
	public static Connection getConnection() {
		if(connection == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/laundry_apps","root","");
				return conn;
			} catch(Exception e) {
				JOptionPane.showMessageDialog(null, e);
				return null;
			}
		}
		
		return connection;
	}
}
