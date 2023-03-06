<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
    <form method="get" action="/coculator">
        <input type="number" name="firstN">
        <input type="number" name="secondN">
        <button type="submit" name="addition" value="cong">+</button>
        <button type="submit" name="addition" value="tru">-</button>
        <button type="submit" name="addition" value="nhan">*</button>
        <button type="submit" name="addition" value="chia">/</button>
    </form>

    <h3>ket qua: ${result}</h3>
</body>
</html>