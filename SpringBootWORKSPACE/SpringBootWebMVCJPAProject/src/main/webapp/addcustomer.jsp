<%@ page contentType="text/html; charset=ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="jakarta.tags.core" prefix="c"%> 

<html>
<head>

<link type="text/css" rel="stylesheet" href="css/style.css">

<style>

</style>
</head>
<body>

<%@ include file="adminnavbar.jsp" %>

<br>
<span class="blink">
<h3 align=center  style="color:red">${message}</h3>
</span>

<h3 align=center><u>Add Customer</u></h3>

<br>

<form:form modelAttribute="customer" method="post" action="insertcustomer">

<table align=center>

<tr>
<td><label>Name</label></td>
<td>
<form:input path="name" required="required"></form:input>
</td>
</tr>

<tr><td></td></tr>

<tr>
<td><label>Gender</label></td>
<td>
<form:radiobutton path="gender" value="Male" required="required"/>Male
<form:radiobutton path="gender" value="Female" required="required"/>Female
</td>
</tr>


<tr><td></td></tr>


<tr>
<td><label>Email ID</label></td>
<td><form:input path="email" required="required"/></td>
</tr>

<tr><td></td></tr>


<tr>
<td><label>Password</label></td>
<td><form:password path="password" required="required"/></td>
</tr>

<tr><td></td></tr>

<tr>
<td><label>Address</label></td>
<td>
<form:textarea path="address" required="required"/>
</td>
</tr>

<tr><td></td></tr>


<tr>
<td><label>Contact No</label></td>
<td><form:input path="contactno" required="required"/></td>
</tr>

<tr><td></td></tr>
<tr><td></td></tr>

<tr align=center>
<td colspan=2><input type="submit" value="Add" class="button"></td>
</tr>

</table>

</form:form>

 
<table align=center  border=2>  
<tr bgcolor="black" style="color:white"> 
<td>ID</td> 
<td>NAME</td> 
<td>GENDER</td> 
<td>EMAIL ID</td> 
<td>Address</td> 
<td>CONTACT NO</td> 
</tr> 
 
<c:forEach items="${customerdata}"  var="cus"> 
<tr> 
<td><c:out value="${cus.id}" /></td> 
<td><c:out value="${cus.name}" /></td> 
<td><c:out value="${cus.gender}" /></td> 
<td><c:out value="${cus.email}" /></td> 
<td><c:out value="${cus.address}" /></td> 
<td><c:out value="${cus.contactno}" /></td> 

 
</tr> 
</c:forEach> 
 
</table> 

</body>

</html>