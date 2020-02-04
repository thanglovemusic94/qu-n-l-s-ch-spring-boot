<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="com.springboot.vo.ManagerVo"%>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/mos-style.css"></link>


<div id="rightContent" style="height: 600px;">
	<h3 style="color: goldenrod; font-size: 32px; font-weight: bold">Thông
		tin quản lý</h3>
	<br />



	<div class="msg">${msg}</div>

	<form:form modelAttribute="managerVo"
		action="${pageContext.request.contextPath}/manager/create"
		method="POST">
		<table width="95%" style="margin-left: 200px">
			<br />
			<br />

			<tr>
				<td width="125px"><b>Mã tài khoản</b></td>
				<td>
					<div style="color: blue; font-weight: bold; font-style: italic;">*Chú
						ý: Mã tài khoản là tài khoản cá nhân của từng manager và không được trùng</div>
					<br> <form:input type="text" path="id"
						placeholder="Nhập mã danh mục..." />
					<div style="color: red; font-style: italic;">
						<form:errors path="id" cssClass="error" />
					</div>
					

				</td>



			</tr>
			<tr>
				<td width="125px"><b>Mật khẩu</b></td>
				<td><form:input type="text" path="pass"
						placeholder="Nhập mật khẩu..." />
					<div style="color: red; font-style: italic;">
						<form:errors path="pass" cssClass="error" />
					</div>
					</td>
			</tr>
			
			<tr>
				<td width="125px"><b>Tên quản lý</b></td>
				<td><form:input type="text" path="ten"
						placeholder="Nhập tên quản lý..." />
					<div style="color: red; font-style: italic;">
						<form:errors path="ten" cssClass="error" />
					</div>
					</td>
			</tr>
			
			<tr>
				<td width="125px"><b>Năm sinh</b></td>
				<td><form:input type="text" path="namsinh"
						placeholder="Nhập năm sinh..." />
					<div style="color: red; font-style: italic;">
						<form:errors path="namsinh" cssClass="error" />
					</div>
					</td>
			</tr>

			<tr>
				<td width="125px"><b>Email</b></td>
				<td><form:input type="text" path="email"
						placeholder="Nhập email..." />
					<div style="color: red; font-style: italic;">
						<form:errors path="email" cssClass="error" />
					</div>
					</td>
			</tr>
			
			<tr>
				<td width="125px"><b>Số điện thoại</b></td>
				<td><form:input type="text" path="sdt"
						placeholder="Nhập số điện thoại..." />
					<div style="color: red; font-style: italic;">
						<form:errors path="sdt" cssClass="error" />
					</div>
					
			</tr>
			
			<tr>
				<td width="125px"><b>Địa chỉ</b></td>
				<td><form:input type="text" path="diachi"
						placeholder="Nhập địa chỉ..." />
					<div style="color: red; font-style: italic;">
						<form:errors path="diachi" cssClass="error" />
					</div>
					</td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="submit" class="button" value="Tạo quản lý">
				</td>
			</tr>


		</table>
	</form:form>

</div>

