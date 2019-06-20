package springbook.user.sqlservice;

import java.util.Map;

/**
 * SqlRegistry에 SQL 수정 기능을 추가(확장)한 인터페이스 
 *
 */
public interface UpdatableSqlRegistry extends SqlRegistry {
	public void updateSql(String key, String sql) throws SqlUpdateFailureException;
	public void updateSql(Map<String, String> sqlmap) throws SqlUpdateFailureException;
}
