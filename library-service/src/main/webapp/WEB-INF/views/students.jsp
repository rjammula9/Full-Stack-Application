
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Student List</title>
</head>
<body>
    <h1>Student List</h1>
     <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Age</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>

        <c:forEach var="student" items="${students}" >
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.email}</td>
                <td>${student.age}</td>
                <td>
                    <a href="/library-service/students/student/edit/${student.id}">Edit</a>
                </td>
                <td>
                    <a href="/library-service/students/student/delete/${student.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <p>
        <a href="/library-service/students/student/add">Add New Student Details</a>
    </p>
    <p>
        <a href="/library-service/employees/">Employees</a>
    </p>
    <p>
        <a href="/library-service/books/">Books</a>
    </p>
</body>
</html>