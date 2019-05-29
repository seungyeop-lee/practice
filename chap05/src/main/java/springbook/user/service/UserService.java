package springbook.user.service;

import java.util.List;

import springbook.user.dao.UserDao;
import springbook.user.domain.Level;
import springbook.user.domain.User;

public class UserService {
	UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	//전체 유저를 대상으로 레벨 상향 대상자의 레벨 상향 처리
	public void upgradeLevels() {
		List<User> users = userDao.getAll();
		for(User user : users) {
			if(canUpgradeLevel(user)) {
				upgradeLevel(user);
			}
		}
	}

	//레벨 상향 대상유무 확인
	private boolean canUpgradeLevel(User user) {
		Level currentLevel = user.getLevel();
		
		//현재 레벨에 따른 조건 확인 및 결과 반환
		switch (currentLevel) {
		case BASIC:
			return user.getLogin() >= 50;
		case SILVER:
			return user.getRecommend() >= 30;
		case GOLD:
			return false;
		default:
			throw new IllegalArgumentException("Unknown Level: " + currentLevel);
		}
	}
	
	//레벨 상향 작업
	private void upgradeLevel(User user) {
		user.upgradeLevel();	//User객체 내부 데이터 수정 작업은 User객체에게 위임
		userDao.update(user);
	}

	public void add(User user) {
		//레벨이 설정되어 있지않으면 BASIC으로 초기화
		if(user.getLevel() == null) user.setLevel(Level.BASIC);
		
		userDao.add(user);
	}
}
