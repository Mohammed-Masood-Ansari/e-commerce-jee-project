package com.jsp.ecommerce_jee_project.dao;

import com.jsp.ecommerce_jee_project.entity.Admin;

public interface AdminDao {

	public Admin getAdminByEmailDao(String email);
}
