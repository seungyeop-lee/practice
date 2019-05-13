package springbook.user.dao;

import java.sql.SQLException;

import springbook.user.domain.User;

public class UserDaoTestMain {
	//main메소드가 클라이언트로서 관계설정 책임이 부과된다.
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//UserDao에서 사용 할 ConnectionMaker 타입의 구상 클래스 생성
		ConnectionMaker connectionMaker = new DConnectionMaker();
		
		//dao의 변경없이 DB 접속 클래스의 교체가 가능하다.
//		ConnectionMaker connectionMaker = new NConnectionMaker();
		
		UserDao dao = new UserDao(connectionMaker);
		
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
