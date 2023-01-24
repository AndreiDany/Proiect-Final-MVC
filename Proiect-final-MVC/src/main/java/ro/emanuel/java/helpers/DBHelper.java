package ro.emanuel.java.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBHelper {

	private static Connection conn;
	
	
	public static Connection getConnection() throws SQLException {
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch(ClassNotFoundException e) {
			
			e.printStackTrace();
			
		}
		
		if(conn==null || conn.isClosed())
		{
			Properties connectionProps = new Properties();
			connectionProps.put("user", "root");
			connectionProps.put("password", "");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect_final_restaurant",
					connectionProps);
			
			return conn;
		}
		else return conn;
	}
	
	public static void colseConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}