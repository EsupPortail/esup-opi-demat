<%@ include file="header.jsp" %>
<%@ include file="menuAccueil.jsp" %>

<div id="maPage" class="div_body">
<div style="width:100%;text-align:center;">
			<p><span class="section-header-blue"><%= prop.getProperty("bienvenueRecommandation") %></span></p>
			<p><span class="section-header-blue"><%= prop.getProperty("titreRecommandation") %></span></p>
			<h2><span class="section-header-two-black"></span></h2>
</div>

<ul>
<div id ="validation" style="display: none; "><li/>le mail et le mot de passe sont obligatoire</div>
</ul>

<div class="salahddine_welcomeInfoFirstConnexion">
<form action="loginReferent" method="post" name="myform" onsubmit='return Verif();'>
<table class="welcomeConnexion">
	<tr>
		<td>
		<center>
		<h2><span style="text-align: center;" class="section-subheader"><%= prop.getProperty("titreLogin")  %></span></h2>
		</center>
		
		<center>
		<p><span class="portlet-section-text"><%= prop.getProperty("adresseMail")  %><input type="text" id="adresseMail" name="adresseMail" onblur='verifPseudo(this)'/></span></p>
		</center>
		
		
		<center>
		<p><span class="portlet-section-text"><%= prop.getProperty("password")  %><input type="password" id="password" name="password" value="" onblur='verifPseudo(this)'/></span></p>
		</center>
		
		<br>
		<center>
			<input type="submit" name="Submit" value="<%= prop.getProperty("buttonConnexion")  %>" maxlength="8" size="10" class="form-button"/><br>
			<!--  <a href='MDPOublie.jsp' ><%= prop.getProperty("MDPOublie")  %></a> -->
		</center>
		</td>
		
		
	</tr>
</table>
</form>

</div>
</div>
<%@ include file="menuAccueil.jsp" %>
</body>
</html>
<script language="javascript" type="text/javascript">
function surligne(champ, erreur)
{
   if(erreur) {
      champ.style.backgroundColor = "#fba";
   } else {
      champ.style.backgroundColor = "";
   }
}
function verifPseudo(champ)
{
   if(champ.value.length == 0)
   {
      surligne(champ, true);
      return false;
   }
   else
   {
      surligne(champ, false);
      return true;
   }
}
function Verif() {
	if (document.getElementById("adresseMail").value.length != 0 && document.getElementById("password").value.length != 0 ){
		document.form1.submit();
		return true;
	} else {
		div = document.getElementById("validation");
	    div.style.display = "block";
		return false;
	} 
}
</script>