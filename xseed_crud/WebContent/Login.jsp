<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>XSeed - Estágio</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
	<form action="LoginConfere.jsp" method="Post">
	<div class="container">
		<h1>Welcome to Xseed</h1>
		<label for="login"><b>User</b></label>
			<input type="text" class="form-control" placeholder="Name" name="login" required>
			<br>
		<label for="password"><b>Password</b></label>
			<input type="password" class="form-control" placeholder="*****" name="password" required>
			<br>
		<button type="submit" class="btn btn-md btn-primary">Login</button>
		<button type="reset" class="btn btn-md btn-warning">Clear</button>
	</div>	
</form>
</body>
</html>