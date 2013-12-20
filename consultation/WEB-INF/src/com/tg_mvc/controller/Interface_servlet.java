package com.tg_mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.tg_mvc.tools.LoadProperties;

/**
 * 
 * @author root
 *
 */
public class Interface_servlet  extends AbstractServlets {


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
		//obtenir des parametres
		String idUsr = session.getAttribute("idUsr").toString();
		String idCmi = request.getParameter("idCmi");
		
		//obtenir les filtres
		//numero de la page (intialisation) + mise à jour
		int numPage = 1;
		if(request.getAttribute("numPage") != null)
			numPage = Integer.parseInt(request.getAttribute("numPage").toString());
		else
			if(request.getParameter("numPage") != null)
				numPage = Integer.parseInt(request.getParameter("numPage"));
		
		//nb eudiants par page
		int nbEtudiantsParPage = 25;
		if(request.getAttribute("nbEtudiantsParPage") != null)
			nbEtudiantsParPage = Integer.parseInt(request.getAttribute("nbEtudiantsParPage").toString());
		else
			if(request.getParameter("nbEtudiantsParPage") != null)
				nbEtudiantsParPage = Integer.parseInt(request.getParameter("nbEtudiantsParPage"));
		
		//Le type de filtrage, sera utiliser pour recuperer la nouvelle liste des etudiants selon traitment de referent dans cette idCmi
		//null si on arrive pour la 1ere fois, et autre apres ca
		String filtre = "";
		if(request.getAttribute("filtre") != null)//filtre selon traitement
			filtre = request.getAttribute("filtre").toString();
		else
			filtre = request.getParameter("filtre");
		
		String filtreAvis = "";
		if(request.getAttribute("filtreAvis") != null)
			filtreAvis = request.getAttribute("filtreAvis").toString();//filtre selon avis
		else
			filtreAvis = request.getParameter("filtreAvis");
		
		String filtreEtablissement = "";
		String login = session.getAttribute("login").toString();
		String idSession = session.getId();
		if(metier.existeDansUPDFiltreEtab(login, idSession, idCmi)) {
			filtreEtablissement = metier.getEtabAAffiche(idSession, login, idCmi);
		} else {
			if(request.getAttribute("filtreEtablissement") != null)
				filtreEtablissement = request.getAttribute("filtreEtablissement").toString();//filtre selon etablissement
			else
				filtreEtablissement = request.getParameter("filtreEtablissement");
		}
		
		
		//candidat recherche nom
		String rechercheNom = "";
		if(request.getParameter("rechercheNom") != null && request.getParameter("rechercheNom").trim().length() != 0)
			rechercheNom = request.getParameter("rechercheNom");
		else
			rechercheNom = "none";
		
		//candidat recherche id
		String rechercheNumDossier = "";
		if(request.getParameter("rechercheNumDossier") != null && request.getParameter("rechercheNumDossier").trim().length() != 0)
			rechercheNumDossier = request.getParameter("rechercheNumDossier");
		else
			rechercheNumDossier = "none";

		
		//obtenir des donnees de commission
		String libCmi = metier.getLibCmi(idCmi);
		String codeRi = metier.getCodeRi(idCmi);
		String codeEtape = metier.getCodeEtape(idCmi);
		String codeVet = metier.getCodeVet(idCmi);
		String idTrtCmi = metier.getIdTrtCmi(idCmi);
		String idLink = metier.getIdLink(idTrtCmi);
		
		
		//obtenir la liste des pieces communes
		ArrayList<String> listLibNomsPc = metier.getlistLibNomsPc(codeRi);
		ArrayList<String> listCodeNomsPc = metier.getlistCodeNomsPc(codeRi);
		Map<String, String> MapLibNomsPcLicNomsPc = metier.getMapLibNomsPcLicNomsPc(codeRi);
		
		//obtenir la liste des pieces specifiques
		ArrayList<String> listIdNomPs = metier.getListIdNomPs(codeEtape, codeVet);
		ArrayList<String> listCodeNomPs = metier.getListCodeNomPs(listIdNomPs);
		ArrayList<String> listLibNomPs = metier.getListLibNomPs(listIdNomPs);
		Map<String, String> MapLibNomsPsLicNomsPs = metier.getMapLibNomsPsLicNomsPs(listIdNomPs);
		
		//tous les fichiers
		ArrayList<String> listCodeFile = new ArrayList<String>(listCodeNomsPc) ;
		listCodeFile.addAll(listCodeNomPs);
		ArrayList<String> listNomFile = new ArrayList<String>(listLibNomsPc) ;
		listNomFile.addAll(listLibNomPs);
		ArrayList<String> listLicNomFile = new ArrayList<String>() ;
		for(String nomFile : listNomFile) {
			if(MapLibNomsPcLicNomsPc.containsKey(nomFile)) {
				listLicNomFile.add(MapLibNomsPcLicNomsPc.get(nomFile));
			} else {
				listLicNomFile.add(MapLibNomsPsLicNomsPs.get(nomFile));
			}
		}
	
		//obtenir la liste des avis possibles
		ArrayList<String> listLicNomAvis = metier.getlistLicNomAvis();
		
		//obtenir la list des etudiants
		ArrayList<String> listIdUsrEtudiant = metier.getListIdUsrEtudiant(idCmi);

		
		ArrayList<String> listCodeEtab = metier.getlistCodeEtabTrie(listIdUsrEtudiant);
		
		//si recherche nom candidat
		if(!rechercheNom.equals("none") && rechercheNom.length() >= 4) {
			listIdUsrEtudiant = metier.getListIdUsrEtudiantRechercheNom(rechercheNom, listIdUsrEtudiant);
		}
		
		//si recherche numDossier candidat
		if(!rechercheNumDossier.equals("none")) {
			listIdUsrEtudiant = metier.getListIdUsrEtudiantRechercheNumDossier(rechercheNumDossier, listIdUsrEtudiant);
		}
		
		//trier les etudiants en ordre alphabetique
		//ArrayList<String> listNomEtudiantTrie = metier.getListNomEtudiant(idCmi);
		ArrayList<String> listNomEtudiantTrie = metier.getListNomEtudiant(listIdUsrEtudiant);
		//ArrayList<String> listNumDossierTrie = metier.getListNumDossier(idCmi);
		ArrayList<String> listNumDossierTrie = metier.getListNumDossier(listIdUsrEtudiant);
		ArrayList<String> listIdUsrEtudiantTrie = listIdUsrEtudiant;
		
		
		//obtenir une map des candidats et leurs derniere etablissement
		Map<String, String> MapIdUsrEtudiantCodeEtab = metier.getMapIdUsrEtudiantCodeEtab(listIdUsrEtudiant);
		
		//obtenir la liste des code etablissements : sert dans les filtres
		Map<String, String> MapCodeEtabLibEtab = metier.getMapCodeEtabLibEtab(listCodeEtab);
		
		
		//list des etudiants ayant choisi un referent
		ArrayList<String> listIdUsrFromUPD_IND_REF = metier.getlistIdUsrFromUPD_IND_REF();
		
		///list des etudiants ayant recu une lettre de rec, et le lien de la lettre
		Map<String, ArrayList<String>> MapIdUsrLienRecommandation = metier.getMapIdUsrLienRecommandation(listIdUsrFromUPD_IND_REF);
		
		//obtenir les observtions par idUsrEtudiant
		Map<String, String> MapIdUsrEtudiantObservation = metier.getMapIdUsrEtudiantObservation(idUsr, idCmi);
		
		//obtenir les traitements par idUsrEtudiant
		Map<String, String> MapIdUsrEtudiantTraitement = metier.getMapIdUsrEtudiantTraitement(idUsr, idCmi);
		
		//obtenir les avis par idUsrEtudiant
		Map<String, String> MapIdUsrEtudiantAvis = metier.getMapIdUsrEtudiantAvis(listIdUsrEtudiant, idCmi);
		
		//obtenir la list d'emplacement des fichiers pour cette Cmi : sert a verifier si le fichier exit en bdd
		ArrayList<String> listEmplacements = metier.getListEmplacements(idCmi);
		
		//obtenir la liste des ficheirs par idUsrEtudiant
		Map<String, ArrayList<String>> MapIdUsrEmplacementsForIdCmi = metier.getMapIdUsrEmplacementsForIdCmi(listIdUsrEtudiant, listCodeFile, idCmi);
		
		Map<String, ArrayList<String>> MapCodeFileColonneFiles = metier.getMapCodeFileColonneFiles(listIdUsrEtudiant, listCodeFile, idCmi);
		
		
		//obtenir la liste des pieces a afficher
		//la 1ere fois on la mis à null pour eviter de ne rien afficher
		ArrayList<String> listFichiersAAffiche = null;
		if(metier.existeDansUPDConsul(login, idSession, idCmi)){
			listFichiersAAffiche = metier.getListFichiersAAffiche(idSession, login, idCmi);
		}
		
		//obtenir le filtre actuel et la list des etudiants à affiché
		ArrayList<String> listDesEtudiantsAAffiche = null;
		if(filtre == null || filtre.equals("Tout")) {
			filtre = "Tout";
		} else {
			if(filtre.equals("STATE.TRAITE")) {
				listDesEtudiantsAAffiche = metier.getListEtudiantTraite(idUsr, idCmi);
			}
			if(filtre.equals("STATE.NON_TRAITE")) {
				listDesEtudiantsAAffiche = metier.getListEtudiantNonTraitement(MapIdUsrEtudiantTraitement, listIdUsrEtudiant);
			}
			if(filtre.equals("STATE.EN_COURS_TRAITEMENT")) {
				listDesEtudiantsAAffiche = metier.getListEtudiantEnCoursTraitement(idUsr, idCmi);
			}
		}
		request.setAttribute("filtre", filtre);
		
		
		ArrayList<String> listDesEtudiantsAAfficheParCodeEtablissement = null;
		if(filtreEtablissement == null || filtreEtablissement.equals("Tout")) {
			filtreEtablissement = "Tout";
		} else {
			listDesEtudiantsAAfficheParCodeEtablissement = metier.listDesEtudiantsAAfficheParCodeEtab(MapIdUsrEtudiantCodeEtab, filtreEtablissement);
		}
		request.setAttribute("filtreEtablissement", filtreEtablissement);
		
		
		ArrayList<String> listDesEtudiantsAAfficheParAvis = null;
		if(filtreAvis == null || filtreAvis.equals("Tout")) {
			filtreAvis = "Tout";
		} else {
			listDesEtudiantsAAfficheParAvis = metier.listDesEtudiantsAAfficheParAvis(MapIdUsrEtudiantAvis, filtreAvis);
		}
		request.setAttribute("filtreAvis", filtreAvis);
		
		ArrayList<String> listIdUsrEtudiantSurPage = metier.listIdUsrEtdiantSurPage(listIdUsrEtudiantTrie, listDesEtudiantsAAffiche, /*listDesEtudiantsAAfficheParProvenance, */listDesEtudiantsAAfficheParCodeEtablissement, listDesEtudiantsAAfficheParAvis, filtre, /*filtreProvenance,*/ filtreEtablissement, filtreAvis);
		
		
		metier.deconnexion();
		request.setAttribute("idCmi", idCmi);
		request.setAttribute("libCmi", libCmi);
		request.setAttribute("codeEtape", codeEtape);
		request.setAttribute("codeVet", codeVet);
		request.setAttribute("listLibNomsPc", listLibNomsPc);
		request.setAttribute("listCodeNomsPc", listCodeNomsPc);
		request.setAttribute("MapLibNomsPcLicNomsPc", MapLibNomsPcLicNomsPc);
		request.setAttribute("listLibNomPs", listLibNomPs);
		request.setAttribute("listCodeNomPs", listCodeNomPs);
		request.setAttribute("MapLibNomsPsLicNomsPs", MapLibNomsPsLicNomsPs);
		request.setAttribute("listCodeFile", listCodeFile);
		request.setAttribute("listIdUsrEtudiantTrie", listIdUsrEtudiantTrie);
		request.setAttribute("listNomEtudiantTrie", listNomEtudiantTrie);
		request.setAttribute("listNumDossierTrie", listNumDossierTrie);
		request.setAttribute("listIdUsrFromUPD_IND_REF", listIdUsrFromUPD_IND_REF);
		request.setAttribute("MapIdUsrLienRecommandation", MapIdUsrLienRecommandation);
		request.setAttribute("MapIdUsrEtudiantObservation", MapIdUsrEtudiantObservation);
		request.setAttribute("MapIdUsrEtudiantTraitement", MapIdUsrEtudiantTraitement);
		request.setAttribute("MapIdUsrEtudiantAvis", MapIdUsrEtudiantAvis);
		request.setAttribute("MapIdUsrEtudiantCodeEtab", MapIdUsrEtudiantCodeEtab);
		request.setAttribute("listEmplacements", listEmplacements);
		request.setAttribute("MapIdUsrEmplacementsForIdCmi", MapIdUsrEmplacementsForIdCmi);
		request.setAttribute("MapCodeFileColonneFiles", MapCodeFileColonneFiles);
		request.setAttribute("MapCodeEtabLibEtab", MapCodeEtabLibEtab);
		request.setAttribute("listFichiersAAffiche", listFichiersAAffiche);
		request.setAttribute("listIdUsrEtudiantSurPage", listIdUsrEtudiantSurPage);
		request.setAttribute("listLicNomAvis", listLicNomAvis);
		request.setAttribute("numPage", numPage);
		request.setAttribute("nbEtudiantsParPage", nbEtudiantsParPage);
		request.setAttribute("rechercheNom", rechercheNom);
		request.setAttribute("rechercheNumDossier", rechercheNumDossier); 
		request.setAttribute("listNomFile", listNomFile);
		request.setAttribute("listLicNomFile", listLicNomFile);
		request.setAttribute("listCodeEtab", listCodeEtab);
		
		request.getRequestDispatcher("interface.jsp").forward(request, response);
	}
	

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)						
											throws IOException, ServletException{
		doGet(request, response);
	}
	
	

}
