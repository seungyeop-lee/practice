package springbook.user.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextTestMain {

	public static void main(String[] args) {
		
		DaoFactory factory = new DaoFactory();
		UserDao dao1 = factory.userDao();
		UserDao dao2 = factory.userDao();
		
		System.out.println(dao1);	//springbook.user.dao.UserDao@610455d6
		System.out.println(dao2);	//springbook.user.dao.UserDao@610455d6
		System.out.println("dao1 == dao2: " + (dao1 == dao2));	//true
		
		ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
		UserDao dao3 = context.getBean("userDao", UserDao.class);
		UserDao dao4 = context.getBean("userDao", UserDao.class);
		
		System.out.println(dao3);	//springbook.user.dao.UserDao@610455d6
		System.out.println(dao4);	//springbook.user.dao.UserDao@610455d6
		System.out.println("dao3 == dao4: " + (dao3 == dao4));	//true
		
	}
	
}
