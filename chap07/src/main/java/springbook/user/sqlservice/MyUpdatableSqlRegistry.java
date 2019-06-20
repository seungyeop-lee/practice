package springbook.user.sqlservice;

import java.util.Map;

public class MyUpdatableSqlRegistry extends HashMapSqlRegistry implements UpdatableSqlRegistry {
	
	@Override
	public void updateSql(String key, String sql) throws SqlUpdateFailureException {
		sqlMap.replace(key, sql);
	}

	@Override
	public void updateSql(Map<String, String> uSqlmap) throws SqlUpdateFailureException {
		for(String key : uSqlmap.keySet()) {
			sqlMap.replace(key, uSqlmap.get(key));
		}
	}

}
