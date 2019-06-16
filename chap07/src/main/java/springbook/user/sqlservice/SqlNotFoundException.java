package springbook.user.sqlservice;

public class SqlNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -7723289157810851058L;
	
	public SqlNotFoundException(String message) {
		super(message);
	}
	
}
