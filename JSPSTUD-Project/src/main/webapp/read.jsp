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
StudentDAO dao = new StudentDAO();
List<Student> list = dao.retreiveStudentData();
%>
	<center>
	
	<h1>List of Student Information</h1>
	<a href="index.jsp"><h3>Insert Data</h3></a><br>
	<table border="1" align="center">
	<tr>
		<th>Student Id</th>
		<th>Student Name</th>
		<th>Student Email</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>
	
	<% for(Student student:list) { %>
	<tr>
		<td><%= student.getSid() %></td>
		<td><%= student.getSname() %></td>
		<td><%= student.getSemail() %></td>
		<td><a href="EditStudent.jsp?id=<%= student.getSid() %> ">Edit</a></td>
		<td><a href="DeleteStudent.jsp?id=<%= student.getSid() %> ">Delete</a></td>
	</tr>
	<% } %>
	</table>
    </center>		

</body>
</html>