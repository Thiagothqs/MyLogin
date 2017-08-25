<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar Cliente</title>
</head>
<body>
<form action="/MyLogin/AlterarClienteServlet" method="post">
	<h1>Alterar Cliente</h1>
	<p/>
	ID do Cliente <input type="text" name="id" id="id" value=""/>
	<p/>
	Nome <input type="text" name="nome" id="nome" value=""/>
	<p/>
	CPF <input type="text" name="cpf" id="cpf" value=""/>
	<p/>
	Email <input type="text" name="email" id="email" value=""/>
	<p/>
	Senha <input type="password" name="senha" id="senha" value=""/>
	<p/>
	<input type="reset" value="Limpar"/>
	<input type="submit" value="Entrar"/>
</form>
</body>
</html>