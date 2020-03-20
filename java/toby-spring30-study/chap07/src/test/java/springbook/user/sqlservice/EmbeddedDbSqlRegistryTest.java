package springbook.user.sqlservice;

import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import springbook.user.sqlservice.exception.SqlUpdateFailureException;
import springbook.user.sqlservice.registry.EmbeddedDbSqlRegistry;
import springbook.user.sqlservice.registry.UpdatableSqlRegistry;

public class EmbeddedDbSqlRegistryTest extends AbstractUpdatableSqlRegistryTest {
	EmbeddedDatabase db;
	
	@Override
	protected UpdatableSqlRegistry createUpdatableSqlRegistry() {
		db = new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.HSQL)
				.addScript("classpath:springbook/user/sqlservice/sqlRegistrySchema.sql")
				.build();
		
		EmbeddedDbSqlRegistry embeddedDbSqlRegistry = 
				new EmbeddedDbSqlRegistry();
		embeddedDbSqlRegistry.setDataSource(db);
		
		return embeddedDbSqlRegistry;
	}
	
	@After
	public void tearDown() {
		db.shutdown();
	}
	
	@Test
	public void transactionUpdate() {
		checkFindResult("SQL1", "SQL2", "SQL3");
		
		Map<String, String> sqlmap = new HashMap<>();
		sqlmap.put("KEY1", "Modified1");
		sqlmap.put("KEY9999!@#$", "Modified9999");
		
		try {
			sqlRegistry.updateSql(sqlmap);
			fail();
		} catch (SqlUpdateFailureException e) {
			checkFindResult("SQL1", "SQL2", "SQL3");
		}
	}
	
}
