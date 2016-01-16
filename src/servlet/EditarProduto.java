package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ComputadorDAO;
import entidades.Computador;

/**
 * Servlet que faz a atualiza��o de computadores no banco de dados
 * 
 * @author Amanda
 *
 */
public class EditarProduto extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, 
	     HttpServletResponse response)
				     throws ServletException, IOException {
		
		Computador auto = new Computador();
	
		PrintWriter out = response.getWriter();
		out.println("<head>	<link rel=\"stylesheet\" type=\"text/css\" href=\"../estilos.css\"></head>");
		
		try{
			ComputadorDAO dao = new ComputadorDAO();
			
			//seta os atributos
			auto.setCodigo(Long.parseLong(request.getParameter("codigo")));
			auto.setDescricao(request.getParameter("descricao"));
			auto.setPreco(Float.parseFloat(request.getParameter("preco")));
			
			//atualiza no banco
			dao.atualiza(auto);
			
		}
		catch(SQLException e){
			out.println("<html>");
			out.println("<form action=\"../index.jsp\">");
			out.println("<html>");
			out.println("Ocorreu um erro, O produto n�o foi atualizado!");
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
		out.println("Atualizacao realizada com sucesso!");
		out.println("<input type=\"submit\" value=\"Home\">");
		out.println("</form>");
		out.println("</html>");	
	}	


}
