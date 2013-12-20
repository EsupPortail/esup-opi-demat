package com.tg_mvc.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tg_mvc.metier.Metier;
import com.tg_mvc.tools.FusionnerPDF;
import com.tg_mvc.tools.LoadProperties;

/**
 * servlet de telechargement d'un dossier pour un etudiant (toute la ligne)
 * @author root
 * @version 1.0
 */
public class TelechargementMultipleLigne_servlet extends AbstractServlets {


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
		HttpSession session = request.getSession(false);

		//recuperationdes parametres
		String nomEtudiant = request.getParameter("nomEtudiant");
		String idUsrEtudiant = request.getParameter("idUsrEtudiant");
		String idCmi = request.getParameter("idCmi");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
        String dateActuel = dateFormat.format(date);
        String dateFin = metier.getDateFin(idCmi);
		
		//recuperation des doonées
		String codeRi = metier.getCodeRi(idCmi);
		ArrayList<String> listCodeNomsPc = metier.getlistCodeNomsPc(codeRi);
		String codeEtape = metier.getCodeEtape(idCmi);
		String codeVet = metier.getCodeVet(idCmi);
		ArrayList<String> listIdNomPs = metier.getListIdNomPs(codeEtape, codeVet);
		ArrayList<String> listCodeNomPs = metier.getListCodeNomPs(listIdNomPs);
		ArrayList<String> listCodeFile = new ArrayList<String>(listCodeNomsPc) ;
		listCodeFile.addAll(listCodeNomPs);
		
		//filtrer les fichiers a afficher
		/*ArrayList<String> listFichiersAAffiche = null;
		String login = session.getAttribute("login").toString();
		String idSession = session.getId();
		if(metier.existeDansUPDConsul(login, idSession, idCmi)){
			listFichiersAAffiche = metier.getListFichiersAAffiche(idSession, login, idCmi);
		}
		System.out.println(listCodeFile);
		System.out.println(listFichiersAAffiche);
		listCodeFile = (ArrayList<String>) metier.intersect(listFichiersAAffiche, listCodeFile);
		System.out.println(listCodeFile);*/
		
		//recuperation des emplacements
		ArrayList<String> listEmplacements = metier.getListEmplacementsForIdUsrIdCmi(idUsrEtudiant, idCmi, listCodeFile);
		System.out.println(listEmplacements.size());
		ArrayList<String> listLiensRecommandation = metier.getListLiensRecommandationForIdUsr(idUsrEtudiant);
		listEmplacements.addAll(listLiensRecommandation);
		
		//Organisation et telechargement
		String lienAbsoluRes = new File(listEmplacements.get(0)).getParent()+"/res.pdf";
		File fullLienAbsoluRes = new File(lienAbsoluRes);
		
		if(!fullLienAbsoluRes.exists()) {
			
			ArrayList<String> pdfsPath = new ArrayList<String>();
			for(String emplacement : listEmplacements){
				File fullFile = new File(emplacement);
				String extention = "";
				if(fullFile.exists()){
					if(fullFile.length() > 0) {
						extention = fullFile.getName().substring(fullFile.getName().lastIndexOf(".") + 1).toLowerCase();
						if(extention.equals("pdf"))
							pdfsPath.add(emplacement);
						
						
					} else {
						String fichierCorrompu = getServletContext().getInitParameter("lienDossier") +"messageFichierCorrompu.pdf";
						extention = fullFile.getName().substring(fullFile.getName().lastIndexOf(".") + 1).toLowerCase();
						if(extention.equals("pdf"))
							pdfsPath.add(fichierCorrompu);
					}
					
				} 
			}
		
			if(pdfsPath.size() > 1 )
				if(!FusionnerPDF.fusionnerAvecPDFBox(pdfsPath, lienAbsoluRes, prop.getProperty("lienLibrairieFusionPdf")))
					FusionnerPDF.fusionnerAvecGs(pdfsPath, lienAbsoluRes);
			else 
				FusionnerPDF.Copier(pdfsPath, lienAbsoluRes);
			
			
			
		}
		
		
		//telecharger
		FileInputStream fileToDownload = new FileInputStream(lienAbsoluRes);
			
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
		
		//supprimer si la période des consultations est tjrs ouverte
		if(dateActuel.compareTo(dateFin) <= 0) {
			new File(lienAbsoluRes).delete();
		}
	
		return;
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)						
	throws IOException, ServletException{
			doGet(request, response);
	}
}
