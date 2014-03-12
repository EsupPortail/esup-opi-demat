package com.lr_mvc.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ImplementCommandes implements CommandesBDD {
	/**
	 * attribut de connection
	 */
	Connection con;
	
	public boolean ConnectionBDD(String name, String driver, String user, String code) {
		try {
			Class.forName(name);
			con = DriverManager.getConnection(driver, user, code);
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}
	
	public void deconnexion() {
		if(con != null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


	public void setConnection(Connection con) {
		this.con = con;
	}

	@Override
	public ArrayList<String> getListMailRef() {
		ArrayList<String> listMailRef = new ArrayList<String>();
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select mail_ref from UPD_REFERENT");
			while(rs1.next()){
				listMailRef.add(rs1.getObject(1).toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listMailRef;
	}
	
	@Override
	public String getPasswordRef(String mail) {
		String passwordRef = "";
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select mdp_ref from UPD_REFERENT where mail_ref='"+mail+"'");
			if (rs1.next())
				passwordRef = rs1.getObject(1).toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return passwordRef;
	}

	@Override
	public ArrayList<String> getListIdUsr(String idRef) {
		ArrayList<String> listIdUsr = new ArrayList<String>();
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select id_usr from UPD_IND_REFERENT where id_ref='"+idRef+"'");
			while(rs1.next()){
				listIdUsr.add(rs1.getObject(1).toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listIdUsr;
	}

	@Override
	public String getPrenomRef(String mail) {
		String prenomRef = "";
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select prenom_ref from UPD_REFERENT where mail_ref='"+mail+"'");
			if(rs1.next() && rs1.getString("prenom_ref") != null)
				prenomRef = rs1.getObject(1).toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prenomRef;
	}

	@Override
	public String getIdRef(String mail) {
		String idRef = "";
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select id_ref from UPD_REFERENT where mail_ref='"+mail+"'");
			if(rs1.next())
				idRef = rs1.getObject(1).toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idRef;
	}

	@Override
	public String getNomRef(String mail) {
		String nomRef = "";
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select nom_ref from UPD_REFERENT where mail_ref='"+mail+"'");
			if(rs1.next() && rs1.getString("nom_ref") != null)
				nomRef = rs1.getObject(1).toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nomRef;
	}
	
	@Override
	public String getNomUsr(String idUsr) {
		String NomUsr = null;
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("SELECT lib_nom_pat_usr,lib_pr1_usr FROM opi_user WHERE id_usr='"+idUsr+"'");
			if(rs1.next())
				NomUsr = rs1.getObject(1).toString()+" "+rs1.getObject(2).toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return NomUsr;
	}

	@Override
	public void updateNomPrenomRef(String nomRef, String prenomRef,  String titreRef, String fonctionRef, String adresseMail) {
		Statement stmt1 = null;
		try {
			stmt1 = con.createStatement();
			stmt1.executeUpdate("UPDATE `UPD_REFERENT` SET `nom_ref` = '"+nomRef+"', `prenom_ref` = '"+prenomRef+"', titre_ref='"+titreRef+"', organisme_ref='"+fonctionRef+"' WHERE `UPD_REFERENT`.`mail_ref` ='"+adresseMail+"'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public String getNomFile(String idRef, String idUsr) {
		String nomFile = "";
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select nom_fichier_recommandation from UPD_IND_REFERENT where id_usr='"+idUsr+"' and id_ref='"+idRef+"'");
			if(rs1.next() && rs1.getString("nom_fichier_recommandation") != null)
				nomFile = rs1.getObject(1).toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nomFile;
	}

	@Override
	public String updateNomFileDate(String idRef, String idUsr, String nomFile,
			String date) {
		Statement stmt1 = null;
		try {
			stmt1 = con.createStatement();
			stmt1.executeUpdate("update UPD_IND_REFERENT set nom_fichier_recommandation='"+nomFile+"', dat_depot_recommandation='"+date+"'  where UPD_IND_REFERENT.id_usr='"+idUsr+"' and UPD_IND_REFERENT.id_ref='"+idRef+"'");
		} catch (SQLException e) {
			e.printStackTrace();
			return e.toString();
		}
		return"";
	}

	@Override
	public String getMailUsr(String idUsr) {
		String mailUsr = "";
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select lib_mail_usr from opi_user where id_usr='"+idUsr+"'");
			if(rs1.next())
				mailUsr = rs1.getObject(1).toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mailUsr;
	}

	
	@Override
	public String getLienCompletForRef(String mail) {
		String lienComplet  = "";
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select lien_mdp_ref from UPD_REFERENT where mail_ref='"+mail+"'");
			if(rs1.next()){
				lienComplet = rs1.getObject(1).toString();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return e.toString();
		}
		return lienComplet;
	}

	@Override
	public void setMDPForRef(String adresseMail, String password) {
		Statement stmt1 = null;
		try {
			stmt1 = con.createStatement();
			stmt1.executeUpdate("update UPD_REFERENT set mdp_ref = MD5('"+password+"') , lien_mdp_ref = '' WHERE mail_ref='"+adresseMail+"'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateLienReferent(String lienComplet, String adresseMail) {
		Statement stmt1 = null;
		try {
			stmt1 = con.createStatement();
			stmt1.executeUpdate("update UPD_REFERENT set lien_mdp_ref = '"+lienComplet+"' WHERE mail_ref='"+adresseMail+"'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
