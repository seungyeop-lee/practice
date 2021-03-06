package springbook.user.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import springbook.user.domain.User;

public class UserDaoTest {

	//픽스처(테스트를 수행하는 데 필요한 정보나 오브젝트)
	private UserDao dao;
	private User user1;
	private User user2;
	private User user3;
	
	//각 테스트를 실행하기 전, 테스트에 필요한 환경 구축
	@Before
	public void setUp() {
		//UserDao객체를 직접 생성 후 DI
		dao = new UserDao();
		DataSource dataSource = new SingleConnectionDataSource(
				"jdbc:mysql://localhost:3306/testdb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=Asia/Tokyo",
				"spring", "book", true);
		dao.setDataSource(dataSource);
		
		user1 = new User("id1111", "name1111", "ps1111");
		user2 = new User("id2222", "name2222", "ps2222");
		user3 = new User("id3333", "name3333", "ps3333");
	}
	
	//IDE에서는 main메소드를 만들지 않아도 테스트가 가능!
	@Test
	public void addAndGet() throws SQLException {
		
		dao.deleteAll();	//테스트 전 DB의 데이터를 전부 삭제
		assertThat(dao.getCount(), is(0));	//dao.deleteAll()작동 확인
		
		dao.add(user1);
		dao.add(user2);
		assertThat(dao.getCount(), is(2));	//dao.getCount()작동 확인
		
		//1개만 add후 get하였을 경우 제대로 값을 가져오는지에 대한 검증이 불충분
		//2개를 추가 후 2개를 각각 get하는 것으로 테스트의 신뢰성 향상
		User userget1 = dao.get(user1.getId());
		assertThat(user1.getName(), is(userget1.getName()));
		assertThat(user1.getPassword(), is(userget1.getPassword()));
		
		User userget2 = dao.get(user2.getId());
		assertThat(user2.getName(), is(userget2.getName()));
		assertThat(user2.getPassword(), is(userget2.getPassword()));
		
	}
	
	@Test
	public void count() throws SQLException {
		
		//데이터를 1개 추가 할 때마다 count가 1씩 증가 하는 것을 확인
		
		dao.deleteAll();
		assertThat(dao.getCount(), is(0));
		
		dao.add(user1);
		assertThat(dao.getCount(), is(1));
		
		dao.add(user2);
		assertThat(dao.getCount(), is(2));
		
		dao.add(user3);
		assertThat(dao.getCount(), is(3));
		
	}
	
	//expected에 설정된 예외가 발생해야 테스트 성공!
	@Test(expected = EmptyResultDataAccessException.class)
	public void getUserFailure() throws SQLException {
		
		//테이블을 비운 후, 비워진 것을 확인
		dao.deleteAll();
		assertThat(dao.getCount(), is(0));
		
		//존재하지 않는 id를 인수로하여 get메소드를 호출
		dao.get("unknown_id");
		
	}
}
