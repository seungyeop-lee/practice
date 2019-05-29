package springbook.user.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import springbook.user.dao.UserDao;
import springbook.user.domain.Level;
import springbook.user.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/test-applicationContext.xml")
public class UserServiceTest {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserDao userDao;
	
	List<User> users;
	
	@Before
	public void setUp() {
		//경계값으로 테스트 데이터를 만듦 (테스트 신뢰성 향상)
		users = Arrays.asList(
					new User("a", "n1", "p1", Level.BASIC, 49, 0),
					new User("b", "n2", "p2", Level.BASIC, 50, 0),
					new User("c", "n3", "p3", Level.SILVER, 60, 29),
					new User("d", "n4", "p4", Level.SILVER, 60, 30),
					new User("e", "n5", "p5", Level.GOLD, 100, 100)
				);
	}
	
	@Test
	public void bean() {	//UserService빈 생성 유무 확인
		assertThat(this.userService, is(notNullValue()));
	}
	
	@Test
	public void upgradeLevels() {
		
		//DB초기화 후 테스트 데이터 add
		userDao.deleteAll();
		for(User user : users) {
			userDao.add(user);
		}
		
		//레벨 상향
		userService.upgradeLevels();
		
		//상향된 레벨 적용확인
		checkLevel(users.get(0), Level.BASIC);
		checkLevel(users.get(1), Level.SILVER);
		checkLevel(users.get(2), Level.SILVER);
		checkLevel(users.get(3), Level.GOLD);
		checkLevel(users.get(4), Level.GOLD);
	}

	private void checkLevel(User user, Level expectedLevel) {
		User userUpdate = userDao.get(user.getId());
		assertThat(userUpdate.getLevel(), is(expectedLevel));
	}
}
