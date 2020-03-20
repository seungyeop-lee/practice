package org.zerock.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.persistence.SampleMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class SampleMapperTest {

	@Inject
	private SampleMapper mapper;
	
	@Test
	public void testTime() {
		
		System.out.println(mapper.getClass().getName());	//com.sun.proxy.$Proxy14
		
		System.out.println(mapper.getTime());	//2019-05-08 22:28:13
		
	}
	
	@Test
	public void testMail() {
		
		String email = mapper.getEmail("user10", "user10");
		
		System.out.println(email);	//user10@zerock.com
		
	}
	
	@Test
	public void testUserName() {
		
		String name = mapper.getUserName("user10", "user10");
		
		System.out.println(name);	//Quick Silver
	}
	
	@Test
	public void testUserName2() {
		
		String name = mapper.search("id", "user01");
		
		System.out.println(name);	//CAPTAIN
		
	}
}
