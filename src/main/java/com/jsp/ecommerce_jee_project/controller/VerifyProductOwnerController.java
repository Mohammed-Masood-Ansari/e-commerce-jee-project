package com.jsp.ecommerce_jee_project.controller;

import java.io.IOException;

import com.jsp.ecommerce_jee_project.dao.ProductOwnerDao;
import com.jsp.ecommerce_jee_project.dao.impl.ProductOwnerDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value = "/ownerVerify")
public class VerifyProductOwnerController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		ProductOwnerDao dao = new ProductOwnerDaoImpl();
		
		boolean b=dao.verifyProductOwnerDao(id);
		
		if(b) {
			
		}
	}
}
