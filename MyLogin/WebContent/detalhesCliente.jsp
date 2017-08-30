<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Detalhes do Cliente</title>
</head>
<body>
	<c:choose>
		<c:when test="${not empty cliente}">
			<table>
				<thead>
					<tr>
						<th>ID</th>
						<th>NOME</th>
						<th>CPF</th>
						<th>EMAIL</th>
						<th>SENHA</th>
					</tr>
					<tr>
						<td>${cliente.id}</td>
						<td>${cliente.nome}</td>
						<td>${cliente.cpf}</td>
						<td>${cliente.email}</td>
						<td>${cliente.senha}</td>
						<td>
							<a href="/MyLogin/ObterClienteServlet?id=${cliente.id}">Exibir</a>
						</td>
					</tr>
				</thead>
			</table>
		</c:when>
	</c:choose>
	
	<form action="/MyLogin/AlterarClienteServlet" method="post">
		ID:<input type="text" id="id" name="id" value="${cliente.id}" readonly="readonly"/>
		NOME:<input type="text" id="nome" name="nome" value="${cliente.nome}"/>
		CPF:<input type="text" id="cpf" name="cpf" value="${cliente.cpf}"/>
		EMAIL:<input type="text" id="email" name="email" value="${cliente.email}"/>
		SENHA:<input type="text" id="senha" name="senha" value="${cliente.senha}"/>
		<input type="submit" value="Alterar"/>
	</form>
	
</body>
</html>