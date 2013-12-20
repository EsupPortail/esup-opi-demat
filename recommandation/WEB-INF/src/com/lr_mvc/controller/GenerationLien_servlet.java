package com.lr_mvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lr_mvc.metier.Metier;
import com.lr_mvc.tools.LoadProperties;
import com.lr_mvc.tools.MyMail;
import com.lr_mvc.tools.PasswordGenerator;

public class GenerationLien_servlet extends AbstractServlets {


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
		
		String adresseMail = request.getParameter("adresseMail").toLowerCase();
		
		ArrayList<String> ListMailRef = metier.getListMailRef();
		//out.print(ListMailRef);
		
		boolean existe = false;
		for(String s : ListMailRef){
			if(s.toLowerCase().equals(adresseMail))
				existe = true;
		}
		
		
		if(existe) {
			String idLienUnique  = PasswordGenerator.generatePassword(20);
			String lien = prop.getProperty("lienIdentifRef");
			String lienComplet = lien+idLienUnique;
			
			metier.updateLienReferent(lienComplet, adresseMail);
			
			String sender = prop.getProperty("mailFrom");
			String getter = adresseMail;
			String host = prop.getProperty("mailHost");
			String hostServer = prop.getProperty("HostServer");
			String messageText = prop.getProperty("envoieMessageRecupMDP").toString()+"\n\n";
			messageText += "\n Lien : "+lienComplet;
			messageText += "\n adresse mail : "+adresseMail;
			String subject = prop.getProperty("recupMDP").toString();
			

			MyMail.sendMail(sender, getter, host, hostServer, messageText, subject);
			
			metier.deconnexion();
			request.getRequestDispatcher("mailEnvoye.jsp").forward(request, response);
		} else {
			metier.deconnexion();
			request.getRequestDispatcher("mailInconnu.jsp").forward(request, response);
		}
	}
	



	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)						
											throws IOException, ServletException{
		doGet(request, response);
	}

}