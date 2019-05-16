package springbook.user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CountingDaoFactory {

	@Bean
	public UserDao userDao() {
		UserDao userDao = new UserDao();
		userDao.setConnectionMaker(connectionMaker()); //기능이 추가된 Connection생성 객체를 인수로 사용
		return userDao;
	}

	@Bean
	public ConnectionMaker connectionMaker() {
		//Connection생성 객체를 감싸서, 기능이 추가된 Connection생성 객체를 반환
		return new CountingConnectionMaker(realConnectionMaker());
	}
	
	@Bean
	public ConnectionMaker realConnectionMaker() {
		return new DConnectionMaker();	//실제 Connection생성 객체를 반환
	}

}
