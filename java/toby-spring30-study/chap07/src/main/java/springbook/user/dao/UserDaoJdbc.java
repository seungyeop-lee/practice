package springbook.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import springbook.user.domain.Level;
import springbook.user.domain.User;
import springbook.user.sqlservice.SqlService;

public class UserDaoJdbc implements UserDao {
	
	private SqlService sqlService;
	
	//SQL을 제공해주는 서비스객체를 주입받음
	//어디에서 SQL문이 만들어지는지에 대해 신경쓰지 않아도 된다.
	public void setSqlService(SqlService sqlService) {
		this.sqlService = sqlService;
	}
	
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
			user.setEmail(rs.getString("email"));
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
		this.jdbcTemplate.update(this.sqlService.getSql("userAdd"),
				user.getId(), user.getName(), user.getPassword(), 
				user.getLevel().intValue(), user.getLogin(), user.getRecommend(), user.getEmail());
	}
	
	@Override
	public User get(String id) {
		
		return this.jdbcTemplate.queryForObject(
				this.sqlService.getSql("userGet"),	//SQL구문
				new Object[] {id},	// ? 에 넣어 줄 인자 값
				this.userMapper
		);
		
	}
	
	@Override
	public void deleteAll() {
		//JdbcTemplate의 내부 콜백사용 메소드로 변경
		this.jdbcTemplate.update(this.sqlService.getSql("userDeleteAll"));
	}
	
	@Override
	public int getCount() {
		//내장 콜백을 이용하는 sql실행 메소드
		return this.jdbcTemplate.queryForInt(this.sqlService.getSql("userGetCount"));
	}
	
	@Override
	public List<User> getAll() {
		return this.jdbcTemplate.query(this.sqlService.getSql("userGetAll"),
				this.userMapper);
	}
	
	@Override
	public void update(User user) {
		this.jdbcTemplate.update(this.sqlService.getSql("userUpdate"),
				user.getName(), user.getPassword(), user.getLevel().intValue(), 
				user.getLogin(), user.getRecommend(), user.getEmail(), user.getId());
	}
	
}
