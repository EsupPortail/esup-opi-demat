package com.de_mvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.de_mvc.tools.LoadProperties;
import com.de_mvc.metier.Metier;


/**
 * servlet de rederiction vers modification.jsp avec le passage des attributs
 * @author root
 * @version 1.0
 */
public class Modification_servlet extends AbstractServlets {

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
		String idCmi = session.getAttribute("idCmi").toString();
		String idUsr = session.getAttribute("idUsr").toString();
		String libCmi = metier.getLibCmiFromIdCmi(idCmi);
		String dateFin = metier.getDateFin(idCmi);
		
		/****************************** verification des emplacement dans la bdd, et le systeme  ************************/
		String[] listeFichiers;
		String lienDossier = getServletContext().getInitParameter("lienDossier");
		File repertoire = new File(lienDossier + codeEtape + "-" + codeVet + "/" + numDossier + "/");
		if (repertoire.exists() && repertoire.list().length != 0) {
			// les codes de tout les fichiers sont dans le tableau listeFichiers
			listeFichiers = repertoire.list();
			
			//obtenir parmis les fichiers enregistrés que ceux qui sont en bdd
			ArrayList<String> fichiersExistEnBDD = new ArrayList<String>();
			for(int i =0; i < listeFichiers.length; i++){
				
				String emplacement = lienDossier+codeEtape+"-"+codeVet+"/"+ numDossier+"/"+listeFichiers[i];
				if(metier.fileInBDD(idCmi, idUsr, emplacement)) {
					fichiersExistEnBDD.add(listeFichiers[i]);
				}
			}
			//out.println(fichiersExistEnBDD);
			if(fichiersExistEnBDD.size() != 0){
				
				Map<String, String> MapNomCodeFichierNomFichier = metier.getMapLibFichierPourCodeFichier(fichiersExistEnBDD);
				
				request.setAttribute("dateFin", dateFin);
				request.setAttribute("libCmi", libCmi);
				request.setAttribute("MapNomCodeFichierNomFichier", MapNomCodeFichierNomFichier);
				request.setAttribute("listeFichiers", fichiersExistEnBDD);
				request.getRequestDispatcher("modification.jsp").forward(request, response);
			} else {
				metier.deconnexion();
				request.getRequestDispatcher("aucunFichier.jsp").forward(request, response);
			}
			
		} else {
			metier.deconnexion();
			request.getRequestDispatcher("aucunFichier.jsp").forward(request, response);
		}
		
		/****************************** verification des emplacement dans la bdd : annule temporairement  ************************/
/*		
		ArrayList<String> listCodeFichierDepose = metier.getListCodeFichierDeposeForIdCmiIdUsr(idCmi, idUsr);
		
		if(listCodeFichierDepose.size() != 0){
			
			Map<String, String> MapNomCodeFichierNomFichier = metier.getMapLibFichierPourCodeFichier(listCodeFichierDepose);
			out.println(MapNomCodeFichierNomFichier);
			
			request.setAttribute("MapNomCodeFichierNomFichier", MapNomCodeFichierNomFichier);
			request.setAttribute("listeFichiers", listCodeFichierDepose);
			request.getRequestDispatcher("modification.jsp").forward(request, response);
		} else {
			metier.deconnexion();
			request.getRequestDispatcher("aucunFichier.jsp").forward(request, response);
		}
*/		
		
		
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
