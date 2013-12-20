<%@ include file="header.jsp" %>
<%@ include file="menuAccueil.jsp" %>

<div id="maPage" class="div_body">
<div style="width:100%;text-align:center;">
			<p><span class="section-header-blue"><%= prop.getProperty("bienvenue")  %></span></p>
			<p><span class="section-header-blue"><%= prop.getProperty("titre")  %></span></p>
			<h2><span class="section-header-two-black"></span></h2>
</div>

<ul>
<div id ="validation" style="display: none; "><li/>le numero de dossier et la date de naissance sont obligatoire</div>
</ul>

<div class="salahddine_welcomeInfoFirstConnexion">
<form action="Etape.do" method="post" name="myform" onsubmit='return Verif();'>

<table class="welcomeConnexion">
	<tr>
		<td>
		<center>
		<h2><span style="text-align: center;" class="section-subheader"><%= prop.getProperty("titreLogin")  %></span></h2>
		</center>
		
		
		<center>
		<p><span class="portlet-section-text"><%= prop.getProperty("numDossier")  %><input type="password" id="numDossier" name="numDossier" onblur='verifPseudo(this)'/></span></p>
		</center>
		
		
		<center>
		<p><span class="portlet-section-text"><%= prop.getProperty("dateNaissance")  %><input type="text" id="dateNaissance" name="dateNaissance" value="" onblur='verifPseudo(this)'/></span></p>
		</center>
		
		<br></br>
		<center><input type="submit" name="Submit" value="<%= prop.getProperty("buttonConnexion")  %>" maxlength="8" size="10" class="form-button"/>
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
	if (document.getElementById("numDossier").value.length != 0 && document.getElementById("dateNaissance").value.length != 0 ){
		document.form1.submit();
		return true;
	} else {
		div = document.getElementById("validation");
	    div.style.display = "block";
		return false;
	} 
}
</script>