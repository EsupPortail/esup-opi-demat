<%@ include file="header.jsp" %>
<%@ include file="menu.jsp" %>

<div id="maPage" class="div_body">
<%
String nomRef = session.getAttribute("nomRef").toString();
String prenomRef = session.getAttribute("prenomRef").toString();
String msg = request.getAttribute("msg").toString();
out.print("<h1>"+nomRef+" "+prenomRef+"</h1>");
%>
<div style="width:100%;text-align:center;">
</div>
			<center>
			<p><span class="section-header-blue"><%= msg  %></span></p>
			</center><br></br>
			
			<center>
			<p><span class="section-header-blue"><a href="listCandidat"><%= prop.getProperty("retourCandidats")  %></a><br></br></span></p>
			</center>
			
			<center>
			<p><span class="section-header-blue"><a href="etudiant"><%= prop.getProperty("retourDepot")  %></a><br></br></span></p>
			</center><br></br>
</div>
<%@ include file="menu.jsp" %>
</body>
</html>