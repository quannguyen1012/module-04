<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<form action="/translate" method="post">
    <label>Insert a Word: </label>
    <input type="text" name="word">
    <input type="submit" value="Search">
</form>
    <h3>
        <c:out value="${result}" />
    </h3>
</body>
</html>