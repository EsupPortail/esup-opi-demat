<%@include file="../../_include/_include.jsp"%>
<e:menu id="navigation" styleClass="menuWelcome">
	<e:menuItem id="accueil" action="#{welcomeController.goWelcomeManager}" 
		value="#{msgs['NAVIGATION.TEXT.WELCOME']}"/>
<% /*
	<e:menuItem id="help" value="#{msgs['NAVIGATION.TEXT.HELP']}" />
*/ %>
<e:menuItem value="#{msgs['DEMAT.MENU_CONSULT']}"
                onclick="openPage('#{welcomeController.lienConsultationDossiers}','#{msgs['APPLICATION.BIG_TITLE']}','')"/>
	<e:menuItem id="logout" value="#{msgs['NAVIGATION.TEXT.LOGOUT']}"
		rendered="#{sessionController.isServlet}"
		action="#{sessionController.logoutGest}" />
</e:menu>
