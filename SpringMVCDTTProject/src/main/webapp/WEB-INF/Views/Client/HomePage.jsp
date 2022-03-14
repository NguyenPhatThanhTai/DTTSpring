<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
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
    <!-- logo -->
    <link rel="icon" href="<c:url value="/resources/IMG/logo.png" />">
    <!-- css -->
    <link rel="stylesheet" href="<c:url value="/resources/CSS/app.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/CSS/grid.css" />">
</head>
<body>
    <!-- hero section -->
    <div class="hero">
        <div class="slider">
            <div class="container">
                <!-- slide item -->
                <div class="slide active">
                    <div class="info">
                        <div class="info-content">
                            <h3 class="top-down">
                                BAG CAROL PINK
                            </h3>
                            <h2 class="top-down trans-delay-0-2">
                                Next-gen design
                            </h2>
                            <p class="top-down trans-delay-0-4">
                                Sản phẩm phù hợp cho giới trẻ. Màu sắc cá tính, trẻ trung cùng với thiết kế đậm chất tươi mới. Khiến cho nhiều anh em phải ngước nhìn.
                            </p>
                            <div class="top-down trans-delay-0-6">
                                <button class="btn-flat btn-hover">
                                    <span>mua ngay</span>
                                </button>
                            </div>
                        </div>
                    </div>
                    <div class="img top-down">
                        <img src="<c:url value="/resources/IMG/bag6.jpg" />" alt="">
                    </div>
                </div>
                <!-- end slide item -->
                <!-- slide item -->
                <div class="slide">
                    <div class="info">
                        <div class="info-content">
                            <h3 class="top-down">
                                BAG TUNE HORIZON
                            </h3>
                            <h2 class="top-down trans-delay-0-2">
                                New trending
                            </h2>
                            <p class="top-down trans-delay-0-4">
                                Sản phẩm phù hợp cho giới trẻ. Màu sắc cá tính, trẻ trung cùng với thiết kế đậm chất tươi mới. Khiến cho nhiều anh em phải ngước nhìn.
                            </p>
                            <div class="top-down trans-delay-0-6">
                                <button class="btn-flat btn-hover">
                                    <span>mua ngay</span>
                                </button>
                            </div>
                        </div>
                    </div>
                    <div class="img right-left">
                        <img src="<c:url value="/resources/IMG/bag12.jpg" />" alt="">
                    </div>
                </div>
                <!-- end slide item -->
                <!-- slide item -->
                <div class="slide">
                    <div class="info">
                        <div class="info-content">
                            <h3 class="top-down">
                                BAG YOUNG YELLOW
                            </h3>
                            <h2 class="top-down trans-delay-0-2">
                                Simple is good
                            </h2>
                            <p class="top-down trans-delay-0-4">
                                Sản phẩm phù hợp cho giới trẻ. Màu sắc cá tính, trẻ trung cùng với thiết kế đậm chất tươi mới. Khiến cho nhiều anh em phải ngước nhìn.
                            </p>
                            <div class="top-down trans-delay-0-6">
                                <button class="btn-flat btn-hover">
                                    <span>mua ngay</span>
                                </button>
                            </div>
                        </div>
                    </div>
                    <div class="img left-right">
                        <img src="<c:url value="/resources/IMG/bag14.jpg" />" alt="">
                    </div>
                </div>
                <!-- end slide item -->
            </div>
            <!-- slider controller -->
            <button class="slide-controll slide-next">
                <i class='bx bxs-chevron-right'></i>
            </button>
            <button class="slide-controll slide-prev">
                <i class='bx bxs-chevron-left'></i>
            </button>
            <!-- end slider controller -->
        </div>
    </div>
    <!-- end hero section -->

    <!-- promotion section -->
    <div class="promotion">
        <div class="row">
            <div class="col-4 col-md-12 col-sm-12">
                <div class="promotion-box">
                    <div class="text">
                        <h3>Balo</h3>
                        <button class="btn-flat btn-hover"><span>xem ngay</span></button>
                    </div>
                    <img src="<c:url value="/resources/IMG/bagbgrm_bg.png" />" alt="">
                </div>
            </div>
            <div class="col-4 col-md-12 col-sm-12">
                <div class="promotion-box">
                    <div class="text">
                        <h3>Túi xách</h3>
                        <button class="btn-flat btn-hover"><span>xem ngay</span></button>
                    </div>
                    <img src="<c:url value="/resources/IMG/tuixachfgd_ccexpress.png" />" alt="">
                </div>
            </div>
            <div class="col-4 col-md-12 col-sm-12">
                <div class="promotion-box">
                    <div class="text">
                        <h3>Túi đeo chéo</h3>
                        <button class="btn-flat btn-hover"><span>xem ngay</span></button>
                    </div>
                    <img src="<c:url value="/resources/IMG/bagrmbg_removebg.png" />" alt="">
                </div>
            </div>
        </div>
    </div>
    <!-- end promotion section -->

    <!-- product list -->
    <div class="section">
        <div class="container">
            <div class="section-header">
                <h2>Sản phẩm mới nhất</h2>
                <h1>${test.size()}</h1>
            </div>
            <div class="row" id="latest-products">
            
            	<c:forEach var="item" items="${list_product_recomment}" varStatus="status">
	            		 <div class="col-3 col-md-6 col-sm-12">
		                    <div class="product-card">
		                        <div class="product-card-img">
		                            <img src="${item.productDetail.img_Cover}" alt="">
		                            <img src="${item.productDetail.img_Hover}" alt="">
		                        </div>
		                        <div class="product-card-info">
		                            <div class="product-btn">
		                                <a href="Detail-Product/${item.id}"></a>
		                                <button class="btn-flat btn-hover btn-shop-now"><a href="Detail-Product/${item.id}">xem ngay</a></button>
		                                <button class="btn-flat btn-hover btn-cart-add">
		                                    <i class='bx bxs-cart-add'></i>
		                                </button>
		                                <button class="btn-flat btn-hover btn-cart-add">
		                                    <i class='bx bxs-heart'></i>
		                                </button>
		                            </div>
		                            <div class="product-card-name">
		                                ${item.productDetail.name}
		                            </div>
		                            <div class="product-card-price">
		                                <span><del>${item.productDetail.price + (item.productDetail.price)/2}</del></span>
		                                <span class="curr-price">${item.productDetail.price}</span>
		                            </div>
		                        </div>
		                    </div>
		                </div>
	             </c:forEach>
            </div>
            <div class="section-footer">
                <a href="All-Products/1" class="btn-flat btn-hover">xem tất cả</a>
            </div>
        </div>
    </div>
    <!-- end product list -->

    <!-- special product -->
    <div class="bg-second">
        <div class="section container">
            <div class="row">
                <div class="col-4 col-md-4">
                    <div class="sp-item-img">
                        <img src="<c:url value="/resources/IMG/tuixachfgd_ccexpress.png" />" alt="">
                    </div>
                </div>
                <div class="col-7 col-md-8">
                    <div class="sp-item-info">
                        <div class="sp-item-name">SIMPLE SERIES</div>
                        <p class="sp-item-description">
                            Sản phẩm phù hợp cho giới trẻ. Màu sắc cá tính, trẻ trung cùng với thiết kế đậm chất tươi mới. Khiến cho nhiều anh em phải ngước nhìn.
                        </p>
                        <button class="btn-flat btn-hover">xem ngay</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- end special product -->

    <!-- product list -->
    <div class="section">
        <div class="container">
            <div class="section-header">
                <h2>bán chạy nhất</h2>
            </div>
            <div class="row" id="best-products">
            	<c:forEach var="item" items="${list_bestSeller_product}" varStatus="status">
	                <div class="col-3 col-md-6 col-sm-12">
	                    <div class="product-card">
	                        <div class="product-card-img">
	                            <img src="${item.productDetail.img_Cover}" alt="">
	                            <img src="${item.productDetail.img_Hover}" alt="">
	                        </div>
	                        <div class="product-card-info">
	                            <div class="product-btn">
	                                <button class="btn-flat btn-hover btn-shop-now">xem ngay</button>
	                                <button class="btn-flat btn-hover btn-cart-add">
	                                    <i class='bx bxs-cart-add'></i>
	                                </button>
	                                <button class="btn-flat btn-hover btn-cart-add">
	                                    <i class='bx bxs-heart'></i>
	                                </button>
	                            </div>
	                            <div class="product-card-name">
	                                ${item.productDetail.name}
	                            </div>
	                            <div class="product-card-price">
	                                <span><del>${item.productDetail.price + (item.productDetail.price)/2}</del></span>
	                                <span class="curr-price">${item.productDetail.price}</span>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	             </c:forEach>
            </div>
            <div class="section-footer">
                <a href="./products.html" class="btn-flat btn-hover">xem tất cả</a>
            </div>
        </div>
    </div>
    <!-- end product list -->

    <!-- blogs -->
    <div class="section">
        <div class="container">
            <div class="section-header">
                <h2>bài viết mới nhất</h2>
            </div>
            <div class="blog">
                <div class="blog-img">
                    <img src="<c:url value="/resources/IMG/thub0403.jpg" />" alt="">
                </div>
                <div class="blog-info">
                    <div class="blog-title">
                        Sản phẩm bán chạy nhất tháng 3
                    </div>
                    <div class="blog-preview">
                        Sản phẩm phù hợp cho giới trẻ. Màu sắc cá tính, trẻ trung cùng với thiết kế đậm chất tươi mới. Khiến cho nhiều anh em phải ngước nhìn.
                    </div>
                    <button class="btn-flat btn-hover">đọc tiếp</button>
                </div>
            </div>
            <div class="blog row-revere">
                <div class="blog-img">
                    <img src="<c:url value="/resources/IMG/THUMB.jpg" />" alt="">
                </div>
                <div class="blog-info">
                    <div class="blog-title">
                        Sản phẩm nổi bật tháng 4
                    </div>
                    <div class="blog-preview">
                        Sản phẩm phù hợp cho giới trẻ. Màu sắc cá tính, trẻ trung cùng với thiết kế đậm chất tươi mới. Khiến cho nhiều anh em phải ngước nhìn.
                    </div>
                    <button class="btn-flat btn-hover">đọc tiếp</button>
                </div>
            </div>
            <div class="section-footer">
                <a href="#" class="btn-flat btn-hover">xem tất cả</a>
            </div>
        </div>
    </div>
    <!-- end blogs -->


    <!-- app js -->
    <script src="<c:url value="/resources/JS/app.js" />"></script>
    <script src="<c:url value="/resources/JS/index.js" />"></script>
</body>
</html>