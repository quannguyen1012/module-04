<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
  <title>Create a new employee</title>
  <style>
    .error {
      color: red;
    }
  </style>
</head>
<body>
<h3>Welcome, Enter The Employee Details</h3>
<form:form method="POST" action="/employee/addEmployee" modelAttribute="employee">
  <table>
    <tr>
      <td><form:label path="id">Employee ID: </form:label></td>
      <td>
        <form:input path="id"/>
        <form:errors path="id" cssClass="error"/>
      </td>
    </tr>
    <tr>
      <td><form:label path="name" >Employee's name: </form:label></td>
      <td>
        <form:input path="name"/>
        <form:errors path="name" cssClass="error"/>
      </td>
    </tr>
    <tr>
      <td><form:label path="contactNumber">Contact's number: </form:label></td>
      <td>
        <form:input path="contactNumber"/>
        <form:errors path="contactNumber" cssClass="error"/>
      </td>
    </tr>
    <tr>
      <td><input type="submit" value="Submit"/></td>
    </tr>
  </table>
</form:form>
</body>
</html>