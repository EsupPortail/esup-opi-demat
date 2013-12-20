<%
//nbEtudiants
out.print("<p>"+prop.getProperty("nbEtudiants")+listIdUsrEtudiantSurPage.size()+"</p>");

//numero page
out.print("<p>"+prop.getProperty("page")+numPage+"/"+nbPages+"</p>");
%>
<nobr>
<% 
if (numPage > 1) {
	int newNumPage = numPage - 1;
	out.print("<form style='display: inline;' action='interface' method='post' name='myformA' >");
	out.print("<input type='hidden' name='numPage' value='"+newNumPage+"' />");
	out.print("<input type='hidden' name='libCmi' value='"+libCmi+"' />");
	out.print("<input type='hidden' name='idCmi' value='"+idCmi+"' />");
	out.print("<input type='hidden' name='filtre' value='"+filtre+"' />");
	out.print("<input type='hidden' name='filtreEtablissement' value='"+filtreEtablissement+"' />");
	out.print("<input type='hidden' name='filtreAvis' value='"+filtreAvis+"' />");
	out.print("<input type='hidden' name='nbEtudiantsParPage' value='"+nbEtudiantsParPage+"' />");
	out.print("<input type='hidden' name='rechercheNom' value='" +  rechercheNom +"' />");
	out.print("<input type='hidden' name='rechercheNumDossier' value='" +  rechercheNumDossier +"' />");
	out.print("<input type='submit' value='Precedent' maxlength='8' size='10' class='form-button' />");
	out.print("</form>");
}

for (int i = 1; i <= nbPages; i++) {
	out.print("<form style='display: inline;' action='interface' method='post' name='myform"+i+"' >");
	out.print("<input type='hidden' name='numPage' value='"+i+"' />");
	out.print("<input type='hidden' name='libCmi' value='"+libCmi+"' />");
	out.print("<input type='hidden' name='idCmi' value='"+idCmi+"' />");
	out.print("<input type='hidden' name='filtre' value='"+filtre+"' />");
	out.print("<input type='hidden' name='filtreEtablissement' value='"+filtreEtablissement+"' />");
	out.print("<input type='hidden' name='filtreAvis' value='"+filtreAvis+"' />");
	out.print("<input type='hidden' name='nbEtudiantsParPage' value='"+nbEtudiantsParPage+"' />");
	out.print("<input type='hidden' name='rechercheNom' value='" +  rechercheNom +"' />");
	out.print("<input type='hidden' name='rechercheNumDossier' value='" +  rechercheNumDossier +"' />");
	out.print("<input type='submit' value='"+i+"' maxlength='8' size='10' class='form-button' />");
	out.print("</form>");
}

if (numPage != nbPages ) {
	int newNumPage = numPage + 1;
	out.print("<form style='display: inline;' action='interface' method='post' name='myformB' >");
	out.print("<input type='hidden' name='numPage' value='"+newNumPage+"' />");
	out.print("<input type='hidden' name='libCmi' value='"+libCmi+"' />");
	out.print("<input type='hidden' name='idCmi' value='"+idCmi+"' />");
	out.print("<input type='hidden' name='filtre' value='"+filtre+"' />");
	out.print("<input type='hidden' name='filtreEtablissement' value='"+filtreEtablissement+"' />");
	out.print("<input type='hidden' name='filtreAvis' value='"+filtreAvis+"' />");
	out.print("<input type='hidden' name='nbEtudiantsParPage' value='"+nbEtudiantsParPage+"' />");
	out.print("<input type='hidden' name='rechercheNom' value='" +  rechercheNom +"' />");
	out.print("<input type='hidden' name='rechercheNumDossier' value='" +  rechercheNumDossier +"' />");
	out.print("<input type='submit' value='Suivant' maxlength='8' size='10' class='form-button' />");
	out.print("</form>");
}
%>
<FORM style='display: inline;' action='interface' method='post' name='myformC' >
	<span class="section-header-blue">Etudiants par page : </span>
	<SELECT name="nbEtudiantsParPage" onChange="go(this)" >
			<OPTION id="1" VALUE="1" >1</OPTION>
			<OPTION id="25" VALUE="25" >25</OPTION>
			<OPTION id="50" VALUE="50" >50</OPTION>
		    <OPTION id="100" VALUE="100" >100</OPTION>
	</SELECT>
	<input type="hidden" name="idCmi" value="<%= idCmi %>" ></input>
	<input type="hidden" name="libCmi" value="<%= libCmi %>" ></input>
	<input type="hidden" name="filtre" value="<%= filtre %>" ></input>
	<input type="hidden" name="filtreEtablissement" value="<%= filtreEtablissement %>" ></input>
	<input type="hidden" name="filtreAvis" value="<%= filtreAvis %>" ></input>
	<input type="hidden" name="numPage" value="1" />
	<input type="hidden" name="rechercheNom" value="<%= rechercheNom %>" />
	<input type="hidden" name="rechercheNumDossier" value="<%= rechercheNumDossier %>" />
</FORM>
</nobr>