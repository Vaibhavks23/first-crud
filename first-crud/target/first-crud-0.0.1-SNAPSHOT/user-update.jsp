<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update</title>
</head>
<body>

<form method = "Get" action="user-update">
	
		<label for="empid">EMP-ID:</label><br> <input type="number"	id="empid" name="empid" value = "<c:out value="${user.emp_id}" />" readonly><br> 
	
		<label for="name">Name:</label><br><input type="text" id="name" name="name" value = "<c:out value="${user.name}" />"><br> 
			
			<label for="age">Age:</label><br> <input type="number" id="age"name="age" value ="<c:out value="${user.age}" />"><br>
			
			 <label for="position">position:</label><br> <input type="text" id="position" name="position" value = "<c:out value="${user.position}" />"><br> 
		
		
				<input type="submit" value="Submit">
				</form>

</body>
</html>