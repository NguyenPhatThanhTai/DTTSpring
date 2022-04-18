<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css'
	rel='stylesheet'>
<link rel="stylesheet"
	href="<c:url value="/resources/CSS/baloCRUD.css" />">
	<link rel="stylesheet"
	href="<c:url value="/resources/CSS/styleAdmin.css" />">
<!-- bootstrap -->
<!-- icon -->
<link rel="icon" href="../admin/img/TTDStore_logo.png">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"
	integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<title>DTT Store Admin</title>
</head>
<body>
		<!-- SIDEBAR -->
	<section id="sidebar">
		<a href="#" class="brand"><i class='bx bxs-smile icon'></i> DTT Store</a>
		<ul class="side-menu">
			<li><a href="#" class=""><i class='bx bxs-dashboard icon' ></i> Tổng quan</a></li>
			<li class="divider" data-text="Danh mục">Main</li>
			<li>
				<a href="#" class="active"><i class='bx bxs-inbox icon' ></i> Quản lý <i class='bx bx-chevron-right icon-right' ></i></a>
				<ul class="side-dropdown">
					<li><a href="/SpringMVCDTTpProject/Admin/">Sản phẩm</a></li>
					<li><a class="Category" href="CategoryManagment">Loại sản phẩm</a></li>
					<li><a href="ManufactorManagment">Nhà phân phối</a></li>
					<li><a href="OrderManagment">Đơn hàng</a></li>
				</ul>
			</li>
			<li><a href="CustomerManagment"><i class='bx bxs-chart icon' ></i> Nhân sự</a></li>
			<li><a href="CustomerManagment"><i class='bx bxs-widget icon' ></i> Khách hàng</a></li>
			<li class="divider" data-text="table and forms">Thống kê</li>
			<li><a href="#"><i class='bx bx-table icon' ></i> Doanh thu</a></li>
		</ul>
	</section>
	<!-- SIDEBAR -->

	<!-- NAVBAR -->
	<section id="content">
		<!-- NAVBAR -->
		<nav>
			<i class='bx bx-menu toggle-sidebar' ></i>
			<form action="#">
				<div class="form-group">
					<input type="text" placeholder="Tìm kiếm...">
					<i class='bx bx-search icon' ></i>
				</div>
			</form>
			<a href="#" class="nav-link">
				<i class='bx bxs-bell icon' ></i>
				<span class="badge">1</span>
			</a>
			<a href="#" class="nav-link">
				<i class='bx bxs-message-square-dots icon' ></i>
				<span class="badge">1 </span>
			</a>
			<span class="divider"></span>
			<div class="profile">
				<img src="./img/avt.jpg" alt="">
				<ul class="profile-link">
					<li><a href="#"><i class='bx bxs-user-circle icon' ></i> Hồ sơ</a></li>
					<li><a href="#"><i class='bx bxs-cog' ></i> Cài đặt</a></li>
					<li><a href="#"><i class='bx bxs-log-out-circle' ></i> Đăng xuất</a></li>
				</ul>
			</div>
		</nav>
		<!-- NAVBAR -->

		<!-- MAIN -->
		<main>
			<h1 class="title">DANH MỤC</h1>
			<ul class="breadcrumbs">
				<li><a href="#">Trang chủ</a></li>
				<li class="divider">/</li>
				<li><a href="#" class="active">QL Danh mục</a></li>
			</ul>
			<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modalAdd"><i class='bx bx-plus'></i> Thêm danh mục sản phẩm</button>
            <!-- Product table -->
            <!-- Style table -->

            <div class="table-responsive">
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>STT</th>
                            <th>Tên loại sản phẩm</th>
                            <th>Hành động</th>
                        </tr>
                    </thead>
                    <tbody>
	                    <c:forEach var="item" items="${List_Category}" varStatus="status">
	                        <tr>
	                            <td>${item.id}</td>
	                            <td>${item.name}</td>
	                            <td>
	                                <button type="button" class="btn-edit" data-toggle="modal" data-target="#modalEdit"
	                                onclick=(updateCategory(${item.id}))>
	                                    <i class='bx bx-edit-alt' ></i>
	                                    
	                                </button>
	                                <button type="button" class="btn-delete" data-toggle="modal" data-target="#modalDel" 
	                                onclick=(deleteCategory(${item.id}))>
	                                    <i class='bx bx-trash' ></i>
	                                    
	                                </button>
	                            </td>
	                        </tr>
	                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <!-- Modal -->
            <div class="modal fade" id="modalAdd" role="dialog">
                <div class="modal-dialog">
                
                <!-- Modal content-->
                <div class="modal-content">
	                <form method="POST" action="AddCategory" modelAttribute="AddCategory">
	                    <div class="modal-header">
	                      <button type="button" class="close" data-dismiss="modal">&times;</button>
	                      <h4 class="modal-title">Thêm Danh Mục Sản Phẩm</h4>
	                    </div>
	                    <div class="modal-body">
	                        <div class="modal-body-left">
	                            <p>Tên loại sản phẩm</p>
	                            <input type="text" placeholder="Tên sản phẩm" name="Name" class="form-control my-3 p-4">
	                          </div>
	                    </div>
	                    <div class="modal-footer">
	                      <button type="button" class="btn btn-danger" data-dismiss="modal">Đóng</button>
	                      <input type="submit" class="btn btn-primary" value="Thêm" />
	                    </div>
                     </form>
                  </div>
                </div>
            </div>
            
            <div class="modal fade" id="modalDel" role="dialog">
                <div class="modal-dialog">
	                <form method="POST" action="DeleteCategory">
		                <!-- Modal content-->
		                <div class="modal-content">
		                    <div class="modal-header">
		                      <button type="button" class="close" data-dismiss="modal">&times;</button>
		                      <h4 class="modal-title">Xóa loại sản phẩm</h4>
		                    </div>
		                    <div class="modal-body">
		                      <p>Bạn có chắc chắn muốn xóa loại sản phẩm này ?</p>
		                    </div>
		                    <div class="modal-footer">
		                      <input type="hidden" name="categoryId" id="categoryDelete" value="">
		                      <button type="button" class="btn btn-danger" data-dismiss="modal">Hủy</button>
		                      <input type="submit" value="Đồng ý" class="btn btn-primary" />
		                    </div>
		                  </div>
	                  </form>
                </div>
            </div>
            <div class="modal fade" id="modalEdit" role="dialog">
                <div class="modal-dialog">
                <form method="POST" action="UpdateCategory" modelAttribute="UpdateCategory">
	                <!-- Modal content-->
	                <div class="modal-content">
	                    <div class="modal-header">
	                      <button type="button" class="close" data-dismiss="modal">&times;</button>
	                      <h4 class="modal-title">Cập nhật Danh Mục Sản Phẩm</h4>
	                    </div>
	                    <div class="modal-body">
	                        <div class="modal-body-left">
	                            <p>Tên loại sản phẩm</p>
	                            <input id="categoryName" type="text" name="Name" placeholder="A du` loai balo kia` ae" class="form-control my-3 p-4">
	                            <input id="categoryId" type="hidden" name="Id" placeholder="A du` loai balo kia` ae" class="form-control my-3 p-4">
	                          </div>
	                    </div>
	                    <div class="modal-footer">
	                      <button type="button" class="btn btn-danger" data-dismiss="modal">Đóng</button>
	                      <input type="submit" value="Cập nhật" class="btn btn-primary" />
	                    </div>
	                 </div>
	             </form>
            </div>
		</main>
		<!-- MAIN -->
	</section>
	<!-- NAVBAR -->
	<script>
	
	$( document ).ready(function() {
	    $('.side-dropdown').addClass('show');
	    $('.Category').css("color", "red");
	});
	
		function deleteCategory(id){
			$("#categoryDelete").val(id);
		}
		
		function updateCategory(id){
			$.ajax({
				  type: 'GET',
				  dataType:"jsonp",
				  url: '../Admin/GetCategoryJson?categoryId=' + id,
				  complete: function (data) {
					  data = JSON.parse(data.responseText);
					  $("#categoryId").val(data.id);
					  $("#categoryName").val(data.name);
				  }
			});	
		}
	</script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/apexcharts"></script>
	<script src="<c:url value="/resources/JS/script.js" />"></script>
</body>
</html>