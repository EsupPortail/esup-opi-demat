package com.tg_mvc.DAO;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

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
	public boolean verifLogin(String login) {
		Statement stmt1 = null;
		ResultSet rs1 = null;
		boolean existe = false;;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select count(login_gest) from gestionnaire where login_gest='"+login+"'");

			if(rs1.next())
				if(rs1.getInt(1) == 1)
					existe = true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return existe;
	}

	@Override
	public String getDispName(String login) {
		Statement stmt1 = null;
		ResultSet rs1 = null;
		String dispName = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("SELECT `id_usr`, disp_name FROM `gestionnaire` WHERE `login_gest`='"+login+"'");
			if(rs1.next()){
				dispName = rs1.getObject(2).toString();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dispName;
	}

	@Override
	public String getIdUsr(String login) {
		Statement stmt1 = null;
		ResultSet rs1 = null;
		String idUsr = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("SELECT `id_usr`, disp_name FROM `gestionnaire` WHERE `login_gest`='"+login+"'");
			if(rs1.next()){
				idUsr = rs1.getObject(1).toString();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idUsr;
	}
	
	@Override
	public String getIdProfile(String idUsr) {
		Statement stmt1 = null;
		ResultSet rs1 = null;
		String idProfile = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select id_pro from gestionnaire where id_usr='"+idUsr+"'");
			if(rs1.next())
				idProfile = rs1.getObject(1).toString();
		}  catch (SQLException e) {
			e.printStackTrace();
		}
		return idProfile;
	}
	
	@Override
	public ArrayList<String> getIdCmis(String idUsr, String idProfile) {
		ArrayList<String> listIdCmis = new ArrayList<String>();
		/*if(!(idProfile.equals("1") || idProfile.equals("4") || idProfile.equals("7") || idProfile.equals("8"))){
			Statement stmt1 = null;
			ResultSet rs1 = null;
			try {
				stmt1 = con.createStatement();
				rs1 = stmt1.executeQuery("Select id_cmi from member where id_usr='"+idUsr+"'");
				while(rs1.next()){
					String idCmi = rs1.getObject(1).toString();
					listIdCmis.add(idCmi);
				}
			}  catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			Statement stmt1 = null;
			ResultSet rs1 = null;
			try {
				stmt1 = con.createStatement();
				rs1 = stmt1.executeQuery("Select id_cmi from commission");
				while(rs1.next()){
					String idCmi = rs1.getObject(1).toString();
					listIdCmis.add(idCmi);
				}
			}  catch (SQLException e) {
				e.printStackTrace();
			}
		}*/
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("Select id_cmi from member where id_usr='"+idUsr+"'");
			while(rs1.next()){
				String idCmi = rs1.getObject(1).toString();
				listIdCmis.add(idCmi);
			}
		}  catch (SQLException e) {
			e.printStackTrace();
		}
		return listIdCmis;
	}
	
	@Override
	public ArrayList<String> getIdCmisFromRightOnCmi(String idUsr,
			String idProfile) {
		ArrayList<String> listIdCmis = new ArrayList<String>();
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("Select id_cmi from rightOnCmi where id_usr='"+idUsr+"'");
			while(rs1.next()){
				String idCmi = rs1.getObject(1).toString();
				listIdCmis.add(idCmi);
			}
		}  catch (SQLException e) {
			e.printStackTrace();
		}
		return listIdCmis;
	}
	
	@Override
	public ArrayList<String> getAllIdCmis(String idUsr, String idProfile) {
		ArrayList<String> listIdCmis = new ArrayList<String>();
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("Select id_cmi from commission");
			while(rs1.next()){
				String idCmi = rs1.getObject(1).toString();
				listIdCmis.add(idCmi);
			}
		}  catch (SQLException e) {
			e.printStackTrace();
		}
		return listIdCmis;
	}

	@Override
	public ArrayList<String> getCodeCmis(ArrayList<String> idCmis) {
		ArrayList<String> listCodeCmis = new ArrayList<String>();
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			for(String idCmi : idCmis){
				rs1 = stmt1.executeQuery("Select cod_cmi, lib_cmi from commission where id_cmi='"+idCmi+"'");
				if(rs1.next()){
					listCodeCmis.add(rs1.getObject(1).toString());
				}
			}
		}  catch (SQLException e) {
			e.printStackTrace();
		}
		return listCodeCmis;
	}
	

	

	@Override
	public ArrayList<String> getLibCmis(ArrayList<String> idCmis) {
		ArrayList<String> listLibCmis = new ArrayList<String>();
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			for(String idCmi : idCmis){
				rs1 = stmt1.executeQuery("Select cod_cmi, lib_cmi from commission where id_cmi='"+idCmi+"'");
				if(rs1.next()){
					listLibCmis.add(rs1.getObject(2).toString());
				}
			}
		}  catch (SQLException e) {
			e.printStackTrace();
		}
		return listLibCmis;
	}

	@Override
	public String getCodeRi(String idCmi) {
		String codeRi = null;
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select cod_ri_nom from nomenclature, link_trt_cmi_camp"
							+ " where link_trt_cmi_camp.id_trt_cmi ='"
							+ idCmi
							+ "' and link_trt_cmi_camp.id_nom = nomenclature.id_nom");
			if (rs1.next())
				codeRi = rs1.getObject(1).toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return codeRi;
	}

	@Override
	public ArrayList<String> getListIdNomsPc(String codeRi) {
		ArrayList<String> listIdNomsPc = new ArrayList<String>();
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select id_nom, type_nom, cod_nom, lib_nom, lic_nom from nomenclature"
							+ " where `type_nom`='PIECE_JST'"
							+ " and tem_en_sve_nom='Y'"
							+ " and `is_for_all_vet_nom`='Y'"
							+ " and cod_ri_nom='" + codeRi + "'");

			while (rs1.next()) {
				listIdNomsPc.add(rs1.getObject(1).toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listIdNomsPc;
	}

	

	@Override
	public ArrayList<String> getlistCodeNomsPc(String codeRi) {
		ArrayList<String> listCodeNomsPc = new ArrayList<String>();
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1
					.executeQuery("select id_nom, type_nom, cod_nom, lib_nom, lic_nom from nomenclature"
							+ " where `type_nom`='PIECE_JST'"
							+ " and tem_en_sve_nom='Y'"
							+ " and `is_for_all_vet_nom`='Y'"
							+ " and cod_ri_nom='" + codeRi + "'");

			while (rs1.next()) {
				listCodeNomsPc.add(rs1.getObject(3).toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listCodeNomsPc;
	}
	
	@Override
	public ArrayList<String> getlistLibNomsPc(String codeRi) {
		ArrayList<String> listLibNomsPc = new ArrayList<String>();
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1
					.executeQuery("select id_nom, type_nom, cod_nom, lib_nom, lic_nom from nomenclature"
							+ " where `type_nom`='PIECE_JST'"
							+ " and tem_en_sve_nom='Y'"
							+ " and `is_for_all_vet_nom`='Y'"
							+ " and cod_ri_nom='" + codeRi + "'");

			while (rs1.next()) {
					listLibNomsPc.add(rs1.getObject(4).toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listLibNomsPc;
	}

	@Override
	public ArrayList<String> getlistCodeVets(String idCmi) {
		ArrayList<String> listCodeVets = new ArrayList<String>();
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("SELECT  `cod_etp_trt_cmi`,`cod_vrs_vet_trt_cmi` FROM `trt_cmi_vet` WHERE `id_cmi`='"
							+ idCmi + "'");
			while (rs1.next()) {
				listCodeVets.add(rs1.getObject(2).toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listCodeVets;
	}

	@Override
	public ArrayList<String> getlistCodeEtapes(String idCmi) {
		ArrayList<String> listCodeEtapes = new ArrayList<String>();
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("SELECT  `cod_etp_trt_cmi`,`cod_vrs_vet_trt_cmi` FROM `trt_cmi_vet` WHERE `id_cmi`='"
							+ idCmi + "'");
			while (rs1.next()) {
				listCodeEtapes.add(rs1.getObject(1).toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listCodeEtapes;
	}

	
	@Override
	public ArrayList<String> getListIdNomPs(String codeEtape, String codeVet) {
		ArrayList<String> listIdNomPs = new ArrayList<String>();
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("Select id_nom from piece_justi_vet where cod_etp_pc_jst_vet='"
					+ codeEtape + "' and cod_vrs_vet_pc_jst_vet='" + codeVet + "'");
			while(rs1.next())
				if(idNomEnService(rs1.getObject(1).toString()).equals("Y"))
					listIdNomPs.add(rs1.getObject(1).toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listIdNomPs;
	}
	
	@Override
	public Map<String, ArrayList<String>> getMapCodeEtapeIdNomPs(ArrayList<String> listCodeEtapes, ArrayList<String> listCodeVets) {
		Map<String, ArrayList<String>> MapCodeEtapeIdNomPs = new TreeMap<String, ArrayList<String>>();
		int i = 0;
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			for (String s : listCodeEtapes) {
				String s2 = listCodeVets.get(i);
				rs1 = stmt1.executeQuery("Select id_nom from piece_justi_vet where cod_etp_pc_jst_vet='"
								+ s
								+ "' and cod_vrs_vet_pc_jst_vet='"
								+ s2
								+ "'");
				i++;

				MapCodeEtapeIdNomPs.put(s, new ArrayList<String>());
				while (rs1.next())
					if(idNomEnService(rs1.getObject(1).toString()).equals("Y"))
						MapCodeEtapeIdNomPs.get(s).add(rs1.getObject(1).toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return MapCodeEtapeIdNomPs;
	}
	
	@Override
	public String getCodeNomPs(String idNomPs) {
		String codeNomsPs = null;
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select type_nom, cod_nom, lib_nom, lic_nom from nomenclature where  id_nom='" + idNomPs + "'");
			if (rs1.next()) 
				codeNomsPs = rs1.getObject(2).toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return codeNomsPs;
	}
	
	@Override
	public Map<String, ArrayList<String>> getMapCodeEtapeCodeNomPs(Map<String, ArrayList<String>> MapCodeEtapeIdNomPs) {
		Map<String, ArrayList<String>> MapCodeEtapeCodeNomPs = new TreeMap<String, ArrayList<String>>();
		// Map<String, ArrayList<String>> MapCodeEtapeLibNomPs = new TreeMap<String, ArrayList<String>>();
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			for (Map.Entry<String, ArrayList<String>> e : MapCodeEtapeIdNomPs
					.entrySet()) {
				MapCodeEtapeCodeNomPs.put(e.getKey(), new ArrayList<String>());
				//MapCodeEtapeLibNomPs.put(e.getKey(), new ArrayList<String>());
				for (String s : e.getValue()) {
					rs1 = stmt1.executeQuery("select type_nom, cod_nom, lib_nom, lic_nom from nomenclature where  id_nom='" + s + "'");

					if (rs1.next()) {
						MapCodeEtapeCodeNomPs.get(e.getKey()).add(rs1.getObject(2).toString());
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return MapCodeEtapeCodeNomPs;
	}
	
	@Override
	public String getLibNomPs(String idNomPs) {
		String libNomPs = null;
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select type_nom, cod_nom, lib_nom, lic_nom from nomenclature where  id_nom='" + idNomPs + "'");
			if (rs1.next()) 
				libNomPs = rs1.getObject(3).toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return libNomPs;
	}

	
	@Override
	public Map<String, ArrayList<String>> getMapCodeEtapeLibNomPs(Map<String, ArrayList<String>> MapCodeEtapeIdNomPs) {
		Map<String, ArrayList<String>> MapCodeEtapeLibNomPs = new TreeMap<String, ArrayList<String>>();
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			for (Map.Entry<String, ArrayList<String>> e : MapCodeEtapeIdNomPs
					.entrySet()) {
				MapCodeEtapeLibNomPs.put(e.getKey(), new ArrayList<String>());
				for (String s : e.getValue()) {
					rs1 = stmt1.executeQuery("select type_nom, cod_nom, lib_nom, lic_nom from nomenclature where  id_nom='"
									+ s + "'");

					if (rs1.next()) {
						MapCodeEtapeLibNomPs.get(e.getKey()).add(rs1.getObject(3).toString());
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return MapCodeEtapeLibNomPs;
	}

	@Override
	public ArrayList<String> getListEtudiant(String codeEtape, String codeVet) {
		ArrayList<String> listEtudiant = new ArrayList<String>();
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("SELECT id_usr FROM ind_voeu, link_trt_cmi_camp, trt_cmi_vet"
					+ " Where ind_voeu.id_link = link_trt_cmi_camp.id_link"
					+ " And link_trt_cmi_camp.id_trt_cmi= trt_cmi_vet.id_trt_cmi"
					+ " And tem_en_sve_voeu='Y'"
					+ " And trt_cmi_vet.cod_etp_trt_cmi='" + codeEtape
					+ "' and cod_vrs_vet_trt_cmi='" + codeVet + "'");
			
			while (rs1.next() && rs1.getObject(1) != null)
				listEtudiant.add(rs1.getObject(1).toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listEtudiant;
	}
	
	@Override
	public ArrayList<String> getListIdUsrEtudiant(String idCmi) {
		ArrayList<String> listEtudiant = new ArrayList<String>();
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("SELECT DISTINCT ind_voeu.id_usr, lib_nom_pat_usr FROM ind_voeu, link_trt_cmi_camp, trt_cmi_vet, opi_user"
					+ " Where ind_voeu.id_link = link_trt_cmi_camp.id_link"
					+ " And link_trt_cmi_camp.id_trt_cmi= trt_cmi_vet.id_trt_cmi"
					+ " And tem_en_sve_voeu='Y'"
					+ " And trt_cmi_vet.id_cmi='"+ idCmi +"'"
					+ " And opi_user.id_usr=ind_voeu.id_usr"
					+ " And ind_voeu.id_usr IN (select id_usr from UPD_IND_FICHIER where id_cmi='"+ idCmi +"')"
					+ " order by lib_nom_pat_usr");
			
			while (rs1.next() && rs1.getObject(1) != null)
				listEtudiant.add(rs1.getObject(1).toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listEtudiant;
	}
	
	@Override
	public Map<String, ArrayList<String>> getMapCodeEtapeIdUsrEtudiant(ArrayList<String> listCodeEtapes, ArrayList<String> listCodeVets) {
		Map<String, ArrayList<String>> MapCodeEtapeIdUsrEtudiant = new TreeMap<String, ArrayList<String>>();
		int i = 0;
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			for (String s : listCodeEtapes) {
				String s2 = listCodeVets.get(i);
				rs1 = stmt1.executeQuery("SELECT id_usr FROM ind_voeu, link_trt_cmi_camp, trt_cmi_vet"
								+ " Where ind_voeu.id_link = link_trt_cmi_camp.id_link"
								+ " And link_trt_cmi_camp.id_trt_cmi= trt_cmi_vet.id_trt_cmi"
								+ " And trt_cmi_vet.cod_etp_trt_cmi='"
								+ s
								+ "' and cod_vrs_vet_trt_cmi='" + s2 + "'");
				i++;

				MapCodeEtapeIdUsrEtudiant.put(s, new ArrayList<String>());
				while (rs1.next())
					MapCodeEtapeIdUsrEtudiant.get(s).add(
							rs1.getObject(1).toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return MapCodeEtapeIdUsrEtudiant;
	}
	
	@Override
	public ArrayList<String> getListIdUsrEtudiantRechercheNom(String recherche) {
		ArrayList<String> listIdUsrEtudiantRecherche = new ArrayList<String>();
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("SELECT individu.id_usr, `opi_user`.`lib_nom_pat_usr` FROM individu, `opi_user` " +
					"WHERE individu.id_usr=opi_user.id_usr and opi_user.`lib_nom_pat_usr` LIKE '%"+recherche+"%';");
			while(rs1.next() ) 
				if(rs1.getObject(1) != null)
					listIdUsrEtudiantRecherche.add(rs1.getObject(1).toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listIdUsrEtudiantRecherche;
	}

	@Override
	public String getNomEtudiant(String idUsrEtudiant) {
		String nomEtudiant = null;
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("SELECT `lib_nom_pat_usr`, `lib_nom_usu_usr`,`lib_pr1_usr`, num_dos_opi " +
					"FROM `opi_user`, individu WHERE individu.id_usr=opi_user.id_usr and opi_user.id_usr='"+idUsrEtudiant+"'");
			if (rs1.next() && rs1.getObject(1) != null && rs1.getObject(3) != null)
				if(rs1.getObject(2) != null && rs1.getObject(2).toString().trim().length() > 0 && !rs1.getObject(1).toString().trim().equals(rs1.getObject(2).toString().trim()))
					nomEtudiant = rs1.getObject(1).toString()+ " " + "(" + rs1.getObject(2).toString() + ")" + " " + rs1.getObject(3).toString();
				else
					nomEtudiant = rs1.getObject(1).toString()+ " " + rs1.getObject(3).toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nomEtudiant;
	}
	
	@Override
	public ArrayList<String> getListNomEtudiant(String idCmi) {
		ArrayList<String> listEtudiant = new ArrayList<String>();
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("SELECT DISTINCT ind_voeu.id_usr, lib_nom_pat_usr, lib_nom_usu_usr, lib_pr1_usr FROM ind_voeu, link_trt_cmi_camp, trt_cmi_vet, opi_user"
					+ " Where ind_voeu.id_link = link_trt_cmi_camp.id_link"
					+ " And link_trt_cmi_camp.id_trt_cmi= trt_cmi_vet.id_trt_cmi"
					+ " And tem_en_sve_voeu='Y'"
					+ " And trt_cmi_vet.id_cmi='"+ idCmi +"'"
					+ " And opi_user.id_usr=ind_voeu.id_usr"
					+ " And ind_voeu.id_usr IN (select id_usr from UPD_IND_FICHIER)"
					+ " order by lib_nom_pat_usr");
			
			String nomEtudiant = "";
			while (rs1.next()) {
				if (rs1.getObject(2) != null && rs1.getObject(4) != null) {
					if(rs1.getObject(3) != null && rs1.getObject(3).toString().trim().length() > 0 && !rs1.getObject(2).toString().trim().equals(rs1.getObject(3).toString().trim()))
						nomEtudiant = rs1.getObject(2).toString()+ " " + "(" + rs1.getObject(3).toString() + ")" + " " + rs1.getObject(4).toString();
					else
						nomEtudiant = rs1.getObject(2).toString()+ " " + rs1.getObject(4).toString();
					listEtudiant.add(nomEtudiant);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listEtudiant;
	}
	
	@Override
	public ArrayList<String> getListNumDossierEtudiant(String idCmi) {
		ArrayList<String> listEtudiant = new ArrayList<String>();
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("SELECT DISTINCT ind_voeu.id_usr, lib_nom_pat_usr, num_dos_opi  FROM ind_voeu, link_trt_cmi_camp, trt_cmi_vet, opi_user, individu"
					+" Where ind_voeu.id_link = link_trt_cmi_camp.id_link"
					+" And link_trt_cmi_camp.id_trt_cmi= trt_cmi_vet.id_trt_cmi"
					+" And tem_en_sve_voeu='Y'"
					+" And trt_cmi_vet.id_cmi='" + idCmi + "'"
					+" And opi_user.id_usr=ind_voeu.id_usr"
					+" And ind_voeu.id_usr IN (select id_usr from UPD_IND_FICHIER)"
					+" And ind_voeu.id_usr=individu.id_usr"
					+" order by lib_nom_pat_usr;");
			
			while (rs1.next() && rs1.getObject(1) != null)
				listEtudiant.add(rs1.getObject(3).toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listEtudiant;
	}

	
	@Override
	public Map<String, ArrayList<String>> getMapCodeEtapeNomEtudiant(Map<String, ArrayList<String>> MapCodeEtapeIdUsrEtudiant) {
		Map<String, ArrayList<String>> MapCodeEtapeNomEtudiant = new TreeMap<String, ArrayList<String>>();
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			for (Map.Entry<String, ArrayList<String>> e : MapCodeEtapeIdUsrEtudiant
					.entrySet()) {

				MapCodeEtapeNomEtudiant.put(e.getKey(), new ArrayList<String>());
				for (String s : e.getValue()) {
					//rs1 = stmt1.executeQuery("SELECT `lib_nom_pat_usr`,`lib_pr1_usr`,`cod_user_to_update_usr` FROM `opi_user` WHERE `id_usr`='"+ s + "'");
					rs1 = stmt1.executeQuery("SELECT `lib_nom_pat_usr`,`lib_pr1_usr`, num_dos_opi FROM `opi_user`, individu WHERE individu.id_usr=opi_user.id_usr and opi_user.id_usr='"+s+"'");
					if (rs1.next()) {
						MapCodeEtapeNomEtudiant.get(e.getKey()).add(rs1.getObject(1).toString()+ " " + rs1.getObject(2).toString());
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return MapCodeEtapeNomEtudiant;
	}
	
	@Override
	public String getIdUsrEtudiantRechercheNumDossier(String rechercheNumDossier) {
		String idUsr = "";
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("SELECT opi_user.id_usr FROM `opi_user`, individu WHERE individu.id_usr=opi_user.id_usr and num_dos_opi='"+rechercheNumDossier+"'");
			if (rs1.next() && rs1.getObject(1) != null)
				idUsr = rs1.getObject(1).toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idUsr;
	}
	
	@Override
	public String getNumDossier(String idUsrEtudiant) {
		String numDossier = null;
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("SELECT `lib_nom_pat_usr`,`lib_pr1_usr`, num_dos_opi FROM `opi_user`, individu WHERE individu.id_usr=opi_user.id_usr and opi_user.id_usr='"+idUsrEtudiant+"'");
			if (rs1.next() && rs1.getObject(3) != null)
				numDossier = rs1.getObject(3).toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return numDossier;
	}

	@Override
	public Map<String, ArrayList<String>> getMapCodeEtapeNumDossier(Map<String, ArrayList<String>> MapCodeEtapeIdUsrEtudiant) {
		Map<String, ArrayList<String>> MapCodeEtapeNumDossier = new TreeMap<String, ArrayList<String>>();
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			for (Map.Entry<String, ArrayList<String>> e : MapCodeEtapeIdUsrEtudiant
					.entrySet()) {

				MapCodeEtapeNumDossier.put(e.getKey(), new ArrayList<String>());
				for (String s : e.getValue()) {
					//rs1 = stmt1.executeQuery("SELECT `lib_nom_pat_usr`,`lib_pr1_usr`,`cod_user_to_update_usr` FROM `opi_user` WHERE `id_usr`='"+ s + "'");
					rs1 = stmt1.executeQuery("SELECT `lib_nom_pat_usr`,`lib_pr1_usr`, num_dos_opi FROM `opi_user`, individu WHERE individu.id_usr=opi_user.id_usr and opi_user.id_usr='"+s+"'");
					if (rs1.next()) {
						MapCodeEtapeNumDossier.get(e.getKey()).add(rs1.getObject(3).toString());
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return MapCodeEtapeNumDossier;
	}
	
	@Override
	public ArrayList<String> getlistIdUsrFromUPD_IND_REF() {
		ArrayList<String> listIdUsrFromUPD_IND_REF = new ArrayList<String>();
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select id_usr from UPD_IND_REFERENT");
			while(rs1.next()){
				listIdUsrFromUPD_IND_REF.add(rs1.getObject(1).toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listIdUsrFromUPD_IND_REF;
	}

	@Override
	public Map<String, ArrayList<String>> getMapIdUsrLienRecommandation(
			ArrayList<String> idUsr) {
		Map<String, ArrayList<String>> MapIdUsrLienRecommandation = new TreeMap<String, ArrayList<String>>();
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			for(String s : idUsr){
				rs1 = stmt1.executeQuery("select nom_fichier_recommandation from UPD_IND_REFERENT WHERE id_usr='"+s+"'");
				MapIdUsrLienRecommandation.put(s, new ArrayList<String>());
				while(rs1.next()){
					if( rs1.getObject(1) != null)
						MapIdUsrLienRecommandation.get(s).add(rs1.getObject(1).toString());
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return MapIdUsrLienRecommandation;
	}

	@Override
	public ArrayList<String> getlistIdUsrNoFileUploaded() {
		ArrayList<String> listIdUsrNoFileUploaded = new ArrayList<String>();
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select id_usr from individu where id_usr not in (select id_usr from UPD_IND_FICHIER)");
			while(rs1.next()){
				listIdUsrNoFileUploaded.add(rs1.getObject(1).toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listIdUsrNoFileUploaded;
	}
	
	@Override
	public ArrayList<String> getlistIdUsrNoFileAlireUploaded() {
		ArrayList<String> listIdUsrNoFileUploaded = new ArrayList<String>();
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select id_usr from individu where id_usr not in (select id_usr from UPD_IND_FICHIER where Emplacement LIKE '%pdf' or Emplacement LIKE '%xls' or Emplacement LIKE '%xlsx')");
			while(rs1.next()){
				listIdUsrNoFileUploaded.add(rs1.getObject(1).toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listIdUsrNoFileUploaded;
	}

	@Override
	public ArrayList<String> getlistIdUsrNoFileAlireUploadedForIdCmi(String idCmi) {
		ArrayList<String> listIdUsrNoFileUploaded = new ArrayList<String>();
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select id_usr from individu " +
					"where id_usr not in (select id_usr from UPD_IND_FICHIER where id_cmi='"+idCmi+"'" +
							" and (Emplacement LIKE '%pdf' or Emplacement LIKE '%xls' or Emplacement LIKE '%xlsx'))");
			while(rs1.next()){
				listIdUsrNoFileUploaded.add(rs1.getObject(1).toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listIdUsrNoFileUploaded;
	}
	
	@Override
	public ArrayList<String> getlistTypePieceJustif(String idUsr, String idCmi) {
		ArrayList<String> listTypePieceJustif = new ArrayList<String>();
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("SELECT `TYPE_PIECE_JUSTIF`, `Emplacement`, `DATE_UPLOAD` FROM `UPD_IND_FICHIER` WHERE `id_usr`='"+idUsr+"' and `id_cmi`='"+idCmi+"'");
			while(rs1.next()){
				listTypePieceJustif.add(rs1.getObject(1).toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listTypePieceJustif;
	}

	@Override
	public ArrayList<String> getlistIdCmiEnService() {
		ArrayList<String> listIdCmiEnService = new ArrayList<String>();
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("SELECT id_cmi FROM `commission` WHERE `tem_en_sve_cmi`='Y'");
			while(rs1.next()){
				listIdCmiEnService.add(rs1.getObject(1).toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listIdCmiEnService;
	}
	
	@Override
	public String getIdLink(String idTrtCmi) {
		String idLink = null;
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select id_link from link_trt_cmi_camp where id_trt_cmi='"+idTrtCmi+"'");
			if (rs1.next())
				idLink = rs1.getObject(1).toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idLink;
	}


	@Override
	public String getIdTrtCmi(String idCmi) {
		String idTrtCmi = null;
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select id_trt_cmi from trt_cmi_vet where id_cmi='"+idCmi+"'");
			if (rs1.next())
				idTrtCmi = rs1.getObject(1).toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idTrtCmi;
	}

	@Override
	public Map<String, String> getMapIdUsrDossierComplet(String idLink) {
		Map<String, String> MapIdUsrDossierComplet = new TreeMap<String, String>();
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select id_usr, state_ind_voeu from ind_voeu where id_link='"+idLink+"'");
			while(rs1.next()){
				String complet;
				if(rs1.getObject(2).toString().equals("STATE.ARRIVE_COMPLET"))
					complet = "Complet";
				else
					if(rs1.getObject(2).toString().equals("STATE.ARRIVE_INCOMPLET"))
						complet = "Incomplet";
					else
						complet = "Non Arrivé";
				MapIdUsrDossierComplet.put(rs1.getObject(1).toString(), complet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return MapIdUsrDossierComplet;
	}

	@Override
	public Map<String, String> getMapIdUsrEtudiantObservation(String idUsr, String idCmi) {
		Map<String, String> MapIdUsrEtudiantObservation = new TreeMap<String, String>();
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select id_usr_candidat, Observations from UPD_EXAMEN_DOSSIER where id_usr_membre='"+idUsr+"' and id_cmi='"+idCmi+"'");
			while(rs1.next())
				 MapIdUsrEtudiantObservation.put(rs1.getObject(1).toString(), rs1.getObject(2).toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return MapIdUsrEtudiantObservation;
	}

	@Override
	public Map<String, String> getMapIdUsrEtudiantTraitement(String idUsr, String idCmi) {
		Map<String, String> MapIdUsrEtudiantTraitement = new TreeMap<String, String>();
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select id_usr_candidat, Etat_traitement from UPD_EXAMEN_DOSSIER where id_usr_membre='"+idUsr+"' and id_cmi='"+idCmi+"'");
			while(rs1.next())
				MapIdUsrEtudiantTraitement.put(rs1.getObject(1).toString(), rs1.getObject(2).toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return MapIdUsrEtudiantTraitement;
	}

	@Override
	public void insertObsTrait(String idUsr, String idUsrEtudiant, String idCmi, String etat, String observation) {
		Statement stmt1 = null;
		try {
			stmt1 = con.createStatement();
			stmt1.executeUpdate("INSERT INTO `UPD_EXAMEN_DOSSIER` ( `id_usr_candidat` , `id_usr_membre` , `id_cmi` , `Observations` , `Etat_traitement` , `Date_creation_traitement`, `Date_modification_traitement`) VALUES ( '"+idUsrEtudiant+"', '"+idUsr+"', '"+idCmi+"', '"+observation+"', '"+etat+"', SYSDATE(), SYSDATE())");	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateObsTrait(String idUsr, String idUsrEtudiant, String idCmi, String etat, String observation) {
		Statement stmt1 = null;
		try {
			stmt1 = con.createStatement();
			stmt1.executeUpdate("Update `UPD_EXAMEN_DOSSIER` set `Observations`='"+observation+"', `Etat_traitement`='"+etat+"', Date_modification_traitement=SYSDATE() where `id_usr_candidat`='"+idUsrEtudiant+"' and id_usr_membre='"+idUsr+"' and id_cmi='"+idCmi+"'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean ligneExist(String idUsr, String idUsrEtudiant, String idCmi) {
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select * from UPD_EXAMEN_DOSSIER  where `id_usr_candidat`='"+idUsrEtudiant+"' and id_usr_membre='"+idUsr+"' and id_cmi='"+idCmi+"'");
			if (rs1.next())
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<String> getListEtudiantEnCoursTraitement(String idUsr, String idCmi) {
		ArrayList<String> listEtudiantEnCoursTraitement = new ArrayList<String>();
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select id_usr_candidat from UPD_EXAMEN_DOSSIER where Etat_traitement='STATE.EN_COURS_TRAITEMENT' and id_usr_membre='"+idUsr+"' and id_cmi='"+idCmi+"'");
			while(rs1.next()){
				listEtudiantEnCoursTraitement.add(rs1.getObject(1).toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listEtudiantEnCoursTraitement;
	}

	@Override
	public ArrayList<String> getListEtudiantNonTraite(String idUsr, String idCmi) {
		ArrayList<String> listEtudiantEnCoursTraitement = new ArrayList<String>();
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select id_usr_candidat from UPD_EXAMEN_DOSSIER where Etat_traitement='STATE.NON_TRAITE' and id_usr_membre='"+idUsr+"' and id_cmi='"+idCmi+"'");
			while(rs1.next()){
				listEtudiantEnCoursTraitement.add(rs1.getObject(1).toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listEtudiantEnCoursTraitement;
	}

	@Override
	public ArrayList<String> getListEtudiantTraite(String idUsr, String idCmi) {
		ArrayList<String> listEtudiantEnCoursTraitement = new ArrayList<String>();
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select id_usr_candidat from UPD_EXAMEN_DOSSIER where Etat_traitement='STATE.TRAITE' and id_usr_membre='"+idUsr+"' and id_cmi='"+idCmi+"'");
			while(rs1.next()){
				listEtudiantEnCoursTraitement.add(rs1.getObject(1).toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listEtudiantEnCoursTraitement;
	}

	@Override
	public String idNomEnService(String idNom) {
		String enService = null;
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select tem_en_sve_nom from nomenclature where id_nom='"+idNom+"'");
			if(rs1.next())
				enService = rs1.getObject(1).toString();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return enService;
	}
	
	@Override
	public boolean fileInBDD(String emplacement) {
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select * from UPD_IND_FICHIER where Emplacement='"+emplacement+"'");
			if (rs1.next())
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean recommandationInBDD(String emplacement) {
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select * from UPD_IND_REFERENT where nom_fichier_recommandation='"+emplacement+"'");
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
	public String getTypeCurSco(String idUsrEtudiant) {
		//rs1 = stmt1.executeQuery("select id_usr, type_cur_scol, lib_etb_etr_cur_ext, max(an_cur_scol) FROM ind_cur_scol where  id_usr='"+idUsrEtudiant+"'");
		
		/*
		 * rs1 = stmt1.executeQuery("select max(an_cur_scol) FROM ind_cur_scol where  id_usr='"+idUsrEtudiant+"' limit 1");
			if(rs1.next())
				maxAnCur = rs1.getObject(1).toString();
			
			rs1 = stmt1.executeQuery("select type_cur_scol FROM ind_cur_scol where an_cur_scol='"+maxAnCur+"'  and id_usr='"+idUsrEtudiant+"'");
			if(rs1.next())
				typeCurSco = rs1.getObject(1).toString();
		 */
		int maxAnCur = 0;
		String typeCurSco = null;
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select an_cur_scol FROM ind_cur_scol where  id_usr='"+idUsrEtudiant+"'");
			while(rs1.next()){
				if(maxAnCur < rs1.getInt(1))
					maxAnCur = rs1.getInt(1);
			}
			rs1 = stmt1.executeQuery("select type_cur_scol FROM ind_cur_scol where an_cur_scol='"+maxAnCur+"'  and id_usr='"+idUsrEtudiant+"'");
			if(rs1.next())
				typeCurSco = rs1.getObject(1).toString();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return typeCurSco;
	}

	@Override
	public String getLibEtbEtrCurExt(String idUsrEtudiant) {
		String libEtbEtrCurExt = null;
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select id_usr, type_cur_scol, lib_etb_etr_cur_ext, max(an_cur_scol) FROM ind_cur_scol where  id_usr='"+idUsrEtudiant+"'");
			if(rs1.next() && rs1.getObject(3) != null)
				libEtbEtrCurExt = rs1.getObject(3).toString();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return libEtbEtrCurExt;
	}
	
	public boolean filtreExiste(String idSession, String sessionStartTime) {
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select id_session from UPD_CONSULTATION where id_session='" + idSession + "' and dat_cre_session='" + sessionStartTime + "'");
			if(rs1.next())
				return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public String insertFichiersAAffiche(String idSession, String login, String codeNomFichiers,
			String idCmi, String sessionStartTime) {
		Statement stmt1 = null;
		try {
			stmt1 = con.createStatement();
			stmt1.executeUpdate("INSERT INTO UPD_CONSULTATION (id_session, login, id_cmi, elements, dat_cre_session, dat_fin_session) VALUES ('"+idSession+"', '"+login+"', '"+idCmi+"', '"+codeNomFichiers+"', '"+sessionStartTime+"', '"+sessionStartTime+"')");	
		} catch (SQLException e) {
			e.printStackTrace();
			return e.toString();
		}
		return null;
	}
	
	@Override
	public String insertEtablissementAAffiche(String idSession, String login, String codeEtab,
			String idCmi, String sessionStartTime) {
		Statement stmt1 = null;
		try {
			stmt1 = con.createStatement();
			stmt1.executeUpdate("INSERT INTO UPD_FILTRE_ETAB (id_session, login, id_cmi, filtre_cod_etab, dat_cre_session, dat_fin_session) VALUES ('"+idSession+"', '"+login+"', '"+idCmi+"', '"+codeEtab+"', '"+sessionStartTime+"', '"+sessionStartTime+"')");	
		} catch (SQLException e) {
			e.printStackTrace();
			return e.toString();
		}
		return null;
	}

	@Override
	public ArrayList<String> getListFichiersAAffiche(String idSession,
			String login, String idCmi) {
		ArrayList<String> listFichiersAAffiche = new ArrayList<String>();
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("SELECT elements FROM UPD_CONSULTATION WHERE id_session='"+idSession+"' and login='"+login+"' and id_cmi='"+idCmi+"'");
			if(rs1.next()){
				String[] tabFichiers = rs1.getObject(1).toString().split(";");
				for(int i = 0; i < tabFichiers.length; i++)
					listFichiersAAffiche.add(tabFichiers[i]);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listFichiersAAffiche;
	}
	
	@Override
	public String getEtablissementAAffiche(String idSession,
			String login, String idCmi) {
		String codeEtab = "";
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("SELECT filtre_cod_etab FROM UPD_FILTRE_ETAB WHERE id_session='"+idSession+"' and login='"+login+"' and id_cmi='"+idCmi+"'");
			if(rs1.next() && rs1.getObject(1) != null){
				codeEtab = rs1.getObject(1).toString();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return codeEtab;
	}

	@Override
	public boolean existeDansUPDConsul(String login, String idSession, String idCmi) {
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("SELECT id_session from UPD_CONSULTATION WHERE id_session='"+idSession+"' and login='"+login+"' and id_cmi='" +idCmi+ "'");
			if(rs1.next())
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean existeDansUPDFiltreEtab(String login, String idSession, String idCmi) {
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("SELECT id_session from UPD_FILTRE_ETAB WHERE id_session='"+idSession+"' and login='"+login+"' and id_cmi='" +idCmi+ "'");
			if(rs1.next())
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void updateFichiersAAffiche(String idSession, String login,
			String codeNomFichiers, String idCmi,
			String sessionStartTimeSimpleFormat) {
		Statement stmt1 = null;
		try {
			stmt1 = con.createStatement();
			stmt1.executeUpdate("UPDATE UPD_CONSULTATION set elements='"+codeNomFichiers+"' where id_session='"+idSession+"' and login='"+login+"' and id_cmi='"+idCmi+"'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateEtablissementAAffiche(String idSession, String login,
			String codEtab, String idCmi, String sessionStartTimeSimpleFormat) {
		Statement stmt1 = null;
		try {
			stmt1 = con.createStatement();
			stmt1.executeUpdate("UPDATE UPD_FILTRE_ETAB set filtre_cod_etab='"+codEtab+"' where id_session='"+idSession+"' and login='"+login+"' and id_cmi='"+idCmi+"'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public String getLogin(String nom) {
		String login = "";
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("");
			if(rs1.next())
				login = rs1.getObject(1).toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return login;
	}
	
	@Override
	public String getLibCmi(String idCmi) {
		String libCmi = null;
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select lib_cmi from `trt_cmi_vet`, commission where commission.id_cmi='"+idCmi+"' and `trt_cmi_vet`.id_cmi=commission.id_cmi");
			if(rs1.next() && rs1.getObject(1) != null)
				libCmi = rs1.getObject(1).toString();
			
		} catch (SQLException e) {
			return e.toString();
		}
		return libCmi;
	}

	@Override
	public String getAvis(String idUsrEtudiant, String idCmi) {
		String avis = null;
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select nomenclature.lic_nom"
					+ " from avis, ind_voeu, nomenclature, link_trt_cmi_camp, trt_cmi_vet where"
					+ " ind_voeu.id_link= link_trt_cmi_camp.id_link"
					+ " and link_trt_cmi_camp.id_trt_cmi= trt_cmi_vet.id_trt_cmi"
					+ " and ind_voeu.tem_en_sve_voeu='Y'"
					+ " and avis.id_ind_voeu=ind_voeu.id_ind_voeu"
					+ " and avis.tem_en_sve_avis='Y'"
					+ " and avis.id_typ_dec = nomenclature.id_nom"
					+ " and id_usr="+idUsrEtudiant
					+ " and trt_cmi_vet.id_cmi="+idCmi);
			if(rs1.next() && rs1.getObject(1) != null)
				avis = rs1.getObject(1).toString();
			
		} catch (SQLException e) {
			return e.toString();
		}
		return avis;
	}

	
	@Override
	public ArrayList<String> getlistLicNomAvis() {
		ArrayList<String> listLicNomAvis = new ArrayList<String>();
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select lic_nom from nomenclature where type_nom='TYP_DEC'");
			while(rs1.next()){
				listLicNomAvis.add(rs1.getObject(1).toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listLicNomAvis;
	}
	
	@Override
	public Map<String, String> getMapLibNomsPcLicNomsPc(String codeRi) {
		Map<String, String> MapLibNomsPcLicNomsPc = new TreeMap<String, String>();
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1
			.executeQuery("select id_nom, type_nom, cod_nom, lib_nom, lic_nom from nomenclature"
					+ " where `type_nom`='PIECE_JST'"
					+ " and tem_en_sve_nom='Y'"
					+ " and `is_for_all_vet_nom`='Y'"
					+ " and cod_ri_nom='" + codeRi + "'");
			while(rs1.next()) {
				try {
					String libNom = rs1.getObject(4).toString();
					String licNom;
					if(rs1.getObject(5) != null)
						licNom = new String(rs1.getObject(5).toString().getBytes("utf-8"), "iso-8859-1");
					else 
						licNom = libNom;
					MapLibNomsPcLicNomsPc.put(libNom, licNom);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return MapLibNomsPcLicNomsPc;
	}

	@Override
	public String getLicNomPs(String idNomPs) {
		String licNomPs = null;
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select type_nom, cod_nom, lib_nom, lic_nom from nomenclature where  id_nom='"+ idNomPs + "'");
			if (rs1.next())
				if(rs1.getObject(4) != null)
					licNomPs = rs1.getObject(4).toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return licNomPs;
	}
	
	@Override
	public Map<String, String> getMapLibNomsPsLibNomsPs(Map<String, ArrayList<String>> MapCodeEtapeIdNomPs) {
		Map<String, String> MapLibNomsPsLibNomsPs = new TreeMap<String, String>();
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			for (Map.Entry<String, ArrayList<String>> e : MapCodeEtapeIdNomPs
					.entrySet()) {
				for (String s : e.getValue()) {
					rs1 = stmt1.executeQuery("select type_nom, cod_nom, lib_nom, lic_nom from nomenclature where  id_nom='"+ s + "'");
					if (rs1.next()) {
						String libNom = rs1.getObject(3).toString();
						String licNom; 
						if(rs1.getObject(4) != null)
							licNom = rs1.getObject(4).toString();
						else 
							licNom = libNom;
						MapLibNomsPsLibNomsPs.put(libNom, licNom);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return MapLibNomsPsLibNomsPs;
	}

	@Override
	public String EmplacementCodeFile(String idUsr, String idCmi, String codeFile) {
		String emplacement = null;
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select Emplacement from UPD_IND_FICHIER where id_usr='"+idUsr+"' and id_cmi='"+idCmi+"' and Emplacement like '%/"+codeFile+".%'");
			if(rs1.next() && rs1.getObject(1) != null)
				emplacement = rs1.getObject(1).toString();
			
		} catch (SQLException e) {
			return e.toString();
		}
		return emplacement;
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
	public String dernierCodEtabEtudiant(String idUsr) {
		String codeEtab = null;
		Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("select distinct cod_etb_cur_scol, max(an_cur_scol) from ind_cur_scol where id_usr='" + idUsr + "'");
			if(rs1.next() && rs1.getObject(1) != null)
				codeEtab = rs1.getObject(1).toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return codeEtab ;
	}

	

	
	

	

	

	

	

	


}
