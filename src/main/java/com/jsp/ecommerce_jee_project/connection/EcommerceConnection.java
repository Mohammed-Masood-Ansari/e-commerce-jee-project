package com.jsp.ecommerce_jee_project.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class EcommerceConnection {
	
	
	public static Connection getEcommerceConnection() {
		
		try {
			Driver driver = new Driver();
			
			DriverManager.registerDriver(driver);

			return DriverManager.getConnection("jdbc:mysql://localhost:3306/e-commerce", "root","root");
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			return null;
		}
	}

}
