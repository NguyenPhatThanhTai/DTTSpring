<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
    <!-- box icons -->
    <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>
    <!-- css -->
    <link rel="stylesheet" href="<c:url value="/resources/CSS/cart.css" />">
    <!-- jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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
		                            <button class="btn-minus btn-hover"><span>-</span></button>
		                            <input id="ascending" type="number" value="${item.number}">
		                            <button class="btn-plus btn-hover"><span>+</span></button>
		                            <h3 class="text-all-price">Tổng tiền: <span class="bg-color-price"><input class="price" type="number" value="${(item.price) * (item.number)}"></span></h3>
		                            <input class="hiddenprice" type="hidden" value="300000">
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
                    <h3>Thành tiền: <span>1.000.000 VND</span></h3>
                    <button class="btn-flat btn-hover complete-cart"><span>Đặt hàng</span></button>
                </div>
            </div>
        </div>
    </div>
</body>
</html>

<script>
    $(document).ready(function() {
        $('.btn-minus').click(function() {
            var $input = $(this).parent().find('#ascending');
            var count = parseInt($input.val()) - 1;
            count = count < 1 ? 1 : count;
            $input.val(count);
            $input.change();
            var price_all_price = $(this).parent().find('.price');
            var totalprice = parseInt(price_all_price.val())-parseInt($(this).parent().find('.hiddenprice').val());
            price_all_price.val(totalprice < parseInt($(this).parent().find('.hiddenprice').val()) ? parseInt($(this).parent().find('.hiddenprice').val()) : totalprice);
            price_all_price.change();
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
            return false;
    });
});
</script>