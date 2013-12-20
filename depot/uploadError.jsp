
<%@ include file="header.jsp" %>
<%@ include file="menu.jsp" %>
<%@ page import="java.util.ArrayList, java.util.Map, java.util.TreeMap, java.io.File, java.util.Properties" %>


<div id="maPage" class="div_body">
<br /><br /><br />
<%
ArrayList<String> listFileErrorType = (ArrayList<String>) request.getAttribute("listFileErrorType");
ArrayList<String> listFileErrorTailleMax = (ArrayList<String>) request.getAttribute("listFileErrorTailleMax");
ArrayList<String> listFileErrorTailleMin = (ArrayList<String>) request.getAttribute("listFileErrorTailleMin");
String fileSizeMax =  request.getAttribute("fileSizeMax").toString();

for(String fType : listFileErrorType) {
	out.print(" <center><p><span class=\"section-header-blue\">le type de "
            + fType
            + " " + prop.getProperty("typeFichier") +"</span></p></center><br></br>");
}

for(String fTaille : listFileErrorTailleMax) {
	out.print("<center><p><span class=\"section-header-blue\"> la taille du fichier "
			+ fTaille + " est sup &agrave; "
			+ fileSizeMax + " octets</span></p></center><br></br>");
}

for(String fTaille : listFileErrorTailleMin) {
	out.print("<center><p><span class=\"section-header-blue\"> le fichier "
			+ fTaille + " est corrompu</span></p></center><br></br>");
}
%>
<center><p><span class="section-header-blue"> <a href="javascript:history.back(-1)">retour</a> <br></br></span></p></center><br></br>
</div>
<%@ include file="menu.jsp" %>
</body>
</html>