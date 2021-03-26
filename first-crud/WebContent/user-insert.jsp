<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<b> Add Details <br></b>

</head>
<meta charset="UTF-8">
<title>Add Details</title>
</head>
<body>

	<form method = "Get" action="user-insert">
	
		<label for="empid">EMP-ID:</label><br> <input type="number"	id="empid" name="empid"><br> 
			
			<label for="name">Name:</label><br><input type="text" id="name" name="name"><br> 
			
			<label for="age">Age:</label><br> <input type="number" id="age"name="age"><br>
			
			 <label for="position">position:</label><br> <input type="text" id="position" name="position"><br> 
		
		
		<input type="submit" value="Submit">
	</form>

</body>
</html>