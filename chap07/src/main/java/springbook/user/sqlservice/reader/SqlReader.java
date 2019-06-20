package springbook.user.sqlservice.reader;

import springbook.user.sqlservice.registry.SqlRegistry;

public interface SqlReader {
	void read(SqlRegistry sqlRegistry);
}
