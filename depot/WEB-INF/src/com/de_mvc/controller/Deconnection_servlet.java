package com.de_mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * servlet de deconnection
 * @author root
 * @version 1.0
 */
public class Deconnection_servlet extends AbstractServlets {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	
	@Override 
	public void doGet(HttpServletRequest request, HttpServletResponse response)						
											throws IOException, ServletException{
		request.getSession(false).invalidate();
		request.getRequestDispatcher("deconnection.jsp").forward(request, response);
	}


	@Override 
	public void doPost(HttpServletRequest request, HttpServletResponse response)						
											throws IOException, ServletException{
		doGet(request, response);
	}

	
}
