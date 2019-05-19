package springbook.user.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springbook.user.domain.User;

public class UserDaoTest {

	//IDE에서는 main메소드를 만들지 않아도 테스트가 가능!
	@Test
	public void addAndGet() throws SQLException {
		ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
		
		UserDao dao = context.getBean("userDao", UserDao.class);
		
		dao.deleteAll();	//테스트 전 DB의 데이터를 전부 삭제
		assertThat(dao.getCount(), is(0));	//dao.deleteAll()작동 확인
		
		User user = new User();
		user.setId("xbeast7");
		user.setName("이승엽");
		user.setPassword("single");
		
		dao.add(user);
		assertThat(dao.getCount(), is(1));	//dao.getCount()작동 확인
		
		User user2 = dao.get(user.getId());
		assertThat(user.getName(), is(user2.getName()));
		assertThat(user.getPassword(), is(user2.getPassword()));
		
	}
}
