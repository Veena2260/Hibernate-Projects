 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   
    <%@page import="java.util.ArrayList, model.Employee" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html 4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Page</title>
</head>
<body>
Home Page
<%
	ArrayList<Employee> empList=(ArrayList)request.getAttribute("empList");
	Long empCount=(Long)request.getAttribute("empCount");
	int noOfpages=empCount!=null?(int)Math.ceil(empCount/10):pageContext.getAttribute("noOfPages",pageContext.APPLICATION_SCOPE);
	boolean isFirstCall=(boolean)request.getAttribute("firsCall");
	
	if (isFirstCall)	
	pageContext.setAttribute("noOfPages", noOfpages,pageContext.APPLICATION_SCOPE);
	
%>
<table>
 <%
    pageContext.setAttribute("eid", "11"); 
    String eid = pageContext.getAttribute("eid"); 
	  for(Employee emp : empList) {
		 if(emp.getEmpId().equals(eid)){
			out.println("<tr><td>"+emp.getEmpName() +"</td></tr>"); 
		 }
    }  %>        
   
</table>  

    <h2>using jstl Core taglib to print list</h2>
    <ul>
        <c:forEach items="${empList}" var="emp">
         <c:set var="eid" scope="session" value="1"/>
        <c:set var="ename" scope="session" value="${emp.empName}"/>
        <c:if test="${eid==emp.empId}"> 
            <li>${emp.empName }</li>
            <li>${emp.dob }</li>
            <li>${emp.empId}</li>
            <li>${emp.gender}</li>
            <li>${emp.experience}</li>
            <li>${emp.salary}</li>
            </c:if>   
          <c:choose> 
         <c:when test="${emp.salary <= 10000}">
         	Salary is at the starting range
         </c:when>
          <c:when test="${emp.salary > 20000}"> && ${emp.salary <= 30000}">
         	Salary is at the middle range
         </c:when> 
         
         <c:otherwise>
        	 No comments!!
         </c:otherwise>
          </c:choose>
         <c:remove var="eid"/>
         <c:out value="${eid}"></c:out>
        </c:forEach>
    
    </ul>
 <%-- <% ArrayList<Integer> empList1 = (ArrayList)request.getAttribute("empList1");%>
	 <h2>using jstl Core taglib to print list</h2> --%>
    <%-- <ul>
        <c:forEach items="${empList1}" var="sal">
        
            <li>${sal}</li>
 
    	</c:forEach>
    	</ul> --%>
 <a href="display.jsp">display</a> 
 <a href="prev">Prev</a>
 <a href="update">update</a>
 
 <p> Hibernate Pagination</p>
 <%
	for(int i=1;i<=noOfpages;i++){%>
	<a href="http://<%=request.getServerName() %>:<%=request.getServerPort() %>/employee/getPage/<%=i%>">Page <%=i %></a>/&nbsp; 
	<%
	}	
	%> 

 <c:forEach var="i" begin="1" end="${noOfpages}">
 	<a href="getPage/${i}">Page ${i} </a>/&nbsp;
 </c:forEach>
</body>
</html>
