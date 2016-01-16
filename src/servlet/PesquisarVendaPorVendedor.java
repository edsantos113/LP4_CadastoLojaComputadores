package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.VendaDAO;
import entidades.Venda;

/**
 * Servlet que faz a pesquisa pelo c�digo do vendedor no banco de dados
 * 
 * @author Amanda
 *
 */
public class PesquisarVendaPorVendedor extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, 
	     HttpServletResponse response)
				     throws ServletException, IOException {
		float total=0f;
		List<String> vendas = null;
		
		long id = 0;
		PrintWriter out = response.getWriter();
		out.println("<head>	<link rel=\"stylesheet\" type=\"text/css\" href=\"../estilos.css\"></head>");
		
		try{
			VendaDAO dao = new VendaDAO();
			//Busca o proximo codigo disponivel para cadastro 
			id = Long.parseLong(request.getParameter("vendedor"));
			
			vendas=dao.getVendasPorVendedor(id);
			
			if(vendas.size()==0){
				out.println("<html>");
				out.println("<form action=\"../index.jsp\">");
				out.println("<html>");
				out.println("Sem Registros para o dado informado!");
				out.println("<input type=\"submit\" value=\"Home\">");
				out.println("</form>");
				out.println("</html>");	
				return;
			}
			
		}
		catch(Exception e){
			out.println("<html>");
			out.println("<form action=\"../index.jsp\">");
			out.println("<html>");
			out.println("Ocorreu um erro ao buscar vendas!");
			out.println("<input type=\"submit\" value=\"Home\">");
			out.println("</form>");
			out.println("</html>");	
			return;
		}

		
		out.println("<html>");
		out.println("<form action=\"../index.jsp\">");
		out.println("Quantidade de vendas: " + (vendas.size()-1));
		out.println(vendas.get(vendas.size()-1));
		
		for (int i = 0; i < vendas.size()-1; i++){
			
			out.println("<br>"+vendas.get(i)+"<br>");
		}

		//out.println("Valor total de vendas: R$" + String.format("%.02f",total));
		out.println("<br><input type=\"submit\" value=\"Home\">");
		out.println("</form>");
		out.println("</html>");	
	}	


}
