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

/**
 * servlet de mise à jour de la page interface.jsp
 * @author root
 *
 */
public class MiseAJour_servlet extends AbstractServlets{


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
		
		String traitement = request.getParameter("Traitement");
		String observation = request.getParameter("Observation");
		String idUsrEtudiant = request.getParameter("idUsrEtudiant");
		String idCmi = request.getParameter("idCmi");
		//String filtre = request.getParameter("filtre");
		//String filtreProvenance = request.getParameter("filtreProvenance");
		//String filtreAvis = request.getParameter("filtreAvis");
		String idUsr = session.getAttribute("idUsr").toString();
		
		
		if(metier.ligneExist(idUsr, idUsrEtudiant, idCmi))
			metier.updateObsTrait(idUsr, idUsrEtudiant, idCmi, traitement, observation);
		else 
			metier.insertObsTrait(idUsr, idUsrEtudiant, idCmi, traitement, observation);
		
		RequestDispatcher dispatch = request.getRequestDispatcher("interface");
		dispatch.forward(request, response);
	}
	
	

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)						
											throws IOException, ServletException{
		doGet(request, response);
	}

}