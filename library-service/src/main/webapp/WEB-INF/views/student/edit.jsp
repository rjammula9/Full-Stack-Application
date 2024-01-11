<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edit Student</title>
</head>
<body>
    <h1>Edit Student</h1>
    
    <form:form action="/library-service/students/student/edit/${student.id}" method="post" modelAttribute="student">
        <table>
            <tr>
                <td>ID:</td>
                <td>${student.id}</td>
                <td><input type="hidden" name="id" value="${student.id}" /></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><form:input path="name" required="true"/></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><form:input path="email" required="true"/></td>
            </tr>
            <tr>
                <td>Age:</td>
                <td><form:input path="age" required="true"/></td>
            </tr>
        </table>
        <input type="hidden" name="_method" value="PUT">
        <input type="submit" value="Save">
    </form:form>
    
    <p><a href="/library-service/students/">Back to Student List</a></p>
</body>
</html>
