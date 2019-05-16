package springbook.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import springbook.user.domain.User;

public class UserDao {
	
	private ConnectionMaker connectionMaker;
	
	//수정자 메소드 DI 방식 (자바빈 규약에 따름, XML에서 Bean설정시 편리)
	public void setConnectionMaker(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
	}

	public void add(User user) throws ClassNotFoundException, SQLException {
		
		Connection c = connectionMaker.makeConnection();	//인터페이스를 사용하므로, 구상클래스가 변경되어도 영향을 받지 않음
		
		PreparedStatement ps = c.prepareStatement("insert into users(id, name, password) values(?, ?, ?)");
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		
		ps.executeUpdate();
		
		ps.close();
		c.close();
		
	}
	
	public User get(String id) throws ClassNotFoundException, SQLException {
		
		Connection c = connectionMaker.makeConnection();

		PreparedStatement ps = c.prepareStatement("select * from users where id = ?");
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		rs.next();
		
		User user = new User();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		
		rs.close();
		ps.close();
		c.close();
		
		return user;
		
	}
	
}
