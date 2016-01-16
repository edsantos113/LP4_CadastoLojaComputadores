package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.VendedorDAO;

/**
 * Servlet que faz a exclusão de vendedores no banco de dados
 * 
 * @author Amanda
 *
 */
public class ExcluirVendedor extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, 
	     HttpServletResponse response)
				     throws ServletException, IOException {
		
		long registro = Long.parseLong(request.getParameter("registro"));
		
		PrintWriter out = response.getWriter();
		out.println("<head>	<link rel=\"stylesheet\" type=\"text/css\" href=\"../estilos.css\"></head>");
		
		try{
			VendedorDAO dao = new VendedorDAO();
			
			//exclui no banco
			dao.exclui(registro);
			
		}
		catch(SQLException e){
			out.println("<html>");
			out.println("<form action=\"../index.jsp\">");
			out.println("<html>");
			out.println("Ocorreu um erro. O Vendedor não foi excluido!");
			out.println("<input type=\"submit\" value=\"Home\">");
			out.println("</form>");
			out.println("</html>");	
			return;
		}
		
		
		out.println("<html>");
		out.println("<form action=\"../index.jsp\">");
		out.println("Vendedor excluido com sucesso!");
		out.println("<input type=\"submit\" value=\"Home\">");
		out.println("</form>");
		out.println("</html>");	
	}	


}
