<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Send Email</title>
</head>
<body>
   <c:if test="${not empty message}">
    <div style="color: green; font-weight: bold">
        ${message}
    </div>
</c:if>

<form action="sendWeatherAlerts" method="post">
    <label for="subject">Subject:</label><br>
    <input type="text" id="subject" name="subject"><br><br>
    <label for="message">Message:</label><br>
    <textarea id="message" name="message" rows="4" cols="50"></textarea><br><br>
    <input type="submit" value="Send Alerts">
</form>
</body>
</html>
