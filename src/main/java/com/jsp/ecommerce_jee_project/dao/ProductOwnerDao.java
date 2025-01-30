package com.jsp.ecommerce_jee_project.dao;

import com.jsp.ecommerce_jee_project.entity.ProductOwner;

public interface ProductOwnerDao {
	public ProductOwner registerProductOwnerDao(ProductOwner productOwner);
	public ProductOwner getProductOwnerByEmailDao(String email);


}
