package com.lr_mvc.controller;

import java.io.IOException;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lr_mvc.metier.Metier;
import com.lr_mvc.tools.LoadProperties;

/**
 * servlet de verification du nom prenom donné, redirection vers listCandidat.jsp, ou ErreurNomPrenomjsp s'ils respectent pas les normes
 * @author root
 * @version 1.0
 */
public class ValidationNomPrenom_servlet extends AbstractServlets {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)						
											throws IOException, ServletException{
		/*response.setContentType("text/html");
		PrintWriter out = response.getWriter();*/
		Properties prop = LoadProperties.load(getServletContext().getRealPath("/")+"/WEB-INF/classes/Message_fr.properties");
		Metier metier = new Metier(prop);
		metier.connexion();
		
		HttpSession session = request.getSession(false);
		String adresseMail = session.getAttribute("adresseMail").toString();
		String nomRef = request.getParameter("nomRef").trim();
		String prenomRef = request.getParameter("prenomRef").trim();
		String titreRef = request.getParameter("titreRef").trim();
		String fonctionRef = request.getParameter("fonctionRef").trim();
		
		
		
		if(nomRef.length() != 0 && prenomRef.length() != 0){
			metier.updateNomPrenomRef(nomRef, prenomRef, titreRef, fonctionRef, adresseMail);
			metier.deconnexion();
			request.getRequestDispatcher("listCandidat").forward(request, response);
		} else {
			metier.deconnexion();
			request.getRequestDispatcher("ErreurNomPrenom.jsp").forward(request, response);
		}
	}
	



	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)						
											throws IOException, ServletException{
		doGet(request, response);
	}

}