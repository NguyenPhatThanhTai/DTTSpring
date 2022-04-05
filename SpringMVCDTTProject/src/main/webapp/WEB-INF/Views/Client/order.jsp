<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>DTT Store</title>
<!-- google font -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
	rel="stylesheet">
<!-- box icons -->
<link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css'
	rel='stylesheet'>
<!-- bootstrap -->
<link
	href="https://getbootstrap.com/docs/5.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<!-- logo -->
<link rel="icon" href="./images/TTDStore_logo.png">
<!-- css -->
<link rel="stylesheet" href="<c:url value="/resources/CSS/order.css" />">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"
	integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</head>
<body>
	<form method="POST" action="CheckOut" modelAttribute="CheckOut">
			<div class="container">
			<div class="py-3 text-center">
				<h2>Thông tin thanh toán</h2>
			</div>
		</div>
	
		<div class="row g-5">
			<div class="col-md-5 col-lg-4 order-md-last">
				<h4 class="d-flex justify-content-between align-items-center mb-3">
					<span class="text-primary">Giỏ hàng của bạn</span> <span
						class="badge bg-primary rounded-pill">${list_cart.size()}</span>
				</h4>
				<ul class="list-group mb-3">
					<c:forEach var="item" items="${list_cart}" varStatus="status">
						<li class="list-group-item d-flex justify-content-between lh-sm">
							<div>
							<input type="hidden" name="ProductId" value="${item.productId}">
							<input type="hidden" name="Quantity" value="${item.number}">
								<h6 class="my-0">${item.name}</h6>
							</div> <span class="text-muted">${(item.price) * (item.number)} VND</span>
						</li>
					</c:forEach>
				</ul>
	
				<div id="currentMoney">
					<b><h3>Tổng thanh toán:</b><span id="totalMoney">${total_money}</span>
					<input type="hidden" name="TotalPrice" value="${total_money}">
					VND
					</h3>
				</div>
				<div id="discountMoney"></div>
	
					<div class="input-group">
						<input type="text" class="form-control" id="discountCode"
							placeholder="Nhập mã giảm giá">
						<button type="button" id="disCountSubmit" class="btn btn-secondary">Áp
							dụng</button>
					</div>
			</div>
			<div class="col-md-7 col-lg-8">
			<input type="hidden" value="${user.id}" name="CustomerId">
				<h4 class="mb-3">Địa chỉ thanh toán</h4>
					<div class="row g-3">	
						<div class="col-sm-6">
							<label for="lastName" class="form-label">Tên</label> <input
								type="text" class="form-control" id="lastName"
								placeholder="Tên của bạn" value="${user.name}" required="" name="NameReceive">
							<div class="invalid-feedback">Vui lòng nhập Tên của bạn.</div>
						</div>
	
						<div class="col-12">
							<label for="email" class="form-label">Email</label> <input
								type="email" class="form-control" id="email"
								placeholder="you@example.com" value="${user.email}" name="EmailReceive">
							<div class="invalid-feedback">Vui lòng nhập Email của bạn.</div>
						</div>
	
						<div class="col-12">
							<label for="address" class="form-label">Địa chỉ</label> <input
								type="text" class="form-control" id="address"
								placeholder="123/2 Võ Thị Sáu..." value="${user.address}" required="" name="AddressReceive">
							<div class="invalid-feedback">Vui lòng nhập Địa chỉ của bạn.
							</div>
						</div>
	
						<div class="col-md-5">
							<label for="country" class="form-label">Tỉnh/Thành phố</label> <select
								class="form-select" id="country" required="" name="City">
								<option value="">Vui lòng chọn...</option>
							</select>
							<div class="invalid-feedback">Vui lòng chọn Tỉnh/Thành phố
								của bạn.</div>
						</div>
	
						<div class="col-md-4">
							<label for="state" class="form-label">Quận/Huyện</label> <select
								class="form-select" id="state" required="" name="District">
								<option value="">Vui lòng chọn...</option>
							</select>
							<div class="invalid-feedback">Vui lòng nhập Quận/Huyện của
								bạn.</div>
						</div>
	
						<div class="col-md-3">
							<label for="zip" class="form-label">Mã Bưu Điện</label> <input
								type="text" class="form-control" id="zip" placeholder="888888"
								required="">
							<div class="invalid-feedback">Vui lòng nhập Mã Bưu Điện của
								bạn.</div>
						</div>
					</div>
	
					<hr class="my-4">
	
					<div class="form-check">
						<input type="checkbox" class="form-check-input" id="same-address">
						<label class="form-check-label" for="same-address">Vận
							chuyển hàng đến địa chỉ trên</label>
					</div>
	
					<div class="form-check">
						<input type="checkbox" class="form-check-input" id="save-info">
						<label class="form-check-label" for="save-info">Lưu thông
							tin</label>
					</div>
	
					<hr class="my-4">
	
					<h4 class="mb-3">Phương thức thanh toán</h4>
	
					<div class="my-3">
						<div class="form-check">
							<input id="credit" name="paymentMethod" type="radio"
								class="form-check-input" checked="" required=""> <label
								class="form-check-label" for="credit">Thẻ tín dụng</label>
						</div>
						<div class="form-check">
							<input id="cash" name="paymentMethod" type="radio"
								class="form-check-input" required=""> <label
								class="form-check-label" for="cash">Tiền mặt</label>
						</div>
						<div class="form-check">
							<input id="paypal" name="paymentMethod" type="radio"
								class="form-check-input" required=""> <label
								class="form-check-label" for="paypal">PayPal</label>
						</div>
					</div>
	
					<div class="row gy-3">
						<div class="col-md-6">
							<label for="cc-name" class="form-label">Tên chủ thẻ</label> <input
								type="text" class="form-control" id="cc-name"
								placeholder="NGUYEN VAN A" required="">
							<div class="invalid-feedback">Vui lòng nhập Tên chủ thẻ.</div>
						</div>
	
						<div class="col-md-6">
							<label for="cc-number" class="form-label">Số thẻ</label> <input
								type="text" class="form-control" id="cc-number"
								placeholder="1234 XXXX YYYY ZZZZ" required="">
							<div class="invalid-feedback">Vui lòng nhập Số thẻ.</div>
						</div>
	
						<div class="col-md-3">
							<label for="cc-expiration" class="form-label">Thời hạn</label> <input
								type="text" class="form-control" id="cc-expiration"
								placeholder="01/01" required="">
							<div class="invalid-feedback">Vui lòng nhập Thời hạn.</div>
						</div>
	
						<div class="col-md-3">
							<label for="cc-cvv" class="form-label">CVV</label> <input
								type="text" class="form-control" id="cc-cvv" placeholder="XXX"
								required="">
							<div class="invalid-feedback">Vui lòng nhập CVV Code.</div>
						</div>
					</div>
			</div>
		</div>
		<br>
		<input type="submit" value="Xác nhận thanh toán" class="w-100 btn btn-primary btn-lg" />
	</form>
	
	<script type="text/javascript">
	    $(document).ready(function() {
	    	var listCity = null;
	    	$.ajax({
    		  type: 'GET',
    		  dataType : 'json',
    		  url: "https://provinces.open-api.vn/api/?depth=2",
    		  crossDomain: true,
    		  complete: function (data) {
    			    data = JSON.parse(data.responseText);
    			    listCity = data;
    			    listCity.forEach((x) =>{
						$("#country").append('<option class="city" value="'+x.code+'">'+x.name+'</option>')
					})
				}
    		  })
    		  
    		  $("#country").on("change", function(){
    			    $("#state").html("");
			    	var state = listCity.find(y => y.code == $(this).val());
			    	state.districts.forEach((x) =>{
						$("#state").append('<option class="state" value="'+x.code+'">'+x.name+'</option>')
					})
    		  })
    		  
    		  $("#cash").on("click", function(){
    			  $("#cc-name").prop('disabled', true);
    			  $("#cc-number").prop('disabled', true);
    			  $("#cc-expiration").prop('disabled', true);
    			  $("#cc-cvv").prop('disabled', true);
    		  })
    		  
    		  $("#paypal").on("click", function(){
    			  $("#cc-name").prop('disabled', true);
    			  $("#cc-number").prop('disabled', true);
    			  $("#cc-expiration").prop('disabled', true);
    			  $("#cc-cvv").prop('disabled', true);
    		  })
    		  
    		  $("#credit").on("click", function(){
    			  $("#cc-name").prop('disabled', false);
    			  $("#cc-number").prop('disabled', false);
    			  $("#cc-expiration").prop('disabled', false);
    			  $("#cc-cvv").prop('disabled', false);
    		  })
    		  
    		  $("#disCountSubmit").on("click", function(e){
    			  e.preventDefault();
    			  if($("#discountCode").val() == "DTTSALEOFF"){
    				  $("#currentMoney").html('<del><b><h3>Tổng thanh toán: </b><span id="totalMoney">${total_money}</span> VND</h3></del>');
    				  $("#discountMoney").html('<b><h3>Tổng thanh toán: </b><span id="totalMoney">${total_money - (total_money * 15 / 100)}</span> VND</h3>');
    			  }
    		  })
	    })
    </script>
</body>
</html>