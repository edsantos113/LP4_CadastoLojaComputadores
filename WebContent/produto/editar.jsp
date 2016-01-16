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
<title>Editar Produtos</title>
</head>
<body>
	<form action="edita">
		<div>
		
		<%
		//preenche as caixas de texto com os valores atuais, para que o usuario possa alterar
			ComputadorDAO dao = new ComputadorDAO();
			long codigo = Long.parseLong(request.getParameter("codigo"));
			Computador auto=null;
			try{
				auto = dao.getComputador(codigo);
			}catch(Exception e){
				
			}
			
			%>
			<table>
			<input type="hidden" id="codigo" name="codigo" value=<%=request.getParameter("codigo")%>>
		<tr> 
			<td><label for="marca"> Descricao: </label></td>
			<td><input id="marca" value=<%=auto.getDescricao() %> name="marca" type="text"/></td>
		</tr>
		<tr> 
			<td><label for="preco"> Preço: </label></td>
			<td><input id="preco" value=<%=auto.getPreco() %> name="preco" type="text"/> (Separar casas decimais por ponto)</td>
		</tr>
		<tr>
			<td><input type="submit" value="Atualizar"></td>
			<td><input type="button" onClick=back() value="Voltar"></td>
		</tr>
		</table>
		</div>
	</form>
</body>
</html>