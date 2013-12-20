package com.de_mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * classe de retour vers l'etape (permet de reinitialiser les parametres correctement)
 * @author root
 * @version 1.0
 */
public class BackToEtape_servlet extends AbstractServlets {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException{
		/*response.setContentType("text/html");
		PrintWriter out = response.getWriter();*/
		
		HttpSession session = request.getSession(false);
		String numDossier = session.getAttribute("numDossier").toString();
		String dateNaissance = session.getAttribute("dateNaissance").toString();
		//out.print(session.getAttribute("numDossier").toString());
		while(session.getAttributeNames().hasMoreElements())
			session.removeAttribute(session.getAttributeNames().nextElement().toString());
		//out.print(session.getAttribute("numDossier").toString());
		
		
		//out.print(numDossier);
		//out.print(dateNaissance);
		session.setAttribute("dateNaissance", dateNaissance);
		session.setAttribute("numDossier", numDossier);
		request.getRequestDispatcher("Etape.do").forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
