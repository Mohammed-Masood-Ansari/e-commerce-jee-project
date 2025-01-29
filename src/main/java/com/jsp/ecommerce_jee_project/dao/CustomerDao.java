package com.jsp.ecommerce_jee_project.dao;

import com.jsp.ecommerce_jee_project.entity.Customer;

public interface CustomerDao {
	
	public Customer registerCustomerDao(Customer customer);
	
	public Customer getCustomerByIdDao(String email);

}
