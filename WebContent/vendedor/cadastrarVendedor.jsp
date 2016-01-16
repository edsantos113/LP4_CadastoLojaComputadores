<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="../estilos.css">
<script>
function back() {
    window.history.back();
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Vendedores</title>
</head>
<body>
	<form action="cadastra">
		<div>
		<table>
		 <tr>
			<td><label for="registro"> Registro: </label></td>
			<td><input id="registro" name="registro" type="text"/></td>
		</tr>
		<tr> 
			<td><label for="nome"> Nome: </label></td>
			<td><input id="nome" name="nome" type="text"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="Cadastrar"></td>
			<td><input type="button" onClick=back() value="Voltar"></td>
		</tr>
		</table>
		</div>
	</form>
</body>
</html>