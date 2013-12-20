<%@ taglib prefix="cas" uri="http://www.yale.edu/its/tp/castools" %>
<cas:auth id="user" scope="session"/>
<html>
<body onload="submitform()">
redirection <%=session.getAttribute("user")%> !!!<br>
<form id="myForm" method=POST action="login">
	<input type="hidden" name="nom" value="<%=session.getAttribute("user")%>"/>
</form>
</body>
</html>
<script type="text/javascript" language="javascript">
function submitform(){
	document.getElementById('myForm').submit();
}
</script>
