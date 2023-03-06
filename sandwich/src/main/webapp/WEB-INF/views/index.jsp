<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
    <h1>Sandwich Condiment</h1>

    <form action="/save" method="post">
        <b>
        <input type="checkbox" value="Lettuce" name="condiment">Lettuce
        <input type="checkbox" value="Tomato" name="condiment">Tomato
        <input type="checkbox" value="Mustard" name="condiment">Mustard
        <input type="checkbox" value="Sprouts" name="condiment">Sprouts</b>
        <hr>
        <input type="submit" value="Save">
    </form>

    <h3>${result}</h3>

</body>
</html>