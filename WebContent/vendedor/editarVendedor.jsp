<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
<%@ page import="java.util.*, DAO.VendedorDAO" %>
<link rel="stylesheet" type="text/css" href="../estilos.css">

<script>
function back() {
    window.history.back();
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar Vendedor</title>
</head>
<body>
	<form action="editar.jsp">
		<div>
		<p> 
			<label for="codigo"> Registro: </label>
			<select id="codigo" name="codigo">
				<%
					VendedorDAO dao = new VendedorDAO();
		
					List<Long> autoIds = dao.getTodosVendedoresId();
			
					for (Long id: autoIds) {
				%>
				<option value=<%=id%>><%=id%></option>
				<%
					}
				%>
			</select>
		</p>
		<br>	
		<input type="submit" value="Selecionar">
		<input type="button" onClick=back() value="Voltar">
		</div>
	</form>
</body>
</html>