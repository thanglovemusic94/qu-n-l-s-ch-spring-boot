
<%@ page 
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
	<script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
	<script src="/js/datatable.js"></script>
    <div id="rightContent">
    <h3 style="color: goldenrod; font-size: 32px; font-weight: bold">Cập nhật sách</h3>
    <a href="${pageContext.request.contextPath}/admin/book/create" style="float: right; font-weight: bold; margin-bottom: 10px;margin-right: 40px;margin-top: 10px">Thêm sách</a>
    	<div style="color: red; font-style: italic;">
			${msg}
		</div>
    	 <table class="data">
                        <tr class="data">
                            <th class="data" width="30px" style="text-align: center">STT</th>
                            <th class="data"  width="50px" style="text-align: center">Tên sách</th>
                             <th class="data" width="50px  style="text-align: center">Danh mục</th>
                            <th class="data"  style="text-align: center">Ảnh</th>
                            <th class="data"  style="text-align: center">Tác giả</th>
                             <th class="data"  style="text-align: center">Thể loại</th>
                            <th class="data"  style="text-align: center">NXB</th>
                            <th class="data"  style="text-align: center">Ngày</th>
                            <th class="data"  style="text-align: center">Chi tiết</th>
                            <th class="data" width="40px"></th>
                            <th class="data" width="40px"></th>
                        </tr>
                        <c:forEach var="book" items="${allBook}">
                        <tr class="data">
                            <td class="data" width="30px"  style="text-align: center">${book.id}</td>
                            <td class="data"  style="text-align: center" width="100px">${book.name}</td>
                            <td class="data"  style="text-align: center" width="70px">${book.category.name}</td>
                            <td class="data"  style="text-align: center"><img src="${pageContext.request.contextPath}/images/${book.img}"/></td>
                            <td class="data"  style="text-align: center">${book.tacgia}</td>
                            <td class="data"  style="text-align: center">${book.theloai}</td>
                            <td class="data"  style="text-align: center">${book.nxb}</td>
                            <td class="data"  style="text-align: center">${book.ngay}</td>
                            <td class="data"  style="text-align: center" width="250px">${book.chitiet}</td>
                            <td class="data" width="40px" style="text-align: center""><a href="${pageContext.request.contextPath}/admin/book/edit/${book.id}" style="color: blue;font-weight: bold;">Sửa</a></td>
                       		<td class="data" width="40px" style="text-align: center"><a href="${pageContext.request.contextPath}/admin/book/delete/${book.id}" style="color: red; font-weight: bold;">Xóa</a></td>
                        </tr>
                        </c:forEach>
                    </table>
                    
                    <div class="pagination">
               
						<ul>
							<c:forEach  begin="1" end="${totalPage}" varStatus="status" >
							<li><a href="${pageContext.request.contextPath}/admin/book/page/${status.count}">${status.count}</a></li>
							</c:forEach>
						</ul>
					</div>
                    
                </div>
               
                