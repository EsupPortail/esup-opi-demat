<%@ include  file="header.jsp"%>
<%@ taglib prefix="cas" uri="http://www.yale.edu/its/tp/castools" %>
<cas:logout  id="logout" scope="session"/>

<div id="maPage" class="div_body">
<center><p><span class="section-header-blue"><%=  prop.getProperty("messageDeconnexion")  %></span></p></center>
<center><p><span class="section-header-blue"><a href="index.jsp"><%=  prop.getProperty("retourAccueil")  %></a></span></p></center>
</div>
</body>
</html>