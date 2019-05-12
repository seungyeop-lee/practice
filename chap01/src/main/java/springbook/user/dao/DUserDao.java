package springbook.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class DUserDao extends UserDao {

	// UserDao를 수정한 영향으로 상속으로 인한 확장이 불가능해짐
//	@Override
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection c = null;
		//D 사 DB Connection 생성코드
		return c;
	}

}
