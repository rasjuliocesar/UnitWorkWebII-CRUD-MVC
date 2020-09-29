package aula.utilitarios;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import aula.db.ConexaoException;

public class GerenciadorConexaoMySQL implements GerenciadorConexao {

	private static GerenciadorConexaoMySQL instancia;
	
	public GerenciadorConexaoMySQL() {
	}
	
	public static GerenciadorConexaoMySQL getInstancia() {
		if(instancia == null) {
			return new GerenciadorConexaoMySQL();
		}
		return instancia;
	}
	
	@Override
	public Connection conectar() throws ConexaoException {
		String url = "jdbc:mysql://localhost:3306/lojaunit";
		String user = "root";
		String password = "root";
		Connection conn;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
		}catch(SQLException e) {
			throw new ConexaoException(e.getMessage());
		} catch (ClassNotFoundException e) {
			throw new ConexaoException(e.getMessage());
		}
		return conn;
	}

	@Override
	public void desconectar(Connection conn) throws ConexaoException {
		try {
			conn.close();
		} catch(SQLException e) {
			throw new ConexaoException(e.getMessage());
		}	
	}
}
