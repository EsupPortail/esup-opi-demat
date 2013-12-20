<%@ include file="header.jsp" %>
<%@ include file="menu.jsp" %>

<div id="maPage" class="div_body">
<center><p><span class="section-header-blue"><%= prop.getProperty("messageErreurNomPrenom")  %></span></p></center><br></br>
<center><p><span class="section-header-blue"><a href="nomPrenomRef"><%= prop.getProperty("retourCandidats")  %></a><br></br></span></p></center>
</div>
<%@ include file="menu.jsp" %>
</body>
</html>