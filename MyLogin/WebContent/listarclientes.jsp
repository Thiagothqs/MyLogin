<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
	 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Clientes</title>
</head>
<body>
	<c:choose>
		<c:when test = "${not empty listaCliente}">
			<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>NOME</th>
					<th>CPF</th>
					<th>EMAIL</th>
					<th>SENHA</th>
				</tr>
			</thead>
			<c:forEach var="cliente" items="${listaCliente}">
				<tr>
					<td>${cliente.id}</td>
					<td>${cliente.nome}</td>
					<td>${cliente.cpf}</td>
					<td>${cliente.email}</td>
					<td>${cliente.senha}</td>
					<td>
					<a href="/MyLogin/ObterClienteServlet?id=${cliente.id}">Exibir</a> 
					</td>
					<td>
					<a href="/MyLogin/ExcluirClienteServlet?id=${cliente.id}">Excluir</a>
					</td>
				</tr>
			</c:forEach>
			</table>
			<form action="ExcluirClienteServlet" method="post">
				<table>
					<tr>
						<td>Digite o código que da pessoa que você deseja excluir</td> 
						<td><input type="text" name="id" id="id"/></td>
						<td><input type="submit" value="Excluir"/></td>
					</tr>
				</table>
			</form>
			</c:when>
			<c:otherwise>
				<br>
				<div class="alert alert-info">
                	Não tem ninguém
                </div>
			</c:otherwise>
	</c:choose>
</body>
</html>