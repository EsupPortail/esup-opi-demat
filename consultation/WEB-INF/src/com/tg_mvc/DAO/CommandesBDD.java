package com.tg_mvc.DAO;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Map;

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
	 * verifier si le login du gestionnaire est dans la table gestionnaire
	 * @param login
	 * @return boolean
	 */
	public boolean verifLogin(String login);
	
	/**
	 * obtenir le idUsr de getionnaire dans la table gestionnaire
	 * @param login
	 * @return idUsr
	 */
	public String getIdUsr(String login);
	
	/**
	 * obtenir le dispName de getionnaire dans la table gestionnaire
	 * @param login
	 * @return dispName
	 */
	public String getDispName(String login);
	
	/**
	 * obtenir le idProfile du gestionnaire dans la table getionnaire
	 * @param idUsr
	 * @return idProfile
	 */
	public String getIdProfile(String idUsr);
	
	/**
	 * obtenir les idCmi de ce referent dans la table member si idProfole = (1, 4, 7, 8)
	 * et dans la table commission sinon
	 * @param idUsr
	 * @param idProfile
	 * @return listIdCmis
	 */
	public ArrayList<String> getIdCmis(String idUsr, String idProfile);
	
	
	/**
	 * obtnir liste libCmis dans la table commision
	 * @param idCmis
	 * @return listLibCmis
	 */
	public ArrayList<String> getLibCmis(ArrayList<String> idCmis);
	
	/**
	 * obtenir la liste des codeCmis dans la table commission
	 * @param idCmis
	 * @return listCodeCmis
	 */
	public ArrayList<String> getCodeCmis(ArrayList<String> idCmis);
	
	/**
	 * obtenir le codeRi pour une commission dans la table nomenclature et link_trt_cmi_camp
	 * @param idCmi
	 * @return codeRi
	 */
	public String getCodeRi(String idCmi);
	
	/**
	 * obtenir la liste des idNoms des pieces communes pour une commssion dans la table nomenclature
	 * @param codeRi
	 * @return listIdNomPc
	 */
	public ArrayList<String> getListIdNomsPc(String codeRi);
	
	/**
	 * obtenir la liste des libNoms des pieces communes pour une commission dans la table nomenclature
	 * @param codeRi
	 * @return listeLibNomPc
	 */
	public ArrayList<String> getlistLibNomsPc(String codeRi);
	
	/**
	 * obtenir la liste des codeNoms des pieces communes pour une commission dans la table nomenclature
	 * @param codeRi
	 * @return listCodeNomsPc
	 */
	public ArrayList<String> getlistCodeNomsPc(String codeRi);
	
	/**
	 * obtenir la liste des codeEtapes dans une commission dans la table trt_cmi_vet
	 * @param idCmi
	 * @return listCodeEtapes
	 */
	public ArrayList<String> getlistCodeEtapes(String idCmi);
	
	/**
	 * obtenir la liste des codeVets dans une commission dans la table trt_cmi_vet
	 * @param idCmi
	 * @return listCodeVets
	 */
	public ArrayList<String> getlistCodeVets(String idCmi);
	
	/**
	 * obtenir tem_en_sve_nom pour un fichier dans la table nomenclature
	 * @param idNom
	 * @return enService
	 */
	public String idNomEnService(String idNom);
	
	/**
	 * obtenir une map des idNoms des pieces spécifiques pour chaque codeEtape donnée en parametre dans la table nomenclature
	 * @param listCodeEtapes
	 * @param listCodeVets
	 * @return MapCodeEtapeIdNomPs
	 */
	public Map<String, ArrayList<String>> getMapCodeEtapeIdNomPs(ArrayList<String> listCodeEtapes, ArrayList<String> listCodeVets);
	
	/**
	 * obtenir une map des codeNoms des pieces spécifiques pour chaque codeEtape dans la table nomenclature
	 * @param MapCodeEtapeIdNomPs
	 * @return MapCodeEtapeCodeNomPs
	 */
	public Map<String, ArrayList<String>> getMapCodeEtapeCodeNomPs(Map<String, ArrayList<String>> MapCodeEtapeIdNomPs);
	
	/**
	 * obtenir une map des libNoms des pieces spécifiques pour chaque codeEtape dans la table nomenclature
	 * @param MapCodeEtapeIdNomPs
	 * @return MapCodeEtapeLibNomPs
	 */
	public Map<String, ArrayList<String>> getMapCodeEtapeLibNomPs(Map<String, ArrayList<String>> MapCodeEtapeIdNomPs);
	
	/**
	 * obtenir la liste des idUsrEtudiant pour chaque etape donnée en parametre dans la table ind_voeu, link_trt_cmi_camp et trt_cmi_vet
	 * @param listCodeEtapes
	 * @param listCodeVets
	 * @return MapCodeEtapeIdUsrEtudiant
	 */
	public Map<String, ArrayList<String>> getMapCodeEtapeIdUsrEtudiant(ArrayList<String> listCodeEtapes, ArrayList<String> listCodeVets);
	
	/**
	 * obtenir les nom des etudiants pour chaque etape dans la table opi_user
	 * @param MapCodeEtapeIdUsrEtudiant
	 * @return MapCodeEtapeNomEtudiant
	 */
	public Map<String, ArrayList<String>> getMapCodeEtapeNomEtudiant(Map<String, ArrayList<String>> MapCodeEtapeIdUsrEtudiant);
	
	/**
	 * obtenir les num dossiers des etudiants pour chaque etape dans la table opi_user
	 * @param MapCodeEtapeIdUsrEtudiant
	 * @return MapCodeEtapeNumDossier
	 */
	public Map<String, ArrayList<String>> getMapCodeEtapeNumDossier(Map<String, ArrayList<String>> MapCodeEtapeIdUsrEtudiant);
	
	/**
	 * obtenir la liste des idUsr qui ont rien depose individu
	 * @return listIdUsrNoFileUploaded
	 */
	public ArrayList<String> getlistIdUsrNoFileUploaded();
	
	/**
	 * obtenir la liste des idUsr qui ont rien depose en pdf individu
	 * @return listIdUsrNoFileUploaded
	 */
	public ArrayList<String> getlistIdUsrNoFileAlireUploaded();
	
	/**
	 * obtenir la liste de TypePieceJustif des pieces déposées pour un candidat dans la table UPD_IND_FICHIER
	 * @param idUsr
	 * @param idCmi
	 * @return listTypePieceJustif
	 */
	public ArrayList<String> getlistTypePieceJustif(String idUsr, String idCmi);
	
	/**
	 * obtenir la liste des idUsr qui ont indiqué un referent dans la table UPD_IND_REFERENT
	 * @return listIdUsrFromUPD_IND_REF
	 */
	public ArrayList<String> getlistIdUsrFromUPD_IND_REF();
	
	/**
	 * obtenir les path des lettres de recommandation par condidat dans la table UPD_IND_REFERENT 
	 * @param idUsr
	 * @return IdUsrLienRecommandation
	 */
	public Map<String, ArrayList<String>> getMapIdUsrLienRecommandation(ArrayList<String> idUsr);
	
	/**
	 * chercher les commissions en service dans la table commission
	 * @return listIdCmiEnService
	 */
	public ArrayList<String> getlistIdCmiEnService();
	
	/**
	 * chercher l'etat du dossier pour une commission dans la table ind_voeu
	 * @param idLink
	 * @return
	 */
	public Map<String, String> getMapIdUsrDossierComplet(String idLink);
	
	/**
	 * trouver id trt cmi pouir uen commission dans la table trt_cmi_vet
	 * @param idCmi
	 * @return IdTrtCmi
	 */
	public String getIdTrtCmi(String idCmi);
	
	/**
	 * trouver id link pour un id trt cmi dans la table  la table link_trt_cmi_camp
	 * @param idTrtCmi
	 * @return idLink
	 */
	public String getIdLink(String idTrtCmi);
	
	/**
	 * obtenir traitement par etudiant dans une commission dans la table UPD_EXAMEN_DOSSIER
	 * @param idUsr
	 * @param idCmi
	 * @return MapIdUsrEtudiantTraitement
	 */
	public Map<String, String> getMapIdUsrEtudiantTraitement(String idUsr, String idCmi);
	
	/**
	 * obtenir observation par etudiant dans une commission dans la table UPD_EXAMEN_DOSSIER
	 * @param idUsr
	 * @param idCmi
	 * @return MapIdUsrEtudiantObservation
	 */
	public Map<String, String> getMapIdUsrEtudiantObservation(String idUsr, String idCmi);
	
	/**
	 * mettre à jour observation et traitement pour un etudiant dans une commission dans la table UPD_EXAMEN_DOSSIER
	 * @param idUsr
	 * @param idUsrEtudiant
	 * @param idCmi
	 * @param etat
	 * @param Observation
	 */
	public  void updateObsTrait(String idUsr, String idUsrEtudiant, String idCmi, String etat, String Observation);
	
	/**
	 * insertion observation et traitement pour un etudiant dans une commission dans la table UPD_EXAMEN_DOSSIER
	 * @param idUsr
	 * @param idUsrEtudiant
	 * @param idCmi
	 * @param etat
	 * @param Observation
	 */
	public void insertObsTrait(String idUsr, String idUsrEtudiant, String idCmi, String etat, String Observation);
	
	/**
	 * retourne vrai si une observation ou un traitement a deja ete deposer par un member dans une commission dans la table UPD_EXAMEN_DOSSIER
	 * @param idUsr
	 * @param idUsrEtudiant
	 * @param idCmi
	 * @return boolean
	 */
	public boolean ligneExist(String idUsr, String idUsrEtudiant, String idCmi);
	
	/**
	 * retourne les candidat traités pour une commission par un gestionnaire dans la table UPD_EXAMEN_DOSSIER
	 * @param idUsr
	 * @param idCmi
	 * @return listEtudiantTraite
	 */
	public ArrayList<String> getListEtudiantTraite(String idUsr, String idCmi);
	
	/**
	 * retourn les candidats non traités pour une commission par un gestionnaire dans la table UPD_EXAMEN_DOSSIER
	 * @param idUsr
	 * @param idCmi
	 * @return listEtudiantNonTraite
	 */
	public ArrayList<String> getListEtudiantNonTraite(String idUsr, String idCmi);
	
	/**
	 * retourne les candidats en cours de traitement pour une commission par un gestionnaire dans la table UPD_EXAMEN_DOSSIER
	 * @param idUsr
	 * @param idCmi
	 * @return listEtudiantEnCoursTraitement
	 */
	public ArrayList<String> getListEtudiantEnCoursTraitement(String idUsr, String idCmi);
	
	/**
	 * verification si un fichier existe dans la la table UPD_IND_FICHIER
	 * @param emplacement
	 * @return boolean
	 */
	public boolean fileInBDD(String emplacement);
	
	/**
	 * verification si un fichier existe dans la la table UPD_IND_REFERENT
	 * @param emplacement
	 * @return boolean
	 */
	public boolean recommandationInBDD(String emplacement);
	
	
	/**
	 * Les emplacement des fichiers pour un idCmi dans la table UPD_IND_FICHIER
	 * @param idCmi
	 * @return listEmplacements
	 */
	public ArrayList<String> getListEmplacements(String idCmi);
	
	/**
	 * obtenir le dernier diplome obtenue pour un idUsrEtudiant
	 * @ return typeCurSco
	 */
	public String getTypeCurSco(String idUsrEtudiant);
	
	/**
	 * obtenir la derniere provenance de idUsrEtudiant
	 * @ return libEtbEtrCurExt
	 */
	public String getLibEtbEtrCurExt(String idUsrEtudiant);
	
	/**
	 * 
	 * @param idSession
	 * @param sessionStartTime
	 * @return
	 */
	public boolean filtreExiste(String idSession, String sessionStartTime);

	/**
	 * 
	 * @param login
	 * @param codeNomFichiers
	 * @param idCmi
	 * @param sessionStartTimeSimpleFormat 
	 * @param idCmi2 
	 */
	public String insertFichiersAAffiche(String login, String codeNomFichiers,
			String idCmi, String idCmi2, String sessionStartTimeSimpleFormat);
	
	public String insertEtablissementAAffiche(String idSession, String login, String codeEtab,
			String idCmi, String sessionStartTime);

	/**
	 * 
	 * @param idSession
	 * @param login
	 * @param idCmi
	 * @return
	 */
	public ArrayList<String> getListFichiersAAffiche(String idSession,
			String login, String idCmi);
	
	/**
	 * 
	 * @param idSession
	 * @param login
	 * @param idCmi
	 * @return
	 */
	public String getEtablissementAAffiche(String idSession,
			String login, String idCmi);

	/**
	 * 
	 * @param login
	 * @param idSession
	 * @return
	 */
	public boolean existeDansUPDConsul(String idSession, String login, String idCmi);

	/**
	 * 
	 * @param idSession
	 * @param login
	 * @param codeNomFichiers
	 * @param idCmi
	 * @param sessionStartTimeSimpleFormat
	 */
	public void updateFichiersAAffiche(String idSession, String login,
			String codeNomFichiers, String idCmi,
			String sessionStartTimeSimpleFormat);
	
	public void updateEtablissementAAffiche(String idSession, String login,
			String codEtab, String idCmi,
			String sessionStartTimeSimpleFormat);

	/**
	 * A faire
	 * @param nom
	 * @return
	 */
	public String getLogin(String nom);
	
	/**
	 * 
	 * @param idUsr
	 * @param idProfile
	 */
	public ArrayList<String> getIdCmisFromRightOnCmi(String idUsr, String idProfile);
	
	/**
	 * 
	 * @param idUsr
	 * @param idProfile
	 * @return
	 */
	public ArrayList<String> getAllIdCmis(String idUsr, String idProfile);
	
	/**
	 * 
	 * @param idCmi
	 * @return
	 */
	public String getLibCmi(String idCmi);

	/**
	 * 
	 * @param idUsrEtudiant
	 * @param idCmi
	 * @return
	 */
	public String getAvis(String idUsrEtudiant, String idCmi);

	/**
	 * retourne la liste des avis possibles
	 * @return
	 */
	public ArrayList<String> getlistLicNomAvis();

	/**
	 * 
	 * @param codeRi
	 * @return
	 */
	public Map<String, String> getMapLibNomsPcLicNomsPc(String codeRi);

	/**
	 * 
	 * @param mapCodeEtapeIdNomPs
	 * @return
	 */
	public Map<String, String> getMapLibNomsPsLibNomsPs(
			Map<String, ArrayList<String>> mapCodeEtapeIdNomPs);
	
	/**
	 * obtenir emplacement file selon id_usr, id_cmi, codeFile
	 * @param id_usr
	 * @param id_cmi
	 * @param codeFile
	 * @return
	 */
	public String EmplacementCodeFile(String id_usr, String id_cmi, String codeFile);

	public ArrayList<String> getListIdNomPs(String codeEtape, String codeVet);

	public String getCodeNomPs(String idNomPs);

	public String getLibNomPs(String idNomPs);

	public String getLicNomPs(String idNomPs);

	public ArrayList<String> getListEtudiant(String codeEtape, String codeVet);

	public String getNomEtudiant(String idUsrEtudiant);

	public String getNumDossier(String idUsrEtudiant);

	public ArrayList<String> getListIdUsrEtudiantRechercheNom(String recherche);

	public String getIdUsrEtudiantRechercheNumDossier(
			String rechercheNumDossier);

	public ArrayList<String> getlistIdUsrNoFileAlireUploadedForIdCmi(String idCmi);
	
	public String getDateFin(String idCmi);
	
	public String dernierCodEtabEtudiant(String id_usr);
	
	public ArrayList<String> getListIdUsrEtudiant(String idCmi);

	public ArrayList<String> getListNomEtudiant(String idCmi);

	public ArrayList<String> getListNumDossierEtudiant(String idCmi);
	
	public boolean existeDansUPDFiltreEtab(String login, String idSession, String idCmi);
}
