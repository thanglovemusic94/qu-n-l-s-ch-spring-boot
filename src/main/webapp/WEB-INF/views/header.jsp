<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/mos-style.css"></link>
<div id="header">
	<div class="inHeader">
	<img src="${pageContext.request.contextPath}/images/sach.png" class="inHeader1" style="margin-left: -600px;margin-top: -13px"/>
		<div class="mosAdmin">
		<form:form action ="${pageContext.request.contextPath}/admin/" method="POST" modelAttribute="user">
		Xin chào, Administration<br>
		<a href="">Trợ giúp</a> | <a href="${pageContext.request.contextPath}/login">Đăng xuất</a>
		</form:form>
		</div>
	<div class="clear"></div>
	</div>
</div>
