<%@ page contentType="text/html; charset=ISO-8859-1" isELIgnored="false"%> 
<%@ taglib uri="jakarta.tags.core" prefix="c"%> 
 
<html> 
<head> 
 
<link type="text/css" rel="stylesheet" href="css/style.css"> 
 
<style> 
 
 
</style> 
</head> 
<body> 
 
 
<br> 
 
<h3 align="center"><u>View All Events</u></h3> 
 
<table align=center  border=2>  
<tr bgcolor="black" style="color:white"> 
<td>ID</td> 
<td>NAME</td> 
<td>DEPARTMENT</td> 
<td>LOCATION</td> 
<td>EMAIL ID</td> 
<td>CONTACT NO</td> 
<td>ACTION</td>
</tr> 
 
<c:forEach items="${eventdata}"  var="emp"> 
<tr> 
<td><c:out value="${event.id}" /></td> 
<td><c:out value="${event.name}" /></td> 
<td><c:out value="${event.department}" /></td> 
<td><c:out value="${event.location}" /></td> 
<td><c:out value="${event.email}" /></td> 
<td><c:out value="${event.contact}" /></td> 
<td>
<a href='<c:url value="view?id=${emp.id}"></c:url>'>View</a>
</td>
 
</tr> 
</c:forEach> 
 
</table> 
 
</body> 
</html>