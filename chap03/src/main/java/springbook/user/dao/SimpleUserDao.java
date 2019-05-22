package springbook.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SimpleUserDao extends UserDao {
	
	@Override
	protected PreparedStatement makeAddStatement(Connection c) throws SQLException {
		return c.prepareStatement("insert into users(id, name, password) values(?, ?, ?)");
	}
	
	@Override
	protected PreparedStatement makeGetStatement(Connection c) throws SQLException {
		return c.prepareStatement("select * from users where id = ?");
	}
	
	@Override
	protected PreparedStatement makeDeleteAllStatement(Connection c) throws SQLException {
		return c.prepareStatement("delete from users");
	}
	
	@Override
	protected PreparedStatement makeGetCountStatement(Connection c) throws SQLException {
		return c.prepareStatement("select count(*) from users");
	}
	
}
