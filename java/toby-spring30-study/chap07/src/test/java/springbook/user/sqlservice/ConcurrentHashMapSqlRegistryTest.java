package springbook.user.sqlservice;

import springbook.user.sqlservice.registry.ConcurrentHashMapSqlRegistry;
import springbook.user.sqlservice.registry.UpdatableSqlRegistry;

public class ConcurrentHashMapSqlRegistryTest extends AbstractUpdatableSqlRegistryTest {
	
	@Override
	protected UpdatableSqlRegistry createUpdatableSqlRegistry() {
		return new ConcurrentHashMapSqlRegistry();
	}
	
}
