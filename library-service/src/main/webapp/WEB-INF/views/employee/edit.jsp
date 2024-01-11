<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Employee</title>
</head>


<body>
    <h1>Edit Employee</h1>
    <form action="/library-service/employees/employee/edit/${employee.id}" method="post" >
        <input type="hidden" name="id" value="${employee.id}">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${employee.name}" required><br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="${employee.email}" required><br>
        <label for="age">Age:</label>
        <input type="number" id="age" name="age" value="${employee.age}" required><br>
        <label for="position">Position:</label>
        <input type="text" id="position" name="position" value="${employee.position}" required><br>
        <label for="address1">Address 1:</label>
        <input type="text" id="address1" name="address.address1" value="${employee.address.address1}" required><br>
        
        <label for="address2">Address 2:</label>
        <input type="text" id="address2" name="address.address2" value="${employee.address.address2}"><br>
        
        <label for="city">City:</label>
        <input type="text" id="city" name="address.city" value="${employee.address.city}" required><br>
        
        <label for="state">State:</label>
        <input type="text" id="state" name="address.state" value="${employee.address.state}" required><br>
        
        <label for="country">Country:</label>
        <input type="text" id="country" name="address.country" value="${employee.address.country}" required><br>
        
        <label for="zip">Zip:</label>
        <input type="text" id="zip" name="address.zip" value="${employee.address.zip}" required><br>
        <input type="hidden" name="_method" value="PUT">
        <input type="submit" value="Save">
    </form>
    <a href="/library-service/employees/">Back to List</a>
</body>
</html>