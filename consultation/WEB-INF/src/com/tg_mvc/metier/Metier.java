package com.tg_mvc.metier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import java.util.Map.Entry;
import com.tg_mvc.DAO.CommandesBDD;
import com.tg_mvc.DAO.ImplementCommandes;
import com.tg_mvc.IntroWebService.EtablissementApogee;

/**
 * Class contenant les fonctions de traitement des données
 * @author root
 *
 */
public class Metier {
	
	private Properties prop;
	private String name;
	private String driver;
	private String user;
	private String code;
	private CommandesBDD commande;
	
	/**
	 * Constructeur
	 * @param properties
	 */
	public Metier(Properties properties) {
		commande = new ImplementCommandes();
		prop = properties;
		name = prop.getProperty("nameDriver");
		driver = prop.getProperty("driver");
		user = prop.getProperty("user");
		code = prop.getProperty("code");
	}
	
	/**
	 * connexion à la BDD
	 */
	public void connexion() {
		commande.ConnectionBDD(name, driver, user, code);
	}
	
	/**
	 * deconnexion de la bdd
	 */
	public void deconnexion() {
		commande.deconnexion();
	}
	
	/**
	 * verif existance login
	 * @param login
	 * @return boolean
	 */
	public boolean verifLogin(String login) {
		return commande.verifLogin(login);
	}

	/**
	 * obtenir id_usr a partir du login
	 * @param login
	 * @return id_usr
	 */
	public String getIdUsr(String login) {
		return commande.getIdUsr(login);
	}
	
	/**
	 * obtenir dispName a patir du login
	 * @param login
	 * @return dispName
	 */
	public String getDispName(String login) {
		return commande.getDispName(login);
	}
	
	/**
	 * obtenir id_profile a patir de id_usr
	 * @param idUsr
	 * @return id_profile
	 */
	public String getIdProfile(String idUsr) {
		return commande.getIdProfile(idUsr);
	}
	
	/**
	 * obtenir la list des id_cmi selon id_usr, et id_profile (table memeber)
	 * @param idUsr
	 * @param idProfile
	 * @return list des id_cmi
	 */
	public ArrayList<String> getIdCmis(String idUsr, String idProfile){
		return commande.getIdCmis(idUsr, idProfile);
	}
	
	/**
	 * obtenir la list des id_cmi selon id_usr, et id_profile (table righthOnCmi)
	 * @param idUsr
	 * @param idProfile
	 * @return  list des id_cmi
	 */
	public  ArrayList<String> getIdCmisFromRightOnCmi(String idUsr, String idProfile){
		return commande.getIdCmisFromRightOnCmi(idUsr, idProfile);
	}
	
	/**
	 * obtenir la list des id_cmi selon id_usr, et id_profile (table commission)
	 * @param idUsr
	 * @param idProfile
	 * @return  list des id_cmi
	 */
	public  ArrayList<String> getAllIdCmis(String idUsr, String idProfile){
		return commande.getAllIdCmis(idUsr, idProfile);
	}
	
	/**
	 * obtenir la list des id_cmi en sevice
	 * @return list des id_cmi
	 */
	public ArrayList<String> getlistIdCmiEnService() {
		return commande.getlistIdCmiEnService();
	}
	
	/**
	 * obtenir list des lib_cmi pour les list id_cmi
	 * @param listIdCmis
	 * @return list des lib_cmi
	 */
	public ArrayList<String> getLibCmis(ArrayList<String> listIdCmis) {
		return commande.getLibCmis(listIdCmis);
	}
	
	/**
	 * obtenir list des code_cmi pour les list id_cmi
	 * @param listIdCmis
	 * @return list des code_cmi
	 */
	public ArrayList<String> getCodeCmis(ArrayList<String> listIdCmis) {
		return commande.getCodeCmis(listIdCmis);
	}
	
	/**
	 * obtenir lib_cmi a partir de id_cmi
	 * @param idCmi
	 * @return
	 */
	public String getLibCmi(String idCmi) {
		return commande.getLibCmi(idCmi);
	}
	
	/**
	 * obtenir code_ri a partir de id_cmi
	 * @param idCmi
	 * @return code_ri
	 */
	public String getCodeRi(String idCmi) {
		return commande.getCodeRi(idCmi);
	}
	
	/**
	 * obtenir list lib_nom des pieces communes selon code_ri
	 * @param codeRi
	 * @return list lib_nom des pieces communes
	 */
	public ArrayList<String> getlistLibNomsPc(String codeRi) {
		return commande.getlistLibNomsPc(codeRi);
	}
	
	
	
	/**
	 * obtenir uen map de lib_nom et lic_nom des pieces communes
	 * @param codeRi
	 * @return obtenir uen map de lib_nom et lic_nom
	 */
	public Map<String, String> getMapLibNomsPcLicNomsPc(String codeRi) {
		return commande.getMapLibNomsPcLicNomsPc(codeRi);
	}
	
	/**
	 * obtenir list des code_nom des pieces communes
	 * @param codeRi
	 * @return list des code_nom des pieces communes
	 */
	public ArrayList<String> getlistCodeNomsPc(String codeRi) {
		return commande.getlistCodeNomsPc(codeRi);
	}
	
	/**
	 * obtenir list des code_etapes selon id_cmi
	 * @param idCmi
	 * @return list des code_etapes
	 */
	public ArrayList<String> getlistCodeEtapes(String idCmi) {
		return commande.getlistCodeEtapes(idCmi);
	}
	
	/**
	 * obtenir list des com_vet selon id_cmi
	 * @return list des com_vet
	 */
	public ArrayList<String> getlistCodeVets(String idCmi) {
		return commande.getlistCodeVets(idCmi);
	}
	
	/**
	 * obtenir la liste possible des avis
	 * @return list possibles des avis
	 */
	public ArrayList<String> getlistLicNomAvis() {
		return commande.getlistLicNomAvis();
	}
	
	/**
	 * obtenir une map des idNoms des pieces spécifiques pour chaque codeEtape
	 * @param listCodeEtapes
	 * @param listCodeVets
	 * @return map des idNoms des pieces spécifiques
	 */
	public Map<String, ArrayList<String>> getMapCodeEtapeIdNomPs(ArrayList<String> listCodeEtapes, ArrayList<String> listCodeVets) {
		return commande.getMapCodeEtapeIdNomPs(listCodeEtapes, listCodeVets);
	}
	
	/**
	 * obtenir une map des codeNoms des pieces spécifiques pour chaque codeEtape
	 * @param MapCodeEtapeIdNomPs
	 * @return map des codeNoms des pieces spécifiques
	 */
	public Map<String, ArrayList<String>> getMapCodeEtapeCodeNomPs(Map<String, ArrayList<String>> MapCodeEtapeIdNomPs) {
		return commande.getMapCodeEtapeCodeNomPs(MapCodeEtapeIdNomPs);
	}
	
	/**
	 * obtenir une map des libNoms des pieces spécifiques pour chaque codeEtape
	 * @param MapCodeEtapeIdNomPs
	 * @return obtenir une map des libNoms des pieces spécifiques
	 */
	public Map<String, ArrayList<String>> getMapCodeEtapeLibNomPs(Map<String, ArrayList<String>> MapCodeEtapeIdNomPs) {
		return commande.getMapCodeEtapeLibNomPs(MapCodeEtapeIdNomPs);
	}
	
	/**
	 * obtenir map de lib_nom et lic_nom des pieces specifiques
	 * @param mapCodeEtapeIdNomPs
	 * @return map de lib_nom et lic_nom des pieces specifiques
	 */
	public Map<String, String> getMapLibNomsPsLicNomsPs(Map<String, ArrayList<String>> mapCodeEtapeIdNomPs) {
		return commande.getMapLibNomsPsLibNomsPs(mapCodeEtapeIdNomPs);
	}
	
	public Map<String, String> getMapLibNomsPsLicNomsPs(ArrayList<String> listIdNomPs) {
		Map<String, String> MapLibNomsPsLicNomsPs = new TreeMap<String, String>();
		for(String idNomPs : listIdNomPs) {
			String libNomPs = commande.getLibNomPs(idNomPs);
			String licNomPs = commande.getLicNomPs(idNomPs);
			if(licNomPs != null)
				MapLibNomsPsLicNomsPs.put(libNomPs, licNomPs);
			else
				MapLibNomsPsLicNomsPs.put(libNomPs, libNomPs);
		}
		return MapLibNomsPsLicNomsPs;
	}
	
	/**
	 * obtenir une map des idUsrEtudiant pour chaque etape
	 * @param listCodeEtapes
	 * @param listCodeVets
	 * @return map des idUsrEtudiant pour chaque etape
	 */
	public Map<String, ArrayList<String>> getMapCodeEtapeIdUsrEtudiant(ArrayList<String> listCodeEtapes, ArrayList<String> listCodeVets) {
		return commande.getMapCodeEtapeIdUsrEtudiant(listCodeEtapes, listCodeVets);
	}
	
	public ArrayList<String> getListNomEtudiant(ArrayList<String> listIdUsrEtudiant) {
		ArrayList<String> listNomEtudiant = new ArrayList<String>();
		for(String idUsrEtudiant : listIdUsrEtudiant) {
			String nomEtudiant = commande.getNomEtudiant(idUsrEtudiant);
			if(nomEtudiant != null) 
				listNomEtudiant.add(nomEtudiant);
			else
				listNomEtudiant.add("ERROR");
		}
		return listNomEtudiant;
	}
	
	public ArrayList<String> getListNomEtudiant(String idCmi) {
		return commande.getListNomEtudiant(idCmi);
	}
	
	public ArrayList<String> getListNumDossier(String idCmi) {
		return commande.getListNumDossierEtudiant(idCmi);
	}
	
	/**
	 * obtenir les nom des etudiants pour chaque etape
	 * @param MapCodeEtapeIdUsrEtudiant
	 * @return nom des etudiants pour chaque etape
	 */
	public Map<String, ArrayList<String>> getMapCodeEtapeNomEtudiant(Map<String, ArrayList<String>> MapCodeEtapeIdUsrEtudiant) {
		return commande.getMapCodeEtapeNomEtudiant(MapCodeEtapeIdUsrEtudiant);
	}
	
	public ArrayList<String> getListNumDossier(ArrayList<String> listIdUsrEtudiant) {
		ArrayList<String> listNumDossier = new ArrayList<String>();
		for(String idUsrEtudiant : listIdUsrEtudiant) {
			String numDossier = commande.getNumDossier(idUsrEtudiant);
			if(numDossier != null) 
				listNumDossier.add(numDossier);
			else
				listNumDossier.add("ERROR");
		}
		return listNumDossier;
	}

	
	/**
	 * obtenir les num dossiers des etudiants pour chaque etape
	 * @param MapCodeEtapeIdUsrEtudiant
	 * @return num dossiers des etudiants pour chaque etape
	 */
	public Map<String, ArrayList<String>> getMapCodeEtapeNumDossier(Map<String, ArrayList<String>> MapCodeEtapeIdUsrEtudiant) {
		return commande.getMapCodeEtapeNumDossier(MapCodeEtapeIdUsrEtudiant);
	}
	
	/**
	 * obtenir id_trt_cmi selon id_cmi
	 * @param idCmi
	 * @return id_trt_cmi
	 */
	public String getIdTrtCmi(String idCmi) {
		return commande.getIdTrtCmi(idCmi);
	}
	
	/**
	 * obtenir id_link pour un id_trt_cmi
	 * @param idTrtCmi
	 * @return id_link
	 */
	public String getIdLink(String idTrtCmi) {
		return commande.getIdLink(idTrtCmi);
	}
	
	/**
	 * obtenir l'etat du dossier des candidat pour une commission
	 * @param idLink
	 * @return l'etat du dossier des candidat
	 */
	public Map<String, String> getMapIdUsrDossierComplet(String idLink) {
		return commande.getMapIdUsrDossierComplet(idLink);
	}
	
	/**
	 * obtenir la liste des idUsr qui ont indiqué un referent
	 * @return liste des idUsr qui ont indiqué un referent
	 */
	public ArrayList<String> getlistIdUsrFromUPD_IND_REF() {
		return commande.getlistIdUsrFromUPD_IND_REF();
	}
	
	/**
	 * obtenir une map des path des lettres de recommandation par condidat
	 * @param listIdUsrFromUPD_IND_REF
	 * @return map des path des lettres de recommandation par condidat
	 */
	public Map<String, ArrayList<String>> getMapIdUsrLienRecommandation(ArrayList<String> listIdUsrFromUPD_IND_REF) {
		return commande.getMapIdUsrLienRecommandation(listIdUsrFromUPD_IND_REF);
	}
	
	/**
	 * get List recommandations for idUsr
	 * @param idUsr
	 * @return
	 */
	public ArrayList<String> getListLiensRecommandationForIdUsr(String idUsr) {
		ArrayList<String> listIdUsr = new ArrayList<String>();
		listIdUsr.add(idUsr);
		return commande.getMapIdUsrLienRecommandation(listIdUsr).get(idUsr);
	}
	
	/**
	 * obtenir la liste des idUsr qui ont rien depose
	 * @return liste des idUsr qui ont rien depose
	 */
	public ArrayList<String> getlistIdUsrNoFileUploaded() {
		return commande.getlistIdUsrNoFileAlireUploaded();
	}
	
	/**
	 * obtenir la liste des idUsr qui ont rien depose pour cette cmi
	 * @return liste des idUsr qui ont rien depose
	 */
	public ArrayList<String> getlistIdUsrNoFileUploadedForIdCmi(String idCmi) {
		return commande.getlistIdUsrNoFileAlireUploadedForIdCmi(idCmi);
	}
	
	/**
	 * obtenir observation par etudiant dans une commission
	 * @param idUsr
	 * @param idCmi
	 * @return observation par etudiant dans une commission
	 */
	public Map<String, String> getMapIdUsrEtudiantObservation(String idUsr, String idCmi) {
		return commande.getMapIdUsrEtudiantObservation(idUsr, idCmi);
	}
	
	/**
	 * obtenir traitement par etudiant dans une commission
	 * @param idUsr
	 * @param idCmi
	 * @return traitement par etudiant dans une commission
	 */
	public Map<String, String> getMapIdUsrEtudiantTraitement(String idUsr,String idCmi) {
		return commande.getMapIdUsrEtudiantTraitement(idUsr, idCmi);
	}
	
	/**
	 * obtenir la list des candidat traités pour une commission par un gestionnaire
	 * @param idUsr
	 * @param idCmi
	 * @return list des candidat traités pour une commission par un gestionnaire
	 */
	public ArrayList<String> getListEtudiantTraite(String idUsr, String idCmi) {
		return commande.getListEtudiantTraite(idUsr, idCmi);
	}
	
	/**
	 * obtenir la list des candidats en cours de traitement pour une commission par un gestionnaire
	 * @param idUsr
	 * @param idCmi
	 * @return list des candidats en cours de traitement pour une commission par un gestionnaire
	 */
	public ArrayList<String> getListEtudiantEnCoursTraitement(String idUsr, String idCmi) {
		return commande.getListEtudiantEnCoursTraitement(idUsr, idCmi);
	}
	
	/**
	 * obtenir la list des emplacement des fichiers pour un idCmi
	 * @param idCmi
	 * @return list des emplacement des fichiers pour un idCmi
	 */
	public ArrayList<String> getListEmplacements(String idCmi) {
		return commande.getListEmplacements(idCmi);
	}
	
	/**
	 * verifier si le consultant a deja enregistrer une consultation
	 * @param login
	 * @param idSession
	 * @param idCmi
	 * @return boolean
	 */
	public boolean existeDansUPDConsul(String login, String idSession, String idCmi) {
		return commande.existeDansUPDConsul(login, idSession, idCmi);
	}
	
	public boolean existeDansUPDFiltreEtab(String login, String idSession, String idCmi) {
		return commande.existeDansUPDFiltreEtab(login, idSession, idCmi);
	}
	
	/**
	 * obtenir list des fichiers a afficher
	 * @param idSession
	 * @param login
	 * @param idCmi
	 * @return list des fichiers a afficher
	 */
	public ArrayList<String> getListFichiersAAffiche(String idSession, String login, String idCmi) {
		return commande.getListFichiersAAffiche(idSession, login, idCmi);
	}
	
	/**
	 * insertion des fichiers a afficher pour le gestionnaire
	 * @param idSession
	 * @param login
	 * @param codeNomFichiers
	 * @param idCmi
	 * @param sessionStartTimeSimpleFormat
	 */
	public void insertFichiersAAffiche(String idSession, String login, String codeNomFichiers, String idCmi, String sessionStartTimeSimpleFormat) {
		commande.insertFichiersAAffiche(idSession, login, codeNomFichiers, idCmi, sessionStartTimeSimpleFormat);
	}
	
	/**
	 * mettre a jour les fichiers a afficher pour getionnaire
	 * @param idSession
	 * @param login
	 * @param codeNomFichiers
	 * @param idCmi
	 * @param sessionStartTimeSimpleFormat
	 */
	public void updateFichiersAAffiche(String idSession, String login, String codeNomFichiers, String idCmi, String sessionStartTimeSimpleFormat) {
		commande.updateFichiersAAffiche(idSession, login, codeNomFichiers, idCmi, sessionStartTimeSimpleFormat);
	}
	
	/**
	 * verifier si une observation ou un traitement a deja ete deposer par un member dans une commission
	 * @param idUsr
	 * @param idUsrEtudiant
	 * @param idCmi
	 * @return boolean
	 */
	public boolean ligneExist(String idUsr, String idUsrEtudiant, String idCmi) {
		return commande.ligneExist(idUsr, idUsrEtudiant, idCmi);
	}
	
	/**
	 * mettre à jour observation et traitement pour un etudiant
	 * @param idUsr
	 * @param idUsrEtudiant
	 * @param idCmi
	 * @param traitement
	 * @param observation
	 */
	public void updateObsTrait(String idUsr, String idUsrEtudiant, String idCmi, String traitement, String observation) {
		commande.updateObsTrait(idUsr, idUsrEtudiant, idCmi, traitement, observation);
	}
	
	
	/**
	 * insertion observation et traitement pour un etudiant
	 * @param idUsr
	 * @param idUsrEtudiant
	 * @param idCmi
	 * @param traitement
	 * @param observation
	 */
	public void  insertObsTrait(String idUsr, String idUsrEtudiant, String idCmi, String traitement, String observation) {
		commande.insertObsTrait(idUsr, idUsrEtudiant, idCmi, traitement, observation);
	}
	
	/**
	 * obtenir map d'étudians avec lien fichiers deposees
	 * @param listIdUsr
	 * @param listCodeFile
	 * @param idCmi
	 * @return
	 */
	public Map<String, ArrayList<String>>  getMapIdUsrEmplacementsForIdCmi(ArrayList<String> listIdUsr, ArrayList<String> listCodeFile, String idCmi) {
		Map<String, ArrayList<String>> MapIdUsrEmplacements = new TreeMap<String, ArrayList<String>>();

		for (String idUsr : listIdUsr) {
			MapIdUsrEmplacements.put(idUsr, new ArrayList<String>());
			for(String codeFile : listCodeFile) {
				String emplacement = commande.EmplacementCodeFile(idUsr, idCmi, codeFile);
				if(emplacement != null)
					MapIdUsrEmplacements.get(idUsr).add(emplacement);
			}
		}
		
		return MapIdUsrEmplacements;
	}
	
	/**
	 * obtenir liste emplacement pour idUsr dans idcmi
	 * @param listIdUsr
	 * @param idCmi
	 * @return
	 */
	public ArrayList<String>  getListEmplacementsForIdUsrIdCmi(String idUsr, String idCmi, ArrayList<String> listCodeFile) {
		ArrayList<String> IdUsrEmplacements = new ArrayList<String>();
		
		for(String codeFile : listCodeFile) {
			String emplacement = commande.EmplacementCodeFile(idUsr, idCmi, codeFile);
			if(emplacement != null)
				IdUsrEmplacements.add(emplacement);
		}
		
		return IdUsrEmplacements;
	}
	
	/**
	 * obtenir map de codeFile et liste emplacements pour id_cmi
	 * @param listIdUsr
	 * @param listCodeFile
	 * @param idCmi
	 * @return
	 */
	public Map<String, ArrayList<String>> getMapCodeFileColonneFiles(ArrayList<String> listIdUsr, ArrayList<String> listCodeFile, String idCmi) {
		Map<String, ArrayList<String>> MapCodeFileEmplacements = new TreeMap<String, ArrayList<String>>();
		for(String codeFile : listCodeFile) {
			MapCodeFileEmplacements.put(codeFile, new ArrayList<String>());
			for (String idUsr : listIdUsr) {
				String emplacement = commande.EmplacementCodeFile(idUsr, idCmi, codeFile);
				if(emplacement != null)
					MapCodeFileEmplacements.get(codeFile).add(emplacement);
			}
		}
		return MapCodeFileEmplacements;
	}
	
	/**
	 * verifier si un fichier a ete depose
	 * @param lienAbsolu
	 * @return boolean
	 */
	public boolean fileInBDD(String lienAbsolu) {
		return commande.fileInBDD(lienAbsolu);
	}
	
	/**
	 * verifier si un fichier a ete depose
	 * @param lienAbsolu
	 * @return boolean
	 */
	public boolean recommandationInBDD(String lienAbsolu) {
		return commande.recommandationInBDD(lienAbsolu);
	}
	
	/**
	 * obtenir la liste des commissions en service pour un idUsr
	 * @param listIdCmis
	 * @param listIdCmiEnService
	 * @return listIdCmisEnServicePourLeIdUsr
	 */
	public ArrayList<String> getlistIdCmisEnServicePourLeIdUsr(ArrayList<String> listIdCmis, ArrayList<String> listIdCmiEnService){
		ArrayList<String> listIdCmisEnServicePourLeIdUsr = new ArrayList<String>();
		for(String s : listIdCmis){
			if(listIdCmiEnService.contains(s))
				 listIdCmisEnServicePourLeIdUsr.add(s);
		}
		return  listIdCmisEnServicePourLeIdUsr;
	}
	
	/**
	 * obtenir la liste des condidat selon provenance
	 * @param MapIdUsrEtudiantProvenance
	 * @param provenance
	 * @return listDesEtudiantsAAfficheParProvenance
	 */
	public ArrayList<String> listDesEtudiantsAAfficheParProvenance(Map<String, String> MapIdUsrEtudiantProvenance, String provenance) {
		ArrayList<String> listDesEtudiantsAAfficheParProvenance = new ArrayList<String>();
		for(Map.Entry<String, String> e : MapIdUsrEtudiantProvenance.entrySet()){
			if(e.getValue().equals(provenance)){
				listDesEtudiantsAAfficheParProvenance.add(e.getKey());
			}
		}
		return listDesEtudiantsAAfficheParProvenance;
	}

	/**
	 * fonction retourne une map des etudiants (idUsr) et si leurs dossier est complet
	 * Prédicat : à partir d'ici on considére que pour une commision il correspond une seule étape.
	 * prédicat2 : tous les fichier sont obligatoires à part les recommandations des referent
	 * @param listCodeEtapes
	 * @param MapCodeEtapeIdUsrEtudiant
	 * @param listIdNomsPc
	 * @param MapCodeEtapeIdNomPs
	 * @param commande
	 * @param idCmi
	 * @return MapIdUsrDossierComplet
	 */
	public static Map<String, Boolean> getMapIdUsrDossierComplet(ArrayList<String> listCodeEtapes, Map<String
			, ArrayList<String>> MapCodeEtapeIdUsrEtudiant, ArrayList<String> listIdNomsPc
			, Map<String, ArrayList<String>> MapCodeEtapeIdNomPs, CommandesBDD commande, String idCmi){
		
		Map<String, Boolean> MapIdUsrDossierComplet = new TreeMap<String, Boolean>();
		
		for(String s : listCodeEtapes){
			for (String s2 : MapCodeEtapeIdUsrEtudiant.get(s)){
				boolean complet = true;
				ArrayList<String> listTypePieceJustif = commande.getlistTypePieceJustif(s2, idCmi);
				// parcours des pieces communes
				for(String s3 : listIdNomsPc){
					if(!listTypePieceJustif.contains(s3)){
						MapIdUsrDossierComplet.put(s2, false);
						complet = false;
					}
				}
				// parcours des pieces specifiques
				for(String s3 : MapCodeEtapeIdNomPs.get(s)){
					if(!listTypePieceJustif.contains(s3)){
						MapIdUsrDossierComplet.put(s2, false);
						complet = false;
					}
				}
				if(complet)
					MapIdUsrDossierComplet.put(s2, true);
			}
		}
		
		return MapIdUsrDossierComplet;
		
	}
	
	public ArrayList<String> trierLesNomEtudiants(ArrayList<String> listNomEtudiant) {
		ArrayList<String> listNomEtudiantsTrie = (ArrayList<String>) listNomEtudiant.clone();
		Collections.sort(listNomEtudiantsTrie);
		return listNomEtudiantsTrie;
	}
	
	public ArrayList<String> trierIdUsrEtudiants(ArrayList<String> listIdUsrEtudiant, ArrayList<String> listNomEtudiant, ArrayList<String> listNomEtudiantTrie) {
		ArrayList<String> listIdUsrTrie = new ArrayList<String>();
		for(String nomEtudiant : listNomEtudiantTrie) {
			int index = listNomEtudiant.indexOf(nomEtudiant);
			String idUsrEtudiantAIndex = listIdUsrEtudiant.get(index);
			listIdUsrTrie.add(idUsrEtudiantAIndex);
		}
		return listIdUsrTrie;
	}
	
	public ArrayList<String> trierNumDossier(ArrayList<String> listNumDossier, ArrayList<String> listNomEtudiant, ArrayList<String> listNomEtudiantTrie) {
		ArrayList<String> listNumDossierTrie = new ArrayList<String>();
		for(String nomEtudiant : listNomEtudiantTrie) {
			int index = listNomEtudiant.indexOf(nomEtudiant);
			String idUsrEtudiantAIndex = listNumDossier.get(index);
			listNumDossierTrie.add(idUsrEtudiantAIndex);
		}
		return listNumDossierTrie;
	}
	
	/**
	 * trier les nom des candidats par ordre alphabetique 
	 * @param MapCodeEtapeIdUsrEtudiant
	 * @return MapCodeEtapeIdUsrEtudiant
	 */
	public static Map<String, ArrayList<String>> trierLesEtudiants(Map<String, ArrayList<String>> MapCodeEtapeIdUsrEtudiant){
		for(Map.Entry<String, ArrayList<String>> e : MapCodeEtapeIdUsrEtudiant.entrySet()){
			Collections.sort(MapCodeEtapeIdUsrEtudiant.get(e.getKey()), Collections.reverseOrder());
		}
		return MapCodeEtapeIdUsrEtudiant;
	}
	
	public Map<String, String> getMapIdUsrEtudiantProvenance(ArrayList<String> listIdUsrEtudiant) {
		Map<String, String> MapIdUsrEtudiantProvenance = new TreeMap<String, String>();
		for(String idUsrEtudiant : listIdUsrEtudiant){
			String typeCurSco = commande.getTypeCurSco(idUsrEtudiant);
			if(typeCurSco != null){
				if(typeCurSco.equals("CUR_R1")){
					MapIdUsrEtudiantProvenance.put(idUsrEtudiant, prop.getProperty("dauphine"));
				} else {
					String libEtbEtrCurExt = commande.getLibEtbEtrCurExt(idUsrEtudiant);
					if(libEtbEtrCurExt == null){
						MapIdUsrEtudiantProvenance.put(idUsrEtudiant, prop.getProperty("france"));
					} else {
						MapIdUsrEtudiantProvenance.put(idUsrEtudiant, prop.getProperty("etranger"));
					}
				}
			} else {
				MapIdUsrEtudiantProvenance.put(idUsrEtudiant, "ERROR");
			}
			
		}
		return MapIdUsrEtudiantProvenance;
	}
	
	/**
	 * obtenir une map des candidats et leurs derniere provenance
	 * @param MapCodeEtapeIdUsrEtudiant
	 * @param commande
	 * @return MapIdUsrEtudiantProvenance
	 */
	public Map<String, String> getMapIdUsrEtudiantProvenance(Map<String, ArrayList<String>> MapCodeEtapeIdUsrEtudiant){
		Map<String, String> MapIdUsrEtudiantProvenance = new TreeMap<String, String>();
		for(Map.Entry<String, ArrayList<String>> e : MapCodeEtapeIdUsrEtudiant.entrySet()){
			for(String idUsrEtudiant : MapCodeEtapeIdUsrEtudiant.get(e.getKey())){
				String typeCurSco = commande.getTypeCurSco(idUsrEtudiant);
				if(typeCurSco.equals("CUR_R1")){
					MapIdUsrEtudiantProvenance.put(idUsrEtudiant, prop.getProperty("dauphine"));
				} else {
					String libEtbEtrCurExt = commande.getLibEtbEtrCurExt(idUsrEtudiant);
					if(libEtbEtrCurExt == null){
						MapIdUsrEtudiantProvenance.put(idUsrEtudiant, prop.getProperty("france"));
					} else {
						MapIdUsrEtudiantProvenance.put(idUsrEtudiant, prop.getProperty("etranger"));
					}
				}
			}
		}
		return MapIdUsrEtudiantProvenance;
	}
	
	public ArrayList<String> trierLesEtudiantsParProvenance(ArrayList<String> listIdUsrEtudiant) {
		ArrayList<String> idUsrEtudiantDauphine = new ArrayList<String>();
		ArrayList<String> idUsrEtudiantFrance = new ArrayList<String>();
		ArrayList<String> idUsrEtudiantEtranger = new ArrayList<String>();
		for(String idUsrEtudiant : listIdUsrEtudiant) {
			String typeCurSco = commande.getTypeCurSco(idUsrEtudiant);
			if(typeCurSco.equals("CUR_R1")){
				idUsrEtudiantDauphine.add(idUsrEtudiant);
			} else {
				String libEtbEtrCurExt = commande.getLibEtbEtrCurExt(idUsrEtudiant);
				if(libEtbEtrCurExt == null){
					idUsrEtudiantFrance.add(idUsrEtudiant);
				} else {
					idUsrEtudiantEtranger.add(idUsrEtudiant);
				}
			}
		}
		idUsrEtudiantFrance.addAll(idUsrEtudiantEtranger);
		idUsrEtudiantDauphine.addAll(idUsrEtudiantFrance);
		return idUsrEtudiantDauphine;
	}
	
	
	/**
	 * trier les nom des etudiants par provenance (dauphine, france, etranger)
	 * @param MapCodeEtapeIdUsrEtudiant
	 * @param commande
	 * @return MapCodeEtapeIdUsrEtudiant
	 */
	public Map<String, ArrayList<String>> trierLesEtudiantsParProvenance(Map<String, ArrayList<String>> MapCodeEtapeIdUsrEtudiant){
		for(Map.Entry<String, ArrayList<String>> e : MapCodeEtapeIdUsrEtudiant.entrySet()){
			ArrayList<String> idUsrEtudiantDauphine = new ArrayList<String>();
			ArrayList<String> idUsrEtudiantFrance = new ArrayList<String>();
			ArrayList<String> idUsrEtudiantEtranger = new ArrayList<String>();
			for(String idUsrEtudiant : MapCodeEtapeIdUsrEtudiant.get(e.getKey())){
				String typeCurSco = commande.getTypeCurSco(idUsrEtudiant);
				if(typeCurSco.equals("CUR_R1")){
					idUsrEtudiantDauphine.add(idUsrEtudiant);
				} else {
					String libEtbEtrCurExt = commande.getLibEtbEtrCurExt(idUsrEtudiant);
					if(libEtbEtrCurExt == null){
						idUsrEtudiantFrance.add(idUsrEtudiant);
					} else {
						idUsrEtudiantEtranger.add(idUsrEtudiant);
					}
				}
			}
			//supprimer l'ancien valeur, et remettre les candidats dans l'ordre
			//MapCodeEtapeIdUsrEtudiant.remove(e.getKey());
			idUsrEtudiantFrance.addAll(idUsrEtudiantEtranger);
			idUsrEtudiantDauphine.addAll(idUsrEtudiantFrance);
			//MapCodeEtapeIdUsrEtudiant.put(e.getKey(), idUsrEtudiantDauphine);
			
			MapCodeEtapeIdUsrEtudiant.get(e.getKey()).clear();
			MapCodeEtapeIdUsrEtudiant.get(e.getKey()).addAll(idUsrEtudiantDauphine);
		}
		return MapCodeEtapeIdUsrEtudiant;
	}
	
	public Map<String, String> getMapIdUsrEtudiantAvis(ArrayList<String> listIdUsrEtudiant, String idCmi) {
		Map<String, String> MapIdUsrEtudiantAvis = new TreeMap<String, String>();
		for(String idUsrEtudiant : listIdUsrEtudiant) {
			String avis = commande.getAvis(idUsrEtudiant, idCmi);
			if(avis != null)
				MapIdUsrEtudiantAvis.put(idUsrEtudiant, avis);
			else
				MapIdUsrEtudiantAvis.put(idUsrEtudiant, prop.getProperty("sansAvis"));
		}
		return MapIdUsrEtudiantAvis;
	}

	/**
	 * retourne une map des idUsrEtudiant avec leurs ais dans cette commissions
	 * @param MapCodeEtapeIdUsrEtudiant
	 * @param idCmi
	 * @param commande
	 * @return
	 */
	public Map<String, String> getMapIdUsrEtudiantAvis(
			Map<String, ArrayList<String>> MapCodeEtapeIdUsrEtudiant, String idCmi) {
		Map<String, String> MapIdUsrEtudiantAvis = new TreeMap<String, String>();
		for(Map.Entry<String, ArrayList<String>> e : MapCodeEtapeIdUsrEtudiant.entrySet()){
			for(String idUsrEtudiant : MapCodeEtapeIdUsrEtudiant.get(e.getKey())){
				String avis = commande.getAvis(idUsrEtudiant, idCmi);
				if(avis != null)
					MapIdUsrEtudiantAvis.put(idUsrEtudiant, avis);
				else
					MapIdUsrEtudiantAvis.put(idUsrEtudiant, prop.getProperty("sansAvis"));
			}
		}
		return MapIdUsrEtudiantAvis;
	}

	/**
	 * retourne la liste des etudiants qui ont cet avis
	 * @param MapIdUsrEtudiantAvis
	 * @param avis
	 * @return
	 */
	public ArrayList<String> listDesEtudiantsAAfficheParAvis(
			Map<String, String> MapIdUsrEtudiantAvis, String avis) {
		ArrayList<String> listDesEtudiantsAAfficheParAvis = new ArrayList<String>();
		for(Map.Entry<String, String> e : MapIdUsrEtudiantAvis.entrySet()){
			if(e.getValue().equals(avis)){
				listDesEtudiantsAAfficheParAvis.add(e.getKey());
			}
		}
		return listDesEtudiantsAAfficheParAvis;
	}

	public ArrayList<String> getListEtudiantNonTraitement(Map<String, String> mapIdUsrEtudiantTraitement, ArrayList<String> listIdUsrEtudiant) {
		ArrayList<String> listEtudiantNonTraitement = new ArrayList<String>();
		for(String idUsr : listIdUsrEtudiant){
			if(!mapIdUsrEtudiantTraitement.containsKey(idUsr) || mapIdUsrEtudiantTraitement.get(idUsr).equals("STATE.NON_TRAITE"))
				listEtudiantNonTraitement.add(idUsr);
		}
		return listEtudiantNonTraitement;
	}
	
	public ArrayList<String> getListEtudiantNonTraitement(Map<String, String> mapIdUsrEtudiantTraitement, Map<String, ArrayList<String>> MapCodeEtapeIdUsrEtudiant) {
		ArrayList<String> listEtudiantNonTraitement = new ArrayList<String>();
		for(Entry<String, ArrayList<String>> e : MapCodeEtapeIdUsrEtudiant.entrySet()){
			for(String idUsr : e.getValue()){
				if(!mapIdUsrEtudiantTraitement.containsKey(idUsr) || mapIdUsrEtudiantTraitement.get(idUsr).equals("STATE.NON_TRAITE"))
					listEtudiantNonTraitement.add(idUsr);
			}
		}
		return listEtudiantNonTraitement;
	}

	public ArrayList<String> getListIdUsr(Map<String, ArrayList<String>> MapCodeEtapeIdUsrEtudiant) {
		ArrayList<String> listIdUsr= new ArrayList<String>();
		for(Entry<String, ArrayList<String>> e : MapCodeEtapeIdUsrEtudiant.entrySet()){
			listIdUsr.addAll(e.getValue());
		}
		return listIdUsr;
	}
	
	public ArrayList<String> getListCodeNomPs(Map<String, ArrayList<String>> mapCodeEtapeCodeNomPs) {
		ArrayList<String> listCodeNomPs = new ArrayList<String>();
		for(Entry<String, ArrayList<String>> e : mapCodeEtapeCodeNomPs.entrySet()){
			listCodeNomPs.addAll(e.getValue());
		}
		return listCodeNomPs;
	}

	public String getCodeEtape(String idCmi) {
		return commande.getlistCodeEtapes(idCmi).get(0);
	}
	
	public String getCodeVet(String idCmi) {
		return commande.getlistCodeVets(idCmi).get(0);
	}

	public ArrayList<String> getListIdNomPs(String codeEtape, String codeVet) {
		return commande.getListIdNomPs(codeEtape, codeVet);
	}

	public ArrayList<String> getListCodeNomPs(ArrayList<String> listIdNomPs) {
		ArrayList<String> listCodeNomPs = new ArrayList<String>();
		for(String idNomPs : listIdNomPs) {
			String codeNomPs = commande.getCodeNomPs(idNomPs);
			if(codeNomPs != null)
				listCodeNomPs.add(codeNomPs);
			else
				listCodeNomPs.add("ERROR");
		}
		return listCodeNomPs;
	}

	public ArrayList<String> getListLibNomPs(ArrayList<String> listIdNomPs) {
		ArrayList<String> listLibNomPs = new ArrayList<String>();
		for(String idNomPs : listIdNomPs) {
			String codeNomPs = commande.getLibNomPs(idNomPs);
			if(codeNomPs != null)
				listLibNomPs.add(codeNomPs);
			else
				listLibNomPs.add("ERROR");
		}
		return listLibNomPs;
	}

	//annulee
	public ArrayList<String> getListIdUsrEtudiant(String codeEtape, String codeVet) {
		return commande.getListEtudiant(codeEtape, codeVet);
	}
	
	public ArrayList<String> getListIdUsrEtudiant(String idCmi) {
		return commande.getListIdUsrEtudiant(idCmi);
	}
//-> recherche
	/**
	 * obtenir  la liste des id_usr recherches qui correspondent a la commission
	 * @param recherche
	 * @param listIdUsrEtudiant
	 * @return
	 */
	public ArrayList<String> getListIdUsrEtudiantRechercheNom(String recherche, ArrayList<String> listIdUsrEtudiant) {
		ArrayList<String> listIdUsrEtudiantRecherche = new ArrayList<String>();
		ArrayList<String> listIdUsrEtudiantBase = commande.getListIdUsrEtudiantRechercheNom(recherche);
		for(String idUsrEtudiant : listIdUsrEtudiantBase)
			if(listIdUsrEtudiant.contains(idUsrEtudiant)) 
				listIdUsrEtudiantRecherche.add(idUsrEtudiant);
		return listIdUsrEtudiantRecherche;
	}
	
	public ArrayList<String> getListIdUsrEtudiantRechercheId(String rechercheId, ArrayList<String> listIdUsrEtudiant) {
		ArrayList<String> listIdUsrEtudiantRecherche = new ArrayList<String>();
		if(listIdUsrEtudiant.contains(rechercheId))
			listIdUsrEtudiantRecherche.add(rechercheId);
		return listIdUsrEtudiantRecherche;
	}	

	public ArrayList<String> getListIdUsrEtudiantRechercheNumDossier(String rechercheNumDossier, ArrayList<String> listIdUsrEtudiant) {
		ArrayList<String> listIdUsrEtudiantRecherche = new ArrayList<String>();
		String IdUsrEtudiantBase = commande.getIdUsrEtudiantRechercheNumDossier(rechercheNumDossier);
		if(listIdUsrEtudiant.contains(IdUsrEtudiantBase)) 
			listIdUsrEtudiantRecherche.add(IdUsrEtudiantBase);
		return listIdUsrEtudiantRecherche;
	}
	/**
	 * list des IdUsr Ayant Depose
	 * @param <String>
	 * @param list1
	 * @param list2
	 * @return
	 */
	public ArrayList<String> listIdUsrAyantDepose(ArrayList<String> list1, ArrayList<String> list2) {
		ArrayList<String> list = new ArrayList<String>();

        for (String t : list1) {
            if(!list2.contains(t)) {
                list.add(t);
            }
        }

        return list;
    }

	public ArrayList<String> listIdUsrEtdiantSurPage(ArrayList<String> listIdUsrEtudiant, ArrayList<String> listDesEtudiantsAAffiche, /*ArrayList<String> listDesEtudiantsAAfficheParProvenance,*/ ArrayList<String> listDesEtudiantsAAfficheParCodeEtablissement, ArrayList<String> listDesEtudiantsAAfficheParAvis, String filtre, /*String filtreProvenance,*/ String filtreEtablissement, String filtreAvis){
		ArrayList<String> listIdUsrEtudiantAffiche = new ArrayList<String>();
		for(String s : listIdUsrEtudiant){
			
			if(!filtre.equals("Tout"))
				if(!listDesEtudiantsAAffiche.contains(s))
					continue;
			
			/*if(!filtreProvenance.equals("Tout"))
				if(!listDesEtudiantsAAfficheParProvenance.contains(s))
					continue;*/
			
			if(!filtreEtablissement.equals("Tout"))
				if(!listDesEtudiantsAAfficheParCodeEtablissement.contains(s))
					continue;
			
			if(!filtreAvis.equals("Tout"))
				if(!listDesEtudiantsAAfficheParAvis.contains(s))
					continue;
					
			
			 listIdUsrEtudiantAffiche.add(s);
		}
		return  listIdUsrEtudiantAffiche;
	}

	public void trierLibCmiParOrdreAlphabetique(ArrayList<String> listLibCmis) {
		Collections.sort(listLibCmis);
	}
	
	public ArrayList<String> trierCommisionParOrdreAlphabetique(ArrayList<String> listIdCmis) {
		ArrayList<String>  listIdCmisTrie = new ArrayList<String>();
		
		ArrayList<String>  listLibCmis = this.getLibCmis(listIdCmis);
		ArrayList<String>  listLibCmisTrie = this.getLibCmis(listIdCmis);
		Collections.sort(listLibCmisTrie);
		
		for(String libCmi : listLibCmisTrie) {
			int index = listLibCmis.indexOf(libCmi);
			listIdCmisTrie.add(listIdCmis.get(index));
		}
		
		return listIdCmisTrie;
		
	}

	public String getDateFin(String idCmi) {
		return commande.getDateFin(idCmi);
	}

	
	public <T> List<T> intersect(List<T> list1, List<T> list2) {
        List<T> list = new ArrayList<T>();

        for (T t : list1) {
            if(list2.contains(t)) {
                list.add(t);
            }
        }

        return list;
    }

	public Map<String, String> getMapIdUsrEtudiantCodeEtab(ArrayList<String> listIdUsrEtudiant) {
		Map<String, String> MapIdUsrCodeEtab = new TreeMap<String, String>();
		for(String idUsr : listIdUsrEtudiant) {
			String codeEtab = commande.dernierCodEtabEtudiant(idUsr);
			if(codeEtab == null)
				codeEtab = prop.getProperty("etabEtran");
			else {
				if(codeEtab.equals("")) {
					codeEtab = prop.getProperty("inconnu");
				}
			}
			MapIdUsrCodeEtab.put(idUsr, codeEtab);
		}
		return MapIdUsrCodeEtab;
	}

	public ArrayList<String> getlistCodeEtabTrie(ArrayList<String> listIdUsrEtudiant) {
		ArrayList<String> listCodeEtab = new ArrayList<String>();
		for(String idUsr : listIdUsrEtudiant) {
			String codeEtab = commande.dernierCodEtabEtudiant(idUsr);
			if(codeEtab == null)
				codeEtab = prop.getProperty("etabEtran");
			else {
				if(codeEtab.equals("")) {
					codeEtab = prop.getProperty("inconnu");
				}
			}
			if(!listCodeEtab.contains(codeEtab))
				listCodeEtab.add(codeEtab);
		}
		Collections.sort(listCodeEtab);
		return listCodeEtab;
	}

	public ArrayList<String> listDesEtudiantsAAfficheParCodeEtab(Map<String, String> mapIdUsrEtudiantCodeEtab, String filtreEtablissement) {
		ArrayList<String> listDesEtudiantsAAfficheParCodeEtab = new ArrayList<String>();
		for(Map.Entry<String, String> e : mapIdUsrEtudiantCodeEtab.entrySet()){
			if(e.getValue().equals(filtreEtablissement)){
				listDesEtudiantsAAfficheParCodeEtab.add(e.getKey());
			}
		}
		return listDesEtudiantsAAfficheParCodeEtab;
	}
	
	public String getLibEtablissement(String codeEtab) {
		try {
			
			EtablissementApogee et = new EtablissementApogee();
			et.initConnexion();
			if(et.getEtablissementtMetier(codeEtab).length == 1) 
				return et.getEtablissementtMetier(codeEtab)[0].getLibEtb().toLowerCase();
				
			
			et.close();
			
		} catch (Exception e) {
			System.err.println("ERROR : METIER -> getLibEtablissement");
			
		}
		
		return codeEtab;
	}

	public Map<String, String> getMapCodeEtabLibEtab(
			ArrayList<String> listCodeEtab) {
		Map<String, String> map = new TreeMap<String, String>();
		for(String codeEtab : listCodeEtab) {
			map.put(codeEtab, this.getLibEtablissement(codeEtab));
		}
		return map;
	}

	public void insertEtablissementAAffiche(String idSession, String login,
			String codeEtab, String idCmi, String sessionStartTimeSimpleFormat) {
		commande.insertEtablissementAAffiche(idSession, login, codeEtab, idCmi, sessionStartTimeSimpleFormat);
	}

	public void updateEtablissementAAffiche(String idSession, String login,
			String codeEtab, String idCmi, String sessionStartTimeSimpleFormat) {
		commande.updateEtablissementAAffiche(idSession, login, codeEtab, idCmi, sessionStartTimeSimpleFormat);
		
	}
	
	public String getEtabAAffiche(String idSession, String login, String idCmi) {
		return commande.getEtablissementAAffiche(idSession, login, idCmi);
	}

	
	

	
	

	

	

	

	
	
}
