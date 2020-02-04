<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/mos-style.css"></link>

  <div id="rightContent">
    <h3 style="color: goldenrod; font-size: 32px; font-weight: bold">Cập nhật danh mục sách</h3>
   <a href="${pageContext.request.contextPath}/category/create" style="float: right; font-weight: bold; margin-bottom: 10px;margin-right: 40px;margin-top: 10px">Thêm danh mục</a>
   <div style="color: red; font-style: italic;">
	${msg}
</div>
    	 <table class="data">
                        <tr class="data">
                           
                             <th class="data" width="150px" style="text-align: center">Mã danh mục</th>
                            <th class="data"  style="text-align: center">Tên danh mục</th>
                            <th class="data" width="70px"></th>
                            <th class="data" width="70px"></th>
                        </tr>
                        <c:forEach var="category" items="${allCategory}">
                        <tr class="data">
                           
                             <td class="data" width="150px"  style="text-align: center">${category.id}</td>
                            <td class="data"  style="text-align: center">${category.name}</td>
                            <td class="data" width="70px" style="text-align: center""><a href="${pageContext.request.contextPath}/category/edit/${category.id}" style="color: blue;font-weight: bold;">Sửa</a></td>
                       		<td class="data" width="70px" style="text-align: center"><a href="${pageContext.request.contextPath}/category/delete/${category.id}" style="color: red; font-weight: bold;">Xóa</a></td>
                        </tr>
                        </c:forEach>
                    </table>
                    
                    
                    
                </div>