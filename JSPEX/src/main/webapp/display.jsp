<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
int number = Integer.parseInt(request.getParameter("number"));

if(number%2==0){
	out.print("Number is prime");
}
else{
	out.print("Number is not prime");
}

//session.setAttribute("sessionId", user);
//response.sendRedirect("show.jsp");
%>
</body>
</html>