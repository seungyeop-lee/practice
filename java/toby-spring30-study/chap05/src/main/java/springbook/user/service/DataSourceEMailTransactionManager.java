package springbook.user.service;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.support.DefaultTransactionStatus;

/**
 * DB와 메일 발송의 트렌젝션을 합쳐놓은 트렌젝션 매니저 
 *
 */
public class DataSourceEMailTransactionManager extends DataSourceTransactionManager {
	
	private static final long serialVersionUID = 1L;
	
	private MailSenderTransaction mailSender;
	
	public void setMailSender(MailSenderTransaction mailSender) {
		this.mailSender = mailSender;
	}

	@Override
	protected void doCommit(DefaultTransactionStatus status) {
		super.doCommit(status);
		mailSender.sendAll();
	}
	
	@Override
	protected void doRollback(DefaultTransactionStatus status) {
		super.doRollback(status);
		mailSender.cancelAll();
	}
	
}
