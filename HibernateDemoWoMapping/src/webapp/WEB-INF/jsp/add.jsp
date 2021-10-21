<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="springform" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Employee</title>
<style>

</style>
</head>
<body>


    <springform:form action="add" modelAttribute="emp" method="POST">
	<springform:errors path="*"  cssClass="error" />
	<br><br>
	<springform:label path="empId" >Employee Id: </springform:label>
	<springform:input path="empId" />
		<br><br>
	<springform:label path="empName" >Employee Name: </springform:label>
	<springform:input path="empName" />
		<br><br>
	<springform:label path="empPhoneNum" >Employee Phone: </springform:label>
	<springform:input path="empPhoneNum" />
			<br><br>
	<springform:label path="experience" >Emp Experience:</springform:label>
	<springform:input path="experience" />
	<br><br>
	<springform:label path="dob">DOB (dd/mm/yyyy):</springform:label>
	<springform:input path="dob"   cssClass="datepicker" />
	<br><br>
	<input type="submit" value="Add Employee" >
	
</springform:form> 

</body>
</html>