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
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void add(User user) throws SQLException {
		//add에 해당하는 SQL생성 전략 객체 생성
		StatementStrategy st = new AddStatement(user);
		jdbcContextWithStatementStrategy(st);
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
		//statement생성 전략을 가진 객체 생성
		StatementStrategy strategy = new DeleteAllStatement();
		//전략을 인수로 전달하여 전략에 담긴 SQL문을 실행
		jdbcContextWithStatementStrategy(strategy);
	}
	
	//실행 SQL구문을 파라미터로 받아서 실행
	//반복되는 부분을 메소드로 분리한 결과
	public void jdbcContextWithStatementStrategy(StatementStrategy stmt) throws SQLException {
		
		Connection c = null;
		PreparedStatement ps = null;
		
		try {
			c = dataSource.getConnection();
			
			//PreparedStatement의 생성은 파라미터로 설정된 전략 객체에 위임한다.
			ps = stmt.makePreparedStatement(c);
			
			ps.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			//에러발생 유무에 관계없이, 사용한 리소스를 반환한다.
			//만들어진 순서의 역순으로 리소스를 반환한다.
			if(ps != null) {
				try {
					ps.close();	//리소스 반환 중 예외 발생 가능성이 있음
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
