
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Listing product</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="/sandwich"  >
    <label>rau-dếp</label>
    <input type="checkbox" name="condiment" value="trung">
    <label>cà-chua</label>
    <input type="checkbox" name="condiment" value="thit">
    <label>mù-tạc</label>
    <input type="checkbox" name="condiment" value="banhmy">
    <label>rau-dếp</label>
    <input type="checkbox" name="condiment"  value="xúc-xích">
    <input type="submit" value="save">
</form>
<h3>đã chọn : ${condiment}</h3>
</body>
</html>