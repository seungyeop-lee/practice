package springbook.user.dao;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
public class CountingDaoFactory {

	@Bean
	public UserDao userDao() {
		UserDao userDao = new UserDao();
		userDao.setDataSource(dataSource()); //기능이 추가된 DataSource를 인수로 사용
		return userDao;
	}

	@Bean
	public DataSource dataSource() {
		//DataSource 객체를 감싸서, 기능이 추가된 DataSource를 반환
		return new CountingDataSource(realDataSource());
	}
	
	@Bean
	public DataSource realDataSource() {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		
		dataSource.setDriverClass(com.mysql.cj.jdbc.Driver.class);
		dataSource.setUrl("jdbc:mysql://localhost:3306/springbook?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=Asia/Tokyo");
		dataSource.setUsername("spring");
		dataSource.setPassword("book");
		
		return dataSource;	//실제 DataSource를 반환
	}

}
