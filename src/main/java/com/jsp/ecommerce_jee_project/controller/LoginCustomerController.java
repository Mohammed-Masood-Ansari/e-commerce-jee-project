package com.jsp.ecommerce_jee_project.controller;

import java.io.IOException;

import com.jsp.ecommerce_jee_project.dao.CustomerDao;
import com.jsp.ecommerce_jee_project.dao.impl.CustomerDaoImpl;
import com.jsp.ecommerce_jee_project.entity.Customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(value = "/loginCustomer")
public class LoginCustomerController extends HttpServlet {

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession httpSession = req.getSession();
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		CustomerDao customerDao = new CustomerDaoImpl();
		
		Customer customer=customerDao.getCustomerByIdDao(email);
		
		if(customer!=null) {
			
			if(customer.getCustomerPassword().equals(password)) {
				
				httpSession.setAttribute("customerSession", email);
				
				req.getRequestDispatcher("customer-home.jsp").forward(req, resp);;
				
			}else {
				req.setAttribute("msg", "password wrong");
				req.getRequestDispatcher("customer-login.jsp").forward(req, resp);;
			}
		}else {
			
			req.setAttribute("msg", "email wrong");
			req.getRequestDispatcher("customer-login.jsp").forward(req, resp);;
			
		}
		
	}
	
}
