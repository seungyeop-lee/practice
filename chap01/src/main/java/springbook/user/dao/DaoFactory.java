package springbook.user.dao;

//UserDao 생성 책임을 맡는 Factory클래스
public class DaoFactory {
	
	//어떤 구상 클래스를 어떤 방식으로 만들어 준비하여 반환 할 지 결정
	public UserDao userDao() {
		return new UserDao(connectionMaker());
	}
	
	public AccountDao accountDao() {
		return new AccountDao(connectionMaker());
	}
	
	public MessageDao messageDao() {
		return new MessageDao(connectionMaker());
	}
	
	//공통적으로 사용되는 구상 클래스의 인스턴스를 반환 (중복을 제거하기 위한 분리)
	public ConnectionMaker connectionMaker() {
		return new DConnectionMaker();
	}
	
}
