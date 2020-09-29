package aula.db;

public class RepositoryException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public RepositoryException(String msg) {
		super(msg);
	}
	
	public RepositoryException(Exception msg) {
		super(msg);
	}

}
