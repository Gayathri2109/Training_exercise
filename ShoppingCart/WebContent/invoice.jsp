<%@page import="java.util.Enumeration" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="/WEB-INF/mylisttag.tld" prefix="productlist" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Invoice</title>
</head>
<body>
<h1>Thanks for shopping</h1>

	<productlist:list  />
	<form action="files.do" method="post">
	    <input type="submit" name="button1" value="Generate pdf"  class="btn btn-info" />
	    <input type="submit" name="button2" value="Generate Excel"  class="btn btn-info" />
	    <input type="submit" name="button3" value="Send Email"  class="btn btn-info"/>
	    <input type="submit" name="button4" value="Send SMS"  class="btn btn-info"/>
	    <!--   <input type="submit" name="button5" value="Make Payement"  class="btn btn-info"/>-->
	</form>	

</body>
</html>