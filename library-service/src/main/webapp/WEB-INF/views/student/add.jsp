 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add a Student</title>
</head>
<body>
    <h1>Add a Student</h1>
    
    <form action="/library-service/students/student/add" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br>
        
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>
        
        <label for="age">Age:</label>
        <input type="number" id="age" name="age" required><br>
        
        <input type="submit" value="Add ">
    </form>
    
    <p><a href="/library-service/students/">Back to Student List</a></p>
</body>
</html>
