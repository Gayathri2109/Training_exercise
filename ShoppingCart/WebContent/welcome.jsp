<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel = "stylesheet" type = "text/css" href = "./styles.css">
<title>Welcome Page</title>
</head>
<body>
<h2>	<div class="font_shadows_into_light">
        <p>Welcome,<%=session.getAttribute("uname") %></p>
      </div></h2>
	
	<hr><jsp:include page="logout.jsp"></jsp:include><hr>
	<form action="Shopping.do" method="post">
	<input type="hidden" name="formid" value="shopping">
		<center><button type="submit" value="Shopping" class="btn btn-info">Shopping</button></center>
	
	</form>
</body>
</html>