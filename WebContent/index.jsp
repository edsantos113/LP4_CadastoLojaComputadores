<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="estilos.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Controle De Vendas</title>
</head>
<body>
<div class="main">
<div id="header"><span><h1 align="center">Sistema de vendas</h1></span></div>
<div class="content">
	<ul> 
    	<li><a href="#">Produtos</a>
    		<ul> 
       			<li><a href="produto/cadastrarProduto.jsp">Cadastrar</a></li> 
       			<li><a href="produto/excluirProduto.jsp">Excluir</a></li> 
       			<li><a href="produto/editarProduto.jsp">Editar</a></li> 
    		</ul> 
    	</li> 
    	<li><a href="#">Vendedor</a>
    		<ul> 
       			<li><a href="vendedor/cadastrarVendedor.jsp">Cadastrar</a></li> 
       			<li><a href="vendedor/excluirVendedor.jsp">Excluir</a></li> 
       			<li><a href="vendedor/editarVendedor.jsp">Editar</a></li> 
    		</ul> 
    	</li> 
    	<li><a href="#">Vendas</a> 
      		<ul> 
        		<li><a href="venda/realizarVenda.jsp">Realizar Venda</a></li> 
        		<li><a href="#">Consultar</a>
        			<ul>
        				<li><a href="venda/pesquisaPorCodigo.jsp">Por Código</a></li>
        				<li><a href="venda/pesquisaPorVendedor.jsp">Por Vendedor</a></li>
        				<li><a href="venda/pesquisaPorData.jsp">Por Data</a></li>
        			</ul>
        		</li>  
      		</ul> 
    	</li> 
	</ul>
</div>
</div>
<div align="center" id="footer">
<span align="center"><b>UNIVERSIDADE CASTELO BRANCO</b><br>
Sistemas de Informação<br>
Disciplina: LP-4<br>
Prof.: Cláudio Márcio<br>
</span>
</div>
</body>
</html>