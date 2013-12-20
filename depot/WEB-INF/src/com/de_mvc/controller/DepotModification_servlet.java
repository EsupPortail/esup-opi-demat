package com.de_mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * servlet de rdirection vers la jsp de modification des pieces deposées
 * @author root
 * @version 1.0
 */
public class DepotModification_servlet extends  AbstractServlets {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException{
		String valeurs = request.getParameter("valeurs");
		String nomFichier = valeurs.substring(0, valeurs.lastIndexOf("="));
		String idNom = valeurs.substring(valeurs.lastIndexOf("=")+1, valeurs.lastIndexOf("."));
		request.setAttribute("piece", nomFichier);
		request.setAttribute("code", idNom);
		request.getRequestDispatcher("depotModification.jsp").forward(request, response);
	}

	
	@Override 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		throw new ServletException("GET method used with "
				+ getClass().getName() + ": POST method required.");
	}
}
