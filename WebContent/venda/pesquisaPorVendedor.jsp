<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<title>Pesquisa de Vendas por Identificador da Venda</title>
</head>
<body>
	<form action="pequisaVendaPorVendedor">
		<div>
		<p> 
			<label for="vendedor"> Registro do vendedor: </label>
			<input id="vendedor" name="vendedor" type="text"/>
		</p>
				
		<input type="submit" value="Pesquisar">
		<input type="button" onClick=back() value="Voltar">
		</div>
	</form>
</body>
</html>