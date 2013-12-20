<%@ include file="header.jsp" %>
<%@ include file="menu.jsp" %>

<div id="maPage" class="div_body">

<%out.println("<h1>"+new String(request.getSession(false).getAttribute("nomUsr").toString().getBytes("utf-8"), "iso-8859-1")+"</h1>");%>
<center><p><span class="section-header-blue"><%= prop.getProperty("AlertDocumentEcrase")  %></span></p></center>
<div class="salahddine_welcomeInfoFirstConnexion">

<form action="uploading.do" method="post" name="myform2" enctype="multipart/form-data">
<%
	String piece = request.getAttribute("piece").toString();
	String code = request.getAttribute("code").toString();
	out.println("<table class=\"welcomeConnexion\"><tr><td><center>");
	out.println("<h2><span style=\"text-align: center;\" class=\"section-subheader2\"> "+piece+"</span></h2>");
	out.println("<center><input type=\"file\" name="+new String(piece.replaceAll(" ", "-").getBytes("utf-8"), "iso-8859-1")+"="+code+"><center>");
	out.println("</td></tr></table></center>");
%>

<center><input type="submit" name="Submit" value="<%= prop.getProperty("buttonValider") %>"/ maxlength="10" size="15" class="form-button"></center><br></br><br></br>
</form>
</div>
<center><p><span class="section-header-blue"><a href="modification"><%= prop.getProperty("retour")  %></a><br></span></p></center>
<center><p><span class="section-header-blue"><a href="depot.do"><%= prop.getProperty("retourAccueilDepot")  %></a><br></span></p></center>
<center><p><span class="section-header-blue"><a href="backToEtape"><%= prop.getProperty("retourAccueil")  %></a><br></span></p></center>
<!--  <center><p><span class="section-header-blue"><a href="deconnection.do"><%= prop.getProperty("deconnexion")  %></a></span></p></center> -->
</div>
<%@ include file="menu.jsp" %>
</body>
</html>