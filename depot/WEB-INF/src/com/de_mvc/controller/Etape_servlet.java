package com.de_mvc.controller;


import java.util.ArrayList;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.de_mvc.tools.LoadProperties;
import com.de_mvc.metier.Metier;

/**
 * servlet de verification des coordonnées d'acces, des délais de depot et de redirection vers Etapes.jsp
 * @author root
 * @version 1.0
 */
public class Etape_servlet extends AbstractServlets{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		
		HttpSession session = request.getSession(true);
		/*response.setContentType("text/html");
		PrintWriter out = response.getWriter();*/
		Properties prop = LoadProperties.load(getServletContext().getRealPath("/")+"/WEB-INF/classes/Message_fr.properties");
		Metier metier = new Metier(prop);
		metier.connexion();
		String numDossier="";
		String dateNaissance="";
		if(request.getParameter("numDossier") == null){
			numDossier = session.getAttribute("numDossier").toString().toUpperCase();
			dateNaissance = session.getAttribute("dateNaissance").toString().toUpperCase();
		} else {
			numDossier = request.getParameter("numDossier").toUpperCase();
			dateNaissance = request.getParameter("dateNaissance").toUpperCase();
			//out.print(dateNaissance);
		}
		//jjmmaaaa
		
		if(dateNaissance.length() != 8){
			metier.deconnexion();
			request.getRequestDispatcher("erreurAcces.jsp").forward(request, response);
			return;
		}
		
		String dateNaissance2 = dateNaissance.substring(4, 8)+ "-" + dateNaissance.substring(2, 4) + "-" +dateNaissance.substring(0, 2);
		if(metier.verifNumDossier(numDossier) && dateNaissance2.equals(metier.getDateDeNaissance(numDossier))){
			String idUsr = metier.getIdUsr(numDossier);
			String nomUsr = metier.getNomUsr(idUsr);
			session.setAttribute("numDossier", numDossier);
			session.setAttribute("dateNaissance", dateNaissance);
			session.setAttribute("idUsr", idUsr);
			session.setAttribute("nomUsr", nomUsr);
			
			String[] idLinks = metier.getTabIdLinks(idUsr);
			ArrayList<String> trtCmis = metier.getListIdTrtCmi(idLinks);
			ArrayList<String> libCmis = metier.getListLibCmis(trtCmis);
			
			//l'utilisateur n'a deposé pour aucun master
			if(trtCmis.size() == 0){
				metier.deconnexion();
				request.getRequestDispatcher("erreurAcces.jsp").forward(request, response);
				return;
			}
			
			ArrayList<String> codeEtapes = metier.getCodeEtapes(trtCmis);
			ArrayList<String> codeVets = metier.getCodeVets(trtCmis);
			
			
			metier.deconnexion();
			request.setAttribute("codeEtapes", codeEtapes);
			request.setAttribute("codeVets", codeVets);
			request.setAttribute("trtCmis", trtCmis);
			request.setAttribute("libCmis", libCmis);
			request.getRequestDispatcher("Etapes.jsp").forward(request, response);
			
		} else {
			metier.deconnexion();
			RequestDispatcher dispatch = request.getRequestDispatcher("erreurAcces.jsp");
			dispatch.forward(request, response);
		} 
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		/*throw new ServletException("GET method used with "
				+ getClass().getName() + ": POST method required.");*/
		doGet(request, response);
	}

}
