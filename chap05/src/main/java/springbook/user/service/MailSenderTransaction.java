package springbook.user.service;

/**
 * 메일 발송 트랜젝션 인터페이스 
 *
 */
public interface MailSenderTransaction {
	void sendAll();
	void cancelAll();
}
