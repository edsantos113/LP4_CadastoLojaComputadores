package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.VendaDAO;
import entidades.Venda;

/**
 * Servlet que faz a pesquisa pelo código da venda no banco de dados
 * 
 * @author Amanda
 *
 */
public class PesquisarVendaPorCodigo extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, 
	     HttpServletResponse response)
				     throws ServletException, IOException {
		
		List<String> vendas = null;
		
		long id = 0;
		PrintWriter out = response.getWriter();
		out.println("<head>	<link rel=\"stylesheet\" type=\"text/css\" href=\"../estilos.css\"></head>");
		
		try{
			
			VendaDAO vendaDAO = new VendaDAO();
			
			id = Long.parseLong(request.getParameter("id"));

			vendas = vendaDAO.getVenda(id);
						
		}
		catch(Exception e){
			out.println("<html>");
			out.println("<form action=\"../index.jsp\">");
			out.println("<html>");
			out.println("Ocorreu um erro ao buscar venda!");
			out.println("<input type=\"submit\" value=\"Home\">");
			out.println("</form>");
			out.println("</html>");	
			return;
		}

		
		out.println("<html>");
		out.println("<form action=\"../index.jsp\">");
		out.println("Busca realizado com sucesso!<br>");
		
		for (int i = 0; i < vendas.size()-1; i++){
			
			out.println("<br>"+vendas.get(i)+"</br>");
		}
		
		out.println("<br><br><input type=\"submit\" value=\"Home\">");
		out.println("</form>");
		out.println("</html>");	
	}	


}
