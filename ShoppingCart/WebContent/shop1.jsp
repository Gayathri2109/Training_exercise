<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/myproducttags.tld" prefix="producttag" %>

  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Jewellery Shop</title>
</head>
<body>
	<h1>Jewellery Shop</h1>
	<form action="shop.do" method="post">
		<input type="hidden" name="formid" value="shop">
		<input type="hidden" name="shopid" value="shop1">
		
		
		
		<%-- <producttag:item category="<%=request.getParameter(\"category\")%>" />--%>
		<producttag:item category="1" />
		
		
		<input type="submit" value="Next">
	</form>


</body>
</html>