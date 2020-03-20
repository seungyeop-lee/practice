package springbook.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.SimpleDriverDataSource;

//데코레이션 패턴을 사용한 부가기능 추가
public class CountingDataSource extends SimpleDriverDataSource {

	int counter = 0;
	private DataSource realDataSource;
	
	//실제 DataSource를 주입 받음
	public CountingDataSource(DataSource realDataSource) {
		this.realDataSource = realDataSource;
	}
	
	@Override
	public Connection getConnection() throws SQLException {
		counter++;	//Connection을 생성하기 전 호출 횟수를 카운팅
		return realDataSource.getConnection();
	}
	
	//지금까지의 Connection 생성 횟수를 반환
	public int getCounter() {
		return counter;
	}

}
