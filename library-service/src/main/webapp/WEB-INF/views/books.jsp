<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>List of Books</title>
</head>
<body>
    <h1>List of Books</h1>

    <table border="1">
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Author</th>
            <th>ISBN</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>

        <c:forEach var="book" items="${books}" >
            <tr>
                <td>${book.id}</td>
                <td>${book.title}</td>
                <td>${book.author}</td>
                <td>${book.isbn}</td>
                <td>
                    <a href="/library-service/books/book/edit/${book.id}">Edit</a>
                </td>
                <td>
                    <a href="/library-service/books/book/delete/${book.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <p>
        <a href="/library-service/books/book/add/">Add New Book</a>
    </p>
    <p>
        <a href="/library-service/employees">Employees</a>
    </p>
    <p>
        <a href="/library-service/students">Students</a>
    </p>
</body>
</html>
