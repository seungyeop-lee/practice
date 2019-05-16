package springbook.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

//데코레이션 패턴을 사용한 부가기능 추가
public class CountingConnectionMaker implements ConnectionMaker {

	int counter = 0;
	private ConnectionMaker realConnectionMaker;
	
	//실제 ConnectionMaker를 주입 받음
	public CountingConnectionMaker(ConnectionMaker realConnectionMaker) {
		this.realConnectionMaker = realConnectionMaker;
	}
	
	@Override
	public Connection makeConnection() throws ClassNotFoundException, SQLException {
		counter++;	//Connection을 생성하기 전 호출 횟수를 카운팅
		return realConnectionMaker.makeConnection();
	}
	
	//지금까지의 Connection 생성 횟수를 반환
	public int getCounter() {
		return counter;
	}

}
