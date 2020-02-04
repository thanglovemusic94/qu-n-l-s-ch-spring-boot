<%@ page 
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="com.springboot.vo.BookVo" %>

<div id="rightContent" >
                    <h3 style="color: goldenrod; font-size: 32px; font-weight: bold">Thêm sách</h3>
                    <br/>
					<div style="color: red; font-style: italic;">${msg}</div>
                    <form:form modelAttribute="bookVo" action="${pageContext.request.contextPath}/book/create" method="POST" enctype="multipart/form-data">
                   
                    <table width="95%" style="margin-left: 130px">
                        <tr><td width="125px"><b>Tên sách</b></td><td>
                        <form:input type="text" class="sedang" path="name" placeholder="Nhập tên sách..."/><div style="color: red; font-style: italic;"><form:errors path="name" cssClass="error"/></div></td></tr>
                       
                        
                        <tr><td><b>Ảnh</b></td><td>
                        <form:input type="file" class="sedang" path="img"/></td></tr>
                        
                        
                        <tr><td><b>Tác giả</b></td><td>
                        <form:input type="text" class="sedang" path="tacgia" placeholder="Nhập tên tác giả..."/><div style="color: red; font-style: italic;"><form:errors path="tacgia" cssClass="error"/></div></td></tr>
                        
                        
                        <tr><td><b>Thể loại</b></td><td>
                        <form:input type="text" class="sedang" path="theloai" placeholder="Nhập tên thể loại..."/><div style="color: red; font-style: italic;"><form:errors path="theloai" cssClass="error"/></div></td></tr>
                        
                        
                        <tr><td><b>Nhà xuất bản</b></td><td>
                        <form:input type="text" class="sedang" path="nxb" placeholder="Nhập tên nhà xuất bản..."/><div style="color: red; font-style: italic;"><form:errors path="nxb" cssClass="error"/></div></td></tr>
                        
                        
                        <tr><td><b>Ngày cập nhật</b></td><td>
                        <form:input type="text" class="sedang" path="ngay" placeholder="Nhập ngày cập nhật..."/><div style="color: red; font-style: italic;"><form:errors path="ngay" cssClass="error"/></div></td></tr>
                        
                        
                        <tr><td><b>Mô tả chi tiết</b></td><td>
                        <form:textarea style="height: 100px; width: 40%" path="chitiet" placeholder="Nhập mô tả chi tiết..."></form:textarea><div style="color: red; font-style: italic;"><form:errors path="chitiet" cssClass="error"/></div></td></tr>
                      
                        <tr><td><b>Danh mục</b></td><td>
                        <c:choose>
                        <c:when test="${not empty categoryList}">
                        	<select name="category">
                        		<option value=0>Chọn danh mục sách...</option>
                        		<c:forEach var="category" items="${categoryList}">
                        			<option value="${category.id}">${category.name}</option>
                        		
                        		</c:forEach>
                        	
                        	</select>
                       
                        </c:when>
                        </c:choose>
                        </td></tr>
                       <tr><td></td><td>
                                <input type="hidden" name="command" value="insert">
                                <input type="submit" class="button" value="Thêm sách"> </td></tr>
                    </table>
                </form:form>
                    
                </div>