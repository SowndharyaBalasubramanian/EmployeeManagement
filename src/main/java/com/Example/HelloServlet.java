package com.Example;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		  request.setAttribute("userName", "Besant");
		  //request.setAttribute("isLoggedIn", true);
		  
		  RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
		  rd.forward(request, response);
	 }
}
