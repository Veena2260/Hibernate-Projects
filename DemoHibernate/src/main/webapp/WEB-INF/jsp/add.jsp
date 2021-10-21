<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
    <%@taglib uri="http://www.springframework.org/tags/form"
    	prefix="springform" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.error{
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Employee</title>
</head>
<body>
<h3>${HeaderStatus}</h3>
<h1>Add New Employee</h1>
<!-- <form action="add">
	<h3>Enter Name : <input type="text" name="empName"/></h3>
	<h3>Enter Phone: <input type="text" name="empPhoneNum"/></h3>
	<input type="submit" value="Create"/>
</form> -->
<springform:form action="add" modelAttribute="emp" method="POST">
	<%-- <springform:errors path="errors" cssClass="error"/> --%>
    <springform:errors path="empName" cssClass="error"/> 
	<br><br>
	<springform:label path="empName">Employee Name </springform:label>
	<springform:input path="empName" type="text"/>
	<br><br>
	<springform:errors path="empPhoneNum" cssClass="error"/> 
	<springform:label path="empPhoneNum">Employee Phone Num </springform:label>
	<springform:input path="empPhoneNum" />
	<springform:label path="age">Employee Age </springform:label>
	<springform:input path="age" />
	<springform:label path="dateOfBirth">Employee DOB </springform:label>
	<springform:input path="dateOfBirth" type="date" cssClass="date-picker"/>
	<br><br>
	<springform:label path="empExperience">Employee Experience </springform:label>
	<springform:input path="empExperience" />
	
	<input type="submit" value="Submit"/>
</springform:form>
	

</body>
</html>