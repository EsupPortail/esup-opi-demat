package com.tg_mvc.tools;

import java.util.Properties;

import com.tg_mvc.DAO.CommandesBDD;
import com.tg_mvc.DAO.ImplementCommandes;
import com.tg_mvc.IntroWebService.EtablissementApogee;


public class MainTest {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		EtablissementApogee et = new EtablissementApogee();
		/*
		et.initConnexion();
		
		System.out.println(et.getEtablissementtMetier("0750736T")[0].getLibEtb());
		
		et.close();*/
		
		CommandesBDD commande = new ImplementCommandes();
		commande.ConnectionBDD("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/candidatures", "root", "Coloane1");
		
	    //commande.insertFichiersAAffiche("test1", "salahddine.aberkan@gmail.com", "test;test", "1", "2010-01-01");
		
		//commande.insertEtablissementAAffiche("test1", "salahddine.aberkan@gmail.com", "testetab",  "1", "2010-01-01");
		
		//commande.updateEtablissementAAffiche("test1", "salahddine.aberkan@gmail.com", "testetab2", "1", "2010-01-01");
		
		//commande.updateFichiersAAffiche("test1", "salahddine.aberkan@gmail.com", "testetab", "1", "2010-01-01");
		
		//System.out.println(commande.existeDansUPDFiltreEtab("salahddine.aberkan@gmail.com", "test1", "1"));

	}

}
