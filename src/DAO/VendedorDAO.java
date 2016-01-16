package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Vendedor;
import fabrica.ConnectionFactory;

/**
 * Data Acces Objec para simplificar o acesso aos dados dos Vendedores
 * 
 * @author Amanda e Werneck
 *
 */

public class VendedorDAO {

	//nome da tabela no banco de dados
	final String TABELA = "Vendedor";

	private Connection connection;

	public VendedorDAO() throws SQLException{
		this.connection = ConnectionFactory.getConnection();
	}

	//adiciona um novo computador no banco de dados
	public void adiciona(Vendedor vendedor)throws SQLException{

		String sql = "insert into " + TABELA + " (registro,nome) values (?,?)";
		PreparedStatement stmt = connection.prepareStatement(sql);

		//setar os parametros da query sql
		stmt.setLong(1, vendedor.getRegistro());
		stmt.setString(2, vendedor.getNome());

		stmt.execute();
		stmt.close();
	}

	//atualizar informações de um computador existente no banco de dados
	public void atualiza(Vendedor vendedor) throws SQLException{

		String sql = "update " + TABELA + " set nome=? where registro=?";

		PreparedStatement stmt = connection.prepareStatement(sql);

		//setar parametros da query sql
		stmt.setString(1, vendedor.getNome());
		stmt.setLong(2, vendedor.getRegistro());

		stmt.execute();
		stmt.close();

	}

	//excluir um computador do banco de dados
	public void exclui(long registro)throws SQLException{

		String sql  = "delete from " + TABELA + " where registro=?";

		PreparedStatement stmt = connection.prepareStatement(sql);

		//setar parametros da query sql
		stmt.setLong(1, registro);

		stmt.execute();
		stmt.close();

	}

	//Pesquisar um vendedor existente no banco de dados
	public Vendedor getVendedor(long registro)throws Exception{
		String sql = "select * from " + TABELA + " where registro=?";

		PreparedStatement stmt = connection.prepareStatement(sql);

		//setar parametro na query sql
		stmt.setLong(1, registro);

		ResultSet rs = stmt.executeQuery();

		//se não retornar resultados o objeto não existe no banco de dados
		if(!rs.first()){
			throw new Exception("Vendedor com registro " +registro+" não encontrado no banco");
		}

		Vendedor vendedor = new Vendedor();
		vendedor.setRegistro(rs.getLong("registro"));
		vendedor.setNome(rs.getString("nome"));

		return vendedor;
	}

	public long getProximoRegistro() throws SQLException{
		String sql = "select max(registro) from " + TABELA;
		PreparedStatement stmt = connection.prepareStatement(sql);

		ResultSet rs = stmt.executeQuery();
		long registro;
		//se não retornar resultados a tabela está vazia
		if(!rs.first()){
			registro=1;
		}
		registro=rs.getLong(1)+1;
		rs.close();
		stmt.close();
		return registro;
	}
	
	//Pesquisar todos ids dos vendedores existentes no banco de dados
	public List<Long> getTodosVendedoresId()throws Exception{
		
		List<Long> ids=new ArrayList<Long>();
		String sql = "select registro from " + TABELA;

		PreparedStatement stmt = connection.prepareStatement(sql);

		ResultSet rs = stmt.executeQuery();

		while (rs.next()){
			ids.add(rs.getLong(1));
		}

		return ids;
	}

}
