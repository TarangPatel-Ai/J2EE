<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ page import="com.caltech.pojo.*" %>
  <%@ page import="com.caltech.dao.*" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Student student = new Student();
student.setSid(Integer.parseInt(request.getParameter("id")));
student.setSname(request.getParameter("name"));
student.setSemail(request.getParameter("email"));

StudentDAO dao = new StudentDAO();
try {
	if(dao.insertStudentintodb(student)>0) {
		response.sendRedirect("display.jsp");
	}
} 
catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
%>
</body>
</html>