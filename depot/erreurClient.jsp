<%@ include file="header.jsp" %>
<%@ include file="menu.jsp" %>

<div id="maPage" class="div_body">
<center><p><span class="section-header-blue"><%= prop.getProperty("messageErreurClient")  %></span></p></center><br></br>
<center><p><span class="section-header-blue"><a href="index.jsp"><%= prop.getProperty("retour")  %></a><br></br></span></p></center>
<%
request.getSession(false).invalidate();
%>
</div>
</body>
</html>