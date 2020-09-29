package aula.model;

import aula.db.ConexaoException;
import aula.db.DAOCliente;
import aula.db.RepositoryException;
import aula.entidade.Cliente;

public class ClienteConsultar {

	public Cliente consultar(Cliente cliente) throws Exception{
		valida(cliente);
		Cliente aux = consulta(cliente);
		
		return aux;
	}
	
	private void valida(Cliente cliente) throws Exception{
		if((cliente.getCpf() == null) || (cliente.getCpf().isEmpty())) {
			throw new Exception("CPF Inválido");
		}
	}
	
	private Cliente consulta(Cliente cliente) throws Exception{
		DAOCliente dao = new DAOCliente();
		
		try {
			Cliente aux = dao.consultar(cliente);
			
			if(aux == null) {
				throw new Exception("Dados não encontrados ClienteConsultar ");
			}
			
			return aux;
		} catch(ConexaoException e) {
			throw new Exception("Erro Conexão ClienteConsultar " + e.getMessage());
		} catch(RepositoryException e) {
			throw new Exception("Erro Repositório ClienteConsultar " + e.getMessage());
		}
	}
}
