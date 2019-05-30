package springbook.user.service;

import static springbook.user.service.UserService.MIN_LOGCOUNT_FOR_SILVER;
import static springbook.user.service.UserService.MIN_RECCOMEND_FOR_GOLD;

import springbook.user.dao.UserDao;
import springbook.user.domain.Level;
import springbook.user.domain.User;

/**
 * 평상시 유저 레벨 상향 정책 
 *
 */
public class CommonUserLevelUpgradePolicy implements UserLevelUpgradePolicy {
	
	UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	//레벨 상향 대상유무 확인
	@Override
	public boolean canUpgradeLevel(User user) {
		Level currentLevel = user.getLevel();
		
		//현재 레벨에 따른 조건 확인 및 결과 반환
		switch (currentLevel) {
		case BASIC:
			return user.getLogin() >= MIN_LOGCOUNT_FOR_SILVER;
		case SILVER:
			return user.getRecommend() >= MIN_RECCOMEND_FOR_GOLD;
		case GOLD:
			return false;
		default:
			throw new IllegalArgumentException("Unknown Level: " + currentLevel);
		}
	}
	
	//레벨 상향 작업
	@Override
	public void upgradeLevel(User user) {
		user.upgradeLevel();	//User객체 내부 데이터 수정 작업은 User객체에게 위임
		userDao.update(user);
	}

}
