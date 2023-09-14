<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add a Book</title>
</head>
<body>
    <h1>Add a Book</h1>
    <form action="/library-service/books/book/add" method="post">
        <label for="title">Title:</label>
        <input type="text" id="title" name="title" required><br>
        <label for="author">Author:</label>
        <input type="text" id="author" name="author" required><br>
        <label for="ISBN">ISBN:</label>
        <input type="text" id="ISBN" name="isbn" required><br>
        <input type="submit" value="Add">
        
    </form>
</body>
</html>
