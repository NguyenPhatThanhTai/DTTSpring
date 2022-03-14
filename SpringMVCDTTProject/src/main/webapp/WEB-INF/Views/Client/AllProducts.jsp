<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DTT Store</title>
    <!-- google font -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,900&display=swap" rel="stylesheet">
    <!-- boxicons -->
    <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
    <!-- logo -->
    <link rel="icon" href="images/logo.png">
    <!-- app css -->
    <link rel="stylesheet" href="<c:url value="/resources/CSS/grid.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/CSS/products.css" />">

</head>
<body>
	<!-- products content -->
    <div class="bg-main">
        <div class="container">
            <div class="box">
                <div class="breadcumb">
                    <a href="./index.html">trang chủ</a>
                    <span><i class='bx bxs-chevrons-right'></i></span>
                    <a href="./products.html">tất cả sản phẩm</a>
                </div>
            </div>
            <div class="box">
                <div class="row">
                    <div class="col-3 filter-col" id="filter-col">
                        <div class="box filter-toggle-box">
                            <button class="btn-flat btn-hover" id="filter-close">đóng</button>
                        </div>
                        <div class="box">
                            <span class="filter-header">
                                Danh mục
                            </span>
                            <ul class="filter-list">
                                <li><a href="#">Balo</a></li>
                                <li><a href="#">Túi xách</a></li>
                                <li><a href="#">Túi đeo chéo</a></li>
                            </ul>
                        </div>
                        <div class="box">
                            <span class="filter-header">
                                Giá tiền
                            </span>
                            <div class="price-range">
                                <input type="text">
                                <span>-</span>
                                <input type="text">
                            </div>
                        </div>
                        <div class="box">
                            <ul class="filter-list">
                                <li>
                                    <div class="group-checkbox">
                                        <input type="checkbox" id="status1">
                                        <label for="status1">
                                            Đang hạ giá
                                            <i class='bx bx-check'></i>
                                        </label>
                                    </div>
                                </li>
                                <li>
                                    <div class="group-checkbox">
                                        <input type="checkbox" id="status2">
                                        <label for="status2">
                                            Có sẵn
                                            <i class='bx bx-check'></i>
                                        </label>
                                    </div>
                                </li>
                                <li>
                                    <div class="group-checkbox">
                                        <input type="checkbox" id="status3">
                                        <label for="status3">
                                            Đặc biệt
                                            <i class='bx bx-check'></i>
                                        </label>
                                    </div>
                                </li>
                            </ul>
                        </div>
                        <div class="box">
                            <span class="filter-header">
                                Nhãn hiệu
                            </span>
                            <ul class="filter-list">
                                <li>
                                    <div class="group-checkbox">
                                        <input type="checkbox" id="remember1" checked="checked">
                                        <label for="remember1">
                                            Yame
                                            <i class='bx bx-check'></i>
                                        </label>
                                    </div>
                                </li>
                                <li>
                                    <div class="group-checkbox">
                                        <input type="checkbox" id="remember2">
                                        <label for="remember2">
                                            S1mple
                                            <i class='bx bx-check'></i>
                                        </label>
                                    </div>
                                </li>
                                <li>
                                    <div class="group-checkbox">
                                        <input type="checkbox" id="remember3">
                                        <label for="remember3">
                                            Horizon
                                            <i class='bx bx-check'></i>
                                        </label>
                                    </div>
                                </li>
                                <li>
                                    <div class="group-checkbox">
                                        <input type="checkbox" id="remember4">
                                        <label for="remember4">
                                            Carol
                                            <i class='bx bx-check'></i>
                                        </label>
                                    </div>
                                </li>
                                <li>
                                    <div class="group-checkbox">
                                        <input type="checkbox" id="remember5">
                                        <label for="remember5">
                                            Key
                                            <i class='bx bx-check'></i>
                                        </label>
                                    </div>
                                </li>
                            </ul>
                        </div>
                        <div class="box">
                            <span class="filter-header">
                                Colors
                            </span>
                            <ul class="filter-list">
                                <li>
                                    <div class="group-checkbox">
                                        <input type="checkbox" id="remember1">
                                        <label for="remember1">
                                            Black
                                            <i class='bx bx-check'></i>
                                        </label>
                                    </div>
                                </li>
                                <li>
                                    <div class="group-checkbox">
                                        <input type="checkbox" id="remember2">
                                        <label for="remember2">
                                            Pink
                                            <i class='bx bx-check'></i>
                                        </label>
                                    </div>
                                </li>
                                <li>
                                    <div class="group-checkbox">
                                        <input type="checkbox" id="remember3">
                                        <label for="remember3">
                                            White
                                            <i class='bx bx-check'></i>
                                        </label>
                                    </div>
                                </li>
                                <li>
                                    <div class="group-checkbox">
                                        <input type="checkbox" id="remember4">
                                        <label for="remember4">
                                            Grey
                                            <i class='bx bx-check'></i>
                                        </label>
                                    </div>
                                </li>
                                <li>
                                    <div class="group-checkbox">
                                        <input type="checkbox" id="remember5">
                                        <label for="remember5">
                                            Blue
                                            <i class='bx bx-check'></i>
                                        </label>
                                    </div>
                                </li>
                            </ul>
                        </div>
                        <div class="box">
                            <span class="filter-header">
                                Đánh giá
                            </span>
                            <ul class="filter-list">
                                <li>
                                    <div class="group-checkbox">
                                        <input type="checkbox" id="remember1">
                                        <label for="remember1">
                                            <span class="rating">
                                                <i class='bx bxs-star'></i>
                                                <i class='bx bxs-star'></i>
                                                <i class='bx bxs-star'></i>
                                                <i class='bx bxs-star'></i>
                                                <i class='bx bxs-star'></i>
                                            </span>
                                            <i class='bx bx-check'></i>
                                        </label>
                                    </div>
                                </li>
                                <li>
                                    <div class="group-checkbox">
                                        <input type="checkbox" id="remember1">
                                        <label for="remember1">
                                            <span class="rating">
                                                <i class='bx bxs-star'></i>
                                                <i class='bx bxs-star'></i>
                                                <i class='bx bxs-star'></i>
                                                <i class='bx bxs-star'></i>
                                                <i class='bx bx-star'></i>
                                            </span>
                                            <i class='bx bx-check'></i>
                                        </label>
                                    </div>
                                </li>
                                <li>
                                    <div class="group-checkbox">
                                        <input type="checkbox" id="remember1">
                                        <label for="remember1">
                                            <span class="rating">
                                                <i class='bx bxs-star'></i>
                                                <i class='bx bxs-star'></i>
                                                <i class='bx bxs-star'></i>
                                                <i class='bx bx-star'></i>
                                                <i class='bx bx-star'></i>
                                            </span>
                                            <i class='bx bx-check'></i>
                                        </label>
                                    </div>
                                </li>
                                <li>
                                    <div class="group-checkbox">
                                        <input type="checkbox" id="remember1">
                                        <label for="remember1">
                                            <span class="rating">
                                                <i class='bx bxs-star'></i>
                                                <i class='bx bxs-star'></i>
                                                <i class='bx bx-star'></i>
                                                <i class='bx bx-star'></i>
                                                <i class='bx bx-star'></i>
                                            </span>
                                            <i class='bx bx-check'></i>
                                        </label>
                                    </div>
                                </li>
                                <li>
                                    <div class="group-checkbox">
                                        <input type="checkbox" id="remember1">
                                        <label for="remember1">
                                            <span class="rating">
                                                <i class='bx bxs-star'></i>
                                                <i class='bx bx-star'></i>
                                                <i class='bx bx-star'></i>
                                                <i class='bx bx-star'></i>
                                                <i class='bx bx-star'></i>
                                            </span>
                                            <i class='bx bx-check'></i>
                                        </label>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-9 col-md-12">
                        <div class="box filter-toggle-box">
                            <button class="btn-flat btn-hover" id="filter-toggle">lọc</button>
                        </div>
                        <div class="box">
                            <div class="row" id="products">
                            <c:forEach var="item" items="${all_product}" varStatus="status">
                   	            <div class="col-4 col-md-6 col-sm-12">
					                <div class="product-card">
					                    <div class="product-card-img">
					                        <img src="${item.productDetail.img_Cover}" alt="">
					                        <img src="${item.productDetail.img_Hover}" alt="">
					                    </div>
					                    <div class="product-card-info">
					                        <div class="product-btn">
					                            <a href="./product-detail.html" class="btn-flat btn-hover btn-shop-now"><a href="Detail-Product/${item.id}">xem ngay</a></a>
					                            <button class="btn-flat btn-hover btn-cart-add">
					                                <i class='bx bxs-cart-add'></i>
					                            </button>
					                            <button class="btn-flat btn-hover btn-cart-add">
					                                <i class='bx bxs-heart'></i>
					                            </button>
					                        </div>
					                        <div class="product-card-name">
					                            ${item.id}
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
                        </div>
                        <div class="box">
                            <ul class="pagination">
                                <li><a href="#"><i class='bx bxs-chevron-left'></i></a></li>
                                <c:forEach begin="1" end="${count_product}" varStatus="loop">
                                    <li><a href="../All-Products/${loop.index}" class="${loop.index == current_page ? "active" : ""}">${loop.index}</a></li>
								</c:forEach>
                                <!-- <li><a href="#" class="active">1</a></li>
                                <li><a href="#">2</a></li>
                                <li><a href="#">3</a></li>
                                <li><a href="#">4</a></li>
                                <li><a href="#">5</a></li> -->
                                <li><a href="#"><i class='bx bxs-chevron-right'></i></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- end products content -->
    <script src="<c:url value="/resources/JS/products.js" />"></script>
</body>
</html>