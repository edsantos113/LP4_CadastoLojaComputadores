package fabrica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ConnectionFactory é um padrão de projeto que define a interface
 * para criação de objetos. O padrão Factory encapsula o código de 
 * criação de objetos em um único local, evitando a duplicação do
 * mesmo e facilitando a manutenção.
 *
 * @author Amanda
 *
 */
public class ConnectionFactory {
	
	final static String DRIVER = "com.mysql.jdbc.Driver";
	final static String BANCO_DE_DADOS = "jdbc:mysql://localhost:3306/sistemadevendas";
	final static String USUARIO = "root";
	final static String SENHA = "";
	
	//Cria conexão com o banco de dados
	public static Connection getConnection() throws SQLException{
		try{
			Class.forName(DRIVER);
			return DriverManager.getConnection(BANCO_DE_DADOS,USUARIO,SENHA);
		} catch (ClassNotFoundException e){
			throw new SQLException(e.getMessage());
		}
	}

}