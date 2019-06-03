package springbook.user.service;

import java.util.List;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import springbook.user.dao.UserDao;
import springbook.user.domain.Level;
import springbook.user.domain.User;

public class UserServiceImpl implements UserService {
	
	//실버와 골드레벨의 최소 조건을 상수로 설정
	public static final int MIN_LOGCOUNT_FOR_SILVER = 50;
	public static final int MIN_RECCOMEND_FOR_GOLD = 30;
	
	UserDao userDao;
	UserLevelUpgradePolicy upgradePolicy;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public void setUserLevelUpgradePolicy(UserLevelUpgradePolicy upgradePolicy) {
		this.upgradePolicy = upgradePolicy;
	}
	
	//전체 유저를 대상으로 레벨 상향 대상자의 레벨 상향 처리
	@Override
	public void upgradeLevels() {
		List<User> users = userDao.getAll();
		for(User user : users) {
			if(upgradePolicy.canUpgradeLevel(user)) {
				upgradePolicy.upgradeLevel(user);
			}
		}
	}
	
	@Override
	public void add(User user) {
		//레벨이 설정되어 있지않으면 BASIC으로 초기화
		if(user.getLevel() == null) user.setLevel(Level.BASIC);
		
		userDao.add(user);
	}
}
