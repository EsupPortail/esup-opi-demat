<%@ page import = "java.util.TreeMap, java.util.Map" %>
<%@ include file="header.jsp" %>
<%@ include file="menu.jsp" %>
	
	<div id="maPage" class="div_body">
	
	<%
	String nomRef = request.getAttribute("nomRef").toString();
	String prenomRef = request.getAttribute("prenomRef").toString();
	String idRef = request.getAttribute("idRef").toString();
	TreeMap<String, String> mapIdUsrNomUsr = (TreeMap<String, String>) request.getAttribute("mapIdUsrNomUsr");
	//TreeMap<String, String> mapIdUsrNomFile = (TreeMap<String, String>) request.getAttribute("mapIdUsrNomFile");
	//out.print(nomRef+prenomRef+idRef+mapIdUsrNomUsr.toString()+mapIdUsrNomFile.toString());
	out.print("<h1>"+nomRef+" "+prenomRef+"</h1>");
	out.print("<center><p><span class=\"section-header-blue\">"+prop.getProperty("titreListeEtudiant")+"</span></p></center>");
	int i = 0;
	out.print("<form action=\"etudiant\" method=\"post\" name=\"myform\">");
	for (Map.Entry<String, String> e : mapIdUsrNomUsr.entrySet()){
		out.print("<div class=\"salahddine_welcomeInfoFirstConnexion\">"
				+"<table class=\"welcomeConnexion\">"
				+"<tr>"
				+"<td>"
				
				+"<center>"
				+"<p><span class=\"section-header-blue\">"+e.getValue()+"</span></p>"
				+"</center>");
		if(i==0){
			out.print("<center>"
					+"<input type=\"radio\" name=\"idUsr\"  value=\""+e.getKey()+"\" checked=\"checked\"/>"
					+"</center>"
					+"<input type=\"hidden\" name=\"nomUsr"+e.getKey()+"\"  value=\""+e.getValue()+"\"/>");
		}else {
			out.print("<center>"
					+"<input type=\"radio\" name=\"idUsr\"  value=\""+e.getKey()+"\"/>"
					+"</center>"
					+"<input type=\"hidden\" name=\"nomUsr"+e.getKey()+"\"  value=\""+e.getValue()+"\"/>");
		}
		
		out.print("<br>"
			+"</td>"
			+"</tr>"
			+"</table>"
			+"</div>"
			+"<br>");
		i++;
		
	}
	out.print("</forme>");
	out.print("<center><input type=\"submit\" name=\"Submit"+i+"\" value=\""+prop.getProperty("buttonValider")+"\" maxlength=\"8\" size=\"10\" class=\"form-button\"/>"
	+"</center>");
	%>
	<br></br>
	<!--  <center><p><span class="section-header-blue"><a href="deconnection"><%= prop.getProperty("deconnexion")  %></a></span></p></center> -->
	</div>
<%@ include file="menu.jsp" %>
</body>
</html>