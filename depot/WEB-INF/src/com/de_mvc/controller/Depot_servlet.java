package com.de_mvc.controller;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.de_mvc.metier.Metier;
import com.de_mvc.tools.LoadProperties;

/**
 * servlet de redirection vers la liste des etapes
 * @author root
 * @version 1.0
 */
public class Depot_servlet extends AbstractServlets{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Override 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		/*response.setContentType("text/html");
		PrintWriter out = response.getWriter();*/
		
		Properties prop = LoadProperties.load(getServletContext().getRealPath("/")+"/WEB-INF/classes/Message_fr.properties");
		Metier metier = new Metier(prop);
		metier.connexion();
		
		
		/****************************Obtenir la liste des parametres********************************************/
		HttpSession session = request.getSession(false);
		String codeEtape, codeVet, idTrtCmi, idUsr;
		
		if(request.getParameter("codeEtape") == null){
			codeEtape = session.getAttribute("codeEtape").toString();
			codeVet = session.getAttribute("codeVet").toString();
			idTrtCmi = session.getAttribute("idTrtCmi").toString();
		} else {
			codeEtape = request.getParameter("codeEtape");
			codeVet = request.getParameter("codeVet");
			idTrtCmi = request.getParameter("idTrtCmi");
		}
		
		session.setAttribute("codeEtape", codeEtape);
		session.setAttribute("codeVet", codeVet);
		session.setAttribute("idTrtCmi", idTrtCmi);
		//numDossier = session.getAttribute("numDossier").toString();
		idUsr = session.getAttribute("idUsr").toString();
		
		
		/****************************************************************************************************/
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String dateActuel = dateFormat.format(date);
        String idCmi = metier.getIdCmi(idTrtCmi);
        String libCmi = metier.getLibCmiFromIdCmi(idCmi);
        String dateDeb = metier.getDateDeb(idCmi);
        String dateFin = metier.getDateFin(idCmi);
        
        //acces interdit dans une periode
        if(dateActuel.compareTo(dateDeb) < 0){
        	metier.deconnexion();
			request.setAttribute("dateDeb", dateDeb);
			request.getRequestDispatcher("depotNonCommence.jsp").forward(request, response);
		} else {
			if(dateActuel.compareTo(dateFin) > 0){
				metier.deconnexion();
				request.setAttribute("dateFin", dateFin);
				request.getRequestDispatcher("depotFerme.jsp").forward(request, response);
			} else {
				String codeRiNom = metier.getCodeRiNom(idUsr);
		        
		        //Piece communes
		        ArrayList<String> listPJO = metier.getListPJO(codeRiNom);
		    	ArrayList<String> listCodePJO = metier.getListCodePJO(codeRiNom);
		    	
		    	//Pices spécifiques
		    	ArrayList<String> listIdNom = metier.getListIdNom(codeEtape, codeVet);
		    	ArrayList<String> listPJS = metier.getListPJS(codeRiNom, listIdNom); 
				ArrayList<String> listCodePJS = metier.getListCodePJS(codeRiNom, listIdNom);
				
				//obtenir les fichier dans la bdd pour savoir s'il existe en systeme et bdd
				//ArrayList<String> listEmplacements = metier.getListEmplacements(idCmi);
				ArrayList<String> listEmplacementsForIdUsrIdCmi = metier.getListEmplacements(idCmi, idUsr);
				
				
				ArrayList<String> listPieces = new ArrayList<String>(listPJO);
				listPieces.addAll(listPJS);
				
				ArrayList<String> listCodes = new ArrayList<String>(listCodePJO);
				listCodes.addAll(listCodePJS);
				
				metier.deconnexion();
				request.setAttribute("pieces", listPieces);
				request.setAttribute("codes", listCodes);
				request.setAttribute("listEmplacements", listEmplacementsForIdUsrIdCmi);
				request.setAttribute("libCmi", libCmi);
				request.setAttribute("dateFin", dateFin);
				session.setAttribute("idCmi", idCmi);
				request.getRequestDispatcher("depot.jsp").forward(request, response);
			}
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