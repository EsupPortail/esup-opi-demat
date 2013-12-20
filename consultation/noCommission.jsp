<%@ include  file="header.jsp"%>
<%@ include  file="menu.jsp"%>

<div id="maPage" class="div_body">

<h1><%= session.getAttribute("dispName") %></h1><br>

<center><p><span class="section-header-blue"><%= prop.getProperty("noCommission") %></span></p></center>


<br /><br /><br /><br /><br />
<!-- <center><p><span class="section-header-blue"><a href="<%=  prop.getProperty("casLogOut")  %>"><%=  prop.getProperty("deconnexion")  %></a></span></p></center> -->
<!-- <div class="blockImportant">
	<center><p><span class="section-header-blue"><a href="<%= prop.getProperty("lienCandidature") %>"><%= prop.getProperty("retourCandidature")  %></a></span></p></center>
</div>  -->
 </div>
 <%@ include  file="menu.jsp"%>
</body>
</html>