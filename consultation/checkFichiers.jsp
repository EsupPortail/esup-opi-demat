<button class="form-button" onclick="javascript:afficher_cacher('fileFiltre');" ><%= prop.getProperty("filtreFiles") %></button>
<div  id="fileFiltre" style="visibility: hidden; height: 0;" class="blockImportant">
	<br>
	<h3><%=  prop.getProperty("fichiersAAfficher")  %></h3>
	<form name="myform" action="fichiersAAffiche" method="POST">
		<table border="1">
		<%
		int ordreFile = 0;
		for (String s : listCodeNomPc) {
			if(ordreFile % 2 == 0)
				out.print("<tr>");
			out.print("<td>");
			String libNom = listLibNomPc.get(listCodeNomPc.indexOf(s));
			String licNom = MapLibNomsPcLicNomsPc.get(libNom);
			if(listFichiersAAffiche!=null && !listFichiersAAffiche.contains(s)) {
				out.print("<input type='checkbox' name='fichier' value='"+s+"'>"+"<nobr>"+libNom+" ("+licNom+")</nobr>");
			} else {
				out.print("<input type='checkbox' name='fichier' value='"+s+"' checked='true'>"+"<nobr>"+libNom+" ("+licNom+")</nobr>");
			}
			out.print("</td>");
			if(ordreFile % 2 == 1) 
				out.print("</tr>");
			ordreFile++;
		}
		for(String s : listCodeNomPs){
				if(ordreFile % 2 == 0)
					out.print("<tr>");
				out.print("<td>");
				String libNom = listLibNomPs.get(listCodeNomPs.indexOf(s)) ;
				String licNom =  MapLibNomsPsLicNomsPs.get(libNom);
				
				if(listFichiersAAffiche!=null && !listFichiersAAffiche.contains(s)) {
					out.print("<input type='checkbox' name='fichier' value='"+s+"'>"+"<nobr>"+libNom+" ("+licNom+")</nobr>");
				} else {
					out.print("<input type='checkbox' name='fichier' value='"+s+"' checked='true'>"+"<nobr>"+libNom+" ("+licNom+")</nobr>");
				}
				out.print("</td>");
				if(ordreFile % 2 == 1) 
					out.print("</tr>");
				ordreFile++;
		}
		%>
		</table>
		<br><br>
		<input type="hidden" name="idCmi" value="<%= idCmi %>" ></input>
		<input type="hidden" name="libCmi" value="<%= libCmi %>" ></input>
		<input type="hidden" name="filtre" value="<%= filtre %>" ></input>
		<input type="hidden" name="filtreEtablissement" value="<%= filtreEtablissement %>" ></input>
		<input type="hidden" name="filtreAvis" value="<%= filtreAvis %>" ></input>
		<input type="hidden" name="numPage" value="<%= numPage %>" />
		<input type='hidden' name='nbEtudiantsParPage' value='<%= nbEtudiantsParPage %>' />
		<input type="hidden" name="rechercheNom" value="<%= rechercheNom %>" />
		<input type="hidden" name="rechercheNumDossier" value="<%= rechercheNumDossier %>" />
		<input type="submit" value="afficher" maxlength='8' size='10' class='form-button'/>
	</form>
	<br>
</div>
<script language="javascript" type="text/javascript">
function afficher_cacher(id)
{
        if(document.getElementById(id).style.visibility=="hidden")
        {
                document.getElementById(id).style.visibility="visible";
                document.getElementById(id).style.height = "auto";
        } else {
        		document.getElementById(id).style.visibility="hidden";
            	document.getElementById(id).style.height = "0";
        }
        return true;
}
</script>