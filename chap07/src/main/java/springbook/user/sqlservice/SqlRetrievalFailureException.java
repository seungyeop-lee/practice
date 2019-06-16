package springbook.user.sqlservice;

/**
 * 요청한 key에 해당하는 SQL을 찾을 수 없을 경우 발생시킬 예외 
 *
 */
public class SqlRetrievalFailureException extends RuntimeException {
	
	private static final long serialVersionUID = -8695864519098001516L;

	public SqlRetrievalFailureException(String message) {
		super(message);
	}
	
	public SqlRetrievalFailureException(Throwable cause) {
		super(cause);
	}
	
	public SqlRetrievalFailureException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
