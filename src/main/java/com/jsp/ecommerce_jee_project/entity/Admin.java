package com.jsp.ecommerce_jee_project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
	
	private int adminId;
	private String adminName;
	private String adminEmail;
	private String adminPassword;
	
	public Admin(String adminEmail, String adminPassword) {
		super();
		this.adminEmail = adminEmail;
		this.adminPassword = adminPassword;
	}
	
	
	

}
