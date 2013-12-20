package com.lr_mvc.DAO;

import java.sql.Connection;
import java.util.ArrayList;

public interface CommandesBDD {
	
	public boolean ConnectionBDD(String name, String driver, String user, String code);
	
	public void deconnexion();
	/**
	 * setter de l'attribut con
	 * @param con
	 */
	public void setConnection(Connection con);
	
	/**
	 * obtenir la liste des mails des referents dans la table UPD_REFERENT
	 * @return listMailRef
	 */
	public ArrayList<String> getListMailRef();
	
	/**
	 * obtenir la password d'un referent dans la table UPD_REFERENT
	 * @param mail
	 * @return passwordRef
	 */
	public String getPasswordRef(String mail);
	
	/**
	 * obtenir le nom du referent dans la table UPD_REFERENT
	 * @param mail
	 * @return nomRef
	 */
	public String getNomRef(String mail);
	
	/**
	 * obtenir le prenom du referent dans la table UPD_REFERENT
	 * @param mail
	 * @return prenomRef
	 */
	public String getPrenomRef(String mail);
	
	/**
	 * obtenir le id du referent dans la table UPD_REFERENT
	 * @param mail
	 * @return idRef
	 */
	public String getIdRef(String mail);
	
	/**
	 * obtenir la liste des idUsr pour un referent dans la table UPD_IND_REFERENT
	 * @param idRef
	 * @return
	 */
	public ArrayList<String> getListIdUsr(String idRef);
	
	/**
	 * obtenir le nomUsr dans la table opi_user
	 * @param idUsr
	 * @return nomUsr
	 */
	public String getNomUsr(String idUsr);
	
	/**
	 * mise à jour de nom, prenom du referent dans la table UPD_REFERENT
	 * @param nomRef
	 * @param prenomRef
	 * @param adresseMail
	 */
	public void updateNomPrenomRef(String nomRef, String prenomRef, String titreRef, String fonctionRef, String adresseMail);
	
	/**
	 * obtenir le path de fichier de recommandation depose par un referent pour un etudiant dans la table UPD_IND_REFERENT
	 * @param idRef
	 * @param idUsr
	 * @return nomFile
	 */
	public String getNomFile(String idRef, String idUsr);
	
	/**
	 * mise à jour du path et de la date d'un fihier de recommandation depose par un referent dans la table UPD_IND_REFERENT
	 * @param idRef
	 * @param idUsr
	 * @param nomFile
	 * @param date
	 * @return ""
	 */
	public String updateNomFileDate(String idRef, String idUsr, String nomFile, String date);
	
	/**
	 * obtenir le mailUsr d'un idUsr dans la table opi_user where
	 * @param idUsr
	 * @return mailUsr
	 */
	public String getMailUsr(String idUsr);

	/**
	 * obtenir le lien unique d'identification du referent de la table UPD_REFERENT
	 * @param mail
	 * @return lien unique d'identification
	 */
	public String getLienCompletForRef(String mail);

	/**
	 * insertion du mot de passe pour referent dans la table UPD_REFERENT
	 * @param adresseMail
	 * @param password
	 */
	public void setMDPForRef(String adresseMail, String password);

	/**
	 * mise a jour du lien pour referent dans la table UPD_REFERENT
	 * @param lienComplet
	 * @param adresseMail
	 */
	public void updateLienReferent(String lienComplet, String adresseMail);

}
