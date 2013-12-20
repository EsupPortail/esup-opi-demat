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
public class ChoixMDP_servlet extends AbstractServlets {


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
		String idLienUnique = session.getAttribute("idLienUnique").toString();
		String adresseMail  = request.getParameter("adresseMail");
		
		String LienCompletFromDBForRef = metier.getLienCompletForRef(adresseMail);
		String idLienUniqueFromDBForRef  = LienCompletFromDBForRef.substring(LienCompletFromDBForRef.indexOf("=") + 1);
		
		
		if(idLienUniqueFromDBForRef.equals(idLienUnique)){
			metier.deconnexion();
			session.setAttribute("adresseMail", adresseMail);
			request.getRequestDispatcher("choixMDP.jsp").forward(request, response);
		} else  {
			metier.deconnexion();
			session.invalidate();
			request.getRequestDispatcher("erreurLien.jsp").forward(request, response);
		}
		
	}
	



	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)						
											throws IOException, ServletException{
		doGet(request, response);
	}

}