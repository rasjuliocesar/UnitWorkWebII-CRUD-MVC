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
			throw new Exception("Dados inv�lidos");
		}
	}
	
	private void verifica(Cliente cliente) throws Exception {
		DAOCliente dao = new DAOCliente();
		
		try {
			Cliente aux = dao.consultar(cliente);
			
			if(aux == null) {
				throw new Exception("Dados n�o encontrados");
			}
		} catch(ConexaoException e) {
			throw new Exception("Erro Conex�o Verificar ClienteApagar " + e.getMessage());
		} catch(RepositoryException e) {
			throw new Exception("Erro Reposit�rio Verificar ClienteApagar " + e.getMessage());
		}
	}
	
	private void apaga(Cliente cliente) throws Exception {
		DAOCliente dao = new DAOCliente();
		
		try {
			dao.excluir(cliente);
		} catch(ConexaoException e) {
			throw new Exception("Erro Conex�o Apagar ClienteApagar " + e.getMessage());
		} catch(RepositoryException e) {
			throw new Exception("Erro Reposit�rio Apagar ClienteApagar " + e.getMessage());
		}
	}
}
