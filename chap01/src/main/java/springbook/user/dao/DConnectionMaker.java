package springbook.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class DConnectionMaker implements ConnectionMaker {

	@Override
	public Connection makeConnection() throws ClassNotFoundException, SQLException {
		Connection c = null;
		// D사의 독자적인 방법으로 Connection을 생성하는 코드
		return c;
	}

}
