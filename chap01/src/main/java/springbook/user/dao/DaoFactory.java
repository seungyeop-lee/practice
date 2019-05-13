package springbook.user.dao;

//UserDao 생성 책임을 맡는 Factory클래스
public class DaoFactory {
	
	//어떤 구상 클래스를 어떤 방식으로 만들어 준비하여 반환 할 지 결정
	public UserDao userDao() {
		
		ConnectionMaker connectionMaker = new DConnectionMaker();
		UserDao userDao = new UserDao(connectionMaker);
		
		return userDao;
		
	}
	
}
