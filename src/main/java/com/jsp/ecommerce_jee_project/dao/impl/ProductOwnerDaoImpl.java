package com.jsp.ecommerce_jee_project.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jsp.ecommerce_jee_project.connection.EcommerceConnection;
import com.jsp.ecommerce_jee_project.dao.ProductOwnerDao;
import com.jsp.ecommerce_jee_project.entity.ProductOwner;

public class ProductOwnerDaoImpl implements ProductOwnerDao {

	Connection connection = EcommerceConnection.getEcommerceConnection();

	final String ProductOwner_REGISTER_QUERY = "insert into product_owner(name,email,password,verify) values(?,?,?,?)";

	final String GET_productOwner_BY_EMAIL_QUERY = "select * from product_owner where email=?";
	
	final String GET_ALL_NONVERIFIED_PRODUCT_OWNER_DETAILS = "SELECT * FROM PRODUCT_OWNER WHERE verify='no'";
	
	final String GET_ALL_VERIFIED_PRODUCT_OWNER_DETAILS = "SELECT * FROM PRODUCT_OWNER WHERE verify='yes'";
	
	final String VERIFY_PRODUCT_OWNER_QUERY = "update PRODUCT_OWNER set verify=? where id=?";
	
	@Override
	public ProductOwner registerProductOwnerDao(ProductOwner productOwner) {

		try {

			PreparedStatement ps = connection.prepareStatement( ProductOwner_REGISTER_QUERY );
			
			ps.setString(1, productOwner.getOwnerName());
			ps.setString(2, productOwner.getOwnerEmail());
			ps.setString(3, productOwner.getOwnerPassword());
			ps.setString(4, "no");
			
			int a=ps.executeUpdate();
			
			if(a!=0) {
				System.out.println("customer registered");
				return productOwner;
			}else {
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ProductOwner getProductOwnerByEmailDao(String email) {
		try {

			PreparedStatement ps = connection.prepareStatement(GET_productOwner_BY_EMAIL_QUERY);
			
			
			ps.setString(1, email);
			
			
			ResultSet set = ps.executeQuery();
			
			if(set.next()) {
				ProductOwner owner= new ProductOwner();
				
				owner.setOwnerEmail(set.getString("email"));
				owner.setOwnerPassword(set.getString("password"));
				owner.setOwnerVerify(set.getString("verify"));
				
				return owner;
			}else {
				return null;
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

}

	@Override
	public List<ProductOwner> getAllNonVerifiedProductOwnerDao() {
		
		try {
			Statement statement = connection.createStatement();
			ResultSet set=statement.executeQuery(GET_ALL_NONVERIFIED_PRODUCT_OWNER_DETAILS);
			
			List<ProductOwner> owners = new ArrayList<ProductOwner>();
			while(set.next()) {
				
				ProductOwner owner = 
						new ProductOwner(set.getInt("id"),
						set.getString("name"),
						set.getString("email"),
						set.getString("verify")
						);
				owners.add(owner);
				
			}
			return owners;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean verifyProductOwnerDao(int id) {
		
		try {

			PreparedStatement ps = connection.prepareStatement(VERIFY_PRODUCT_OWNER_QUERY);
			
			
			ps.setString(1, "yes");
			ps.setInt(2, id);
			
			int a = ps.executeUpdate();
			
			if(a!=0) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public List<ProductOwner> getAllVerifiedProductOwnerDao() {
		try {
			Statement statement = connection.createStatement();
			ResultSet set=statement.executeQuery(GET_ALL_VERIFIED_PRODUCT_OWNER_DETAILS);
			
			List<ProductOwner> owners = new ArrayList<ProductOwner>();
			while(set.next()) {
				
				ProductOwner owner = 
						new ProductOwner(set.getInt("id"),
						set.getString("name"),
						set.getString("email"),
						set.getString("verify")
						);
				owners.add(owner);
				
			}
			return owners;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean unverifyProductOwnerDao(int id) {
		try {

			PreparedStatement ps = connection.prepareStatement(VERIFY_PRODUCT_OWNER_QUERY);
			
			
			ps.setString(1, "no");
			ps.setInt(2, id);
			
			int a = ps.executeUpdate();
			
			if(a!=0) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}
}
