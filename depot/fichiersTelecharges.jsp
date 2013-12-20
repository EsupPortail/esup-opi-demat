<%@ include file="header.jsp" %>
<%@ include file="menu.jsp" %>
<%@ page import="java.util.ArrayList, java.util.Map, java.util.TreeMap, java.io.File, java.util.Properties" %>

<div id="maPage" class="div_body">
<br /><br /><br />
<%
ArrayList<String> listFichierTelecharge = (ArrayList<String>) request.getAttribute("listFichierTelecharge");
for(String s : listFichierTelecharge){
	out.println("<center><p><span class=\"section-header-blue\"> "
			+ new String(s.replace('-', ' ').getBytes("ISO-8859-1"), "UTF-8")
			+" " +prop.getProperty("messageEstTelecharge")+"<br></br></span></p></center>");
}
%>

<center><p><span class="section-header-blue"><a href="depot.do"><%= prop.getProperty("retourAccueilDepot")  %></a><br></span></p></center>
<center><p><span class="section-header-blue"><a href="backToEtape"><%= prop.getProperty("retourAccueil")  %></a><br></br></span></p></center>
</div>
<%@ include file="menu.jsp" %>
</body>
</html>