package aula.model;

import aula.db.ConexaoException;
import aula.db.DAOCliente;
import aula.db.RepositoryException;
import aula.entidade.Cliente;

public class ClienteAlterar {

	public Cliente atualizar(Cliente cliente) throws Exception {
		altera(cliente);
		return consulta(cliente);
	}
	
	private void altera(Cliente cliente) throws Exception {
		DAOCliente dao = new DAOCliente();
		
		try {
			dao.alterar(cliente);
			
		} catch(ConexaoException e) {
			throw new Exception("Erro Conexão ClienteAlterar " + e.getMessage());
		} catch(RepositoryException e) {
			throw new Exception("Erro Repositório ClienteAlterar " + e.getMessage());
		}
	}
	
	private Cliente consulta(Cliente cliente) throws Exception{
		DAOCliente dao = new DAOCliente();
		
		try {
			Cliente aux = dao.consultar(cliente);
			
			if(aux == null) {
				throw new Exception("Dados não encontrados");
			}
			
			return aux;
		} catch(ConexaoException e) {
			throw new Exception("Erro Conexão ClienteAlterar 2 " + e.getMessage());
		} catch(RepositoryException e) {
			throw new Exception("Erro Repositório ClienteAlterar 2 " + e.getMessage());
		}
	}
}
