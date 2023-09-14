<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Delete Book</title>
</head>
<body>
    <h1>Delete Book</h1>
    <p>Are you sure you want to delete the following book?</p>
    <p><strong>Title:</strong> ${book.title}</p>
    <p><strong>Author:</strong> ${book.author}</p>
    <p><strong>ISBN:</strong> ${book.isbn }</p>
    
    <form action="/library-service/books/book/delete/${book.id}" method="post">
    <input type="hidden" name="_method" value="DELETE">
        <input type="submit" value="Delete">
    </form>
    
    <a href="/library-service/books/">Cancel</a>
</body>
</html>
