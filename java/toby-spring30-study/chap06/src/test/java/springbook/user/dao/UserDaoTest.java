package springbook.user.dao;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;
import org.springframework.jdbc.support.SQLExceptionTranslator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import springbook.user.domain.Level;
import springbook.user.domain.User;

//스프링의 요소를 테스트에서 사용 가능하게 함
@RunWith(SpringJUnit4ClassRunner.class)
//구성xml파일 위치 설정, 다른 테스트 클래스에 동일한 설정이 있을경우 동일한 애플리케이션 컨텍스트를 공유
@ContextConfiguration(locations="/test-applicationContext.xml")
public class UserDaoTest {

	//픽스처(테스트를 수행하는 데 필요한 정보나 오브젝트)
	@Autowired
	private UserDao dao;
	
	@Autowired
	private DataSource dataSource;	//예외 전환 객체 생성에 필요
	
	private User user1;
	private User user2;
	private User user3;
	
	//각 테스트를 실행하기 전, 테스트에 필요한 환경 구축
	@Before
	public void setUp() {
		user1 = new User("bbbb", "name1111", "ps1111", Level.BASIC, 1, 0, "bbbb@email.com");
		user2 = new User("cccc", "name2222", "ps2222", Level.SILVER, 55, 10, "cccc@email.com");
		user3 = new User("aaaa", "name3333", "ps3333", Level.GOLD, 100, 40, "aaaa@email.com");
	}
	
	//IDE에서는 main메소드를 만들지 않아도 테스트가 가능!
	@Test
	public void addAndGet() {
		
		dao.deleteAll();	//테스트 전 DB의 데이터를 전부 삭제
		assertThat(dao.getCount(), is(0));	//dao.deleteAll()작동 확인
		
		dao.add(user1);
		dao.add(user2);
		assertThat(dao.getCount(), is(2));	//dao.getCount()작동 확인
		
		//1개만 add후 get하였을 경우 제대로 값을 가져오는지에 대한 검증이 불충분
		//2개를 추가 후 2개를 각각 get하는 것으로 테스트의 신뢰성 향상
		User userget1 = dao.get(user1.getId());
		checkSameUser(userget1, user1);
		
		User userget2 = dao.get(user2.getId());
		checkSameUser(userget2, user2);
		
	}
	
	@Test
	public void count() {
		
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
	//JdbcTemplate의 queryForObject메소드 등에서 기본적으로 사용하는 예외
	@Test(expected = EmptyResultDataAccessException.class)
	public void getUserFailure() {
		
		//테이블을 비운 후, 비워진 것을 확인
		dao.deleteAll();
		assertThat(dao.getCount(), is(0));
		
		//존재하지 않는 id를 인수로하여 get메소드를 호출
		dao.get("unknown_id");
		
	}
	
	@Test
	public void getAll() {
		
		dao.deleteAll();
		
		//데이터가 없는 경우에 대한 검증 코드
		List<User> users0 = dao.getAll();
		assertThat(users0.size(), is(0));
		
		dao.add(user1);	//Id: bbbb
		List<User> users1 = dao.getAll();
		assertThat(users1.size(), is(1));
		checkSameUser(user1, users1.get(0));
		
		dao.add(user2);	//Id: cccc
		List<User> users2 = dao.getAll();
		assertThat(users2.size(), is(2));
		checkSameUser(user1, users2.get(0));
		checkSameUser(user2, users2.get(1));
		
		dao.add(user3);	//Id: aaaa
		List<User> users3 = dao.getAll();
		assertThat(users3.size(), is(3));
		checkSameUser(user3, users3.get(0));
		checkSameUser(user1, users3.get(1));
		checkSameUser(user2, users3.get(2));
		
	}
	
	@Test(expected = DuplicateKeyException.class)	//key가 겹쳤을 경우 발생하는 예외에 대한 테스트
	public void duplicateKey() {
		dao.deleteAll();
		
		dao.add(user1);
		dao.add(user1);
	}
	
	@Test
	public void sqlExceptionTranslate() {	//예외 전환 테스트
		dao.deleteAll();
		
		try {
			dao.add(user1);
			dao.add(user1);
		} catch (DuplicateKeyException e) {
			SQLException sqlEx = (SQLException) e.getRootCause();	//처음 발생한 예외를 가져옴
			SQLExceptionTranslator set = new SQLErrorCodeSQLExceptionTranslator(this.dataSource);	//예외 전환을 위한 객체 생성
			assertThat(set.translate(null, null, sqlEx), is(instanceOf(DuplicateKeyException.class)));
		}
	}
	
	@Test
	public void update() {
		dao.deleteAll();
		
		dao.add(user1);	//수정 할 사용자
		dao.add(user2);	//수정하지 않을 사용자(where조건 확인용)
		
		//user1은 픽스처이지만 매 테스트마다 초기화되므로 수정해도 무관
		user1.setName("name4444");
		user1.setPassword("ps4444");
		user1.setLevel(Level.GOLD);
		user1.setLogin(1000);
		user1.setRecommend(999);
		user1.setEmail("unknown@email.com");
		
		dao.update(user1);
		
		User user1update = dao.get(user1.getId());
		checkSameUser(user1, user1update);
		User user2update = dao.get(user2.getId());
		checkSameUser(user2, user2update);
	}
	
	private void checkSameUser(User user1, User user2) {
		assertThat(user1.getId(), is(user2.getId()));
		assertThat(user1.getName(), is(user2.getName()));
		assertThat(user1.getPassword(), is(user2.getPassword()));
		assertThat(user1.getLevel(), is(user2.getLevel()));
		assertThat(user1.getLogin(), is(user2.getLogin()));
		assertThat(user1.getRecommend(), is(user2.getRecommend()));
		assertThat(user1.getEmail(), is(user2.getEmail()));
	}
}
