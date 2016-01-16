package fabrica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ConnectionFactory � um padr�o de projeto que define a interface
 * para cria��o de objetos. O padr�o Factory encapsula o c�digo de 
 * cria��o de objetos em um �nico local, evitando a duplica��o do
 * mesmo e facilitando a manuten��o.
 *
 * @author Amanda
 *
 */
public class ConnectionFactory {
	
	final static String DRIVER = "com.mysql.jdbc.Driver";
	final static String BANCO_DE_DADOS = "jdbc:mysql://localhost:3306/sistemadevendas";
	final static String USUARIO = "root";
	final static String SENHA = "";
	
	//Cria conex�o com o banco de dados
	public static Connection getConnection() throws SQLException{
		try{
			Class.forName(DRIVER);
			return DriverManager.getConnection(BANCO_DE_DADOS,USUARIO,SENHA);
		} catch (ClassNotFoundException e){
			throw new SQLException(e.getMessage());
		}
	}

}