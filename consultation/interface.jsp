<%@ include  file="header.jsp"%>
<%@ include  file="menu.jsp"%>
<%@ page import="java.util.ArrayList, java.util.Map, java.util.TreeMap, java.io.File, java.util.Properties" %>
<%
String idCmi = request.getAttribute("idCmi").toString();
String libCmi = request.getAttribute("libCmi").toString();
String codeEtape = request.getAttribute("codeEtape").toString();
String codeVet = request.getAttribute("codeVet").toString();
ArrayList<String> listLibNomPc = (ArrayList<String>) request.getAttribute("listLibNomsPc");
ArrayList<String> listCodeNomPc = (ArrayList<String>) request.getAttribute("listCodeNomsPc");
ArrayList<String> listLibNomPs = (ArrayList<String>) request.getAttribute("listLibNomPs");
ArrayList<String> listCodeNomPs = (ArrayList<String>) request.getAttribute("listCodeNomPs");
ArrayList<String> listIdUsrEtudiant = (ArrayList<String>) request.getAttribute("listIdUsrEtudiantTrie");
ArrayList<String> listNomEtudiant = (ArrayList<String>) request.getAttribute("listNomEtudiantTrie");
ArrayList<String> listNumDossier = (ArrayList<String>) request.getAttribute("listNumDossierTrie");
ArrayList<String> listIdUsrFromUPD_IND_REF = (ArrayList<String>) request.getAttribute("listIdUsrFromUPD_IND_REF");
ArrayList<String> listEmplacements = (ArrayList<String>) request.getAttribute("listEmplacements");
ArrayList<String> listFichiersAAffiche = (ArrayList<String>) request.getAttribute("listFichiersAAffiche");
ArrayList<String> listCodeFile = (ArrayList<String>) request.getAttribute("listCodeFile");
ArrayList<String> listIdUsrEtudiantSurPage = (ArrayList<String>) request.getAttribute("listIdUsrEtudiantSurPage");
ArrayList<String> listLicNomAvis = (ArrayList<String>) request.getAttribute("listLicNomAvis");
ArrayList<String> listNomFile = (ArrayList<String>) request.getAttribute("listNomFile");
ArrayList<String> listLicNomFile = (ArrayList<String>) request.getAttribute("listLicNomFile");
ArrayList<String> listCodeEtab = (ArrayList<String>) request.getAttribute("listCodeEtab");
Map<String, String> MapLibNomsPcLicNomsPc = (TreeMap<String, String>) request.getAttribute("MapLibNomsPcLicNomsPc");
Map<String, String> MapLibNomsPsLicNomsPs = (TreeMap<String, String>) request.getAttribute("MapLibNomsPsLicNomsPs");
//Map<String, String> MapIdUsrEtudiantProvenance = (TreeMap<String, String>) request.getAttribute("MapIdUsrEtudiantProvenance");
Map<String, ArrayList<String>> MapIdUsrLienRecommandation = (TreeMap<String, ArrayList<String>>) request.getAttribute("MapIdUsrLienRecommandation");
Map<String, String> MapIdUsrEtudiantObservation = (TreeMap<String, String>) request.getAttribute("MapIdUsrEtudiantObservation");
Map<String, String> MapIdUsrEtudiantTraitement = (TreeMap<String, String>) request.getAttribute("MapIdUsrEtudiantTraitement");
Map<String, String> MapIdUsrEtudiantAvis = (TreeMap<String, String>) request.getAttribute("MapIdUsrEtudiantAvis");
Map<String, ArrayList<String>> MapIdUsrEmplacementsForIdCmi = (TreeMap<String, ArrayList<String>>) request.getAttribute("MapIdUsrEmplacementsForIdCmi");
Map<String, ArrayList<String>> MapCodeFileColonneFiles = (TreeMap<String, ArrayList<String>>) request.getAttribute("MapCodeFileColonneFiles");
Map<String, ArrayList<String>> MapIdUsrEtudiantCodeEtab = (TreeMap<String, ArrayList<String>>) request.getAttribute("MapIdUsrEtudiantCodeEtab");
Map<String, String> MapCodeEtabLibEtab = (TreeMap<String, String>) request.getAttribute("MapCodeEtabLibEtab");
String lienDossier = application.getInitParameter("lienDossier");
String filtre = request.getAttribute("filtre").toString();
String filtreEtablissement = request.getAttribute("filtreEtablissement").toString();
String filtreAvis = request.getAttribute("filtreAvis").toString();
String rechercheNom = request.getAttribute("rechercheNom").toString();
String rechercheNumDossier = request.getAttribute("rechercheNumDossier").toString();
int numPage = Integer.parseInt(request.getAttribute("numPage").toString());
int nbEtudiantsParPage = Integer.parseInt(request.getAttribute("nbEtudiantsParPage").toString());
int nbPages = nbPages(listIdUsrEtudiantSurPage.size(), nbEtudiantsParPage);
int indicePremierEtudiant = indicePremierEtudiant(numPage, nbEtudiantsParPage);
int indiceDernierEtudiant = indiceDernierEtudiant(indicePremierEtudiant, nbEtudiantsParPage, listIdUsrEtudiantSurPage.size());
%>
<%!
public String liensColonne(Map<String, ArrayList<String>>  MapCodeFileColonneFiles, String codeFile
		, String lienDossier, int numPage, int nbEtudiantsParPage, int nbPages
		, int indicePremierEtudiant, int indiceDernierEtudiant, ArrayList<String> listIdUsrEtudiantSurPage
		, Map<String, ArrayList<String>> MapIdUsrEmplacementsForIdCmi) {
	
	ArrayList<String> listEmplacements = MapCodeFileColonneFiles.get(codeFile);
	String liens ="";
	for(int j = indicePremierEtudiant ; (j < indiceDernierEtudiant  && j < listIdUsrEtudiantSurPage.size()); j++) {
		String idUsrEtudiant = listIdUsrEtudiantSurPage.get(j);
		ArrayList<String> listEmplacementsPourIdUsr = MapIdUsrEmplacementsForIdCmi.get(idUsrEtudiant);
		String emplacement = "";
		for(String lien : listEmplacementsPourIdUsr) {
			emplacement = lien.substring(0, lien.lastIndexOf(".")).replaceAll(lienDossier, "");
			if(lien.contains("/"+codeFile+".") && new File(lien).exists()) {
				String extention = lien.substring(lien.lastIndexOf(".") + 1);
				if(extention.equals("pdf") || extention.equals("xls")) {
					liens += emplacement + "&";
				}
			}
		}
	}
	return liens;
}
public int nbPages(int nbEtudiants, int nbEtudiantParPage) {
	if(nbEtudiants <= nbEtudiantParPage)
		return 1;
	else {
		return (nbEtudiants - (nbEtudiants % nbEtudiantParPage))/nbEtudiantParPage + 1;
	}
}
public int indicePremierEtudiant(int numPage, int nbEtudiantsParPage) {
	return (numPage - 1) * nbEtudiantsParPage;
}
public int indiceDernierEtudiant(int indicePremierEtudiant, int nbEtudiantsParPage, int nbEtudiants) {
	return indicePremierEtudiant + nbEtudiantsParPage;
}
%>
<body   onLoad="check('<%= filtre %>');  check('<%= filtreAvis %>'); check('<%= nbEtudiantsParPage %>'); check('<%= filtreEtablissement %>');">
<div id="maPage" class="salahddine_welcomeInfoFirstConnexion2" >

<%@ include file="filtre.jsp" %>
<%@ include file="recherche.jsp" %>
<%@ include file="checkFichiers.jsp" %>


<CAPTION><span class="section-header-blue"><%= prop.getProperty("commission") %> : <%= libCmi %></span><CAPTION>

<%@ include  file="pagination.jsp"%>

<table style='border-collapse: separate; border-spacing: 2px; border-color: gray;'>

<%
/**************************************************** Entete ****************************************************/
out.println("<tr style='background-color: lightgray;'>");

//provenance + num de dossier + nom prenom + fichiers
out.println("<td>");
out.println(prop.getProperty("nomEtPrenom"));
out.println("</td>");
out.println("<td>");
out.println(prop.getProperty("numDossier"));
out.println("</td>");
out.println("<td>");
out.println(prop.getProperty("lastEtab"));
out.println("</td>");

//Avis
out.println("<td>");
out.println("<center>"+prop.getProperty("avis")+"</center>");
out.println("</td>");



//telecharger toute la ligne
out.println("<td>");
out.println("Telecharger tout le dossier");
out.println("</td>");

//list des pieces communes
for(String nomFile : listNomFile) {
	String licNomFile = listLicNomFile.get(listNomFile.indexOf(nomFile));
	String codeFile = listCodeFile.get(listNomFile.indexOf(nomFile));
	
	//sauter si le fichier n'est pas a afficher, et le gestionnaire arrive pas la 1ere fois sur la page (listfichiersAAFFICHE = null)
	if(listFichiersAAffiche != null && !listFichiersAAffiche.contains(codeFile))
		continue;
	
	out.println("<td valign=bottom>"+licNomFile);
	
	//recuperation de fichiers par colonne
	String liensColonne = liensColonne(MapCodeFileColonneFiles, codeFile, lienDossier, numPage, nbEtudiantsParPage, nbPages, indicePremierEtudiant, indiceDernierEtudiant, listIdUsrEtudiantSurPage, MapIdUsrEmplacementsForIdCmi);
	if(liensColonne.trim().length() != 0){
		out.println("<form action=\"telechargementMultipleColonne\" method=\"post\" name=\"myform\">");
		out.println("<br/><center><input type=\"submit\" class=\"iconeTelecharger\" name=\"telecharger\" value=\"\" /></center>");
		out.println("<input type=\"hidden\" name=\"liens\" value="+liensColonne+">");
		out.println("<input type=\"hidden\" name=\"codePiece\" value="+codeFile+">");
		out.println("<input type=\"hidden\" name=\"codeEtape\" value="+codeEtape+">");
		out.println("<input type=\"hidden\" name=\"codeVet\" value="+codeVet+">");
		out.println("</form>");
	} else {
		out.print("<center><p><span class=\"portlet-section-text\"><img src=\"./image/button_cancel.png\"></img></span></p></center>");
	}
	
	out.println("</td>");
}



//recommandation
for (int i = 1; i < 4; i++){
	out.println("<td>");
	out.println("Rec"+i);
	out.println("</td>");
}


//Traitement
out.println("<td>");
out.println(prop.getProperty("traite"));
out.println("</td>");
out.println("<td>");
out.println("<nobr>");
out.println(prop.getProperty("nonTraite"));
out.println("</nobr>");
out.println("</td>");

//Observation
out.println("<td>");
out.println("<center>Observation</center>");
out.println("</td>");

//mettre à jour
out.println("<td>");
out.println("<center>Mise à jour</center>");
out.println("</td>");

out.println("</tr>");

/**************************************************** Lignes ****************************************************/
String[] tabExtentions = {".pdf", ".xls"};
boolean fileExist;
int z = 0;
for(int j = indicePremierEtudiant ; (j < indiceDernierEtudiant  && j < listIdUsrEtudiantSurPage.size()); j++) {
	String idUsrEtudiant = listIdUsrEtudiantSurPage.get(j);
	z++;
	
	if(z%2 != 0)
		out.println("<tr style='background-color: ghostwhite;'>");
	else
		out.println("<tr style='background-color: lightgray;'>");
	
	//String provenance = MapIdUsrEtudiantProvenance.get(idUsrEtudiant);
	String numDossier = listNumDossier.get(listIdUsrEtudiant.indexOf(idUsrEtudiant));
	String nomEtudiant = listNomEtudiant.get(listIdUsrEtudiant.indexOf(idUsrEtudiant));
	
	//nom
	out.println("<td>");
	out.println(nomEtudiant);
	out.println("</td>");
	
	//numero de dossier
	out.println("<td>");
	out.println(numDossier);
	out.println("</td>");
	
	//dernier etablissement
	out.println("<td>");
	out.println("<p style='text-transform:capitalize;'>"+MapCodeEtabLibEtab.get(MapIdUsrEtudiantCodeEtab.get(idUsrEtudiant))+"</p>");
	out.println("</td>");
	
	
	//Avis
	out.println("<td>");
	out.println("<nobr><center>"+MapIdUsrEtudiantAvis.get(idUsrEtudiant)+"</center></nobr>");
	out.println("</td>");
	
	
	//telecharger tout le dossier
	out.println("<td>");
	if(MapIdUsrEmplacementsForIdCmi.get(idUsrEtudiant).size() > 0) {
		out.println("<form action=\"telechargementMultipleLigne\" method=\"post\" name=\"myform\">");
		out.println("<center><input type=\"submit\" class=\"iconeTelecharger\" name=\"telecharger\" value=\"\" /></center>");
		out.println("<input type=\"hidden\" name=\"nomEtudiant\" value="+nomEtudiant.replaceAll(" ", "_")+">");
		out.println("<input type=\"hidden\" name=\"idCmi\" value="+idCmi+">");
		out.println("<input type=\"hidden\" name=\"idUsrEtudiant\" value="+idUsrEtudiant+">");
		out.println("</form>");
	} else {
		out.print("<center><p><span class=\"portlet-section-text\"><img src=\"./image/button_cancel.png\"></img></span></p></center>");
	}
	out.println("</td>");

	
	
	//files
	//String liens = "";
	for(String codeFile : listCodeFile) {
		String licNomfile = listLicNomFile.get(listCodeFile.indexOf(codeFile));
		//sauter si le fichier n'est pas a afficher, et le gestionnaire arrive pas la 1ere fois sur la page (listfichiersAAFFICHE = null)
		if(listFichiersAAffiche != null && !listFichiersAAffiche.contains(codeFile)){
			continue;
		}
		
		out.println("<td>");
		fileExist = false;
		ArrayList<String> listEmplacementsPourIdUsr = MapIdUsrEmplacementsForIdCmi.get(idUsrEtudiant);
		String emplacement = "";
		for(String lien : listEmplacementsPourIdUsr) {
			if(lien.contains("/"+codeFile+".") && new File(lien).exists()) {
				String extention = lien.substring(lien.lastIndexOf(".") + 1);
				if(extention.equals("pdf") || extention.equals("xls")) {
					fileExist = true;
					emplacement = lien;
				}
			}
		}
		if(fileExist) {
			out.println("<form action=\"telechargement\" method=\"post\" name=\"myform\">");
			out.println("<center><input type=\"submit\" class=\"form-button-gris\" name=\"telecharger\" value=\" "+ licNomfile +" \" /></center>");
			out.println("<input type=\"hidden\" name=\"nomEtudiant\" value="+nomEtudiant.replaceAll(" ", "_")+">");
			out.println("<input type=\"hidden\" name=\"codeEtape\" value="+codeEtape+">");
			out.println("<input type=\"hidden\" name=\"codeVet\" value="+codeVet+">");
			emplacement = emplacement.substring(0, emplacement.lastIndexOf(".")).replaceAll(lienDossier, "");
			out.println("<input type=\"hidden\" name=\"lien\" value="+emplacement+">");
			out.println("</form>");
		} else {
			out.print("<center><p><span class=\"portlet-section-text\"><img src=\"./image/button_cancel.png\"></img></span></p></center>");
		}
		out.println("</td>");
	}
	
	//recommandation
	for(int i = 0; i < 3; i++){
		out.print("<td>");
		if(MapIdUsrLienRecommandation.containsKey(idUsrEtudiant)){
			if(MapIdUsrLienRecommandation.get(idUsrEtudiant).size() > i){
				int longueurLienDossier = getServletContext().getInitParameter("lienDossier").length();
				out.println("<form action=\"telechargement\" method=\"post\" name=\"myform\">");
				out.println("<center><input type=\"submit\"class=\"form-button-gris\" name=\"telecharger\" value=\"Rec"+(i+1)+"\" /></center>");
				String lienRec = MapIdUsrLienRecommandation.get(idUsrEtudiant).get(i);
				lienRec = lienRec.substring(0, lienRec.lastIndexOf(".")).replaceAll(lienDossier, "");
				out.println("<input type=\"hidden\" name=\"lien\" value="+lienRec+">");
				out.println("<input type=\"hidden\" name=\"nomEtudiant\" value="+nomEtudiant.replaceAll(" ", "_")+">");
				out.println("<input type=\"hidden\" name=\"codeEtape\" value="+codeEtape+">");
				out.println("<input type=\"hidden\" name=\"codeVet\" value="+codeVet+">");
				out.println("</form>");
			} else {
				out.print("<center><p><span class=\"portlet-section-text\"><img src=\"./image/button_cancel.png\"></img></span></p></center>");
			}
		} else {
			out.print("<center><p><span class=\"portlet-section-text\"><img src=\"./image/button_cancel.png\"></img></span></p></center>");
		}
		out.print("</td>");
	}
	
	//traitement et observation
	out.println("<form action=\"miseAJour\" method=\"post\" name=\"myform\">");
	//Traitement 
	out.print("<td>");
	if(MapIdUsrEtudiantTraitement.get(idUsrEtudiant) != null && MapIdUsrEtudiantTraitement.get(idUsrEtudiant).equals("STATE.TRAITE"))
		out.println("<center><input type=\"radio\" name=\"Traitement\" value=\"STATE.TRAITE\" checked=\"checked\" /></center>");
	else
		out.println("<center><input type=\"radio\" name=\"Traitement\" value=\"STATE.TRAITE\" /></center>");
	out.print("</td>");
	out.print("<td>");
	if(MapIdUsrEtudiantTraitement.get(idUsrEtudiant) == null || MapIdUsrEtudiantTraitement.get(idUsrEtudiant).equals("STATE.NON_TRAITE"))
		out.println("<center><input type=\"radio\" name=\"Traitement\" value=\"STATE.NON_TRAITE\" checked=\"checked\"/></center>");
	else
		out.println("<center><input type=\"radio\" name=\"Traitement\" value=\"STATE.NON_TRAITE\" /></center>");
	out.print("</td>");
	
	//Observation
	out.print("<td>");
	if(MapIdUsrEtudiantObservation.get(idUsrEtudiant) != null)
		out.println("<TEXTAREA name=\"Observation\"  maxlength=\"255\" placeholder=\"Veuillez saisir votre observation\" >"+MapIdUsrEtudiantObservation.get(idUsrEtudiant)+"</TEXTAREA>");
	else
		out.println("<TEXTAREA name=\"Observation\"  maxlength=\"255\" placeholder=\"Veuillez saisir votre observation\" ></TEXTAREA>");
	out.println("<input type=\"hidden\" name=\"idUsrEtudiant\" value="+idUsrEtudiant+">");
	out.println("<input type=\"hidden\" name=\"idCmi\" value="+idCmi+">");
	out.println("<input type=\"hidden\" name=\"libCmi\" value=\""+libCmi+"\">");
	out.println("<input type=\"hidden\" name=\"filtre\" value=\""+filtre+"\">");
	out.println("<input type=\"hidden\" name=\"filtreEtablissement\" value=\""+filtreEtablissement+"\">");
	out.println("<input type=\"hidden\" name=\"filtreAvis\" value=\""+filtreAvis+"\">");
	out.println("<input type=\"hidden\" name=\"numPage\" value=\""+numPage+"\">");
	out.print("<input type='hidden' name='nbEtudiantsParPage' value='"+nbEtudiantsParPage+"' />");
	out.print("<input type='hidden' name='rechercheNom' value='" +  rechercheNom +"' />");
	out.print("<input type='hidden' name='rechercheNumDossier' value='" +  rechercheNumDossier +"' />");
	out.print("</td>");
	
	//mettre à jour
	out.print("<td>");
	out.println("<center><input type=\"submit\" name=\"MettreAJour\" value=\"Mettre à jour\" maxlength=\"8\" size=\"10\" class=\"form-button\"></center>");
	out.print("</td>");
	out.println("</form>");
	
	out.println("</tr>");
}
%>
</table>
<form action="login" method="post" name="myform">
	<input type="submit" name="retour" value="<%= prop.getProperty("retour") %>" maxlength="8" size="10" class="form-button" />
	<input type="hidden" name="login" value="<%= session.getAttribute("login") %>" />
</form>
</div>
<%@ include  file="menu.jsp"%>
</body>
<script language="javascript" type="text/javascript">
function go(select) {
	select.parentNode.submit();
}
function check(filtre) {
	var elmt = document.getElementById(filtre);
	if(elmt != null)
		elmt.selected = "selected";
}
</script>