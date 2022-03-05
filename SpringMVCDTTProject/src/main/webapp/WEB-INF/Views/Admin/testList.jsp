<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
 <head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <title>Department List</title>
 </head>
 <body>
     <div align="center">
         <h1>Department List</h1>
         <table border="1">
             <th>Dept No</th>
             <th>Dept Name</th>
             <th>Location</th>
           
             <c:forEach var="item" items="${test}" varStatus="status">
             <tr>
                 <td>${item.id}</td>
                 <td>${item.name}</td>
                 <td>${item.note}</td>
                 <c:forEach var="two" items="${item.two}" varStatus="status">
		             <tr>
                          	<td>${item.id}</td>
                 			<td>${item.name}</td>
		                 	<td>${two.note}</td>                         
		             </tr>
             	</c:forEach>                      
             </tr>
             </c:forEach>
                       
         </table>
     </div>
 </body>
</html>