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
 * 
 * @author root
 *
 */
public class EnregitrementMDP_servlet extends AbstractServlets {


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
		
		HttpSession session = request.getSession(true);
		String adresseMail = session.getAttribute("adresseMail").toString();
		String password = request.getParameter("password1").toUpperCase();
		
		//enregistre mot de passe pour referent et supprimer le lien
		metier.setMDPForRef(adresseMail, password);
		
		metier.deconnexion();
		request.getRequestDispatcher("MDPEnregistre.jsp").forward(request, response);
	}
	



	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)						
											throws IOException, ServletException{
		doGet(request, response);
	}

}