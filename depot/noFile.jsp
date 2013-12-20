
<%@ include file="header.jsp" %>
<%@ include file="menu.jsp" %>


<div id="maPage" class="div_body">
<br /><br /><br />
<%
out.println("<center><p><span class=\"section-header-blue\">"+prop.getProperty("messageNoFile").toString()+"</span></p></center></br>");
%>
<center><p><span class="section-header-blue"><a href="depot.do"><%= prop.getProperty("retourAccueilDepot")  %></a><br></span></p></center>
<center><p><span class="section-header-blue"><a href="backToEtape"><%= prop.getProperty("retourAccueil")  %></a><br></br></span></p></center>
</div>
<%@ include file="menu.jsp" %>
</body>
</html>