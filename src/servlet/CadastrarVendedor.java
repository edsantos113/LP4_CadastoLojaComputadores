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
 * Servlet que faz o cadastro de vendedores no banco de dados
 * 
 * @author Amanda
 *
 */
public class CadastrarVendedor extends HttpServlet {


	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, 
	     HttpServletResponse response)
				     throws ServletException, IOException {
		
		Vendedor vendedor = new Vendedor();
		
		long registro = 0;
		PrintWriter out = response.getWriter();
		out.println("<head>	<link rel=\"stylesheet\" type=\"text/css\" href=\"../estilos.css\"></head>");
		
		try{
			VendedorDAO dao = new VendedorDAO();
			
			//Busca o proximo registro disponivel para cadastro 
			registro = dao.getProximoRegistro();
			
			//seta os atributos
			vendedor.setRegistro(registro);
			vendedor.setNome(request.getParameter("nome"));
		
			//salva no banco
			dao.adiciona(vendedor);
			
		}
		catch(SQLException e){
			out.println("<html>");
			out.println("<form action=\"../index.jsp\">");
			out.println("<html>");
			out.println("Ocorreu um erro! O vendedor não foi cadastrado!");
			out.println("<input type=\"submit\" value=\"Home\">");
			out.println("</form>");
			out.println("</html>");	
			return;
		}
		catch(NumberFormatException e){
			out.println("<html>");
			out.println("<form action=\"../index.jsp\">");
			out.println("<html>");
			out.println("Ocorreu um erro no preenchimento dos campos numéricos, tente novamente!");
			out.println("<input type=\"submit\" value=\"Home\">");
			out.println("</form>");
			out.println("</html>");	
			return;
		}
		catch(NullPointerException e){
			out.println("<html>");
			out.println("<form action=\"../index.jsp\">");
			out.println("<html>");
			out.println("Ocorreu um erro no preenchimento dos campos numéricos, tente novamente!");
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
