<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page import="java.util.*, DAO.ComputadorDAO, entidades.Computador" %>
<link rel="stylesheet" type="text/css" href="../estilos.css">

<script>
function back() {
    window.history.back();
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Vendas</title>
</head>
<body>
	<form action="cadastraVenda">
		<div>
		<table>
		<tr> 
			<td><label for="id"> Identificador da Venda: </label></td>
			<td><input id="id" name="id" type="text"/></td>
		</tr>
		<tr> 
			<td><label for="vendedor"> Registro do Vendedor: </label></td>
			<td><input id="vendedor" name="vendedor" type="text"/></td>
		</tr>
		<tr> 
			<td><label for="data"> Data da Venda: </label></td>
			<td><input id="data" name="data" type="text"/>(Formato DD/MM/AAAA)</td>
		</tr>
		<tr> 
			<td><label for="codigo"> Código do Produto: </label></td>
			<td><select id="codigo" name="codigo">
				<%
					ComputadorDAO dao = new ComputadorDAO();
		
					List<Long> autoIds = dao.getTodosComputadoresId();
			
					for (Long id: autoIds) {
						Computador auto = dao.getComputador(id);
				%>
				<option value=<%=id%>><%=id%> - <%=auto.getDescricao() %></option>
				<%
					}
				%>
			</select></td>
		</tr>
		<tr> 
			<td><label for="desconto"> Desconto: </label></td>
			<td><input id="desconto" name="desconto" type="text"/>(Separar casas decimais por ponto)</td>
		</tr>
		<tr> 
			<td><label for="valor"> Valor em Acessórios: </label></td>
			<td><input id="valor" name="valor" type="text"/>(Separar casas decimais por ponto)</td>
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