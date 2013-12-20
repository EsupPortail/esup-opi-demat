
<%@ include file="header.jsp" %>
<%@ include file="menu.jsp" %>
<%@ page import="java.util.ArrayList, java.util.Map, java.util.TreeMap, java.io.File, java.util.Properties" %>

<div id="maPage" class="div_body">
<h1><%= session.getAttribute("nomUsr")%></h1>
<% 
ArrayList<String> listeFichiers = (ArrayList<String>) request.getAttribute("listeFichiers");
Map<String, String> MapNomCodeFichierNomFichier = (TreeMap<String, String>) request.getAttribute("MapNomCodeFichierNomFichier");
String libCmi = request.getAttribute("libCmi").toString();
String dateFin = request.getAttribute("dateFin").toString();
%>

<h2><%= libCmi %></h2>
<h3><%=prop.getProperty("dateFermeture")  %><%= dateFin %></h3><br/>
<%
int i= 0;
for (String fichier : listeFichiers) {
	String nomFichier = MapNomCodeFichierNomFichier.get(fichier.substring(0, fichier.indexOf(".")));
	out.print("<div style=\"float: left; width: 50%;\" >");
	out.println("<div class=\"salahddine_welcomeInfoFirstConnexion3\">");
	out.println("<table class=\"welcomeConnexion\"><tr><td><center>");
	out.println("<form action=\"depotModification.do\" method=\"post\" name=\"" + i + "\" class=\"form\">");
	out.println("<h2><span style=\"text-align: center;\" class=\"section-subheader2\"> " + nomFichier + " </span></h2>"+prop.getProperty("supprimer")+"<a href=\"suppressionDone?idFichier=" + fichier + "\">&nbsp;&nbsp;<img border=\"0\" src=\"./image/button_cancel.png\" value=\"supprimer\"/></a>");
	out.println("<input type=\"hidden\" name=\"valeurs\" value=\"" + nomFichier + "=" + fichier + "\">");
	out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
	out.println(prop.getProperty("modifier")+"&nbsp;&nbsp;<input type=\"submit\" class=\"iconeModifie\" name=\"submit\" value=\"\">");
	out.println("</form>");
	out.println("</td></tr></table></center>");
	out.println("</div><br>");
	out.print("</div>");
	i++;
}
if(listeFichiers.size() % 2 == 1){
	out.println("<table class=\"welcomeConnexion\"><tr><td></td></tr></table>");
}
%>
<center><p><span class="section-header-blue"><a href="depot.do"><%= prop.getProperty("retourAccueilDepot")  %></a><br></span></p></center>
<center><p><span class="section-header-blue"><a href="backToEtape"><%= prop.getProperty("retourAccueil")  %></a><br></br></span></p></center>
</div>
<%@ include file="menu.jsp" %>
</body>
</html>