package com.de_mvc.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 * implementation de CommandesBDD
 * @author root
 * @version 1.0
 */
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


	@Override
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	@Override
	public Connection getConnection() {
		return con;
	}


	@Override
	public boolean verifNumDossier(String numDossier) {
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select num_dos_opi, id_usr from individu");
			// displaying records
			while(rs1.next()){
				if(numDossier.equals(rs1.getObject(1).toString().toUpperCase())){
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public String getDateNaissance(String numDossier) {
		String dateNaissance = null;
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select dat_nai_ind from individu where num_dos_opi='"+numDossier+"'");
			if(rs1.next())
				dateNaissance = rs1.getObject(1).toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dateNaissance;
	}


	@Override
	public String getIdUsr(String numDossier) {
		String idUsr = null;
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select id_usr from individu where num_dos_opi='"+numDossier+"'");
			if(rs1.next())
				idUsr = rs1.getObject(1).toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idUsr;
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
	public String[] getTabIdLinks(String idUsr) {
		String[] tabLinks = null;
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("Select id_link from ind_voeu where tem_en_sve_voeu='Y' and id_usr='"
							+ idUsr + "'");
			// nbre de links
			rs1.last();
			int size = rs1.getRow();
			rs1.beforeFirst();
			
			tabLinks = new String[size];
			int i = 0;
			while (rs1.next()) {
				tabLinks[i++] = rs1.getObject(1).toString();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tabLinks;
	}


	@Override
	public ArrayList<String> getListIdTrtCmi(String[] tabLinks) {
		ArrayList<String> tabTrtCmi = new ArrayList<String>();
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			for (int j = 0; j <= tabLinks.length - 1; j++) {
				rs1 = stmt1.executeQuery("Select id_trt_cmi from link_trt_cmi_camp where tem_en_sve_link='Y' and id_link='"
								+ tabLinks[j] + "'");
				if (rs1.next())
					tabTrtCmi.add(rs1.getObject(1).toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tabTrtCmi;
	}


	@Override
	public ArrayList<String> getCodeEtapes(ArrayList<String> listTrtCmis) {
		ArrayList<String> codeEtapes = new ArrayList<String>();
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			for (String trtCmi : listTrtCmis) {
				rs1 = stmt1.executeQuery("Select  `cod_etp_trt_cmi`, `cod_vrs_vet_trt_cmi` from trt_cmi_vet where id_trt_cmi='"
								+ trtCmi + "'");
				if (rs1.next()) {
					codeEtapes.add(rs1.getObject(1).toString());
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return codeEtapes;
	}


	@Override
	public ArrayList<String> getCodeVets(ArrayList<String> listTrtCmis) {
		ArrayList<String> codeVets = new ArrayList<String>();
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			for (String trtCmi :  listTrtCmis) {
				rs1 = stmt1.executeQuery("Select  `cod_etp_trt_cmi`, `cod_vrs_vet_trt_cmi` from trt_cmi_vet where id_trt_cmi='"
								+ trtCmi + "'");
				if (rs1.next()) {
					codeVets.add(rs1.getObject(2).toString());
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return codeVets ;
	}


	@Override
	public String getIdCmi(String idTrtCmi) {
		String idCmi = "";
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("SELECT id_cmi FROM trt_cmi_vet WHERE id_trt_cmi ='"+idTrtCmi+"'");
			if(rs1.next())
				idCmi = rs1.getObject(1).toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idCmi ;
	}


	@Override
	public String getDateDeb(String idCmi) {
		String dateDeb = "";
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("Select dat_dbt, dat_fin from calendar, cal_ins_cmi" +
					" where calendar.id_cal = cal_ins_cmi.id_cal_ins" +
					"  and cal_ins_cmi.id_cmi='"+idCmi+"'");
			if(rs1.next())
				 dateDeb = rs1.getObject(1).toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dateDeb ;
	}


	@Override
	public String getDateFin(String idCmi) {
		String dateFin = "";
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select dat_end_back_dossier from calendar, commission where calendar.id_cal = commission.id_cal_cmi and commission.id_cmi='"+idCmi+"'");
			if(rs1.next())
				 dateFin = rs1.getObject(1).toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dateFin ;
	}


	@Override
	public String getCodeRiNom(String idUsr) {
		String codeRiNom = "";
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select cod_ri_nom from ind_camp, nomenclature" +
					" where nomenclature.id_nom=ind_camp.id_nom and id_usr='"+idUsr+"'");
			if(rs1.next())
				codeRiNom = rs1.getObject(1).toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return codeRiNom;
	}

	@Override
	public ArrayList<String> getListPJO(String codeRiNom) {
		ArrayList<String> listPJO = new ArrayList<String>();
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select id_nom, type_nom, cod_nom, lib_nom, lic_nom from nomenclature" +
					" where `type_nom`='PIECE_JST'" +
					" and tem_en_sve_nom='Y'" +
					" and `is_for_all_vet_nom`='Y'" +
					" and cod_ri_nom='"+codeRiNom+"'");
			while(rs1.next())
				listPJO.add(rs1.getObject(4).toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listPJO;
	}

	@Override
	public ArrayList<String> getListCodePJO(String codeRiNom) {
		ArrayList<String> listCodePJO = new ArrayList<String>();
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select id_nom, type_nom, cod_nom, lib_nom, lic_nom from nomenclature" +
					" where `type_nom`='PIECE_JST'" +
					" and tem_en_sve_nom='Y'" +
					" and `is_for_all_vet_nom`='Y'" +
					" and cod_ri_nom='"+codeRiNom+"'");
			while(rs1.next())
				listCodePJO.add(rs1.getObject(3).toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listCodePJO;
	}


	@Override
	public ArrayList<String> getListIdNom(String codeEtape, String codeVet) {
		ArrayList<String> listIdNom = new ArrayList<String>(); 
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("Select id_nom from piece_justi_vet where cod_etp_pc_jst_vet='"+codeEtape+"' and cod_vrs_vet_pc_jst_vet='"+codeVet+"'");
			while(rs1.next())
				listIdNom.add(rs1.getObject(1).toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listIdNom ;
	}

	
	@Override
	public ArrayList<String> getListPJS(String codeRiNom,
			ArrayList<String> listIdNom) {
		ArrayList<String> listPJS = new ArrayList<String>();
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			for(String s : listIdNom){
				rs1 = stmt1.executeQuery("select id_nom, type_nom, cod_nom, lib_nom, lic_nom from nomenclature" +
						" where `type_nom`='PIECE_JST'" +
						" and tem_en_sve_nom='Y'" +
						" and `is_for_all_vet_nom`='N'" +
						" and cod_ri_nom='"+codeRiNom+"'" +
						" and id_nom='"+s+"'");
				if(rs1.next())
					listPJS.add(rs1.getObject(4).toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listPJS ;
	}

	@Override
	public ArrayList<String> getListCodePJS(String codeRiNom,
			ArrayList<String> listIdNom) {
		ArrayList<String> listCodePJS = new ArrayList<String>();
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			for(String s : listIdNom){
				rs1 = stmt1.executeQuery("select id_nom, type_nom, cod_nom, lib_nom, lic_nom from nomenclature" +
						" where `type_nom`='PIECE_JST'" +
						" and tem_en_sve_nom='Y'" +
						" and `is_for_all_vet_nom`='N'" +
						" and cod_ri_nom='"+codeRiNom+"'" +
						" and id_nom='"+s+"'");
				if(rs1.next())
					listCodePJS.add(rs1.getObject(3).toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listCodePJS;
	}


	@Override
	public String getIdNom(String codeNom) {
		String idNom = "";
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select id_nom from nomenclature where cod_nom='"
					+ codeNom.substring(codeNom
							.indexOf("=") + 1) + "'");
			if (rs1.next()) 
				idNom = rs1.getObject(1).toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idNom;
	}


	@Override
	public void delFile(String idNom, String idCmi, String idUsr) {
		Statement stmt1 = null;
		try {
			stmt1 = con.createStatement();
			stmt1.executeUpdate("Delete from "
					+ "`candidatures`.`UPD_IND_FICHIER`"
					+ " where id_usr='"
					+ idUsr
					+ "' and id_cmi='"
					+ idCmi
					+ "'"
					+ " and TYPE_PIECE_JUSTIF='"
					+ idNom + "'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void insertFile(String idUsr, String idCmi, String idNom,
			String repertoire, String name, String extention) {
		Statement stmt1 = null;
		try {
			stmt1 = con.createStatement();
			stmt1.executeUpdate("INSERT INTO"
								+ " `candidatures`.`UPD_IND_FICHIER`"
								+ " (`ID_FICHIER`, `id_usr`, `id_cmi`, `DATE_UPLOAD`, `TYPE_PIECE_JUSTIF`, `Emplacement`)"
								+ " VALUES "
								+ "(NULL, '"
								+ idUsr
								+ "', '"
								+ idCmi
								+ "', sysdate(), '"
								+ idNom
								+ "', '"
								+ repertoire
								+ "/"
								+ name
								+ extention + "')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	@Override
	public String getNomFile(String codeNom) {
		String nomFile = "";
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select lib_nom from nomenclature where cod_nom='"
					+ codeNom
					+ "'");
			if (rs1.next())
				nomFile = rs1.getObject(1).toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nomFile;
	}

	@Override
	public String nbMailRecommandation(String idUsr){
		String nbMailRecommandation = "";
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select count(id_usr) from UPD_IND_REFERENT where id_usr='"+idUsr+"'");
			if (rs1.next())
				nbMailRecommandation = rs1.getObject(1).toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nbMailRecommandation;
	}
	
	
	public ArrayList<String> getMailRefs(){
		ArrayList<String> listMailRefs = new ArrayList<String>();
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select mail_ref from UPD_REFERENT");
			while(rs1.next())
				listMailRefs.add(rs1.getObject(1).toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listMailRefs;
	}

	@Override
	public ArrayList<String> getMailRefsForUsr(String idUsr) {
		ArrayList<String> listMailRefsForUsr = new ArrayList<String>();
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select mail_ref from UPD_REFERENT, UPD_IND_REFERENT" +
					" where UPD_REFERENT.id_ref=UPD_IND_REFERENT.id_ref and UPD_IND_REFERENT.id_usr='"+idUsr+"'");
			while(rs1.next())
				listMailRefsForUsr.add(rs1.getObject(1).toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listMailRefsForUsr;
	}


	@Override
	public String getIdRef(String mail) {
		String idRef = "";
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select id_ref from UPD_REFERENT where mail_ref='"+mail+"'");
			if (rs1.next())
				idRef = rs1.getObject(1).toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idRef;
	}


	@Override
	public void insertNewRef(String mailRef, String password) {
		Statement stmt1 = null;
		try {
			stmt1 = con.createStatement();
			stmt1.executeUpdate("INSERT INTO `candidatures`.`UPD_REFERENT` (`id_ref`, `mail_ref`, `mdp_ref`, `date_cre_ref`, `dat_mod_ref`, `titre_ref`, `organisme_ref`, `lien_mdp_ref`) VALUES (NULL, '"+mailRef+"', '"+password+"', CURDATE(), CURDATE(), '', '', '')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void insertNewRefForUsr(String idRef, String idUsr) {
		Statement stmt1 = null;
		try {
			stmt1 = con.createStatement();
			stmt1.executeUpdate("INSERT INTO `candidatures`.`UPD_IND_REFERENT` (`id_usr`, `id_ref`) VALUES ('"+idUsr+"', '"+idRef+"')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
	public boolean fileInBDD(String idCmi, String idUsr, String emplacement) {
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select * from UPD_IND_FICHIER where id_usr='"+idUsr+"' and id_cmi='"+idCmi+"' and Emplacement='"+emplacement+"'");
			if (rs1.next())
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public ArrayList<String> getListEmplacements(String idCmi) {
		ArrayList<String> listEmplacements = new ArrayList<String>();
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select Emplacement from UPD_IND_FICHIER where id_cmi='"+idCmi+"'");
			while(rs1.next()){
				listEmplacements.add(rs1.getObject(1).toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listEmplacements;
	}


	@Override
	public boolean lienIdentifRefExiste(String lien) {
		boolean lienExiste = false;
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select lien_mdp_ref from UPD_REFERENT where lien_mdp_ref='"+lien+"'");
			if(rs1.next()){
				lienExiste = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lienExiste;
	}


	@Override
	public void insertNewRefLienUnique(String mail, String lienComplet) {
		Statement stmt1 = null;
		try {
			stmt1 = con.createStatement();
			stmt1.executeUpdate("INSERT INTO `candidatures`.`UPD_REFERENT` (`id_ref`, `mail_ref`, `mdp_ref`, `date_cre_ref`, `dat_mod_ref`, titre_ref, organisme_ref, lien_mdp_ref) VALUES (NULL, '"+mail+"', '', CURDATE(), CURDATE(), '', '', '"+lienComplet+"')");
			
		} catch (SQLException e) {
			System.out.print("erreur");
			e.printStackTrace();
		}
		
		
	}


	@Override
	public boolean referentDisposeLien(String mail) {
		boolean lienExiste = false;
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select lien_mdp_ref from UPD_REFERENT where mail_ref='"+mail+"'");
			if(rs1.next() && rs1.getObject(1).toString().trim().length() != 0){
				lienExiste = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lienExiste;
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
	public ArrayList<String> getListLibCmis(ArrayList<String> listTrtCmis) {
		ArrayList<String> listLibCmi = new ArrayList<String>();
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			for (String trtCmi : listTrtCmis) {
				rs1 = stmt1.executeQuery("SELECT `trt_cmi_vet`.`id_cmi`, lib_cmi FROM `trt_cmi_vet`, commission WHERE `trt_cmi_vet`.`id_trt_cmi`='"+trtCmi+"' and `trt_cmi_vet`.id_cmi=commission.id_cmi");
				if (rs1.next())
					listLibCmi.add(rs1.getObject(2).toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listLibCmi;
	}
	
	@Override
	public String getLibCmiFromIdCmi(String idCmi) {
		String libCmi = null;
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("SELECT lib_cmi FROM `trt_cmi_vet`, commission WHERE `trt_cmi_vet`.id_cmi=commission.id_cmi and trt_cmi_vet.id_cmi='"+idCmi+"'");
				if (rs1.next())
					libCmi = rs1.getObject(1).toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return libCmi;
	}

	@Override
	public ArrayList<String> getListFichiersEnBDD(String idCmi, String idUsr) {
		ArrayList<String> listFichiersEnBDD = new ArrayList<String>();
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select Emplacement from UPD_IND_FICHIER where id_usr='"+idUsr+"' and id_cmi='"+idCmi+"'");
			while(rs1.next()){
				listFichiersEnBDD.add(rs1.getObject(1).toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listFichiersEnBDD;
	}

	@Override
	public ArrayList<String> getListEmplacementsForIdCmiIdUsr(String idCmi, String idUsr) {
		ArrayList<String> listEmplacements = new ArrayList<String>();
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select Emplacement from UPD_IND_FICHIER where id_cmi='"+idCmi+"' and id_usr='"+idUsr+"'");
			while(rs1.next()){
				listEmplacements.add(rs1.getObject(1).toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listEmplacements;
	}
	
	public String getMailContent(String codeMail) {
		String content = null;
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select body_mail_cont from mail_content where cod_mail_cont='"+codeMail+"'");
				if (rs1.next())
					content = rs1.getObject(1).toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return content;
	}
	
	public String getMailSubject(String codeMail) {
		String subject = null;
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select sjt_mail_cont from mail_content  where cod_mail_cont='"+codeMail+"'");
				if (rs1.next())
					subject = rs1.getObject(1).toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return subject;
	}


	
	

	
	

}
