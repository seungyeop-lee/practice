package springbook.user.sqlservice;

import javax.annotation.PostConstruct;

import springbook.user.sqlservice.exception.SqlNotFoundException;
import springbook.user.sqlservice.exception.SqlRetrievalFailureException;
import springbook.user.sqlservice.reader.SqlReader;
import springbook.user.sqlservice.registry.SqlRegistry;

public class BaseSqlService implements SqlService {

	protected SqlReader sqlReader;
	protected SqlRegistry sqlRegistry;
	
	public void setSqlReader(SqlReader sqlReader) {
		this.sqlReader = sqlReader;
	}
	public void setSqlRegistry(SqlRegistry sqlRegistry) {
		this.sqlRegistry = sqlRegistry;
	}
	
	@PostConstruct
	public void loadSql() {
		this.sqlReader.read(this.sqlRegistry);
	}
	
	@Override
	public String getSql(String key) throws SqlRetrievalFailureException {
		try {
			return this.sqlRegistry.findSql(key);
		} catch (SqlNotFoundException e) {
			throw new SqlRetrievalFailureException(e);
		}
	}

}
