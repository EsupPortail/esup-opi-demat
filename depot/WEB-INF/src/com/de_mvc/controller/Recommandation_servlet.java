package com.de_mvc.controller;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.de_mvc.tools.LoadProperties;
import com.de_mvc.metier.Metier;


/**
 * servlet de redirection vers recommandaion.jsp, avec passage des attributs. 
 * @author root
 * @version 1.0
 */
public class Recommandation_servlet extends AbstractServlets {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
					throws IOException, ServletException{
		
		
		/*response.setContentType("text/html");
		PrintWriter out = response.getWriter();*/
		
		/**********************recuperation des parametres******************************/
		Properties prop = LoadProperties.load(getServletContext().getRealPath("/")+"/WEB-INF/classes/Message_fr.properties");
		Metier metier = new Metier(prop);
		metier.connexion();
		
		HttpSession session = request.getSession(false);
		String idUsr = session.getAttribute("idUsr").toString();
		int nbMailRecommandation = Integer.parseInt(metier.nbMailRecommandation(idUsr));
		
		/*********************************************************************************/
		
		if(nbMailRecommandation < 3){
			metier.deconnexion();
			request.setAttribute("nbMailRecommandation", nbMailRecommandation);
			request.getRequestDispatcher("recommandation.jsp").forward(request, response);
		} else {
			metier.deconnexion();
			request.getRequestDispatcher("finRecommandation.jsp").forward(request, response);
		}
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}
