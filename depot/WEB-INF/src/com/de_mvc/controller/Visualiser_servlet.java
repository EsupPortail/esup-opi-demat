package com.de_mvc.controller;

import java.io.File;
import java.io.FileInputStream;
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

import com.de_mvc.tools.LoadProperties;
import com.de_mvc.metier.Metier;

/**
 * servlet de Visualisation
 * @author root
 * @version 1.0
 */
public class Visualiser_servlet extends AbstractServlets{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Override 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Properties prop = LoadProperties.load(getServletContext().getRealPath("/")+"/WEB-INF/classes/Message_fr.properties");
		Metier metier = new Metier(prop);
		metier.connexion();
		
		
		String numDossier = request.getParameter("numDossier");
		String codeEtape = request.getParameter("codeEtape");
		String codeVet = request.getParameter("codeVet");
		String codePj = request.getParameter("codePj");
		
		String[] tabExtentions = {".pdf"};
		for(int i = 0; i < tabExtentions.length; i++){
			String lienDossier = getServletContext().getInitParameter("lienDossier");
			String lienAbsolu = lienDossier+codeEtape+"-"+codeVet+"/"+numDossier+"/"+codePj+tabExtentions[i];
			File fullFile = new File(lienAbsolu);
			if(fullFile.exists()){
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
						+ codeEtape +"-"+codeVet+"_"+fileName.substring(0, fileName.lastIndexOf("."))+"_"+numDossier+tabExtentions[i]);
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
	}

	
	@Override 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		/*throw new ServletException("GET method used with "
		+ getClass().getName() + ": POST method required.");*/
		doGet(request, response);
	}
}