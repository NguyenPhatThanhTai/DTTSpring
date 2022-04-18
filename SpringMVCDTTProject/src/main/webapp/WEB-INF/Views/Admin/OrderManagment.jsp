<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css'
	rel='stylesheet'>
<link rel="stylesheet"
	href="<c:url value="/resources/CSS/orderCRUD.css" />">
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
					<li><a href="CategoryManagment">Loại sản phẩm</a></li>
					<li><a href="ManufactorManagment">Nhà sản xuất</a></li>
					<li><a class="Order" href="OrderManagment">Đơn hàng</a></li>
				</ul>
			</li>
			<li><a href="#"><i class='bx bxs-chart icon' ></i> Nhân sự</a></li>
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
			<h1 class="title">ĐƠN HÀNG</h1>
			<ul class="breadcrumbs">
				<li><a href="#">Trang chủ</a></li>
				<li class="divider">/</li>
				<li><a href="#" class="active">QL Đơn hàng</a></li>
			</ul>

            <!-- Product table -->
            <!-- Style table -->
            <div class="table-responsive">
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>Mã đơn hàng</th>
                            <th>Thời gian</th>
                            <th>Tên người nhận</th>
                            <th>SĐT người nhận</th>
                            <th>Địa chỉ người nhận</th>
                            <th>Ghi chú</th>
                            <th>Tổng tiền</th>
                            <th>Hành động</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="item" items="${List_Order}" varStatus="status">
                        	<tr>
	                            <td>${item.id}</td>
	                            <td>${item.time}</td>
	                            <td>${item.nameReceive}</td>
	                            <td>${item.phoneReceive}</td>
	                            <td>${item.addressReceive}</td>
	                            <td>${item.note}</td>
	                            <td>${item.totalPrice}</td>
	                            <td>
	                                <button type="button" class="btn-delete" data-toggle="modal" data-target="#modalDel"
	                                    onclick="getInfoDetailOrder('${item.id}')"><i class='bx bx-search' ></i>
	                                </button>
	                                <c:if test="${item.status == -1}">
	                                	<i class='bx bx-check'></i>
	                                </c:if>
	                            </td>
                        	</tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            
            <div class="modal fade" id="modalDel" role="dialog">
                <div class="modal-dialog">
                    <form action="UpdateOrderStatus" method="post">
                    <!-- Modal content-->
                    <div class="modal-content">
                    <div class="modal-header">
                      <button type="button" class="close" data-dismiss="modal">&times;</button>
                      <h4 class="modal-title">Chi tiết đơn hàng</h4>
                    </div>
                    <div class="modal-body">
                        <div id="InfoOrder">

                        </div>
                </div>
                <div class="modal-footer">
                      <input type="button" class="btn btn-danger" data-dismiss="modal" value="Hủy"></input>
                      <input id="OrderDone" type="submit" class="btn btn-primary" value="Hoàn thành đơn hàng" />
                    </div>
                </div>
                </form>
                
		</main>
		<!-- MAIN -->
	</section>
	<!-- NAVBAR -->
<script>
	$( document ).ready(function() {
	    $('.side-dropdown').addClass('show');
	    $('.Order').css("color", "red");
	});

    function getInfoDetailOrder($orderId){
            $.ajax({
                  type: 'GET',
                  dataType:"jsonp",
                  url: '../Admin/GetOrderJson?orderId=' + $orderId,
                  complete: function (data) {

                      data = JSON.parse(data.responseText);
                      console.log(data);

                      var template = "";
                      for(var i = 0; i < data.listOrder.length; i++){
                        template += '<tr>' +
                                        '<td>'+data.listOrder[i].productId+'</td>' +
                                        '<td>'+data.listOrder[i].productQuantity+'</td>' +
                                        '<td>'+data.listOrder[i].productName+'</td>' +
                                    '</tr>';
                      }

                      if(data.status == -1){
                        $("#OrderDone").attr("value", "Đã hoàn thành đơn hàng");
                        $("#OrderDone").attr("disabled", "disabled");
                      }else{
                        $("#OrderDone").attr("value", "Hoàn thành đơn hàng");
                        $("#OrderDone").removeAttr("disabled");
                      }


                            var cmtTemplate = 
                                '<div class="modal-body">' +
                                    '<div class="modal-body-left">' +
                                    '<input id="OrderId" name="OrderId" type="hidden" value="'+data.orderId+'" />' +
                                        '<p>Tên người đặt</p>' +
                                        '<input type="text" placeholder="Tên người đặt" class="form-control my-3 p-4" value="'+data.name+'" disabled>' +
                                        '<p>SĐT người đặt</p>' +
                                        '<input type="text" placeholder="SĐT người đặt" class="form-control my-3 p-4" value="'+data.phone+'" disabled>' +
                                        '<p>Địa chỉ người đặt</p>' +
                                        '<input type="text" placeholder="Địa chỉ người đặt" class="form-control my-3 p-4" value="'+data.address+'" disabled>' +
                                        '<p>Ghi chú</p>' +
                                        '<input type="text" placeholder="Ghi chú" class="form-control my-3 p-4" value="'+data.note+'" disabled>' +
                                        '<p>Tổng tiền</p>' +
                                        '<input type="text" placeholder="Tổng tiền" class="form-control my-3 p-4" value="'+data.totalrice+'" disabled>' +
                                    '</div>' +
                                        '<div class="modal-body-left">' +
                                            '<div class="table-responsive table-height">' +
                                                '<table class="table table-striped table-hover ">' +
                                                    '<thead>' +
                                                        '<tr>' +
                                                            '<th>Mã sản phẩm</th>' +
                                                            '<th>Tên sản phẩm</th>' +
                                                            '<th>Số lượng</th>' +
                                                        '</tr>' +
                                                    '</thead>' +
                                                    '<tbody>' +
                                                        template +
                                                    '</tbody>' +
                                                '</table>' +
                                            '</div>' +
                                        '</div>' +
                                    '</div>' +
                                '</div>';
                            $("#InfoOrder").html(cmtTemplate);
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