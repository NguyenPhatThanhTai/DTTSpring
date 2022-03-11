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
    <link rel="icon" href="<c:url value="/resources/IMG/logo.png" />">
    <!-- app css -->
    <link rel="stylesheet" href="<c:url value="/resources/CSS/grid.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/CSS/product-detail.css" />">
</head>
<body>
    <!-- product-detail content -->
    <div class="bg-main">
        <div class="container">
            <div class="box">
                <div class="breadcumb">
                    <a href="./index.html">trang chủ</a>
                    <span><i class='bx bxs-chevrons-right'></i></span>
                    <a href="./products.html">tất cả sản phẩm</a>
                    <span><i class='bx bxs-chevrons-right'></i></span>
                    <a href="./product-detail.html">${product_detail.productDetail.name}</a>
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
                        <h1>
                            ${product_detail.productDetail.name}
                        </h1>
                        <div class="product-info-detail">
                            <span class="product-info-detail-title">Nhãn hiệu:</span>
                            <a href="#">${product_detail.manufacturers.name}</a>
                        </div>
                        <div class="product-info-detail">
                            <span class="product-info-detail-title">Đánh giá:</span>
                            <span class="rating">
                                <i class='bx bxs-star'></i>
                                <i class='bx bxs-star'></i>
                                <i class='bx bxs-star'></i>
                                <i class='bx bxs-star'></i>
                                <i class='bx bxs-star'></i>
                            </span>
                        </div>
                        <p class="product-description">
                            Sản phẩm phù hợp cho giới trẻ. Màu sắc cá tính, trẻ trung cùng với thiết kế đậm chất tươi mới. Khiến cho nhiều anh em phải ngước nhìn.
                        </p>
                        <div class="product-info-price">${product_detail.productDetail.price} VND</div>
                        <div class="product-quantity-wrapper">
                            <span class="product-quantity-btn">
                                <i class='bx bx-minus'></i>
                            </span>
                            <span class="product-quantity">1</span>
                            <span class="product-quantity-btn">
                                <i class='bx bx-plus'></i>
                            </span>
                        </div>
                        <div>
                            <button class="btn-flat btn-hover">Thêm vào giỏ hàng</button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="box">
                <div class="box-header">
                    Chi tiết sản phẩm
                </div>
                <div class="product-detail-description">
                    <button class="btn-flat btn-hover btn-view-description" id="view-all-description">
                        view all
                    </button>
                    <div class="product-detail-description-content">
                        <p>
                            Chi tiết bạn cung cấp cho sản phẩm ảnh hưởng đến cách sản phẩm hiển thị với khách hàng, giúp bạn dễ dàng sắp xếp sản phẩm hơn và giúp khách hàng tìm được sản phẩm. Bạn không cần cung cấp mọi chi tiết cho từng sản phẩm.
                            Đối với sản phẩm không có mẫu mã, các mục Định giá, Hàng trong kho và Vận chuyển được hiển thị trên trang chi tiết sản phẩm. Nếu bạn thêm mẫu mã, những mục này sẽ không còn hiển thị trên trang chi tiết sản phẩm nữa. Để thay đổi chi tiết mẫu mã sản phẩm, hãy tham khảo phần Chỉnh sửa mẫu mã đối với sản phẩm hiện có.</p>
                        <img src="<c:url value="/resources/IMG/JBL_Quantum_400_Product Image_Hero 02.png" />" alt="">
                        <p>
                            Chi tiết bạn cung cấp cho sản phẩm ảnh hưởng đến cách sản phẩm hiển thị với khách hàng, giúp bạn dễ dàng sắp xếp sản phẩm hơn và giúp khách hàng tìm được sản phẩm. Bạn không cần cung cấp mọi chi tiết cho từng sản phẩm.
                            Đối với sản phẩm không có mẫu mã, các mục Định giá, Hàng trong kho và Vận chuyển được hiển thị trên trang chi tiết sản phẩm. Nếu bạn thêm mẫu mã, những mục này sẽ không còn hiển thị trên trang chi tiết sản phẩm nữa. Để thay đổi chi tiết mẫu mã sản phẩm, hãy tham khảo phần Chỉnh sửa mẫu mã đối với sản phẩm hiện có.</p>
                        </p>
                        <img src= "<c:url value="/resources/IMG/kisspng-beats-electronics-headphones-apple-beats-studio-red-headphones.png" />" alt="">
                        <p>
                            Sản phẩm phù hợp cho giới trẻ. Màu sắc cá tính, trẻ trung cùng với thiết kế đậm chất tươi mới. Khiến cho nhiều anh em phải ngước nhìn.
                        </p>
                    </div>
                </div>
            </div>
            <div class="box">
                <div class="box-header">
                    Nhận xét
                </div>
                <div>
                    <div class="user-rate">
                        <div class="user-info">
                            <div class="user-avt">
                                <img src="<c:url value="/resources/IMG/223072445_1268702413600772_1982050020744284137_n.jpg" />" alt="">
                            </div>
                            <div class="user-name">
                                <span class="name">Anh Da Den</span>
                                <span class="rating">
                                    <i class='bx bxs-star'></i>
                                    <i class='bx bxs-star'></i>
                                    <i class='bx bxs-star'></i>
                                    <i class='bx bxs-star'></i>
                                    <i class='bx bxs-star'></i>
                                </span>
                            </div>
                        </div>
                        <div class="user-rate-content">
                            Sản phẩm phù hợp cho giới trẻ. Màu sắc cá tính, trẻ trung cùng với thiết kế đậm chất tươi mới. Khiến cho nhiều anh em phải ngước nhìn.
                        </div>
                    </div>
                    <div class="user-rate">
                        <div class="user-info">
                            <div class="user-avt">
                                <img src="<c:url value="/resources/IMG/223072445_1268702413600772_1982050020744284137_n.jpg" />" alt="">
                            </div>
                            <div class="user-name">
                                <span class="name">Anh Da Den</span>
                                <span class="rating">
                                    <i class='bx bxs-star'></i>
                                    <i class='bx bxs-star'></i>
                                    <i class='bx bxs-star'></i>
                                    <i class='bx bxs-star'></i>
                                    <i class='bx bxs-star'></i>
                                </span>
                            </div>
                        </div>
                        <div class="user-rate-content">
                            Sản phẩm phù hợp cho giới trẻ. Màu sắc cá tính, trẻ trung cùng với thiết kế đậm chất tươi mới. Khiến cho nhiều anh em phải ngước nhìn.
                        </div>
                    </div>
                    <div class="user-rate">
                        <div class="user-info">
                            <div class="user-avt">
                                 <img src="<c:url value="/resources/IMG/223072445_1268702413600772_1982050020744284137_n.jpg" />" alt="">
                            </div>
                            <div class="user-name">
                                <span class="name">Anh Da Den</span>
                                <span class="rating">
                                    <i class='bx bxs-star'></i>
                                    <i class='bx bxs-star'></i>
                                    <i class='bx bxs-star'></i>
                                    <i class='bx bxs-star'></i>
                                    <i class='bx bxs-star'></i>
                                </span>
                            </div>
                        </div>
                        <div class="user-rate-content">
                            Sản phẩm phù hợp cho giới trẻ. Màu sắc cá tính, trẻ trung cùng với thiết kế đậm chất tươi mới. Khiến cho nhiều anh em phải ngước nhìn.
                        </div>
                    </div>
                    <div class="user-rate">
                        <div class="user-info">
                            <div class="user-avt">
                                 <img src="<c:url value="/resources/IMG/223072445_1268702413600772_1982050020744284137_n.jpg" />" alt="">
                            </div>
                            <div class="user-name">
                                <span class="name">Anh Da Den</span>
                                <span class="rating">
                                    <i class='bx bxs-star'></i>
                                    <i class='bx bxs-star'></i>
                                    <i class='bx bxs-star'></i>
                                    <i class='bx bxs-star'></i>
                                    <i class='bx bxs-star'></i>
                                </span>
                            </div>
                        </div>
                        <div class="user-rate-content">
                            Sản phẩm phù hợp cho giới trẻ. Màu sắc cá tính, trẻ trung cùng với thiết kế đậm chất tươi mới. Khiến cho nhiều anh em phải ngước nhìn.
                        </div>
                    </div>
                    
                    <div class="box">
                        <ul class="pagination">
                            <li><a href="#"><i class='bx bxs-chevron-left'></i></a></li>
                            <li><a href="#" class="active">1</a></li>
                            <li><a href="#">2</a></li>
                            <li><a href="#">3</a></li>
                            <li><a href="#">4</a></li>
                            <li><a href="#">5</a></li>
                            <li><a href="#"><i class='bx bxs-chevron-right'></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="box">
                <div class="box-header">
                    Sản phẩm liên quan
                </div>
                <div class="row" id="related-products"></div>
            </div>
        </div>
    </div>
    <!-- end product-detail content -->
</body>
</html>