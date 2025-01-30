package com.jsp.ecommerce_jee_project.controller;

import java.io.IOException;

import com.jsp.ecommerce_jee_project.dao.AdminDao;
import com.jsp.ecommerce_jee_project.dao.CustomerDao;
import com.jsp.ecommerce_jee_project.dao.impl.AdminDaoImpl;
import com.jsp.ecommerce_jee_project.dao.impl.CustomerDaoImpl;
import com.jsp.ecommerce_jee_project.entity.Admin;
import com.jsp.ecommerce_jee_project.entity.Customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(value = "/loginAdmin")
public class LoginAdminController extends HttpServlet {
	
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession httpSession = req.getSession();
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		AdminDao adminDao = new AdminDaoImpl();
		
		Admin  admin = adminDao.getAdminByEmailDao(email);
		
		if(admin!=null) {
			
			if(admin.getAdminPassword().equals(password)) {
				
				httpSession.setAttribute("adminSession", email);
				
				req.getRequestDispatcher("admin-home.jsp").forward(req, resp);;
				
			}else {
				req.setAttribute("msg", "password wrong");
				req.getRequestDispatcher("admin-login.jsp").forward(req, resp);;
			}
		}else {
			
			req.setAttribute("msg", "email wrong");
			req.getRequestDispatcher("admin-login.jsp").forward(req, resp);;
			
		}
		
	}

}
