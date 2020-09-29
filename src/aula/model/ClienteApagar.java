package aula.model;

import aula.db.ConexaoException;
import aula.db.DAOCliente;
import aula.db.RepositoryException;
import aula.entidade.Cliente;

public class ClienteApagar {

	public void apagar(Cliente cliente) throws Exception {
		valida(cliente);
		verifica(cliente);
		apaga(cliente);
	}
	
	private void valida(Cliente cliente) throws Exception{
		if( ((cliente.getCpf() == null) || (cliente.getCpf().isEmpty()))
				&&
			((cliente.getEmail() == null) || (cliente.getEmail().isEmpty())) ){
			throw new Exception("Dados inválidos");
		}
	}
	
	private void verifica(Cliente cliente) throws Exception {
		DAOCliente dao = new DAOCliente();
		
		try {
			Cliente aux = dao.consultar(cliente);
			
			if(aux == null) {
				throw new Exception("Dados não encontrados");
			}
		} catch(ConexaoException e) {
			throw new Exception("Erro Conexão Verificar ClienteApagar " + e.getMessage());
		} catch(RepositoryException e) {
			throw new Exception("Erro Repositório Verificar ClienteApagar " + e.getMessage());
		}
	}
	
	private void apaga(Cliente cliente) throws Exception {
		DAOCliente dao = new DAOCliente();
		
		try {
			dao.excluir(cliente);
		} catch(ConexaoException e) {
			throw new Exception("Erro Conexão Apagar ClienteApagar " + e.getMessage());
		} catch(RepositoryException e) {
			throw new Exception("Erro Repositório Apagar ClienteApagar " + e.getMessage());
		}
	}
}
