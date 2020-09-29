package aula.db;

public class ConexaoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ConexaoException(String msg) {
		super(msg);
	}
	
	public ConexaoException(Exception msg) {
		super(msg);
	}

}
