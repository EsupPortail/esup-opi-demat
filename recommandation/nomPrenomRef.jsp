<%@ include file="header.jsp" %>
<%@ include file="menu.jsp" %>

<div id="maPage" class="div_body">


	<form action="validationNomPrenom" method="post" name="myform">
	<tr>
		<td>
		
		<p><span class="section-header-blue"><%= prop.getProperty("demandeNomPrenom") %></span></p><br>
		
		<p><span class="portlet-section-text"><label for="nomRef"><%= prop.getProperty("nom")  %></label><input type="text" name="nomRef" /></span></p>
		
		<p><span class="portlet-section-text"><label for="prenomRef"><%= prop.getProperty("prenom") %></label><input type="text" name="prenomRef" /></span></p>
		
		
		
		<p><span class="portlet-section-text"><label for="titreRef"> titre : </label><input type="text" name="titreRef" /></span></p>
		
		<p><span class="portlet-section-text"><label for="fonctionRef"> organisme : </label><input type="text" name="fonctionRef" /></span></p>
		
		
		<br>
		<center>
			<input type="submit" name="Submit" value="<%= prop.getProperty("buttonValider") %>" maxlength="8" size="10" class="form-button"/>
		</center>
		</td>
	</tr>
	</forme>
	<br><br><br>

<br></br>
<!-- <center><p><span class="section-header-blue"><a href="deconnection"><%out.print( prop.getProperty("deconnexion") ); %></a><br></br></span></p></center> -->
</div>
<%@ include file="menu.jsp" %>
</body>
</html>