<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page import="java.util.*, DAO.ComputadorDAO" %>
<link rel="stylesheet" type="text/css" href="../estilos.css">

<script>
function back() {
    window.history.back();
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Excluir Produto</title>
</head>
<body>
	<form action="exclue">
		<div>
		<p> 
			<label for="codigo"> Código: </label>
			<select id="codigo" name="codigo">
				<%
					ComputadorDAO dao = new ComputadorDAO();
		
					List<Long> autoIds = dao.getTodosComputadoresId();
			
					for (Long id: autoIds) {
				%>
				<option value=<%=id%>><%=id%></option>
				<%
					}
				%>
			</select>
		</p>
		<br>	
		<input type="submit" value="Excluir">
		<input type="button" onClick=back() value="Voltar">
		</div>
	</form>
</body>
</html>