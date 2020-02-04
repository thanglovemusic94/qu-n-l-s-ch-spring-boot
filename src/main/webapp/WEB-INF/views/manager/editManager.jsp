<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="com.springboot.vo.ManagerVo"%>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/mos-style.css"></link>


<div id="rightContent" style="height: 600px;">
	<h3 style="color: goldenrod; font-size: 32px; font-weight: bold">Sửa
		thông tin quản lý</h3>
	<br />

	<div class="msg">${msg}</div>
	<form:form modelAttribute="managerVo"
		action="${pageContext.request.contextPath}/manager/edit" method = "POST">
		<table width="95%" style="margin-left: 200px">

			<tr>
				<td width="125px"><b>Mã tài khoản</b></td>
				<td>
					<form:input type="text" path="id" readonly="true"/>
					<div style="color: red; font-style: italic;">
						<form:errors path="id" cssClass="error" />
					</div>
					<br>

				</td>
			</tr>


			<tr>
				<td width="125px"><b>Mật khẩu</b></td>
				<td><form:input type="text" path="pass" />
					<div style="color: red; font-style: italic;">
						<form:errors path="pass" cssClass="error" />
					</div>
					<br></td>
			</tr>
			
			<tr>
				<td width="125px"><b>Tên quản lý</b></td>
				<td><form:input type="text" path="ten" />
					<div style="color: red; font-style: italic;">
						<form:errors path="ten" cssClass="error" />
					</div>
					<br></td>
			</tr>
			
			<tr>
				<td width="125px"><b>Năm sinh</b></td>
				<td><form:input type="text" path="namsinh" />
					<div style="color: red; font-style: italic;">
						<form:errors path="namsinh" cssClass="error" />
					</div>
					<br></td>
			</tr>
			
			<tr>
				<td width="125px"><b>Email</b></td>
				<td><form:input type="text" path="email" />
					<div style="color: red; font-style: italic;">
						<form:errors path="email" cssClass="error" />
					</div>
					<br></td>
			</tr>
			
			<tr>
				<td width="125px"><b>Số điện thoại</b></td>
				<td><form:input type="text" path="sdt" />
					<div style="color: red; font-style: italic;">
						<form:errors path="sdt" cssClass="error" />
					</div>
					<br></td>
			</tr>
			
			<tr>
				<td width="125px"><b>Địa chỉ</b></td>
				<td><form:input type="text" path="diachi" />
					<div style="color: red; font-style: italic;">
						<form:errors path="diachi" cssClass="error" />
					</div>
					<br></td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="submit" class="button" value="Sửa quản lý">
				</td>
			</tr>


		</table>
	</form:form>

</div>
