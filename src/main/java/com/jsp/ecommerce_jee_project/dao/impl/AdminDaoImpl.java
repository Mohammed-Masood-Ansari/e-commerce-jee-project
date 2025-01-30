package com.jsp.ecommerce_jee_project.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jsp.ecommerce_jee_project.connection.EcommerceConnection;
import com.jsp.ecommerce_jee_project.dao.AdminDao;
import com.jsp.ecommerce_jee_project.entity.Admin;
import com.jsp.ecommerce_jee_project.entity.Customer;

public class AdminDaoImpl implements AdminDao {
	
	Connection connection = EcommerceConnection.getEcommerceConnection();

	final String GET_ADMIN_BY_EMAIL_QUERY = "select * from admin where email=?";

	@Override
	public Admin getAdminByEmailDao(String email) {
		
		try {

			PreparedStatement ps = connection.prepareStatement(GET_ADMIN_BY_EMAIL_QUERY);
			
			
			ps.setString(1, email);
			
			
			ResultSet set = ps.executeQuery();
			
			if(set.next()) {
				return  new Admin(set.getString("email"), set.getString("password"));
			}else {
				return null;
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
