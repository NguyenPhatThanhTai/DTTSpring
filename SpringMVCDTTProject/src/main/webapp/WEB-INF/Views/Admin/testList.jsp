<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Department List</title>
</head>
<body>
	<form action="deptList" method="post">
		<label for="fname">Id:</label> <input type="text" id="fname" name="id"><br>
		<br> <label for="lname">Name:</label> <input type="text"
			id="lname" name="name"><br>
		<br> <label for="lname">Note:</label> <input type="text"
			id="lname" name="note"><br>
		<br> <input type="submit" value="Submit">
	</form>
	<div align="center">
		<h1>Department List</h1>
		<table border="1">
			<th>Dept No</th>
			<th>Dept Name</th>
			<th>Dept Name</th>

			<c:forEach var="item" items="${test}" varStatus="status">
				<tr>
					<td>${item.id}</td>
					<td>${item.name}</td>
				</tr>
			</c:forEach>

		</table>
	</div>
</body>
</html>