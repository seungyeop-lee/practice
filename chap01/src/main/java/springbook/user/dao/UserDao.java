package springbook.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import springbook.user.domain.User;

public class UserDao {
	
	//초기 설정 후 바뀌지 않는 읽기전용 인스턴스 변수
	private ConnectionMaker connectionMaker;
	
	//매번 새로운 값으로 바뀌는 인스턴스 변수, 동시에 사용 시 심각한 문제 발생을 야기한다.
	private Connection c;
	private User user;
	
	public UserDao(ConnectionMaker connectionMaker) {
		//Connection객체를 반환하는 메소드를 제공하는 객체를 필드에 저장
		this.connectionMaker = connectionMaker;	//UserDao클래스에서 사용 할 ConnectionMaker를 전달 받아 사용 
	}
	
	public void add(User user) throws ClassNotFoundException, SQLException {
		
		c = connectionMaker.makeConnection();	//인터페이스를 사용하므로, 구상클래스가 변경되어도 영향을 받지 않음
		
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
		
		user = new User();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		
		rs.close();
		ps.close();
		c.close();
		
		return user;
		
	}
	
}
