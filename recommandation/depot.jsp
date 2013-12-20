
<%@ include file="header.jsp" %>
<%@ include file="menu.jsp" %>

<div id="maPage" class="div_body">
<h1>
<%
String nomRef = session.getAttribute("nomRef").toString();
String prenomRef = session.getAttribute("prenomRef").toString();
out.print(nomRef+" "+prenomRef);
%>
</h1>
<% 
String idUsr = session.getAttribute("idUsr").toString();
String nomUsr = session.getAttribute("nomUsr").toString();
String idRef = request.getAttribute("idRef").toString();
out.print("<center>"
		+"<p><span class=\"section-header-blue\">"+prop.getProperty("messageDepot")+"</span></p>"
		+"</center>");
out.print("<div class=\"salahddine_welcomeInfoFirstConnexion\">"
			+"<form action=\"telechargement\" method=\"post\" name=\"myform\" enctype=\"multipart/form-data\">"
			+"<table class=\"welcomeConnexion\">"
			+"<tr>"
				+"<td>"
				
				+"<center>"
				+"<p><span class=\"section-header-blue\">"+nomUsr+"</span></p>"
				+"</center>"
				
				+"<center>"
				+"<input type=\"file\" name=\""+idUsr+"_"+idRef+"\"/>"
				+"</center>"
				
				+"<br>"
				+"<center><input type=\"submit\" name=\"Submit\" value=\""+prop.getProperty("buttonValider")+"\" maxlength=\"8\" size=\"10\" class=\"form-button\"/>"
				+"</center>"
				+"</td>"
			+"</tr>"
			+"</table>"
			+"</forme>"
			+"</div>");
%>
<br></br>
<center>
			<p><span class="section-header-blue"><a href="listCandidat"><%= prop.getProperty("retourCandidats")  %></a><br></br></span></p>
</center>
<!-- <center>
			<p><span class="section-header-blue"><a href="deconnection"><%= prop.getProperty("deconnexion")  %></a><br></br></span></p>
</center>  -->
<br></br>

</div>
<%@ include file="menu.jsp" %>
</body>
</html>