package DAO;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Computador;
import fabrica.ConnectionFactory;

/**
 * Data Acces Objec para simplificar o acesso aos dados de Computadores
 * 
 * @author Amanda e Werneck
 *
 */
public class ComputadorDAO {

	//nome da tabela no banco de dados
	final String TABELA = "Computador";

	private Connection connection;

	public ComputadorDAO() throws SQLException{
		this.connection = ConnectionFactory.getConnection();
	}

	//adiciona um novo computador no banco de dados
	public void adiciona(Computador computador)throws SQLException{

		String sql = "insert into " + TABELA + " (codigo,descricao,preco) values (?,?,?)";
		PreparedStatement stmt = connection.prepareStatement(sql);

		//setar os parametros da query sql
		stmt.setLong(1, computador.getCodigo());
		stmt.setString(2, computador.getDescricao());
		stmt.setFloat(3, computador.getPreco());

		stmt.execute();
		stmt.close();
	}

	//atualizar informações de um computador existente no banco de dados
	public void atualiza(Computador computador) throws SQLException{

		String sql = "update " + TABELA + " set descricao=?, preco=? where codigo=?";

		PreparedStatement stmt = connection.prepareStatement(sql);

		//setar parametros da query sql
		stmt.setString(1, computador.getDescricao());
		stmt.setFloat(2, computador.getPreco());
		stmt.setLong(3, computador.getCodigo());

		stmt.execute();
		stmt.close();

	}

	//excluir um computador do banco de dados
	public void exclui(long codigo)throws SQLException{

		String sql  = "delete from " + TABELA + " where codigo=?";

		PreparedStatement stmt = connection.prepareStatement(sql);

		//setar parametros da query sql
		stmt.setLong(1, codigo);

		stmt.execute();
		stmt.close();

	}

	//Pesquisar um computador existente no banco de dados
	public Computador getComputador(long codigo)throws Exception{
		String sql = "select * from " + TABELA + " where codigo=?";

		PreparedStatement stmt = connection.prepareStatement(sql);

		//setar parametro na query sql
		stmt.setLong(1, codigo);

		ResultSet rs = stmt.executeQuery();

		//se não retornar resultados o objeto não existe no banco de dados
		if(!rs.first()){
			throw new Exception("Produto com codigo " +codigo+" não encontrado no banco");
		}

		Computador computador = new Computador();
		computador.setCodigo(rs.getLong("codigo"));
		computador.setDescricao(rs.getString("descricao"));
		computador.setPreco(rs.getFloat("preco"));

		return computador;
	}

	//Pesquisar todos ids dos computadores existentes no banco de dados
	public List<Long> getTodosComputadoresId()throws Exception{
		
		List<Long> ids=new ArrayList<Long>();
		String sql = "select codigo from " + TABELA;

		PreparedStatement stmt = connection.prepareStatement(sql);

		ResultSet rs = stmt.executeQuery();

		while (rs.next()){
			ids.add(rs.getLong(1));
		}

		return ids;
	}
	
	
	public long getProximoCodigo() throws SQLException{
		String sql = "select max(codigo) from " + TABELA;
		PreparedStatement stmt = connection.prepareStatement(sql);
		
		ResultSet rs = stmt.executeQuery();
		long codigo;
		//se não retornar resultados a tabela está vazia
		if(!rs.first()){
			codigo=1;
		}
		codigo=rs.getLong(1)+1;
		rs.close();
		stmt.close();
		return codigo;
	}
	
}
