package springbook.user.service;

import static springbook.user.service.UserService.MIN_LOGCOUNT_FOR_SILVER;
import static springbook.user.service.UserService.MIN_RECCOMEND_FOR_GOLD;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import springbook.user.dao.UserDao;
import springbook.user.domain.Level;
import springbook.user.domain.User;

/**
 * 평상시 유저 레벨 상향 정책 
 *
 */
public class CommonUserLevelUpgradePolicy implements UserLevelUpgradePolicy {
	
	UserDao userDao;
	private MailSender mailSender;	//스프링이 제공해주는 메일 서비스를 추상화시킨 인터페이스
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
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
		sendUpgradeEMail(user);
	}

	//레벨 상향 안내메일 발송
	private void sendUpgradeEMail(User user) {
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		//발신인 설정
		mailMessage.setTo(user.getEmail());
		//수신인 설정
		mailMessage.setFrom("useradmin@ksug.org");
		//제목
		mailMessage.setSubject("Upgrade 안내");
		//내용
		mailMessage.setText("사용자님의 등급이 " + user.getLevel().name() + "로 업그레이드되었습니다.");
		
		//전송
		mailSender.send(mailMessage);
		
	}

}
