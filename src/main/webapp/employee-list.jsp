<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee List</title>
</head>
<body>
    <h2>Employees</h2>
    <a href="employees?action=new">Add New Employee</a>
    <br><br>

    <table border="1" cellpadding="8">
        <tr>
            <th>ID</th><th>Name</th><th>Email</th><th>Department</th><th>Salary</th><th>Actions</th>
        </tr>
        <c:forEach var="emp" items="${employeeList}">
            <tr>
                <td>${emp.id}</td>
                <td>${emp.name}</td>
                <td>${emp.email}</td>
                <td>${emp.department}</td>
                <td>${emp.salary}</td>
                <td>
                    <a href="employees?action=edit&id=${emp.id}">Edit</a> |
                    <a href="employees?action=delete&id=${emp.id}" onclick="return confirm('Delete this employee?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
