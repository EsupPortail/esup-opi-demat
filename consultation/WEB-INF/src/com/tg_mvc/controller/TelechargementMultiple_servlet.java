package com.tg_mvc.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tg_mvc.tools.FusionnerPDF;
import com.tg_mvc.tools.LoadProperties;

/**
 * servlet de telechargement d'un dossier pour un etudiant (toute la ligne)
 * @author root
 * @version 1.0
 */
public class TelechargementMultiple_servlet extends AbstractServlets {


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

		
		//out.println("liens : "+request.getParameter("liens"));
		//out.println("nomEtudiant : "+request.getParameter("nomEtudiant"));
		String liens = request.getParameter("liens");
		String nomEtudiant = request.getParameter("nomEtudiant");
		String codeEtape = request.getParameter("codeEtape");
		String codeVet = request.getParameter("codeVet");
		String[] tabLien = liens.split("&");
		//out.print(tabLien.length);
		ArrayList<String> pdfsPath = new ArrayList<String>();
		String lienDossier = getServletContext().getInitParameter("lienDossier");
		
		
		for(int j = 0; j < tabLien.length; j++ ){
			String lien = tabLien[j];
			String lienAbsolu = lienDossier+lien+".pdf";
			File fullFile = new File(lienAbsolu);
			if(fullFile.exists()){
				//out.print("<br>"+lienAbsolu);
				pdfsPath.add(lienAbsolu);
			} 
		}
		
		String lienCommisionEtudiant = tabLien[0].substring(0, tabLien[0].lastIndexOf("/"));
		String lienAbsoluRes = lienDossier+lienCommisionEtudiant+"/res.pdf";
		//out.print(lienAbsoluRes);
		
		if(pdfsPath.size() > 1 )
			FusionnerPDF.fusionnerAvecPDFBox(pdfsPath, lienAbsoluRes, prop.getProperty("lienLibrairieFusionPdf"));
		else
			FusionnerPDF.Copier(pdfsPath, lienAbsoluRes);
		
		
		//telecharger
		File fullFile = new File(lienAbsoluRes);
		String filePath = lienAbsoluRes;
		
		//String fileName = fullFile.getName();
		FileInputStream fileToDownload = new FileInputStream(filePath);
			
		//out.println("nom fichier : "+fileName.substring(0, fileName.lastIndexOf("."))+"_"+nomEtudiant+tabExtentions[i]);
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; filename= Dossier_"+codeEtape+"-"+codeVet+"_"+nomEtudiant+".pdf");
		response.setContentLength(fileToDownload.available());
		int c;
		while ((c = fileToDownload.read()) != -1) { 
			out.write(c);
		}
		out.flush();
		out.close();
		fileToDownload.close();
		
		//supprimer
		fullFile.delete();
		
		return;
		
		/*RequestDispatcher dispatch = request.getRequestDispatcher("/interface");
		dispatch.forward(request, response);*/
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)						
	throws IOException, ServletException{
			doGet(request, response);
	}
}
