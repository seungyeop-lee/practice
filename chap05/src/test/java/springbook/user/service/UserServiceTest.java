package springbook.user.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static springbook.user.service.UserService.MIN_LOGCOUNT_FOR_SILVER;
import static springbook.user.service.UserService.MIN_RECCOMEND_FOR_GOLD;

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
					//상수를 사용함으로서 테스트 데이터의 목적이 분명해지는 효과가 생김
					new User("a", "n1", "p1", Level.BASIC, MIN_LOGCOUNT_FOR_SILVER-1, 0),
					new User("b", "n2", "p2", Level.BASIC, MIN_LOGCOUNT_FOR_SILVER, 0),
					new User("c", "n3", "p3", Level.SILVER, 60, MIN_RECCOMEND_FOR_GOLD-1),
					new User("d", "n4", "p4", Level.SILVER, 60, MIN_RECCOMEND_FOR_GOLD),
					new User("e", "n5", "p5", Level.GOLD, 100, Integer.MAX_VALUE)
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
		checkLevelUpgraded(users.get(0), false);
		checkLevelUpgraded(users.get(1), true);
		checkLevelUpgraded(users.get(2), false);
		checkLevelUpgraded(users.get(3), true);
		checkLevelUpgraded(users.get(4), false);
	}

	//해당유저가 레벨 상향 대상이라면 레벨이 상향되었는지 확인
	//레벨 상향으로 인해 어떤 레벨이 되는가는 객체에 위임하여 확인 
	private void checkLevelUpgraded(User user, boolean upgraded) {
		User userUpdate = userDao.get(user.getId());
		if(upgraded) {
			assertThat(userUpdate.getLevel(), is(user.getLevel().nextLevel()));
		} else {
			assertThat(userUpdate.getLevel(), is(user.getLevel()));
		}
	}
	
	@Test
	public void add() {
		userDao.deleteAll();
		
		User userWithLevel = users.get(4);	//레벨이 설정되어 있는 유저
		User userWithoutLevel = users.get(0);	//레벨이 설정되어 있지않은 유저
		userWithoutLevel.setLevel(null);
		
		userService.add(userWithLevel);
		userService.add(userWithoutLevel);
		
		User userWithLevelRead = userDao.get(userWithLevel.getId());
		User userWithoutLevelRead = userDao.get(userWithoutLevel.getId());
		
		//레벨이 설정되어 있을경우, 변경 없음
		assertThat(userWithLevelRead.getLevel(), is(userWithLevel.getLevel()));
		//레벨이 설정되어 있지 않을 경우, BASIC으로 초기화
		assertThat(userWithoutLevelRead.getLevel(), is(Level.BASIC));
	}

}
