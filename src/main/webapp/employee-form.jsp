<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Form</title>
</head>
<body>
    <h2>
        <c:choose>
            <c:when test="${not empty employee}">Edit Employee</c:when>
            <c:otherwise>New Employee</c:otherwise>
        </c:choose>
    </h2>

    <form action="employees" method="post">
        <input type="hidden" name="action" value="${empty employee ? 'insert' : 'update'}">
        <c:if test="${not empty employee}">
            <input type="hidden" name="id" value="${employee.id}">
        </c:if>

        <label>Name:</label><br>
        <input type="text" name="name" value="${employee.name}" required><br><br>

        <label>Email:</label><br>
        <input type="email" name="email" value="${employee.email}" required><br><br>

        <label>Department:</label><br>
        <input type="text" name="department" value="${employee.department}" required><br><br>

        <label>Salary:</label><br>
        <input type="number" name="salary" step="0.01" value="${employee.salary}" required><br><br>

        <button type="submit">Save</button>
        <a href="employees">Cancel</a>
    </form>
</body>
</html>

<!-- "${expression}" -->
