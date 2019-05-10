<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="teste.css">
<title>Main</title>
<script>
	function buttonCRUD(){
		window.location = "ClientController?action=listClient";
	}
	function buttonList(){
		window.location = "http://localhost:8080/xseed_crud/List.jsp";
	}
	function buttonLogout(){
		window.location = "http://localhost:8080/xseed_crud/Login.jsp";
	}
</script>
</head>
<body>
	<h1>MENU</h1>
	<input type="button" value="Logout" onclick="buttonLogout()" class="btn btn-md btn-warning Logout"/>
	<div class="buttons">
		<input type="button" value="CRUD" onclick="buttonCRUD()" class="btn btn-md btn-primary CRUD"/>
		<input type="button" value="List" onclick="buttonList()" class="btn btn-md btn-primary List"/>
	</div>
</body>
</html>