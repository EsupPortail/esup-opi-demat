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
 * servlet de redirection vers la page de depot.jsp pour un etudiant (si le depot est effectué, redirection vers depotEffectue.jsp)
 * @author root
 * @version 1.0
 */
public class Etudiant_servlet extends AbstractServlets {


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
		
		
		String idUsr;
		String nomUsr;
		if(request.getParameter("idUsr") != null){
			idUsr = request.getParameter("idUsr");
			nomUsr = request.getParameter("nomUsr"+idUsr);
		} else {
			idUsr = session.getAttribute("idUsr").toString();
			nomUsr = session.getAttribute("nomUsr").toString();
		}
		String mail = session.getAttribute("adresseMail").toString();
		String idRef = metier.getIdRef(mail);
		//String nomRef = session.getAttribute("nomRef").toString();
		//String prenomRef = session.getAttribute("prenomRef").toString();
		String nomFile = metier.getNomFile(idRef, idUsr);
		//out.print(idUsr+nomUsr+mail+nomRef+prenomRef);
		
		
		if(nomFile.trim().length() == 0){
			session.setAttribute("idUsr", idUsr);
			session.setAttribute("nomUsr", nomUsr);
			/*request.setAttribute("nomRef", nomRef);
			request.setAttribute("prenomRef", prenomRef);*/
			request.setAttribute("idRef", idRef);
			metier.deconnexion();
			request.getRequestDispatcher("depot.jsp").forward(request, response);
		} else {
			request.setAttribute("nomUsr", nomUsr);
			metier.deconnexion();
			request.getRequestDispatcher("depotEffectue.jsp").forward(request, response);
		}
		
		
	}
	



	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)						
											throws IOException, ServletException{
		doGet(request, response);
	}

}