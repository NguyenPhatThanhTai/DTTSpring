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
<!-- css -->
<link rel="stylesheet"
	href="<c:url value="/resources/CSS/signup.css" />">
<!-- jQuery -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"
	integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<link
	href="https://getbootstrap.com/docs/5.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<section class="Form my-4 mx-5">
		<div class="container">
			<div class="row no-gutters">
				<div class="col-lg-5">
					<img
						src="<c:url value="/resources/IMG/z3289482746415_6ccb059ec661861329893058a3622956.jpg" />"
						class="img-fluid" alt="">
				</div>
				<div class="col-lg-7 px-5 pt-4">
					<h1 class="font-weight-bold py-3">DTT Store</h1>
					<h4>Đăng ký ngay</h4>
					<form method="POST" action="Register"
						modelAttribute="RegisterRequest">
						<div class="form-row">
							<div class="col-lg-7">
								<input type="email" name="Email" placeholder="Địa chỉ Email"
									class="form-control my-3 p-4">
							</div>
						</div>
						<div class="form-row">
							<div class="col-lg-7">
								<input type="password" name="Token" placeholder="Mật khẩu"
									class="form-control my-3 p-4">
							</div>
						</div>
						<div class="form-row">
							<div class="col-lg-7">
								<input type="text" name="Address" placeholder="Địa chỉ"
									class="form-control my-3 p-4">
							</div>
						</div>
						<div class="form-row">
							<div class="col-lg-7">
								<input type="tel" name="Phone" placeholder="Số điện thoại"
									class="form-control my-3 p-4">
							</div>
						</div>
						<div class="form-row">
							<div class="col-lg-7">
								<input type="submit" value="Đăng ký ngay"
									class="btn-login mt-3 mb-5">
							</div>
							<p>
								Bạn đã có tài khoản ? <a href="/Login">Đăng nhập ngay</a>
							</p>
						</div>
					</form>
				</div>
			</div>
		</div>
</body>
</html>