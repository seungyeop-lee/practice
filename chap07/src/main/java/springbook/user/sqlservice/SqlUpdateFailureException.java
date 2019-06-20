package springbook.user.sqlservice;

public class SqlUpdateFailureException extends RuntimeException {

	private static final long serialVersionUID = -4342169287798238330L;
	
	public SqlUpdateFailureException(String message) {
		super(message);
	}
	
}
