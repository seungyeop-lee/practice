package springbook.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import springbook.user.domain.Level;
import springbook.user.domain.User;

public class UserDaoJdbc implements UserDao {
	
	//재사용 가능하도록 RowMapper객체를 분리
	private RowMapper<User> userMapper = new RowMapper<User>() {
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getString("id"));
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
			user.setLevel(Level.valueOf(rs.getInt("level")));
			user.setLogin(rs.getInt("login"));
			user.setRecommend(rs.getInt("recommend"));
			return user;			
		}
	};
	
	//스프링이 제공하는 JDBC 코드용 기본 템플릿
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void add(User user) {
		//JdbcTemplate의 내부 콜백사용 메소드로 변경
		this.jdbcTemplate.update("insert into users(id, name, password, level, login, recommend) "
				+ "values(?, ?, ?, ?, ?, ?)",
				user.getId(), user.getName(), user.getPassword(), 
				user.getLevel().intValue(), user.getLogin(), user.getRecommend());
	}
	
	@Override
	public User get(String id) {
		
		return this.jdbcTemplate.queryForObject(
				"select * from users where id = ?",	//SQL구문
				new Object[] {id},	// ? 에 넣어 줄 인자 값
				this.userMapper
		);
		
	}
	
	@Override
	public void deleteAll() {
		//JdbcTemplate의 내부 콜백사용 메소드로 변경
		this.jdbcTemplate.update("delete from users");
	}
	
	@Override
	public int getCount() {
		//내장 콜백을 이용하는 sql실행 메소드
		return this.jdbcTemplate.queryForInt("select count(*) from users");
	}
	
	@Override
	public List<User> getAll() {
		return this.jdbcTemplate.query("select * from users order by id",
				this.userMapper);
	}
	
}
