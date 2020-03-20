package springbook.user.dao;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration	//애플리케이션 컨텍스트 or 빈 팩토리가 사용 할 설정정보를 나타냄
public class DaoFactory {
	
	@Bean	//UserDao타입 인스턴스를 생성 해 주는 IoC용 메소드임을 나타냄
	@Lazy	//컨텍스트 어플리케이션 생성 시 이 메소드에 해당하는 빈 초기화는 실제 불려지기 전에 수행 하지 않게한다.
//	@Bean("userDao")	//Bean으로 등록 시 @Bean의 value로 이름을 정할 수 있다.
	public UserDao userDao() {	//@Bean의 value를 설정하지 않으면 메소드명이 Bean의 이름이 된다.
		UserDao userDao = new UserDao();
		userDao.setDataSource(dataSource());
		return userDao; 
	}
	
	@Bean
	public DataSource dataSource() {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		
		dataSource.setDriverClass(com.mysql.cj.jdbc.Driver.class);
		dataSource.setUrl("jdbc:mysql://localhost:3306/springbook?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=Asia/Tokyo");
		dataSource.setUsername("spring");
		dataSource.setPassword("book");
		
		return dataSource;
	}
	
}
