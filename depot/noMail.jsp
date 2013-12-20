<%@ include file="header.jsp" %>
<%@ include file="menu.jsp" %>

<div id="maPage" class="div_body">
<h1><%= session.getAttribute("nomUsr") %> </h1><br>
<center><p><span class="section-header-blue"><%= prop.getProperty("noMail")  %></span></p></center><br></br>
<center><p><span class="section-header-blue"><a href="recommandation"> <%= prop.getProperty("retourRecommandation")  %> </a></span></p></center>
<center><p><span class="section-header-blue"><a href="backToEtape"><%= prop.getProperty("retourAccueil")  %></a></span></p></center>
</div>
<%@ include file="menu.jsp" %>
</body>
</html>