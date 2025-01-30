package com.jsp.ecommerce_jee_project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductOwner {
	
	private int ownerId;
	private String ownerName;
	private String ownerEmail;
	private String ownerPassword;
	private String ownerVerify;
	
	//insertion
	public ProductOwner(String ownerName, String ownerEmail, String ownerPassword) {
		super();
		this.ownerName = ownerName;
		this.ownerEmail = ownerEmail;
		this.ownerPassword = ownerPassword;
	}

	//login
	public ProductOwner(String ownerEmail, String ownerPassword) {
		super();
		this.ownerEmail = ownerEmail;
		this.ownerPassword = ownerPassword;
	}
}
