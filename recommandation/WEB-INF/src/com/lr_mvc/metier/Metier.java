package com.lr_mvc.metier;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Properties;

import com.lr_mvc.DAO.CommandesBDD;
import com.lr_mvc.DAO.ImplementCommandes;

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
	 * obtenir la liste des mails des referents
	 * @return liste des mails des referents
	 */
	public ArrayList<String> getListMailRef() {
		return commande.getListMailRef();
	}
	
	/**
	 * obtenir la password d'un referent
	 * @param adresseMail
	 * @return password d'un referent
	 */
	public String getPasswordRef(String adresseMail) {
		return commande.getPasswordRef(adresseMail);
	}
	
	/**
	 * obtenir le prenom du referent
	 * @param adresseMail
	 * @return prenom du referent
	 */
	public String getPrenomRef(String adresseMail) {
		return commande.getPrenomRef(adresseMail);
	}
	
	/**
	 * obtenir le nom du referent
	 * @param adresseMail
	 * @return nom du referent
	 */
	public String getNomRef(String adresseMail) {
		return commande.getNomRef(adresseMail);
	}
	
	/**
	 * obtenir le id du referent
	 * @param mail
	 * @return id du referent
	 */
	public String getIdRef(String mail) {
		return commande.getIdRef(mail);
	}
	
	/**
	 * mise à jour de nom, prenom du referent
	 * @param nomRef
	 * @param prenomRef
	 * @param titreRef
	 * @param fonctionRef
	 * @param adresseMail
	 */
	public void updateNomPrenomRef(String nomRef, String prenomRef, String titreRef, String fonctionRef, String adresseMail) {
		commande.updateNomPrenomRef(nomRef, prenomRef, titreRef, fonctionRef, adresseMail);
	}

	/**
	 * obtenir la liste des idUsr pour un referent
	 * @param idRef
	 * @return liste des idUsr pour un referent
	 */
	public ArrayList<String> getListIdUsr(String idRef) {
		return commande.getListIdUsr(idRef);
	}
	
	/**
	 * obtenir le nomUsr 
	 * @param idUsr
	 * @return nomUsr 
	 */
	public String getNomUsr(String idUsr) {
		return commande.getNomUsr(idUsr);
	}
	
	/**
	 * obtenir le path de fichier de recommandation depose par un referent pour un etudiant
	 * @param idRef
	 * @param idUsr
	 * @return path de fichier de recommandation depose par un referent pour un etudiant
	 */
	public String getNomFile(String idRef, String idUsr) {
		return commande.getNomFile(idRef, idUsr);
	}
	
	/**
	 * mise à jour du path et de la date d'un fihier de recommandation depose par un referent
	 * @param idRef
	 * @param idUsr
	 * @param CopieFile
	 * @param date
	 * @return
	 */
	public String updateNomFileDate(String idRef, String idUsr, String CopieFile, String date) {
		return commande.updateNomFileDate(idRef, idUsr, CopieFile, date);
	}
	
	/**
	 * obtenir le mailUsr d'un idUsr 
	 * @param idUsr
	 * @return mailUsr d'un idUsr 
	 */
	public String getMailUsr(String idUsr) {
		return commande.getMailUsr(idUsr);
	}
	
	/**
	 * obtenir le lien unique d'identification du referent
	 * @param adresseMail
	 * @return lien unique d'identification du referent
	 */
	public String getLienCompletForRef(String adresseMail) {
		return commande.getLienCompletForRef(adresseMail);
	}
	
	/**
	 * insertion du mot de passe pour referent 
	 * @param adresseMail
	 * @param password
	 */
	public void setMDPForRef(String adresseMail, String password) {
		commande.setMDPForRef(adresseMail, password);
	}
	
	/**
	 * mise a jour du lien pour referent
	 * @param lienComplet
	 * @param adresseMail
	 */
	public void updateLienReferent(String lienComplet, String adresseMail) {
		commande.updateLienReferent(lienComplet, adresseMail);
	}
	
	/**
	 * Encodage MD5
	 * @param password
	 * @param algorithm
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static String encode(String password, String algorithm)
			throws NoSuchAlgorithmException {
		byte[] hash = null;
		try {
			MessageDigest md = MessageDigest.getInstance(algorithm);
			hash = md.digest(password.getBytes());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < hash.length; ++i) {
			String hex = Integer.toHexString(hash[i]);
			if (hex.length() == 1) {
				sb.append(0);
				sb.append(hex.charAt(hex.length() - 1));
			} else {
				sb.append(hex.substring(hex.length() - 2));
			}
		}
		return sb.toString();
	}

}
