<%@ page import="java.util.ArrayList" %>

<%@ include  file="header.jsp"%>
<%@ include  file="menu.jsp"%>

<%
ArrayList<String> listIdCmisEnServicePourLeIdUsr = (ArrayList<String>) request.getAttribute("listIdCmisEnServicePourLeIdUsr");
ArrayList<String> listCodeCmis = (ArrayList<String>) request.getAttribute("listCodeCmis");
ArrayList<String> listLibCmis = (ArrayList<String>) request.getAttribute("listLibCmis");
%>


<div id="maPage" class="div_body">
<h1><%= session.getAttribute("dispName") %></h1><br>
<form action="interface" method="post" name="myform3" align="center">
<center><p><span class="section-header-blue"><%= prop.getProperty("titreCommision") %></span></p></center>
	<br/><br/>
	<SELECT name="idCmi">
			<% 
				int i = 0;
				for(String idCmi : listIdCmisEnServicePourLeIdUsr){
					out.println("<OPTION id='"+idCmi+"' VALUE='"+idCmi+"'>"+listLibCmis.get(i)+"</OPTION>");
					i++;
				}
			%>
			<br/>
			<center><input type="submit" name="Submit" value="<%= prop.getProperty("buttonEntrer") %>" maxlength="8" size="10" class="form-button"/></center>
	</SELECT>
</form>
 </div>
 <%@ include  file="menu.jsp"%>
</body>
</html>