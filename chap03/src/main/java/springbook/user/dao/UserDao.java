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
		this.jdbcContext.workWithStatementStrategy(new StatementStrategy() {	//인수로 익명 객체 생성
			@Override
			public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
				PreparedStatement ps = c.prepareStatement("insert into users(id, name, password) values(?, ?, ?)");
				
				//익명 객체 내부에서도 외부 메소드의 지역 변수 접근 가능
				ps.setString(1, user.getId());
				ps.setString(2, user.getName());
				ps.setString(3, user.getPassword());
				
				return ps;
			}
		});
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
		executeSql("delete from users");
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
	
	//변하지 않는 콜백 클래스 정의 및 객체 생성부분을 분리
	private void executeSql(String query) throws SQLException {
		this.jdbcContext.workWithStatementStrategy(new StatementStrategy() {
			@Override
			public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
				return c.prepareStatement(query);
			}
		});
	}
	
}
