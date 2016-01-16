package DAO;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Venda;
import fabrica.ConnectionFactory;

/**
 * 
 * @author Amanda
 *
 */
public class VendaDAO {

	//nome da tabela no banco de dados
	final String TABELA = "venda";

	private Connection connection;

	public VendaDAO() throws SQLException{
		this.connection = ConnectionFactory.getConnection();
	}

	//Método para adicionar uma nova venda ao banco de dados
	public void adiciona(Venda venda)throws SQLException{

		String sql = "insert into " + TABELA + " (id,data,registroVendedor,nomeComprador,cpfComprador,codigoProduto,desconto,valorTotal) values (?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = connection.prepareStatement(sql);

		//setar os parametros da query sql
		stmt.setLong(1, venda.getId());
		stmt.setString(2, venda.getData());
		stmt.setLong(3, venda.getRegistroVendedor());
		stmt.setString(4, venda.getNomeComprador());
		stmt.setString(5, venda.getCpfComprador());
		stmt.setLong(6, venda.getCodigoProduto());
		stmt.setFloat(7, venda.getDesconto());
		stmt.setFloat(8, venda.getValorTotal());

		stmt.execute();
		stmt.close();
	}

	//Pesquisar no banco de dados informações de vendas
	public List<String> getVenda(long id) throws SQLException{

		String sql = "select vendedor.nome, vendedor.registro, id, data, registroVendedor, nomeComprador, cpfComprador, codigoProduto, desconto, valorTotal "
			    	+ "from vendedor inner join venda on venda.registroVendedor = vendedor.registro where venda.id=?";

		PreparedStatement stmt = connection.prepareStatement(sql);


		//setar parametros da query sql
		stmt.setLong(1, id);

		//stmt.execute();

		ResultSet rs = stmt.executeQuery();
		
		float valorTotalVenda = 0;

		List<String> vendas = new ArrayList<String>();

		while (rs.next()){

			String resultado = ("<br><b>Registro Vendedor:</b> " + (Integer.toString(rs.getInt("vendedor.registro"))) +
								"<br><b>Vendedor:</b> " + (rs.getString("vendedor.nome")) + 
								"<br><b>ID da Venda:</b> " + (Integer.toString(rs.getInt("id"))) + 
								"<br><b>Data:</b> " + (rs.getString("data")) + 
								"<br><b>Nome Comprador:</b> " + (rs.getString("nomeComprador")) +
								"<br><b>CPF Comprador:</b> " + (rs.getString("cpfComprador")) +
								"<br><b>Codigo do Produto:</b> " + (Integer.toString(rs.getInt("codigoProduto"))) + 
								"<br><b>Desconto:</b> " + (String.format("%.02f", rs.getFloat("desconto"))) +
								"<br><b>Valor Total:</b> " + (String.format("%.02f",rs.getFloat("valorTotal"))) ) +
								"<br>=============================================================\n";

			vendas.add(resultado);
		}

		vendas.add("Valor total de vendas: "+Float.toString(valorTotalVenda));

		rs.close();
		stmt.close();

		return vendas;

	}

	//Pesquisar no banco de dados informações de vendas por data
	public List<String> getVendasPorData(String data) throws SQLException{

		String sql = "select vendedor.nome, vendedor.registro, id, data, registroVendedor, nomeComprador, cpfComprador, codigoProduto, desconto, valorTotal "
				+ "from vendedor inner join venda on venda.registroVendedor = vendedor.registro where data=?";

		PreparedStatement stmt = connection.prepareStatement(sql);

		//setar parametros da query sql
		stmt.setString(1, data);

		ResultSet rs = stmt.executeQuery();

		float valorTotalVenda = 0;

		List<String> vendas = new ArrayList<String>();

		while (rs.next()){

			valorTotalVenda = (rs.getFloat("valorTotal") + valorTotalVenda);;

			String resultado = ("<br><b>Vendedor:</b> " + (rs.getString("vendedor.nome")) + 
								"<br><b>ID da Venda:</b> " + (Integer.toString(rs.getInt("id"))) + 
								"<br><b>Data:</b> " + (rs.getString("data")) + 
								"<br><b>Valor total:</b> " + (Float.toString(rs.getFloat("valorTotal"))) )+
								"<br>=============================================================\n";

			vendas.add(resultado);
		}

		vendas.add("Valor total de vendas: "+ Float.toString(valorTotalVenda));

		rs.close();
		stmt.close();

		return vendas;
	}

	//Pesquisar no banco de dados informações de vendas por vendedor
	public List<String> getVendasPorVendedor(long registroVendedor) throws SQLException{

		String sql = "select vendedor.nome, vendedor.registro, id, data, registroVendedor, nomeComprador, cpfComprador, codigoProduto, desconto, valorTotal "
				+ "from vendedor inner join venda on venda.registroVendedor = vendedor.registro where registroVendedor=?";

		PreparedStatement stmt = connection.prepareStatement(sql);

		//setar parametros da query sql
		stmt.setLong(1, registroVendedor);

		ResultSet rs = stmt.executeQuery();

		List<String> vendas = new ArrayList<String>();

		float valorTotalVenda = 0;

		while (rs.next()){

			valorTotalVenda = (rs.getFloat("valorTotal") + valorTotalVenda);;

			String resultado = ("<br><b>Vendedor:</b> " + (rs.getString("vendedor.nome")) + 
								"<br><b>ID da Venda:</b> " + (Integer.toString(rs.getInt("id"))) + 
								"<br><b>Data:</b> " + (rs.getString("data")) + 
								"<br><b>Nome do Comprador:</b> " + (rs.getString("nomeComprador"))+
								"<br><b>Valor total:</b> " + (Float.toString(rs.getFloat("valorTotal"))) )+
								"<br>=============================================================\n";

			vendas.add(resultado);
		}

		vendas.add("Valor total de vendas: " + Float.toString(valorTotalVenda));

		rs.close();
		stmt.close();

		return vendas;
	}

	//metodo para preenchimento do objeto venda
	private Venda setVenda(ResultSet rs) throws SQLException {
		Venda venda  = new Venda();

		venda.setId(rs.getLong("id"));
		venda.setData(rs.getString("data"));
		venda.setRegistroVendedor(rs.getLong("registroVendedor"));
		venda.setNomeComprador(rs.getString("nomeComprador"));
		venda.setCpfComprador(rs.getString("cpfComprador"));
		venda.setCodigoProduto(rs.getLong("codigoProduto"));
		venda.setDesconto(rs.getFloat("desconto"));
		venda.setValorTotal(rs.getLong("valorTotal"));

		return venda;
	}

}
