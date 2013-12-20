<%@ page import="java.io.*, java.net.*, org.apache.commons.fileupload.*, java.util.List, java.util.Iterator, javax.activation.MimetypesFileTypeMap, java.util.ArrayList" %>
<%@ include file="header.jsp" %>
<%@ include file="menu.jsp" %>

<%

String numDossier = session.getAttribute("numDossier").toString();
String codeEtape = session.getAttribute("codeEtape").toString();
String codeVet = session.getAttribute("codeVet").toString();
String libCmi = request.getAttribute("libCmi").toString();
String dateFin = request.getAttribute("dateFin").toString();
ArrayList<String> listEmplacements = (ArrayList<String>) request.getAttribute("listEmplacements");
ArrayList<String> listPJ = (ArrayList<String>) request.getAttribute("pieces");
ArrayList<String> listCodePJ = (ArrayList<String>) request.getAttribute("codes");
String lienDossier = getServletContext().getInitParameter("lienDossier");
%>


<div id="maPage" class="div_body">
<%out.println("<h1>"+new String(request.getSession(false).getAttribute("nomUsr").toString().getBytes("utf-8"), "iso-8859-1")+"</h1>");%>
<h2><%= libCmi %></h2>
<h3><%=prop.getProperty("dateFermeture")  %><%= dateFin %></h3>

<center><p><span class="section-header-blue"><%= prop.getProperty("piecesJointes")  %></span></p></center>
<center><p><span class="section-header-blue"><a href="modification"><%=prop.getProperty("modifFiles")  %></a><br></span></p></center>
<center><p><span class="section-header-blue"><a href="backToEtape"><%= prop.getProperty("retour")  %></a><br></span></p></center>





<% 
int i = 0;
for(String pj : listPJ){
	out.print("<div style=\"float: left; width: 50%;\" >");
	out.println("<div class=\"salahddine_welcomeInfoFirstConnexion3\">");
	out.println("<table class=\"welcomeConnexion\">");
	out.println("<tr><td><center>");
	out.println("<h2><span style=\"text-align: center;\" class=\"section-subheader2\">"+pj+"</span></h2></center>");
	boolean exist = false;
	
	for(String emplacement : listEmplacements){
		if(emplacement.contains("/" +listCodePJ.get(listPJ.indexOf(pj))+".")) {
			File file = new File(emplacement);
			if(file.exists()){
				String codePj = listCodePJ.get(i);
				
				out.println("<form action='visualiser' method='post' name='myform" + i + "'>");
				out.print("<center><p><span class=\"portlet-section-text\">"+prop.getProperty("existFile")+"&nbsp;&nbsp;<img src=\"./image/button_ok.png\"></img></span></p></center>");
				out.print("<input type='hidden' name='numDossier' value='" + numDossier + "' />");
				out.print("<input type='hidden' name='codeEtape' value='" + codeEtape + "' />");
				out.print("<input type='hidden' name='codeVet' value='" + codeVet + "' />");
				out.print("<input type='hidden' name='codePj' value='" + codePj + "' />");
				out.print("<center><input type='submit' name='Submit' value='" + prop.getProperty("visualiser")  + "' maxlength='10' size='15' class='form-button'/></center>");
				exist = true;
			}
		}
	}
	if(!exist){
		out.println("<form action='uploading.do' method='post' name='myform" + i + "' enctype='multipart/form-data'>");
		out.print("<center><input type=\"file\" name="+new String(pj.replaceAll(" ", "-").toString().getBytes("utf-8"), "iso-8859-1")+"="+listCodePJ.get(i)+" /><img src=\"./image/button_cancel.png\"></center>");
		out.print("<center><input type='submit' name='Submit' value='" + prop.getProperty("buttonValider")  + "' maxlength='10' size='15' class='form-button'/></center>");
	}
	out.print("</form>");
	out.println("</tr>");
	out.println("</table>");
	out.println("</div><br>");
	
	out.print("</div><br>");
	
	i++;
}
%>
	
	
<center><p><span class="section-header-blue"><a href="modification"><%= prop.getProperty("modifFiles")  %></a><br></span></p></center>
<center><p><span class="section-header-blue"><a href="backToEtape"><%= prop.getProperty("retour")  %></a><br></span></p></center>


</div>
<%@ include file="menu.jsp" %>
</body>
</html>