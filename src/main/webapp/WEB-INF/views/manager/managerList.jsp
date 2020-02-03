<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/mos-style.css"></link>

  <div id="rightContent">
    <h3 style="color: goldenrod; font-size: 32px; font-weight: bold">Trang chủ Manager</h3>
   <a href="${pageContext.request.contextPath}/admin/manager/create" style="float: right; font-weight: bold; margin-bottom: 10px;margin-right: 40px;margin-top: 10px">Thêm manager</a>
   <div style="color: red; font-style: italic;">
	${msg}
</div>
    	 <table class="data">
                        <tr class="data">
                           
                            <th class="data" width="150px" style="text-align: center">Mã tài khoản</th>
                            <th class="data"  style="text-align: center">Mật khẩu</th>
                            <th class="data"  style="text-align: center">Tên manager</th>
                            <th class="data"  style="text-align: center">Năm sinh</th>
                            <th class="data"  style="text-align: center">Email</th>
                            <th class="data"  style="text-align: center">SĐT</th>
                            <th class="data"  style="text-align: center">Địa chỉ</th>
                            <th class="data" width="70px"></th>
                            <th class="data" width="70px"></th>
                        </tr>
                        <c:forEach var="manager" items="${allManager}">
                        <tr class="data">
                           
                             <td class="data" width="150px"  style="text-align: center">${manager.id}</td>
                            <td class="data"  style="text-align: center">${manager.pass}</td>
                            <td class="data"  style="text-align: center">${manager.ten}</td>
                            <td class="data"  style="text-align: center">${manager.namsinh}</td>
                            <td class="data"  style="text-align: center">${manager.email}</td>
                            <td class="data"  style="text-align: center">${manager.sdt}</td>
                            <td class="data"  style="text-align: center">${manager.diachi}</td>
                            <td class="data" width="70px" style="text-align: center""><a href="${pageContext.request.contextPath}/admin/manager/edit/${manager.id}" style="color: blue;font-weight: bold;">Sửa</a></td>
                       		<td class="data" width="70px" style="text-align: center"><a href="${pageContext.request.contextPath}/admin/manager/delete/${manager.id}" style="color: red; font-weight: bold;">Xóa</a></td>
                        </tr>
                        </c:forEach>
                    </table>
                    
                    
                    
                </div>