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

@WebServlet(value = "/productOwnerRegister")
public class RegisterProductOwnerController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String  name= req.getParameter("productOwnerName");
		String email= req.getParameter("productOwnerEmail");
		String password= req.getParameter("productOwnerPassword");
		
          ProductOwner productOwner1 = new ProductOwner(name, email, password);
		
		
          ProductOwnerDao productOwnerDao = new ProductOwnerDaoImpl();
		
          ProductOwner productOwner2=productOwnerDao.registerProductOwnerDao(productOwner1);
		
		if(productOwner2!=null) {
			
			req.getRequestDispatcher("productOwner-login.jsp").forward(req, resp);
		}else {
			req.setAttribute("msg", "check with your code something went wrong");
			req.getRequestDispatcher("productOwner-register.jsp").forward(req, resp);
		}
	}


}
