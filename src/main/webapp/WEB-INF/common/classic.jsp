<%@ page pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<title><tiles:getAsString name="title" /></title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/mos-style.css"></link>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"></link>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css"></link>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/etalage.css"></link>

</head>
<body>

	<tiles:insertAttribute name="header" />

	<div id="wrapper">
	<tiles:insertAttribute name="menu" />
	
	<tiles:insertAttribute name="body" />

	<tiles:insertAttribute name="footer" />
</div>
</body>
</html>