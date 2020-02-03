<%@ page 
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="com.springboot.vo.BookVo" %>

<div id="rightContent" >
                    <h3 style="color: goldenrod; font-size: 32px; font-weight: bold">Sửa thông tin sách</h3>
                    <br/>
					<div class="msg">${msg}</div>
                    <form:form modelAttribute="bookVo" action="${pageContext.request.contextPath}/admin/book/edit" method="POST"
                    	 enctype="multipart/form-data"
                    >
                   
                    <table width="95%" style="margin-left: 130px">
                    	<tr><td width="125px"><b>Mã sách</b></td><td>
                        <form:input type="text" class="sedang" path="id" readonly="true"/><div style="color: red; font-style: italic;"><form:errors path="id" cssClass="error"/></div></td></tr>
                    	
                        <tr><td width="125px"><b>Tên sách</b></td><td>
                        <form:input type="text" class="sedang" path="name" /><div style="color: red; font-style: italic;"><form:errors path="name" cssClass="error"/></div></td></tr>
                       
                        
                        <tr><td><b>Ảnh</b></td><td>
                        <form:input type="file" class="sedang" path="img"/><div style="color: red; font-style: italic;"><form:errors path="img" cssClass="error"/></div></td></tr>
                        
                        
                        <tr><td><b>Tác giả</b></td><td>
                        <form:input type="text" class="sedang" path="tacgia"/><div style="color: red; font-style: italic;"><form:errors path="tacgia" cssClass="error"/></div></td></tr>
                        
                        
                        <tr><td><b>Thể loại</b></td><td>
                        <form:input type="text" class="sedang" path="theloai"/><div style="color: red; font-style: italic;"><form:errors path="theloai" cssClass="error"/></div></td></tr>
                        
                        
                        <tr><td><b>Nhà xuất bản</b></td><td>
                        <form:input type="text" class="sedang" path="nxb"/><div style="color: red; font-style: italic;"><form:errors path="nxb" cssClass="error"/></div></td></tr>
                        
                        
                        <tr><td><b>Ngày cập nhật</b></td><td>
                        <form:input type="text" class="sedang" path="ngay" /><div style="color: red; font-style: italic;"><form:errors path="ngay" cssClass="error"/></div></td></tr>
                        
                        
                        <tr><td><b>Mô tả chi tiết</b></td><td>
                        <form:textarea style="height: 100px; width: 40%" path="chitiet" ></form:textarea><div style="color: red; font-style: italic;"><form:errors path="chitiet" cssClass="error"/></div></td></tr>
                      
                      
                        <tr><td><b>Danh mục</b></td><td>
                       
                       
					<form:select path="category" items="${categoryList}"
								itemValue="id" itemLabel="name" />
					
                       
                        </td></tr>
                       
                       
                       
                       
                       <tr><td></td><td>
                                <input type="hidden" name="command" value="insert">
                                <input type="submit" class="button" value="Sửa sách"> </td></tr>
                    </table>
                </form:form>
                    
                </div>