package springbook.user.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static springbook.user.service.UserService.MIN_LOGCOUNT_FOR_SILVER;
import static springbook.user.service.UserService.MIN_RECCOMEND_FOR_GOLD;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.test.annotation.DirtiesContext;
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
	
	@Autowired
	MailSender mailSender;
	
	@Autowired
	CommonUserLevelUpgradePolicy upgradePolicy;
	
	List<User> users;
	
	@Before
	public void setUp() {
		//경계값으로 테스트 데이터를 만듦 (테스트 신뢰성 향상)
		users = Arrays.asList(
					//상수를 사용함으로서 테스트 데이터의 목적이 분명해지는 효과가 생김
					new User("a", "n1", "p1", Level.BASIC, MIN_LOGCOUNT_FOR_SILVER-1, 0, "a@email.com"),
					new User("b", "n2", "p2", Level.BASIC, MIN_LOGCOUNT_FOR_SILVER, 0, "b@email.com"),
					new User("c", "n3", "p3", Level.SILVER, 60, MIN_RECCOMEND_FOR_GOLD-1, "c@email.com"),
					new User("d", "n4", "p4", Level.SILVER, 60, MIN_RECCOMEND_FOR_GOLD, "d@email.com"),
					new User("e", "n5", "p5", Level.GOLD, 100, Integer.MAX_VALUE, "e@email.com")
				);
	}
	
	@Test
	public void bean() {	//UserService빈 생성 유무 확인
		assertThat(this.userService, is(notNullValue()));
	}
	
	@Test
	@DirtiesContext
	public void upgradeLevels() throws Exception {
		
		//DB초기화 후 테스트 데이터 add
		userDao.deleteAll();
		for(User user : users) {
			userDao.add(user);
		}
		
		//메일 발송 목 객체 생성 및 수동 DI
		MockMailSender mockMailSender = new MockMailSender();
		upgradePolicy.setMailSender(mockMailSender);
		userService.setUserLevelUpgradePolicy(upgradePolicy);
		
		//레벨 상향
		userService.upgradeLevels();
		
		//상향된 레벨 적용확인
		checkLevelUpgraded(users.get(0), false);
		checkLevelUpgraded(users.get(1), true);
		checkLevelUpgraded(users.get(2), false);
		checkLevelUpgraded(users.get(3), true);
		checkLevelUpgraded(users.get(4), false);
		
		//목 객체의 정보를 통해 예상결과와 일치하는지 확인
		List<String> request = mockMailSender.getRequests();
		assertThat(request.size(), is(2));
		assertThat(request.get(0), is(users.get(1).getEmail()));
		assertThat(request.get(1), is(users.get(3).getEmail()));
		
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
	
	@Test
	@DirtiesContext	//스프링으로 부터 DI받은 빈의 내부 상태를 수정했다는 것을 알림, 다른 테스트 전에 사용된 빈의 초기화 진행
	public void upgradeAllOrNothing() throws Exception {
		//테스트용 레벨 상향 정책 준비
		TestUserLevelUpgradePolicy upgradePolicy = new TestUserLevelUpgradePolicy(users.get(3).getId());
		upgradePolicy.setUserDao(userDao);
		upgradePolicy.setMailSender(mailSender);
		
		//테스트용 레벨 상향 정책을 UserService에 수동DI
		userService.setUserLevelUpgradePolicy(upgradePolicy);
		
		//테스트를 위한 데이터 초기화
		userDao.deleteAll();
		for(User user : users) {
			userDao.add(user);
		}
		
		//레벨 상향 로직 수행, 중간에 예외 발생
		try {
			userService.upgradeLevels();
			fail("TestUserLevelUpgradePolicyException expected");
		} catch (TestUserLevelUpgradePolicyException e) {
		}
		
		//예외 발생 전 수행된 레벨 상향이 반영되지 않았음을 기대함
		checkLevelUpgraded(users.get(1), false);
	}
	
	//테스트용 레벨 상향 정책
	static class TestUserLevelUpgradePolicy extends CommonUserLevelUpgradePolicy {
		//예외가 발생하길 원하는 id
		private String id;
		
		private TestUserLevelUpgradePolicy(String id) {
			this.id = id;
		}
		
		@Override
		public void upgradeLevel(User user) {
			if(user.getId().equals(this.id)) {
				throw new TestUserLevelUpgradePolicyException();
			}
			super.upgradeLevel(user);
		}
		
	}
	
	@SuppressWarnings("serial")
	static class TestUserLevelUpgradePolicyException extends RuntimeException {}

}
