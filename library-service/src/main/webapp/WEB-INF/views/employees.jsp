<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>List of Employees</title>
</head>
<body>
    <h1>List of Employees</h1>

    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Age</th>
            <th>Position</th>
            <th>Address</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>

        <c:forEach var="employee" items="${employees}">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.name}</td>
                <td>${employee.email}</td>
                <td>${employee.age}</td>
                <td>${employee.position}</td>
                <td>
                    ${book.address.address1}, ${book.address.address2}<br>
                    ${book.address.city}, ${book.address.state}, ${book.address.country}<br>
                    ${book.address.zip}
                </td>
                <td>
                    <a href="/library-service/employees/employee/edit/${employee.id}">Edit</a>
                </td>
                <td>
                    <a href="/library-service/employees/employee/delete/${employee.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <p>
        <a href="/library-service/employees/employee/add">Add Employee</a>
    </p>
    <p>
        <a href="/library-service/books">Books</a>
    </p>
    <p>
        <a href="/library-service/students/">Students</a>
    </p>
</body>
</html>