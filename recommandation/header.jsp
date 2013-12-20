<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.Properties, java.io.File" %>
<%
Properties prop = com.lr_mvc.tools.LoadProperties.load(getServletContext().getRealPath("/")+"/WEB-INF/classes/Message_fr.properties");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%= application.getInitParameter("titre") %></title>
<link rel="stylesheet" type="text/css"
	href="./media/style/SABERKAN.css" />
</head>


<body class="portlet-section-body esup-opiR1">
<div id="header" class="header">
<div class="logo"></div>
<div class="header_suite">
<div id="titreAppli" class="titreAppli"><span
	class="span_bigTitre"><%= prop.getProperty("candidatures")  %></span> <br/>
<span class="span_titre"><%= prop.getProperty("operation")  %></span></div>


<div class="user_displayName"><span class="span_currentUser"></span>
</div>
<div class="version"><span class="span_version"></span></div>
</div>
</div>