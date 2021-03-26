<%--Iterator.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User View</title>
</head>
<body>
 <%--Importing all the dependent classes--%>
 <%@page import="com.user.User"%> 
<%@page import="java.util.Iterator"%> 

<c:forEach  items="${users}" var="user">
            
<tr><td>emp_id : </td><td>  <c:out value="${user.emp_id}" /></td></tr>
<tr><td>name  : </td><td><c:out value="${user.name}" /></td></tr>
<tr><td>age    : </td><td><c:out value="${user.age}" /></td></tr>
<tr><td>position : </td><td><c:out value="${user.position}" /></td></tr>

<br><br>
</c:forEach>

</body>
</html>