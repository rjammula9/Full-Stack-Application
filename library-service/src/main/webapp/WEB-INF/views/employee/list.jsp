<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List Employees</title>
</head>
<body>
    <h1>List of Employees</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Age</th>
            <th>Position</th>
            <th>Address 1</th>
            <th>Address 2</th>
            <th>City</th>
            <th>State</th>
            <th>Country</th>
            <th>Zip</th>
            <th>Actions</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${employees}" var="employee">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.name}</td>
                <td>${employee.email}</td>
                <td>${employee.age}</td>
                <td>${employee.position}</td>
                <td>${employee.address.address1}</td>
                <td>${employee.address.address2}</td>
                <td>${employee.address.city}</td>
                <td>${employee.address.state}</td>
                <td>${employee.address.country}</td>
                <td>${employee.address.zip}</td>
                <td>
                    <a href="/library-service/employees/employee/edit/${employee.id}">Edit</a>
                    <a href="/library-service/employees/employee/delete/${employee.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="/library-service/employee/add/">Add Employee</a>
</body>
</html>
