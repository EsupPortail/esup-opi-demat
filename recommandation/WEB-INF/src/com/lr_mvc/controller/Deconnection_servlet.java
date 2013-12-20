package com.lr_mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * servlet de deconnectioon et rediretion vers deconnection.jsp
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Vous etes bien deconnecté");
		out.println("Cliquez <a href=\"index.jsp\">ici</a> pour retourner à l'acceuil ");
		request.getRequestDispatcher("deconnection.jsp").forward(request, response);
	}

	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)						
											throws IOException, ServletException{
		doGet(request, response);
	}

	
}
