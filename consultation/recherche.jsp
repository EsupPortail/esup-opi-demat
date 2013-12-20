<div  class="blockImportant">
	<br>
	<form action="interface" method="post" name="myformR"  onsubmit='return verifRecherche();'>
		<span class="section-header-blue"> recherche candidat par nom : </span>
<% 
if(rechercheNom.equals("none")) 
	out.println("<input type='text' id='rechercheNom' name='rechercheNom' maxlength='20' placeholder='nom du candidat ...'/>");
else
	out.println("<input type='text' id='rechercheNom' name='rechercheNom' maxlength='20' value='"+ rechercheNom + "'/>");
%>
		
		<input type="submit" id="chercherNom" value="chercher" maxlength="8" size="10" class="form-button"/>
		<input type="hidden" name="idCmi" value="<%= idCmi %>" />
		<input type="hidden" name="libCmi" value="<%= libCmi %>" />
		<input type="hidden" name="numPage" value="<%= numPage %>" />
		<input type='hidden' name='nbEtudiantsParPage' value='<%= nbEtudiantsParPage %>' />
		<input type="hidden" name="filtre" value='<%= filtre %>'>
		<input type="hidden" name="filtreProvenance" value='<%= filtreEtablissement %>'>
		<input type="hidden" name="filtreAvis" value='<%= filtreAvis %>'>
	</form>
	<div id='msgRecherche' style="display:none; color">(la valeur recherchée doit contenir 4 alphabets minimum)</div>
	
	
	<form action="interface" method="post" name="myformR1">
		<span class="section-header-blue"> recherche candidat par numéro de dossier : </span>
		
<% 
if(rechercheNumDossier.equals("none")) 
	out.println("<input type='text' id='rechercheNumDossier' name='rechercheNumDossier' maxlength='20' placeholder='numéro de dossier ...'/>");
else
	out.println("<input type='text' id='rechercheNumDossier' name='rechercheNumDossier' maxlength='20' value='"+ rechercheNumDossier + "'/>");
%>
		<input type="submit" id="chercherNumDossier" value="chercher" maxlength="8" size="10" class="form-button"/>
		<input type="hidden" name="idCmi" value="<%= idCmi %>" />
		<input type="hidden" name="libCmi" value="<%= libCmi %>" />
		<input type="hidden" name="numPage" value="<%= numPage %>" />
		<input type='hidden' name='nbEtudiantsParPage' value='<%= nbEtudiantsParPage %>' />
		<input type="hidden" name="filtre" value='<%= filtre %>'>
		<input type="hidden" name="filtreEtablissement" value='<%= filtreEtablissement %>'>
		<input type="hidden" name="filtreAvis" value='<%= filtreAvis %>'>
	</form>
	
	<br>
</div>
<script language="javascript" type="text/javascript">
function verifRecherche(){
	inputRecherche = document.getElementById('rechercheNom');
	textRecherche = inputRecherche.value;
	if(textRecherche.length < 4 && textRecherche.trim().length != 0) {
		document.getElementById('msgRecherche').style.display = 'block';
		return false;
	} else {
		document.getElementById('msgRecherche').style.display = 'none';
		return true;
	}
}
</script>