<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Employee</title>
</head>
<body>
<h3>${HeaderStatus}</h3>
<h1>Add New Employee</h1>
<form action="add">
	<h3>Enter Name : <input type="text" name="empName"/></h3>
	<h3>Enter Phone: <input type="text" name="empPhoneNum"/></h3>
	<input type="submit" value="create"/>
</form> 

	

</body>
</html>