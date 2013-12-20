<%@ include  file="header.jsp"%>

<div id="maPage" class="div_body">
<center><p><span class="section-header-blue"><%= prop.getProperty("messageErreurAcces")  %></span></p></center>
<center><p><span class="section-header-blue"><%= prop.getProperty("messageErreurAccesCas1")  %></center></p>
<center><p><span class="section-header-blue"><%= prop.getProperty("messageErreurAccesCas2")  %></center></p><br></br>
<center><p><span class="section-header-blue"><a href="index.jsp"><%= prop.getProperty("retourAccueil")  %></a></span></p></center>
<%
request.getSession(false).invalidate();
%>
</div>
</body>
</html>