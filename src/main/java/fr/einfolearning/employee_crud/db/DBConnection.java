package fr.einfolearning.employee_crud.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnection {

	private static Connection connection = null;
        
	
	public static Connection getInstance()
	{
		if (connection == null) {
		try
		{
			String dbURL = "jdbc:postgresql://localhost:5432/devavance_bd"; // PostgreSQL 
			String userName = "devavance_user";
			String password = "password";
						
			
			//Load JDBC Driver
			Class.forName("org.postgresql.Driver");
			
			//Open Connection to MySql Employee DB
			connection = DriverManager.getConnection(dbURL, userName, password);
			
			//Condition to make sure connection is established.
			if( connection != null) 
			{
				System.out.println("Connected !");
			}
			else
			{
				System.out.println("Not Connected !");
			}		
			return connection;
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
			return null;
		}
		}
		
		return connection;
	}
	
	public static void main(String[] args) {
		DBConnection.getInstance();
	}
}
