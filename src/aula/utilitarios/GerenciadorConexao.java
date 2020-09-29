package aula.utilitarios;

import java.sql.Connection;

import aula.db.ConexaoException;

public interface GerenciadorConexao {

	public Connection conectar() throws ConexaoException;
	
	public void desconectar(Connection conn) throws ConexaoException;
}
