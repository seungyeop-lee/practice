package springbook.user.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import springbook.user.domain.Level;
import springbook.user.domain.User;

/**
 * User클래스에 추가된 메소드의 테스트 
 *
 */
public class UserTest {
	User user;
	
	@Before
	public void setUp() {
		user = new User();
	}
	
	@Test
	public void upgradeLevel() {	//정상 테스트
		Level[] levels = Level.values();
		for(Level level : levels) {
			if(level.nextLevel() == null) {
				continue;
			}
			user.setLevel(level);
			user.upgradeLevel();
			assertThat(user.getLevel(), is(level.nextLevel()));
		}
	}
	
	@Test(expected = IllegalStateException.class)
	public void cannotUpgradeLevel() {	//예외 발생 테스트
		Level[] levels = Level.values();
		for(Level level : levels) {
			if(level.nextLevel() != null) {
				continue;
			}
			user.setLevel(level);
			user.upgradeLevel();
		}
	}
}
