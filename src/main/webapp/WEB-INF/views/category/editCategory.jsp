<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="com.springboot.vo.CategoryVo"%>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/mos-style.css"></link>


<div id="rightContent" style="height: 400px;">
	<h3 style="color: goldenrod; font-size: 32px; font-weight: bold">Sửa
		thông tin danh mục</h3>
	<br />

	<div class="msg">${msg}</div>
	<form:form modelAttribute="categoryVo"
		action="${pageContext.request.contextPath}/category/edit" method = "POST">
		<table width="95%" style="margin-left: 200px">

			<tr>
				<td width="125px"><b>Mã danh mục</b></td>
				<td>
					<form:input type="text" path="id" readonly="true"/>
					<div style="color: red; font-style: italic;">
						<form:errors path="id" cssClass="error" />
					</div>
					<br>

				</td>



			</tr>


			<tr>
				<td width="125px"><b>Tên danh mục</b></td>
				<td><form:input type="text" path="name" />
					<div style="color: red; font-style: italic;">
						<form:errors path="name" cssClass="error" />
					</div>
					<br></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" class="button" value="Sửa danh mục">
				</td>
			</tr>


		</table>
	</form:form>

</div>
