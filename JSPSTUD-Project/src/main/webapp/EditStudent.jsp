<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.caltech.pojo.*" %>
    <%@ page import="com.caltech.dao.*" %> 
    <%@ page import="java.util.*" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String id=request.getParameter("id"); 
StudentDAO dao=new StudentDAO();  %>

		<form action="EditController.jsp">
		<input type='hidden' name='id' value="<%= id %>">
		Enter the student name to be updated <input type='text' name='name'><br><br>
		Enter the student email to be updated <input type='text' name='email'>
		<input type='submit' value='update'></form>

</body>
</html>