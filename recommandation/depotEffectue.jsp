<%@ include file="header.jsp" %>
<%@ include file="menu.jsp" %>

<div id="maPage" class="div_body">
<%
String nomRef = session.getAttribute("nomRef").toString();
String prenomRef = session.getAttribute("prenomRef").toString();
out.print("<h1>"+nomRef+" "+prenomRef+"</h1>");
%>
<div style="width:100%;text-align:center;">
</div>
			<center>
			<p><span class="section-header-blue"><%= prop.getProperty("messageDepotEffectue") %> <%= request.getAttribute("nomUsr") %></span></p>

			</center><br></br>
			
			<center>
			<p><span class="section-header-blue"><a href="listCandidat"><%= prop.getProperty("retourCandidats")  %></a><br></br></span></p>
			</center><br></br>
</div>
<%@ include file="menu.jsp" %>
</body>
</html>