package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.VendedorDAO;
import entidades.Vendedor;

/**
 * Servlet que faz a atualização de vendedor no banco de dados
 * 
 * @author Amanda
 *
 */
public class EditarVendedor extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, 
	     HttpServletResponse response)
				     throws ServletException, IOException {
		
		Vendedor vendedor = new Vendedor();
	
		PrintWriter out = response.getWriter();
		out.println("<head>	<link rel=\"stylesheet\" type=\"text/css\" href=\"../estilos.css\"></head>");
		
		try{
			VendedorDAO dao = new VendedorDAO();
			
			//seta os atributos
			vendedor.setRegistro(Long.parseLong(request.getParameter("registro")));
			vendedor.setNome(request.getParameter("nome"));
			
			//atualiza no banco
			dao.atualiza(vendedor);
			
		}
		catch(SQLException e){
			out.println("<html>");
			out.println("<form action=\"../index.jsp\">");
			out.println("<html>");
			out.println("Ocorreu um erro. O vendedor não foi atualizado!");
			out.println("<input type=\"submit\" value=\"Home\">");
			out.println("</form>");
			out.println("</html>");	
			return;
		}
		catch(NumberFormatException e){
			out.println("<html>");
			out.println("<form action=\"../index.jsp\">");
			out.println("<html>");
			out.println("Ocorreu um erro no preenchimento dos campos numericos, tente novamente!");
			out.println("<input type=\"submit\" value=\"Home\">");
			out.println("</form>");
			out.println("</html>");	
			return;
		}
		catch(NullPointerException e){
			out.println("<html>");
			out.println("<form action=\"../index.jsp\">");
			out.println("<html>");
			out.println("Ocorreu um erro no preenchimento dos campos numericos, tente novamente!");
			out.println("<input type=\"submit\" value=\"Home\">");
			out.println("</form>");
			out.println("</html>");	
			return;
		}
		
		out.println("<html>");
		out.println("<form action=\"../index.jsp\">");
		out.println("Atualização realizada com sucesso!");
		out.println("<input type=\"submit\" value=\"Home\">");
		out.println("</form>");
		out.println("</html>");	
	}	


}
