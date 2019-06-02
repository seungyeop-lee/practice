package springbook.user.service;

import static springbook.user.service.UserService.MIN_LOGCOUNT_FOR_SILVER;
import static springbook.user.service.UserService.MIN_RECCOMEND_FOR_GOLD;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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
		sendUpgradeEMail(user);
	}

	//레벨 상향 안내메일 발송
	private void sendUpgradeEMail(User user) {
		Properties props = new Properties();
		props.put("mail.smtp.host", "mail.ksug.org");
		Session s = Session.getInstance(props);
		
		MimeMessage message = new MimeMessage(s);
		try {
			//발신인 설정
			message.setFrom(new InternetAddress("useradmin@ksug.org"));
			//수신인 설정
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));
			//제목
			message.setSubject("Upgrade 안내");
			//내용
			message.setText("사용자님의 등급이 " + user.getLevel().name() + "로 업그레이드되었습니다.");
			
			//전송
			Transport.send(message);
		} catch (AddressException e) {
			throw new RuntimeException(e);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
