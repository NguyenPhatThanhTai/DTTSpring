<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
<!-- css -->
<link rel="stylesheet" href="<c:url value="/resources/CSS/cart.css" />">
<!-- jQuery -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<!-- promotion section -->
	<div class="promo-parent">
		<div class="promotion">
			<div class="row">
				<c:choose>
					<c:when test="${list_cart != null}">
						<c:forEach var="item" items="${list_cart}" varStatus="status">
							<div class="col-4 col-md-12 col-sm-12">
								<div class="promotion-box">
									<div class="text">
										<h3>Số lượng</h3>
										<button class="btn-minus btn-hover">
											<span>-</span>
										</button>
										<input id="ascending" type="number" value="${item.number}">
										<input id="productId" type="hidden" value="${item.productId}">
										<button class="btn-plus btn-hover">
											<span>+</span>
										</button>
										<h3 class="text-all-price">
											Tổng tiền: <span class="bg-color-price"><input
												class="price" type="number"
												value="${(item.price) * (item.number)}"></span>
										</h3>
										<input class="hiddenprice" type="hidden" value="${(item.price)}">
									</div>
									<img src="${item.image}" alt="">
								</div>
							</div>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<h3>Bạn chưa thêm gì vào giỏ hàng!</h3>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
	<!-- end promotion section -->
	<div class="price">
		<div class="row">
			<div class="col-12 col-md-12 col-sm-12">
				<div class="text-price">
					<h3>
						Tổng tiền <span id="totalPrice">0 VND</span>
					</h3>
					<button class="btn-flat btn-hover complete-cart">
						<span><a href="order">Đặt hàng</a></span>
					</button>
				</div>
			</div>
		</div>
	</div>


	<script>
    $(document).ready(function() {
    	calcuTotalPrice();
    	
        $('.btn-minus').click(function() {
            var $input = $(this).parent().find('#ascending');
            var flagStop = false;
            
            var count = parseInt($input.val()) - 1;
            //count = count < 1 ? 1 : count;
            if(count < 1){
            	if (confirm('Bạn có muốn xóa món hàng này khỏi giỏ hàng?')){
            		count = 0;
            	}
            	else{
            		flagStop = true;
            	}
            }

            if(!flagStop){
                minus(parseInt($(this).parent().find('#productId').val()));	
                
                $input.val(count);
                $input.change();
                var price_all_price = $(this).parent().find('.price');
                var totalprice = parseInt(price_all_price.val())-parseInt($(this).parent().find('.hiddenprice').val());
                price_all_price.val(totalprice < parseInt($(this).parent().find('.hiddenprice').val()) ? parseInt($(this).parent().find('.hiddenprice').val()) : totalprice);
                price_all_price.change();
                
                calcuTotalPrice();
                if(count == 0){
                	location.reload();
                }
            }
            return false;
        });
        $('.btn-plus').click(function() {
            var $input = $(this).parent().find('#ascending');
            $input.val(parseInt($input.val()) + 1);
            $input.change();
            var price_all_price = $(this).parent().find('.price');
            var totalprice = parseInt(price_all_price.val())+parseInt($(this).parent().find('.hiddenprice').val());
            price_all_price.val(totalprice < parseInt($(this).parent().find('.hiddenprice').val()) ? parseInt($(this).parent().find('.hiddenprice').val()) : totalprice);
            price_all_price.change();
            plusNumber(parseInt($(this).parent().find('#productId').val()));
            
            calcuTotalPrice();
            return false;
    	});
        
        function calcuTotalPrice(){
        	var totalPrice = 0;
        	$('.price').each(function() {
        		totalPrice += Number($(this).val())
        		console.log("======= " + totalPrice);
        	});
        	
        	$("#totalPrice").html(String(totalPrice) + " VND");
        }
        
		function plusNumber(ProductId){
			$.ajax({
				  type: 'POST',
				  contentType : 'application/json; charset=utf-8',
				  dataType : 'json',
				  data: JSON.stringify({ 
			        "productId": ProductId, 
			        "number": null,
			        "action": 0,
			        "price": null,
			        "image": null,
			        "name": null
			      }),
				  url: 'addToCartJson',
				  complete: function (data) {
					  data = JSON.parse(data.responseText);
					 	
				  }
			});	
		}
		
		function minus(ProductId){
			$.ajax({
				  type: 'POST',
				  contentType : 'application/json; charset=utf-8',
				  dataType : 'json',
				  data: JSON.stringify({ 
			        "productId": ProductId, 
			        "number": null,
			        "action": 1,
			        "price": null,
			        "image": null,
			        "name": null
			      }),
				  url: 'addToCartJson',
				  complete: function (data) {
					  data = JSON.parse(data.responseText);
					  

				  }
			});	
		}
});
</script>
</body>
</html>