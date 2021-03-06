<%@include file="_include.jsp"%>
<e:menu id="navigation" styleClass="menuWelcome">
	<e:menuItem id="login" action="#{welcomeController.goWelcomeManager}"
		rendered="#{sessionController.isServlet}"
		value="#{msgs['NAVIGATION.TEXT.LOGIN']} #{msgs['GESTIONNAIRES']}"/>
        <e:menuItem value="#{msgs['DEMAT.MENU_CONSULT']}"
                onclick="openPage('#{welcomeController.lienConsultationDossiers}','#{msgs['APPLICATION.BIG_TITLE']}','')"/>
	<e:menuItem id="faq" value="#{msgs['NAVIGATION.TEXT.FAQ']}" 
		onclick="openPage('#{accueilController.context}/stylesheets/help/faq.html','#{msgs['APPLICATION.BIG_TITLE']}','')"/>
	<e:menuItem id="help" value="#{msgs['NAVIGATION.TEXT.CONTACT']}" 
		rendered="#{sessionController.regimeInsUser == null || !sessionController.regimeInsUser.displayInfoFC}" 
		onclick="openPage('#{accueilController.context}/stylesheets/help/contact.html','#{msgs['APPLICATION.BIG_TITLE']}','')"/>
	<e:menuItem value="#{msgs['DEMAT.NAVIGATION.OUTILS']}"
		onclick="openPage('#{accueilController.context}/stylesheets/help/Outils.html','#{msgs['APPLICATION.BIG_TITLE']}','')"/>
</e:menu>
