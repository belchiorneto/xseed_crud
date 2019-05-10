<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
%>
<%@ page import="java.sql.*" %> 
<%@ page import="java.io.*" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="telaLogin.*"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="teste2.css">
<title>List</title>
<script>
	function buttonBack(){
		window.location = "http://localhost:8080/menu_teste/Main.jsp";
	}
</script>
</head>
<body>
	<form method="get", name="lista">
	<h1>List</h1>
	<input type="button" value="Back" onclick="buttonBack()" class="btn btn-md btn-warning Back"/>
	<table class="table table-bordered table-striped table-hover">
		<thead>
			<tr>
				<th class="text-center">Nome</th>
				<th class="text-center">Endereço</th>
				<th class="text-center">Crédito</th>
				<th class="text-center">Validade</th>
			</tr>
		</thead>
		<%
			List<ClienteModel> lista = DaoClient.getInstancia().pesquisar();
			String nome, endereco;
			Double credito;
			Date validade;
			for(int i=0; i<lista.size(); i++){
				nome = lista.get(i).getName();
				endereco = lista.get(i).getAdress();
				credito = lista.get(i).getCredit();
				validade = lista.get(i).getExpiration();
		%>
		<tr>
			<td><%=nome %></td>
			<td><%=endereco %></td>
			<td><%=credito %></td>
			<td><%=validade %></td>
		</tr>
		<%}
		%>
	</table>
	</form>
</body>
</html>