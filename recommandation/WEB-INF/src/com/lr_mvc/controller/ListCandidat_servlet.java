package com.lr_mvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lr_mvc.metier.Metier;
import com.lr_mvc.tools.LoadProperties;

/**
 * servlet de redirection vers la page de la liste des candidats listCandidats.jsp
 * @author root
 * @version 1.0
 */
public class ListCandidat_servlet extends AbstractServlets {


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
		
		String mail = session.getAttribute("adresseMail").toString();
		String nomRef = metier.getNomRef(mail);
		String prenomRef = metier.getPrenomRef(mail);
		String idRef = metier.getIdRef(mail);
		ArrayList<String> listIdUsr = metier.getListIdUsr(idRef);
		TreeMap<String, String> mapIdUsrNomUsr = new TreeMap<String, String>();
		//TreeMap<String, String> mapIdUsrNomFile = new TreeMap<String, String>();
		for(String s : listIdUsr){
			mapIdUsrNomUsr.put(s, metier.getNomUsr(s));
			//mapIdUsrNomFile.put(s, commande.getNomFile(idRef, s));
		}
		
		//out.print(nomRef+prenomRef+mail+idRef+listIdUsr+mapIdUsrNomUsr.toString());
		
		
		session.setAttribute("nomRef", nomRef);
		session.setAttribute("prenomRef", prenomRef);
		request.setAttribute("nomRef", nomRef);
		request.setAttribute("prenomRef", prenomRef);
		request.setAttribute("idRef", idRef);
		request.setAttribute("mapIdUsrNomUsr", mapIdUsrNomUsr);
		//request.setAttribute("mapIdUsrNomFile", mapIdUsrNomFile);
		
		
		metier.deconnexion();
		request.getRequestDispatcher("listCandidat.jsp").forward(request, response);
		
		
	}
	



	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)						
											throws IOException, ServletException{
		doGet(request, response);
	}

}