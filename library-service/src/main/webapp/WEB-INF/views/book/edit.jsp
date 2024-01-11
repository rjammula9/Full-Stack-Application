<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edit Book</title>
</head>
<body>
    <h1>Edit Book</h1>
    
    <form:form action="/library-service/books/book/edit/${book.id}" method="post" modelAttribute="book">
        <table>
            <tr>
           "     <td>ID: </td>
                <td>${book.id}</td>
                <td><input type="hidden" name="id" value="${book.id}" /></td>
            </tr>
            <tr>
                <td>Title:</td>
                <td><form:input path="title" required="true"/></td>
            </tr>
            <tr>
                <td>Author:</td>
                <td><form:input path="author" required="true"/></td>
            </tr>
             <tr>
                <td>ISBN:</td>
                <td><form:input path="isbn" required="true"/></td>
            </tr>
        </table>
         <input type="hidden" name="_method" value="PUT">
        <input type="submit" value=Save">
    </form:form>
    
    <a href="/library-service/books/">Cancel</a>
</body>
</html>
