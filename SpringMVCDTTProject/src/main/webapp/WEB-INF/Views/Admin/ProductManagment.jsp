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
		<a href="#" class="brand"><i class='bx bxs-smile icon'></i> DTT
			Store</a>
		<ul class="side-menu">
			<li><a href="#" class=""><i class='bx bxs-dashboard icon'></i>
					Tổng quan</a></li>
			<li class="divider" data-text="Danh mục">Main</li>
			<li><a href="#" class="active"><i class='bx bxs-inbox icon'></i>
					Quản lý <i class='bx bx-chevron-right icon-right'></i></a>
				<ul class="side-dropdown">
					<li><a href="#">Sản phẩm</a></li>
					<li><a href="#">Loại sản phẩm</a></li>
					<li><a href="#">Nhà sản xuất</a></li>
					<li><a href="#">Đơn hàng</a></li>
				</ul></li>
			<li><a href="#"><i class='bx bxs-chart icon'></i> Nhân sự</a></li>
			<li><a href="#"><i class='bx bxs-widget icon'></i> Khách
					hàng</a></li>
			<li class="divider" data-text="table and forms">Thống kê</li>
			<li><a href="#"><i class='bx bx-table icon'></i> Doanh thu</a></li>
		</ul>
	</section>
	<!-- SIDEBAR -->

	<!-- NAVBAR -->
	<section id="content">
		<!-- NAVBAR -->
		<nav>
			<i class='bx bx-menu toggle-sidebar'></i>
			<form action="#">
				<div class="form-group">
					<input type="text" placeholder="Tìm kiếm..."> <i
						class='bx bx-search icon'></i>
				</div>
			</form>
			<a href="#" class="nav-link"> <i class='bx bxs-bell icon'></i> <span
				class="badge">1</span>
			</a> <a href="#" class="nav-link"> <i
				class='bx bxs-message-square-dots icon'></i> <span class="badge">1
			</span>
			</a> <span class="divider"></span>
			<div class="profile">
				<img src="./img/avt.jpg" alt="">
				<ul class="profile-link">
					<li><a href="#"><i class='bx bxs-user-circle icon'></i>
							Hồ sơ</a></li>
					<li><a href="#"><i class='bx bxs-cog'></i> Cài đặt</a></li>
					<li><a href="#"><i class='bx bxs-log-out-circle'></i>
							Đăng xuất</a></li>
				</ul>
			</div>
		</nav>
		<!-- NAVBAR -->

		<!-- MAIN -->
		<main>
			<h1 class="title">Tổng quan</h1>
			<ul class="breadcrumbs">
				<li><a href="#">Trang chủ</a></li>
				<li class="divider">/</li>
				<li><a href="#" class="active">Tổng quan</a></li>
			</ul>
			<button type="button" class="btn btn-primary" data-toggle="modal"
				data-target="#modalAdd">
				<i class='bx bx-plus'></i> Thêm sản phẩm
			</button>
			<!-- Product table -->
			<!-- Style table -->

			<div class="table-responsive">
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>ID</th>
							<th>Tên sản phẩm</th>
							<th>Loại sản phẩm</th>
							<th>Giá</th>
							<th>Giới thiệu</th>
							<th>Ảnh đại điện</th>
							<th>Hành động</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${All_Product}" varStatus="status">
							<tr>
								<td>${item.productDetail.id}</td>
								<td>${item.productDetail.name}</td>
								<td>${item.category.name}</td>
								<td>${item.productDetail.price}</td>
								<td>${item.productDetail.description}</td>
								<td style="text-align: center;"><img width="100"
									src="${item.productDetail.img_Cover}"></td>
								<td>
									<button type="button" class="btn-edit" data-toggle="modal"
										data-target="#modalEdit"
										onclick=(getProduct(${item.productDetail.id}))>
										<i class='bx bx-edit-alt'></i>
									</button>
									<button type="button" class="btn-delete" data-toggle="modal"
										data-target="#modalDel">
										<i class='bx bx-trash'></i>
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
						<form method="POST" action="AddProduct"
							modelAttribute="AddProduct">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4 class="modal-title">Thêm Sản Phẩm</h4>
							</div>
							<div class="modal-body">
								<div class="modal-body-left">
									<p>Tên sản phẩm</p>
									<input type="text" placeholder="Tên sản phẩm" name="Name"
										class="form-control my-3 p-4">
									<p>Giới thiệu sản phẩm</p>
									<input type="text" placeholder="Giới thiệu sản phẩm"
										name="Descripsion" class="form-control my-3 p-4">
									<p>Giá sản phẩm</p>
									<input type="text" placeholder="Giá sản phẩm" name="Price"
										class="form-control my-3 p-4">
									<p>Ảnh đại diện sản phẩm</p>
									<input type="text" placeholder="Link ảnh đại diện"
										name="Img_cover" class="form-control my-3 p-4">
									<p>Ảnh phụ đại diện sản phẩm</p>
									<input type="text" placeholder="Link ảnh phụ" name="Img_hover"
										class="form-control my-3 p-4">
									<p>Nhà sản xuất</p>
									<select class="form-control my-3 p-4" name="ManufactorsId">
										<c:forEach var="item" items="${All_Manufactors}"
											varStatus="status">
											<option value="${item.id}">${item.name}</option>
										</c:forEach>
									</select>
								</div>
								<div class="modal-body-left">
									<p>Ảnh chi tiết thứ nhất sản phẩm</p>
									<input type="text" placeholder="Link ảnh chi tiết thứ nhất"
										name="Img_detail1" class="form-control my-3 p-4">
									<p>Ảnh chi tiết thứ hai sản phẩm</p>
									<input type="text" placeholder="Link ảnh chi tiết thứ hai"
										name="Img_detail2" class="form-control my-3 p-4">
									<p>Ảnh chi tiết thứ ba sản phẩm</p>
									<input type="text" placeholder="Link ảnh chi tiết thứ ba"
										name="Img_detail3" class="form-control my-3 p-4">
									<p>Ảnh chi tiết thứ tư sản phẩm</p>
									<input type="text" placeholder="Link ảnh chi tiết thứ tư"
										name="Img_detail4" class="form-control my-3 p-4">
									<p>Số lượng</p>
									<input type="text" placeholder="Link ảnh chi tiết thứ tư"
										name="Img_detail5" class="form-control my-3 p-4">
									<p>Loại sản phẩm</p>
									<select class="form-control my-3 p-4" name="CategoryId">
										<c:forEach var="item" items="${All_Category}"
											varStatus="status">
											<option value="${item.id}">${item.name}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-danger"
									data-dismiss="modal">Đóng</button>
								<input type="submit" value="Thêm" class="btn btn-primary" />
							</div>
						</form>
					</div>
				</div>
			</div>

			<div class="modal fade" id="modalDel" role="dialog">
				<div class="modal-dialog">

					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title">Xóa sản phẩm</h4>
						</div>
						<div class="modal-body">
							<p>Bạn có chắc chắn muốn xóa sản phẩm này ?</p>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-danger" data-dismiss="modal">Hủy</button>
							<button type="button" class="btn btn-primary"
								data-dismiss="modal">Đồng ý</button>
						</div>
					</div>
				</div>
			</div>
			<div class="modal fade" id="modalEdit" role="dialog">
				<div class="modal-dialog">

					<!-- Modal content-->
					<div class="modal-content">
						<form method="POST" action="UpdateProduct" modelAttribute="Product">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4 class="modal-title">Cập nhật sản phẩm</h4>
							</div>
							<div class="modal-body" id="updateContent">
								<!-- load by ajax -->
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-danger" data-dismiss="modal">Hủy</button>
								<input type="submit" class="btn btn-primary" value="Cập nhật" />
							</div>
						</form>
					</div>
				</div>
			</div>
		</main>
		<!-- MAIN -->
	</section>
	<!-- NAVBAR -->
	<script>
	function getProduct(prodId){
		$("#updateContent").html("");
			$.ajax({
				  type: 'GET',
				  dataType:"jsonp",
				  url: '../Admin/GetProductJson?prodId=' + prodId,
				  complete: function (data) {
					  data = JSON.parse(data.responseText);				  
	    		    	var updateContent = 
	    		    		'<div class="modal-body-left">' +
	                    		'<p>Tên sản phẩm</p>' +
	    		    			'<input type="text" placeholder="Tên sản phẩm" name="Name" value="'+data.name+'" class="form-control my-3 p-4">' +
	                        	'<p>Giới thiệu sản phẩm</p>' +
	                            '<input type="text" placeholder="Giới thiệu sản phẩm" name="Descripsion" class="form-control my-3 p-4" value="'+data.description+'">' +
	                        	'<p>Giá sản phẩm</p>' + 
	                        	'<input type="text" placeholder="Giá sản phẩm" name="Price" class="form-control my-3 p-4" value="'+data.price+'">' + 
	                            '<p>Ảnh đại diện sản phẩm</p>' + 
	                            '<input type="text" placeholder="Link ảnh đại diện" name="Img_cover" class="form-control my-3 p-4" value="'+data.img_Cover+'">' + 
	                            '<p>Ảnh phụ đại diện sản phẩm</p>' + 
	                            '<input type="text" placeholder="Link ảnh phụ" name="Img_hover" class="form-control my-3 p-4" value="'+data.img_Hover+'">' +
	                        	'<p>Nhà sản xuất</p>' +
                                '<select class="form-control my-3 p-4" name="ManufactorsId">' + 
                                	'<c:forEach var="item" items="${All_Manufactors}" varStatus="status">' +
                                	    '<option value="${item.id}" ${data.manufactorId == item.id ? "selected" : ""}>${item.name}</option>' +
                                	'</c:forEach>' +
                                '</select>' +
	                            '</div>' +
	                    	'<div class="modal-body-left">' +
                    			'<p>Ảnh chi tiết thứ nhất sản phẩm</p>' +
                        		'<input type="text" placeholder="Link ảnh chi tiết thứ nhất" name="Img_detail1" class="form-control my-3 p-4" value="'+data.img_Detail1+'">' +
                            	'<p>Ảnh chi tiết thứ hai sản phẩm</p>' +
                        		'<input type="text" placeholder="Link ảnh chi tiết thứ hai" name="Img_detail2" class="form-control my-3 p-4" value="'+data.img_Detail2+'"/>' + 
                        		'<p>Ảnh chi tiết thứ ba sản phẩm</p>' + 
                            	'<input type="text" placeholder="Link ảnh chi tiết thứ ba" name="Img_detail3" class="form-control my-3 p-4" value="'+data.img_Detail3+'">' +  
                            	'<p>Ảnh chi tiết thứ tư sản phẩm</p>' + 
                            	'<input type="text" placeholder="Link ảnh chi tiết thứ tư" name="Img_detail4" class="form-control my-3 p-4" value="'+data.img_Detail4+'">' +
                            	'<p>Số lượng</p>' +
                            	'<input type="text" placeholder="Số lượng" class="form-control my-3 p-4" value="0">' +
	                        	'<p>Nhà sản xuất</p>' +
                                '<select class="form-control my-3 p-4" name="CategoryId">' + 
                                	'<c:forEach var="item" items="${All_Category}" varStatus="status">' +
                                	    '<option value="${item.id}" ${data.categoryId == item.id ? "selected" : ""}>${item.name}</option>' +
                                	'</c:forEach>' +
                                	'<input type="hidden" name="ProductId" value="'+data.productId+'"/>' +
                                	'<input type="hidden" name="Id" value="'+data.id+'"/>' +
                                '</select>' +
                        	'</div>';
	                   		
	    		    	$("#updateContent").html(updateContent);
				  }
			});	
		}
	</script>

	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/apexcharts"></script>
	<script src="<c:url value="/resources/JS/script.js" />"></script>
</body>
</html>