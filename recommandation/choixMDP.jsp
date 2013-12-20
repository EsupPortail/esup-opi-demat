<%@ include file="header.jsp" %>

<div id="maPage" class="div_body">
<div style="width:100%;text-align:center;">
			<p><span class="section-header-blue">Choix de mot de passe</span></p>
			<h2><span class="section-header-two-black"></span></h2>
</div>

<ul>
<div id ="validation1" style="display: none; "><li/>le mot de passe doit contenir aumoins 4 caracteres</div>
</ul>

<ul>
<div id ="validation2" style="display: none; "><li/>les deux mots de passes doivent etre identiques </div>
</ul>


<div class="salahddine_welcomeInfoFirstConnexion">
<form action="enregistrementMDP" method="post" name="myform" onsubmit='return Verif();'>
<table class="welcomeConnexion">
	<tr>
		<td>
		
		<center>
		<p><span class="portlet-section-text"><%= prop.getProperty("choixMDP")  %><input type="password" id="password1" name="password1" onblur='verifPseudo(this)'/></span></p>
		</center>
		
		<center>
		<p><span class="portlet-section-text"><%= prop.getProperty("reSaisiMDP")  %><input type="password" id="password2" name="password2" onblur='verifPseudo(this)'/></span></p>
		</center>
		
		<br>
		<center><input type="submit" name="Submit" value="<%= prop.getProperty("buttonConnexion")  %>" maxlength="8" size="10" class="form-button"/>
		</center>
		</td>
	</tr>
</table>
</form>
</div>
</div>
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
	div = document.getElementById("validation1");
	div.style.display = "none";
	div = document.getElementById("validation2");
	div.style.display = "none";
	if (document.getElementById("password1").value.length >= 4 && document.getElementById("password2").value.length >= 4 ){
		if(document.getElementById("password1").value == document.getElementById("password2").value) {
			document.form1.submit();
			return true;
		} else {
			div = document.getElementById("validation2");
		    div.style.display = "block";
		}
	} else {
		div = document.getElementById("validation1");
	    div.style.display = "block";
	} 
	return false;

	
}
</script>