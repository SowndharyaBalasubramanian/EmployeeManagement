<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:set var = "userName" value = "Besant"></c:set>
	<c:set var = "age" value = "45"></c:set>
	<c:set var = "marks" value = "98"></c:set>
	
	<c:out value="${userName}"></c:out>
	
	<c:if test="${age>=18}">
		<p>Major</p>
	</c:if>
	<c:if test="${age<18}">
		<p>Minor</p>
	</c:if>
	
	<c:choose>
		<c:when test = "${marks >= 90 }">
			<p>Grade A </p>
		</c:when>
		
		<c:when test = "${marks >= 80  && marks < 90}">
			<p>Grade B </p>
		</c:when>
		
		<c:otherwise>
			<p>your grade is not mentioned</p>
		</c:otherwise>
	</c:choose>
	
	<c:set var = "numbers" value="10, 20, 30, 40, 50"></c:set>
	<ul>
	<c:forEach var = "num" items = "${numbers}" >
		<li>${num}</li>
	</c:forEach>
	</ul>
	
</body>
</html>