package springbook.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class NUserDao extends UserDao {
	@Override
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection c = null;
		//N사 DB Connection 생성코드
		return c;
	}
}
