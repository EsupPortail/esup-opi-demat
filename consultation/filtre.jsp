
<div  class="blockImportant">
	<br>
	
	<form action="etablissementAAffiche" method="post" name="myform2" >
		<span class="section-header-blue"><%= prop.getProperty("etab") %></span>
		<SELECT name="filtreEtablissement" onChange="go(this)" style='text-transform:capitalize;'>
			<OPTION id="TouteEtablissement" VALUE="Tout" >Tout</OPTION>
			<% 
			for(String codeEtab : listCodeEtab){
				out.println("<OPTION id='"+codeEtab+"' VALUE='"+codeEtab+"'>"+MapCodeEtabLibEtab.get(codeEtab)+"</OPTION>");
			}
			%>
		</SELECT>
		<input type="hidden" name="idCmi" value="<%= idCmi %>" />
		<input type="hidden" name="libCmi" value="<%= libCmi %>" />
		<input type="hidden" name="numPage" value="<%= numPage %>" />
		<input type='hidden' name='nbEtudiantsParPage' value='<%= nbEtudiantsParPage %>' />
		<input type="hidden" name="rechercheNom" value="<%= rechercheNom %>" />
		<input type="hidden" name="filtre" value="<%= filtre %>" ></input>
		<input type="hidden" name="filtreAvis" value="<%= filtreAvis %>" ></input>
		<input type="hidden" name="rechercheNumDossier" value="<%= rechercheNumDossier %>" />
	</form>
	
	<form action="interface" method="post" name="myform1" >
		<span class="section-header-blue"><%= prop.getProperty("typeTraitement") %></span>
		<SELECT name="filtre" onChange="go(this)" >
			<OPTION id="ToutTraitement" VALUE="Tout" >Tout</OPTION>
			<OPTION id="STATE.TRAITE" VALUE="STATE.TRAITE" ><%= prop.getProperty("traite") %></OPTION>
			<OPTION id="STATE.NON_TRAITE" VALUE="STATE.NON_TRAITE" ><%= prop.getProperty("nonTraite") %></OPTION> 
<!--		<OPTION id="STATE.EN_COURS_TRAITEMENT" VALUE="STATE.EN_COURS_TRAITEMENT" >En cours de traitement</OPTION>  -->
		</SELECT>
<!--  	<span class="section-header-blue"><%= prop.getProperty("origine") %></span>
		<SELECT name="filtreProvenance" onChange="go(this)" >
			<OPTION id="TouteProvenance" VALUE="Tout" >Tout</OPTION>
			<OPTION id="<%= prop.getProperty("dauphine") %>" VALUE="<%= prop.getProperty("dauphine") %>" ><%= prop.getProperty("dauphine") %></OPTION>
			<OPTION id="<%= prop.getProperty("france") %>" VALUE="<%= prop.getProperty("france") %>" ><%= prop.getProperty("france") %></OPTION>
			<OPTION id="<%= prop.getProperty("etranger") %>" VALUE="<%= prop.getProperty("etranger") %>" ><%= prop.getProperty("etranger") %></OPTION>
		</SELECT>
-->
		
		<span class="section-header-blue"><%= prop.getProperty("avis") %></span>
		<SELECT name="filtreAvis" onChange="go(this)" >
			<OPTION id="TouteAvis" VALUE="Tout" >Tout</OPTION>
			<OPTION id="<%= prop.getProperty("sansAvis") %>" VALUE="<%= prop.getProperty("sansAvis") %>" ><%= prop.getProperty("sansAvis") %></OPTION>
			<% 
			for(String avis : listLicNomAvis){
				out.println("<OPTION id='"+avis+"' VALUE='"+avis+"'>"+avis+"</OPTION>");
			}
			%>
		</SELECT>
		<input type="hidden" name="idCmi" value="<%= idCmi %>" />
		<input type="hidden" name="libCmi" value="<%= libCmi %>" />
		<input type="hidden" name="numPage" value="<%= numPage %>" />
		<input type="hidden" name="filtreEtablissement" value="<%= filtreEtablissement %>" ></input>
		<input type='hidden' name='nbEtudiantsParPage' value='<%= nbEtudiantsParPage %>' />
		<input type="hidden" name="rechercheNom" value="<%= rechercheNom %>" />
		<input type="hidden" name="rechercheNumDossier" value="<%= rechercheNumDossier %>" />
	</form>
	
	
	<br>
</div>
