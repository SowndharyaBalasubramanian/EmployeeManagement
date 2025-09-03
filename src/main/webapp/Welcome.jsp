<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>
<% 
	String username = (String)request.getAttribute("userName");
Boolean isLoggedIn = (Boolean)request.getAttribute("isLoggedIn");
%>
	<h2>Hello, <%=username %></h2>
	
	<h1> Hello , ${userName}</h1>
	<!-- <p>Number : ${5}</p> -->
	
</body>
</html>