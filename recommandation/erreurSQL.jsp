<%@ include file="header.jsp" %>

<div id="maPage" class="div_body">
<center><p><span class="section-header-blue"><%= prop.getProperty("messageErreurSql")  %></span></p></center><br></br>
<center><p><span class="section-header-blue"><%= prop.getProperty("solutionErreurSql")  %></span></p></center><br></br>
<center><p><span class="section-header-blue"><a href="accueilReferent.jsp"><%= prop.getProperty("retourAccueil")  %></a></span></p></center>
<%
request.getSession(false).invalidate();
%>
</div>
</body>
</html>