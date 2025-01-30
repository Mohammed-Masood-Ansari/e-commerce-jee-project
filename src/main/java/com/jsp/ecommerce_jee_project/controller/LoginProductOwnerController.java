package com.jsp.ecommerce_jee_project.controller;

import java.io.IOException;

import com.jsp.ecommerce_jee_project.dao.ProductOwnerDao;
import com.jsp.ecommerce_jee_project.dao.impl.ProductOwnerDaoImpl;
import com.jsp.ecommerce_jee_project.entity.ProductOwner;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet(value="/loginProductOwner")
public class LoginProductOwnerController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession httpSession = req.getSession();
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		ProductOwnerDao productOwnerDao = new ProductOwnerDaoImpl();
		
		ProductOwner productOwner=productOwnerDao.getProductOwnerByEmailDao(email);
		
		if(productOwner!=null) {
			
			if(productOwner.getOwnerVerify().equalsIgnoreCase("yes")) {
				
				if(productOwner.getOwnerPassword().equals(password)) {
					
					httpSession.setAttribute("productOwnerSession", email);
					
					req.getRequestDispatcher("productOwner-home.jsp").forward(req, resp);;
					
				}else {
					req.setAttribute("msg", "password wrong");
					req.getRequestDispatcher("productOwner-login.jsp").forward(req, resp);;
				}
				
			}else {
				req.setAttribute("msg", "you are not verified owner");
				req.getRequestDispatcher("productOwner-login.jsp").forward(req, resp);;
			}
			
			
		}else {
			
			req.setAttribute("msg", "email wrong");
			req.getRequestDispatcher("productOwner-login.jsp").forward(req, resp);;
			
		}
		
	}


}
