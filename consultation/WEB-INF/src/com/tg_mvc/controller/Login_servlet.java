package com.tg_mvc.controller;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tg_mvc.metier.Metier;
import com.tg_mvc.tools.LoadProperties;
import com.tg_mvc.tools.MyMail;

/**
 * servelt de redirection vers commissions si le login de gestionnaire est valide, sinon redirection vers erreurAcces.jsp
 * @author root
 * @version 1.0
 */
public class Login_servlet extends AbstractServlets {


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
		
		
		
		String login = "";
		if(request.getParameter("login") != null)//arrive de retour
			login = request.getParameter("login") ;
		else {
			String nom = request.getParameter("nom").toLowerCase();//1ere arrivee
			if(!MyMail.isMail(nom)){
				login = nom+"@exemple.fr";
			} else {
				login = nom;
			}
		}
		
		
		if(metier.verifLogin(login)){
			HttpSession session = request.getSession(false);
			session.setAttribute("login", login);
			metier.deconnexion();
			RequestDispatcher dispatch = request.getRequestDispatcher("commission");
			dispatch.forward(request, response);
		} else {
			metier.deconnexion();
			RequestDispatcher dispatch = request.getRequestDispatcher("erreurAcces.jsp");
			dispatch.forward(request, response);
		}
		
	}
	



	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)						
											throws IOException, ServletException{
		doGet(request, response);
	}

}
