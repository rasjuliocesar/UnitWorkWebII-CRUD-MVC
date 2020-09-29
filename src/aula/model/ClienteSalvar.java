package aula.model;

import aula.db.ConexaoException;
import aula.db.DAOCliente;
import aula.db.RepositoryException;
import aula.entidade.Cliente;

public class ClienteSalvar {

	public void salvar(Cliente cliente) throws Exception {
		validar(cliente);
		verificar(cliente);
		inserir(cliente);
	}

	private void validar(Cliente cliente) throws Exception {
		if((cliente.getNome() == null) || (cliente.getNome().isEmpty())) {
			throw new Exception("Nome inválido");
		}
		
		if((cliente.getCpf() == null) || (cliente.getCpf().isEmpty())) {
			throw new Exception("CPF inválido");
		}
		
		if((cliente.getEmail() == null) || (cliente.getEmail().isEmpty())) {
			throw new Exception("E-mail inválido");
		}
	}
	
	private void verificar(Cliente cliente) throws Exception {
		DAOCliente dao = new DAOCliente();
		
		try {
			Cliente aux = dao.consultar(cliente);
			
			if(aux != null) {
				throw new Exception("CPF Duplicado");
			}
		} catch(ConexaoException e) {
			throw new Exception("Erro Conexão ClienteSalvar " + e.getMessage());
		} catch(RepositoryException e) {
			throw new Exception("Erro Repositório ClienteSalvar " + e.getMessage());
		}
		
	}
	
	private void inserir(Cliente cliente) throws Exception {
		DAOCliente dao = new DAOCliente();
		
		try {
			dao.inserir(cliente);
		} catch(ConexaoException e) {
			throw new Exception("Erro Conexão Inserir ClienteSalvar " + e.getMessage());
		} catch(RepositoryException e) {
			throw new Exception("Erro Repositório Inserir ClienteSalvar " + e.getMessage());
		}
		
	}
}
