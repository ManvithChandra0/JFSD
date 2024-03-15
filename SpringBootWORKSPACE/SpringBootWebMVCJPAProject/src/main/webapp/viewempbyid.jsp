<%@ page contentType="text/html; charset=ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c1" %>

<html>
<head>
    <link type="text/css" rel="stylesheet" href="css/style.css">
<style>
    .card {
        border: 2px solid black; 
        border-radius: 10px; 
        padding: 20px; 
        margin: 20px; 
        box-shadow: 0 4px 12px 0 rgba(0, 0, 0, 0.2); 
        max-width: 400px; 
        background-color: dimgray; 
        color: white;
    }

    .card-title {
        font-weight: bold;
        font-size: 18px;
        margin-bottom: 10px; 
    }
</style>

</head>
<body>
    <%@ include file="adminnavbar.jsp" %>

    <div class="card">
       ID : ${emp.id}<br>
Name : ${emp.name}<br>
Gender : ${emp.gender}<br>
DateofBirth : ${emp.dateofbirth}<br>
Department : ${emp.department}<br>
Salary : ${emp.salary}<br>
Email : ${emp.email}<br>
Location : ${emp.location}<br>
Contact No : ${emp.contact}<br>
Status : ${emp.active}
    </div>
</body>
</html>
