<!DOCTYPE html>
<%@page import="java.util.ResourceBundle"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel = "stylesheet" type = "text/css" href = "./styles.css">
</head>
<body>

<%
	ResourceBundle rb = (ResourceBundle)session.getAttribute("rb");
%>
<form action="Login.do" method="post">
	<input type="hidden" name="formid" value="login">
	
<div class="row row-content">
	<div class="col-md-3">
	</div>
	<div class="col-md-3 ml-3 mt-3">
		  <div class="form-group">
		  <h1 class="font_shadows_into_light"><center><b>Login</b></center></h1>
		    <h4><b> <%=rb.getString("username") %></b></h4>  
		   <input type="text" class="form-control" id="uname" name="uname" placeholder="Enter Username">
		  </div>
	  </div>
  </div>
 <div class="row row-content">
		 <div class="col-md-3">
		</div>
	<div class="col-md-3 ml-3 mt-3">
		  <div class="form-group">
		  <h4><b> <%=rb.getString("password") %></b></h4>  
		    <input type="password" class="form-control" id="upass" name="upass" placeholder="Enter Password">
		  </div>
	 </div>
 </div>
 <div class="row">
	 <div class="col-md-3">
	 </div>
	<div class="col-md-3 ml-3 mt-3">
	 	<center><button type="submit" value="login" class="btn btn-info">Login</button></center>
	 </div>
 </div>
</form>


	<!--  <form action="Login.do" method="post">
	<input type="hidden" name="formid" value="login">
		Username:<input type="text" name="uname">
		Password:<input type="password" name="upass">
		<input type="submit" value="Login">
	</form>-->
</body>
</html>