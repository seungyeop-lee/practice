package springbook.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class NUserDao extends UserDao {
	
	// UserDao를 수정한 영향으로 상속으로 인한 확장이 불가능해짐
//	@Override
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection c = null;
		//N사 DB Connection 생성코드
		return c;
	}
	
}
