package springbook.user.sqlservice;

/**
 * key에 해당하는 SQL문을 제공하는 인터페이스 
 *
 */
public interface SqlService {
	String getSql(String key) throws SqlRetrievalFailureException;
}
