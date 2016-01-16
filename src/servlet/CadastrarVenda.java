package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ComputadorDAO;
import DAO.VendaDAO;
import entidades.Computador;
import entidades.Venda;



/**
 * Servlet que faz o cadastro de vendas no banco de dados
 * 
 * @author Amanda
 *
 */
public class CadastrarVenda extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, 
	     HttpServletResponse response)
				     throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.println("<head>	<link rel=\"stylesheet\" type=\"text/css\" href=\"../estilos.css\"></head>");
		Venda venda = null;
		try{
			VendaDAO dao = new VendaDAO();
			venda = new Venda();
			venda.setId(Long.parseLong(request.getParameter("id")));
			venda.setData(request.getParameter("data"));
			venda.setRegistroVendedor(Long.parseLong(request.getParameter("vendedor")));
			venda.setCodigoProduto(Long.parseLong(request.getParameter("codigo")));
			venda.setDesconto(Float.parseFloat(request.getParameter("desconto")));
			ComputadorDAO autoDao = new ComputadorDAO();
			Computador auto = autoDao.getComputador(venda.getCodigoProduto());
			venda.setValorTotal(auto.getPreco()-venda.getDesconto());
			
			dao.adiciona(venda);
			
		}
		catch(Exception e){
			out.println("<html>");
			out.println("<form action=\"../index.jsp\">");
			out.println("<html>");
			out.println("Ocorreu um erro, A venda não foi efetuada!");
			out.println("<input type=\"submit\" value=\"Home\">");
			out.println("</form>");
			out.println("</html>");	
			return;
		}
		
		
		out.println("<html>");
		out.println("<form action=\"../index.jsp\">");
		out.println("Venda efetuada com sucesso! \nValor total da venda: R$" + String.format("%.02f",venda.getValorTotal()));
		out.println("<input type=\"submit\" value=\"Home\">");
		out.println("</form>");
		out.println("</html>");	
	}	


}
