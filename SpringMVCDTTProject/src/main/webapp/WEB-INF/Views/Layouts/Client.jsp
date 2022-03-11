<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<decorator:head />
<head>
	<link rel="stylesheet" href="<c:url value="/resources/CSS/header.css" />">
	<link rel="stylesheet" href="<c:url value="/resources/CSS/footer.css" />">
</head>
<body>
    <!-- header -->
    <header>
        <!-- mobile menu -->
        <div class="mobile-menu bg-second">
            <a href="#" class="mb-logo">DTT Store</a>
            <span class="mb-menu-toggle" id="mb-menu-toggle">
                <i class='bx bx-menu'></i>
            </span>
        </div>
        <!-- end mobile menu -->
        <!-- main header -->
        <div class="header-wrapper" id="header-wrapper">
            <span class="mb-menu-toggle mb-menu-close" id="mb-menu-close">
                <i class='bx bx-x'></i>
            </span>
            <!-- top header -->
            <div class="bg-second">
                <div class="top-header container">
                    <ul class="devided">
                        <li>
                            <a href="#">+84345439899</a>
                        </li>
                        <li>
                            <a href="#">dttstore@gmail.com</a>
                        </li>
                    </ul>
                    <ul class="devided">
                        <li class="dropdown">
                            <a href="">VND</a>
                            <i class='bx bxs-chevron-down'></i>
                            <ul class="dropdown-content">
                                <li><a href="#">USD</a></li>
                                <li><a href="#">JPY</a></li>
                                <li><a href="#">EUR</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="">TIẾNG VIỆT</a>
                            <i class='bx bxs-chevron-down'></i>
                            <ul class="dropdown-content">
                                <li><a href="#">ENGLISH</a></li>
                                <li><a href="#">JAPANESE</a></li>
                                <li><a href="#">FRENCH</a></li>
                                <li><a href="#">SPANISH</a></li>
                            </ul>
                        </li>
                        <li><a href="#">THEO DÕI ĐƠN HÀNG</a></li>
                    </ul>
                </div>
            </div>
            <!-- end top header -->
            <!-- mid header -->
            <div class="bg-main">
                <div class="mid-header container">
                    <a href="#" class="logo">DTT Store</a>
                    <div class="search">
                        <input type="text" placeholder="Search">
                        <i class='bx bx-search-alt'></i>
                    </div>
                    <ul class="user-menu">
                        <li><a href="#"><i class='bx bx-bell'></i></a></li>
                        <li><a href="#"><i class='bx bx-user-circle'></i></a></li>
                        <li><a href="#"><i class='bx bx-cart'></i></a></li>
                    </ul>
                </div>
            </div>
            <!-- end mid header -->
            <!-- bottom header -->
            <div class="bg-second">
                <div class="bottom-header container">
                    <ul class="main-menu">
                        <li><a href="#">trang chủ</a></li>
                        <!-- mega menu -->
                        <li class="mega-dropdown">
                            <a href="./products.html">danh mục<i class='bx bxs-chevron-down'></i></a>
                            <div class="mega-content">
                                <div class="row">
                                    <div class="col-3 col-md-12">
                                        <div class="box">
                                            <h3>Balo</h3>
                                            <ul>
                                                <li><a href="#">Space Series Balo</a></li>
                                                <li><a href="#">Big Series Balo</a></li>
                                                <li><a href="#">Fit Series Balo</a></li>
                                                <li><a href="#">Simple Series Balo</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="col-3 col-md-12">
                                        <div class="box">
                                            <h3>Túi xách</h3>
                                            <ul>
                                                <li><a href="#">Space Series</a></li>
                                                <li><a href="#">Big Series</a></li>
                                                <li><a href="#">Fit Series</a></li>
                                                <li><a href="#">Simple Series</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="col-3 col-md-12">
                                        <div class="box">
                                            <h3>Túi đeo chéo</h3>
                                            <ul>
                                                <li><a href="#">Space Series</a></li>
                                                <li><a href="#">Big Series</a></li>
                                                <li><a href="#">Fit Series</a></li>
                                                <li><a href="#">Simple Series</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="col-3 col-md-12">
                                        <div class="box">
                                            <h3>Tất cả sản phẩm</h3>
                                            <ul>
                                                <li><a href="#">Balo</a></li>
                                                <li><a href="#">Túi xách</a></li>
                                                <li><a href="#">Túi đeo chéo</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <div class="row img-row">
                                    <div class="col-3">
                                        <div class="box">
                                            <img src="<c:url value="/resources/IMG/bag7.jpg" />">
                                        </div>
                                    </div>
                                    <div class="col-3">
                                        <div class="box">
                                            <img src="<c:url value="/resources/IMG/bag12.jpg" />">
                                        </div>
                                    </div>
                                    <div class="col-3">
                                        <div class="box">
                                            <img src="<c:url value="/resources/IMG/bag15.jpg" />">
                                        </div>
                                    </div>
                                    <div class="col-3">
                                        <div class="box">
                                            <img src="<c:url value="/resources/IMG/bag11.jpg" />">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <!-- end mega menu -->
                        <li><a href="#">bài viết</a></li>
                        <li><a href="#">liên hệ</a></li>
                    </ul>
                </div>
            </div>
            <!-- end bottom header -->
        </div>
        <!-- end main header -->
    </header>
    <!-- end header -->
	
		<decorator:body />
	
    <!-- footer -->
    <footer class="bg-second">
        <div class="container">
            <div class="row">
                <div class="col-3 col-md-6">
                    <h3 class="footer-head">Sản phẩm</h3>
                    <ul class="menu">
                        <li><a href="#">Trung tâm hỗ trợ</a></li>
                        <li><a href="#">Liên hệ chúng tôi</a></li>
                        <li><a href="#">Hỗ trợ sản phẩm</a></li>
                        <li><a href="#">Bảo hành</a></li>
                    </ul>
                </div>
                <div class="col-3 col-md-6">
                    <h3 class="footer-head">Dịch vụ</h3>
                    <ul class="menu">
                        <li><a href="#">Trung tâm hỗ trợ</a></li>
                        <li><a href="#">Liên hệ chúng tôi</a></li>
                        <li><a href="#">Hỗ trợ sản phẩm</a></li>
                        <li><a href="#">Bảo hành</a></li>
                    </ul>
                </div>
                <div class="col-3 col-md-6">
                    <h3 class="footer-head">Hỗ trợ</h3>
                    <ul class="menu">
                        <li><a href="#">Góp ý</a></li>
                        <li><a href="#">Liên hệ chúng tôi</a></li>
                        <li><a href="#">Hỗ trợ</a></li>
                        <li><a href="#">Bảo hành</a></li>
                    </ul>
                </div>
                <div class="col-3 col-md-6 col-sm-12">
                    <div class="contact">
                        <h3 class="contact-header">
                            DTT Store
                        </h3>
                        <ul class="contact-socials">
                            <li><a href="#">
                                    <i class='bx bxl-facebook-circle'></i>
                                </a></li>
                            <li><a href="#">
                                    <i class='bx bxl-instagram-alt'></i>
                                </a></li>
                            <li><a href="#">
                                    <i class='bx bxl-youtube'></i>
                                </a></li>
                            <li><a href="#">
                                    <i class='bx bxl-twitter'></i>
                                </a></li>
                        </ul>
                    </div>
                    <div class="subscribe">
                        <input type="email" placeholder="Nhập Email của bạn">
                        <button>Đăng ký</button>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- end footer -->
    
    <script src="<c:url value="/resources/JS/header.js" />"></script>
</body>
</html>