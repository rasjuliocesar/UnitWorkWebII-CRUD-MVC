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
			throw new Exception("CPF Inv�lido");
		}
	}
	
	private Cliente consulta(Cliente cliente) throws Exception{
		DAOCliente dao = new DAOCliente();
		
		try {
			Cliente aux = dao.consultar(cliente);
			
			if(aux == null) {
				throw new Exception("Dados n�o encontrados ClienteConsultar ");
			}
			
			return aux;
		} catch(ConexaoException e) {
			throw new Exception("Erro Conex�o ClienteConsultar " + e.getMessage());
		} catch(RepositoryException e) {
			throw new Exception("Erro Reposit�rio ClienteConsultar " + e.getMessage());
		}
	}
}
