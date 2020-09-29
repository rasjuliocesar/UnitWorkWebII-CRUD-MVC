package aula.model;

import java.util.ArrayList;
import java.util.List;

import aula.db.ConexaoException;
import aula.db.DAOCliente;
import aula.db.RepositoryException;
import aula.entidade.Cliente;

public class ClienteListar {

	public List<Cliente> listar() throws Exception {
		DAOCliente dao = new DAOCliente();
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		
		try {
			lista = (ArrayList<Cliente>) dao.listarTudo();
		} catch(ConexaoException e) {
			throw new Exception("Erro Conexão ClienteListar " + e.getMessage());
		} catch(RepositoryException e) {
			throw new Exception("Erro Repositório ClienteListar " + e.getMessage());
		}
		return lista;
	}
}
