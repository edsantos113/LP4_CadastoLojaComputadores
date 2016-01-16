package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ComputadorDAO;

/**
 * Servlet que faz a exclusão de computadores no banco de dados
 * 
 * @author Amanda
 *
 */
public class ExcluirProduto extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, 
	     HttpServletResponse response)
				     throws ServletException, IOException {
		
		long codigo = Long.parseLong(request.getParameter("codigo"));
		
		PrintWriter out = response.getWriter();
		out.println("<head>	<link rel=\"stylesheet\" type=\"text/css\" href=\"../estilos.css\"></head>");
		
		try{
			ComputadorDAO dao = new ComputadorDAO();
			
			//exclue no banco
			dao.exclui(codigo);
			
		}
		catch(SQLException e){
			out.println("<html>");
			out.println("<form action=\"../index.jsp\">");
			out.println("<html>");
			out.println("Ocorreu um erro, O produto não foi excluido!");
			out.println("<input type=\"submit\" value=\"Home\">");
			out.println("</form>");
			out.println("</html>");	
			return;
		}
		
		
		out.println("<html>");
		out.println("<form action=\"../index.jsp\">");
		out.println("Produto excluido com sucesso!");
		out.println("<input type=\"submit\" value=\"Home\">");
		out.println("</form>");
		out.println("</html>");	
	}	


}
