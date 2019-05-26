package springbook.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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
		
		return this.jdbcTemplate.queryForObject(
				"select * from users where id = ?",	//SQL구문
				new Object[] {id},	// ? 에 넣어 줄 인자 값
				new RowMapper<User>() {	//결과 ResultSet의 1개 데이터(튜플)에 대한 매핑 전략
					public User mapRow(ResultSet rs, int rowNum) throws SQLException {
						User user = new User();
						user.setId(rs.getString("id"));
						user.setName(rs.getString("name"));
						user.setPassword(rs.getString("password"));
						return user;
					};
				}
		);
		
	}
	
	public void deleteAll() throws SQLException {
		//JdbcTemplate의 내부 콜백사용 메소드로 변경
		this.jdbcTemplate.update("delete from users");
	}
	
	public int getCount() throws SQLException {
		//내장 콜백을 이용하는 sql실행 메소드
		return this.jdbcTemplate.queryForInt("select count(*) from users");
	}
	
}
