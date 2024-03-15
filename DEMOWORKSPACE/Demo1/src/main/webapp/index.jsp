<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- Use fmt:formatNumber to format the temperature -->

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Weather App</title>
</head>
<body>
    <h1>Weather Data</h1>
    <form action="/search" method="post">
        <input type="text" name="city" placeholder="Enter city">
        <button type="submit">Search</button>
    </form>
    
    <c:if test="${not empty weatherData}">
        <h2>Weather for ${weatherData.city}</h2>
        <p>Date: ${weatherData.date}</p>
<p>Temperature: <fmt:formatNumber value="${weatherData.temperature}" pattern="#.#" />°C</p>
        <p>Description: ${weatherData.description}</p>
    </c:if>
</body>
</html>
