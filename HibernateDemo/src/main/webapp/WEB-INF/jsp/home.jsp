 <%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList, model.Employee" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Page</title>
</head>
<body>
Impelsys Home Page!! 
<%
	ArrayList<Employee> empList = (ArrayList)request.getAttribute("empList");
	Long empCount =(Long) request.getAttribute("empCount");
	if(empCount==null)
		empCount=(Long)pageContext.getAttribute("empCount",pageContext.APPLICATION_SCOPE);
	//	int noOfpages =empCount!=null?(int)Math.ceil(empCount/10):0;s
	int noOfpages = empCount!=null?(int)Math.ceil(empCount/10):0;
	int rem= empCount!=null?(int)(empCount%10):0;
	  /* if(rem>0)
		noOfpages++;  */
	
   /*  boolean isFirstCall =(boolean) request.getAttribute("firstCall");
	if(isFirstCall)
	//	pageContext.setAttribute("noOfpages",noOfpages,pageContext.APPLICATION_SCOPE);
		pageContext.setAttribute("empCount",empCount,pageContext.APPLICATION_SCOPE);  */
	
		
%>
<table>


	<% 
	/*  pageContext.setAttribute("eid",1);
	int eid=pageContext.getAttribute(eid); */  
	if(empList!=null)
	{
		for(Employee emp : empList)
		{
			
				out.println("<tr><td>" +emp.getEmpName() + "</td></tr>"); 
				out.println("<tr><td>" +emp.getEmpId() + "</td></tr>"); 
				//emp.getDepartment().getDeptName(); 
		}	
		
		/* out.println("<tr><td>" +emp.getEmpName() + "</td></tr>"); 
		out.println("<tr><td>" +emp.getEmpId() + "</td></tr>"); 
		out.println("<tr><td>" +emp.getGender() + "</td></tr>"); 
		out.println("<tr><td>" +emp.getExperience() + "</td></tr>");  */
		
	}%>
</table>
<br>
<%-- <h2>Using jstl Core taglib to Print list</h2>
	<ul>
		<c:forEach items="${empList}" var="emp">
		<c:set var="eid" scope="session" value="10"/>  <!--pageContext.setAttribute  -->
		<c:set var="ename" scope="session" value="${emp.empName}"/>
		
		<c:if test="${eid==emp.empId}">
			<li>${emp.empName }</li>
			<li>${emp.dob }</li>
			<li>${emp.empId}</li>
			<li>${emp.gender}</li>
			<li>${emp.experience}</li>	
			<li>${emp.department.deptName}</li>
			
		</c:if>
		
		<c:choose>
		<c:when test="${emp.salary}<=10000">
		Salary is at starting range
		</c:when>
		
		<c:when test="${emp.salary>10000 && emp.salary<=30000}">
		Salary is at middle range
		</c:when>
		
		<c:otherwise>
		No Comments
		</c:otherwise>
		 </c:choose>
		 <c:remove var="eid"/>
		 <c:out value="${eid}"></c:out>
		</c:forEach>
	
	</ul>  --%>
	
<%--  <%ArrayList<Integer> empList1 = (ArrayList)request.getAttribute("empList1");%>
	<h2>Using jstl Core taglib to Print list</h2>
	<ul>
		<c:forEach items="${empList1}" var="sal">
			<li>${sal}</li>
			</c:forEach>
			</ul> --%>
	
	<a href="display.jsp">Check Attributes</a>
	<p>Hibernate Pagination</p>
	<%
		for(int i=1;i<=noOfpages;i++){ %>
		<a href="http://<%=request.getServerName() %>:<%=request.getServerPort()%>
		/HibernateDemo/employee/getPage/<%= i%>">Page<%= i%> 
	<a href="http://<%=request.getServerName() %>:<%=request.getServerPort()%>
		/HibernateDemo/employee/getPage/<%= i+1%>"></a> Page<%=i+1 %> </a>
	<%
		}
	%>
	 
	 <%-- <c:forEach var="i" begin="1" end="${noOfpages}">
		<a href="getPage/${i}">Page ${i}</a> &nbsp;
		
	</c:forEach>  --%>
</body>
</html>