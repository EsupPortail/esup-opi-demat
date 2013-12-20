<%@ include file="header.jsp" %>
<%@ include file="menu.jsp" %>

<div id="maPage" class="div_body">
<center><p><span class="section-header-blue"><%= prop.getProperty("depotFerme")  %></span></p></center> <br></br>

<p><center><h1> <%= request.getAttribute("dateFin") %></h1></center></p>

<center><p><span class="section-header-blue"><a href="backToEtape"><%= prop.getProperty("retourAccueil")  %></a></span><br></br></p></center>
</div>
</body>
<%@ include file="menu.jsp" %>
</html>