<%@ include file="header.jsp" %>
<%@ include file="menu.jsp" %>

<div id="maPage" class="div_body">
<center><p><span class="section-header-blue"><a href="backToEtape"><%= prop.getProperty("depotNonCommence")  %></p></center><br></br>

<p><center><h1><%= request.getAttribute("dateDeb") %></h1></center></p>

<center><p><span class="section-header-blue"><a href="backToEtape"><%= prop.getProperty("retourAccueil")  %></a></span></p></center>
</div>
<%@ include file="menu.jsp" %>
</body>
</html>