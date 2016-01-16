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
 * Servlet que faz o cadastro de computadores no banco de dados
 * 
 * @author Amanda
 *
 */
public class CadastrarProduto extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, 
	     HttpServletResponse response)
				     throws ServletException, IOException {
		
		
		
		Computador auto = new Computador();
		
		long codigo = 0;
		PrintWriter out = response.getWriter();
		out.println("<head>	<link rel=\"stylesheet\" type=\"text/css\" href=\"../estilos.css\"></head>");
		
		try{
			ComputadorDAO dao = new ComputadorDAO();
			//Busca o proximo codigo disponivel para cadastro 
			codigo = dao.getProximoCodigo();
			
			//seta os atributos
			auto.setCodigo(codigo);
			auto.setDescricao(request.getParameter("descricao"));
			auto.setPreco(Float.parseFloat(request.getParameter("preco")));
			
			//salva no banco
			dao.adiciona(auto);
			
		}
		catch(SQLException e){
			out.println("<html>");
			out.println("<form action=\"../index.jsp\">");
			out.println("<html>");
			out.println("Ocorreu um erro, O produto não foi cadastrado!");
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
		out.println("Cadastro realizado com sucesso!");
		out.println("<input type=\"submit\" value=\"Home\">");
		out.println("</form>");
		out.println("</html>");	
	}	


}
