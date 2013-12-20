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
 * servlet de redirection vers listCandidat, (si le referent se connecte pour la 1ere fois redirection vers nomPrenomRef)
 * @author root
 * @version 1.0
 */
public class NomPrenomRef_servlet extends AbstractServlets {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)						
											throws IOException, ServletException{
		/*response.setContentType("text/html");
		PrintWriter out = response.getWriter();*/
		Properties prop = LoadProperties.load(getServletContext().getRealPath("/")+"/WEB-INF/classes/Message_fr.properties");
		Metier metier = new Metier(prop);
		metier.connexion();
		
		HttpSession session = request.getSession(false);
		String adresseMail = session.getAttribute("adresseMail").toString();
		
		if((metier.getPrenomRef(adresseMail)+metier.getNomRef(adresseMail)).length() == 0){
			metier.deconnexion();
			request.getRequestDispatcher("nomPrenomRef.jsp").forward(request, response);
		} else {
			metier.deconnexion();
			request.getRequestDispatcher("listCandidat").forward(request, response);
		}
		
		
		
	}
	



	public void doPost(HttpServletRequest request, HttpServletResponse response)						
											throws IOException, ServletException{
		doGet(request, response);
	}

}