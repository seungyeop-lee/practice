package springbook.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;

import springbook.user.domain.User;

public class UserDao {
	
	private DataSource dataSource;
	private JdbcContext jdbcContext;
	
	//DataSource 수정자 메소드가
	//의존객체(JdbcContext)의 생성, 필요 의존성 주입(DataSource)의 역할을 맡는다.
	public void setDataSource(DataSource dataSource) {
		//JdbcContext객체는 UserDao와 긴밀한 관계이므로 UserDao내부에서 생성!
		this.jdbcContext = new JdbcContext();
		
		this.jdbcContext.setDataSource(dataSource);
		
		this.dataSource = dataSource;
	}
	
	public void add(User user) throws SQLException {
		jdbcContext.executeSql("insert into users(id, name, password) values(?, ?, ?)",
				user.getId(), user.getName(), user.getPassword());
	}
	
	public User get(String id) throws SQLException {
		
		Connection c = dataSource.getConnection();

		PreparedStatement ps = c.prepareStatement("select * from users where id = ?");
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		User user = null;
		if(rs.next()) {
			user = new User();
			user.setId(rs.getString("id"));
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
		}
		
		rs.close();
		ps.close();
		c.close();
		
		//테스트코드를 성공시키기 위해 
		//데이터가 없을 경우 EmptyResultDataAccessException을 발생시킴
		if(user == null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		return user;
		
	}
	
	public void deleteAll() throws SQLException {
		jdbcContext.executeSql("delete from users");
	}
	
	public int getCount() throws SQLException {
		
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			c = dataSource.getConnection();
			ps = c.prepareStatement("select count(*) from users");
			
			rs = ps.executeQuery();
			rs.next();
			return rs.getInt(1);
		} catch (Exception e) {
			throw e;
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}
			if(c != null) {
				try {
					c.close();
				} catch (SQLException e) {
				}
			}
		}
		
	}
	
}
