<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>DTT Store - Balo Shop</title>
    <!-- icon -->
    <link rel="shortcut icon" href="./images/TTDStore_logo.png" type="image/x-icon">
	<link href='https://fonts.googleapis.com/css?family=Lato:300,400|Montserrat:700' rel='stylesheet' type='text/css'>
	<style>
		@import url(//cdnjs.cloudflare.com/ajax/libs/normalize/3.0.1/normalize.min.css);
		@import url(//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css);
        
        .gohome{
            margin-top: 20px;
            text-align: center;
            width: 160px;
            height: 60px;
            background-color: black;
            border: none;
            cursor: pointer;
            border-radius: 4px;
        }
        .gohome:hover {
            border: 1px solid black;
            background-color: #fff;
            border-radius: 4px;
        }
        .gohome:hover p{
            color: black;
        }
        .gohome p{
            color: #fff;
        }
        .gohome a{
            text-decoration: none;
            font-weight: 600;
        }
	</style>
	<link rel="stylesheet" href="https://2-22-4-dot-lead-pages.appspot.com/static/lp918/min/default_thank_you.css">
	<script src="https://2-22-4-dot-lead-pages.appspot.com/static/lp918/min/jquery-1.9.1.min.js"></script>
	<script src="https://2-22-4-dot-lead-pages.appspot.com/static/lp918/min/html5shiv.js"></script>
</head>
<body>
	<header class="site-header" id="header">
		<h1 class="site-header__title" data-lead-id="site-header-title">CẢM ƠN!</h1>
	</header>

	<div class="main-content">
		<i class="fa fa-check main-content__checkmark" id="checkmark"></i>
		<p class="main-content__body" data-lead-id="main-content-body">Xin cảm ơn vì đã tin tưởng vào dịch vụ của chúng tôi.</p>
	</div>

    <div class="go-to-home">
        <p class="main-content__body" data-lead-id="main-content-body">Về trang chủ ngay</p>
        <button class="gohome" type="button">
            <a href="/SpringMVCDTTpProject/">
                <p>TRANG CHỦ</p>
            </a>
        </button>
    </div>
	
</body>
</html>