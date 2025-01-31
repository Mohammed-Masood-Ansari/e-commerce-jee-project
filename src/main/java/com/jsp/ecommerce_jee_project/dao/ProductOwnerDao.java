package com.jsp.ecommerce_jee_project.dao;

import java.util.List;

import com.jsp.ecommerce_jee_project.entity.ProductOwner;

public interface ProductOwnerDao {
	
	 ProductOwner registerProductOwnerDao(ProductOwner productOwner);
	 ProductOwner getProductOwnerByEmailDao(String email);
	 List<ProductOwner> getAllNonVerifiedProductOwnerDao();
	 List<ProductOwner> getAllVerifiedProductOwnerDao();
	 //Product getProductOwnerByIdDao(int productId);
	 boolean verifyProductOwnerDao(int id);
	 boolean unverifyProductOwnerDao(int id);

}
