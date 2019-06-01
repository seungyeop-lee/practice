package springbook.user.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import springbook.user.dao.UserDao;
import springbook.user.domain.Level;
import springbook.user.domain.User;

public class UserService {
	
	//실버와 골드레벨의 최소 조건을 상수로 설정
	public static final int MIN_LOGCOUNT_FOR_SILVER = 50;
	public static final int MIN_RECCOMEND_FOR_GOLD = 30;
	
	UserDao userDao;
	UserLevelUpgradePolicy upgradePolicy;
	private DataSource dataSource;	//트랜잭션 적용을 위한 Connection객체 취득용 DataSource
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public void setUserLevelUpgradePolicy(UserLevelUpgradePolicy upgradePolicy) {
		this.upgradePolicy = upgradePolicy;
	}
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	//전체 유저를 대상으로 레벨 상향 대상자의 레벨 상향 처리
	public void upgradeLevels() throws Exception {
		//트랜잭션 매니저로 JDBC용 트랜잭션 매니저 생성
		PlatformTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
		//트랜잭션 정보 획득
		TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
		
		try {
			List<User> users = userDao.getAll();
			for(User user : users) {
				if(upgradePolicy.canUpgradeLevel(user)) {
					upgradePolicy.upgradeLevel(user);
				}
			}
			transactionManager.commit(status);
		} catch (Exception e) {
			transactionManager.rollback(status);
			throw e;
		}	//트랜잭션 동기화 작업 종료 및 정리가 필요없음
	}

	public void add(User user) {
		//레벨이 설정되어 있지않으면 BASIC으로 초기화
		if(user.getLevel() == null) user.setLevel(Level.BASIC);
		
		userDao.add(user);
	}
}
