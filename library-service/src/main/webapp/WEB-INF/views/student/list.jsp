 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>List of Students</title>
</head>
<body>
    <h1>List of Students</h1>
    
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Age</th>
            <th>Actions</th>
        </tr>
        
        <c:forEach items="${students}" var="student">
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.email}</td>
                <td>${student.age}</td>
                <td>
                    <a href="/library-service/students/student/edit/${student.id}">Edit</a> 
                    </td>
                    <td>|
                    <a href="/library-service/students/student/delete/${student.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    
    <p><a href="/library-service/student/add">Add New Student</a> </p>

</body>
</html>
