<%@ include file="header.jsp" %>
<%@ include file="menu.jsp" %>

<% int nbMailRecommandation = Integer.parseInt(request.getAttribute("nbMailRecommandation").toString()); %>
<div id="maPage" class="div_body">
<h1><%= session.getAttribute("nomUsr") %></h1><br>
<div style="width:100%;text-align:center;">
			<p><span class="section-header-blue"><%= prop.getProperty("deposerMails")  %></span></p>
			<p><span class="section-header-blue"><% out.print( prop.getProperty("encoreMails") + (3-nbMailRecommandation) + " " + prop.getProperty("adresseMails") ); %></span></p>
			<h2><span class="section-header-two-black"></span></h2>
</div>
<div class="salahddine_welcomeInfoFirstConnexion2">
<form action="envoieLiens" method="post" name="myform">

<table class="welcomeConnexion">
	<tr>
		<td>
		<center>
		<p><span class="portlet-section-text">
		<%= prop.getProperty("mail1")  %><input type="text" name="mail1" value="" size="15"/>
		</span></p>
		</center>
		<% 
		//out.print(nbMailRecommandation);
		if(nbMailRecommandation < 2 ){
			out.print("<center><p><span class=\"portlet-section-text\">"+prop.getProperty("mail2")+"<input type=\"text\" name=\"mail2\" value=\"\" size=\"15\"/></span></p></center>");
		}
		if(nbMailRecommandation < 1){
			out.print("<center><p><span class=\"portlet-section-text\">"+prop.getProperty("mail3")+"<input type=\"text\" name=\"mail3\" value=\"\" size=\"15\"/></span></p></center>");
		}
		%>
		<input type="hidden" name="nbMailRecommandation" value="<%= 3-nbMailRecommandation  %>" maxlength="8" size="10" class="form-button"/>
		<br><br><br>
		<center><input type="submit" name="Submit" value="<%= prop.getProperty("envoie")  %>" maxlength="8" size="10" class="form-button"/>
		</center>
		</td>
		
	</tr>
</table>
</form>
<center><p><span class="section-header-blue"><a href="backToEtape"><%= prop.getProperty("retourAccueil")  %></a><br></span></p></center>
<!--  <center><p><span class="section-header-blue"><a href="deconnection.do"><%= prop.getProperty("deconnexion")  %></a></span></p></center> -->
</div>
</div>
<%@ include file="menu.jsp" %>
</body>
</html>