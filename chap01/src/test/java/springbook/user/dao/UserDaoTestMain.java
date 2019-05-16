package springbook.user.dao;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import springbook.user.domain.User;

public class UserDaoTestMain {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//문자열에 위치한 xml을 설정파일로 하는 ApplicationContext객체를 생성
		//xml파일의 위치 문자열 맨 처음에 /가 붙어있지 않아도, 항상 루트에서부터 시작하는 클래스패스를 나타냄
		ApplicationContext context = new GenericXmlApplicationContext("/applicationContext.xml");

		//userDao라는 이름을 가진 IoC용 메소드의 반환 값을 UserDao타입으로 형변환 한 인스턴스 
		UserDao dao = context.getBean("userDao", UserDao.class);
		
		User user = new User();
		user.setId("xbeast7");
		user.setName("이승엽");
		user.setPassword("single");
		
		dao.add(user);
		System.out.println(user.getId() + " 등록 성공");
		
		User user2 = dao.get(user.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		System.out.println(user2.getId() + " 조회 성공");
	}
}
