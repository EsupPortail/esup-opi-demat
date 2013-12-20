<%@ include  file="header.jsp"%>

<div id="maPage" class="div_body">
<center><p><span class="section-header-blue"><%= prop.getProperty("messageErreurClient")  %></span></p></center><br></br>
<center><p><span class="section-header-blue"><a href="index.jsp"><%= prop.getProperty("retourAccueil")  %></a><br></br></span></p></center>
<%
request.getSession(false).invalidate();
%>
</div>
</body>
</html>