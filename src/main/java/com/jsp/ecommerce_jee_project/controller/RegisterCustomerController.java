package com.jsp.ecommerce_jee_project.controller;

import java.io.IOException;
import java.io.InputStream;

import com.jsp.ecommerce_jee_project.dao.CustomerDao;
import com.jsp.ecommerce_jee_project.dao.impl.CustomerDaoImpl;
import com.jsp.ecommerce_jee_project.entity.Customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet(value = "/customerRegister")
@MultipartConfig
public class RegisterCustomerController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String  name= req.getParameter("customerName");
		String email= req.getParameter("customerEmail");
		String password= req.getParameter("customerPassword");
		Part image = req.getPart("customerImage");
		
		InputStream stream=image.getInputStream();
		
		byte[] image1=stream.readAllBytes();
		
		
		Customer customer1 = new Customer(name, email, password, image1);
		
		
		CustomerDao customerDao = new CustomerDaoImpl();
		
		Customer customer2=customerDao.registerCustomerDao(customer1);
		
		if(customer2!=null) {
			
			req.getRequestDispatcher("customer-login.jsp").forward(req, resp);
		}else {
			req.setAttribute("msg", "check with your code something went wrong");
			req.getRequestDispatcher("customer-register.jsp").forward(req, resp);
		}
	}
}
