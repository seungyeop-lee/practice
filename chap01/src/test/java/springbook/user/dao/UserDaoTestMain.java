package springbook.user.dao;

import java.sql.SQLException;

import springbook.user.domain.User;

public class UserDaoTestMain {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//DaoFactory에서 UserDao객체를 받으므로, 세부사항에 대해서는 알 수 없다.
		UserDao dao = new DaoFactory().userDao();
		
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
