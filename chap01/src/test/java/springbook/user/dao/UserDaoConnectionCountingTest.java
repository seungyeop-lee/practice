package springbook.user.dao;

import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import springbook.user.domain.User;

public class UserDaoConnectionCountingTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//UserDao객체 로딩
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CountingDaoFactory.class);
		UserDao dao = context.getBean("userDao", UserDao.class);
		
		//User객체 생성 후 추가
		User user = new User();
		user.setId("xbeast7");
		user.setName("이승엽");
		user.setPassword("single");
		
		dao.add(user);
		System.out.println(user.getId() + " 등록 성공");
		
		//추가한 User정보를 획득 및 출력
		User user2 = dao.get(user.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		System.out.println(user2.getId() + " 조회 성공");
		
		//Connection객체 생성 메소드는 추가와 획득, 총 2번 실행되었으므로 2가 반환되어 출력
		CountingConnectionMaker ccm = context.getBean("connectionMaker", CountingConnectionMaker.class);
		System.out.println("Connection counter: " + ccm.getCounter());
	}
}
