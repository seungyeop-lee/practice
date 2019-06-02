package springbook.user.service;

import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class DummyMailSender implements MailSender, MailSenderTransaction {

	@Override
	public void send(SimpleMailMessage simpleMessage) throws MailException {
	}

	@Override
	public void send(SimpleMailMessage[] simpleMessages) throws MailException {
	}

	@Override
	public void sendAll() {
	}
	
	@Override
	public void cancelAll() {
	}
}
