package com.lr_mvc.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lr_mvc.metier.Metier;
import com.lr_mvc.tools.LoadProperties;

/**
 * servlet de redirecion vers la page nomPrenomRef, sinon redirection vers erreurAccess.jsp
 * @author root
 * @version 1.0
 */
public class LoginReferent_servlet extends AbstractServlets {


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
		Metier metier= new Metier(prop);
		metier.connexion();
		
		String adresseMail = request.getParameter("adresseMail").trim().toLowerCase();
		String password = request.getParameter("password").trim().toUpperCase();
		
		if(adresseMail.equals("") || password.equals("")){
			metier.deconnexion();
			request.getRequestDispatcher("ErreurAcces.jsp").forward(request, response);
			return;
		}
		
		
		
		ArrayList<String> ListMailRef = metier.getListMailRef();
		//out.print(ListMailRef);
		
		boolean existe = false;
		for(String s : ListMailRef){
			if(s.toLowerCase().equals(adresseMail))
				existe = true;
		}
		
		if(existe){
			if(metier.getPasswordRef(adresseMail).equals(password)){
				HttpSession session = request.getSession(true);
				session.setAttribute("adresseMail", adresseMail);
				metier.deconnexion();
				request.getRequestDispatcher("nomPrenomRef").forward(request, response);
				
			} else {
				metier.deconnexion();
				request.getRequestDispatcher("ErreurAcces.jsp").forward(request, response);
			}
		} else {
			metier.deconnexion();
			request.getRequestDispatcher("ErreurAcces.jsp").forward(request, response);
		}
		
		
		
	}
	



	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)						
											throws IOException, ServletException{
		doGet(request, response);
	}
	
	

}