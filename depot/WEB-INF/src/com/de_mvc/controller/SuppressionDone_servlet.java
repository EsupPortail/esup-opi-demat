package com.de_mvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.de_mvc.tools.LoadProperties;
import com.de_mvc.metier.Metier;

/**
 * servlet de suppression d'un fichier
 * @author root
 * @version 1.0
 */
public class SuppressionDone_servlet extends AbstractServlets {
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
		String numDossier = session.getAttribute("numDossier").toString();
		String codeEtape = session.getAttribute("codeEtape").toString();
		String codeVet = session.getAttribute("codeVet").toString();
		String idUsr = session.getAttribute("idUsr").toString();
		String idCmi = session.getAttribute("idCmi").toString();
		String idFichier = request.getParameter("idFichier");
		String lienDossier = getServletContext().getInitParameter("lienDossier");
		
		//out.println("<h1>"+session.getAttribute("nomUsr")+"</h1><br>");
		
		//String[] listeFichiers;
		File repertoire = new File(lienDossier + codeEtape + "-" + codeVet + "/" + numDossier + "/");
		//listeFichiers = repertoire.list();
	
		String nomAbsoluFichier = repertoire+"/"+idFichier;
		File fullFile = new File(nomAbsoluFichier);
		String nomFichier = "";
		if(fullFile.exists()){
			/************************** obtenir le idNom, et le nomdufichier **************************************/
			String idNom = metier.getIdNom(fullFile.getName().substring(0, fullFile.getName().lastIndexOf(".")));
			nomFichier = metier.getNomFile(fullFile.getName().substring(0, fullFile.getName().lastIndexOf(".")));
			
			/*********************** supprimer de la bdd *************************************/
			if(fullFile.delete()) //suppression physique
				metier.delFile(idNom, idCmi, idUsr);
			
		}
		
		//supprimer le repertoire s'il est vide
		if(repertoire.list().length == 0)
			repertoire.delete();
		
		metier.deconnexion();
		request.setAttribute("nomFichier", nomFichier);
		request.getRequestDispatcher("suppressionDone.jsp").forward(request, response);
		//out.println("le fichier "+fullFile.getName()+" a bien etait supprimer, cliquez <a href=\"modification\">ici</a> pour retourner");
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
}
