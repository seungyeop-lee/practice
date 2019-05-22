package springbook.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import springbook.user.domain.User;

public class AddStatement implements StatementStrategy {

	User user;
	
	//Add의 경우 user 정보가 필요하므로 DI 받는다.
	public AddStatement(User user) {
		this.user = user;
	}
	
	@Override
	public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
		
		PreparedStatement ps = c.prepareStatement("insert into users(id, name, password) values(?, ?, ?)");
		
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		
		return ps;
		
	}
}
