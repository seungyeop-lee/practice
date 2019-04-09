package org.zerock.web;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.MemberVO;
import org.zerock.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MemberDAOTest {
	
	@Inject
	private MemberDAO dao;
	
	@Inject
	private DataSource dataSource;
	
	//테스크용 픽스쳐
	private MemberVO vo;
	
	@Before
	public void setUp() {
		//데이터 베이스의 테스트 데이터 삭제
		try(Connection c = dataSource.getConnection();
			PreparedStatement ps = c.prepareStatement("delete from tbl_member");
			) {
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		vo = new MemberVO();
		vo.setUserid("user00");
		vo.setUserpw("user00");
		vo.setUsername("USER00");
		vo.setEmail("user00@aaa.com");
	}
	
	@Test
	public void testTime() throws Exception {
		
		System.out.println(dao.getTime());
		
	}
	
	@Test
	public void testInsertMember() throws Exception {
		
		dao.insertMember(vo);
		
	}
	
	@Test
	public void testReadMember() throws Exception {
		
		dao.insertMember(vo);
		
		MemberVO voFromTbl = dao.readMember("user00");
		checkEqual(vo, voFromTbl);
		
	}
	
	@Test
	public void testReadWithPW() throws Exception {
		
		dao.insertMember(vo);
		
		MemberVO voFromTbl = dao.readWithPW(vo.getUserid(), vo.getUserpw());
		checkEqual(vo, voFromTbl);
		
	}
	
	private void checkEqual(MemberVO vo1, MemberVO vo2) {
		assertThat(vo1.getUserid(), is(vo2.getUserid()));
		assertThat(vo1.getUserpw(), is(vo2.getUserpw()));
		assertThat(vo1.getUsername(), is(vo2.getUsername()));
		assertThat(vo1.getEmail(), is(vo2.getEmail()));
	}
}
