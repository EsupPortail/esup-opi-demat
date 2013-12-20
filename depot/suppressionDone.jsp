<%@ include file="header.jsp" %>
<%@ include file="menu.jsp" %>

<div id="maPage" class="div_body">

<h1><%= request.getSession(false).getAttribute("nomUsr") %></h1>
<center><p><span class="section-header-blue"><%= request.getAttribute("nomFichier") %>  <%= prop.getProperty("messageEstSupprime") %></span></p></center>
<br></br>
<center><p><span class="section-header-blue"><a href="modification"><%= prop.getProperty("retour")  %></a><br></span></p></center>
<center><p><span class="section-header-blue"><a href="depot.do"><%= prop.getProperty("retourAccueilDepot")  %></a><br></span></p></center>
<center><p><span class="section-header-blue"><a href="backToEtape"><%= prop.getProperty("retourAccueil")  %></a><br></br></span></p></center>	
</div>
<%@ include file="menu.jsp" %>
</body>
</html>