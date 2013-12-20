package com.de_mvc.metier;

import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

import com.de_mvc.DAO.CommandesBDD;
import com.de_mvc.DAO.ImplementCommandes;


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
	 * verification de l'existance de numero de dossier
	 * @param numDossier
	 * @return boolean
	 */
	public boolean verifNumDossier(String numDossier) {
		return commande.verifNumDossier(numDossier);
	}
	
	/**
	 * obtenir la date de naissance
	 * @param numDossier
	 * @return String
	 */
	public String getDateDeNaissance(String numDossier) {
		return commande.getDateNaissance(numDossier);
	}
	
	/**
	 * obtenir id_usr
	 * @param numDossier
	 * @return String
	 */
	public String getIdUsr(String numDossier) {
		return commande.getIdUsr(numDossier);
	}
	
	/**
	 * obtenir nomUsr
	 * @param idUsr
	 * @return String
	 */
	public String getNomUsr(String idUsr) {
		return commande.getNomUsr(idUsr);
	}
	
	/**
	 * obtenir tableau des id_link
	 * @param idUsr
	 * @return String[]
	 */
	public String[] getTabIdLinks(String idUsr) {
		return commande.getTabIdLinks(idUsr);
	}
	
	/**
	 * obtenir tableau des id_trt_cmi
	 * @param idLinks
	 * @return String[]
	 */
	public ArrayList<String>getListIdTrtCmi(String[] idLinks) {
		return commande.getListIdTrtCmi(idLinks);
	}
	
	/**
	 * obtenir tableau des lib_cmi
	 * @param tabTrtCmis
	 * @return String[]
	 */
	public ArrayList<String> getListLibCmis(ArrayList<String> listTrtCmis) {
		return commande.getListLibCmis(listTrtCmis);
	}
	
	/**
	 * obtenir les codes etapes pour candidat separees par \<br\>
	 * @param tabTrtCmis
	 * @return String
	 */
	public ArrayList<String> getCodeEtapes(ArrayList<String> tabTrtCmis) {
		return commande.getCodeEtapes(tabTrtCmis);
	}
	
	/**
	 * obtenir les codes Vets pour candidat separees par \<br\>
	 * @param tabTrtCmis
	 * @return String
	 */
	public ArrayList<String> getCodeVets(ArrayList<String> tabTrtCmis) {
		return commande.getCodeVets(tabTrtCmis);
	}
	
	/**
	 * obtenir idCmi selon idTrtCmi
	 * @param idTrtCmi
	 * @return String
	 */
	public String getIdCmi(String idTrtCmi) {
		return commande.getIdCmi(idTrtCmi);
	}
	
	/**
	 * obtenir date de debut de compagne pour id_cmi
	 * @param idCmi
	 * @return String 
	 */
	public String getDateDeb(String idCmi) {
		return commande.getDateDeb(idCmi);
	}
	
	/**
	 * obtenir date de fin de compagne pour id_cmi
	 * @param idCmi
	 * @return String
	 */
	public String getDateFin(String idCmi) {
		return commande.getDateFin(idCmi);
	}
	
	/**
	 * obtenir codeRiNom pour id_usr
	 * @param idUsr
	 * @return String
	 */
	public String getCodeRiNom(String idUsr) {
		return commande.getCodeRiNom(idUsr);
	}
	
	/**
	 * obtenir list piece justif communes selon codeRiNom
	 * @param codeRiNom
	 * @return ArrayList
	 */
	public ArrayList<String> getListPJO(String codeRiNom) {
		return commande.getListPJO(codeRiNom);
	}
	
	/**
	 * obtenir list code piece justif communes selon codeRiNom
	 * @param codeRiNom
	 * @return ArrayList
	 */
	public ArrayList<String> getListCodePJO(String codeRiNom) {
		return commande.getListCodePJO(codeRiNom);
	}
	
	/**
	 * obtenir list id nom semon codeEtape, codeVet
	 * @param codeEtape
	 * @param codeVet
	 * @return ArrayList
	 */
	public ArrayList<String> getListIdNom(String codeEtape, String codeVet) {
		return commande.getListIdNom(codeEtape, codeVet);
	}
	
	/**
	 * obtenir list piece justif specifiques selon codeRiNom et listIdNom
	 * @param codeRiNom
	 * @param listIdNom
	 * @return ArrayList
	 */
	public ArrayList<String> getListPJS(String codeRiNom, ArrayList<String> listIdNom) {
		return commande.getListPJS(codeRiNom, listIdNom);
	}
	
	/**
	 * obtenir list code piece justif specifiques selon codeRiNom et listIdNom
	 * @param codeRiNom
	 * @param listIdNom
	 * @return ArrayList
	 */
	public ArrayList<String> getListCodePJS(String codeRiNom, ArrayList<String> listIdNom) {
		return commande.getListCodePJS(codeRiNom, listIdNom);
	}
	
	/**
	 * obtenir listEmplacements selon id_cmi
	 * @param idCmi
	 * @return ArrayList
	 */
	public ArrayList<String> getListEmplacements(String idCmi)  {
		return commande.getListEmplacements(idCmi);
	}
	
	/**
	 * obtenir listEmplacements selon id_cmi, id_usr
	 * @param idCmi
	 * @return ArrayList
	 */
	public ArrayList<String> getListEmplacements(String idCmi, String idUsr)  {
		return commande.getListEmplacementsForIdCmiIdUsr(idCmi, idUsr);
	}
	
	/**
	 * obtenir list des codes des fichiers deposes selon id_cmi, id_usr
	 * @param idCmi
	 * @param idUsr
	 * @return ArrayList
	 */
	public ArrayList<String> getListCodeFichierDeposeForIdCmiIdUsr(String idCmi, String idUsr)  {
		ArrayList<String> listCodeFichierDeposeForIdCmiIdUsr = new ArrayList<String>();
		ArrayList<String> listEmplacements = commande.getListEmplacementsForIdCmiIdUsr(idCmi, idUsr);
		for (String emplacement : listEmplacements)
			listCodeFichierDeposeForIdCmiIdUsr.add(emplacement.substring(emplacement.lastIndexOf("/") + 1));
		return listCodeFichierDeposeForIdCmiIdUsr;
	}
	
	/**
	 * obtenir id_nom selon codeNom
	 * @param codeNom
	 * @return String
	 */
	public String getIdNom(String codeNom) {
		return commande.getIdNom(codeNom);
	}
	
	/**
	 * suppression fichier de la base semon id_nom, id_cmi, id_usr
	 * @param idNom
	 * @param idCmi
	 * @param idUsr
	 */
	public void delFile(String idNom, String idCmi, String idUsr) {
		commande.delFile(idNom, idCmi, idUsr);
	}
	
	/**
	 * insertion fichier dans la base selon id_usr, id_cmi, id_nom
	 * @param idUsr
	 * @param idCmi
	 * @param idNom
	 * @param repertoire
	 * @param name
	 * @param extention
	 */
	public void insertFile(String idUsr, String idCmi, String idNom,
			String repertoire, String name, String extention) {
		commande.insertFile(idUsr, idCmi, idNom, repertoire, name, extention);
		/************** type de fichier convertit dan sla bdd : annule ***************/
		/*if (extention.toLowerCase().equals(".odt")
				|| extention.toLowerCase().equals(".doc")
				|| extention.toLowerCase().equals(".docx")
				|| extention.toLowerCase().equals(".rtf")
				|| extention.toLowerCase().equals(".jpg")
				|| extention.toLowerCase().equals(".gif")
				|| extention.toLowerCase().equals(".jpeg")) {
			commande.insertFile(idUsr, idCmi, idNom, repertoire, name, ".pdf");
		} else {
			commande.insertFile(idUsr, idCmi, idNom, repertoire, name, extention);
		}*/
	}
	
	/**
	 * obtenir les adresses mail des referent pour candidat
	 * @param idUsr
	 * @return ArrayList
	 */
	public ArrayList<String> getMailRefsForUsr(String idUsr) {
		return commande.getMailRefsForUsr(idUsr);
	}
	
	/**
	 * obtenir les adresses mail de tout les referents
	 * @return ArrayList
	 */
	public ArrayList<String> getMailRefs() {
		return commande.getMailRefs();
	}
	
	/**
	 * verifier si lienComplet existe pour referent
	 * @param lienComplet
	 * @return boolean
	 */
	public boolean lienIdentifRefExiste(String lienComplet) {
		return commande.lienIdentifRefExiste(lienComplet);
	}
	
	/**
	 * insertion de lien unique pour referent
	 * @param mail
	 * @param lienComplet
	 */
	public void insertNewRefLienUnique(String mail, String lienComplet) {
		commande.insertNewRefLienUnique(mail, lienComplet);
	}
	
	/**
	 * obtenir id_ref selon son mail
	 * @param mail
	 * @return String
	 */
	public String getIdRef(String mail) {
		return commande.getIdRef(mail);
	}
	
	/**
	 * insertions de referent pour id_usr
	 * @param idRef
	 * @param idUsr
	 */
	public void insertNewRefForUsr(String idRef, String idUsr) {
		commande.insertNewRefForUsr(idRef, idUsr);
	}
	
	/**
	 * verifier si un referent dispose un lien selon mail
	 * @param mail
	 * @return boolean
	 */
	public boolean referentDisposeLien(String mail) {
		return commande.referentDisposeLien(mail);
	}
	
	/**
	 * obtenir lienComplet pour referent selon mail
	 * @param mail
	 * @return String
	 */
	public String getLienCompletForRef(String mail) {
		return commande.getLienCompletForRef(mail);
	}
	
	/**
	 * insertion de nouveau referent
	 * @param mail
	 * @param password
	 */
	public void insertNewRef(String mail, String password) {
		commande.insertNewRef(mail, password);
	}
	
	/**
	 * obtenir password referent selon mail
	 * @param mail
	 * @return String
	 */
	public String getPasswordRef(String mail) {
		return commande.getPasswordRef(mail);
	}
	
	/**
	 * verifier existance fichier dans bdd avec id_cmi, id_usr, emplacement
	 * @param idCmi
	 * @param idUsr
	 * @param emplacement
	 * @return boolean
	 */
	public boolean fileInBDD(String idCmi, String idUsr, String emplacement) {
		return commande.fileInBDD(idCmi, idUsr, emplacement);
	}
	
	/**obtenir nom fichier selon code_nom
	 * 
	 * @param codeNom
	 * @return String
	 */
	public String getNomFile(String codeNom) {
		return commande.getNomFile(codeNom);
	}
	
	/**
	 * ibtenir nombre de recommandatiosn deposées pour id_usr
	 * @param idUsr
	 * @return String
	 */
	public String nbMailRecommandation(String idUsr) {
		return commande.nbMailRecommandation(idUsr);
	}

	/**
	 * 
	 * @param listFichiersExistEnBDD
	 * @return Map
	 */
	public Map<String, String> getMapLibFichierPourCodeFichier(ArrayList<String> listFichiersExistEnBDD) {
		Map<String, String> MapLibFichierPourCodeFichier = new TreeMap<String, String>();
		for (String fichier : listFichiersExistEnBDD) {
			String codeFile = fichier.substring(0 , fichier.lastIndexOf("."));
			MapLibFichierPourCodeFichier.put(codeFile, commande.getNomFile(codeFile));
		}
		return MapLibFichierPourCodeFichier;
	}
	
	/**
	 * 
	 * @param idCmi
	 * @return
	 */
	public String getLibCmiFromIdCmi(String idCmi) {
		return commande.getLibCmiFromIdCmi(idCmi);
	}
	
	public String getMailContent(String codeMail) {
		return commande.getMailContent(codeMail);
	}
	
	public String getMailSubject(String codeMail) {
		return commande.getMailSubject(codeMail);
	}
}
