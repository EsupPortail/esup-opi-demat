package com.tg_mvc.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tg_mvc.metier.Metier;
import com.tg_mvc.tools.LoadProperties;

/**
 * servlet de telechargement d'un ficheir pour un etudiant
 * @author root
 * @version 1.0
 */
public class Telechargement_servlet extends AbstractServlets {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)						
											throws IOException, ServletException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Properties prop = LoadProperties.load(getServletContext().getRealPath("/")+"/WEB-INF/classes/Message_fr.properties");
		Metier metier = new Metier(prop);
		metier.connexion();
		
		//out.println("lien : "+request.getParameter("lien"));
		//out.println("nomEtudiant : "+request.getParameter("nomEtudiant"));
		String lien = request.getParameter("lien");
		String nomEtudiant = request.getParameter("nomEtudiant");
		String codeEtape = request.getParameter("codeEtape");
		String codeVet = request.getParameter("codeVet");
		String[] tabExtentions = {".pdf"};
		for(int i = 0; i < tabExtentions.length; i++){
			String lienDossier = getServletContext().getInitParameter("lienDossier");
			String lienAbsolu = lienDossier+lien+tabExtentions[i];
			File fullFile = new File(lienAbsolu);
			if(fullFile.exists() && (metier.fileInBDD(lienAbsolu) || metier.recommandationInBDD(lienAbsolu))){
				String filePath = "";
				String fileName = "";
				FileInputStream fileToDownload = null;
				if(fullFile.length() <= 0) {
					filePath = getServletContext().getInitParameter("lienDossier") +"messageFichierCorrompu.pdf";
					fullFile = new File(filePath);
					fileName = fullFile.getName();
					fileToDownload = new FileInputStream(filePath);
				} else {
					filePath = lienAbsolu;
					fileName = fullFile.getName();
					fileToDownload = new FileInputStream(filePath);
				}
				//out.println("nom fichier : "+fileName.substring(0, fileName.lastIndexOf("."))+"_"+nomEtudiant+tabExtentions[i]);
				response.setContentType("application/octet-stream");
				response.setHeader("Content-Disposition", "attachment; filename="
						+ codeEtape +"-"+codeVet+"_"+fileName.substring(0, fileName.lastIndexOf("."))+"_"+nomEtudiant+tabExtentions[i]);
				response.setContentLength(fileToDownload.available());
				int c;
				while ((c = fileToDownload.read()) != -1) {
					out.write(c);
				}
				out.flush();
				out.close();
				fileToDownload.close();
				return;
			}
		}
		//out.println("ce fichier n'existe pas");
		/*RequestDispatcher dispatch = request.getRequestDispatcher("/interface");
		dispatch.forward(request, response);*/
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)						
	throws IOException, ServletException{
			doGet(request, response);
	}
}
