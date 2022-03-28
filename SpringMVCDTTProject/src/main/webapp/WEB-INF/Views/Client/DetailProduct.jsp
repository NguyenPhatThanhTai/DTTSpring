<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>DTT Store</title>
<!-- google font -->
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,900&display=swap"
	rel="stylesheet">
<!-- boxicons -->
<link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css'
	rel='stylesheet'>
<!-- logo -->
<link rel="icon" href="<c:url value="/resources/IMG/logo.png" />">
<!-- app css -->
<link rel="stylesheet" href="<c:url value="/resources/CSS/grid.css" />">
<link rel="stylesheet"
	href="<c:url value="/resources/CSS/product-detail.css" />">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"
	integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</head>
<body>
	<!-- product-detail content -->
	<div class="bg-main">
		<div class="container">
			<div class="box">
				<div class="breadcumb">
					<a href="./index.html">trang chủ</a> <span><i
						class='bx bxs-chevrons-right'></i></span> <a href="./products.html">tất
						cả sản phẩm</a> <span><i class='bx bxs-chevrons-right'></i></span> <a
						href="./product-detail.html">${product_detail.productDetail.name}</a>
				</div>
			</div>
			<div class="row product-row">
				<div class="col-5 col-md-12">
					<div class="product-img" id="product-img">
						<img src="${product_detail.productDetail.img_Detail1}" alt="">
					</div>
					<div class="box">
						<div class="product-img-list">
							<div class="product-img-item">
								<img src="${product_detail.productDetail.img_Detail2}" alt="">
							</div>
							<div class="product-img-item">
								<img src="${product_detail.productDetail.img_Detail3}" alt="">
							</div>
							<div class="product-img-item">
								<img src="${product_detail.productDetail.img_Detail4}" alt="">
							</div>
						</div>
					</div>
				</div>
				<div class="col-7 col-md-12">
					<div class="product-info">
						<h1>${product_detail.productDetail.name}</h1>
						<div class="product-info-detail">
							<span class="product-info-detail-title">Nhãn hiệu:</span> <a
								href="#">${product_detail.manufacturers.name}</a>
						</div>
						<div class="product-info-detail">
							<span class="product-info-detail-title">Đánh giá:</span> <span
								class="rating"> <i class='bx bxs-star'></i> <i
								class='bx bxs-star'></i> <i class='bx bxs-star'></i> <i
								class='bx bxs-star'></i> <i class='bx bxs-star'></i>
							</span>
						</div>
						<p class="product-description">Sản phẩm phù hợp cho giới trẻ.
							Màu sắc cá tính, trẻ trung cùng với thiết kế đậm chất tươi mới.
							Khiến cho nhiều anh em phải ngước nhìn.</p>
						<div class="product-info-price">${product_detail.productDetail.price}
							VND</div>
						<div class="product-quantity-wrapper">
							<span class="product-quantity-btn"> <i class='bx bx-minus'></i>
							</span> <span class="product-quantity">1</span> <span
								class="product-quantity-btn"> <i class='bx bx-plus'></i>
							</span>
						</div>
						<div>
							<button class="btn-flat btn-hover">Thêm vào giỏ hàng</button>
						</div>
					</div>
				</div>
			</div>
			<div class="box">
				<div class="box-header">Chi tiết sản phẩm</div>
				<div class="product-detail-description">
					<button class="btn-flat btn-hover btn-view-description"
						id="view-all-description">view all</button>
					<div class="product-detail-description-content">
						<p>${product_detail.productDetail.description}</p>
					</div>
				</div>
			</div>
			<div class="box">
				<div class="box-header">
					Nhận xét
					<div class="star-rate-user">
						<ul class="rate-area">
							<input type="radio" class="getRating" id="5-star" name="rating"
								value="5" />
							<label for="5-star" title="Amazing">5 stars</label>
							<input type="radio" class="getRating" id="4-star" name="rating"
								value="4" />
							<label for="4-star" title="Good">4 stars</label>
							<input type="radio" class="getRating" id="3-star" name="rating"
								value="3" />
							<label for="3-star" title="Average">3 stars</label>
							<input type="radio" class="getRating" id="2-star" name="rating"
								value="2" />
							<label for="2-star" title="Not Good">2 stars</label>
							<input type="radio" class="getRating" id="1-star" name="rating"
								value="1" />
							<label for="1-star" title="Bad">1 star</label>
						</ul>
						<input type="hidden" id="number-of-star">
					</div>
				</div>
				<!-- comment box -->
				<div class="comment-box">
					<img class="rounded-circle"
						src="/resources/IMG/223072445_1268702413600772_1982050020744284137_n.jpg"
						width="50">
					<textarea id="comment-input" class="comment-input"></textarea>
				</div>
				<div class="btn-comment">
					<button id="sentComment" class="btn-postcmt" type="button">Đăng
						bình luận</button>
					<button id="unSent" class="btn-cancel" type="button">Hủy</button>
				</div>
				<!-- end comment box -->

				<!-- load all comment -->
				<div id="loadComment"></div>
			</div>
		</div>
		<div class="box">
			<div class="box-header">Sản phẩm liên quan</div>
			<div class="row" id="related-products"></div>
		</div>
	</div>
	</div>
	<!-- end product-detail content -->
	<script type="text/javascript">
	    $(document).ready(function() {
	    	getAllComment();
	    	
	        $(".getRating").on("click", function(){
	            $("#number-of-star").val($(this).val());
	        })
	        
	        $("#sentComment").on("click", function(){
		    	$.ajax({
		    		  type: 'POST',
		    		  contentType : 'application/json; charset=utf-8',
		    		  dataType : 'json',
		    		  data: JSON.stringify({ 
	    		        "prodId": '${product_id}', 
	    		        "content": $("#comment-input").val(),
	    		        "start": $("#number-of-star").val()
	    		      }),
		    		  url: '../sendComment',
		    		  complete: function (data) {
		    			  data = JSON.parse(data.responseText);
		    			  
		    			  if(data.isSuccess){
		    				  getAllComment();
		    			  }
		    			  else{
		    				  alert("Gửi bình luận thất bại!")
		    			  }
		    		  }
		    	});	
	        })
	    	
	    	function getAllComment(){
        		$("#loadComment").html("");
		    	$.ajax({
		    		  type: 'GET',
		    		  dataType:"jsonp",
		    		  url: '../viewCommentJson?prodId=' + '${product_id}',
		    		  complete: function (data) {
		    			  data = JSON.parse(data.responseText);
		    			  data.forEach(function(item){
		    				  
		    				  var startNumberRate = '';
		    				  
		    				  for(var i = 0; i < item.start; i++){
		    					  startNumberRate += '<i class="bx bxs-star"></i>';
		    				  }
		    				  
			    		    	var cmtTemplate = 
			    		    		'<div class="user-rate">' +
		                        		'<div class="user-info">' +
		                            		'<div class="user-avt">' +
		                                		'<img src="<c:url value="/resources/IMG/223072445_1268702413600772_1982050020744284137_n.jpg" />" alt="">' +
		                            		'</div>' + 
		                            		'<div class="user-name">' + 
		                                		'<span class="name">'+item.name+'</span>' + 
		                                		'<span class="rating">' + 
		                                			startNumberRate + 
		                                		'</span>' +
		                            		'</div>' +
		                            	'</div>' +
		                        		'<div class="user-rate-content">' +
		                            		item.content +
		                        		'</div>' + 
	                        		'</div>';
			    		    	$("#loadComment:last").append(cmtTemplate);
		    			  })
		    		  }
		    	});	
	    	}
	    });
    </script>
</body>
</html>