package com.jsp.ecommerce_jee_project.controller;

import java.io.IOException;
import java.io.InputStream;

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
		
		System.out.println(stream+" "+image);
		System.out.println(password);
	}
}
