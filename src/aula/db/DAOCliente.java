package aula.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import aula.entidade.Cliente;
import aula.utilitarios.GerenciadorConexao;
import aula.utilitarios.GerenciadorConexaoMySQL;

public class DAOCliente implements DAO<Cliente>{
	
	private GerenciadorConexao ger;
	
	@Override
	public void inserir(Cliente cliente) throws ConexaoException, RepositoryException {
		ger = GerenciadorConexaoMySQL.getInstancia();
		Connection conn = ger.conectar();
		
		String sql = "INSERT INTO clientes (cpf, nome, email, dataNascimento, sexo, nomeSocial, apelido, telefone) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, cliente.getCpf());
			ps.setString(2, cliente.getNome());
			ps.setString(3, cliente.getEmail());
			ps.setDate(4, new java.sql.Date(cliente.getDataNascimento().getTime()));
			ps.setString(5, cliente.getSexo());
			ps.setString(6, cliente.getNomeSocial());
			ps.setString(7, cliente.getApelido());
			ps.setString(8, cliente.getTelefone());
			ps.executeUpdate();
		} catch(SQLException e) {
			throw new RepositoryException("DAOCliente inserir " + e.getMessage());
		} finally {
			ger.desconectar(conn);
		}
	}

	@Override
	public Cliente consultar(Cliente cliente) throws ConexaoException, RepositoryException {
		ger = GerenciadorConexaoMySQL.getInstancia();
		Connection conn = ger.conectar();
		
		Cliente aux = null;
		String sql = "SELECT id, cpf, nome, email, dataNascimento, sexo, nomeSocial, apelido, telefone FROM clientes WHERE cpf=? OR email=?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cliente.getCpf());
			ps.setString(2, cliente.getEmail());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				aux = new Cliente();
				aux.setId(rs.getInt("id"));
				aux.setCpf(rs.getString("cpf"));
				aux.setNome(rs.getString("nome"));
				aux.setEmail(rs.getString("email"));
				aux.setDataNascimento(rs.getDate("dataNascimento"));
				aux.setSexo(rs.getString("sexo"));
				aux.setNomeSocial(rs.getString("nomeSocial"));
				aux.setApelido(rs.getString("apelido"));
				aux.setTelefone(rs.getString("telefone"));
			}
		} catch(SQLException e) {
			throw new RepositoryException("DAOCliente consultar " + e.getMessage());
		} finally {
			ger.desconectar(conn);
		}
		return aux;
	}

	@Override
	public void excluir(Cliente cliente) throws ConexaoException, RepositoryException {
		ger = GerenciadorConexaoMySQL.getInstancia();
		Connection conn = ger.conectar();
		
		String sql = "DELETE FROM clientes WHERE cpf=? OR email=?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cliente.getCpf());
			ps.setString(2, cliente.getEmail());
			ps.executeUpdate();
		} catch(SQLException e) {
			throw new RepositoryException("DAOCliente excluir " + e.getMessage());
		} finally {
			ger.desconectar(conn);
		}
		
	}

	@Override
	public void alterar(Cliente cliente) throws ConexaoException, RepositoryException {
		ger = GerenciadorConexaoMySQL.getInstancia();
		Connection conn = ger.conectar();
		
		String sql = "UPDATE clientes SET cpf=?, nome=?, email=?, dataNascimento=?, sexo=?, nomeSocial=?, apelido=?, telefone=? WHERE id=?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cliente.getCpf());
			ps.setString(2,  cliente.getNome());
			ps.setString(3, cliente.getEmail());
			ps.setDate(4, new java.sql.Date(cliente.getDataNascimento().getTime()));
			ps.setString(5, cliente.getSexo());
			ps.setString(6,  cliente.getNomeSocial());
			ps.setString(7, cliente.getApelido());
			ps.setString(8,  cliente.getTelefone());
			ps.setInt(9, cliente.getId());
			ps.executeUpdate();
		} catch(SQLException e) {
			throw new RepositoryException("DAOCliente alterar" + e.getMessage());
		} finally {
			ger.desconectar(conn);
		}
	}

	@Override
	public List<Cliente> listarTudo() throws ConexaoException, RepositoryException {
		ger = GerenciadorConexaoMySQL.getInstancia();
		Connection conn = ger.conectar();
		
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		Cliente aux = null;
		
		String sql = "SELECT * FROM clientes";
		
		try {
			Statement ps = conn.createStatement();
			ResultSet rs = ps.executeQuery(sql);
			while(rs.next()) {
				aux = new Cliente();
				aux.setId(rs.getInt("id"));
				aux.setCpf(rs.getString("cpf"));
				aux.setNome(rs.getString("nome"));
				aux.setEmail(rs.getString("email"));
				aux.setDataNascimento(rs.getDate("dataNascimento"));
				aux.setSexo(rs.getString("sexo"));
				aux.setNomeSocial(rs.getString("nomeSocial"));
				aux.setApelido(rs.getString("apelido"));
				aux.setTelefone(rs.getString("telefone"));
				lista.add(aux);
			}
		} catch(SQLException e) {
			throw new RepositoryException("DAOCliente listarTudo " + e.getMessage());
		} finally {
			ger.desconectar(conn);
		}
		return lista;
	}
}
