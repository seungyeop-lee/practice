package springbook.user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration	//애플리케이션 컨텍스트 or 빈 팩토리가 사용 할 설정정보를 나타냄
public class DaoFactory {
	
	@Bean	//UserDao타입 인스턴스를 생성 해 주는 IoC용 메소드임을 나타냄
//	@Bean("userDao")	//Bean으로 등록 시 @Bean의 value로 이름을 정할 수 있다.
	public UserDao userDao() {	//@Bean의 value를 설정하지 않으면 메소드명이 Bean의 이름이 된다.
		return UserDao.getInstance();	//싱글톤패턴을 적용하였으므로 static method로 인스턴스를 획득
	}
	
	public AccountDao accountDao() {
		return new AccountDao(connectionMaker());
	}
	
	public MessageDao messageDao() {
		return new MessageDao(connectionMaker());
	}
	
	@Bean	//ConnectionMaker타입 인스턴스를 생성 해 주는 IoC용 메소드임을 나타냄
	public ConnectionMaker connectionMaker() {
		return new DConnectionMaker();
	}
	
}
