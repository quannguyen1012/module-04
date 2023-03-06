<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<form method="get" action="/convert">
    <input type="number" name="number">

    <select name="currency">
        <option value="VND">VND</option>
        <option value="USD">USD</option>
    </select>

    <input type="submit" value="convert">
</form>

<p c:if result="${result}">
    <p>My salary is:  <c:out value = "${result}"/><p>
</p>
</body>
</html>