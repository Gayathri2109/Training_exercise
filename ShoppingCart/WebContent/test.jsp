<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> <% String s = request.getParameter("uname");%> 
	 <% out.println(s);%> </h1>
	 <% LocalDateTime date = LocalDateTime.now();
	 	out.println(date);
	 %>
<h2> <%=request.getParameter("uname") %> </h2>

</body>
</html>