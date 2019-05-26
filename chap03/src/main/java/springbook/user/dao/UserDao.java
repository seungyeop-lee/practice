package springbook.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;

import springbook.user.domain.User;

public class UserDao {
	
	private DataSource dataSource;
	private JdbcContext jdbcContext;
	//스프링이 제공하는 JDBC 코드용 기본 템플릿
	private JdbcTemplate jdbcTemplate;
	
	//DataSource 수정자 메소드가
	//의존객체(JdbcContext)의 생성, 필요 의존성 주입(DataSource)의 역할을 맡는다.
	public void setDataSource(DataSource dataSource) {
		//JdbcContext객체는 UserDao와 긴밀한 관계이므로 UserDao내부에서 생성!
		this.jdbcContext = new JdbcContext();
		
		this.jdbcContext.setDataSource(dataSource);
		
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		
		this.dataSource = dataSource;
	}
	
	public void add(User user) throws SQLException {
		//JdbcTemplate의 내부 콜백사용 메소드로 변경
		this.jdbcTemplate.update("insert into users(id, name, password) values(?, ?, ?)",
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
		//JdbcTemplate의 내부 콜백사용 메소드로 변경
		this.jdbcTemplate.update("delete from users");
	}
	
	public int getCount() throws SQLException {
		//PreparedStatementCreator는 prepareStatement 객체 생성 전략을 담은 콜백 객체
		return this.jdbcTemplate.query(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				return con.prepareStatement("select count(*) from users");
			}
		//ResultSetExtractor는 ResultSet으로부터의 값 추출 전략을 담은 콜백 객체
		}, new ResultSetExtractor<Integer>() {
			@Override
			public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
				rs.next();
				return rs.getInt(1);
			}
		});
		
		
		/**
		 * 람다식을 이용하면 더 간략하게 쓸 수 있다.
		 * Spring 3.0.7에서는 ArrayIndexOutOfBoundsException발생으로 사용 불가
		 * Spring 5.1.7에서 정상 작동 확인 완료
		 */
//		PreparedStatementCreator psc = con -> con.prepareStatement("select count(*) from users");
//		ResultSetExtractor<Integer> rse = rs -> {
//			rs.next();
//			return rs.getInt(1);
//		};
//		return this.jdbcTemplate.query(psc, rse);
		
	}
	
}
