package springbook.user.dao;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import springbook.user.domain.User;

public class UserDaoTestMain {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//@Configuration이 붙은 클래스를 설정 정보로 하는 어플리케이션 컨텍스트 생성
		ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);

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
