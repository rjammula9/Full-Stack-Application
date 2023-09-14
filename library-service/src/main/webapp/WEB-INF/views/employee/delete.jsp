 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Delete Employee</title>
</head>
<body>
    <h1>Delete Employee</h1>
    <p>Are you sure you want to delete the employee with ID ${employee.id} - ${employee.name}?</p>
    <p><strong>Name:</strong> ${employee.name}</p>
    <p><strong>Email:</strong> ${employee.email}</p>
    <p><strong>Age:</strong> ${employee.age }</p>
    <p><strong>Position:</strong>${employee.position }</p>
    <p><strong>Address:</strong></p>
    <p><strong>Address 1:</strong> ${employee.address.address1}</p>
    <p><strong>Address 2:</strong> ${employee.address.address2}</p>
    <p><strong>City:</strong> ${employee.address.city}</p>
    <p><strong>State:</strong> ${employee.address.state}</p>
    <p><strong>Country:</strong> ${employee.address.country}</p>
    <p><strong>Zip:</strong> ${employee.address.zip}</p>
    <form action="/library-service/employees/employee/delete/${employee.id}" method="post">
    <input type="hidden" name="_method" value="DELETE">
        <input type="submit" value="Delete">
    </form>
    
    <a href="/library-service/employees/">Cancel</a>
</body>
</html>
