package org.zerock;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class App2ApplicationTests {

	@Autowired
	private DataSource ds;
	
	@Autowired
	private SqlSessionFactory sqlSession;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testConnection() throws Exception {
		
		System.out.println(ds);
		
		Connection con = ds.getConnection();
		
		System.out.println(con);
		
		con.close();
		
	}
	
	@Test
	public void testSqlSession() throws Exception {
		System.out.println(sqlSession);
	}

}
