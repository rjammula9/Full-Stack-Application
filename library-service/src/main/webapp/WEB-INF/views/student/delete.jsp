<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Delete Student</title>
</head>
<body>
    <h1>Delete Student</h1>
    
    <p>Are you sure you want to delete the following student?</p>
    <p><strong>Name:</strong> ${student.name}</p>
    <p><strong>Email:</strong> ${student.email}</p>
    <p><strong>Age:</strong> ${student.age}</p>
    
    <form action="/library-service/students/student/delete/${student.id}" method="post">
       <input type="hidden" name="_method" value="DELETE">
        <input type="submit" value="Delete">
    </form>
    
    <p><a href="/library-service/students/">Cancel</a></p>
</body>
</html>
