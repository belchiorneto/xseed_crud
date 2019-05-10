<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CRUD</title>

</head>
<body>
	<form action="http://localhost:8080/menu_teste/Main.jsp">
    	<input type="submit" value="Back">
	</form>	
	<table>
		<c:forEach items="${clients}" var="client">
			<tr>
				<td><c:out value="${client.name}" /></td>
			    <td><c:out value="${client.adress}" /></td>
			    <td><fmt:formatDate pattern="dd/MM/YYYY" value="${client.expiration}" /></td>
                <td><c:out value="${client.credit}" /></td>
	            <td><a href="ClientController?action=updateClient&id=<c:out value="${client.id}"/>">Update</a></td>
	            <td><a href="ClientController?action=deleteClient&id=<c:out value="${client.id}"/>">Delete</a></td>
	        </tr>
        </c:forEach>
        <tr>
	        <form action="ClientController?action=add" method="post">
		        <td><input type="text" name="name"></td>
		        <td><input type="text" name="address"></td>
		        <td><input type="text" name="expiration"></td>
		        <td><input type="number" name="credit"></td>
		        <td><input type="submit" value="incluir"></td>
	        </form>
        </tr>
	</table>
</body>
</html>