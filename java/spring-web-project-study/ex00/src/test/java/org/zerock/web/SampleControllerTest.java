package org.zerock.web;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)	//Spring요소의 사용이 가능한 JUnit러너 클래스 설정
@WebAppConfiguration	//테스트에서 WebApplicationContext의 사용을 가능하게 해줌
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/servlet-context.xml"})
public class SampleControllerTest {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleControllerTest.class);
	
	@Inject
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;	//브라우저의 요청과 응답의 생성이 가능한 객체 
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		logger.info("setup......");
	}
	
	@Test
	public void testDoA() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/doA"));
	}
}
