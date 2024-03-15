<%@ page contentType="text/html; charset=ISO-8859-1" isELIgnored="false"%> 
<%@ taglib uri="jakarta.tags.core" prefix="c"%> 
 
<html> 
<head> 
 
<link type="text/css" rel="stylesheet" href="css/style.css"> 
 
<style> 
 
  table {
      border-collapse: collapse;
      width: 80%;
      margin: 20px auto;
      background-color: white; /* Set the background color of the table to white */
    }

    table, th, td {
      border: 1px solid #696969;
      padding: 8px;
      text-align: left;
    }
    

    th {
      background-color: #696969;
      color: #696969;
    }

    
          .delete-button {
            padding: 6px 12px;
            background-color: #ff0000;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }


        .delete-button:hover {
            background-color: #cc3d27;
        }
        .view-button {
            background-color: black;
            color: white;
            padding: 5px 10px;
            text-decoration: none;
            border-radius: 4px;
        }
</style> 
</head> 
<body> 
 
 <%@ include file="adminnavbar.jsp" %>
 
<br> 
 
<h3 align="center"><u>Update Status</u></h3> 
 
<table align=center  border=2>  
<tr bgcolor="black" style="color:white"> 
<td>ID</td> 
<td>NAME</td> 
<td>DEPARTMENT</td> 
<td>LOCATION</td> 
<td>EMAIL ID</td> 
<td>CONTACT NO</td> 
<td>Status</td> 
<td>ACTION</td>
</tr> 
 
<c:forEach items="${empdata}"  var="emp"> 
<tr> 
<td><c:out value="${emp.id}" /></td> 
<td><c:out value="${emp.name}" /></td> 
<td><c:out value="${emp.department}" /></td> 
<td><c:out value="${emp.location}" /></td> 
<td><c:out value="${emp.email}" /></td> 
<td><c:out value="${emp.contact}" /></td> 

<c:if test="${emp.active==true}">
<td bgcolor="green">ACTIVE</td>
</c:if>
<c:if test="${emp.active==false}">
<td bgcolor="red">INACTIVE</td>
</c:if>

<td>
<a class="view-button" href='<c:url value="setstatus?id=${emp.id}&status=true"></c:url>'>Active</a>
<a class="view-button" href='<c:url value="setstatus?id=${emp.id}&status=false"></c:url>'>Inactive</a>
</td>
 
</tr> 
</c:forEach> 
 
</table> 
 
</body> 
</html>