package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Properties;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.io.File;
import java.util.Properties;

public final class interface2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


public String liensColonne(Map<String, ArrayList<String>>  MapCodeFileColonneFiles, String codeFile, String lienDossier) {
	ArrayList<String> listEmplacements = MapCodeFileColonneFiles.get(codeFile);
	String liens ="";
	for(String emplacement : listEmplacements){
		String extention = emplacement.substring(emplacement.lastIndexOf(".") + 1);
		if(new File(emplacement).exists() && extention.toLowerCase().equals("pdf")) {
			String lien = emplacement.substring(0, emplacement.lastIndexOf(".")).replaceAll(lienDossier, "");
			liens += lien + "&";
		}
	}
	return liens;
}
public int nbPages(int nbEtudiants, int nbEtudiantParPage) {
	if(nbEtudiants <= nbEtudiantParPage)
		return 1;
	else {
		if(nbEtudiants % 2 == 0)
			return (nbEtudiants - (nbEtudiants % nbEtudiantParPage))/nbEtudiantParPage;
		else
			return (nbEtudiants - (nbEtudiants % nbEtudiantParPage))/nbEtudiantParPage + 1;
	}
}

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(5);
    _jspx_dependants.add("/header.jsp");
    _jspx_dependants.add("/menu.jsp");
    _jspx_dependants.add("/filtre.jsp");
    _jspx_dependants.add("/checkFichiers.jsp");
    _jspx_dependants.add("/pagination.jsp");
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

	Properties prop = com.tg_mvc.tools.LoadProperties.load(getServletContext().getRealPath("/")+"/WEB-INF/classes/Message_fr.properties");

      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\">\n");
      out.write("<title>");
      out.print( application.getInitParameter("titre") );
      out.write("</title>\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\n");
      out.write("\thref=\"./media/style/SABERKAN.css\" />\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body class=\"portlet-section-body esup-opiR1\">\n");
      out.write("<div id=\"header\" class=\"header\">\n");
      out.write("<div class=\"logo\"></div>\n");
      out.write("<div class=\"header_suite\">\n");
      out.write("<div id=\"titreAppli\" class=\"titreAppli\"><span\n");
      out.write("\tclass=\"span_bigTitre\">");
      out.print( prop.getProperty("candidatures") );
      out.write("</span> <br />\n");
      out.write("<span class=\"span_titre\">");
      out.print( prop.getProperty("operation") );
      out.write("</span></div>\n");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"user_displayName\"><span class=\"span_currentUser\"></span>\n");
      out.write("</div>\n");
      out.write("<div class=\"version\"><span class=\"span_version\"></span></div>\n");
      out.write("</div>\n");
      out.write("</div>");
      out.write('\n');
      out.write("<ul id=\"navigationHeader:navigation\" class=\"menu\">\n");
      out.write("\t<li class=\"item\"><a class=\"rubrique\" href=\"");
      out.print( prop.getProperty("lienCandidature") );
      out.write("\" target=_blank>Accueil</a></li>\n");
      out.write("\t\n");
      out.write("\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("\t\n");
      out.write("\t<li class=\"item\"><a class=\"rubrique\" href=\"");
      out.print( prop.getProperty("lienCommission") );
      out.write("\" target=_blank>Commission</a></li>\n");
      out.write("\t\n");
      out.write("\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("\t\n");
      out.write("\t<li class=\"item\"><a class=\"rubrique\" href=\"");
      out.print(  prop.getProperty("casLogOut")  );
      out.write("\">D&#233;connexion</a></li>\n");
      out.write("</ul>\n");
      out.write('\n');
      out.write('\n');

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
Map<String, String> MapLibNomsPcLicNomsPc = (TreeMap<String, String>) request.getAttribute("MapLibNomsPcLicNomsPc");
Map<String, String> MapLibNomsPsLicNomsPs = (TreeMap<String, String>) request.getAttribute("MapLibNomsPsLicNomsPs");
Map<String, String> MapIdUsrEtudiantProvenance = (TreeMap<String, String>) request.getAttribute("MapIdUsrEtudiantProvenance");
Map<String, ArrayList<String>> MapIdUsrLienRecommandation = (TreeMap<String, ArrayList<String>>) request.getAttribute("MapIdUsrLienRecommandation");
Map<String, String> MapIdUsrEtudiantObservation = (TreeMap<String, String>) request.getAttribute("MapIdUsrEtudiantObservation");
Map<String, String> MapIdUsrEtudiantTraitement = (TreeMap<String, String>) request.getAttribute("MapIdUsrEtudiantTraitement");
Map<String, String> MapIdUsrEtudiantAvis = (TreeMap<String, String>) request.getAttribute("MapIdUsrEtudiantAvis");
Map<String, ArrayList<String>> MapIdUsrEmplacementsForIdCmi = (TreeMap<String, ArrayList<String>>) request.getAttribute("MapIdUsrEmplacementsForIdCmi");
Map<String, ArrayList<String>> MapCodeFileColonneFiles = (TreeMap<String, ArrayList<String>>) request.getAttribute("MapCodeFileColonneFiles");
String lienDossier = application.getInitParameter("lienDossier");
String filtre = request.getAttribute("filtre").toString();
String filtreProvenance = request.getAttribute("filtreProvenance").toString();
String filtreAvis = request.getAttribute("filtreAvis").toString();
int numPage = Integer.parseInt(request.getAttribute("numPage").toString());
int nbEtudiantsParPage = Integer.parseInt(request.getAttribute("nbEtudiantsParPage").toString());

      out.write('\n');
      out.write("\n");
      out.write("<body   onLoad=\"check('");
      out.print( filtre );
      out.write("'); check('");
      out.print( filtreProvenance );
      out.write("'); check('");
      out.print( filtreAvis );
      out.write("'); check('");
      out.print( nbEtudiantsParPage );
      out.write("');\">\n");
      out.write("<div id=\"maPage\" class=\"salahddine_welcomeInfoFirstConnexion2\" >\n");
      out.write("\n");
      out.write("\n");
      out.write("<div  class=\"blockImportant\">\n");
      out.write("\t<br>\n");
      out.write("\t<form action=\"interface\" method=\"post\" name=\"myform1\" >\n");
      out.write("\t\t<span class=\"section-header-blue\">");
      out.print( prop.getProperty("typeTraitement") );
      out.write("</span>\n");
      out.write("\t\t<SELECT name=\"filtre\" onChange=\"go(this)\" >\n");
      out.write("\t\t\t<OPTION id=\"ToutTraitement\" VALUE=\"Tout\" >Tout</OPTION>\n");
      out.write("\t\t\t<OPTION id=\"STATE.TRAITE\" VALUE=\"STATE.TRAITE\" >");
      out.print( prop.getProperty("traite") );
      out.write("</OPTION>\n");
      out.write("\t\t\t<OPTION id=\"STATE.NON_TRAITE\" VALUE=\"STATE.NON_TRAITE\" >");
      out.print( prop.getProperty("nonTraite") );
      out.write("</OPTION> \n");
      out.write("<!--\t\t<OPTION id=\"STATE.EN_COURS_TRAITEMENT\" VALUE=\"STATE.EN_COURS_TRAITEMENT\" >En cours de traitement</OPTION>  -->\n");
      out.write("\t\t</SELECT>\n");
      out.write("\t\t<span class=\"section-header-blue\">");
      out.print( prop.getProperty("origine") );
      out.write("</span>\n");
      out.write("\t\t<SELECT name=\"filtreProvenance\" onChange=\"go(this)\" >\n");
      out.write("\t\t\t<OPTION id=\"TouteProvenance\" VALUE=\"Tout\" >Tout</OPTION>\n");
      out.write("\t\t\t<OPTION id=\"");
      out.print( prop.getProperty("dauphine") );
      out.write("\" VALUE=\"");
      out.print( prop.getProperty("dauphine") );
      out.write('"');
      out.write(' ');
      out.write('>');
      out.print( prop.getProperty("dauphine") );
      out.write("</OPTION>\n");
      out.write("\t\t\t<OPTION id=\"");
      out.print( prop.getProperty("france") );
      out.write("\" VALUE=\"");
      out.print( prop.getProperty("france") );
      out.write('"');
      out.write(' ');
      out.write('>');
      out.print( prop.getProperty("france") );
      out.write("</OPTION>\n");
      out.write("\t\t\t<OPTION id=\"");
      out.print( prop.getProperty("etranger") );
      out.write("\" VALUE=\"");
      out.print( prop.getProperty("etranger") );
      out.write('"');
      out.write(' ');
      out.write('>');
      out.print( prop.getProperty("etranger") );
      out.write("</OPTION>\n");
      out.write("\t\t</SELECT>\n");
      out.write("\t\t<span class=\"section-header-blue\">");
      out.print( prop.getProperty("avis") );
      out.write("</span>\n");
      out.write("\t\t<SELECT name=\"filtreAvis\" onChange=\"go(this)\" >\n");
      out.write("\t\t\t<OPTION id=\"TouteAvis\" VALUE=\"Tout\" >Tout</OPTION>\n");
      out.write("\t\t\t<OPTION id=\"");
      out.print( prop.getProperty("sansAvis") );
      out.write("\" VALUE=\"");
      out.print( prop.getProperty("sansAvis") );
      out.write('"');
      out.write(' ');
      out.write('>');
      out.print( prop.getProperty("sansAvis") );
      out.write("</OPTION>\n");
      out.write("\t\t\t");
 
			for(String avis : listLicNomAvis){
				out.println("<OPTION id='"+avis+"' VALUE='"+avis+"'>"+avis+"</OPTION>");
			}
			
      out.write("\n");
      out.write("\t\t</SELECT>\n");
      out.write("\t\t<input type=\"hidden\" name=\"idCmi\" value=\"");
      out.print( idCmi );
      out.write("\" />\n");
      out.write("\t\t<input type=\"hidden\" name=\"libCmi\" value=\"");
      out.print( libCmi );
      out.write("\" />\n");
      out.write("\t\t<input type=\"hidden\" name=\"numPage\" value=\"");
      out.print( numPage );
      out.write("\" />\n");
      out.write("\t\t<input type='hidden' name='nbEtudiantsParPage' value='");
      out.print( nbEtudiantsParPage );
      out.write("' />\n");
      out.write("\t</form>\n");
      out.write("\t\n");
      out.write("\t\n");
      out.write("\t<br>\n");
      out.write("</div>\n");
      out.write('\n');
      out.write("\n");
      out.write("<div  class=\"blockImportant\">\n");
      out.write("\t<br>\n");
      out.write("\t<h3>");
      out.print(  prop.getProperty("fichiersAAfficher")  );
      out.write("</h3>\n");
      out.write("\t<form name=\"myform\" action=\"fichiersAAffiche\" method=\"POST\">\n");
      out.write("\t\t<table border=\"1\">\n");
      out.write("\t\t");

		int ordreFile = 0;
		for (String s : listCodeNomPc) {
			if(ordreFile % 2 == 0)
				out.print("<tr>");
			out.print("<td>");
			String libNom = new String((listLibNomPc.get(listCodeNomPc.indexOf(s))).getBytes("iso-8859-1"), "utf-8");
			String licNom = MapLibNomsPcLicNomsPc.get(libNom);
			if(listFichiersAAffiche!=null && !listFichiersAAffiche.contains(s)) {
				out.print("<input type='checkbox' name='fichier' value='"+s+"'>"+"<nobr>"+libNom+" ("+licNom+")</nobr>");
			} else {
				out.print("<input type='checkbox' name='fichier' value='"+s+"' checked='true'>"+"<nobr>"+libNom+" ("+licNom+")</nobr>");
			}
			out.print("</td>");
			if(ordreFile % 2 == 1) 
				out.print("</tr>");
			ordreFile++;
		}
		for(String s : listCodeNomPs){
				if(ordreFile % 2 == 0)
					out.print("<tr>");
				out.print("<td>");
				String libNom = listLibNomPs.get(listCodeNomPs.indexOf(s)) ;
				String licNom =  MapLibNomsPsLicNomsPs.get(libNom);
				
				if(listFichiersAAffiche!=null && !listFichiersAAffiche.contains(s)) {
					out.print("<input type='checkbox' name='fichier' value='"+s+"'>"+"<nobr>"+libNom+" ("+licNom+")</nobr>");
				} else {
					out.print("<input type='checkbox' name='fichier' value='"+s+"' checked='true'>"+"<nobr>"+libNom+" ("+licNom+")</nobr>");
				}
				out.print("</td>");
				if(ordreFile % 2 == 1) 
					out.print("</tr>");
				ordreFile++;
		}
		
      out.write("\n");
      out.write("\t\t</table>\n");
      out.write("\t\t<br><br>\n");
      out.write("\t\t<input type=\"hidden\" name=\"idCmi\" value=\"");
      out.print( idCmi );
      out.write("\" ></input>\n");
      out.write("\t\t<input type=\"hidden\" name=\"libCmi\" value=\"");
      out.print( libCmi );
      out.write("\" ></input>\n");
      out.write("\t\t<input type=\"hidden\" name=\"filtre\" value=\"");
      out.print( filtre );
      out.write("\" ></input>\n");
      out.write("\t\t<input type=\"hidden\" name=\"filtreProvenance\" value=\"");
      out.print( filtreProvenance );
      out.write("\" ></input>\n");
      out.write("\t\t<input type=\"hidden\" name=\"filtreAvis\" value=\"");
      out.print( filtreAvis );
      out.write("\" ></input>\n");
      out.write("\t\t<input type=\"hidden\" name=\"numPage\" value=\"");
      out.print( numPage );
      out.write("\" />\n");
      out.write("\t\t<input type='hidden' name='nbEtudiantsParPage' value='");
      out.print( nbEtudiantsParPage );
      out.write("' />\n");
      out.write("\t\t<input type=\"submit\" value=\"afficher\" maxlength='8' size='10' class='form-button'/>\n");
      out.write("\t</form>\n");
      out.write("\t<br>\n");
      out.write("</div>");
      out.write("\n");
      out.write("\n");
      out.write("<CAPTION><span class=\"section-header-blue\">");
      out.print( prop.getProperty("commission") );
      out.write(' ');
      out.write(':');
      out.write(' ');
      out.print( libCmi );
      out.write("</span><CAPTION>\n");
      out.write("\n");

int nbPages = nbPages(listIdUsrEtudiantSurPage.size(), nbEtudiantsParPage);
int indicePremierEtudiant = (numPage - 1) * nbEtudiantsParPage;
int indiceDernierEtudiant = indicePremierEtudiant + nbEtudiantsParPage;

      out.write('\n');
      out.write('\n');

//nbEtudiants
out.print("<p>"+prop.getProperty("nbEtudiants")+listIdUsrEtudiantSurPage.size()+"</p>");

//numero page
out.print("<p>"+prop.getProperty("page")+numPage+"/"+nbPages+"</p>");

      out.write("\n");
      out.write("<nobr>\n");
 
if (numPage > 1) {
	int newNumPage = numPage - 1;
	out.print("<form style='display: inline;' action='interface' method='post' name='myformA' >");
	out.print("<input type='hidden' name='numPage' value='"+newNumPage+"' />");
	out.print("<input type='hidden' name='libCmi' value='"+libCmi+"' />");
	out.print("<input type='hidden' name='idCmi' value='"+idCmi+"' />");
	out.print("<input type='hidden' name='filtre' value='"+filtre+"' />");
	out.print("<input type='hidden' name='filtreProvenance' value='"+filtreProvenance+"' />");
	out.print("<input type='hidden' name='filtreAvis' value='"+filtreAvis+"' />");
	out.print("<input type='hidden' name='nbEtudiantsParPage' value='"+nbEtudiantsParPage+"' />");
	out.print("<input type='submit' value='Precedent' maxlength='8' size='10' class='form-button' />");
	out.print("</form>");
}

for (int i = 1; i <= nbPages; i++) {
	out.print("<form style='display: inline;' action='interface' method='post' name='myform"+i+"' >");
	out.print("<input type='hidden' name='numPage' value='"+i+"' />");
	out.print("<input type='hidden' name='libCmi' value='"+libCmi+"' />");
	out.print("<input type='hidden' name='idCmi' value='"+idCmi+"' />");
	out.print("<input type='hidden' name='filtre' value='"+filtre+"' />");
	out.print("<input type='hidden' name='filtreProvenance' value='"+filtreProvenance+"' />");
	out.print("<input type='hidden' name='filtreAvis' value='"+filtreAvis+"' />");
	out.print("<input type='hidden' name='nbEtudiantsParPage' value='"+nbEtudiantsParPage+"' />");
	out.print("<input type='submit' value='"+i+"' maxlength='8' size='10' class='form-button' />");
	out.print("</form>");
}

if (numPage != nbPages ) {
	int newNumPage = numPage + 1;
	out.print("<form style='display: inline;' action='interface' method='post' name='myformB' >");
	out.print("<input type='hidden' name='numPage' value='"+newNumPage+"' />");
	out.print("<input type='hidden' name='libCmi' value='"+libCmi+"' />");
	out.print("<input type='hidden' name='idCmi' value='"+idCmi+"' />");
	out.print("<input type='hidden' name='filtre' value='"+filtre+"' />");
	out.print("<input type='hidden' name='filtreProvenance' value='"+filtreProvenance+"' />");
	out.print("<input type='hidden' name='filtreAvis' value='"+filtreAvis+"' />");
	out.print("<input type='hidden' name='nbEtudiantsParPage' value='"+nbEtudiantsParPage+"' />");
	out.print("<input type='submit' value='Suivant' maxlength='8' size='10' class='form-button' />");
	out.print("</form>");
}

      out.write("\n");
      out.write("<FORM style='display: inline;' action='interface' method='post' name='myformC' >\n");
      out.write("\t<span class=\"section-header-blue\">Etudiants par page : </span>\n");
      out.write("\t<SELECT name=\"nbEtudiantsParPage\" onChange=\"go(this)\" >\n");
      out.write("\t\t\t<OPTION id=\"1\" VALUE=\"1\" >1</OPTION>\n");
      out.write("\t\t\t<OPTION id=\"10\" VALUE=\"10\" >10</OPTION>\n");
      out.write("\t\t\t<OPTION id=\"20\" VALUE=\"20\" >20</OPTION>\n");
      out.write("\t\t\t<OPTION id=\"30\" VALUE=\"30\" >30</OPTION>\n");
      out.write("\t\t\t<OPTION id=\"40\" VALUE=\"40\" >40</OPTION> \n");
      out.write("\t</SELECT>\n");
      out.write("\t<input type=\"hidden\" name=\"idCmi\" value=\"");
      out.print( idCmi );
      out.write("\" ></input>\n");
      out.write("\t<input type=\"hidden\" name=\"libCmi\" value=\"");
      out.print( libCmi );
      out.write("\" ></input>\n");
      out.write("\t<input type=\"hidden\" name=\"filtre\" value=\"");
      out.print( filtre );
      out.write("\" ></input>\n");
      out.write("\t<input type=\"hidden\" name=\"filtreProvenance\" value=\"");
      out.print( filtreProvenance );
      out.write("\" ></input>\n");
      out.write("\t<input type=\"hidden\" name=\"filtreAvis\" value=\"");
      out.print( filtreAvis );
      out.write("\" ></input>\n");
      out.write("\t<input type=\"hidden\" name=\"numPage\" value=\"1\" />\n");
      out.write("</FORM>\n");
      out.write("</nobr>");
      out.write("\n");
      out.write("\n");
      out.write("<table style='border-collapse: separate; border-spacing: 2px; border-color: gray;'>\n");
      out.write("\n");


/**************************************************** Entete ****************************************************/
out.println("<tr style='background-color: lightgray;'>");

//provenance + num de dossier + nom prenom + fichiers
out.println("<td>");
out.println(prop.getProperty("provenance"));
out.println("</td>");
out.println("<td>");
out.println(prop.getProperty("numDossier"));
out.println("</td>");
out.println("<td>");
out.println(prop.getProperty("nomEtPrenom"));
out.println("</td>");

//list des pieces communes
for(String nomPc : listLibNomPc) {
	String libNomPc = new String(nomPc.toString().getBytes("iso-8859-1"), "utf-8");
	String licNomPc = MapLibNomsPcLicNomsPc.get(libNomPc);
	String codeNomPc = listCodeNomPc.get(listLibNomPc.indexOf(nomPc));
	
	//sauter si le fichier n'est pas a afficher, et le gestionnaire arrive pas la 1ere fois sur la page (listfichiersAAFFICHE = null)
	if(listFichiersAAffiche != null && !listFichiersAAffiche.contains(codeNomPc))
		continue;
	
	out.println("<td valign=bottom>"+licNomPc);
	
	//recuperation de fichiers par colonne
	String liensColonne = liensColonne(MapCodeFileColonneFiles, codeNomPc, lienDossier);
	if(liensColonne.trim().length() != 0){
		out.println("<form action=\"telechargementMultipleColonne\" method=\"post\" name=\"myform\">");
		out.println("<input type=\"hidden\" name=\"liens\" value="+liensColonne+">");
		out.println("<input type=\"hidden\" name=\"codePiece\" value="+codeNomPc+">");
		out.println("<input type=\"hidden\" name=\"codeEtape\" value="+codeEtape+">");
		out.println("<input type=\"hidden\" name=\"codeVet\" value="+codeVet+">");
		out.println("</form>");
	} else {
		out.print("<center><p><span class=\"portlet-section-text\"><img src=\"./image/button_cancel.png\"></img></span></p></center>");
	}
	
	out.println("</td>");
}

//list des pieces specifiques
for(String nomPs : listLibNomPs) {
	String licNomPs = MapLibNomsPsLicNomsPs.get(nomPs);
	String codeNomPs = listCodeNomPs.get(listLibNomPs.indexOf(nomPs));
	
	out.println("<td  valign=bottom>"+licNomPs);
	
	String liensColonne = liensColonne(MapCodeFileColonneFiles, codeNomPs, lienDossier);
	if(liensColonne.trim().length() != 0){
		out.println("<form action=\"telechargementMultipleColonne\" method=\"post\" name=\"myform\">");
		//out.println("<center><input type=\"submit\" name=\"telecharger\" value=\"telecharger\" maxlength=\"8\" size=\"10\" class=\"form-button\"></center>");
		out.println("<br/><center><input type=\"submit\" class=\"iconeTelecharger\" name=\"telecharger\" value=\"\" /></center>");
		out.println("<input type=\"hidden\" name=\"liens\" value="+liensColonne+">");
		out.println("<input type=\"hidden\" name=\"codePiece\" value="+codeNomPs+">");
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

//telecharger toute la ligne
out.println("<td>");
out.println("Telecharger tout le dossier");
out.println("</td>");

//Avis
out.println("<td>");
out.println("<center>"+prop.getProperty("avis")+"</center>");
out.println("</td>");

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
	
	String provenance = MapIdUsrEtudiantProvenance.get(idUsrEtudiant);
	String numDossier = listNumDossier.get(listIdUsrEtudiant.indexOf(idUsrEtudiant));
	String nomEtudiant = listNomEtudiant.get(listIdUsrEtudiant.indexOf(idUsrEtudiant));
	
	//provenance
	out.println("<td>");
	out.println(provenance);
	out.println("</td>");
	
	//numero de dossier
	out.println("<td>");
	out.println(numDossier);
	out.println("</td>");
	
	//nom
	out.println("<td>");
	out.println(nomEtudiant);
	out.println("</td>");
	
	//files
	String liens = "";
	for(String codeFile : listCodeFile) {
		//sauter si le fichier n'est pas a afficher, et le gestionnaire arrive pas la 1ere fois sur la page (listfichiersAAFFICHE = null)
		if(listFichiersAAffiche != null && !listFichiersAAffiche.contains(codeFile)){
			continue;
		}
		
		out.println("<td>");
		fileExist = false;
		ArrayList<String> listEmplacementsPourIdUsr = MapIdUsrEmplacementsForIdCmi.get(idUsrEtudiant);
		String emplacement = "";
		for(String lien : listEmplacementsPourIdUsr) {
			if(lien.contains(codeFile) && new File(lien).exists()) {
				String extention = lien.substring(lien.lastIndexOf(".") + 1);
				if(extention.equals("pdf") || extention.equals("xls")) {
					fileExist = true;
					emplacement = lien;
				}
			}
		}
		if(fileExist) {
			out.println("<form action=\"telechargement\" method=\"post\" name=\"myform\">");
			//out.println("<center><input type=\"submit\" name=\"telecharger\" value=\"telecharger\" maxlength=\"8\" size=\"10\" class=\"form-button\"></center>");
			out.println("<center><input type=\"submit\" class=\"iconeTelecharger\" name=\"telecharger\" value=\"\" /></center>");
			//out.println("<input type=\"hidden\" name=\"lien\" value="+s+"-"+codeVet+"/"+MapCodeEtapeNumDossier.get(s).get(MapCodeEtapeIdUsrEtudiant.get(s).indexOf(s2))+"/"+codeFile+">");
			out.println("<input type=\"hidden\" name=\"nomEtudiant\" value="+nomEtudiant.replaceAll(" ", "_")+">");
			out.println("<input type=\"hidden\" name=\"codeEtape\" value="+codeEtape+">");
			out.println("<input type=\"hidden\" name=\"codeVet\" value="+codeVet+">");
			emplacement = emplacement.substring(0, emplacement.lastIndexOf(".")).replaceAll(lienDossier, "");
			out.println("<input type=\"hidden\" name=\"lien\" value="+emplacement+">");
			liens += emplacement + "&";
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
				//out.println("<center><input type=\"submit\" name=\"telecharger\" value=\"telecharger\" maxlength=\"8\" size=\"10\" class=\"form-button\"></center>");
				out.println("<center><input type=\"submit\" class=\"iconeTelecharger\" name=\"telecharger\" value=\"\" /></center>");
				out.println("<input type=\"hidden\" name=\"lien\" value="+MapIdUsrLienRecommandation.get(idUsrEtudiant).get(i).substring(longueurLienDossier, MapIdUsrLienRecommandation.get(idUsrEtudiant).get(i).lastIndexOf("."))+">");
				out.println("<input type=\"hidden\" name=\"nomEtudiant\" value="+nomEtudiant.replaceAll(" ", "_")+">");
				out.println("<input type=\"hidden\" name=\"type\" value=recommandation>");
				out.println("<input type=\"hidden\" name=\"codeEtape\" value="+codeEtape+">");
				out.println("<input type=\"hidden\" name=\"codeVet\" value="+codeVet+">");
				liens += MapIdUsrLienRecommandation.get(idUsrEtudiant).get(i).substring(longueurLienDossier, MapIdUsrLienRecommandation.get(idUsrEtudiant).get(i).lastIndexOf(".")) + "&";
				out.println("</form>");
			} else {
				out.print("<center><p><span class=\"portlet-section-text\"><img src=\"./image/button_cancel.png\"></img></span></p></center>");
			}
		} else {
			out.print("<center><p><span class=\"portlet-section-text\"><img src=\"./image/button_cancel.png\"></img></span></p></center>");
		}
		out.print("</td>");
	}
	
	//telecharger tout le dossier
	String[] tabLiens = liens.split("&");
	boolean aucunPDF = true;
	for(int i = 0; i < tabLiens.length; i++) {
		if(new File(lienDossier+tabLiens[i]+".pdf").exists())
			aucunPDF = false;
	}
	out.println("<td>");
	if(!aucunPDF) {
		
		out.println("<form action=\"telechargementMultiple\" method=\"post\" name=\"myform\">");
		//out.println("<center><input type=\"submit\" name=\"telecharger\" value=\"telecharger\" maxlength=\"8\" size=\"10\" class=\"form-button\"></center>");
		out.println("<center><input type=\"submit\" class=\"iconeTelecharger\" name=\"telecharger\" value=\"\" /></center>");
		out.println("<input type=\"hidden\" name=\"liens\" value="+liens+">");
		out.println("<input type=\"hidden\" name=\"nomEtudiant\" value="+nomEtudiant.replaceAll(" ", "_")+">");
		out.println("<input type=\"hidden\" name=\"codeEtape\" value="+codeEtape+">");
		out.println("<input type=\"hidden\" name=\"codeVet\" value="+codeVet+">");
		out.println("</form>");
		
	} else {
		out.print("<center><p><span class=\"portlet-section-text\"><img src=\"./image/button_cancel.png\"></img></span></p></center>");
	}
	out.println("</td>");
	
	//Avis
	out.println("<td>");
	out.println("<nobr><center>"+MapIdUsrEtudiantAvis.get(idUsrEtudiant)+"</center></nobr>");
	out.println("</td>");
	
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
	out.println("<input type=\"hidden\" name=\"filtreProvenance\" value=\""+filtreProvenance+"\">");
	out.println("<input type=\"hidden\" name=\"filtreAvis\" value=\""+filtreAvis+"\">");
	out.println("<input type=\"hidden\" name=\"numPage\" value=\""+numPage+"\">");
	out.print("<input type='hidden' name='nbEtudiantsParPage' value='"+nbEtudiantsParPage+"' />");
	out.print("</td>");
	
	//mettre à jour
	out.print("<td>");
	out.println("<center><input type=\"submit\" name=\"MettreAJour\" value=\"Mettre à jour\" maxlength=\"8\" size=\"10\" class=\"form-button\"></center>");
	out.print("</td>");
	out.println("</form>");
	
	out.println("</tr>");
}

      out.write("\n");
      out.write("</table>\n");
      out.write("<form action=\"login\" method=\"post\" name=\"myform\">\n");
      out.write("\t<input type=\"submit\" name=\"retour\" value=\"");
      out.print( prop.getProperty("retour") );
      out.write("\" maxlength=\"8\" size=\"10\" class=\"form-button\" />\n");
      out.write("\t<input type=\"hidden\" name=\"login\" value=\"");
      out.print( session.getAttribute("login") );
      out.write("\" />\n");
      out.write("</form>\n");
      out.write("</div>\n");
      out.write("<ul id=\"navigationHeader:navigation\" class=\"menu\">\n");
      out.write("\t<li class=\"item\"><a class=\"rubrique\" href=\"");
      out.print( prop.getProperty("lienCandidature") );
      out.write("\" target=_blank>Accueil</a></li>\n");
      out.write("\t\n");
      out.write("\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("\t\n");
      out.write("\t<li class=\"item\"><a class=\"rubrique\" href=\"");
      out.print( prop.getProperty("lienCommission") );
      out.write("\" target=_blank>Commission</a></li>\n");
      out.write("\t\n");
      out.write("\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("\t\n");
      out.write("\t<li class=\"item\"><a class=\"rubrique\" href=\"");
      out.print(  prop.getProperty("casLogOut")  );
      out.write("\">D&#233;connexion</a></li>\n");
      out.write("</ul>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("<script language=\"javascript\" type=\"text/javascript\">\n");
      out.write("function go(select) {\n");
      out.write("\tselect.parentNode.submit();\n");
      out.write("}\n");
      out.write("function check(filtre) {\n");
      out.write("\tvar elmt = document.getElementById(filtre);\n");
      out.write("\tif(elmt != null)\n");
      out.write("\t\telmt.selected = \"selected\";\n");
      out.write("}\n");
      out.write("</script>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
