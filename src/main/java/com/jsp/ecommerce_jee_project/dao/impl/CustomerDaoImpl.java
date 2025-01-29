package com.jsp.ecommerce_jee_project.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jsp.ecommerce_jee_project.connection.EcommerceConnection;
import com.jsp.ecommerce_jee_project.dao.CustomerDao;
import com.jsp.ecommerce_jee_project.entity.Customer;

public class CustomerDaoImpl implements CustomerDao {

	Connection connection = EcommerceConnection.getEcommerceConnection();

	final String CUSTOMER_REGISTER_QUERY = "insert into customer(name,email,password,image) values(?,?,?,?)";

	final String GET_CUSTOMER_BY_EMAIL_QUERY = "select * from customer where email=?";
	@Override
	public Customer registerCustomerDao(Customer customer) {

		try {

			PreparedStatement ps = connection.prepareStatement(CUSTOMER_REGISTER_QUERY);
			
			ps.setString(1, customer.getCustomerName());
			ps.setString(2, customer.getCustomerEmail());
			ps.setString(3, customer.getCustomerPassword());
			ps.setBytes(4, customer.getCustomerImage());
			
			int a=ps.executeUpdate();
			
			if(a!=0) {
				System.out.println("customer registered");
				return customer;
			}else {
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Customer getCustomerByIdDao(String email) {
		try {

			PreparedStatement ps = connection.prepareStatement(GET_CUSTOMER_BY_EMAIL_QUERY);
			
			
			ps.setString(1, email);
			
			
			ResultSet set = ps.executeQuery();
			
			if(set.next()) {
				return  new Customer(set.getString("email"), set.getString("password"));
			}else {
				return null;
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
