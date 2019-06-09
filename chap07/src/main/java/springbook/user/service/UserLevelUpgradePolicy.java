package springbook.user.service;

import springbook.user.domain.User;

/**
 * 유저 레벨 상향 정책 인터페이스 
 *
 */
public interface UserLevelUpgradePolicy {
	boolean canUpgradeLevel(User user);
	void upgradeLevel(User user);
}
