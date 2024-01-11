 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add Employee</title>
</head>
<body>
    <h1>Add Employee</h1>
    <form action="/library-service/employees/employee/add"method="POST" >
        <table>
            <!-- Form fields for adding an employee -->
            <tr>
                <td>ID:</td>
                <td><input type="text" name="id" /></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" /></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="text" name="email" /></td>
            </tr>
            <tr>
                <td>Age:</td>
                <td><input type="text" name="age" /></td>
            </tr>
            <tr>
                <td>Position:</td>
                <td><input type="text" name="position" /></td>
            </tr>
            <tr>
                <td>Address 1:</td>
                <td><input type="text" name="address.address1" /></td>
            </tr>
            <tr>
                <td>Address 2:</td>
                <td><input type="text" name="address.address2" /></td>
            </tr>
            <tr>
                <td>City:</td>
                <td><input type="text" name="address.city" /></td>
            </tr>
            <tr>
                <td>State:</td>
                <td><input type="text" name="address.state" /></td>
            </tr>
            <tr>
                <td>Country:</td>
                <td><input type="text" name="address.country" /></td>
            </tr>
            <tr>
                <td>Zip:</td>
                <td><input type="text" name="address.zip" /></td>
            </tr>
            
            <!-- Add other fields as needed -->
            <tr>
                <td colspan="2"><input type="submit" value="Add " /></td>
            </tr>
        </table>
    </form>
    <br>
    <a href="/library-service/employees/">Back to Employee List</a>
</body>
</html>
