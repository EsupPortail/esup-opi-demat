package com.de_mvc.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * interface des fonctions de communication avec la base des données
 * @author root
 * @version 1.0
 */
public interface CommandesBDD {
	
	public boolean ConnectionBDD(String name, String driver, String user, String code);
	
	public void deconnexion();
	
	/**
	 * setter de l'attribut con
	 * @param con
	 */
	public void setConnection(Connection con);
	
	/**
	 * getter de l'attribut con
	 * @param con
	 */
	public Connection getConnection();
	
	/**
	 * verification de l'existance de nmDossier dans individu
	 * @param numDossier
	 * @return boolean
	 */
	public boolean verifNumDossier(String numDossier);
	
	/**
	 * obtenir la date de naissance dans la table individu
	 * @param numDossier
	 * @return dateNaissance
	 */
	public String getDateNaissance(String numDossier);
	
	/**
	 * obtenir le idUsr dans la table individu
	 * @param numDossier
	 * @return idUsr
	 */
	public String getIdUsr(String numDossier);
	
	/**
	 * obtenir nomUsr dans la tabel opi_user
	 * @param idUsr
	 * @return nomUsr
	 */
	public String getNomUsr(String idUsr);
	
	/**
	 * obtenir les Links la table ind_voeu
	 * @param idUsr
	 * @return tabLinks
	 */
	public String[] getTabIdLinks(String idUsr);
	
	/**
	 * obtenir les idTrtCmi dans la table link_trt_cmi_camp
	 * @param tabLinks
	 * @return tabIdTrtCmi
	 */
	public ArrayList<String> getListIdTrtCmi(String[] tabLinks);
	
	/**
	 * obtenir une chaine de caractere contenant les codes etape dans la table trt_cmi_vet
	 * @param tabTrtCmis
	 * @return codeEtapes
	 */
	public ArrayList<String> getCodeEtapes(ArrayList<String> tabTrtCmis);
	
	/**
	 * obtenir une chaine de caractere contenant les codes etape dans la table trt_cmi_vet
	 * @param tabTrtCmis
	 * @return
	 */
	public ArrayList<String> getCodeVets(ArrayList<String> tabTrtCmis);
	/**
	 * obtenir idCmi dans la table trt_cmi_vet
	 * @param idTrtCmi
	 * @return idCmi
	 */
	public String getIdCmi(String idTrtCmi);
	
	/**
	 * obtenir la date de debut de la commission dans la table calendar et cal_ins_cmi
	 * @param idCmi
	 * @return dateDeb
	 */
	public String getDateDeb(String idCmi);
	
	/**
	 * obtenir la date de la fin de la commission dans la table calendar et cal_ins_cmi
	 * @param idCmi
	 * @return dateFin
	 */
	public String getDateFin(String idCmi);
	
	/**
	 * obtenir codeRiNom dans la table ind_camp et nomenclature
	 * @param idUsr
	 * @return codeRiNom
	 */
	public String getCodeRiNom(String idUsr);
	
	/**
	 * obtenir la liste des id de pieces justificatives communes dans la table nomenclature
	 * @param codeRiNom
	 * @return listPJO
	 */
	public ArrayList<String> getListPJO(String codeRiNom);
	
	/**
	 * obtenir la liste des code pieces justificatives communes dans la table nomenclature
	 * @param codeRiNom
	 * @return listCodePJO
	 */
	public ArrayList<String> getListCodePJO(String codeRiNom);
	
	/**
	 * obtenir la liste des idNoms dans la table piece_justi_vet
	 * @param codeEtape
	 * @param codeVet
	 * @return listIdNom
	 */
	public ArrayList<String> getListIdNom(String codeEtape, String codeVet);
	
	/**
	 * obtenir la liste des id de pieces justificatives spécifiques dans la table nomenclature
	 * @param codeRiNom
	 * @param listIdNom
	 * @return listPJS
	 */
	public ArrayList<String> getListPJS(String codeRiNom, ArrayList<String> listIdNom);
	
	/**
	 * obtenir la liste des code de pieces justificatives spécifiques dans la table nomenclature
	 * @param codeRiNom
	 * @param listIdNom
	 * @return listCodePJS
	 */
	public ArrayList<String> getListCodePJS(String codeRiNom, ArrayList<String> listIdNom);
	
	/**
	 * obtenir idNom dans la table nomenclature
	 * @param codeNom
	 * @return idNom
	 */
	public String getIdNom(String codeNom);
	
	/**
	 * supprimer un fichier dans la table UPD_IND_FICHIER
	 * @param idNom
	 * @param idCmi
	 * @param idUsr
	 */
	public void delFile(String idNom, String idCmi, String idUsr);
	
	/**
	 * inserer un fichier dans la table UPD_IND_FICHIER
	 * @param idUsr
	 * @param idCmi
	 * @param idNom
	 * @param repertoire
	 * @param name
	 * @param extention
	 */
	public void insertFile(String idUsr, String idCmi, String idNom, String repertoire, String name, String extention);
	
	/**
	 * obtenir le nom de fichier dans la table nomenclature
	 * @param codeNom
	 * @return nomFile
	 */
	public String getNomFile(String codeNom);
	
	/**
	 * verifier si un fichier existe dans la table UPD_IND_FICHIER
	 * @param idCmi
	 * @param idUsr
	 * @param emplacement
	 * @return boolean
	 */
	public boolean fileInBDD(String idCmi, String idUsr, String emplacement);
	
	/**
	 * obtenir le nombre de referents indiqués dans la table UPD_IND_REFERENT
	 * @param idUsr
	 * @return nbMailRecommandation
	 */
	public String nbMailRecommandation(String idUsr);
	
	/**
	 * obtenir la liste des mails d'un referent pour un etudiant dans la table  UPD_REFERENT et UPD_IND_REFERENT
	 * @param idUsr
	 * @return listMailRefsForUsr
	 */
	public ArrayList<String> getMailRefsForUsr(String idUsr);
	
	/**
	 * obtenir la liste des mail de referents dans la table UPD_REFERENT
	 * @return listmailRef
	 */
	public ArrayList<String> getMailRefs();
	
	/**
	 * inserer un nouveau referent dans la table UPD_REFERENT
	 * @param mailRef
	 * @param password
	 */
	public void insertNewRef(String mailRef, String password);
	
	/**
	 * obtenir id de referent dans la table UPD_REFERENT
	 * @param mail
	 * @return idRef
	 */
	public String getIdRef(String mail);
	
	/**
	 * inserer un nouveau referent pour un etudiant dans la table UPD_IND_REFERENT
	 * @param idRef
	 * @param idUsr
	 */
	public void insertNewRefForUsr(String idRef, String idUsr);
	
	/**
	 * obtenir le password du referent dans la table UPD_REFERENT 
	 * @param mail
	 * @return
	 */
	public String getPasswordRef(String mail);
	
	/**
	 * obtenir la liste d'emplacement des fichiers dans une commission dans la table UPD_IND_FICHIER
	 * @param idCmi
	 * @return listEmplacements
	 */
	public ArrayList<String> getListEmplacements(String idCmi);
	
	/**
	 * 
	 * @param lien
	 * @return
	 */
	public boolean lienIdentifRefExiste(String lien);

	/**
	 * 
	 * @param mail
	 * @param lienComplet
	 * @return 
	 */
	public void insertNewRefLienUnique(String mail, String lienComplet);

	/**
	 * 
	 * @param mail
	 * @return
	 */
	public boolean referentDisposeLien(String mail);

	/**
	 * 
	 * @param mail
	 * @return
	 */
	public String getLienCompletForRef(String mail);
	
	/**
	 * 
	 * @param trtCmi
	 * @return
	 */
	public ArrayList<String> getListLibCmis(ArrayList<String> tabTrtCmis);
	
	/**
	 * 
	 * @param idCmi
	 * @return
	 */
	public String getLibCmiFromIdCmi(String idCmi);

	/**
	 * 
	 * @param idCmi
	 * @param idUsr
	 * @return
	 */
	public ArrayList<String> getListFichiersEnBDD(String idCmi, String idUsr);

	/**
	 * obtenir la liste d'emplacement des fichiers dans une commission dans la table UPD_IND_FICHIER
	 * @param idCmi
	 * @param idUsr
	 * @return liste d'emplacement
	 */
	public ArrayList<String> getListEmplacementsForIdCmiIdUsr(String idCmi, String idUsr);
	
	public String getMailContent(String codeMail);
	
	public String getMailSubject(String codeMail);

	
}
