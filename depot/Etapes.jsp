<%@ include file="header.jsp" %>
<%@ include file="menu.jsp" %>
<%@ page import="java.io.*, java.net.*, org.apache.commons.fileupload.*, java.util.List, java.util.Iterator, javax.activation.MimetypesFileTypeMap, java.util.ArrayList" %>


<div id="maPage" class="div_body">
<h1><%= request.getSession(false).getAttribute("nomUsr").toString() %></h1>
<center><p><span class="section-header-blue"><%= prop.getProperty("titreEtape")  %></span></p></center>
<%
//out.println(request.getAttribute("codeEtapes"));
//out.println(request.getAttribute("codeVets"));
//out.println(request.getAttribute("idTrtCmis"));
ArrayList<String> codeEtapes = (ArrayList<String>) request.getAttribute("codeEtapes");
ArrayList<String> codeVets = (ArrayList<String>) request.getAttribute("codeVets");
ArrayList<String> trtCmis = (ArrayList<String>) request.getAttribute("trtCmis");
ArrayList<String> libCmis = (ArrayList<String>) request.getAttribute("libCmis");

int i = 0;
for(String etape : codeEtapes){
	out.print("<form action=\"depot.do\" method=\"post\" name=\"myform"+i+"\">");
	out.print("<center>"+libCmis.get(i)+"</center>");
	out.print("<input type=\"hidden\" name=\"codeEtape\" value="+etape+">");
	out.print("<input type =\"hidden\" name=\"codeVet\" value="+codeVets.get(i)+">");
	out.print("<input type =\"hidden\" name=\"idTrtCmi\" value="+trtCmis.get(i)+">");
	out.println("<br>");
	out.print("<center><input type=\"submit\" name=\"Submit\" value="+prop.getProperty("buttonEntrer")+"  maxlength=\"8\" size=\"10\" class=\"form-button\"/></center>");
	out.print("</form>");
	out.print("<br /><br /><br />");
	i++;
}


%>

<!--   <center><p><span class="section-header-blue"><a href="deconnection.do"><%= prop.getProperty("deconnexion")  %></a></span></p></center> -->
<br /><br /><br /><br />
<div class="blockImportant">
<!-- <center><p><span class="section-header-blue"><a href="recommandation" class="lien"><%= prop.getProperty("lienRecommandation")  %></a></span></p></center> -->
<!--   <center><p><span class="section-header-blue"><a href="<%= prop.getProperty("lienCandidature") %> " class="lien"><%= prop.getProperty("retourCandidature")  %></a></span></p></center> -->
</div>
 </div>
 <%@ include file="menu.jsp" %>
</body>
</html>
